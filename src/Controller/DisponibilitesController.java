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
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
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
public class DisponibilitesController implements Initializable {
    private Connection connection;
    private dbconnect handler;
    private PreparedStatement pst;  
    EntityManager em;  
    ObservableList<Disponibilitesfx> data;
    
    
    @FXML
    private TextField schema;

    @FXML
    private JFXButton affichie;

    @FXML
    private JFXButton ajouter;

    @FXML
    private JFXButton modifier;

    @FXML
    private JFXButton supprimer;

    @FXML
    private TableView<Disponibilitesfx> tab_disp;

    @FXML
    private TableColumn<Disponibilitesfx, Number> iddisp;

    @FXML
    private TableColumn<Disponibilitesfx, String> idactivites;

    @FXML
    private TableColumn<Disponibilitesfx, String> heure;

    @FXML
    private TableColumn<Disponibilitesfx, String> jour;

    @FXML
    private TableColumn<Disponibilitesfx, String> classe;

    @FXML
    private TableColumn<Disponibilitesfx, String> matieres;

    @FXML
    private TableColumn<Disponibilitesfx, String> prof;

    @FXML
    private TableColumn<Disponibilitesfx, String> code;

    @FXML
    private TableColumn<Disponibilitesfx, String> salle;

    @FXML
    void importation(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter( "Fichier Microsoft Excel","*.csv"));
        File f = fc.showOpenDialog(null);
        if(f != null)
        {
            schema.setText(f.getAbsolutePath());
        }
    
    }
    private int    autoincrtID()
        { 
            int id = 1;
        try {
            pst = connection.prepareStatement("SELECT max(iddisponibilites) FROM disponibilites");
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
    void ouvrire(ActionEvent event) throws IOException {
        connection = handler.getConnection();
       try
        {   
            String line;
            int i =autoincrtID();        
            BufferedReader br = new BufferedReader(new FileReader(schema.getText()));
            while((line = br.readLine())!=null)
            {
                i+=1; 
                String []value =line.split(",");
                    
                    String sql="INSERT INTO disponibilites VALUES ("+i+",'"+value[0]+"',"+value[1]+","+value[2]+","+value[3]+","+value[4]+","+value[5]+","+value[6]+","+value[7]+",'"+value[8]+"')";
                    pst = connection.prepareStatement(sql);
                    pst.execute();
        
            }
        }
         catch(SQLException |FileNotFoundException e)
            {  
                e.printStackTrace();
            }finally 
        {
                try{
                      connection.close();
                      
                   }catch(SQLException e1)
                    {   
                        e1.printStackTrace();
                    
                    }
        }
    
            
            
    }
    public static EntityManagerFactory emf;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       handler = new dbconnect();
       emf=Persistence.createEntityManagerFactory("ESENPU");
       em = DisponibilitesController.emf.createEntityManager();
         
        
    }    
     @FXML
    void ajouter(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/FormDisponibilites.fxml"));
        AnchorPane  mainPane = (AnchorPane)loader.load();
        Scene scene = new Scene(mainPane);
        stage.setTitle("Ajouter Nouvelle Disponibilites");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        FormDispController ctrl = loader.getController();
        stage.showAndWait();
        affichier(event);
    }
       @FXML
    void modifier(ActionEvent event) throws IOException {
        int row =tab_disp.getSelectionModel().getSelectedIndex();
        if(row <0)return; 
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/FormDisponibilites.fxml"));
        AnchorPane  mainPane = (AnchorPane)loader.load();
        Scene scene = new Scene(mainPane);
        stage.setTitle("Modifier Disponibilite");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        FormDispController ctrl = loader.getController();
        ctrl.setdisp(data.get(row).getIddisponibilites());
        stage.showAndWait();
    }
     @FXML
    void affichier(ActionEvent event) {
        
         emf=Persistence.createEntityManagerFactory("ESENPU");
         em = DisponibilitesController.emf.createEntityManager();
         em = DisponibilitesController.emf.createEntityManager();
         tab_disp.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
         List<Disponibilites>lst = em.createQuery("SELECT d FROM Disponibilites d").getResultList();
         data=FXCollections.observableArrayList();
         for(Disponibilites lists:lst)
         {  
           data.add(new Disponibilitesfx(lists.getIddisponibilites(),lists.getIdactivites(),lists.getDay(),lists.getHour(),lists.getClasse(),lists.getSubject(),lists.getTeachers(),lists.getActivitestages(),lists.getRom()));
         }
         tab_disp.setItems(data);
         iddisp.setCellValueFactory(cell->cell.getValue().getIddisponibilitesProperty());
         idactivites.setCellValueFactory(cell->cell.getValue().getIdactivitesProperty());
         heure.setCellValueFactory(cell->cell.getValue().getHourProperty());
         jour.setCellValueFactory(cell->cell.getValue().getDayProperty());
         classe.setCellValueFactory(cell->cell.getValue().getClasseProperty());
         matieres.setCellValueFactory(cell->cell.getValue().getSubjectProperty());
         prof.setCellValueFactory(cell->cell.getValue().getTeachersProperty());
         code.setCellValueFactory(cell->cell.getValue().getActivitestagesProperty());
         salle.setCellValueFactory(cell->cell.getValue().getRomProperty());
    
         }
    @FXML
    void supprimer(ActionEvent event) {
        int row =tab_disp.getSelectionModel().getSelectedIndex();
        if(row <0)return;
        Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
        alert.setTitle("Conformation de suppression");
        alert.setHeaderText(null);
        alert.setContentText("Vous etes sure?");
        Optional <ButtonType>action = alert.showAndWait();
        
        if(action.get()==ButtonType.OK){
            
        
        em = DisponibilitesController.emf.createEntityManager();
        Query d =em.createQuery("SELECT d FROM Disponibilites d WHERE d.iddisponibilites = :iddisponibilitesd");
        d.setParameter("iddisponibilitesd", data.get(row).getIddisponibilites());
        Disponibilites g = (Disponibilites)d.getSingleResult();
        em.getTransaction().begin();
        em.remove(g);
        em.getTransaction().commit();
        em.close();
        affichier(event);

    }}
      private int   minID()
        { 
            int id = 1;
        try {
            pst = connection.prepareStatement("SELECT min(iddisponibilites) FROM disponibilites");
            ResultSet rs = pst.executeQuery();
            while(rs.next())
            {
                id=rs.getInt(1);
             
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(DisponibilitesController.class.getName()).log(Level.SEVERE, null, ex);
        }
 
 return id;
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
        String sql ="delete from disponibilites where iddisponibilites="+i+"";
        pst = connection.prepareStatement(sql);
        pst.executeUpdate();
        }
        catch (SQLException e1)
            {
                e1.printStackTrace();
            
            }        
i++;
        }
        }affichier(event);
    }
    @FXML
    void e(Event e) {
        TableColumn.CellEditEvent<Disponibilitesfx, Number> CellEditEvent;
        CellEditEvent =(TableColumn.CellEditEvent<Disponibilitesfx, Number>)e;
        Disponibilitesfx disponibilites=CellEditEvent.getRowValue();
        disponibilites.setIddisponibilites(Integer.MIN_VALUE);
    }
    
}
