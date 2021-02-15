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
public class InterfacAdminController implements Initializable {
@FXML
    private ListView<String> listenseig;

    @FXML
    private ListView<String> listutilisteur;

    @FXML
        private ListView<String>listplanning;
 

    @FXML
        private ListView<String> listeparameter;
  @FXML
    private ListView<String> listeviewcalend;

    @FXML
       private TabPane tbpane;

private void loalistview(){
ObservableList <String> ols = FXCollections.observableArrayList();
ols.add("Les garde Des Enseignants");
ols.add("Liste Des Enseignants");
ols.add("Activites Des Enseignants");
ols.add("Disponibilités Des Enseignants");
listenseig.setItems(ols);
}
private void loadCallistview(){
ObservableList <String> ols = FXCollections.observableArrayList();
ols.add("liste des utilisateurs");
listutilisteur.setItems(ols);
}
private void loadcalendrierlistview(){
ObservableList <String> ols = FXCollections.observableArrayList();
ols.add("Calendrier 1ere License");
ols.add("Calendrier 2eme License");
ols.add("Calendrier 3eme License");
ols.add("Calendrier 1Master ");
ols.add("Calendrier 2Master");
listeviewcalend.setItems(ols);
}
private void loadActlistview(){
ObservableList <String> ols = FXCollections.observableArrayList();
ols.add("Séance de planning");
ols.add("Planning Session Principale");
ols.add("Planning Session Rattrapage");
ols.add("Planning De DS");
listplanning.setItems(ols);
}
private void loadDisplistview(){
ObservableList <String> ols = FXCollections.observableArrayList();
ols.add("Modifier Mot de passe");
ols.add("Modifier Email");
listeparameter.setItems(ols);


        }
 private void selectmenu()
    {listenseig.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
          //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          int i=listenseig.getSelectionModel().getSelectedIndex();
          if(i==0)
          {
              try{
                  
                Node node =(AnchorPane)FXMLLoader.load(getClass().getResource("/View/grdEnseg.fxml"));
                    Tab tb = new Tab("Gestion des grade",node);
                    tbpane.getTabs().add(tb);
              
              
              }catch(IOException e)
              {
                  System.out.println("erreur");
                    
                  e.printStackTrace();
              }
          
          }else
          if(i==1)
          {
              try{
                  Node node =(AnchorPane)FXMLLoader.load(getClass().getResource("/View/Enseignants.fxml"));
                  Tab tb = new Tab("Gestion Des  enseignants",node);
                  tbpane.getTabs().add(tb);
              
              
              }catch(IOException e){System.out.println("erreur");
               e.printStackTrace();
              
              }
          
          }
          else if(i==2)
          {
              try{
                  Node node =(AnchorPane)FXMLLoader.load(getClass().getResource("/View/Param.fxml"));
                  Tab tb = new Tab("Gestion Des Activites des enseignants",node);
                  tbpane.getTabs().add(tb);
              
              
              }catch(IOException e){System.out.println("erreur");}
          
              
          }else 
          {try{
                  Node node =(AnchorPane)FXMLLoader.load(getClass().getResource("/View/disponibilites.fxml"));
                  Tab tb = new Tab("Gestion des disponibilites des enseignants",node);
                  tbpane.getTabs().add(tb);
              
              
              }catch(IOException e){System.out.println("erreur");
                                    e.printStackTrace();
              
              }
          
              
              
              
          }}        
    
    
    
    
    
    });
    
    
    
    }
private void selectactivites()
    {listutilisteur.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
          //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          int i=listutilisteur.getSelectionModel().getSelectedIndex();
          if(i==0)
          {
              try{
                  
                  Node node =(AnchorPane)FXMLLoader.load(getClass().getResource("/View/utilisateurs.fxml"));
                  
                  Tab tb = new Tab("Gestion Des Responsables",node);
                  
                  tbpane.getTabs().add(tb);
              
              
              }catch(IOException e){System.out.println("erreur");
              e.printStackTrace();
              }
          
          }
        
        }
    
    
    
    
    
    });
    
    
    
    }

