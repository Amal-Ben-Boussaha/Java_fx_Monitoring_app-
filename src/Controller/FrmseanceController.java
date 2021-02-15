package Controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

public class FrmseanceController implements Initializable {
private Connection connection;
    private dbconnect handler;
    private PreparedStatement pst;  
    EntityManager em;  
    SeancExamen seancexamen;
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
    private TextField nomsea;
    @FXML
    private TextField horaire_txt;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        em = SeanceController.emf.createEntityManager();
        handler = new dbconnect();
    }    
    private  boolean  formtemps()
    { int i= horaire_txt.getText().indexOf(":");
    if( i!=2)
                {   Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("erreur de remplissage");
                    alert.setContentText("le format hh:mm");
                    alert.showAndWait();
                    return false;
        
                    }
    return true;

    }
    private boolean empty()
    {

    if(nomsea.getText().isEmpty()|horaire_txt.getText().isEmpty())
                {   Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("erreur de remplissage");
                    alert.setContentText("Veuillez remplir ce champ");
                    alert.showAndWait();
                    return false;
        
                    }
    return true;

}
    public void setenseignant(int idseance) {
        Query q = em.createQuery("SELECT s FROM SeancExamen s WHERE s.idseance = :idseance");
        q.setParameter("idseance", new Integer(idseance));
        seancexamen = (SeancExamen) q.getSingleResult();
        nomsea.setText(seancexamen.getNomseance());
        horaire_txt.setText(seancexamen.getHoraireseance());
        editmode = true;
    
    }

    @FXML
    private void enrgistrer(ActionEvent event) {
        if (!editmode) {
        seancexamen =  new SeancExamen();
        }
        if(empty()&&formtemps())
        {
            seancexamen.setNomseance(nomsea.getText());
            seancexamen.setHoraireseance(horaire_txt.getText());
            em.getTransaction().begin();
            em.persist(seancexamen);
            em.getTransaction().commit();
            em.close();
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
