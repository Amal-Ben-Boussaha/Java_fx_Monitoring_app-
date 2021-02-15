/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 * FXML Controller class
 *
 * @author Amal Ben Boussaha
 */
public class FrmseancedsController implements Initializable {

        @FXML
    private TextField jour1;
    @FXML
    private TextField jour2;
    @FXML
    private TextField jour3;
    @FXML
    private TextField jour4;
    @FXML
    private TextField jour5;
    @FXML
    private TextField jour6;
    
    @FXML
    private TextField nc;

    @FXML
    private TextField j1s1;

    @FXML
    private TextField j1s2;

    @FXML
    private TextField j1s3;

    @FXML
    private TextField j1s4;

    @FXML
    private TextField j2s1;

    @FXML
    private TextField j2s2;

    @FXML
    private TextField j2s3;

    @FXML
    private TextField j2s4;

    @FXML
    private TextField j3s1;

    @FXML
    private TextField j3s2;

    @FXML
    private TextField j3s3;

    @FXML
    private TextField j3s4;

    @FXML
    private TextField j4s1;

    @FXML
    private TextField j4s2;

    @FXML
    private TextField j4s3;

    @FXML
    private TextField j4s4;

    @FXML
    private TextField j5s1;

    @FXML
    private TextField j5s2;

    @FXML
    private TextField j5s3;

    @FXML
    private TextField j5s4;

    @FXML
    private TextField j6s1;

    @FXML
    private TextField j6s2;

    @FXML
    private TextField j6s3;

    @FXML
    private TextField j6s4;

    @FXML
    private TextField nbre;
    double x= 0,y =0;
    @FXML
    void dragged(MouseEvent event) {
         Node node = (Node) event.getSource();
         Stage stage =(Stage)node.getScene().getWindow();
         stage.setX(event.getScreenX() -x);
         stage.setY(event.getScreenY() -y);
    }
     @FXML
    void pressed(MouseEvent event) {
        x=event.getSceneX();
        y=event.getSceneY();
    }
    @FXML
    void insrer(ActionEvent event) {
         if (!editmode) {
        planningds = new Planningds();
        }if (j1s1.getText().isEmpty()|| j1s2.getText().isEmpty()||j2s1.getText().isEmpty()||j2s2.getText().isEmpty()||j3s1.getText().isEmpty()
            ||j3s2.getText().isEmpty()||j4s1.getText().isEmpty()||j4s2.getText().isEmpty()||j5s1.getText().isEmpty()||j5s2.getText().isEmpty()||j6s1.getText().isEmpty()
            ||j6s2.getText().isEmpty()||j1s3.getText().isEmpty()||j1s4.getText().isEmpty()||j2s3.getText().isEmpty()||j2s4.getText().isEmpty()||j3s3.getText().isEmpty()
            ||j3s4.getText().isEmpty()||j4s3.getText().isEmpty()||j4s4.getText().isEmpty()||j5s3.getText().isEmpty()||j5s4.getText().isEmpty()||j6s3.getText().isEmpty()
            ||j6s4.getText().isEmpty())
                {   Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("erreur de remplissage");
                    alert.setContentText(" veuillez remplir tous les champs ,s'il n'y a pas des Séance à  saisir vous devez mettre des espaces dans les champs correspondants");
                    alert.showAndWait();
                    }else{
         
            planningds.setNomcomplt(nc.getText());
            planningds.setJ1s1(j1s1.getText());
            planningds.setJ1s2(j1s2.getText());
            planningds.setJ1s3(j1s3.getText());
            planningds.setJ1s4(j1s4.getText());
            planningds.setJ2s1(j2s1.getText());
            planningds.setJ2s2(j2s2.getText());
            planningds.setJ2s3(j2s3.getText());
            planningds.setJ2s4(j2s4.getText());
            planningds.setJ3s1(j3s1.getText());
            planningds.setJ3s2(j3s2.getText());
            planningds.setJ3s3(j3s3.getText());
            planningds.setJ3s4(j3s4.getText());
            planningds.setJ4s1(j4s1.getText());
            planningds.setJ4s2(j4s2.getText());
            planningds.setJ4s3(j4s3.getText());
            planningds.setJ4s4(j4s4.getText());
            planningds.setJ5s1(j5s1.getText());
            planningds.setJ5s2(j5s2.getText());
            planningds.setJ5s3(j5s3.getText());
            planningds.setJ5s4(j5s4.getText());
            planningds.setJ6s1(j6s1.getText());
            planningds.setJ6s2(j6s2.getText());
            planningds.setJ6s3(j6s3.getText());
            planningds.setJ6s4(j6s4.getText());
            planningds.setNbre(nbre.getText());
            em.getTransaction().begin();
            em.persist(planningds);
            em.getTransaction().commit();
            em.close();
            annuler(event);
    }
    }

