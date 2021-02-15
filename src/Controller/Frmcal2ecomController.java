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

public class Frmcal2ecomController implements Initializable {
    
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
    private TextField g1_txt;
    @FXML
    private TextField salleg1_txt;
    @FXML
    private TextField g2_txt;
    @FXML
    private TextField salleg2_txt;
    private Connection connection;
    private dbconnect handler;
    private PreparedStatement pst;  
   private ResultSet rs;
    EntityManager em;  
    Ecom2 ecom2;
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
       em = Cal2ecomController.emf.createEntityManager();
    }    
    
    public void setEcom(int idecom2)
     {
        Query q = em.createQuery("SELECT e FROM Ecom2 e WHERE e.idecom2 = :idecom2");
        q.setParameter("idecom2", new Integer(idecom2));
        ecom2 = (Ecom2) q.getSingleResult();
        jour_txt.setText(ecom2.getJourEcom());
        date_txt.setText(ecom2.getDateEcom());
        matieres_txt.setText(ecom2.getMatieresEcom());
        horaire_txt.setText(ecom2.getHoraireEcom());
        duree_txt.setText(ecom2.getDureeEcom());
        g1_txt.setText(ecom2.getGroupe1Ecom());
        salleg1_txt.setText(ecom2.getSalleG1Ecom());
        g2_txt.setText(ecom2.getGroupe2Ecom());
        salleg2_txt.setText(ecom2.getSalleG2Ecom());
        editmode = true;
     
     }
    @FXML
    private void enregistrer(ActionEvent event) {
        connection = handler.getConnection();
            if (!editmode) {
            ecom2 = new Ecom2();
        }
        if(empty()&&recherch_mat()&&verif()&&possible_salletsig11()&&possible_salletsig12()&&possible_salletsig21()&&possible_salletsig22()&&possible_salleecomg11()&&possible_salleecomg12()&&possible_salleecomg21()&&possible_salleecomg22())
           
        {
            ecom2.setJourEcom(jour_txt.getText());
            ecom2.setDateEcom(date_txt.getText());
            ecom2.setMatieresEcom(matieres_txt.getText());
            ecom2.setHoraireEcom(horaire_txt.getText());
            ecom2.setDureeEcom(duree_txt.getText());
            ecom2.setGroupe1Ecom(g1_txt.getText());
            ecom2.setSalleG1Ecom(salleg1_txt.getText());
            ecom2.setGroupe2Ecom(g2_txt.getText());
            ecom2.setSalleG2Ecom(salleg2_txt.getText());
            em.getTransaction().begin();
            em.persist(ecom2);
            em.getTransaction().commit();
            em.close();
            annuler(event);
        }
        
    }

    @FXML
    private void verifier(ActionEvent event) {
        
        connection = handler.getConnection();
         if(empty()&&recherch_mat()&&recherch_disp()&&verif()&&Repmat()&&Repdur()&&possible_salletsig11()&&possible_salletsig12()&&possible_salletsig21()&&possible_salletsig22()&&possible_salleecomg11()&&possible_salleecomg12()&&possible_salleecomg21()&&possible_salleecomg22())
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
    if(jour_txt.getText().isEmpty()| date_txt.getText().isEmpty() | horaire_txt.getText().isEmpty() |matieres_txt.getText().isEmpty()|duree_txt.getText().isEmpty()|g1_txt.getText().isEmpty()|salleg1_txt.getText().isEmpty()|g2_txt.getText().isEmpty()|salleg2_txt.getText().isEmpty())
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
            String q1 = "SELECT examen FROM mati where classe LIKE '%2ECOM%'  AND examen  LIKE '"+mStr+"%' ";

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
            pst = connection.prepareStatement("SELECT distinct(day) FROM disponibilites where subject like '"+mStr+"%'  AND activitestages LIKE'C%' AND classe like '2%'");
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
            String q1 = "SELECT matieres_ecom FROM ecom2 where matieres_ecom like '%"+mStr+"%'";
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
            String q1 = "SELECT horaire_ecom, date_ecom FROM ecom2 where date_ecom='"+date_txt.getText()+"' and horaire_ecom ='"+horaire_txt.getText()+"'";
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

private boolean possible_salletsig11()
 {
        try {
            pst = connection.prepareStatement("SELECT salle_g1_tsi FROM tsi2 where salle_g1_tsi='"+salleg1_txt.getText()+"' and date_tsi='"+date_txt.getText()+"' and horaire_tsi ='"+horaire_txt.getText()+"' and duree_tsi='"+duree_txt.getText()+"' ");
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
                       alert.setContentText("Attention salle déja reservée "+ salleg1_txt.getText());
                       alert.show();
                       return false;
                       
                   }
                                    
            }catch(SQLException e1)
                {
                    e1.printStackTrace();
 
                }
            return true;
    
 }
