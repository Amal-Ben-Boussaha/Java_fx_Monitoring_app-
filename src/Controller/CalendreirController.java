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

public class CalendreirController implements Initializable {
   private  dbconnect handler ;
   private Connection connection;
   private PreparedStatement pst;
   ResultSet rs;
   EntityManager em;
   public static EntityManagerFactory emf;
    ObservableList<Lfigfx> data;
   @FXML
    private TableView<Lfigfx> lfig1;

    @FXML
    private TableColumn<Lfigfx, Number> id;
       @FXML
    private TableColumn<Lfigfx, String> jour;

    @FXML
    private TableColumn<Lfigfx, String> date;

    @FXML
    private TableColumn<Lfigfx, String> mat;

    @FXML
    private TableColumn<Lfigfx, String> horaire;

    @FXML
    private TableColumn<Lfigfx, String> durée;

    @FXML
    private TableColumn<Lfigfx, String> groupe;
    @FXML
    private TableColumn<Lfigfx, String> groupe2;

    @FXML
    private TableColumn<Lfigfx, String> groupe3;

    @FXML
    private TableColumn<Lfigfx, String> groupe4;

    @FXML
    private TableColumn<Lfigfx, String> salle;

    @FXML
    private TableColumn<Lfigfx, String> salle2;

    @FXML
    private TableColumn<Lfigfx, String> salle3;

