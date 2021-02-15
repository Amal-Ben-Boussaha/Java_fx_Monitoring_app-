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
public class FrmGrdController implements Initializable {
    EntityManager em;  
    Grade grade;
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
    private TextField ngrade;

    @FXML
    private TextField msgrade;

    @FXML
    private TextField nsm;

    private boolean empty()
    {

    if(ngrade.getText().isEmpty()|msgrade.getText().isEmpty()|nsm.getText().isEmpty())
                {   Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("erreur de remplissage");
                    alert.setContentText("Veuillez remplir ce champ");
                    alert.showAndWait();
                    return false;
        
                    }
    return true;

}
    public void setenseignant(int idgrade) {
        Query q = em.createQuery("SELECT g FROM Grade g WHERE g.idgrade = :idgrade");
        q.setParameter("idgrade", new Integer(idgrade));
        grade = (Grade) q.getSingleResult();
        ngrade.setText(grade.getNomgrade());
        msgrade.setText(grade.getNbseancemax());
        nsm.setText(grade.getNbseancemin());
        editmode = true;
    
    }

    
    @FXML
    void annuler(ActionEvent event) {
            Node node = (Node) event.getSource();
            Stage stage =(Stage)node.getScene().getWindow();
            stage.close();

    }

    @FXML
    void enregistrer(ActionEvent event) {
        if (!editmode) {
        grade = new Grade();
        }
        if(empty())
        {
            grade.setNomgrade(ngrade.getText());
            grade.setNbseancemax(msgrade.getText());
            grade.setNbseancemin(nsm.getText());
            em.getTransaction().begin();
            em.persist(grade);
            em.getTransaction().commit();
            em.close();
            annuler(event);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        em = GrdEnsegController.emf.createEntityManager();
        
    }    
}
