/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
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
public class ActiviteFormController implements Initializable {

double x=0, y=0;
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
    private TextField etudent;
    @FXML
    private TextField matere;
    @FXML
    private TextField prof;
    @FXML
    private TextField duree;
    EntityManager em;
    Actitvite activite;
    boolean editmode = false;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    em = ParamController.emf.createEntityManager();
    }    
    public void setactivite(int id) {
        Query q = em.createQuery("SELECT a FROM Actitvite a WHERE a.id = :id");
        q.setParameter("id", new Integer(id));
        activite =  (Actitvite) q.getSingleResult();
        etudent.setText(activite.getApprenant());
        matere.setText(activite.getMatere());
        prof.setText(activite.getProf());
        duree.setText(activite.getDuree());
        editmode = true;
    }

    @FXML
    private void reglage(ActionEvent event) {
        if (!editmode) {
            activite = new Actitvite();
        }if(etudent.getText().isEmpty()|matere.getText().isEmpty()|prof.getText().isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("erreur de remplissage");
            alert.setContentText("Veuillez remplir ce champ");
            alert.showAndWait();
        }
        else{
        activite.setApprenant(etudent.getText());
        activite.setMatere(matere.getText());
        activite.setProf(prof.getText());
        activite.setDuree(duree.getText());
        em.getTransaction().begin();
        em.persist(activite);
        em.getTransaction().commit();
        em.close();

    }
    }
    @FXML
    private void annulation(ActionEvent event) {
        Node node = (Node) event.getSource();
                Stage stage =(Stage)node.getScene().getWindow();
                stage.close();

    }
    
}