private boolean possible_salletsig12()
 {
        try {
            pst = connection.prepareStatement("SELECT salle_g1_tsi FROM tsi2 where salle_g1_tsi='"+salleg2_txt.getText()+"' and date_tsi='"+date_txt.getText()+"' and horaire_tsi='"+horaire_txt.getText()+"' and duree_tsi='"+duree_txt.getText()+"'");
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
                       alert.setContentText("Attention salle déja reservée"+ salleg2_txt.getText());
                       alert.show();
                       return false;
                       
                   }
                                    
            }catch(SQLException e1)
                {
                    e1.printStackTrace();
 
                }
return true;
    
 }
private boolean possible_salletsig21()
 {
        try {
            pst = connection.prepareStatement("SELECT salle_g2_tsi FROM tsi2 where salle_g2_tsi='"+salleg1_txt.getText()+"' and date_tsi='"+date_txt.getText()+"' and horaire_tsi='"+horaire_txt.getText()+"' and duree_tsi='"+duree_txt.getText()+"'");
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
                       alert.setContentText("Attention salle déja reservée"+ salleg1_txt.getText());
                       alert.show();
                       return false;
                       
                   }
                                    
            }catch(SQLException e1)
                {
                    e1.printStackTrace();
 
                }
return true;
    
 }
private boolean possible_salletsig22()
 {
        try {
            pst = connection.prepareStatement("SELECT salle_g2_tsi FROM tsi2 where salle_g2_tsi='"+salleg1_txt.getText()+"' and date_tsi='"+date_txt.getText()+"' and horaire_tsi='"+horaire_txt.getText()+"' and duree_tsi='"+duree_txt.getText()+"'");
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
                       alert.setContentText("Attention salle déja reservée"+ salleg1_txt.getText());
                       alert.show();
                       return false;
                       
                   }
                                    
            }catch(SQLException e1)
                {
                    e1.printStackTrace();
 
                }
return true;
    
 }



private boolean possible_salleecomg11()
 {
        try {
            pst = connection.prepareStatement("SELECT salle_g1 FROM lfig2 where salle_g1='"+salleg1_txt.getText()+"' and date='"+date_txt.getText()+"' and horaire='"+horaire_txt.getText()+"' and duree='"+duree_txt.getText()+"' ");
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
                       alert.setContentText("Attention salle déja reservée "+ salleg1_txt.getText());
                       alert.show();
                       return false;
                       
                   }
                                    
            }catch(SQLException e1)
                {
                    e1.printStackTrace();
 
                }
            return true;
    
 }
private boolean possible_salleecomg12()
 {
        try {
            pst = connection.prepareStatement("SELECT salle_g1 FROM lfig2 where salle_g1='"+salleg2_txt.getText()+"' and date='"+date_txt.getText()+"' and horaire='"+horaire_txt.getText()+"' and duree='"+duree_txt.getText()+"'");
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
                       alert.setContentText("Attention salle déja reservée"+ salleg2_txt.getText());
                       alert.show();
                       return false;
                       
                   }
                                    
            }catch(SQLException e1)
                {
                    e1.printStackTrace();
 
                }
return true;
    
 }
private boolean possible_salleecomg21()
 {
        try {
            pst = connection.prepareStatement("SELECT salle_g2 FROM lfig2 where salle_g2='"+salleg1_txt.getText()+"' and date='"+date_txt.getText()+"' and horaire='"+horaire_txt.getText()+"' and duree='"+duree_txt.getText()+"'");
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
                       alert.setContentText("Attention salle déja reservée"+ salleg1_txt.getText());
                       alert.show();
                       return false;
                       
                   }
                                    
            }catch(SQLException e1)
                {
                    e1.printStackTrace();
 
                }
return true;
    
 }
private boolean possible_salleecomg22()
 {
        try {
            pst = connection.prepareStatement("SELECT salle_g2 FROM lfig2 where salle_g2='"+salleg1_txt.getText()+"' and date='"+date_txt.getText()+"' and horaire='"+horaire_txt.getText()+"' and duree='"+duree_txt.getText()+"'");
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
                       alert.setContentText("Attention salle déja reservée"+ salleg1_txt.getText());
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
