package Controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * FXML Controller class
 *
 * @author Amal Ben Boussaha
 */
public class Cosult2MasterController implements Initializable {

  EntityManager em;
   public static EntityManagerFactory emf;
    ObservableList<Mecom2fx> dataMecom;
    ObservableList<Mbds2fx> dataMbds;
    ObservableList<Vic2fx> dataVic;
    ObservableList<Wi2fx> dataWi;
   
    
    
    @FXML
    private TableView<Mecom2fx> mecom2;

    @FXML
    private TableColumn<Mecom2fx, Number> idl;

    @FXML
    private TableColumn<Mecom2fx, String> jourl;

    @FXML
    private TableColumn<Mecom2fx, String> datel;

    @FXML
    private TableColumn<Mecom2fx, String> matieresl;

    @FXML
    private TableColumn<Mecom2fx, String> horairel;

    @FXML
    private TableColumn<Mecom2fx, String> dureel;

    @FXML
    private TableColumn<Mecom2fx, String> sg1l;

    
    @FXML
    private TableView<Mbds2fx> mbds2;

    @FXML
    private TableColumn<Mbds2fx, Number> idt;

    @FXML
    private TableColumn<Mbds2fx, String> jourt;

    @FXML
    private TableColumn<Mbds2fx, String> datet;

    @FXML
    private TableColumn<Mbds2fx, String> matierest;

    @FXML
    private TableColumn<Mbds2fx, String> horairet;

    @FXML
    private TableColumn<Mbds2fx, String> dureet;

   

    @FXML
    private TableColumn<Mbds2fx, String> sg1t;

    
    @FXML
    private TableView<Vic2fx> vic2;

    @FXML
    private TableColumn<Vic2fx, Number> idv;

    @FXML
    private TableColumn<Vic2fx, String> jourv;

    @FXML
    private TableColumn<Vic2fx, String> datev;

    @FXML
    private TableColumn<Vic2fx, String> matieresv;

    @FXML
    private TableColumn<Vic2fx, String> horairev;

    @FXML
    private TableColumn<Vic2fx, String> dureev;

    @FXML
    private TableColumn<Vic2fx, String> sg1v;

   @FXML
    private TableView<Wi2fx> wi2;

    @FXML
    private TableColumn<Wi2fx, Number> idw;

    @FXML
    private TableColumn<Wi2fx, String> jourw;

    @FXML
    private TableColumn<Wi2fx, String> datew;

    @FXML
    private TableColumn<Wi2fx, String> matieresw;

    @FXML
    private TableColumn<Wi2fx, String> horairew;

    @FXML
    private TableColumn<Wi2fx, String> dureew;

    @FXML
    private TableColumn<Wi2fx, String> sg1w;