private void selectcal()
    {listplanning.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
          //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          int i=listplanning.getSelectionModel().getSelectedIndex();
          if(i==0)
          {
              try{
                  Node node =(AnchorPane)FXMLLoader.load(getClass().getResource("/View/seance.fxml"));
                  Tab tb = new Tab("Séances des Survillance",node);
                  tbpane.getTabs().add(tb);
              
              
              }catch(IOException e){System.out.println("erreur");}
          
          }
          
          if(i==1)
          {
              try{
                  Node node =(AnchorPane)FXMLLoader.load(getClass().getResource("/View/planning.fxml"));
                  Tab tb = new Tab("Planning",node);
                  tbpane.getTabs().add(tb);
              
              
              }catch(IOException e){System.out.println("erreur");
              e.printStackTrace();
              }
          
          }else
              if(i==2)
          {
              try{
                  Node node =(AnchorPane)FXMLLoader.load(getClass().getResource("/View/PlanningSC.fxml"));
                  Tab tb = new Tab("Planning rattrapage",node);
                  tbpane.getTabs().add(tb);
              
              
              }catch(IOException e){System.out.println("erreur");
              e.printStackTrace();
              }
          
          }
          else
              if(i==3)
          {
              try{
                  Node node =(AnchorPane)FXMLLoader.load(getClass().getResource("/View/Plannificationds.fxml"));
                  Tab tb = new Tab("Planning DS",node);
                  tbpane.getTabs().add(tb);
              
              
              }catch(IOException e){System.out.println("erreur");
              e.printStackTrace();
              }
          
          }
        }
    
    
    
    
    
    });
    
    
    
    }
private void selectParameter()
    {listeparameter.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
          //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          int i=listeparameter.getSelectionModel().getSelectedIndex();
          if(i==0)
          {
              try{
                  Node node =(AnchorPane)FXMLLoader.load(getClass().getResource("/View/reglagedonnee.fxml"));
                  Tab tb = new Tab("Modifier Mot de passe",node);
                  tbpane.getTabs().add(tb);
              
              
              }catch(IOException e){System.out.println("erreur");}
          
          }
          else if(i==1){
              try{
                  Node node =(AnchorPane)FXMLLoader.load(getClass().getResource("/View/reglagedonnee.fxml"));
                  Tab tb = new Tab("Modifier Email",node);
                  tbpane.getTabs().add(tb);
              
              
              }catch(IOException e){System.out.println("erreur");}}
        }
    });
       

}
private void selectCalendrier()
    { listeviewcalend.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
          //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          int i= listeviewcalend.getSelectionModel().getSelectedIndex();
          if(i==0)
          {
              try{
                  Node node =(AnchorPane)FXMLLoader.load(getClass().getResource("/View/Consult1Lisence.fxml"));
                  Tab tb = new Tab("Les Calendrier 1ere License",node);
                  tbpane.getTabs().add(tb);
              
              
              }catch(IOException e){System.out.println("erreur");}
          
          }
          else if(i==1){
              try{
                  Node node =(AnchorPane)FXMLLoader.load(getClass().getResource("/View/Consult2Lisence.fxml"));
                  Tab tb = new Tab("Calendrier 2eme Lisence",node);
                  tbpane.getTabs().add(tb);
              
              
              }catch(IOException e){System.out.println("erreur");
              e.printStackTrace();
              
              }
          }
          else if(i==2){
              try{
                  Node node =(AnchorPane)FXMLLoader.load(getClass().getResource("/View/Consult3Lisence.fxml"));
                  Tab tb = new Tab("Les Calendrier du 3eme Lisence",node);
                  tbpane.getTabs().add(tb);
              
              
              }catch(IOException e){System.out.println("erreur");
              e.printStackTrace();
              
              }
          }
          else if(i==3){
              try{
                  Node node =(AnchorPane)FXMLLoader.load(getClass().getResource("/View/Consult1Master.fxml"));
                  Tab tb = new Tab("Calendrier 1 Master",node);
                  tbpane.getTabs().add(tb);
              
              
              }catch(IOException e){System.out.println("erreur");
              e.printStackTrace();
              
              }
          }
           else if(i==4){
              try{
                  Node node =(AnchorPane)FXMLLoader.load(getClass().getResource("/View/Cosult2Master.fxml"));
                  Tab tb = new Tab("Calendrier 2eme Master",node);
                  tbpane.getTabs().add(tb);
              
              
              }catch(IOException e){System.out.println("erreur");
              e.printStackTrace();
              
              }
          }
        }
    });
       

}

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loalistview();
    loadCallistview();
    loadActlistview();
    loadDisplistview();
    loadcalendrierlistview();
    selectmenu();
    selectactivites();
    selectParameter();
    selectCalendrier();
    selectcal();
    }    
    @FXML
    void logaut(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/Connexion.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
    }    
    