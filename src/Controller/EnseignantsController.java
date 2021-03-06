/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.jfoenix.controls.JFXButton;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
public class EnseignantsController implements Initializable {

   
    @FXML
    private AnchorPane home;

    @FXML
    private JFXButton ouv;

    @FXML
    private TextField  chema;

    @FXML
    private JFXButton mod;

    @FXML
    private JFXButton sup;
    @FXML
    private JFXButton st;

    @FXML
    private Label sch;
    private JFXButton fix;
    private Connection connection;
    private dbconnect handler;
    private PreparedStatement pst;  
    EntityManager em;  
    private ResultSet rs;
    @FXML
    private TableView<Enseignantfx> fullname;
    ObservableList<Enseignantfx> data;
    @FXML
    private TableColumn<Enseignantfx, Number> id;

    @FXML
    private TableColumn<Enseignantfx, String> NC;

    @FXML
    private TableColumn<Enseignantfx, String> grd;
    
    private String setgradeens()
 
     String gradee="";
    try {
            pst = connection.prepareStatement("SELECT nomgrade FROM grade");
             rs = pst.executeQuery();
            while(rs.next())
            {
                gradee=gradee+" "+rs.getString(1);
            
            }
        
        
        } catch (SQLException ex) {
        ex.printStackTrace();
        }
 
 return gradee;
 
 }
    private int    autoincrtID()
        { 
            int id = 1;
        try {
            pst = connection.prepareStatement("SELECT max(id) FROM enseignant");
            ResultSet rs = pst.executeQuery();
            while(rs.next())
            {
                id=rs.getInt(1);
            
            }
        
        
        } catch (SQLException ex) {
            Logger.getLogger(ParamController.class.getName()).log(Level.SEVERE, null, ex);
        }
 
 return id;
 
 }
    @FXML
    void importation(ActionEvent event) throws FileNotFoundException, IOException, SQLException {
        connection = handler.getConnection();
        String S =setgradeens();
       try
        {
       
        String line;
       int i= autoincrtID(); 
            BufferedReader br = new BufferedReader(new FileReader(chema.getText()));
                while((line = br.readLine())!=null){
                i+=1; 
                String []value =line.split("  ");
                String[] G =S.split(" ");
               
       String sql="INSERT INTO enseignant(id,nomcomplt,grade) values ("+i+",'"+value[0]+"','"+G[1]+"')";
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
    void ouvrire(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter( "Fichier Microsoft Excel","*.csv"));
        File f = fc.showOpenDialog(null);
        if(f != null)
        {
            chema.setText(f.getAbsolutePath());
        }
    } 
    
        
    public static EntityManagerFactory emf;
private void actualiser()
    {   emf=Persistence.createEntityManagerFactory("ESENPU");
        em = EnseignantsController.emf.createEntityManager();
        
        fullname.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
                
        List<Enseignant>lst = em.createQuery("SELECT e FROM Enseignant e").getResultList();
        
        data=FXCollections.observableArrayList();
        for(Enseignant lst1:lst)
        {
            data.add(new Enseignantfx(lst1.getId(),lst1.getNomcomplt(),lst1.getGrade()));
        }
        fullname.setItems(data);
        id.setCellValueFactory(cell->cell.getValue().getIdProperty());
        NC.setCellValueFactory(cell->cell.getValue().getNomcompltProperty());
        grd.setCellValueFactory(cell->cell.getValue().getGradeProperty());

   
    }
    
   @FXML
    void modifier(ActionEvent event) throws IOException {
        int row =fullname.getSelectionModel().getSelectedIndex();
        if(row <0)return; 
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/FrmulairEns.fxml"));
        AnchorPane  mainPane = (AnchorPane)loader.load();
        Scene scene = new Scene(mainPane);
        stage.setTitle("Ajouter Nouvelle enseignant");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        FrmulairEnsController ctrl = loader.getController();
        ctrl.setenseignant(data.get(row).getId());
        stage.showAndWait();
        actualiser();
    }

      @FXML
    void supprimer(ActionEvent event) {
        int row =fullname.getSelectionModel().getSelectedIndex();
        if(row <0)return;
         Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
        alert.setTitle("Conformation de suppression");
        alert.setHeaderText(null);
        alert.setContentText("Vous etes sure?");
        Optional <ButtonType>action = alert.showAndWait();
        
        if(action.get()==ButtonType.OK){
       
        em = EnseignantsController.emf.createEntityManager();
        Query q =em.createQuery("SELECT e FROM Enseignant e WHERE e.id = :id");
        q.setParameter("id", data.get(row).getId());
        Enseignant e = (Enseignant) q.getSingleResult();
        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();
        em.close();
        
        actualiser();
    }
    }
     @FXML
    void ajouter(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/FrmulairEns.fxml"));
        AnchorPane  mainPane = (AnchorPane)loader.load();
        Scene scene = new Scene(mainPane);
        stage.setTitle("Ajouter Nouvelle enseignant");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        FrmulairEnsController ctrl = loader.getController();
        stage.showAndWait();
        actualiser();
    }
    @FXML
    void afficher(ActionEvent event) {
        actualiser();
    }

             
       @Override
    public void initialize(URL url, ResourceBundle rb) {
         handler = new dbconnect();
        emf=Persistence.createEntityManagerFactory("ESENPU");
        em = EnseignantsController.emf.createEntityManager();
        
    }
private int   minID()
        { 
            int idm = 1;
        try {
            pst = connection.prepareStatement("SELECT min(id) FROM enseignant");
            ResultSet rs = pst.executeQuery();
            while(rs.next())
            {
                idm=rs.getInt(1);
             
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(DisponibilitesController.class.getName()).log(Level.SEVERE, null, ex);
        }
 
 return idm;
 }
    @FXML
    void vider(ActionEvent event) {
        connection = handler.getConnection();
        int i=minID(),j=autoincrtID();
        Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
        alert.setTitle("Conformation de suppression");
        alert.setHeaderText(null);
        alert.setContentText("Attention!! si vous aves clique Qui tout les contunu sera supprimer!!");
        Optional <ButtonType>action = alert.showAndWait();
        if(action.get()==ButtonType.OK){
            alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Notification");
                    alert.setContentText("Veuillez Vous Attende Quelque Seconde");
                    alert.showAndWait();
        
            
        while(i<=j)
        {
        try{
        String sql ="delete from enseignant where id="+i+"";
        pst = connection.prepareStatement(sql);
        pst.executeUpdate();
        }
        catch (SQLException e1)
            {
                e1.printStackTrace();
            
            }        
i++;
        }
        }
    }    
  
}
