package Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Salle_examenController implements Initializable {

        @FXML
    private TableView<Sallefx> tabclasse;

    @FXML
    private TableColumn<Sallefx,Number> id;

    @FXML
    private TableColumn<Sallefx, String> nom_sal;

    @FXML
    private TableColumn<Sallefx,String> cap_salle;
    @FXML
    private TableColumn<Sallefx,String> nfac;
    @FXML
    private TextField chema;

     EntityManager em;  
    ObservableList<Sallefx> data;
    private Connection connection;
    private dbconnect handler;
    private PreparedStatement pst;  
    
    @FXML
    void importation(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter( "Fichier Microsoft Excel","*.csv"));
        File f = fc.showOpenDialog(null);
        if(f != null)
        {
            chema.setText(f.getAbsolutePath());
        }
    
    }
    private int    autoincrtID()
        { 
            int id = 1;
        try {
            pst = connection.prepareStatement("SELECT max(idsalle) FROM salle");
            ResultSet rs = pst.executeQuery();
            while(rs.next())
            {
                id=rs.getInt(1);
             System.out.println(id);
            }
        
        
        } catch (SQLException ex) {
            Logger.getLogger(ParamController.class.getName()).log(Level.SEVERE, null, ex);
        }
 
 return id;
 
 }
    @FXML
    void ouvrire(ActionEvent event) throws IOException {
        connection = handler.getConnection();
       try
        {   
            String line;
            int i =autoincrtID();        
            BufferedReader br = new BufferedReader(new FileReader(chema.getText()));
            while((line = br.readLine())!=null)
            {
                i+=1; 
                String []value =line.split(",");
                    for(String item : value)
                    {
                        System.out.print(item);
                        System.out.println(i);
                    }
                    
                    String sql="INSERT INTO salle VALUES ("+i+",'"+value[0]+"',"+value[1]+","+value[2]+")";
                    pst = connection.prepareStatement(sql);
                    pst.execute();
        
            }
        
    }
         catch(SQLException |FileNotFoundException e)
            {  
                e.printStackTrace();
            }finally 
        {
                try{
                      connection.close();
                      
                   }catch(SQLException e1)
                    {   
                        e1.printStackTrace();
                    
                    }
        }
    }
        
    @FXML
    void affichier(ActionEvent event) {
    actualiser();
    }

    @FXML
    void ajouter(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/classForm.fxml"));
        AnchorPane  mainPane = (AnchorPane)loader.load();
        Scene scene = new Scene(mainPane);
        stage.setTitle("Ajouter Nouvelle Salle");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        ClassFormController ctrl = loader.getController();
        stage.showAndWait();
        actualiser();
    }

    @FXML
    void modifier(ActionEvent event) throws IOException {
        int row =tabclasse.getSelectionModel().getSelectedIndex();
        if(row <0)return; 
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/classForm.fxml"));
        AnchorPane  mainPane = (AnchorPane)loader.load();
        Scene scene = new Scene(mainPane);
        stage.setTitle("Modifier Activite");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        ClassFormController ctrl = loader.getController();
        ctrl.setactivite(data.get(row).getIdsalle());
        stage.showAndWait();
        actualiser();
    }

    @FXML
    void supprimer(ActionEvent event) {
        int row =tabclasse.getSelectionModel().getSelectedIndex();
        if(row <0)return;
        Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
        alert.setTitle("Conformation de suppression");
        alert.setHeaderText(null);
        alert.setContentText("Vous etes sure?");
        Optional <ButtonType>action = alert.showAndWait();
        
        if(action.get()==ButtonType.OK){
            
        
        em = Salle_examenController.emf.createEntityManager();
        Query q =em.createQuery("SELECT s FROM Salle s WHERE s.idsalle = :idsalle");
        q.setParameter("idsalle", data.get(row).getIdsalle());
        Salle s =  (Salle) q.getSingleResult();
        em.getTransaction().begin();
        em.remove(s);
        em.getTransaction().commit();
        em.close();
        actualiser();

    }}
    
    public void actualiser()
    {
        emf=Persistence.createEntityManagerFactory("ESENPU");
        em = Salle_examenController.emf.createEntityManager();
        em = Salle_examenController.emf.createEntityManager();
        tabclasse.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        List<Salle>lst = em.createQuery("SELECT s FROM Salle s").getResultList();
        data=FXCollections.observableArrayList();
        for(Salle lste:lst){
        data.add(new Sallefx(lste.getIdsalle(),lste.getNomSalle(),lste.getCapacite(),lste.getNomfac()));
        }
        tabclasse.setItems(data);
        id.setCellValueFactory(cell->cell.getValue().getIdsalleProperty());
        nom_sal.setCellValueFactory(cell->cell.getValue().getNomSalleProperty());
        cap_salle.setCellValueFactory(cell->cell.getValue().getCapaciteProperty());
        nfac.setCellValueFactory(cell->cell.getValue().getNomfacProperty());
    
    
    }
    public static EntityManagerFactory emf;
        @Override

    public void initialize(URL url, ResourceBundle rb) {
               handler = new dbconnect();
        emf=Persistence.createEntityManagerFactory("ESENPU");
        em = Salle_examenController.emf.createEntityManager();
        
    }    
   


}
