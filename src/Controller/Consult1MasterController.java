/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class Consult1MasterController implements Initializable {
EntityManager em;
   public static EntityManagerFactory emf;
    ObservableList<Mecom1fx> dataMecom;
    ObservableList<Mbds1fx> dataMbds;
    ObservableList<Vic1fx> dataVic;
    ObservableList<Wi1fx> dataWi;
   
    
    
    @FXML
    private TableView<Mecom1fx> mecom1;

    @FXML
    private TableColumn<Mecom1fx, Number> idl;

    @FXML
    private TableColumn<Mecom1fx, String> jourl;

    @FXML
    private TableColumn<Mecom1fx, String> datel;

    @FXML
    private TableColumn<Mecom1fx, String> matieresl;

    @FXML
    private TableColumn<Mecom1fx, String> horairel;

    @FXML
    private TableColumn<Mecom1fx, String> dureel;

    @FXML
    private TableColumn<Mecom1fx, String> sg1l;

    
    @FXML
    private TableView<Mbds1fx> mbds1;

    @FXML
    private TableColumn<Mbds1fx, Number> idt;

    @FXML
    private TableColumn<Mbds1fx, String> jourt;

    @FXML
    private TableColumn<Mbds1fx, String> datet;

    @FXML
    private TableColumn<Mbds1fx, String> matierest;

    @FXML
    private TableColumn<Mbds1fx, String> horairet;

    @FXML
    private TableColumn<Mbds1fx, String> dureet;

   

    @FXML
    private TableColumn<Mbds1fx, String> sg1t;

    
    @FXML
    private TableView<Vic1fx> vic1;

    @FXML
    private TableColumn<Vic1fx, Number> idv;

    @FXML
    private TableColumn<Vic1fx, String> jourv;

    @FXML
    private TableColumn<Vic1fx, String> datev;

    @FXML
    private TableColumn<Vic1fx, String> matieresv;

    @FXML
    private TableColumn<Vic1fx, String> horairev;

    @FXML
    private TableColumn<Vic1fx, String> dureev;

    @FXML
    private TableColumn<Vic1fx, String> sg1v;

   @FXML
    private TableView<Wi1fx> wi1;

    @FXML
    private TableColumn<Wi1fx, Number> idw;

    @FXML
    private TableColumn<Wi1fx, String> jourw;

    @FXML
    private TableColumn<Wi1fx, String> datew;

    @FXML
    private TableColumn<Wi1fx, String> matieresw;

    @FXML
    private TableColumn<Wi1fx, String> horairew;

    @FXML
    private TableColumn<Wi1fx, String> dureew;

    @FXML
    private TableColumn<Wi1fx, String> sg1w;

    private void actualiserMecom()
    {
        emf=Persistence.createEntityManagerFactory("ESENPU");
        em = Consult1MasterController.emf.createEntityManager();
        emf=Persistence.createEntityManagerFactory("ESENPU");
        mecom1.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
                
        List<Mecom1>lst = em.createQuery("SELECT m FROM Mecom1 m").getResultList();
        
        dataMecom=FXCollections.observableArrayList();
        for(Mecom1 lst1:lst){
           
        dataMecom.add(new Mecom1fx(lst1.getIdMecom1(),lst1.getJour(),lst1.getDate(),lst1.getMatieres(),lst1.getHoraire(),lst1.getDuree(),lst1.getSalle()));
        }
        mecom1.setItems(dataMecom);
        idl.setCellValueFactory(cell->cell.getValue().getIdMecom1Property());
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
        em = Consult1MasterController.emf.createEntityManager();
        emf=Persistence.createEntityManagerFactory("ESENPU");
        mbds1.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
                
        List<Mbds1>lst = em.createQuery("SELECT m FROM Mbds1 m").getResultList();
        
        dataMbds=FXCollections.observableArrayList();
        for(Mbds1 lst1:lst){
           
        dataMbds.add(new Mbds1fx(lst1.getIdmbds1(),lst1.getJourMbds(),lst1.getDateMbds(),lst1.getMatieresMbds(),lst1.getHoraireMbds(),lst1.getDureeMbds(),lst1.getSalleMbds()));
        }
        mbds1.setItems(dataMbds);
        idt.setCellValueFactory(cell->cell.getValue().getIdmbds1Property());
        jourt.setCellValueFactory(cell->cell.getValue().getJourMbdsProperty());
        datet.setCellValueFactory(cell->cell.getValue().getDateMbdsProperty());
        matierest.setCellValueFactory(cell->cell.getValue().getMatieresMbdsProperty());
        horairet.setCellValueFactory(cell->cell.getValue().getHoraireMbdsProperty());
        dureet.setCellValueFactory(cell->cell.getValue().getDureeMbdsProperty());  
        sg1t.setCellValueFactory(cell->cell.getValue().getSalleMbdsProperty()); 
    
    }
    private void actualiserVic()
    {
        emf=Persistence.createEntityManagerFactory("ESENPU");
        em = Consult1MasterController.emf.createEntityManager();
        emf=Persistence.createEntityManagerFactory("ESENPU");
        vic1.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
                
        List<Vic1>lst = em.createQuery("SELECT v FROM Vic1 v").getResultList();
        
        dataVic=FXCollections.observableArrayList();
        for(Vic1 lst1:lst){
           
        dataVic.add(new Vic1fx(lst1.getIdvic1(),lst1.getJourVic(),lst1.getDateVic(),lst1.getMatieresVic(),lst1.getHoraireVic(),lst1.getDureeVic(),lst1.getSalleVic()));
        }
        vic1.setItems(dataVic);
        idv.setCellValueFactory(cell->cell.getValue().getIdvic1Property());
        jourv.setCellValueFactory(cell->cell.getValue().getJourVicProperty());
        datev.setCellValueFactory(cell->cell.getValue().getDateVicProperty());
        matieresv.setCellValueFactory(cell->cell.getValue().getMatieresVicProperty());
        horairev.setCellValueFactory(cell->cell.getValue().getHoraireVicProperty());
        dureev.setCellValueFactory(cell->cell.getValue().getDureeVicProperty());  
        sg1v.setCellValueFactory(cell->cell.getValue().getSalleVicProperty()); 
     
    }
    private void actualiserWi()
    {
        emf=Persistence.createEntityManagerFactory("ESENPU");
        em = Consult1MasterController.emf.createEntityManager();
        emf=Persistence.createEntityManagerFactory("ESENPU");
        wi1.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
                
        List<Wi1>lst = em.createQuery("SELECT w FROM Wi1 w").getResultList();
        
        dataWi=FXCollections.observableArrayList();
        for(Wi1 lst1:lst){
           
        dataWi.add(new Wi1fx(lst1.getIdwi1(),lst1.getJourWi(),lst1.getDateWi(),lst1.getMatieresWi(),lst1.getHoraireWi(),lst1.getDureeWi(),lst1.getSalleWi()));
        }
        wi1.setItems(dataWi);
        idw.setCellValueFactory(cell->cell.getValue().getIdwi1Property());
        jourw.setCellValueFactory(cell->cell.getValue().getJourWiProperty());
        datew.setCellValueFactory(cell->cell.getValue().getDateWiProperty());
        matieresw.setCellValueFactory(cell->cell.getValue().getMatieresWiProperty());
        horairew.setCellValueFactory(cell->cell.getValue().getHoraireWiProperty());
        dureew.setCellValueFactory(cell->cell.getValue().getDureeWiProperty());  
        sg1w.setCellValueFactory(cell->cell.getValue().getSalleWiProperty()); 
    
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        actualiserMecom();
        actualiserMbds();
        actualiserVic();
        actualiserWi();
    }    
    
}
