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
public class FormDispController implements Initializable {

     @FXML
    private TextField act;

    @FXML
    private TextField jour;

    @FXML
    private TextField heure;

    @FXML
    private TextField classe;

    @FXML
    private TextField mat;

    @FXML
    private TextField ensg;

    @FXML
    private TextField code;

    @FXML
    private TextField salle;

    @FXML
    private TextField comm;
    EntityManager em;
    Disponibilites disponibilites;
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

    public void setdisp(int iddisponibilites) {
        Query q = em.createQuery("SELECT d FROM Disponibilites d WHERE d.iddisponibilites = :iddisponibilites");
        q.setParameter("iddisponibilites", new Integer(iddisponibilites));
        disponibilites = (Disponibilites) q.getSingleResult();
        act.setText(disponibilites.getIdactivites());
        jour.setText(disponibilites.getDay());
        heure.setText(disponibilites.getHour());
        classe.setText(disponibilites.getClasse());
        mat.setText(disponibilites.getSubject());
        ensg.setText(disponibilites.getTeachers());
        code.setText(disponibilites.getActivitestages());
        salle.setText(disponibilites.getRom());
        comm.setText(disponibilites.getCommentaire());
        editmode = true;
        

    }

    @FXML
    void annulation(ActionEvent event) {
        Node node = (Node) event.getSource();
                Stage stage =(Stage)node.getScene().getWindow();
                stage.close();
}

    @FXML
    void insertion(ActionEvent event) {
        if (!editmode) {
            disponibilites = new Disponibilites();
        }
        if(act.getText().isEmpty()|jour.getText().isEmpty()|heure.getText().isEmpty()|classe.getText().isEmpty()|mat.getText().isEmpty()|ensg.getText().isEmpty()|code.getText().isEmpty()|salle.getText().isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("erreur de remplissage");
            alert.setContentText("Veuillez remplir ce champ");
            alert.showAndWait();
        }else{
        disponibilites.setIdactivites(act.getText());
        disponibilites.setDay(jour.getText());
        disponibilites.setHour(heure.getText()); 
        disponibilites.setSubject(classe.getText()); 
        disponibilites.setSubject(mat.getText()); 
        disponibilites.setTeachers(ensg.getText()); 
        disponibilites.setActivitestages(code.getText()); 
        disponibilites.setRom(salle.getText());  
        disponibilites.setClasse(comm.getText()); 
        em.getTransaction().begin();
        em.persist(disponibilites);
        em.getTransaction().commit();
        em.close();
        annulation(event);
    }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      em = DisponibilitesController.emf.createEntityManager();
    }    
    
    
}
