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
public class Consult1LisenceController implements Initializable {
    EntityManager em;
   public static EntityManagerFactory emf;
    ObservableList<Lfigfx> data;
    ObservableList<Ecomfx> dataEcom;
    ObservableList<Tsifx> dataTsi;
   
    
    
    @FXML
    private TableView<Lfigfx> lfig1;

    @FXML
    private TableColumn<Lfigfx, Number> idl;

    @FXML
    private TableColumn<Lfigfx, String> jourl;

    @FXML
    private TableColumn<Lfigfx, String> datel;

    @FXML
    private TableColumn<Lfigfx, String> matieresl;

    @FXML
    private TableColumn<Lfigfx, String> horairel;

    @FXML
    private TableColumn<Lfigfx, String> dureel;

    @FXML
    private TableColumn<Lfigfx, String> g1l;

    @FXML
    private TableColumn<Lfigfx, String> sg1l;

    @FXML
    private TableColumn<Lfigfx, String> g2l;

    @FXML
    private TableColumn<Lfigfx, String> sg2l;

    @FXML
    private TableColumn<Lfigfx, String> g3l;

    @FXML
    private TableColumn<Lfigfx, String> sg3l;

    @FXML
    private TableColumn<Lfigfx, String> g4l;

    @FXML
    private TableColumn<Lfigfx, String> sg4;

    @FXML
    private TableView<Tsifx> tsi1;

    @FXML
    private TableColumn<Tsifx, Number> idt;

    @FXML
    private TableColumn<Tsifx, String> jourt;

    @FXML
    private TableColumn<Tsifx, String> datet;

    @FXML
    private TableColumn<Tsifx, String> matierest;

    @FXML
    private TableColumn<Tsifx, String> horairet;

    @FXML
    private TableColumn<Tsifx, String> dureet;

    @FXML
    private TableColumn<Tsifx, String> g1t;

    @FXML
    private TableColumn<Tsifx, String> sg1t;

    @FXML
    private TableColumn<Tsifx, String> g2t;

    @FXML
    private TableColumn<Tsifx, String> sg2t;

    @FXML
    private TableView<Ecomfx> ecom1;

    @FXML
    private TableColumn<Ecomfx, Number> idm;

    @FXML
    private TableColumn<Ecomfx, String> jourm;

    @FXML
    private TableColumn<Ecomfx, String> datem;

    @FXML
    private TableColumn<Ecomfx, String> matieresm;

    @FXML
    private TableColumn<Ecomfx, String> horairem;

    @FXML
    private TableColumn<Ecomfx, String> dureem;

    @FXML
    private TableColumn<Ecomfx, String> g1m;

    @FXML
    private TableColumn<Ecomfx, String> sg1m;

    @FXML
    private TableColumn<Ecomfx, String> g2m;

