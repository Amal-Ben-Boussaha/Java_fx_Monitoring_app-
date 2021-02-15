/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Amal Ben Boussaha
 */
public class InterfacRespController implements Initializable {
    @FXML
    private ListView<String> livmaster;

    @FXML
    private TabPane tbpane;


    @FXML
    private ListView<String> listCal;

    @FXML
    private ListView<String> listactivites;

    @FXML
    private ListView<String> listdisponibilites;

    @FXML
    private ListView<String> listsalles;

    @FXML
    private ListView<String> listeetudiants;
    @FXML
    private ListView<String> listparameter;
      @FXML
    void deconnexion(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/Connexion.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));
    
    }
private void loadlistview(){
ObservableList <String> ols = FXCollections.observableArrayList();
ols.add("Interface de Matières");
livmaster.setItems(ols);
}
private void loadCallistview(){
ObservableList <String> ols = FXCollections.observableArrayList();
ols.add("Séances des examen");
ols.add("Calendriers 1ere LFIG");
ols.add("Calendriers 1ere TSI");
ols.add("Calendriers 1ere ECOM");
ols.add("Calendriers 2 LFIG");
ols.add("Calendriers 2 TSI");
ols.add("Calendriers 2 ECOM");
ols.add("Calendriers 3 LFIG");
ols.add("Calendriers 3 TSI");
ols.add("Calendriers 3 ECOM");
ols.add("Calendriers 1 MECOM");
ols.add("Calendriers 1 MDBS");
ols.add("Calendriers 1 VIC");
ols.add("Calendriers 1 WI");
ols.add("Calendriers 2 MECOM");
ols.add("Calendriers 2 MDBS");
ols.add("Calendriers 2 VIC");
ols.add("Calendriers 2 WI");

listCal.setItems(ols);
}
private void loadActlistview(){
ObservableList <String> ols = FXCollections.observableArrayList();
ols.add("Activités des enseignants");
listactivites.setItems(ols);
}
private void loadDisplistview(){
ObservableList <String> ols = FXCollections.observableArrayList();
ols.add("Disponibilités des enseignants");
listdisponibilites.setItems(ols);


        }
private void loadSallelistview(){
ObservableList <String> ols = FXCollections.observableArrayList();
ols.add("Liste des salles");
listsalles.setItems(ols);
}
private void loadEtudlistview(){
ObservableList <String> ols = FXCollections.observableArrayList();
ols.add("Liste des apprenants");
listeetudiants.setItems(ols);

}
private void loadParmtlistview(){
ObservableList <String> ols = FXCollections.observableArrayList();
ols.add("Modifier Mot de passe");
ols.add("Modifier email");

listparameter.setItems(ols);
}
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       loadlistview();
       loadCallistview(); 
       loadActlistview();
       loadDisplistview();
       loadSallelistview();
       loadParmtlistview();
       selectmenu();
       selectactivites();
       selectcal();
       selectParameter();
       selectdisp();
       selectaSalle();
    }    
    
    
    private void selectmenu()
    {livmaster.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
          //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          int i=livmaster.getSelectionModel().getSelectedIndex();
          if(i==0)
          {
              try{
                  Node node =(AnchorPane)FXMLLoader.load(getClass().getResource("/View/Matieres.fxml"));
                  Tab tb = new Tab("Gestion Matiéres",node);
                  tbpane.getTabs().add(tb);
              
              
              }catch(IOException e){System.out.println("erreur");}
          
          }
        
        }
    
    
    
    
    
    });
    
    
    
    }
private void selectactivites()
    {listactivites.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
          //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          int i=listactivites.getSelectionModel().getSelectedIndex();
          if(i==0)
          {
              try{
                  
                  Node node =(AnchorPane)FXMLLoader.load(getClass().getResource("/View/Param.fxml"));
                  
                  Tab tb = new Tab("Activites des enseignants",node);
                  
                  tbpane.getTabs().add(tb);
              
              
              }catch(IOException e){System.out.println("erreur");
              e.printStackTrace();
              }
          
          }
        
        }
    
    
    
    
    
    });
    
    
    
    }

