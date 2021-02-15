package Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Amal Ben Boussaha
 */
public class ConnexionController implements Initializable {

    @FXML
    private Label label;
   

    @FXML
    private JFXTextField log;

      @FXML
    private JFXPasswordField pas;
    @FXML
    private JFXButton bottn;
    private  dbconnect handler ;
    private Connection connection;
   private PreparedStatement pst;
   private static  ConnexionController instance;
public ConnexionController()
    {
        instance = this;
   }
public static ConnexionController getInstance()
{
    return instance;
}
public  String log()
{
    return log.getText();

}
private String    typeREPAD()
 {   String day="";
        try {
            pst = connection.prepareStatement("SELECT type FROM utilisateur where email='"+log.getText()+"' ");
            ResultSet rs = pst.executeQuery();
            while(rs.next())
            {
                day=rs.getString(1);
             
            }
        
        
        } catch (SQLException ex) {
/*            Logger.getLogger(ParametController.class.getName()).log(Level.SEVERE, null, ex);*/
        }
 
 return day;
 
 }

   @FXML
    void connecter(ActionEvent event)throws SQLException, IOException {
        String username, mdp;
        username = log.getText();
        mdp = pas.getText();
        connection = handler.getConnection();
        String q1 = "SELECT * FROM utilisateur where email='"+username+"' and password ='"+mdp+"' ";
         try{
            String tpe=typeREPAD();
                   pst = connection.prepareStatement(q1);
                  ResultSet rs = pst.executeQuery();
                  int count = 0;
                  while(rs.next())
                   {
                        count = count+1;
                   }
                   if(count == 1)
                    {if(tpe.equals("responsable"))
                    {Parent root = FXMLLoader.load(getClass().getResource("/View/interfacResp.fxml"));
                        Node node = (Node) event.getSource();
                        Stage stage = (Stage) node.getScene().getWindow();
                        stage.setScene(new Scene(root));
                   
                    }else
                     {
                       Parent root = FXMLLoader.load(getClass().getResource("/View/interfacAdmin.fxml"));
                        Node node = (Node) event.getSource();
                        Stage stage = (Stage) node.getScene().getWindow();
                        stage.setScene(new Scene(root));
                   
                     }
                    }else
                   {
                       Alert alert = new Alert(Alert.AlertType.ERROR);
                       alert.setHeaderText(null);
                       alert.setContentText("Identifiant incorrecte");
                       alert.show();
                   }
            }catch(SQLException e1){
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
   
    @FXML
    void connection (KeyEvent event) throws IOException {
       String username, mdp;
        username = log.getText();
        mdp = pas.getText();
        connection = handler.getConnection();
        String tpe=typeREPAD();
        
        if( event.getCode()==KeyCode.ENTER)
       {
        String q1 = "SELECT * FROM utilisateur where email='"+username+"' and password ='"+mdp+"' ";
            try{
                   pst = connection.prepareStatement(q1);
                   
                    ResultSet rs = pst.executeQuery();
                    int count = 0;
                    while(rs.next())
                        {
                          count = count+1;
                        }
                   if(count == 1)
                    {if(tpe.equals("responsable"))
                        {Parent root = FXMLLoader.load(getClass().getResource("/View/interfacResp.fxml"));
                        Node node = (Node) event.getSource();
                        Stage stage = (Stage) node.getScene().getWindow();
                        stage.setScene(new Scene(root));
                   
                        }
                    else
                   
                   {
                       Parent root = FXMLLoader.load(getClass().getResource("/View/interfacAdmin.fxml"));
                        Node node = (Node) event.getSource();
                        Stage stage = (Stage) node.getScene().getWindow();
                        stage.setScene(new Scene(root));
                   
                   }
                   }
                        else
                        {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setHeaderText(null);
                            alert.setContentText("Identifiant incorrecte");
                            alert.show();
                       
                  
                        
                   
                        }
 }catch(SQLException e1){
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
      log.setStyle("fx-text-inner-color : #a0a2ab;");
      pas.setStyle("fx-text-inner-color : #a0a2ab;");
      handler = new dbconnect();
    }    
    }    
    
