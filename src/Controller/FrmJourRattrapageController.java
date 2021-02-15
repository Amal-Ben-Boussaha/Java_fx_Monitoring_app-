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
public class FrmJourRattrapageController implements Initializable {

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
    private TextField jour7;
    @FXML
    private TextField jour8;
    @FXML
    private TextField jour9;
    @FXML
    private TextField jour10;
    @FXML
    private TextField jour11;
    @FXML
    private TextField jour12;
    @FXML
    private TextField jour13;
    @FXML
    private TextField jour14;
    @FXML
    private TextField jour15;
     @FXML
    private TextField nc;

    @FXML
    private TextField j1s1;

    @FXML
    private TextField j1s2;

    @FXML
    private TextField j2s1;

    @FXML
    private TextField j2s2;

    @FXML
    private TextField j3s1;

    @FXML
    private TextField j3s2;

    @FXML
    private TextField j4s1;

    @FXML
    private TextField j4s2;

    @FXML
    private TextField j5s1;

    @FXML
    private TextField j5s2;

    @FXML
    private TextField j6s1;

    @FXML
    private TextField j6s2;

    @FXML
    private TextField j7s1;

    @FXML
    private TextField j7s2;

    @FXML
    private TextField j8s1;

    @FXML
    private TextField j8s2;

    @FXML
    private TextField j9s1;

    @FXML
    private TextField j10s1;

    @FXML
    private TextField j10s2;

    @FXML
    private TextField j11s1;

    @FXML
    private TextField j11s2;

    @FXML
    private TextField j12s1;

    @FXML
    private TextField j12s2;

    @FXML
    private TextField j13s1;

    @FXML
    private TextField j13s2;

    @FXML
    private TextField j14s1;

    @FXML
    private TextField j14s2;

    @FXML
    private TextField j15s1;

    @FXML
    private TextField j15s2;

    @FXML
    private TextField nbre;

    @FXML
    private TextField j9s2;

    EntityManager em;  
    Planningsc planningsc;
    boolean editmode = false;
    private Connection connection;
    private dbconnect handler;
    private PreparedStatement pst;  
    ResultSet rs;
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
    public static EntityManagerFactory emf;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          handler = new dbconnect();
          em = PlanningSCController.emf.createEntityManager();
        
    }    
private  boolean  empty()
    {
        if (jour1.getText().isEmpty()|| jour2.getText().isEmpty()||jour3.getText().isEmpty()||jour4.getText().isEmpty()||jour5.getText().isEmpty()
            ||jour6.getText().isEmpty()||jour7.getText().isEmpty()||jour8.getText().isEmpty()||jour9.getText().isEmpty()||jour10.getText().isEmpty()||jour11.getText().isEmpty()
            ||jour12.getText().isEmpty()||jour13.getText().isEmpty()||jour14.getText().isEmpty()||jour15.getText().isEmpty()
           )
                {   Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("erreur de remplissage");
                    alert.setContentText(" veuillez remplir tous les champs ,s'il n'y a pas des jours à  saisir vous devez mettre des espaces dans les champs correspondants");
                    alert.showAndWait();
                    return false;
        
                    }
    return true;

    }
private  boolean  empty2()
    {
        if (j1s1.getText().isEmpty()|| j1s2.getText().isEmpty()||j2s1.getText().isEmpty()||j2s2.getText().isEmpty()||j3s1.getText().isEmpty()
            ||j3s2.getText().isEmpty()||j4s1.getText().isEmpty()||j4s2.getText().isEmpty()||j5s1.getText().isEmpty()||j5s2.getText().isEmpty()||j6s1.getText().isEmpty()
            ||j6s2.getText().isEmpty()||j7s1.getText().isEmpty()||j7s2.getText().isEmpty()||j8s1.getText().isEmpty()||j8s2.getText().isEmpty()||j9s1.getText().isEmpty()
            ||j9s2.getText().isEmpty()||j10s1.getText().isEmpty()||j10s2.getText().isEmpty()||j11s1.getText().isEmpty()||j11s2.getText().isEmpty()||j12s1.getText().isEmpty()
            ||j12s2.getText().isEmpty()||j13s1.getText().isEmpty()||j13s2.getText().isEmpty()||j14s1.getText().isEmpty()||j14s2.getText().isEmpty()||j15s1.getText().isEmpty()||j15s2.getText().isEmpty()
           )
                {   Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("erreur de remplissage");
                    alert.setContentText(" veuillez remplir tous les champs ,s'il n'y a pas des Séance à  saisir vous devez mettre des espaces dans les champs correspondants");
                    alert.showAndWait();
                    return false;
        
                    }
    return true;

    }