private void selectcal()
    {listCal.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
          //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          int i=listCal.getSelectionModel().getSelectedIndex();
          if(i==0)
          {
              try{
                  Node node =(AnchorPane)FXMLLoader.load(getClass().getResource("/View/seance.fxml"));
                  Tab tb = new Tab("Gestion des séances des examens",node);
                  tbpane.getTabs().add(tb);
              
              
              }catch(IOException e){System.out.println("erreur");}
          
          }
          else if(i==1)
          {
              try{
                  Node node =(AnchorPane)FXMLLoader.load(getClass().getResource("/View/calendreir.fxml"));
                  Tab tb = new Tab("Calendreir des examen de 1ere LFIG",node);
                  tbpane.getTabs().add(tb);
              
              
              }catch(IOException e){System.out.println("erreur");
                e.printStackTrace();
              }
          
          }
        else if(i==2)
          {
              try{
                  Node node =(AnchorPane)FXMLLoader.load(getClass().getResource("/View/Tsicalen.fxml"));
                  Tab tb = new Tab("Calendreir des examen de 1ere TSI",node);
                  tbpane.getTabs().add(tb);
              
              
              }catch(IOException e){System.out.println("erreur");}
          
          }
          else if(i==3)
          {
              try{
                  Node node =(AnchorPane)FXMLLoader.load(getClass().getResource("/View/ecomCaln.fxml"));
                  Tab tb = new Tab("Calendreir des examen de 1ere ECOM",node);
                  tbpane.getTabs().add(tb);
              
              
              }catch(IOException e){System.out.println("erreur");
              e.printStackTrace();}
          
          }
          else if(i==4)
          {
              try{
                  Node node =(AnchorPane)FXMLLoader.load(getClass().getResource("/View/cal2LFIG.fxml"));
                  Tab tb = new Tab("Calendreir des examen de 2eme LFIG",node);
                  tbpane.getTabs().add(tb);
              
              
              }catch(IOException e){System.out.println("erreur");
              e.printStackTrace();}
          
          }
        else if(i==5)
          {
              try{
                  Node node =(AnchorPane)FXMLLoader.load(getClass().getResource("/View/cla2tsi.fxml"));
                  Tab tb = new Tab("Calendreir des examen de 2eme TSI",node);
                  tbpane.getTabs().add(tb);
              
              
              }catch(IOException e){System.out.println("erreur");
              e.printStackTrace();}
          
          }
         
        else if(i==6)
          {
              try{
                  Node node =(AnchorPane)FXMLLoader.load(getClass().getResource("/View/cal2ecom.fxml"));
                  Tab tb = new Tab("Calendreir des examen de 2eme ECOM",node);
                  tbpane.getTabs().add(tb);
              
              
              }catch(IOException e){System.out.println("erreur");
              e.printStackTrace();}
          
          }
        else if(i==7)
          {
              try{
                  Node node =(AnchorPane)FXMLLoader.load(getClass().getResource("/View/cal3lfig.fxml"));
                  Tab tb = new Tab("Calendreir des examen de 3eme LFIG",node);
                  tbpane.getTabs().add(tb);
              
              
              }catch(IOException e){System.out.println("erreur");
              e.printStackTrace();}
          
          }
        else if(i==8)
          {
              try{
                  Node node =(AnchorPane)FXMLLoader.load(getClass().getResource("/View/cal3tsi.fxml"));
                  Tab tb = new Tab("Calendreir des examen de 3eme TSI",node);
                  tbpane.getTabs().add(tb);
              
              
              }catch(IOException e){System.out.println("erreur");
              e.printStackTrace();}
          
          }
        else if(i==9)
          {
              try{
                  Node node =(AnchorPane)FXMLLoader.load(getClass().getResource("/View/cal3ecom.fxml"));
                  Tab tb = new Tab("Calendreir des examen de 3eme ECOM",node);
                  tbpane.getTabs().add(tb);
              
              
              }catch(IOException e){System.out.println("erreur");
              e.printStackTrace();}
          
          }
        else if(i==10)
          {
              try{
                  Node node =(AnchorPane)FXMLLoader.load(getClass().getResource("/View/cal1mecom.fxml"));
                  Tab tb = new Tab("Calendreir des examens de 1ere MECOM",node);
                  tbpane.getTabs().add(tb);
              
              
              }catch(IOException e){System.out.println("erreur");
              e.printStackTrace();}
          
          }
        else if(i==11)
          {
              try{
                  Node node =(AnchorPane)FXMLLoader.load(getClass().getResource("/View/cal1mbds.fxml"));
                  Tab tb = new Tab("Calendreir des examens de 1ere MBDS",node);
                  tbpane.getTabs().add(tb);
              
              
              }catch(IOException e){System.out.println("erreur");
              e.printStackTrace();}
          
          }
        
        else if(i==12)
          {
              try{
                  Node node =(AnchorPane)FXMLLoader.load(getClass().getResource("/View/cal1vic.fxml"));
                  Tab tb = new Tab("Calendreir des examens de 1ere VIC",node);
                  tbpane.getTabs().add(tb);
              
              
              }catch(IOException e){System.out.println("erreur");
              e.printStackTrace();}
          
          }
        else if(i==13)
          {
              try{
                  Node node =(AnchorPane)FXMLLoader.load(getClass().getResource("/View/cal1wi.fxml"));
                  Tab tb = new Tab("Calendreir des examens de 1ere WI",node);
                  tbpane.getTabs().add(tb);
              
              
              }catch(IOException e){System.out.println("erreur");
              e.printStackTrace();}
          
          }
        else if(i==14)
          {
              try{
                  Node node =(AnchorPane)FXMLLoader.load(getClass().getResource("/View/cal2mecom.fxml"));
                  Tab tb = new Tab("Calendreir des examens de 2eme MECOM",node);
                  tbpane.getTabs().add(tb);
              
              
              }catch(IOException e){System.out.println("erreur");
              e.printStackTrace();}
          
          }
        else if(i==15)
          {
              try{
                  Node node =(AnchorPane)FXMLLoader.load(getClass().getResource("/View/cal2mbds.fxml"));
                  Tab tb = new Tab("Calendreir des examens de 2eme MBDS",node);
                  tbpane.getTabs().add(tb);
              
              
              }catch(IOException e){System.out.println("erreur");
              e.printStackTrace();}
          
          }
        else if(i==16)
          {
              try{
                  Node node =(AnchorPane)FXMLLoader.load(getClass().getResource("/View/cal2vic.fxml"));
                  Tab tb = new Tab("Calendreir des examens de 2eme VIC",node);
                  tbpane.getTabs().add(tb);
              
              
              }catch(IOException e){System.out.println("erreur");
              e.printStackTrace();}
          
          }
        else if(i==17)
          {
              try{
                  Node node =(AnchorPane)FXMLLoader.load(getClass().getResource("/View/cal2wi.fxml"));
                  Tab tb = new Tab("Calendreir des examens de 2eme WI",node);
                  tbpane.getTabs().add(tb);
              
              
              }catch(IOException e){System.out.println("erreur");
              e.printStackTrace();}
          
          }
        
        }
    
    
    
    
    
    });
    
    
    
    }
