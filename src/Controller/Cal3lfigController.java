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
public class Cal3lfigController implements Initializable {
@FXML
    private TableView<Lfig3fx> lfig3;

    @FXML
    private TableColumn<Lfig3fx, Number> id;

    @FXML
    private TableColumn<Lfig3fx, String> jour;

    @FXML
    private TableColumn<Lfig3fx, String> date;

    @FXML
    private TableColumn<Lfig3fx, String> matieres;

    @FXML
    private TableColumn<Lfig3fx, String> horaire;

    @FXML
    private TableColumn<Lfig3fx, String> duree;

    @FXML
    private TableColumn<Lfig3fx, String> g1;

    @FXML
    private TableColumn<Lfig3fx, String> salle_g1;

    @FXML
    private TableColumn<Lfig3fx, String> g2;

    @FXML
    private TableColumn<Lfig3fx, String> salle_g2;
    public static EntityManagerFactory emf;
    private Connection connection;
    private dbconnect handler;
    private PreparedStatement pst;  
    private ResultSet rs;
    EntityManager em;  
    ObservableList<Lfig3fx> data;

    @FXML
    void ajouter(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/Frmcal3lfig.fxml"));
        AnchorPane  mainPane = (AnchorPane)loader.load();
        Scene scene = new Scene(mainPane);
        stage.setTitle("Ajouter Nouvelle Examen");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        Frmcal3lfigController ctrl = loader.getController();
        stage.showAndWait();
        actualiser();
    }
    private int entrejour()
    {
        int i=0;
           try {
            pst = connection.prepareStatement("SELECT count(idlfig3) FROM lfig3");
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
        rs=pst.executeQuery("SELECT * FROM mecom2");
        ResultSetMetaData rsmd =rs.getMetaData();
        int colnc=rsmd.getColumnCount();
        while(rs.next())
         {
            rowno = rowno+1;
         }
        rs.first();
        Document d = new Document();
        PdfWriter.getInstance(d,new FileOutputStream ("3Lfig.pdf"));
        PdfPTable pt = new PdfPTable(colnc);
        d.open();
        d.add(new Paragraph("Calendrier Des examen"));
        d.add(new Paragraph("    3Lfig  "));
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
        int row =lfig3.getSelectionModel().getSelectedIndex();
        if(row <0)return; 
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/Frmcal3lfig.fxml"));
        AnchorPane  mainPane = (AnchorPane)loader.load();
        Scene scene = new Scene(mainPane);
        stage.setTitle("Ajouter Nouvelle Examen");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        Frmcal3lfigController ctrl = loader.getController();
        ctrl.setEcom(data.get(row).getIdlfig3());
        stage.showAndWait();
        actualiser();
        
    }

    @FXML
    void supprimer(ActionEvent event) 
    {
         int row =lfig3.getSelectionModel().getSelectedIndex();
        if(row <0)return;
        Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
        alert.setTitle("Conformation de suppression");
        alert.setHeaderText(null);
        alert.setContentText("Vous etes sure?");
        Optional <ButtonType>action = alert.showAndWait();
        
        if(action.get()==ButtonType.OK){
       
        em = Cal3lfigController.emf.createEntityManager();
        Query q =em.createQuery("SELECT l FROM Lfig3 l WHERE l.idlfig3 = :idlfig3");
        q.setParameter("idlfig3", data.get(row).getIdlfig3());
        Lfig3 E = (Lfig3) q.getSingleResult();
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
        em = Cal3lfigController.emf.createEntityManager();
        emf=Persistence.createEntityManagerFactory("ESENPU");
        lfig3.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
                
        List<Lfig3>lst = em.createQuery("SELECT l FROM Lfig3 l").getResultList();
        
        data=FXCollections.observableArrayList();
        for(Lfig3 lst1:lst){
           
        data.add(new Lfig3fx(lst1.getIdlfig3(),lst1.getJour(),lst1.getDate(),lst1.getMatieres(),lst1.getHoraire(),lst1.getDuree(),lst1.getGroupe1(),lst1.getSalleG1(),lst1.getGroupe2(),lst1.getSalleG2()));
        }
        lfig3.setItems(data);
        id.setCellValueFactory(cell->cell.getValue().getIdlfig3Property());
        jour.setCellValueFactory(cell->cell.getValue().getJourProperty());
        date.setCellValueFactory(cell->cell.getValue().getDateProperty());
        matieres.setCellValueFactory(cell->cell.getValue().getMatieresProperty());
        horaire.setCellValueFactory(cell->cell.getValue().getHoraireProperty());
        duree.setCellValueFactory(cell->cell.getValue().getDureeProperty());  
       g1.setCellValueFactory(cell->cell.getValue().getGroupe1Property());
       salle_g1.setCellValueFactory(cell->cell.getValue().getSalleG1Property());
       g2.setCellValueFactory(cell->cell.getValue().getGroupe2Property());
       salle_g2.setCellValueFactory(cell->cell.getValue().getSalleG2Property()); 
    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       handler = new dbconnect();
        actualiser();
    }   
    private int   minID()
        { 
            int idmin = 1;
        try {
            pst = connection.prepareStatement("SELECT min(idlfig3) FROM lfig3");
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
            pst = connection.prepareStatement("SELECT max(idlfig3) FROM lfig3");
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
        String sql ="delete from lfig3 where idlfig3="+i+"";
        pst = connection.prepareStatement(sql);
        pst.executeUpdate();
        }
        catch (SQLException e1)
            {e1.printStackTrace();}        
i++;}}actualiser();}
   
    
}
