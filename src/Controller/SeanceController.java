package Controller;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
public class SeanceController implements Initializable {
     @FXML
    private TableView<SeancExamenfx> seance;

    @FXML
    private TableColumn<SeancExamenfx, Number> id;

    @FXML
    private TableColumn<SeancExamenfx, String> nomseance;

    @FXML
    private TableColumn<SeancExamenfx, String> horaire;
    
    @FXML
    void modifier(ActionEvent event) throws IOException {
       int row =seance.getSelectionModel().getSelectedIndex();
        if(row <0)return; 
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/frmseance.fxml"));
        AnchorPane  mainPane = (AnchorPane)loader.load();
        Scene scene = new Scene(mainPane);
        stage.setTitle("Modifier Séance");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        FrmseanceController ctrl = loader.getController();
        ctrl.setenseignant(data.get(row).getIdseance());
        stage.showAndWait();
        actualiser();
    
    }

    @FXML
    void supprimer(ActionEvent event) {
            int row =seance.getSelectionModel().getSelectedIndex();
        if(row <0)return;
        Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
        alert.setTitle("Conformation de suppression");
        alert.setHeaderText(null);
        alert.setContentText("Vous etes sure?");
        Optional <ButtonType>action = alert.showAndWait();
        
        if(action.get()==ButtonType.OK){
            
        
        em = SeanceController.emf.createEntityManager();
        Query q =em.createQuery("SELECT s FROM SeancExamen s WHERE s.idseance = :idseance");
        q.setParameter("idseance", data.get(row).getIdseance());
        SeancExamen S = (SeancExamen) q.getSingleResult();
        em.getTransaction().begin();
        em.remove(S);
        em.getTransaction().commit();
        em.close();
        
        actualiser();
    
    }}

    @FXML
    void ajouter(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/frmseance.fxml"));
        AnchorPane  mainPane = (AnchorPane)loader.load();
        Scene scene = new Scene(mainPane);
        stage.setTitle("Ajouter Nouvelle Séance");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        FrmseanceController ctrl = loader.getController();
        stage.showAndWait();
        actualiser();
    
    }

    
    private Connection connection;
    private dbconnect handler;
    private PreparedStatement pst;  
    EntityManager em;  
    ObservableList<SeancExamenfx> data;
    public static EntityManagerFactory emf;
    SeancExamen seancexamen;
    boolean editmode = false;
    
    
private void actualiser()
{
    emf=Persistence.createEntityManagerFactory("ESENPU");
        em = SeanceController.emf.createEntityManager();
        emf=Persistence.createEntityManagerFactory("ESENPU");
        seance.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
                
        List<SeancExamen>lst = em.createQuery("SELECT s FROM SeancExamen s").getResultList();
        
        data=FXCollections.observableArrayList();
        for(SeancExamen lst1:lst){
           
        data.add(new SeancExamenfx(lst1.getIdseance(),lst1.getNomseance(),lst1.getHoraireseance()));
        }
        seance.setItems(data);
        id.setCellValueFactory(cell->cell.getValue().getIdseanceProperty());
        nomseance.setCellValueFactory(cell->cell.getValue().getNomseanceProperty());
        horaire.setCellValueFactory(cell->cell.getValue().getHoraireseanceProperty());


}
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        handler = new dbconnect();
        actualiser();
    }    
    
}