public void setplanning(int idPlanningSC) {
        Query q = em.createQuery("SELECT p FROM Planningsc p WHERE p.idPlanningSC = :idPlanningSC");
        q.setParameter("idPlanningSC",new Integer(idPlanningSC));
        planningsc = (Planningsc) q.getSingleResult();
        nc.setText(planningsc.getNomcomplt());
        j1s1.setText(planningsc.getJ1s1());
        j1s2.setText(planningsc.getJ1s2());
        j2s1.setText(planningsc.getJ2s1());
        j2s2.setText(planningsc.getJ2s2());
        j3s1.setText(planningsc.getJ3s1());
        j3s2.setText(planningsc.getJ3s2());
        j4s1.setText(planningsc.getJ4s1());
        j4s2.setText(planningsc.getJ4s2());
        j5s1.setText(planningsc.getJ5s1());
        j5s2.setText(planningsc.getJ5s2());
        j6s1.setText(planningsc.getJ6s1());
        j6s2.setText(planningsc.getJ6s2());
        j7s1.setText(planningsc.getJ7s1());
        j7s2.setText(planningsc.getJ7s2());
        j8s1.setText(planningsc.getJ8s1());
        j8s2.setText(planningsc.getJ8s2());
        j9s1.setText(planningsc.getJ9s1());
        j9s2.setText(planningsc.getJ9s2());
        j10s1.setText(planningsc.getJ10s1());
        j10s2.setText(planningsc.getJ10s2());
        j11s1.setText(planningsc.getJ11s1());
        j11s2.setText(planningsc.getJ11s2());
        j12s1.setText(planningsc.getJ12s1());
        j12s2.setText(planningsc.getJ12s2());
        j13s1.setText(planningsc.getJ13s1());
        j13s2.setText(planningsc.getJ13s2());
        j14s1.setText(planningsc.getJ14s1());
        j14s2.setText(planningsc.getJ14s2());
        j15s1.setText(planningsc.getJ15s1());
        j15s2.setText(planningsc.getJ15s2());
        nbre.setText(planningsc.getNbre());
        editmode = true;
    
    }
