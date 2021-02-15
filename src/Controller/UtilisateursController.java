package Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
public class UtilisateursController implements Initializable {

    @FXML
   static  AnchorPane home;
   
    @FXML
    private JFXTextField id;

     @FXML
    private JFXTextField email;
       @FXML
    private JFXPasswordField mdp1;

@FXML
    private JFXButton annuler;
   @FXML
    private JFXRadioButton admin;

    @FXML
    private JFXRadioButton responsable;


    @FXML
    private JFXButton ajouter;
    @FXML
    private JFXTextField type;

    
    @FXML
    private ToggleGroup gender;
    @FXML
    private JFXPasswordField mdp;
    @FXML
     
    private TableView<tablevewe> utilisateurs;
   

    @FXML
    private TableColumn<tablevewe, String> colemail;

    @FXML
    private TableColumn<tablevewe, String> colpas;

    @FXML
    private TableColumn<tablevewe, String> coltype;
      @FXML
    private JFXTextField syp;
    
    private Connection connection;
    private dbconnect handler;
    private PreparedStatement pst;
    private ResultSet rs =null;
    private ObservableList<tablevewe> data;
    
    @FXML
    void supprimer(ActionEvent event) {
       if(syp.getText().isEmpty())
       {Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("erreur de suppression");
                    alert.setContentText("Voud devez saisir un email");
                    alert.showAndWait();
        }
       else{
        Alert alert = new Alert (AlertType.CONFIRMATION);
        alert.setTitle("Conformation de suppression");
        alert.setHeaderText(null);
        alert.setContentText("Vous etes sure?");
        Optional <ButtonType>action = alert.showAndWait();
        
        if(action.get()==ButtonType.OK){
            
        try{
        connection = handler.getConnection();
            
        String sql ="delete from utilisateur where email='"+syp.getText()+"'";
        pst = connection.prepareStatement(sql);
        int i= pst.executeUpdate();
        syp.setText(null);
        if(i==1)
        {
                    alert = new Alert(AlertType.WARNING);
                    alert.setTitle("Réussite de suppression");
                    alert.setContentText("Utilisateur supprimé");
                    alert.showAndWait();
        }
       
                actualiser();
    
                }catch (SQLException e1)
            {
                e1.printStackTrace();
            }
        
    }}

    }
private void clear ()
{
    email.setText(null);
    mdp1.setText(null);
    mdp.setText(null);
    type.setText(null);

}
 @FXML
    void annulation(ActionEvent event) {
        clear();
    }
private boolean empty()
{
    if(email.getText().isEmpty()| mdp.getText().isEmpty() | mdp1.getText().isEmpty() |type.getText().isEmpty())
                {   Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("erreur de remplissage");
                    alert.setContentText("Veuillez remplir ce champ");
                    alert.showAndWait();
                    return false;
        
                }
    return true;
}
private boolean eq()
    {
       
        if(!mdp.getText().equals(mdp1.getText()))
       
                        {
                         Alert alert = new Alert(AlertType.WARNING);
                            alert.setTitle("erreur de remplissage");
                            alert.setContentText("les deux mot de passe doivent etre identiques ");
                            alert.showAndWait();
                            return false;   
                        }
    return true;
    }

private boolean lonog()
{
    if(email.getText().length()<4 |mdp.getText().length()<8 | mdp1.getText().length()<8 )
                        {
                            Alert alert = new Alert(AlertType.WARNING);
                            alert.setTitle("erreur de remplissage");
                            alert.setContentText("taille email doit etre >4 et taille de mot de passe doit etre>8");
                            alert.showAndWait();
                            return false;
                        }
    return true;
}
private boolean typeRA()
{
    if((!type.getText().equals("responsable")) &&(!type.getText().equals("Responsable"))  )
                        {
                            Alert alert = new Alert(AlertType.ERROR);
                            alert.setTitle("erreur de remplissage");
                            alert.setContentText("type doit etre responsable");
                            alert.showAndWait();
                            return false;
                        }
 return true;
}
private boolean recherch()
{
           String q1 = "SELECT * FROM utilisateur where email='"+email.getText()+"' ";
        try{
                   pst = connection.prepareStatement(q1);
                   
                   rs = pst.executeQuery();
                   
                   int count = 0;
                   while(rs.next())
                   {
                        count = count+1;
                   }
                   if(count == 1)
                   {
                     Alert alert = new Alert(Alert.AlertType.ERROR);
                       alert.setHeaderText(null);
                       alert.setContentText("email déja existant");
                       alert.show();
                       return false;
                       
                   }
                                    
            }catch(SQLException e1)
                {
                    e1.printStackTrace();
 
                }
        
        return true;
    }

    @FXML
    void ajouter(ActionEvent event) throws SQLException {
      
      connection = handler.getConnection();
        
           if(empty()&&lonog() &&eq() && recherch()&& typeRA())
           { 
            String insert = "INSERT INTO utilisateur (email, password, type) VALUES ('"+email.getText()+"','"+mdp.getText()+"','"+type.getText()+"')";
        try
        {  
            pst = connection.prepareStatement(insert);
               int executeUpdate = pst.executeUpdate();
          
               if(executeUpdate == 1)
                    {  Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Réussite de l'ajout");
                    alert.setContentText("utlisateur ajouté avec succés");
                    alert.showAndWait();
                    }
                clear ();
                actualiser();
        
        }
        catch (SQLException e1)
            {
                e1.printStackTrace();
            }
        finally 
        {
                try{
                      connection.close();
                      
                   }catch(SQLException e1)
                    {
                        e1.printStackTrace();
                    
                    }
        }
    
            
            }
    }
    
   

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        handler = new dbconnect();
        data = FXCollections.observableArrayList();
        setCellTable();
        affdata();
    }  
   
    
    private void setCellTable()
    {
        colemail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colpas.setCellValueFactory(new PropertyValueFactory<>("password"));
        coltype.setCellValueFactory(new PropertyValueFactory<>("type"));
        
    }
   private void actualiser()
   {
        data.clear();
        affdata();
   
   }
//throws SQLException ken n7b na3ml nenzl 3la butt nzid hedi ll void affdata
    private void affdata(){

      connection = handler.getConnection();
try {
    
        pst = connection.prepareStatement("SELECT * FROM utilisateur");
        

        rs = pst.executeQuery();
        while(rs.next())
        {
            data.add(new tablevewe (rs.getString("email"),rs.getString("password"),rs.getString("type")));
            
            
            utilisateurs.setItems(data);
        }pst.close();
        rs.close();
    } catch (SQLException ex) {
        ex.printStackTrace();
        

    }
  
    }
    }
