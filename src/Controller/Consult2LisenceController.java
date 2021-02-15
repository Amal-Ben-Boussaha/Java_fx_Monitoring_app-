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
public class Consult2LisenceController implements Initializable {
    EntityManager em;
   public static EntityManagerFactory emf;
    ObservableList<Lfig2fx> data;
    ObservableList<Ecom2fx> dataEcom;
    ObservableList<Tsi2fx> dataTsi;
   
    
    
    @FXML
    private TableView<Lfig2fx> lfig2;

    @FXML
    private TableColumn<Lfig2fx, Number> idl;

    @FXML
    private TableColumn<Lfig2fx, String> jourl;

    @FXML
    private TableColumn<Lfig2fx, String> datel;

    @FXML
    private TableColumn<Lfig2fx, String> matieresl;

    @FXML
    private TableColumn<Lfig2fx, String> horairel;

    @FXML
    private TableColumn<Lfig2fx, String> dureel;

    @FXML
    private TableColumn<Lfig2fx, String> g1l;

    @FXML
    private TableColumn<Lfig2fx, String> sg1l;

    @FXML
    private TableColumn<Lfig2fx, String> g2l;

    @FXML
    private TableColumn<Lfig2fx, String> sg2l;

  

   
    @FXML
    private TableView<Tsi2fx> tsi2;

    @FXML
    private TableColumn<Tsi2fx, Number> idt;

    @FXML
    private TableColumn<Tsi2fx, String> jourt;

    @FXML
    private TableColumn<Tsi2fx, String> datet;

    @FXML
    private TableColumn<Tsi2fx, String> matierest;

    @FXML
    private TableColumn<Tsi2fx, String> horairet;

    @FXML
    private TableColumn<Tsi2fx, String> dureet;

    @FXML
    private TableColumn<Tsi2fx, String> g1t;

    @FXML
    private TableColumn<Tsi2fx, String> sg1t;

    @FXML
    private TableColumn<Tsi2fx, String> g2t;

    @FXML
    private TableColumn<Tsi2fx, String> sg2t;

    @FXML
    private TableView<Ecom2fx> ecom2;

    @FXML
    private TableColumn<Ecom2fx, Number> idm;

    @FXML
    private TableColumn<Ecom2fx, String> jourm;

    @FXML
    private TableColumn<Ecom2fx, String> datem;

    @FXML
    private TableColumn<Ecom2fx, String> matieresm;

    @FXML
    private TableColumn<Ecom2fx, String> horairem;

    @FXML
    private TableColumn<Ecom2fx, String> dureem;

    @FXML
    private TableColumn<Ecom2fx, String> g1m;

    @FXML
    private TableColumn<Ecom2fx, String> sg1m;

    @FXML
    private TableColumn<Ecom2fx, String> g2m;

