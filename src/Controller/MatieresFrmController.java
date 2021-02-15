package Controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class MatieresFrmController implements Initializable {
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

    EntityManager em;
    Mati mati;
    boolean editmode = false;
     @FXML
    private TextField clas;

    @FXML
    private TextField mat;

    @FXML
    private TextField tyex;
    private Connection connection;
    private dbconnect handler;
    private PreparedStatement pst;  
    private ResultSet rs;
    
    @FXML
    void cancel(ActionEvent event) {
        Node node = (Node) event.getSource();
                Stage stage =(Stage)node.getScene().getWindow();
                stage.close();

    }

    @FXML
    void insert(ActionEvent event) {
        if (!editmode) {
         mati = new  Mati(); 
        }
        
        if(clas.getText().isEmpty() | mat.getText().isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("erreur de remplissage");
            alert.setContentText("Veuillez remplir ce champ");
            alert.showAndWait();
        }
        else 
        {
        mati.setClasse(clas.getText());
        mati.setExamen(mat.getText());
       
        em.getTransaction().begin();
        em.persist(mati);
        em.getTransaction().commit();
        em.close();
        cancel(event);

    }
    }

    public void setdispt(int idM) {
        Query q = em.createQuery("SELECT m FROM Mati m WHERE m.idM = :idM");
        q.setParameter("idM", new Integer(idM));
        mati =  (Mati) q.getSingleResult();
        clas.setText(mati.getClasse());
        mat.setText(mati.getExamen());
       
        editmode = true;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                em = MatieresController.emf.createEntityManager();
                handler = new dbconnect();
    }    
    
}