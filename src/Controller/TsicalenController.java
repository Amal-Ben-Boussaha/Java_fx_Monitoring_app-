package Controller;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXButton;
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

public class TsicalenController implements Initializable {
    private JFXButton fix;
    private Connection connection;
    private dbconnect handler;
    private PreparedStatement pst;  
    EntityManager em;  
    ObservableList<Tsifx> data;
    @FXML
    private TableView<Tsifx> tsi1;

    @FXML
    private TableColumn<Tsifx, Number> id;
    @FXML
    private TableColumn<Tsifx, String> jour;


    @FXML
    private TableColumn<Tsifx, String> date;

    @FXML
    private TableColumn<Tsifx, String> matieres;

    @FXML
    private TableColumn<Tsifx, String> horaire ;

    @FXML
    private TableColumn<Tsifx, String> duree ;

    @FXML
    private TableColumn<Tsifx, String> g1 ;

    @FXML
    private TableColumn<Tsifx, String> g2 ;

    @FXML
    private TableColumn<Tsifx, String> s1 ;

    @FXML
    private TableColumn<Tsifx, String> s2 ;

    @FXML
    void ajouter(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/calFrm1Tsi.fxml"));
        AnchorPane  mainPane = (AnchorPane)loader.load();
        Scene scene = new Scene(mainPane);
        stage.setTitle("Ajouter Nouvelle enseignant");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        CalFrm1TsiController ctrl = loader.getController();
        stage.showAndWait();
        actualiser();
    }
private ResultSet rs;
private int entrejour()
    {
        int i=0;
           try {
            pst = connection.prepareStatement("SELECT count(idTSI) FROM tsi");
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
        rs=pst.executeQuery("SELECT * FROM tsi");
        ResultSetMetaData rsmd =rs.getMetaData();
        int colnc=rsmd.getColumnCount();
        while(rs.next())
         {
            rowno = rowno+1;
         }
        rs.first();
        Document d = new Document();
        PdfWriter.getInstance(d,new FileOutputStream ("1tsi.pdf"));
        PdfPTable pt = new PdfPTable(colnc);
        d.open();
        d.add(new Paragraph("Calendrier Des examen"));
        d.add(new Paragraph("    1Tsi  "));
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
        int row =tsi1.getSelectionModel().getSelectedIndex();
        if(row <0)return; 
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/calFrm1Tsi.fxml"));
        AnchorPane  mainPane = (AnchorPane)loader.load();
        Scene scene = new Scene(mainPane);
        stage.setTitle("Ajouter Nouvelle Matiéres");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        CalFrm1TsiController ctrl = loader.getController();
        ctrl.setLfig(data.get(row).getIdTSI());
        stage.showAndWait();
        actualiser();
    }
    public static EntityManagerFactory emf;
    
    @FXML
    void supprimer(ActionEvent event) {
        int row =tsi1.getSelectionModel().getSelectedIndex();
        if(row <0)return;
        Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
        alert.setTitle("Conformation de suppression");
        alert.setHeaderText(null);
        alert.setContentText("Vous etes sure?");
        Optional <ButtonType>action = alert.showAndWait();
        
        if(action.get()==ButtonType.OK){
        em = TsicalenController.emf.createEntityManager();
        Query q =em.createQuery("SELECT t FROM Tsi t WHERE t.idTSI = :idTSI");
        q.setParameter("idTSI", data.get(row).getIdTSI());
        Tsi t = (Tsi) q.getSingleResult();
        em.getTransaction().begin();
        em.remove(t);
        em.getTransaction().commit();
        em.close();
        
        actualiser();
    }}    
    private void actualiser()
    {
        emf=Persistence.createEntityManagerFactory("ESENPU");
        em = TsicalenController.emf.createEntityManager();
        emf=Persistence.createEntityManagerFactory("ESENPU");
        tsi1.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
                
        List<Tsi>lst = em.createQuery("SELECT t FROM Tsi t").getResultList();
        
        data=FXCollections.observableArrayList();
        for(Tsi lst1:lst){
           
        data.add(new Tsifx(lst1.getIdTSI(),lst1.getJour(),lst1.getDate(),lst1.getMatiereTsi(),lst1.getHoraireTsi(),lst1.getDureeTsi(),lst1.getG1Tsi(),lst1.getG2Tsi(),lst1.getSalleG1(),lst1.getSalleG2()));
        }
        tsi1.setItems(data);
        id.setCellValueFactory(cell->cell.getValue().getIdTSIProperty());
        jour.setCellValueFactory(cell->cell.getValue().getJourProperty());
        date.setCellValueFactory(cell->cell.getValue().getDateProperty());
        matieres.setCellValueFactory(cell->cell.getValue().getMatiereTsiProperty());
        horaire.setCellValueFactory(cell->cell.getValue().getHoraireTsiProperty());
        duree.setCellValueFactory(cell->cell.getValue().getDureeTsiProperty());  
        g1.setCellValueFactory(cell->cell.getValue().getG1TsiProperty());
        g2.setCellValueFactory(cell->cell.getValue().getG2TsiProperty());
        s1.setCellValueFactory(cell->cell.getValue().getSalleG1Property());
        s2.setCellValueFactory(cell->cell.getValue().getSalleG2Property()); 
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
            pst = connection.prepareStatement("SELECT min(idTSI) FROM tsi");
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
            pst = connection.prepareStatement("SELECT max(idTSI) FROM tsi");
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
        String sql ="delete from tsi where idTSI="+i+"";
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
