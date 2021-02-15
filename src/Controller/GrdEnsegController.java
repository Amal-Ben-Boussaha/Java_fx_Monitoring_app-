/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
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
public class GrdEnsegController implements Initializable {

     @FXML
    private TableView<Gradefx> gradeensg;

    @FXML
    private TableColumn<Gradefx, Number> id;

    @FXML
    private TableColumn<Gradefx, String> nbgrade;

    @FXML
    private TableColumn<Gradefx, String> tempseancemax;

    @FXML
    private TableColumn<Gradefx, String> nomgrade1;

    
    private Connection connection;
    private dbconnect handler;
    private PreparedStatement pst; 
    private ResultSet rs;
    EntityManager em;  
    ObservableList<Gradefx> data;
    public static EntityManagerFactory emf;
    @FXML
    void ajouter(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/FrmGrd.fxml"));
        AnchorPane  mainPane = (AnchorPane)loader.load();
        Scene scene = new Scene(mainPane);
        stage.setTitle("Ajouter Nouveaux Grade");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        FrmGrdController ctrl = loader.getController();
        stage.showAndWait();
        actualiser();
    
    }

    @FXML
    void modifier(ActionEvent event) throws IOException {
        int row =gradeensg.getSelectionModel().getSelectedIndex();
        if(row <0)return; 
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/FrmGrd.fxml"));
        AnchorPane  mainPane = (AnchorPane)loader.load();
        Scene scene = new Scene(mainPane);
        stage.setTitle("Modifier Grade");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        FrmGrdController ctrl = loader.getController();
        ctrl.setenseignant(data.get(row).getIdgrade());
        stage.showAndWait();
        actualiser();
    
    }

    @FXML
    void supprimer(ActionEvent event) {
        int row =gradeensg.getSelectionModel().getSelectedIndex();
        if(row <0)return;
        Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
        alert.setTitle("Conformation de suppression");
        alert.setHeaderText(null);
        alert.setContentText("Vous etes sure?");
        Optional <ButtonType>action = alert.showAndWait();
        
        if(action.get()==ButtonType.OK){
            
        
        em = GrdEnsegController.emf.createEntityManager();
        Query q =em.createQuery("SELECT g FROM Grade g WHERE g.idgrade = :idgrade");
        q.setParameter("idgrade", data.get(row).getIdgrade());
        Grade G = (Grade) q.getSingleResult();
        em.getTransaction().begin();
        em.remove(G);
        em.getTransaction().commit();
        em.close();
        
        actualiser();
    
    }
    }
    private void actualiser()
{
    emf=Persistence.createEntityManagerFactory("ESENPU");
        em = GrdEnsegController.emf.createEntityManager();
        emf=Persistence.createEntityManagerFactory("ESENPU");
        gradeensg.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
                
        List<Grade>lst = em.createQuery("SELECT g FROM Grade g").getResultList();
        
        data=FXCollections.observableArrayList();
        for(Grade lst1:lst){
           
        data.add(new Gradefx(lst1.getIdgrade(),lst1.getNomgrade(),lst1.getNbseancemax(),lst1.getNbseancemin()));
        }
        gradeensg.setItems(data);
        id.setCellValueFactory(cell->cell.getValue().getIdgradeProperty());
        nbgrade.setCellValueFactory(cell->cell.getValue().getNomgradeProperty());
        tempseancemax.setCellValueFactory(cell->cell.getValue().getNbseancemaxProperty());
        nomgrade1.setCellValueFactory(cell->cell.getValue().getNbseanceminProperty());

}
    private int   minID()
        { 
            int idmin = 1;
        try {
            pst = connection.prepareStatement("SELECT min(idgrade) FROM grade");
            rs = pst.executeQuery();
            while(rs.next())
            {
                idmin=rs.getInt(1);
             }
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
 
 return idmin;
 }
    private int   maxID()
        { 
            int idm=1;
        try {
            pst = connection.prepareStatement("SELECT max(idgrade) FROM grade");
            rs = pst.executeQuery();
            while(rs.next())
            {
                idm=rs.getInt(1);
             }
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
 
 return idm;
 }
      @FXML
    void vider(ActionEvent event) {
        connection = handler.getConnection();
        int i=minID(),j=maxID();
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
        String sql ="delete from grade where idgrade="+i+"";
        pst = connection.prepareStatement(sql);
        pst.executeUpdate();
        }
        catch (SQLException e1)
            {
                e1.printStackTrace();
            
            }        
i++;
        }
        }actualiser();
   

    }


    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         actualiser();
    }    
}