private void selectParameter()
    {listparameter.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
          //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          int i=listparameter.getSelectionModel().getSelectedIndex();
          if(i==0)
          {
              try{
                  Node node =(AnchorPane)FXMLLoader.load(getClass().getResource("/View/reglagedonnee.fxml"));
                  Tab tb = new Tab("Modifier Mod de passe",node);
                  tbpane.getTabs().add(tb);
              
              
              }catch(IOException e){System.out.println("erreur");}
          
          }
          else if(i==1){
              try{
                  Node node =(AnchorPane)FXMLLoader.load(getClass().getResource("/View/reglagedonnee.fxml"));
                  Tab tb = new Tab("Modifier Email",node);
                  tbpane.getTabs().add(tb);
              
              
              }catch(IOException e){System.out.println("erreur");
                e.printStackTrace();
              }}
        }
    });
    
    
    
    }
private void selectdisp()
    {listdisponibilites.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
          //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          int i=listdisponibilites.getSelectionModel().getSelectedIndex();
          if(i==0)
          {
              try{
                  Node node =(AnchorPane)FXMLLoader.load(getClass().getResource("/View/disponibilites.fxml"));
                  Tab tb = new Tab("Gestion des Disponibilites des enseignants",node);
                  tbpane.getTabs().add(tb);
              
              
              }catch(IOException e){
                  System.out.println("erreur");
                  e.printStackTrace();
              }
          
          }
        
        }
    
    
    
    
    
    });
    
    
    
    }
private void selectaSalle()
    {listsalles.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
          //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          int i=listsalles.getSelectionModel().getSelectedIndex();
          if(i==0)
          {
              try{
                  Node node =(AnchorPane)FXMLLoader.load(getClass().getResource("/View/salle_examen.fxml"));
                  Tab tb = new Tab("Gestion des salles",node);
                  tbpane.getTabs().add(tb);
              
              
              }catch(IOException e){System.out.println("erreur");}
          
          }
        
        }
    
    
    
    
    
    });
    
    
    
    }


    
}