    private void actualiserMecom()
    {
        emf=Persistence.createEntityManagerFactory("ESENPU");
        em = Cosult2MasterController.emf.createEntityManager();
        emf=Persistence.createEntityManagerFactory("ESENPU");
       mecom2.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
                
        List<Mecom2>lst = em.createQuery("SELECT m FROM Mecom2 m").getResultList();
        
        dataMecom=FXCollections.observableArrayList();
        for(Mecom2 lst1:lst){
           
        dataMecom.add(new Mecom2fx(lst1.getIdmecom2(),lst1.getJour(),lst1.getDate(),lst1.getMatieres(),lst1.getHoraire(),lst1.getDuree(),lst1.getSalle()));
        }
        mecom2.setItems(dataMecom);
        idl.setCellValueFactory(cell->cell.getValue().getIdmecom2Property());
        jourl.setCellValueFactory(cell->cell.getValue().getJourProperty());
        datel.setCellValueFactory(cell->cell.getValue().getDateProperty());
        matieresl.setCellValueFactory(cell->cell.getValue().getMatieresProperty());
        horairel.setCellValueFactory(cell->cell.getValue().getHoraireProperty());
        dureel.setCellValueFactory(cell->cell.getValue().getDureeProperty());  
        sg1l.setCellValueFactory(cell->cell.getValue().getSalleProperty()); 
       
    }
    private void actualiserMbds()
    {
        emf=Persistence.createEntityManagerFactory("ESENPU");
        em = Cosult2MasterController.emf.createEntityManager();
        emf=Persistence.createEntityManagerFactory("ESENPU");
        mbds2.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
                
        List<Mbds2>lst = em.createQuery("SELECT m FROM Mbds2 m").getResultList();
        
        dataMbds=FXCollections.observableArrayList();
        for(Mbds2 lst1:lst){
           
        dataMbds.add(new Mbds2fx(lst1.getIdmbds2(),lst1.getJourMbds(),lst1.getDateMbds(),lst1.getMatieresMbds(),lst1.getHoraireMbds(),lst1.getDureeMbds(),lst1.getSalleMbds()));
        }
        mbds2.setItems(dataMbds);
        idt.setCellValueFactory(cell->cell.getValue().getIdmbds2Property());
        jourt.setCellValueFactory(cell->cell.getValue().getJourMbdsProperty());
        datet.setCellValueFactory(cell->cell.getValue().getDateMbdsProperty());
        matierest.setCellValueFactory(cell->cell.getValue().getMatieresMbdsProperty());
        horairet.setCellValueFactory(cell->cell.getValue().getHoraireMbdsProperty());
        dureet.setCellValueFactory(cell->cell.getValue().getDureeMbdsProperty());  
        sg1t.setCellValueFactory(cell->cell.getValue().getSalleMbdsProperty()); 
    }
    private void actualiserWi()
    {
        emf=Persistence.createEntityManagerFactory("ESENPU");
        em = Cosult2MasterController.emf.createEntityManager();
        emf=Persistence.createEntityManagerFactory("ESENPU");
        wi2.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
                
        List<Wi2>lst = em.createQuery("SELECT w FROM Wi2 w").getResultList();
        
        dataWi=FXCollections.observableArrayList();
        for(Wi2 lst1:lst){
           
        dataWi.add(new Wi2fx(lst1.getIdwi2(),lst1.getJourWi(),lst1.getDateWi(),lst1.getMatieresWi(),lst1.getHoraireWi(),lst1.getDureeWi(),lst1.getSalleWi()));
        }
        wi2.setItems(dataWi);
        idw.setCellValueFactory(cell->cell.getValue().getIdwi2Property());
        jourw.setCellValueFactory(cell->cell.getValue().getJourWiProperty());
        datew.setCellValueFactory(cell->cell.getValue().getDateWiProperty());
        matieresw.setCellValueFactory(cell->cell.getValue().getMatieresWiProperty());
        horairew.setCellValueFactory(cell->cell.getValue().getHoraireWiProperty());
        dureew.setCellValueFactory(cell->cell.getValue().getDureeWiProperty());  
        sg1w.setCellValueFactory(cell->cell.getValue().getSalleWiProperty()); 
    
    }
    private void actualiserVic()
    {
        emf=Persistence.createEntityManagerFactory("ESENPU");
        em = Cosult2MasterController.emf.createEntityManager();
        emf=Persistence.createEntityManagerFactory("ESENPU");
       
        vic2.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
                
        List<Vic2>lst = em.createQuery("SELECT v FROM Vic2 v").getResultList();
        
        dataVic=FXCollections.observableArrayList();
        for(Vic2 lst1:lst){
           
        dataVic.add(new Vic2fx(lst1.getIdvic2(),lst1.getJourVic(),lst1.getDateVic(),lst1.getMatieresVic(),lst1.getHoraireVic(),lst1.getDureeVic(),lst1.getSalleVic()));
        }
        vic2.setItems(dataVic);
        idv.setCellValueFactory(cell->cell.getValue().getIdvic2Property());
        jourv.setCellValueFactory(cell->cell.getValue().getJourVicProperty());
        datev.setCellValueFactory(cell->cell.getValue().getDateVicProperty());
        matieresv.setCellValueFactory(cell->cell.getValue().getMatieresVicProperty());
        horairev.setCellValueFactory(cell->cell.getValue().getHoraireVicProperty());
        dureev.setCellValueFactory(cell->cell.getValue().getDureeVicProperty());  
        sg1v.setCellValueFactory(cell->cell.getValue().getSalleVicProperty()); 
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        actualiserMecom();
        actualiserMbds();
        actualiserVic();
        actualiserWi();
    }       
}
