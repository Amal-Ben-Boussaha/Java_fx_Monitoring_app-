package Controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
public class Cal3ecomController implements Initializable {
    
    @FXML
    private TableView<Ecom3fx> ecom3;

    @FXML
    private TableColumn<Ecom3fx, Number> id;

    @FXML
    private TableColumn<Ecom3fx, String> jour;

    @FXML
    private TableColumn<Ecom3fx, String> date;

    @FXML
    private TableColumn<Ecom3fx, String> matieres;

    @FXML
    private TableColumn<Ecom3fx, String> horaire;

    @FXML
    private TableColumn<Ecom3fx, String> duree;

    @FXML
    private TableColumn<Ecom3fx, String> g1;

    @FXML
    private TableColumn<Ecom3fx, String> salle_g1;

    @FXML
    private TableColumn<Ecom3fx, String> g2;

    @FXML
    private TableColumn<Ecom3fx, String> salle_g2;
    public static EntityManagerFactory emf;
    private Connection connection;
    private dbconnect handler;
    private PreparedStatement pst;  
    private ResultSet rs;
    EntityManager em;  
    ObservableList<Ecom3fx> data;

    @FXML
    void ajouter(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/Frmcal3ecom.fxml"));
        AnchorPane  mainPane = (AnchorPane)loader.load();
        Scene scene = new Scene(mainPane);
        stage.setTitle("Ajouter Nouvelle Examen");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        Frmcal3ecomController ctrl = loader.getController();
        stage.showAndWait();
        actualiser();
    }
    private int entrejour()
    {
        int i=0;
           try {
            pst = connection.prepareStatement("SELECT count(idecom3) FROM ecom3");
            rs = pst.executeQuery();
            while(rs.next())
            {
                i=rs.getInt(1);
             System.out.println(id);
            }
        
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return i;
    }


    @FXML
    void imprimer(ActionEvent event) throws SQLException, FileNotFoundException, DocumentException {
        actualiser();
        connection = handler.getConnection();
        int k=entrejour();
        int rowno=0;
        rs=pst.executeQuery("SELECT * FROM ecom3");
        ResultSetMetaData rsmd =rs.getMetaData();
        int colnc=rsmd.getColumnCount();
        while(rs.next())
         {
            rowno = rowno+1;
         }
        rs.first();
        Document d = new Document();
        PdfWriter.getInstance(d,new FileOutputStream ("3Ecom.pdf"));
        PdfPTable pt = new PdfPTable(colnc);
        d.open();
        d.add(new Paragraph("Calendrier Des examen"));
        d.add(new Paragraph("    3Ecom  "));
        d.add(new Paragraph("  "));
        d.add(new Paragraph("  "));

        for(int i=0;i<rowno;i++)
        {
        pt.addCell(""+rs.getString(1));
        pt.addCell(""+rs.getString(2));
        pt.addCell(""+rs.getString(3));
        pt.addCell(""+rs.getString(4));
        pt.addCell(""+rs.getString(5));
        pt.addCell(""+rs.getString(6));
        pt.addCell(""+rs.getString(7));
        pt.addCell(""+rs.getString(8));
        pt.addCell(""+rs.getString(9));
        pt.addCell(""+rs.getString(10));
        rs.next();
        }
        d.add(pt);
        d.close();
    }

    @FXML
    void modifier(ActionEvent event) throws IOException {
        int row =ecom3.getSelectionModel().getSelectedIndex();
        if(row <0)return; 
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/Frmcal3ecom.fxml"));
        AnchorPane  mainPane = (AnchorPane)loader.load();
        Scene scene = new Scene(mainPane);
        stage.setTitle("Ajouter Nouvelle Matiéres");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        Frmcal3ecomController ctrl = loader.getController();
        ctrl.setEcom(data.get(row).getIdecom3());
        stage.showAndWait();
        actualiser();
        
    }

    @FXML
    void supprimer(ActionEvent event) 
    {
         int row =ecom3.getSelectionModel().getSelectedIndex();
        if(row <0)return;
        Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
        alert.setTitle("Conformation de suppression");
        alert.setHeaderText(null);
        alert.setContentText("Vous etes sure?");
        Optional <ButtonType>action = alert.showAndWait();
        
        if(action.get()==ButtonType.OK){
       
        em = Cal3ecomController.emf.createEntityManager();
        Query q =em.createQuery("SELECT e FROM Ecom3 e WHERE e.idecom3 = :idecom3");
        q.setParameter("idecom3", data.get(row).getIdecom3());
        Ecom3 E = (Ecom3) q.getSingleResult();
        em.getTransaction().begin();
        em.remove(E);
        em.getTransaction().commit();
        em.close();
        actualiser();
    }
    }
    private void actualiser()
    {
        emf=Persistence.createEntityManagerFactory("ESENPU");
        em = Cal3ecomController.emf.createEntityManager();
        emf=Persistence.createEntityManagerFactory("ESENPU");
        ecom3.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
                
        List<Ecom3>lst = em.createQuery("SELECT e FROM Ecom3 e").getResultList();
        
        data=FXCollections.observableArrayList();
        for(Ecom3 lst1:lst){
           
        data.add(new Ecom3fx(lst1.getIdecom3(),lst1.getJourEcom(),lst1.getDateEcom(),lst1.getMatieresEcom(),lst1.getHoraireEcom(),lst1.getDureeEcom(),lst1.getGroupe1Ecom(),lst1.getSalleG1Ecom(),lst1.getGroupe2(),lst1.getSalleG2Ecom()));
        }
        ecom3.setItems(data);
        id.setCellValueFactory(cell->cell.getValue().getIdecom3Property());
        jour.setCellValueFactory(cell->cell.getValue().getJourEcomProperty());
        date.setCellValueFactory(cell->cell.getValue().getDateEcomProperty());
        matieres.setCellValueFactory(cell->cell.getValue().getMatieresEcomProperty());
        horaire.setCellValueFactory(cell->cell.getValue().getHoraireEcomProperty());
        duree.setCellValueFactory(cell->cell.getValue().getDureeEcomProperty());  
        g1.setCellValueFactory(cell->cell.getValue().getGroupe1EcomProperty());
       salle_g1.setCellValueFactory(cell->cell.getValue().getSalleG1EcomProperty());
       g2.setCellValueFactory(cell->cell.getValue().getGroupe2Property());
       salle_g2.setCellValueFactory(cell->cell.getValue().getSalleG2EcomProperty()); 
    
    }
    private int   minID()
        { 
            int idmin = 1;
        try {
            pst = connection.prepareStatement("SELECT min(idecom3) FROM ecom3");
            ResultSet rs = pst.executeQuery();
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
            pst = connection.prepareStatement("SELECT max(idecom3) FROM ecom3");
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
        alert.setContentText("Attention!! si vous allez cliquer oui tout le contenu sera supprimé");
        Optional <ButtonType>action = alert.showAndWait();
        if(action.get()==ButtonType.OK){
            alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Notification");
                    alert.setContentText("Veuillez attendre quelques secondes");
                    alert.showAndWait();
        
            
        while(i<=j)
        {
        try{
        String sql ="delete from ecom3 where idecom3="+i+"";
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         handler = new dbconnect();
        actualiser();
        
    }    
    
}
