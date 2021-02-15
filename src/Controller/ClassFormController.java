
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


public class ClassFormController implements Initializable {
 @FXML
    private TextField nom_sale;

    @FXML
    private TextField cap;
      @FXML
    private TextField nfac;
double x= 0, y=0;
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
    void annuler(ActionEvent event) {
         Node node = (Node) event.getSource();
                Stage stage =(Stage)node.getScene().getWindow();
                stage.close();

    }
    @FXML
    void insertion(ActionEvent event) {
  if (!editmode) {
            salle = new Salle();
        }
  if(nom_sale.getText().isEmpty()|cap.getText().isEmpty()|nfac.getText().isEmpty())
  {
      Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("erreur de remplissage");
                    alert.setContentText("Veuillez remplir ce champ");
                    alert.showAndWait();
  }
  else{
        salle.setNomSalle(nom_sale.getText());
        salle.setCapacite(cap.getText());
        salle.setNomfac(nfac.getText());
        em.getTransaction().begin();
        em.persist(salle);
        em.getTransaction().commit();
        em.close();
        annuler(event);
    
    }
    }
        EntityManager em;
    Salle salle;
    boolean editmode = false;
    
    public void setactivite(int idsalle) {
        Query q = em.createQuery("SELECT s FROM Salle s WHERE s.idsalle = :idsalle");
        q.setParameter("idsalle", new Integer(idsalle));
        salle =   (Salle) q.getSingleResult();
        nom_sale.setText(salle.getNomSalle());
        cap.setText(salle.getCapacite());
        nfac.setText(salle.getNomfac());
        editmode = true;
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         em = Salle_examenController.emf.createEntityManager();    }    
    
}
