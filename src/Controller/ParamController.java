/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * FXML Controller class
 *
 * @author Amal Ben Boussaha
 */
public class ParamController implements Initializable {

    @FXML
    private JFXButton aj,sup,mod;@FXML
    private TableView<Actitvitefx> table_act;

    @FXML
    private TableColumn<Actitvitefx, Number> id_act;

    @FXML
    private TableColumn<Actitvitefx, String> cls_act;

    @FXML
    private TableColumn<Actitvitefx, String> mat_act;

    @FXML
    private TableColumn<Actitvitefx, String> ens_act;

    @FXML
    private TableColumn<Actitvitefx, String> c_act;
     @FXML
    private JFXTextField schema;
 
    @FXML
    void importer(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter( "Fichier Microsoft Excel","*.csv"));
        File f = fc.showOpenDialog(null);
        if(f != null)
        {
            schema.setText(f.getAbsolutePath());
        }
    }
    @FXML
    void importation(ActionEvent event) throws IOException {
        connection = handler.getConnection();
      

        try
        {   
            String line;
            int i =autoincrtID();        
        
        
            BufferedReader br = new BufferedReader(new FileReader(schema.getText()));
            while((line = br.readLine())!=null){
                i+=1; 
                String []value =line.split(",");
                for(String item : value){
                    System.out.print(item);
                    System.out.println(i);
         }
       
          String sql="INSERT INTO actitvite(id,apprenant,matere,prof,duree) values ("+i+",'"+value[0]+"',"+value[1]+","+value[2]+","+value[3]+")";
            pst = connection.prepareStatement(sql);
                   pst.execute();
        }
        }
         catch(SQLException |FileNotFoundException e)
        {  
           e.printStackTrace();
        }
    }

    @FXML
    private TableColumn<Actitvitefx, String> dr_act;
    private Connection connection;
    private dbconnect handler;
    private PreparedStatement pst;  
    EntityManager em;  
    ObservableList<Actitvitefx> data;
    @FXML
    void supprimer(ActionEvent event) {
        int row =table_act.getSelectionModel().getSelectedIndex();
        if(row <0)return;
        Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
        alert.setTitle("Conformation de suppression");
        alert.setHeaderText(null);
        alert.setContentText("Vous etes sure?");
        Optional <ButtonType>action = alert.showAndWait();
        
        if(action.get()==ButtonType.OK){
            
        
        em = ParamController.emf.createEntityManager();
        Query q =em.createQuery("SELECT a FROM Actitvite a WHERE a.id = :id");
        q.setParameter("id", data.get(row).getId());
        Actitvite a = (Actitvite) q.getSingleResult();
        em.getTransaction().begin();
        em.remove(a);
        em.getTransaction().commit();
        em.close();
        actualiser();

        }
    }

    @FXML
    void ajouter(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/ActiviteForm.fxml"));
        AnchorPane  mainPane = (AnchorPane)loader.load();
        Scene scene = new Scene(mainPane);
        stage.setTitle("Ajouter Nouvelle Activite");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        ActiviteFormController ctrl = loader.getController();
        stage.showAndWait();
        actualiser();
    }

    @FXML
    void modifier(ActionEvent event) throws IOException {
        int row =table_act.getSelectionModel().getSelectedIndex();
        if(row <0)return; 
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/ActiviteForm.fxml"));
        AnchorPane  mainPane = (AnchorPane)loader.load();
        Scene scene = new Scene(mainPane);
        stage.setTitle("Modifier Activite");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        ActiviteFormController ctrl = loader.getController();
        ctrl.setactivite(data.get(row).getId());
        stage.showAndWait();
        actualiser();
    }
    public static EntityManagerFactory emf;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    handler = new dbconnect();
    emf=Persistence.createEntityManagerFactory("ESENPU");
         em = ParamController.emf.createEntityManager();
        
    }    
 @FXML
    void afficher(ActionEvent event) {
        actualiser();
    }

    private void actualiser() {
        emf=Persistence.createEntityManagerFactory("ESENPU");
         em = ParamController.emf.createEntityManager();
        
         em = ParamController.emf.createEntityManager();
        table_act.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
                
        List<Actitvite>lst = em.createQuery("SELECT a FROM Actitvite a").getResultList();
        
        data=FXCollections.observableArrayList();
        for(Actitvite lste:lst){
            
        data.add(new Actitvitefx(lste.getId(),lste.getApprenant(),lste.getMatere(),lste.getProf(),lste.getDuree()));
        }
        table_act.setItems(data);
        id_act.setCellValueFactory(cell->cell.getValue().getIdProperty());
        cls_act.setCellValueFactory(cell->cell.getValue().getApprenantProperty());
        mat_act.setCellValueFactory(cell->cell.getValue().getMatereProperty());
        ens_act.setCellValueFactory(cell->cell.getValue().getProfProperty());
        c_act.setCellValueFactory(cell->cell.getValue().getCodeProperty());
        //dr_act.setCellValueFactory(cell->cell.getValue().getDureeProperty());
    
    }
      
 private int    autoincrtID()
 { int id = 1;
        try {
            pst = connection.prepareStatement("SELECT max(id) FROM actitvite");
            ResultSet rs = pst.executeQuery();
            while(rs.next())
            {
                id=rs.getInt(1);
             System.out.println(id);
            }
        
        
        } catch (SQLException ex) {
            Logger.getLogger(ParamController.class.getName()).log(Level.SEVERE, null, ex);
        }
 
 return id;
 
 }
 private int   minID()
        { 
            int idmin = 1;
        try {
            pst = connection.prepareStatement("SELECT min(id) FROM actitvite");
            ResultSet rs = pst.executeQuery();
            while(rs.next())
            {
                idmin=rs.getInt(1);
             }
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
 
 return idmin;
 }
    
     @FXML
    void vider(ActionEvent event) {
        connection = handler.getConnection();
        int i=minID(),j=autoincrtID();
        Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
        alert.setTitle("Conformation de suppression");
        alert.setHeaderText(null);
        alert.setContentText("Attention!! si vous allez cliquer oui tout le contenu sera supprimé");
        Optional <ButtonType>action = alert.showAndWait();
        if(action.get()==ButtonType.OK){
            alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Notification");
                    alert.setContentText("Veuillez attendre quelques secondes");
                    alert.showAndWait();
        
            
        while(i<=j)
        {
        try{
        String sql ="delete from actitvite where id="+i+"";
        pst = connection.prepareStatement(sql);
        pst.executeUpdate();
        }
        catch (SQLException e1)
            {e1.printStackTrace();}        
i++;}}actualiser();}
}