    @FXML
    private TableColumn<Ecom2fx, String> sg2m;
    private void actualiserLFIG()
    {
        emf=Persistence.createEntityManagerFactory("ESENPU");
        em = Consult2LisenceController.emf.createEntityManager();
        emf=Persistence.createEntityManagerFactory("ESENPU");
        lfig2.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        List<Lfig2>lst = em.createQuery("SELECT l FROM Lfig2 l").getResultList();
        
        data=FXCollections.observableArrayList();
        for(Lfig2 lst1:lst){
           
        data.add(new Lfig2fx(lst1.getIdlfig2(),lst1.getJour(),lst1.getDate(),lst1.getMatieres(),lst1.getHoraire(),lst1.getDuree(),lst1.getGroupe1(),lst1.getSalleG1(),lst1.getGroupe2(),lst1.getSalleG2()));
        }
        lfig2.setItems(data);
        idl.setCellValueFactory(cell->cell.getValue().getIdlfig2Property());
        jourl.setCellValueFactory(cell->cell.getValue().getJourProperty());
        datel.setCellValueFactory(cell->cell.getValue().getDateProperty());
        matieresl.setCellValueFactory(cell->cell.getValue().getMatieresProperty());
        horairel.setCellValueFactory(cell->cell.getValue().getHoraireProperty());
        dureel.setCellValueFactory(cell->cell.getValue().getDureeProperty());  
       g1l.setCellValueFactory(cell->cell.getValue().getGroupe1Property());
       sg1l.setCellValueFactory(cell->cell.getValue().getSalleG1Property());
       g2l.setCellValueFactory(cell->cell.getValue().getGroupe2Property());
       sg2l.setCellValueFactory(cell->cell.getValue().getSalleG2Property()); 
    
    }
    private void actualiserECOM()
    {
        emf=Persistence.createEntityManagerFactory("ESENPU");
        em = Consult2LisenceController.emf.createEntityManager();
        emf=Persistence.createEntityManagerFactory("ESENPU");
        ecom2.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
                
        List<Ecom2>lst = em.createQuery("SELECT e FROM Ecom2 e").getResultList();
        
        dataEcom=FXCollections.observableArrayList();
        for(Ecom2 lst1:lst){
           
        dataEcom.add(new Ecom2fx(lst1.getIdecom2(),lst1.getJourEcom(),lst1.getDateEcom(),lst1.getMatieresEcom(),lst1.getHoraireEcom(),lst1.getDureeEcom(),lst1.getGroupe1Ecom(),lst1.getSalleG1Ecom(),lst1.getGroupe2Ecom(),lst1.getSalleG2Ecom()));
        }
        ecom2.setItems(dataEcom);
        idm.setCellValueFactory(cell->cell.getValue().getIdecom2Property());
        jourm.setCellValueFactory(cell->cell.getValue().getJourEcomProperty());
        datem.setCellValueFactory(cell->cell.getValue().getDateEcomProperty());
        matieresm.setCellValueFactory(cell->cell.getValue().getMatieresEcomProperty());
        horairem.setCellValueFactory(cell->cell.getValue().getHoraireEcomProperty());
        dureem.setCellValueFactory(cell->cell.getValue().getDureeEcomProperty());  
        g1m.setCellValueFactory(cell->cell.getValue().getGroupe1EcomProperty());
       sg1m.setCellValueFactory(cell->cell.getValue().getSalleG1EcomProperty());
       g2m.setCellValueFactory(cell->cell.getValue().getGroupe2EcomProperty());
       sg2m.setCellValueFactory(cell->cell.getValue().getSalleG2EcomProperty()); 
    
    }
    private void actualiserTSI()
    {
        emf=Persistence.createEntityManagerFactory("ESENPU");
        em = Consult2LisenceController.emf.createEntityManager();
        emf=Persistence.createEntityManagerFactory("ESENPU");
        tsi2.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
                
        List<Tsi2>lst = em.createQuery("SELECT t FROM Tsi2 t").getResultList();
        
        dataTsi=FXCollections.observableArrayList();
        for(Tsi2 lst1:lst){
           
        dataTsi.add(new Tsi2fx(lst1.getIdtsi2(),lst1.getJourTsi(),lst1.getDateTsi(),lst1.getMatieresTsi(),lst1.getHoraireTsi(),lst1.getDureeTsi(),lst1.getGroupe1Tsi(),lst1.getSalleG1Tsi(),lst1.getGroupe2Tsi(),lst1.getSalleG2Tsi()));
        }
        tsi2.setItems(dataTsi);
        idt.setCellValueFactory(cell->cell.getValue().getIdtsi2Property());
        jourt.setCellValueFactory(cell->cell.getValue().getJourTsiProperty());
        datet.setCellValueFactory(cell->cell.getValue().getDateTsiProperty());
        matierest.setCellValueFactory(cell->cell.getValue().getMatieresTsiProperty());
        horairet.setCellValueFactory(cell->cell.getValue().getHoraireTsiProperty());
        dureet.setCellValueFactory(cell->cell.getValue().getDureeTsiProperty());  
       g1t.setCellValueFactory(cell->cell.getValue().getGroupe1TsiProperty());
       sg1t.setCellValueFactory(cell->cell.getValue().getSalleG1TsiProperty());
       g2t.setCellValueFactory(cell->cell.getValue().getGroupe2TsiProperty());
       sg2t.setCellValueFactory(cell->cell.getValue().getSalleG2TsiProperty()); 
     
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        actualiserLFIG();
        actualiserECOM();
        actualiserTSI();
    }    
    
}