private  boolean  formtemps()
    {
        if (jour1.getText().length()<=19||jour2.getText().length()<=19|jour3.getText().length()<=19|jour4.getText().length()<=19|jour5.getText().length()<=19|jour6.getText().length()<=19|jour7.getText().length()<=19|jour8.getText().length()<=19|jour9.getText().length()<=19|jour10.getText().length()<=19|jour11.getText().length()<=19|jour12.getText().length()<=19|jour13.getText().length()<=19|jour14.getText().length()<=19|jour15.getText().length()<=19)
    
                {   Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("erreur de remplissage");
                    alert.setContentText(" pour bien génerer le planning il faut entre sous form Jour jj/mm/aaaa");
                    alert.showAndWait();
                    return false;
        
                    }
    return true;

    }
    
    
    @FXML
    private void enregistrer(ActionEvent event) {
    connection = handler.getConnection();
     if(empty())
        {
          try
        {   
            String insert = "INSERT INTO planningsc VALUES ("+1+",' ','"+jour1.getText()+"','"+jour1.getText()+"','"+jour2.getText()+"','"+jour2.getText()+"','"+jour3.getText()+"','"+jour3.getText()+"','"+jour4.getText()+"','"+jour4.getText()+"','"+jour5.getText()+"','"+jour5.getText()+"','"+jour6.getText()+"','"+jour6.getText()+"','"+jour7.getText()+"','"+jour7.getText()+"','"+jour8.getText()+"','"+jour8.getText()+"','"+jour9.getText()+"','"+jour9.getText()+"','"+jour10.getText()+"','"+jour10.getText()+"','"+jour11.getText()+"','"+jour11.getText()+"','"+jour12.getText()+"','"+jour12.getText()+"','"+jour13.getText()+"','"+jour13.getText()+"','"+jour14.getText()+"','"+jour14.getText()+"','"+jour15.getText()+"','"+jour15.getText()+"','  ')";
       
            pst = connection.prepareStatement(insert);
                           int executeUpdate = pst.executeUpdate();
  
            if(executeUpdate == 1)
                    {  Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Réussite de l'ajout");
                    alert.setContentText("jour bien ajouter");
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
     @FXML
    void insere(ActionEvent event) {
        if (!editmode) {
        planningsc = new Planningsc();
        }if (nc.getText().isEmpty()||j1s1.getText().isEmpty()|| j1s2.getText().isEmpty()||j2s1.getText().isEmpty()||j2s2.getText().isEmpty()||j3s1.getText().isEmpty()
            ||j3s2.getText().isEmpty()||j4s1.getText().isEmpty()||j4s2.getText().isEmpty()||j5s1.getText().isEmpty()||j5s2.getText().isEmpty()||j6s1.getText().isEmpty()
            ||j6s2.getText().isEmpty()||j7s1.getText().isEmpty()||j7s2.getText().isEmpty()||j8s1.getText().isEmpty()||j8s2.getText().isEmpty()||j9s1.getText().isEmpty()
            ||j9s2.getText().isEmpty()||j10s1.getText().isEmpty()||j10s2.getText().isEmpty()||j11s1.getText().isEmpty()||j11s2.getText().isEmpty()||j12s1.getText().isEmpty()
            ||j12s2.getText().isEmpty()||j13s1.getText().isEmpty()||j13s2.getText().isEmpty()||j14s1.getText().isEmpty()||j14s2.getText().isEmpty()||j15s1.getText().isEmpty()||j15s2.getText().isEmpty()||nbre.getText().isEmpty()
           )
                {   Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("erreur de remplissage");
                    alert.setContentText(" veuillez remplir tous les champs ,s'il n'y a pas des Séance à  saisir vous devez mettre des espaces dans les champs correspondants");
                    alert.showAndWait();
                }
        else{
            planningsc.setNomcomplt(nc.getText());
            planningsc.setJ1s1(j1s1.getText());
            planningsc.setJ1s2(j1s2.getText());
            planningsc.setJ2s1(j2s1.getText());
            planningsc.setJ2s2(j2s2.getText());
            planningsc.setJ3s1(j3s1.getText());
            planningsc.setJ3s2(j3s2.getText());
            planningsc.setJ4s1(j4s1.getText());
            planningsc.setJ4s2(j4s2.getText());
            planningsc.setJ5s1(j5s1.getText());
            planningsc.setJ5s2(j5s2.getText());
            planningsc.setJ6s1(j6s1.getText());
            planningsc.setJ6s2(j6s2.getText());
            planningsc.setJ7s1(j7s1.getText());
            planningsc.setJ7s2(j7s2.getText());
            planningsc.setJ8s1(j8s1.getText());
            planningsc.setJ8s2(j8s2.getText());
            planningsc.setJ9s1(j9s1.getText());
            planningsc.setJ9s2(j9s2.getText());
            planningsc.setJ10s1(j10s1.getText());
            planningsc.setJ10s2(j10s2.getText());
            planningsc.setJ11s1(j11s1.getText());
            planningsc.setJ11s2(j11s2.getText());
            planningsc.setJ12s1(j12s1.getText());
            planningsc.setJ12s2(j12s2.getText());
            planningsc.setJ13s1(j13s1.getText());
            planningsc.setJ13s2(j13s2.getText());
            planningsc.setJ14s1(j14s1.getText());
            planningsc.setJ14s2(j14s2.getText());
            planningsc.setJ15s1(j10s2.getText());
            planningsc.setJ15s2(j15s2.getText());
            planningsc.setNbre(nbre.getText());
            
            em.getTransaction().begin();
            em.persist(planningsc);
            em.getTransaction().commit();
            em.close();
            quitter(event);
        
    
    }}

    @FXML
    void quitter(ActionEvent event) {
         Node node = (Node) event.getSource();
         Stage stage =(Stage)node.getScene().getWindow();
         stage.close();
    
    }

    
}