    @FXML
    private TableColumn<Ecomfx, String> sg2m;
    private void actualiserLFIG()
    {
        emf=Persistence.createEntityManagerFactory("ESENPU");
        em = Consult1LisenceController.emf.createEntityManager();
        emf=Persistence.createEntityManagerFactory("ESENPU");
        lfig1.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        List<Lfig>lst = em.createQuery("SELECT l FROM Lfig l").getResultList();
        
        data=FXCollections.observableArrayList();
        for(Lfig lst1:lst){
           
        data.add(new Lfigfx(lst1.getIdLf(),lst1.getJour(),lst1.getDate(),lst1.getMatiere(),lst1.getDuree(),lst1.getGrp1(),lst1.getGrp2(),lst1.getGrp3(),lst1.getG4(),lst1.getSalleg1(),lst1.getSalleg2(),lst1.getSalleg3(),lst1.getSalleg4(),lst1.getHoraire()));
        }
        lfig1.setItems(data);
        idl.setCellValueFactory(cell->cell.getValue().getIdLfProperty());
        
        datel.setCellValueFactory(cell->cell.getValue().getDateProperty());
        matieresl.setCellValueFactory(cell->cell.getValue().getMatiereProperty());
        dureel.setCellValueFactory(cell->cell.getValue().getDureeProperty());
        jourl.setCellValueFactory(cell->cell.getValue().getJourProperty());
        g1l.setCellValueFactory(cell->cell.getValue().getGrp1Property());
        g2l.setCellValueFactory(cell->cell.getValue().getGrp2Property());
        g3l.setCellValueFactory(cell->cell.getValue().getGrp3Property());
        g4l.setCellValueFactory(cell->cell.getValue().getG4Property());
        sg1l.setCellValueFactory(cell->cell.getValue().getSalleg1Property());
        sg2l.setCellValueFactory(cell->cell.getValue().getSalleg2Property());
        sg3l.setCellValueFactory(cell->cell.getValue().getSalleg3Property());
        sg4.setCellValueFactory(cell->cell.getValue().getSalleg4Property());
        horairel.setCellValueFactory(cell->cell.getValue().getHoraireProperty());
    
    }
    private void actualiserECOM()
    {
        emf=Persistence.createEntityManagerFactory("ESENPU");
        em = Consult1LisenceController.emf.createEntityManager();
        emf=Persistence.createEntityManagerFactory("ESENPU");
        ecom1.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
                
        List<Ecom>lst = em.createQuery("SELECT e FROM Ecom e").getResultList();
        
        dataEcom=FXCollections.observableArrayList();
        for(Ecom lst1:lst){
           
        dataEcom.add(new Ecomfx(lst1.getIdecom(),lst1.getJourEcom(),lst1.getDateEcom(),lst1.getMatiereEcom(),lst1.getHoraireEcom(),lst1.getDureeEcom(),lst1.getG1Ecom(),lst1.getG2Ecom(),lst1.getSalleG1(),lst1.getLleG2()));
        }
        ecom1.setItems(dataEcom);
        idm.setCellValueFactory(cell->cell.getValue().getIdecomProperty());
        jourm.setCellValueFactory(cell->cell.getValue().getJourEcomProperty());
        datem.setCellValueFactory(cell->cell.getValue().getDateEcomProperty());
        matieresm.setCellValueFactory(cell->cell.getValue().getMatiereEcomProperty());
        horairem.setCellValueFactory(cell->cell.getValue().getHoraireEcomProperty());
        dureem.setCellValueFactory(cell->cell.getValue().getDureeEcomProperty());  
       g1m.setCellValueFactory(cell->cell.getValue().getG1EcomProperty());
       g2m.setCellValueFactory(cell->cell.getValue().getG2EcomProperty());
       sg1m.setCellValueFactory(cell->cell.getValue().getSalleG1Property());
       sg2m.setCellValueFactory(cell->cell.getValue().getLleG2Property()); 
    
    }
    private void actualiserTSI()
    {
        emf=Persistence.createEntityManagerFactory("ESENPU");
        em = Consult1LisenceController.emf.createEntityManager();
        emf=Persistence.createEntityManagerFactory("ESENPU");
        tsi1.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
                
        List<Tsi>lst = em.createQuery("SELECT t FROM Tsi t").getResultList();
        
        dataTsi=FXCollections.observableArrayList();
        for(Tsi lst1:lst){
           
        dataTsi.add(new Tsifx(lst1.getIdTSI(),lst1.getJour(),lst1.getDate(),lst1.getMatiereTsi(),lst1.getHoraireTsi(),lst1.getDureeTsi(),lst1.getG1Tsi(),lst1.getG2Tsi(),lst1.getSalleG1(),lst1.getSalleG2()));
        }
        tsi1.setItems(dataTsi);
        idt.setCellValueFactory(cell->cell.getValue().getIdTSIProperty());
        jourt.setCellValueFactory(cell->cell.getValue().getJourProperty());
        datet.setCellValueFactory(cell->cell.getValue().getDateProperty());
        matierest.setCellValueFactory(cell->cell.getValue().getMatiereTsiProperty());
        horairet.setCellValueFactory(cell->cell.getValue().getHoraireTsiProperty());
        dureet.setCellValueFactory(cell->cell.getValue().getDureeTsiProperty());  
        g1t.setCellValueFactory(cell->cell.getValue().getG1TsiProperty());
        g2t.setCellValueFactory(cell->cell.getValue().getG2TsiProperty());
        sg1t.setCellValueFactory(cell->cell.getValue().getSalleG1Property());
        sg2t.setCellValueFactory(cell->cell.getValue().getSalleG2Property()); 
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        actualiserLFIG();
        actualiserECOM();
        actualiserTSI();
    }    
    
}