    @FXML
    private TableColumn<Lfigfx, String> salle4;
     @FXML
    void ajouter(ActionEvent event) throws IOException {
     Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/LfigcalendrierFrm.fxml"));
        AnchorPane  mainPane = (AnchorPane)loader.load();
        Scene scene = new Scene(mainPane);
        stage.setTitle("Ajouter Nouvelle enseignant");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        LfigcalendrierFrmController ctrl = loader.getController();
        stage.showAndWait();
        Affichier(event);
    
    }
    @FXML
    void Affichier(ActionEvent event) {
        connection = handler.getConnection();
        emf=Persistence.createEntityManagerFactory("ESENPU");
        em = CalendreirController.emf.createEntityManager();
        emf=Persistence.createEntityManagerFactory("ESENPU");
        lfig1.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        List<Lfig>lst = em.createQuery("SELECT l FROM Lfig l").getResultList();
        
        data=FXCollections.observableArrayList();
        for(Lfig lst1:lst){
           
        data.add(new Lfigfx(lst1.getIdLf(),lst1.getJour(),lst1.getDate(),lst1.getMatiere(),lst1.getDuree(),lst1.getGrp1(),lst1.getGrp2(),lst1.getGrp3(),lst1.getG4(),lst1.getSalleg1(),lst1.getSalleg2(),lst1.getSalleg3(),lst1.getSalleg4(),lst1.getHoraire()));
        }
        lfig1.setItems(data);
        id.setCellValueFactory(cell->cell.getValue().getIdLfProperty());
        
        date.setCellValueFactory(cell->cell.getValue().getDateProperty());
        mat.setCellValueFactory(cell->cell.getValue().getMatiereProperty());
        durée.setCellValueFactory(cell->cell.getValue().getDureeProperty());
        groupe.setCellValueFactory(cell->cell.getValue().getGrp1Property());
        groupe2.setCellValueFactory(cell->cell.getValue().getGrp2Property());
        groupe3.setCellValueFactory(cell->cell.getValue().getGrp3Property());
        groupe4.setCellValueFactory(cell->cell.getValue().getG4Property());
        salle.setCellValueFactory(cell->cell.getValue().getSalleg1Property());
        salle2.setCellValueFactory(cell->cell.getValue().getSalleg2Property());
        salle3.setCellValueFactory(cell->cell.getValue().getSalleg3Property());
        salle4.setCellValueFactory(cell->cell.getValue().getSalleg4Property());
        horaire.setCellValueFactory(cell->cell.getValue().getHoraireProperty());

    }

     
    @FXML
    void aff_disp(ActionEvent event) {

    }
    private int entrejour()
    {
        int i=0;
           try {
            pst = connection.prepareStatement("SELECT count(idlf) FROM lfig");
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
    void imprime(ActionEvent event) throws SQLException, FileNotFoundException, DocumentException {
        Affichier(event);
        connection = handler.getConnection();
        int k=entrejour();
        try{
          
        int rowno=0;
        rs=pst.executeQuery("Select * from lfig");
        ResultSetMetaData rsmd =rs.getMetaData();
        int colnc=rsmd.getColumnCount();
        while(rs.next())
         {
            rowno = rowno+1;
         }
        rs.first();
        Document d = new Document();
        PdfWriter.getInstance(d,new FileOutputStream ("1ereLfig.pdf"));
        PdfPTable pt = new PdfPTable(colnc);
        d.open();
        d.add(new Paragraph("Calendrier Des examen"));
        d.add(new Paragraph("    Lfig  "));
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
        pt.addCell(""+rs.getString(11));
        pt.addCell(""+rs.getString(12));
        pt.addCell(""+rs.getString(13));
        pt.addCell(""+rs.getString(14));
        
        rs.next();
        }
        d.add(pt);
        d.close();
        }catch(DocumentException | FileNotFoundException | SQLException e)
        {e.printStackTrace();}

  
  
    }
     @FXML
    void exemple(ActionEvent event) {
        Affichier(event);
    }


    @FXML
    void modifier(ActionEvent event) throws IOException {
        int row =lfig1.getSelectionModel().getSelectedIndex();
        if(row <0)return; 
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/LfigcalendrierFrm.fxml"));
        AnchorPane  mainPane = (AnchorPane)loader.load();
        Scene scene = new Scene(mainPane);
        stage.setTitle("Ajouter Nouvelle Matiéres");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        LfigcalendrierFrmController ctrl = loader.getController();
        ctrl.setLfig(data.get(row).getIdLf());
        stage.showAndWait();
        Affichier(event);
    }

    @FXML
    void supprimer(ActionEvent event) {
        int row =lfig1.getSelectionModel().getSelectedIndex();
        Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
        alert.setTitle("Conformation de suppression");
        alert.setHeaderText(null);
        alert.setContentText("Vous etes sure?");
        Optional <ButtonType>action = alert.showAndWait();
        
        if(action.get()==ButtonType.OK){
       
        if(row <0)return;
        em = CalendreirController.emf.createEntityManager();
        Query q =em.createQuery("SELECT l FROM Lfig l WHERE l.idLf = :idLf");
        q.setParameter("idLf", data.get(row).getIdLf());
        Lfig l = (Lfig) q.getSingleResult();
        em.getTransaction().begin();
        em.remove(l);
        em.getTransaction().commit();
        em.close();
        Affichier(event);
    }}
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        handler = new dbconnect();
        emf=Persistence.createEntityManagerFactory("ESENPU");
        em = CalendreirController.emf.createEntityManager();
        emf=Persistence.createEntityManagerFactory("ESENPU");
        lfig1.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        List<Lfig>lst = em.createQuery("SELECT l FROM Lfig l").getResultList();
        
        data=FXCollections.observableArrayList();
        for(Lfig lst1:lst){
           
        data.add(new Lfigfx(lst1.getIdLf(),lst1.getJour(),lst1.getDate(),lst1.getMatiere(),lst1.getDuree(),lst1.getGrp1(),lst1.getGrp2(),lst1.getGrp3(),lst1.getG4(),lst1.getSalleg1(),lst1.getSalleg2(),lst1.getSalleg3(),lst1.getSalleg4(),lst1.getHoraire()));
        }
        lfig1.setItems(data);
        id.setCellValueFactory(cell->cell.getValue().getIdLfProperty());
        jour.setCellValueFactory(cell->cell.getValue().getJourProperty());
        date.setCellValueFactory(cell->cell.getValue().getDateProperty());
        mat.setCellValueFactory(cell->cell.getValue().getMatiereProperty());
        horaire.setCellValueFactory(cell->cell.getValue().getHoraireProperty());
        durée.setCellValueFactory(cell->cell.getValue().getDureeProperty());
        groupe.setCellValueFactory(cell->cell.getValue().getGrp1Property());
        salle.setCellValueFactory(cell->cell.getValue().getSalleg1Property());
        groupe2.setCellValueFactory(cell->cell.getValue().getGrp2Property());
        salle2.setCellValueFactory(cell->cell.getValue().getSalleg2Property());
        groupe3.setCellValueFactory(cell->cell.getValue().getGrp3Property());
        salle3.setCellValueFactory(cell->cell.getValue().getSalleg3Property());
        groupe4.setCellValueFactory(cell->cell.getValue().getG4Property());
        salle4.setCellValueFactory(cell->cell.getValue().getSalleg4Property());
        
    }    
    private int   minID()
        { 
            int idmin = 1;
        try {
            pst = connection.prepareStatement("SELECT min(idlf) FROM lfig");
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
            pst = connection.prepareStatement("SELECT max(idlf) FROM lfig");
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
        String sql ="delete from lfig where idlf="+i+"";
        pst = connection.prepareStatement(sql);
        pst.executeUpdate();
        }
        catch (SQLException e1)
            {e1.printStackTrace();}        
i++;}}Affichier(event);}
       
}
