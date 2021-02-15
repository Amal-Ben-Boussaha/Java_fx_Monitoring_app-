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

public class EcomCalnController implements Initializable {
     @FXML
    private TableView<Ecomfx> ecom1;

    @FXML
    private TableColumn<Ecomfx, Number> id;
    @FXML
    private TableColumn<Ecomfx, String> jour;
    
    @FXML
    private TableColumn<Ecomfx, String> date;

    @FXML
    private TableColumn<Ecomfx, String> matieres;

    @FXML
    private TableColumn<Ecomfx, String> horaire;

    @FXML
    private TableColumn<Ecomfx, String> duree;

    @FXML
    private TableColumn<Ecomfx, String> ng1;

    @FXML
    private TableColumn<Ecomfx, String> ng2;

    @FXML
    private TableColumn<Ecomfx, String> sg1;
    @FXML
    private TableColumn<Ecomfx, String> sg2;
    public static EntityManagerFactory emf;
    private Connection connection;
    private dbconnect handler;
    private PreparedStatement pst;  
    EntityManager em;
    private ResultSet rs;
    ObservableList<Ecomfx> data;

    @FXML
    void ajouter(ActionEvent event) throws IOException 
    {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/FrmEcom.fxml"));
        AnchorPane  mainPane = (AnchorPane)loader.load();
        Scene scene = new Scene(mainPane);
        stage.setTitle("Ajouter Nouvelle Examen");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        FrmEcomController ctrl = loader.getController();
        stage.showAndWait();
        actualiser();
    }
private int entrejour()
    {
        int i=0;
           try {
            pst = connection.prepareStatement("SELECT count(idecom) FROM ecom");
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
        connection = handler.getConnection();
        int k=entrejour();
        int rowno=0;
        rs=pst.executeQuery("SELECT * FROM ecom");
        ResultSetMetaData rsmd =rs.getMetaData();
        int colnc=rsmd.getColumnCount();
        while(rs.next())
         {
            rowno = rowno+1;
         }
        rs.first();
        Document d = new Document();
        PdfWriter.getInstance(d,new FileOutputStream ("1ereEcom.pdf"));
        PdfPTable pt = new PdfPTable(colnc);
        d.open();
        d.add(new Paragraph("Calendrier Des examen"));
        d.add(new Paragraph("    Ecom  "));
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
        int row =ecom1.getSelectionModel().getSelectedIndex();
        if(row <0)return; 
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/FrmEcom.fxml"));
        AnchorPane  mainPane = (AnchorPane)loader.load();
        Scene scene = new Scene(mainPane);
        stage.setTitle("Ajouter Nouvelle Matiéres");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        FrmEcomController ctrl = loader.getController();
        ctrl.setEcom(data.get(row).getIdecom());
        stage.showAndWait();
        actualiser();
        
    }

    @FXML
    void supprimer(ActionEvent event) {
         int row =ecom1.getSelectionModel().getSelectedIndex();
        if(row <0)return;
        Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
        alert.setTitle("Conformation de suppression");
        alert.setHeaderText(null);
        alert.setContentText("Vous etes sure?");
        Optional <ButtonType>action = alert.showAndWait();
        
        if(action.get()==ButtonType.OK){
            
        
        em = EcomCalnController.emf.createEntityManager();
        Query q =em.createQuery("SELECT e FROM Ecom e WHERE e.idecom = :idecom");
        q.setParameter("idecom", data.get(row).getIdecom());
        Ecom E = (Ecom) q.getSingleResult();
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
        em = EcomCalnController.emf.createEntityManager();
        emf=Persistence.createEntityManagerFactory("ESENPU");
        ecom1.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
                
        List<Ecom>lst = em.createQuery("SELECT e FROM Ecom e").getResultList();
        
        data=FXCollections.observableArrayList();
        for(Ecom lst1:lst){
           
        data.add(new Ecomfx(lst1.getIdecom(),lst1.getJourEcom(),lst1.getDateEcom(),lst1.getMatiereEcom(),lst1.getHoraireEcom(),lst1.getDureeEcom(),lst1.getG1Ecom(),lst1.getG2Ecom(),lst1.getSalleG1(),lst1.getLleG2()));
        }
        ecom1.setItems(data);
        id.setCellValueFactory(cell->cell.getValue().getIdecomProperty());
        jour.setCellValueFactory(cell->cell.getValue().getJourEcomProperty());
        date.setCellValueFactory(cell->cell.getValue().getDateEcomProperty());
        matieres.setCellValueFactory(cell->cell.getValue().getMatiereEcomProperty());
        horaire.setCellValueFactory(cell->cell.getValue().getHoraireEcomProperty());
        duree.setCellValueFactory(cell->cell.getValue().getDureeEcomProperty());  
       ng1.setCellValueFactory(cell->cell.getValue().getG1EcomProperty());
       ng2.setCellValueFactory(cell->cell.getValue().getG2EcomProperty());
       sg1.setCellValueFactory(cell->cell.getValue().getSalleG1Property());
       sg2.setCellValueFactory(cell->cell.getValue().getLleG2Property()); 
    
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        handler = new dbconnect();
         actualiser();
        
    
    }    
    private int   minID()
        { 
            int idmin = 1;
        try {
            pst = connection.prepareStatement("SELECT min(idecom) FROM ecom");
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
            pst = connection.prepareStatement("SELECT max(idecom) FROM ecom");
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
        String sql ="delete from ecom where idecom="+i+"";
        pst = connection.prepareStatement(sql);
        pst.executeUpdate();
        }
        catch (SQLException e1)
            {e1.printStackTrace();}        
i++;}}actualiser();}
}
