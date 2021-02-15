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
import javax.persistence.Query;

/**
 * FXML Controller class
 *
 * @author Amal Ben Boussaha
 */
public class FrmulairEnsController implements Initializable {

    @FXML
    private TextField nome;
    @FXML
    private TextField grdv;
    EntityManager em;
    Enseignant enseignant;
    boolean editmode = false;
    double x= 0,y =0;
    private Connection connection;
    private dbconnect handler;
    private PreparedStatement pst;  
    private ResultSet rs;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                em = EnseignantsController.emf.createEntityManager();
                 handler = new dbconnect();

    }    
    public void setenseignant(int id) {
        Query q = em.createQuery("SELECT e FROM Enseignant e WHERE e.id = :id");
        q.setParameter("id", new Integer(id));
        enseignant = (Enseignant) q.getSingleResult();
        nome.setText(enseignant.getNomcomplt());
        grdv.setText(enseignant.getGrade());
        editmode = true;
    
    }
    private boolean verifier()
 {        connection = handler.getConnection();

        try {
            pst = connection.prepareStatement("SELECT nomgrade FROM grade where nomgrade='"+grdv.getText()+"'");
             rs = pst.executeQuery();
            int count = 0;
                   while(rs.next())
                   {
                        count = count+1;
                    }
                    if(count ==0)
                   {
                     Alert alert = new Alert(Alert.AlertType.ERROR);
                       alert.setHeaderText(null);
                       alert.setContentText("Ce grade n'existe pas dans la liste des grade"+ grdv.getText());
                       alert.show();
                       return false;
                       
                   }
                                    
            }catch(SQLException e1)
                {
                    e1.printStackTrace();
 
                }
            return true;
    
 }
    @FXML
    private void ajouter(ActionEvent event) {
        if (!editmode) {
            enseignant = new Enseignant();
        }
        if(nome.getText().isEmpty() | grdv.getText().isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("erreur de remplissage");
            alert.setContentText("Veuillez remplir ce champ");
            alert.showAndWait();
        }
        else if(verifier())
        {
            enseignant.setNomcomplt(nome.getText());
            enseignant.setGrade(grdv.getText());
            em.getTransaction().begin();
            em.persist(enseignant);
            em.getTransaction().commit();
            em.close();
            quitter(event);
        }
    
    }

    @FXML
    private void quitter(ActionEvent event) {
    Node node = (Node) event.getSource();
    Stage stage =(Stage)node.getScene().getWindow();
    stage.close();


    }

    @FXML
    private void dragged(MouseEvent event) {
    Node node = (Node) event.getSource();
                Stage stage =(Stage)node.getScene().getWindow();
        stage.setX(event.getScreenX() -x);
        stage.setY(event.getScreenY() -y);
    
    }

    @FXML
    private void pressed(MouseEvent event) {
        x=event.getSceneX();
        y=event.getSceneY();
    
    }
    
}
