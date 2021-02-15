package Controller;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

public class ReglagedonneeController implements Initializable { 
    @FXML
    private JFXTextField mail;
    @FXML
    private JFXTextField login;
    @FXML
    private JFXPasswordField npas;
    @FXML
    private JFXPasswordField pas;
    @FXML
    private JFXTextField nlogin;
    private Connection connection;
    private dbconnect handler;
    private PreparedStatement pst;
    private ResultSet rs;
    @FXML
    void enregistre(ActionEvent event) {
        connection = handler.getConnection();
        String A=npas.getText();
        String L=mail.getText();
           if(empty()&&lonog() && recherch()){
           String update = "UPDATE utilisateur SET`password`='"+A+"' WHERE`email`='"+L+"'";
           try
                {  
                pst = connection.prepareStatement(update);
                int executeUpdate = pst.executeUpdate();
                 if(executeUpdate == 1)
                    {  Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Réussite de la modification");
                    alert.setContentText("Mot de passe modifié avec succés ");
                    alert.showAndWait();
                    }
                clear ();
                }
        catch (SQLException e1)
            {
                e1.printStackTrace();
            }
        finally {
                try
                {
                      connection.close();
                      
                }catch(SQLException e1)
                {
                      e1.printStackTrace();
                    
                }
        }
    
            
    }
    }
private boolean recherch()
{
       String q1 = "SELECT * FROM utilisateur where email='"+mail.getText()+"' and type='admin'";
        try{
                   pst = connection.prepareStatement(q1);
                   
                   rs = pst.executeQuery();
                   
                   int count = 0;
                   while(rs.next())
                   {
                        count = count+1;
                   }
                   if(count != 1)
                   {
                     Alert alert = new Alert(Alert.AlertType.ERROR);
                       alert.setHeaderText(null);
                       alert.setContentText("attention! Email ne correspond pas à un administrateur");
                       alert.show();
                       return false;
                       
                   }
                       clear ();              
 }catch(SQLException e1){
  e1.printStackTrace();
 }
       return true;
    }
   private void clear ()
{
    mail.setText(null);
    pas.setText(null);
    npas.setText(null);

}
    private boolean empty()
{
    if(mail.getText().isEmpty()| pas.getText().isEmpty() | npas.getText().isEmpty())
                { Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("erreur de remplissage");
                    alert.setContentText("Veuillez remplir les champs");
                    alert.showAndWait();
                    return false;
        
                    }
    return true;
}
private boolean lonog()
{
    if(mail.getText().length()<4|pas.getText().length()<8 | npas.getText().length()<8 )
                        {
                            Alert alert = new Alert(Alert.AlertType.WARNING);
                            alert.setTitle("erreur de remplissage");
                            alert.setContentText("Tailles incorrectes");
                            alert.showAndWait();
                            return false;
                        }
    return true;
}
private boolean emptyE()
{
    if(login.getText().isEmpty()| nlogin.getText().isEmpty() )
                { Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("erreur de remplissage");
                    alert.setContentText("Veuillez remplir les champs");
                    alert.showAndWait();
                    return false;
        
                    }
    return true;
}

    @FXML
    void modifier(ActionEvent event) {
         connection = handler.getConnection();
        String Z=nlogin.getText();
        String D=login.getText();
           if(emptyE()&&(nlogin.getText().length()<4) && recherch()){
               
           String update = "UPDATE utilisateur SET `email`='"+Z+"' WHERE `email`='"+D+"'";
        
          
          
        try
        {  
            pst = connection.prepareStatement(update);
            
            
               int executeUpdate = pst.executeUpdate();
               
               if(executeUpdate == 1)
                    {  Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Réussite de la modification");
                    alert.setContentText("Email modifié avec succés");
                    alert.showAndWait();
                    

                    }
                clear ();
               
        
        }
        catch (SQLException e1)
            {
                e1.printStackTrace();
            }
        finally {
                try{
                      connection.close();
                      
                }catch(SQLException e1){
                    e1.printStackTrace();
                    
                }
        }
    }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        handler = new dbconnect();
        
    }    
    
}
