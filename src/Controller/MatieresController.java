package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * FXML Controller class
 *
 * @author Amal Ben Boussaha
 */
public class MatieresController implements Initializable {

  @FXML
    private TableView<Matifx> table_materes;

    @FXML
    private TableColumn<Matifx, Number> id;

    @FXML
    private TableColumn<Matifx, String> classe;

    @FXML
    private TableColumn<Matifx, String> materes;
    @FXML
    private TextField cl;
   @FXML
    void recherche(KeyEvent event) {
        connection = handler.getConnection();
        
        if( event.getCode()==KeyCode.ENTER)
       {
           cl.textProperty().addListener((observable,oldvalue,newvalue)->{
           
           
           });
       }
    }
    
   private Connection connection;
    private dbconnect handler;
    private PreparedStatement pst; 
    private ResultSet rs;
    EntityManager em;  
    ObservableList <Matifx> data;
   
    @FXML
    void exporation(ActionEvent event){
       connection = handler.getConnection();
        Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
        alert.setTitle("Conformation de suppression");
        alert.setHeaderText(null);
        alert.setContentText("veuillez vérifier si les activités de l'enseignant sont bien modifiés ,s'ils ne sont pas modifiés,vous devez les modifier avant");
        Optional <ButtonType>action = alert.showAndWait();
        
        if(action.get()==ButtonType.OK){
        try
        { 
                String insert ="INSERT INTO mati (idM,classe,examen)\n" +
                               " SELECT id, apprenant,matere FROM actitvite;";
                pst = connection.prepareStatement(insert);
        
                pst.execute();
         
                }
        catch (SQLException e1)
             {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erreur de parametrage");
                    alert.setContentText("vous avez déja importé la liste des matières, cliquez sur afficher pour consulter la liste");
                    alert.showAndWait();
             
             }
        finally 
        {
                try{
                      connection.close();
                      
                   }catch(SQLException e1)
                    {
                        e1.printStackTrace();
                    
                    }
        }
    
            
             
            }
    }
    @FXML
    void ajouter(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/MatieresFrm.fxml"));
        AnchorPane  mainPane = (AnchorPane)loader.load();
        Scene scene = new Scene(mainPane);
        stage.setTitle("Ajouter Nouvelle Activite");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        MatieresFrmController ctrl = loader.getController();
        stage.showAndWait();
        actualiser();
    }

    @FXML
    void modifier(ActionEvent event) throws IOException {
        int row =table_materes.getSelectionModel().getSelectedIndex();
        if(row <0)return; 
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/MatieresFrm.fxml"));
        AnchorPane  mainPane = (AnchorPane)loader.load();
        Scene scene = new Scene(mainPane);
        stage.setTitle("Modifier Activite");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        MatieresFrmController ctrl = loader.getController();
        ctrl.setdispt(data.get(row).getIdM());
        stage.showAndWait();
        actualiser();
    
    }

    @FXML
    void supprimer(ActionEvent event) {
        int row =table_materes.getSelectionModel().getSelectedIndex();
        if(row <0)return;
        Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
        alert.setTitle("Conformation de suppression");
        alert.setHeaderText(null);
        alert.setContentText("Vous etes sure?");
        Optional <ButtonType>action = alert.showAndWait();
        
        if(action.get()==ButtonType.OK){
            
        
        em = MatieresController.emf.createEntityManager();
        Query q =em.createQuery("SELECT m FROM Mati m WHERE m.idM = :idM");
        q.setParameter("idM", data.get(row).getIdM());
        Mati m =  (Mati) q.getSingleResult();
        em.getTransaction().begin();
        em.remove(m);
        em.getTransaction().commit();
        em.close();
        actualiser();
    }}
  public static EntityManagerFactory emf;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        handler = new dbconnect();
         emf=Persistence.createEntityManagerFactory("ESENPU");
         em = emf.createEntityManager();
         em = MatieresController.emf.createEntityManager();

        }   
      @FXML
    void afficher(ActionEvent event) {
        actualiser();
    }

    private void actualiser()
    {
        emf=Persistence.createEntityManagerFactory("ESENPU");
         em = emf.createEntityManager();
         em = MatieresController.emf.createEntityManager();

         em = MatieresController.emf.createEntityManager();
        table_materes.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        List<Mati>lst = em.createQuery("SELECT m FROM Mati m").getResultList();
        data=FXCollections.observableArrayList();
        for(Mati lste:lst)
            {
            data.add(new Matifx(lste.getIdM(),lste.getClasse(),lste.getExamen()));
            }
        table_materes.setItems(data);
        id.setCellValueFactory(cell->cell.getValue().getIdMProperty());
        classe.setCellValueFactory(cell->cell.getValue().getClasseProperty());
        materes.setCellValueFactory(cell->cell.getValue().getExamenProperty());
        }
    private int   minID()
        { 
            int idmin = 1;
        try {
            pst = connection.prepareStatement("SELECT min(idM) FROM mati");
            rs = pst.executeQuery();
            while(rs.next())
            {
                idmin=rs.getInt(1);
             }
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
 
 return idmin;
 }
    private int   maxID()
        { 
            int idm=1;
        try {
            pst = connection.prepareStatement("SELECT max(idM) FROM mati");
            rs = pst.executeQuery();
            while(rs.next())
            {
                idm=rs.getInt(1);
             }
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
 
 return idm;
 }
    @FXML
    void vider(ActionEvent event) {
        connection = handler.getConnection();
        int i=minID(),j=maxID();
        Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
        alert.setTitle("Conformation de suppression");
        alert.setHeaderText(null);
        alert.setContentText("Attention!! si vous aves clique Qui tout les contunu sera supprimer!!");
        Optional <ButtonType>action = alert.showAndWait();
        if(action.get()==ButtonType.OK){
            alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Notification");
                    alert.setContentText("Veuillez Vous Attende Quelque Seconde");
                    alert.showAndWait();
        
            
        while(i<=j)
        {
        try{
        String sql ="delete from mati where idM="+i+"";
        pst = connection.prepareStatement(sql);
        pst.executeUpdate();
        }
        catch (SQLException e1)
            {
                e1.printStackTrace();
            
            }        
i++;
        }
        }actualiser();
   
    } 
    
}
