package Controller;

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
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class Frmcal2mecomController implements Initializable {
    @FXML
    private TextField jour_txt;
    @FXML
    private TextField date_txt;
    @FXML
    private TextField matieres_txt;
    @FXML
    private TextField horaire_txt;
    @FXML
    private TextField duree_txt;
    @FXML
     private TextField salle_txt;
    private Connection connection;
    private dbconnect handler;
    private PreparedStatement pst;  
   private ResultSet rs;
    EntityManager em;  
    Mecom2 mecom2;
    boolean editmode = false;
    double x= 0,y =0;
    @FXML
    void dragged(MouseEvent event) {
         Node node = (Node) event.getSource();
         Stage stage =(Stage)node.getScene().getWindow();
        stage.setX(event.getScreenX() -x);
        stage.setY(event.getScreenY() -y);
    }
     @FXML
    void pressed(MouseEvent event) {
        x=event.getSceneX();
        y=event.getSceneY();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       handler = new dbconnect();
       em = Cal2mecomController.emf.createEntityManager();
    }    
    
    public void setEcom(int idmecom2)
     {
        Query q = em.createQuery("SELECT m FROM Mecom2 m WHERE m.idmecom2 = :idmecom2");
        q.setParameter("idmecom2", new Integer(idmecom2));
        mecom2 = (Mecom2) q.getSingleResult();
        jour_txt.setText(mecom2.getJour());
        date_txt.setText(mecom2.getDate());
        matieres_txt.setText(mecom2.getMatieres());
        horaire_txt.setText(mecom2.getHoraire());
        duree_txt.setText(mecom2.getDuree());
        salle_txt.setText(mecom2.getSalle());
        editmode = true;
     
     }
    @FXML
    private void enregistrer(ActionEvent event) {
        connection = handler.getConnection();
            if (!editmode) {
            mecom2 = new Mecom2();
        }
        if(empty()&&recherch_mat()&&verif()&&salle_wi2()&&salle_wi()&&salle_vic()&&salle_vic2()&&salle_mbds()&&salle_mbds2()&&salle_mecom())
           
        {
            mecom2.setJour(jour_txt.getText());
            mecom2.setDate(date_txt.getText());
            mecom2.setMatieres(matieres_txt.getText());
            mecom2.setHoraire(horaire_txt.getText());
            mecom2.setDuree(duree_txt.getText());
            mecom2.setSalle(salle_txt.getText());
            em.getTransaction().begin();
            em.persist(mecom2);
            em.getTransaction().commit();
            em.close();
            annuler(event);
        }
        
    }

    @FXML
    private void verifier(ActionEvent event) {
        
        connection = handler.getConnection();
         if(empty()&&recherch_mat()&&recherch_disp()&&verif()&&Repmat()&&Repdur()&&salle_wi2()&&salle_wi()&&salle_vic()&&salle_vic2()&&salle_mbds()&&salle_mbds2()&&salle_mecom())
     {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("interface d'information");
         alert.setContentText("Examen bien planifier");
         alert.showAndWait();  
     }
    }

    @FXML
    private void annuler(ActionEvent event) {
        Node node = (Node) event.getSource();
         Stage stage =(Stage)node.getScene().getWindow();
         stage.close();
    }
   private boolean empty()
{
    if(jour_txt.getText().isEmpty()| date_txt.getText().isEmpty() | horaire_txt.getText().isEmpty() |matieres_txt.getText().isEmpty()|duree_txt.getText().isEmpty()|salle_txt.getText().isEmpty())
                {   Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("erreur de remplissage");
                    alert.setContentText("Veuillez remplir ce champ");
                    alert.showAndWait();
                    return false;
        
                    }
    return true;
} 
private boolean recherch_mat()
            
{ String mStr = matieres_txt.getText().replace( "'" , "''" );
   try{
            String q1 = "SELECT examen FROM mati where classe LIKE '%2MECOM%'  AND examen  LIKE '"+mStr+"%' ";

                   pst = connection.prepareStatement(q1);
                   
                    rs = pst.executeQuery();
                   
                   int count = 0;
                   while(rs.next())
                   {
                        count = count+1;
                   }
                   if(count == 0)
                   {
                     Alert alert = new Alert(Alert.AlertType.ERROR);
                       alert.setHeaderText(null);
                       alert.setContentText(matieres_txt.getText()+ " n'existe pas dans la liste des matiéres ");
                       alert.show();
                       return false;
                       
                   }
                                    
            }catch(SQLException e1)
                {
                    e1.printStackTrace();
 
                }
               return true;
    }
   
private boolean verif()
 {        connection = handler.getConnection();

        try {
            pst = connection.prepareStatement("SELECT nomseance FROM seanc_examen where nomseance='"+horaire_txt.getText()+"'");
             rs = pst.executeQuery();
            int count = 0;
                   while(rs.next())
                   {
                        count = count+1;
                    }
                    if(count ==0)
                   {
                     Alert alert = new Alert(Alert.AlertType.ERROR);
                       alert.setHeaderText(null);
                       alert.setContentText("la seance n'existe pas dansla table de séance");
                       alert.show();
                       return false;
                       
                   }
                                    
            }catch(SQLException e1)
                {
                    e1.printStackTrace();
 
                }
            return true;
    
 }
 
 


private String    autoincrtID()
 { String day="";
    String mStr = matieres_txt.getText().replace( "'" , "''" );
   try {
            pst = connection.prepareStatement("SELECT distinct(day) FROM disponibilites where subject like '"+mStr+"%'  AND activitestages LIKE 'C%' AND classe like '2%'");
             rs = pst.executeQuery();
            while(rs.next())
            {
                day=day+" "+rs.getString(1);
             System.out.println(day);
            }
        
        
        } catch (SQLException ex) {
            Logger.getLogger(ParamController.class.getName()).log(Level.SEVERE, null, ex);
        }
 
 return day;
 
 }



private boolean recherch_disp()
{String mStr = matieres_txt.getText().replace( "'" , "''" );
String s =autoincrtID();  

try{
            String q1 = "SELECT day FROM disponibilites where day = '"+jour_txt.getText()+"'  AND subject like '%"+mStr+"%'  AND activitestages LIKE 'C%' ";
                   pst = connection.prepareStatement(q1);
                   
                   rs = pst.executeQuery();
                   int count = 0;
                   while(rs.next())
                   {
                        count = count+1;
                    }
                    if(count ==0)
                   {
                     Alert alert = new Alert(Alert.AlertType.ERROR);
                       alert.setHeaderText(null);
                       alert.setContentText("Aucune enseignant disponibilie au " +jour_txt.getText() +" pour "+matieres_txt.getText()+" les jours disponibles sont "+s);
                       alert.show();
                       return false;
                       
                   }
                                    
            }catch(SQLException e1)
                {
                    e1.printStackTrace();
 
                }
            return true;
    }
private boolean Repmat()
{   
    String mStr = matieres_txt.getText().replace( "'" , "''" );


try{
            String q1 = "SELECT matieres FROM mecom2 where matieres like '%"+mStr+"%'";
                   pst = connection.prepareStatement(q1);
                   
                   rs = pst.executeQuery();
                   int count = 0;
                   while(rs.next())
                   {
                        count = count+1;
                    }
                    if(count ==1)
                   {
                     Alert alert = new Alert(Alert.AlertType.ERROR);
                       alert.setHeaderText(null);
                       alert.setContentText("Matiéres déja planifiée");
                       alert.show();
                       return false;
                       
                   }
                                    
            }catch(SQLException e1)
                {
                    e1.printStackTrace();
 
                }

return true;
}
private boolean Repdur()
{   
try{
            String q1 = "SELECT horaire, date FROM mecom2 where date='"+date_txt.getText()+"' and horaire ='"+horaire_txt.getText()+"'";
                   pst = connection.prepareStatement(q1);
                   
                   rs = pst.executeQuery();
                   int count = 0;
                   while(rs.next())
                   {
                        count = count+1;
                    }
                    if(count ==1)
                   {
                     Alert alert = new Alert(Alert.AlertType.ERROR);
                       alert.setHeaderText(null);
                       alert.setContentText("Date déja reservée");
                       alert.show();
                       return false;
                       
                   }
                                    
            }catch(SQLException e1)
                {
                    e1.printStackTrace();
 
                }

return true;
}

private boolean salle_mbds()
 {
        try {
            pst = connection.prepareStatement("SELECT salle_mbds FROM mbds1 where salle_mbds='"+salle_txt.getText()+"' and date_mbds='"+date_txt.getText()+"' and horaire_mbds ='"+horaire_txt.getText()+"'");
             rs = pst.executeQuery();
            int count = 0;
                   while(rs.next())
                   {
                        count = count+1;
                    }
                    if(count !=0)
                   {
                     Alert alert = new Alert(Alert.AlertType.ERROR);
                       alert.setHeaderText(null);
                       alert.setContentText("Attention salle déja reservée "+ salle_txt.getText());
                       alert.show();
                       return false;
                       
                   }
                                    
            }catch(SQLException e1)
                {
                    e1.printStackTrace();
 
                }
            return true;
    
 }
private boolean salle_vic()
 {
        try {
            pst = connection.prepareStatement("SELECT salle_vic FROM vic1 where salle_vic='"+salle_txt.getText()+"' and date_vic='"+date_txt.getText()+"' and horaire_vic='"+horaire_txt.getText()+"'");
            rs = pst.executeQuery();
            int count = 0;
               while(rs.next())
                   {
                        count = count+1;
                    }
                    if(count !=0)
                   {
                     Alert alert = new Alert(Alert.AlertType.ERROR);
                       alert.setHeaderText(null);
                       alert.setContentText("Attention salle déja reservée"+ salle_txt.getText());
                       alert.show();
                       return false;
                       
                   }
                                    
            }catch(SQLException e1)
                {
                    e1.printStackTrace();
 
                }
return true;
    
 }
private boolean salle_wi()
 {
        try {
            pst = connection.prepareStatement("SELECT salle_wi FROM wi1 where salle_wi='"+salle_txt.getText()+"' and date_wi='"+date_txt.getText()+"' and horaire_wi='"+horaire_txt.getText()+"'");
            rs = pst.executeQuery();
            int count = 0;
               while(rs.next())
                   {
                        count = count+1;
                    }
                    if(count !=0)
                   {
                     Alert alert = new Alert(Alert.AlertType.ERROR);
                       alert.setHeaderText(null);
                       alert.setContentText("Attention salle déja reservée"+ salle_txt.getText());
                       alert.show();
                       return false;
                       
                   }
                                    
            }catch(SQLException e1)
                {
                    e1.printStackTrace();
 
                }
return true;
    
 }
private boolean salle_mbds2()
 {
        try {
            pst = connection.prepareStatement("SELECT salle_mbds FROM mbds2 where salle_mbds='"+salle_txt.getText()+"' and date_mbds='"+date_txt.getText()+"' and horaire_mbds='"+horaire_txt.getText()+"' ");
            rs = pst.executeQuery();
            int count = 0;
               while(rs.next())
                   {
                        count = count+1;
                    }
                    if(count !=0)
                   {
                     Alert alert = new Alert(Alert.AlertType.ERROR);
                       alert.setHeaderText(null);
                       alert.setContentText("Attention salle déja reservée"+ salle_txt.getText());
                       alert.show();
                       return false;
                       
                   }
                                    
            }catch(SQLException e1)
                {
                    e1.printStackTrace();
 
                }
return true;
    
 }


private boolean salle_mecom()
 {
        try {
            pst = connection.prepareStatement("SELECT salle FROM mecom1 where salle='"+salle_txt.getText()+"' and date='"+date_txt.getText()+"' and horaire ='"+horaire_txt.getText()+"'");
             rs = pst.executeQuery();
            int count = 0;
                   while(rs.next())
                   {
                        count = count+1;
                    }
                    if(count !=0)
                   {
                     Alert alert = new Alert(Alert.AlertType.ERROR);
                       alert.setHeaderText(null);
                       alert.setContentText("Attention salle déja reservée "+ salle_txt.getText());
                       alert.show();
                       return false;
                       
                   }
                                    
            }catch(SQLException e1)
                {
                    e1.printStackTrace();
 
                }
            return true;
    
 }
private boolean salle_vic2()
 {
        try {
            pst = connection.prepareStatement("SELECT salle_vic FROM vic2 where salle_vic='"+salle_txt.getText()+"' and date_vic='"+date_txt.getText()+"' and horaire_vic='"+horaire_txt.getText()+"'");
            rs = pst.executeQuery();
            int count = 0;
               while(rs.next())
                   {
                        count = count+1;
                    }
                    if(count !=0)
                   {
                     Alert alert = new Alert(Alert.AlertType.ERROR);
                       alert.setHeaderText(null);
                       alert.setContentText("Attention salle déja reservée"+ salle_txt.getText());
                       alert.show();
                       return false;
                       
                   }
                                    
            }catch(SQLException e1)
                {
                    e1.printStackTrace();
 
                }
return true;
    
 }
private boolean salle_wi2()
 {
        try {
            pst = connection.prepareStatement("SELECT salle_wi FROM wi2 where salle_wi='"+salle_txt.getText()+"' and date_wi='"+date_txt.getText()+"' and horaire_wi='"+horaire_txt.getText()+"'");
            rs = pst.executeQuery();
            int count = 0;
               while(rs.next())
                   {
                        count = count+1;
                    }
                    if(count ==1)
                   {
                     Alert alert = new Alert(Alert.AlertType.ERROR);
                       alert.setHeaderText(null);
                       alert.setContentText("Attention salle déja reservée"+ salle_txt.getText());
                       alert.show();
                       return false;
                       
                   }
                                    
            }catch(SQLException e1)
                {
                    e1.printStackTrace();
 
                }
return true;
    
 }
        
}
