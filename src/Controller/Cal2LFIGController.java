package Controller;


import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
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
import java.util.Date;
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
public class Cal2LFIGController implements Initializable {

    @FXML
    private TableView<Lfig2fx> lfig2;

    @FXML
    private TableColumn<Lfig2fx, Number> id;

    @FXML
    private TableColumn<Lfig2fx, String> jour;

    @FXML
    private TableColumn<Lfig2fx, String> date;

    @FXML
    private TableColumn<Lfig2fx, String> matieres;

    @FXML
    private TableColumn<Lfig2fx, String> horaire;

    @FXML
    private TableColumn<Lfig2fx, String> duree;

    @FXML
    private TableColumn<Lfig2fx, String> g1;

    @FXML
    private TableColumn<Lfig2fx, String> salle_g1;

    @FXML
    private TableColumn<Lfig2fx, String> g2;

    @FXML
    private TableColumn<Lfig2fx, String> salle_g2;
    public static EntityManagerFactory emf;
    private Connection connection;
    private dbconnect handler;
    private PreparedStatement pst;  
    EntityManager em;  
    ObservableList<Lfig2fx> data;

    @FXML
    void ajouter(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/Frmcal2lfig.fxml"));
        AnchorPane  mainPane = (AnchorPane)loader.load();
        Scene scene = new Scene(mainPane);
        stage.setTitle("Ajouter Nouvelle Examen");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        Frmcal2lfigController ctrl = loader.getController();
        stage.showAndWait();
        actualiser();
    }
private int entrejour()
    {
        int i=0;
           try {
            pst = connection.prepareStatement("SELECT count(idlfig2) FROM lfig2");
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
    void imprimer(ActionEvent event) throws DocumentException, SQLException, FileNotFoundException {
        actualiser();
        connection = handler.getConnection();
        int s=entrejour();
        int rowno=0;
        rs=pst.executeQuery("SELECT * FROM lfig2");
        ResultSetMetaData rsmd =rs.getMetaData();
        int colnc=rsmd.getColumnCount();
        while(rs.next())
         {
            rowno = rowno+1;
         }
        rs.first();
        Document d = new Document(PageSize.B4.rotate());
        PdfWriter.getInstance(d,new FileOutputStream ("2LFIG.pdf"));
        PdfPTable pt = new PdfPTable(colnc);
        pt.setWidthPercentage(100);
        pt.setHorizontalAlignment(100);
        d.open();
        d.add(new Paragraph("       UNIVERSITE DE LA MANOUBA"));
         d.add(new Paragraph("ECOLE SUPERIEURE DE L’ECONOMIE NUMERIQUE"));
         d.add(new Paragraph("              Secrétariat général"));
        d.add(new Paragraph("CALENDRIER DES EXAMENS",FontFactory.getFont(FontFactory.TIMES_BOLD,18,Font.BOLD,BaseColor.BLUE)));
        d.add(new Paragraph("  "));
        d.add(new Paragraph("2éme ANNEE L F : INFORMATIQUE DE GESTION ",FontFactory.getFont(FontFactory.TIMES_BOLD,18,Font.BOLD)));
        d.add(new Paragraph("                           "+new Date().toString()));
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

private ResultSet rs;
@FXML
    void modifier(ActionEvent event) throws IOException {
        int row =lfig2.getSelectionModel().getSelectedIndex();
        if(row <0)return; 
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/Frmcal2lfig.fxml"));
        AnchorPane  mainPane = (AnchorPane)loader.load();
        Scene scene = new Scene(mainPane);
        stage.setTitle("Ajouter Nouvelle Matiéres");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        Frmcal2lfigController ctrl = loader.getController();
        ctrl.setEcom(data.get(row).getIdlfig2());
        stage.showAndWait();
        actualiser();
        
    }

    @FXML
    void supprimer(ActionEvent event) 
    {
         int row =lfig2.getSelectionModel().getSelectedIndex();
        if(row <0)return;
        Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
        alert.setTitle("Conformation de suppression");
        alert.setHeaderText(null);
        alert.setContentText("Vous etes sure?");
        Optional <ButtonType>action = alert.showAndWait();
        
        if(action.get()==ButtonType.OK){
       
        em = Cal2LFIGController.emf.createEntityManager();
        Query q =em.createQuery("SELECT l FROM Lfig2 l WHERE l.idlfig2 = :idlfig2");
        q.setParameter("idlfig2", data.get(row).getIdlfig2());
        Lfig2 E = (Lfig2) q.getSingleResult();
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
        em = Cal2LFIGController.emf.createEntityManager();
        emf=Persistence.createEntityManagerFactory("ESENPU");
        lfig2.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
                
        List<Lfig2>lst = em.createQuery("SELECT l FROM Lfig2 l").getResultList();
        
        data=FXCollections.observableArrayList();
        for(Lfig2 lst1:lst){
           
        data.add(new Lfig2fx(lst1.getIdlfig2(),lst1.getJour(),lst1.getDate(),lst1.getMatieres(),lst1.getHoraire(),lst1.getDuree(),lst1.getGroupe1(),lst1.getSalleG1(),lst1.getGroupe2(),lst1.getSalleG2()));
        }
        lfig2.setItems(data);
        id.setCellValueFactory(cell->cell.getValue().getIdlfig2Property());
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
            pst = connection.prepareStatement("SELECT min(idlfig2) FROM lfig2");
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
            pst = connection.prepareStatement("SELECT max(idlfig2) FROM lfig2");
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
        String sql ="delete from lfig2 where idlfig2="+i+"";
        pst = connection.prepareStatement(sql);
        pst.executeUpdate();
        }
        catch (SQLException e1)
            {e1.printStackTrace();}        
i++;}}actualiser();}

    
}