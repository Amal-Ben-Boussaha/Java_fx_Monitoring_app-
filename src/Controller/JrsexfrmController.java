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
public class JrsexfrmController implements Initializable {
    @FXML
    private TextField J1;
    @FXML
    private TextField J2;
    @FXML
    private TextField J3;
    @FXML
    private TextField J4;
    @FXML
    private TextField J5;
    @FXML
    private TextField J6;
    @FXML
    private TextField J7;
    @FXML
    private TextField J8;
    @FXML
    private TextField J9;
    @FXML
    private TextField J10;
   @FXML
    private TextField nc;

    @FXML
    private TextField j1s1;

    @FXML
    private TextField j1s2;

    @FXML
    private TextField j1s3;

    @FXML
    private TextField j2s1;

    @FXML
    private TextField j2s2;

    @FXML
    private TextField j2s3;

    @FXML
    private TextField j3s1;

    @FXML
    private TextField j3s2;

    @FXML
    private TextField j3s3;

    @FXML
    private TextField j4s1;

    @FXML
    private TextField j4s2;

    @FXML
    private TextField j4s3;

    @FXML
    private TextField j5s1;

    @FXML
    private TextField j5s2;

    @FXML
    private TextField j5s3;

    @FXML
    private TextField j6s1;

    @FXML
    private TextField j6s2;

    @FXML
    private TextField j7s1;

    @FXML
    private TextField j7s2;

    @FXML
    private TextField j7s3;

    @FXML
    private TextField j8s1;

    @FXML
    private TextField j8s2;

    @FXML
    private TextField j8s3;

    @FXML
    private TextField j9s1;

    @FXML
    private TextField j9s2;

    @FXML
    private TextField j9s3;

    @FXML
    private TextField j10s1;

    @FXML
    private TextField j10s2;

    @FXML
    private TextField j10s3;

    @FXML
    private TextField nbre;

    @FXML
    private TextField j6s3;
    EntityManager em;  
    Planning planning;
    boolean editmode = false;
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
    void quitter(ActionEvent event) {
        Node node = (Node) event.getSource();
         Stage stage =(Stage)node.getScene().getWindow();
         stage.close();
    }
        public void setplanning(int idP) {
        Query q = em.createQuery("SELECT p FROM Planning p WHERE p.idP = :idP");
        q.setParameter("idP",new Integer(idP));
        planning = (Planning) q.getSingleResult();
        nc.setText(planning.getNomcomplt());
        j1s1.setText(planning.getJ1s1());
        j1s2.setText(planning.getJ1s2());
        j1s3.setText(planning.getJ1s3());
        j2s1.setText(planning.getJ2s1());
        j2s2.setText(planning.getJ2s2());
        j2s3.setText(planning.getJ2s3());
        j3s1.setText(planning.getJ3s1());
        j3s2.setText(planning.getJ3s2());
        j3s3.setText(planning.getJ3s3());
        j4s1.setText(planning.getJ4s1());
        j4s2.setText(planning.getJ4s2());
        j4s3.setText(planning.getJ4s3());
        j5s1.setText(planning.getJ5s1());
        j5s2.setText(planning.getJ5s2());
        j5s3.setText(planning.getJ5s3());
        j6s1.setText(planning.getJ6s1());
        j6s2.setText(planning.getJ6s2());
        j6s3.setText(planning.getJ6s3());
        j7s1.setText(planning.getJ7s1());
        j7s2.setText(planning.getJ7s2());
        j7s3.setText(planning.getJ7s3());
        j8s1.setText(planning.getJ8s1());
        j8s2.setText(planning.getJ8s2());
        j8s3.setText(planning.getJ8s3());
        j9s1.setText(planning.getJ9s1());
        j9s2.setText(planning.getJ9s2());
        j9s3.setText(planning.getJ9s3());
        j10s1.setText(planning.getJ10s1());
        j10s2.setText(planning.getJ10s2());
        j10s3.setText(planning.getJ10s3());
        nbre.setText(planning.getNbre());
        editmode = true;
    
    }