    @FXML
    void quiter(ActionEvent event) {
        annuler(event);
    }

    EntityManager em;  
    Planningds planningds;
    boolean editmode = false;
    private Connection connection;
    private dbconnect handler;
    private PreparedStatement pst;  
    private ResultSet rs;
    public static EntityManagerFactory emf;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         handler = new dbconnect();
          em = PlanningSCController.emf.createEntityManager();
        
    }    
    public void setplanning(int idPlanningDS) {
        Query q = em.createQuery("SELECT p FROM Planningds p WHERE p.idPlanningDS = :idPlanningDS");
        q.setParameter("idPlanningDS",new Integer(idPlanningDS));
        planningds = (Planningds) q.getSingleResult();
        nc.setText(planningds.getNomcomplt());
        j1s1.setText(planningds.getJ1s1());
        j1s2.setText(planningds.getJ1s2());
        j1s3.setText(planningds.getJ1s3());
        j1s4.setText(planningds.getJ1s4());
        j2s1.setText(planningds.getJ2s1());
        j2s2.setText(planningds.getJ2s2());
        j2s3.setText(planningds.getJ2s3());
        j2s4.setText(planningds.getJ2s4());
        j3s1.setText(planningds.getJ3s1());
        j3s2.setText(planningds.getJ3s2());
        j3s3.setText(planningds.getJ3s3());
        j3s4.setText(planningds.getJ3s4());
        j4s1.setText(planningds.getJ4s1());
        j4s2.setText(planningds.getJ4s2());
        j4s3.setText(planningds.getJ4s3());
        j4s4.setText(planningds.getJ4s4());
        j5s1.setText(planningds.getJ5s1());
        j5s2.setText(planningds.getJ5s2());
        j5s3.setText(planningds.getJ5s3());
        j5s4.setText(planningds.getJ5s4());
        j6s1.setText(planningds.getJ6s1());
        j6s2.setText(planningds.getJ6s2());
        j6s3.setText(planningds.getJ6s3());
        j6s4.setText(planningds.getJ6s4());
        nbre.setText(planningds.getNbre());
        editmode = true;
    
    }

     
private  boolean  empty()
    {
        if (jour1.getText().isEmpty()|| jour2.getText().isEmpty()||jour3.getText().isEmpty()||jour4.getText().isEmpty()||jour5.getText().isEmpty()
            ||jour6.getText().isEmpty())
        {
    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("erreur de remplissage");
                    alert.setContentText(" veuillez remplir tous les champs ,s'il n'y a pas des jours à  saisir vous devez mettre des espaces dans les champs correspondants");
                    alert.showAndWait();
                    return false;
                
        }
    return true;
    
    }
    @FXML
    private void enregistrer(ActionEvent event) {
    if(empty())
        {
          try
        {   
            String insert = "INSERT INTO planningds VALUES ("+1+",' ','"+jour1.getText()+"','"+jour1.getText()+"','"+jour1.getText()+"','"+jour1.getText()+"','"+jour2.getText()+"','"+jour2.getText()+"','"+jour2.getText()+"','"+jour2.getText()+"','"+jour3.getText()+"','"+jour3.getText()+"','"+jour3.getText()+"','"+jour3.getText()+"','"+jour4.getText()+"','"+jour4.getText()+"','"+jour4.getText()+"','"+jour4.getText()+"','"+jour5.getText()+"','"+jour5.getText()+"','"+jour5.getText()+"','"+jour5.getText()+"','"+jour6.getText()+"','"+jour6.getText()+"','"+jour6.getText()+"','"+jour6.getText()+"','  ')";
       
            pst = connection.prepareStatement(insert);
                           int executeUpdate = pst.executeUpdate();
  
            if(executeUpdate == 1)
                    {  Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Réussite de l'ajout");
                    alert.setContentText("ajouté avec succés");
                    alert.showAndWait();
                    }  
        annuler(event);
        }
        catch (SQLException e1)
            {
                e1.printStackTrace();
            }
        
        } 
    
     
    }

    @FXML
    private void annuler(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage =(Stage)node.getScene().getWindow();
        stage.close();
    
    }
    

}
