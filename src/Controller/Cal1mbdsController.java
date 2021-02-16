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

public class Cal1mbdsController implements Initializable {
    
    @FXML
    private TableView<Mbds1fx> mdbstab;

    @FXML
    private TableColumn<Mbds1fx, Number> id;

    @FXML
    private TableColumn<Mbds1fx, String> jour;

    @FXML
    private TableColumn<Mbds1fx, String> date;

    @FXML
    private TableColumn<Mbds1fx, String> matieres;

    @FXML
    private TableColumn<Mbds1fx, String> horaire;

    @FXML
    private TableColumn<Mbds1fx, String> duree;

    @FXML
    private TableColumn<Mbds1fx, String> salle;

    public static EntityManagerFactory emf;
    
    EntityManager em;  
    ObservableList<Mbds1fx> data;

    @FXML
    void ajouter(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/frmcal1mbds.fxml"));
        AnchorPane  mainPane = (AnchorPane)loader.load();
        Scene scene = new Scene(mainPane);
        stage.setTitle("Ajouter Nouvelle Examen");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        Frmcal1mbdsController ctrl = loader.getController();
        stage.showAndWait();
        actualiser();
    }
    private int entrejour()
    {
        int i=0;
           try {
            pst = connection.prepareStatement("SELECT count(idmbds1) FROM mbds1");
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
        int k=entrejour();
        int rowno=0;
        rs=pst.executeQuery("SELECT * FROM mbds2");
        ResultSetMetaData rsmd =rs.getMetaData();
        int colnc=rsmd.getColumnCount();
        while(rs.next())
         {
            rowno = rowno+1;
         }
        rs.first();
        Document d = new Document();
        PdfWriter.getInstance(d,new FileOutputStream ("Nom.pdf"));
        PdfPTable pt = new PdfPTable(colnc);
        d.open();
        d.add(new Paragraph("Calendrier Des examen"));
        d.add(new Paragraph("    1MBds  "));
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
        rs.next();
        }
        d.add(pt);
        d.close();
    
    }

    @FXML
    void modifier(ActionEvent event) throws IOException {
        int row =mdbstab.getSelectionModel().getSelectedIndex();
        if(row <0)return; 
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/frmcal1mbds.fxml"));
        AnchorPane  mainPane = (AnchorPane)loader.load();
        Scene scene = new Scene(mainPane);
        stage.setTitle("Ajouter Nouvelle Matiéres");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        Frmcal1mbdsController ctrl = loader.getController();
        ctrl.setEcom(data.get(row).getIdmbds1());
        stage.showAndWait();
        actualiser();
        
    }

    @FXML
    void supprimer(ActionEvent event) 
    {
         int row =mdbstab.getSelectionModel().getSelectedIndex();
        if(row <0)return;
         Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
        alert.setTitle("Conformation de suppression");
        alert.setHeaderText(null);
        alert.setContentText("Vous etes sure?");
        Optional <ButtonType>action = alert.showAndWait();
        
        if(action.get()==ButtonType.OK){
        em = Cal1mbdsController.emf.createEntityManager();
        Query q =em.createQuery("SELECT m FROM Mbds1 m WHERE m.idmbds1 = :idmbds1");
        q.setParameter("idmbds1", data.get(row).getIdmbds1());
        Mbds1  M= (Mbds1) q.getSingleResult();
        em.getTransaction().begin();
        em.remove(M);
        em.getTransaction().commit();
        em.close();
        actualiser();
    }}
    
    private void actualiser()
    {
        emf=Persistence.createEntityManagerFactory("ESENPU");
        em = Cal1mbdsController.emf.createEntityManager();
        emf=Persistence.createEntityManagerFactory("ESENPU");
        mdbstab.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
                
        List<Mbds1>lst = em.createQuery("SELECT m FROM Mbds1 m").getResultList();
        
        data=FXCollections.observableArrayList();
        for(Mbds1 lst1:lst){
           
        data.add(new Mbds1fx(lst1.getIdmbds1(),lst1.getJourMbds(),lst1.getDateMbds(),lst1.getMatieresMbds(),lst1.getHoraireMbds(),lst1.getDureeMbds(),lst1.getSalleMbds()));
        }
        mdbstab.setItems(data);
        id.setCellValueFactory(cell->cell.getValue().getIdmbds1Property());
        jour.setCellValueFactory(cell->cell.getValue().getJourMbdsProperty());
        date.setCellValueFactory(cell->cell.getValue().getDateMbdsProperty());
        matieres.setCellValueFactory(cell->cell.getValue().getMatieresMbdsProperty());
        horaire.setCellValueFactory(cell->cell.getValue().getHoraireMbdsProperty());
        duree.setCellValueFactory(cell->cell.getValue().getDureeMbdsProperty());  
        salle.setCellValueFactory(cell->cell.getValue().getSalleMbdsProperty()); 
    
    }
    private ResultSet rs;
private Connection connection;
private dbconnect handler;
private PreparedStatement pst; 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         handler = new dbconnect();
        actualiser();
    }  
    private int   minID()
        { 
            int idmin = 1;
        try {
            pst = connection.prepareStatement("SELECT min(idmbds1) FROM mbds1");
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
            pst = connection.prepareStatement("SELECT max(idmbds1) FROM mbds1");
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
        String sql ="delete from mbds1 where idmbds1="+i+"";
        pst = connection.prepareStatement(sql);
        pst.executeUpdate();
        }
        catch (SQLException e1)
            {e1.printStackTrace();}        
i++;}}actualiser();}
    }