    @FXML
    void insere(ActionEvent event) {
        if (!editmode) {
        planning = new Planning();
        }if (nc.getText().isEmpty()||j1s1.getText().isEmpty()|| j1s2.getText().isEmpty()||j1s3.getText().isEmpty()||j2s2.getText().isEmpty()||j3s1.getText().isEmpty()
            ||j3s2.getText().isEmpty()||j4s1.getText().isEmpty()||j4s2.getText().isEmpty()||j5s1.getText().isEmpty()||j5s2.getText().isEmpty()||j6s1.getText().isEmpty()
            ||j6s2.getText().isEmpty()||j7s1.getText().isEmpty()||j7s2.getText().isEmpty()||j8s1.getText().isEmpty()||j8s2.getText().isEmpty()||j9s1.getText().isEmpty()
            ||j9s2.getText().isEmpty()||j10s1.getText().isEmpty()||j10s2.getText().isEmpty()||j2s1.getText().isEmpty()||j2s3.getText().isEmpty()||j3s3.getText().isEmpty()
            ||j4s3.getText().isEmpty()||j5s3.getText().isEmpty()||j6s3.getText().isEmpty()||j7s3.getText().isEmpty()||j8s3.getText().isEmpty()||j9s3.getText().isEmpty()||j10s3.getText().isEmpty()|nbre.getText().isEmpty()
           )
                {   Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("erreur de remplissage");
                    alert.setContentText(" veuillez remplir tous les champs ,s'il n'y a pas des Séance à  saisir vous devez mettre des espaces dans les champs correspondants");
                    alert.showAndWait();
                }
        else{
            planning.setNomcomplt(nc.getText());
            planning.setJ1s1(j1s1.getText());
            planning.setJ1s2(j1s2.getText());
            planning.setJ1s3(j1s3.getText());
            planning.setJ2s1(j2s1.getText());
            planning.setJ2s2(j2s2.getText());
            planning.setJ2s3(j2s3.getText());
            planning.setJ3s1(j3s1.getText());
            planning.setJ3s2(j3s2.getText());
            planning.setJ3s3(j3s3.getText());
            planning.setJ4s1(j4s1.getText());
            planning.setJ4s2(j4s2.getText());
            planning.setJ4s3(j4s3.getText());
            planning.setJ5s1(j5s1.getText());
            planning.setJ5s2(j5s2.getText());
            planning.setJ5s3(j5s3.getText());
            planning.setJ6s1(j6s1.getText());
            planning.setJ6s2(j6s2.getText());
            planning.setJ6s3(j6s3.getText());
            planning.setJ7s1(j7s1.getText());
            planning.setJ7s2(j7s2.getText());
            planning.setJ7s3(j7s3.getText());
            planning.setJ8s1(j8s1.getText());
            planning.setJ8s2(j8s2.getText());
            planning.setJ8s3(j8s3.getText());
            planning.setJ9s1(j9s1.getText());
            planning.setJ9s2(j9s2.getText());
            planning.setJ9s3(j9s3.getText());
            planning.setJ10s1(j10s1.getText());
            planning.setJ10s2(j10s2.getText());
            planning.setJ10s3(j10s3.getText());
            planning.setNbre(nbre.getText());
            
            em.getTransaction().begin();
            em.persist(planning);
            em.getTransaction().commit();
            em.close();
            quitter(event);
        
    }
    }
    private Connection connection;
    private dbconnect handler;
    private PreparedStatement pst;  
    ResultSet rs;
    public static EntityManagerFactory emf;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         handler = new dbconnect();
          em = PlanningController.emf.createEntityManager();
        
    }    
    private  boolean  formtemps()
    {
        if( (J1.getText().length()<16|J1.getText().length()<19|J1.getText().length()<17)&&(J2.getText().length()<16|J2.getText().length()<19|J2.getText().length()<17)&&(J3.getText().length()<16|J3.getText().length()<19|J3.getText().length()<17)
            &&(J4.getText().length()<16|J4.getText().length()<19|J4.getText().length()<17)&&(J5.getText().length()<16|J5.getText().length()<19|J5.getText().length()<17)&&(J6.getText().length()<16|J6.getText().length()<19|J6.getText().length()<17)
            &&(J7.getText().length()<16|J7.getText().length()<19|J7.getText().length()<17)&&(J8.getText().length()<16|J8.getText().length()<19|J8.getText().length()<17)&&(J9.getText().length()<16|J9.getText().length()<19|J9.getText().length()<17)
            &&J10.getText().length()<16|J10.getText().length()<19|J10.getText().length()<17 )
    
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
     if( (J1.getText().length()<16|J1.getText().length()<19|J1.getText().length()<17)&&(J2.getText().length()<16|J2.getText().length()<19|J2.getText().length()<17)&&(J3.getText().length()<16|J3.getText().length()<19|J3.getText().length()<17)
            &&(J4.getText().length()<16|J4.getText().length()<19|J4.getText().length()<17)&&(J5.getText().length()<16|J5.getText().length()<19|J5.getText().length()<17)&&(J6.getText().length()<16|J6.getText().length()<19|J6.getText().length()<17)
            &&(J7.getText().length()<16|J7.getText().length()<19|J7.getText().length()<17)&&(J8.getText().length()<16|J8.getText().length()<19|J8.getText().length()<17)&&(J9.getText().length()<16|J9.getText().length()<19|J9.getText().length()<17)
            &&(J10.getText().length()<16|J10.getText().length()<19|J10.getText().length()<17) )
    
                {   Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("erreur de remplissage");
                    alert.setContentText(" pour bien génerer le planning il faut entre sous form Jour jj/mm/aaaa");
                    alert.showAndWait();
                }else{        try
        {   
            String insert = "INSERT INTO planning VALUES ("+1+",' ','"+J1.getText()+"','"+J1.getText()+"','"+J1.getText()+"','"+J2.getText()+"','"+J2.getText()+"','"+J2.getText()+"','"+J3.getText()+"','"+J3.getText()+"','"+J3.getText()+"','"+J4.getText()+"','"+J4.getText()+"','"+J4.getText()+"','"+J5.getText()+"','"+J5.getText()+"','"+J5.getText()+"','"+J6.getText()+"','"+J6.getText()+"','"+J6.getText()+"','"+J7.getText()+"','"+J7.getText()+"','"+J7.getText()+"','"+J8.getText()+"','"+J8.getText()+"','"+J8.getText()+"','"+J9.getText()+"','"+J9.getText()+"','"+J9.getText()+"','"+J10.getText()+"','"+J10.getText()+"','"+J10.getText()+"',' ')";
       
            pst = connection.prepareStatement(insert);
                           int executeUpdate = pst.executeUpdate();
  
           
        }
        catch (SQLException e1)
            {
                e1.printStackTrace();
            }
        annuler(event);
        } 
        
    }


    @FXML
    private void annuler(ActionEvent event) {
         Node node = (Node) event.getSource();
         Stage stage =(Stage)node.getScene().getWindow();
         stage.close();
    }
    

}
