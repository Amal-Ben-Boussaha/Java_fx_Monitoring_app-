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
public class CalFrm1TsiController implements Initializable {
    @FXML
    private TextField date_txt;
    @FXML
    private TextField jour;
    @FXML
    private TextField mats_txt;
    @FXML
    private TextField horaire_txt;
    @FXML
    private TextField durs_txt;
    @FXML
    private TextField grp_txt;
    @FXML
    private TextField gop2_txt;
    @FXML
    private TextField s1_txt;
    @FXML
    private TextField s2_txt;
    private  dbconnect handler ;
    private Connection connection;
    private PreparedStatement pst;
    private ResultSet rs;
    boolean editmode = false;
    double x= 0,y =0;
    EntityManager em;
    Tsi tsi;
    private void dragged(MouseEvent event)
    {
        Node node = (Node) event.getSource();
        Stage stage =(Stage)node.getScene().getWindow();
        stage.setX(event.getScreenX() -x);
        stage.setY(event.getScreenY() -y);
    }

    @FXML
    private void pressed(MouseEvent event) {
        x=event.getSceneX();
        y=event.getSceneY();
    
    }
    public void setLfig(int idTSI) {
        Query q = em.createQuery("SELECT t FROM Tsi t WHERE t.idTSI = :idTSI");
        q.setParameter("idTSI", new Integer(idTSI));
        tsi = (Tsi) q.getSingleResult();
        date_txt.setText(tsi.getDate());
        jour.setText(tsi.getJour());
        mats_txt.setText(tsi.getMatiereTsi());
        horaire_txt.setText(tsi.getHoraireTsi());
        durs_txt.setText(tsi.getDureeTsi());
        grp_txt.setText(tsi.getG1Tsi());
        gop2_txt.setText(tsi.getG2Tsi());
        s1_txt.setText(tsi.getSalleG1());
        s2_txt.setText(tsi.getSalleG2());
        editmode = true;
    }
    @FXML
    void annuler(ActionEvent event) {
         Node node = (Node) event.getSource();
         Stage stage =(Stage)node.getScene().getWindow();
         stage.close();
         }
    @FXML
    void enregistrer(ActionEvent event) {
        connection = handler.getConnection();
            if (!editmode) {
            tsi = new Tsi();
        }
        if(empty()&&recherch_mat()&&verif()&&possible_salle()&&possible_salleg1()&&possible_salleg21()&&possible_salleg22()&&possible_salleg31()&&possible_salleg32()&&possible_salleg41()&&possible_salleg42()&& possible_salleecom11()&&possible_sallegecom12()&&possible_sallegecom21()&& possible_sallegecom22())
           
        {   
            tsi.setJour(jour.getText());
            tsi.setDate(date_txt.getText());
            tsi.setMatiereTsi(mats_txt.getText());
            tsi.setHoraireTsi(horaire_txt.getText());
            tsi.setDureeTsi(durs_txt.getText());
            tsi.setG1Tsi(grp_txt.getText());
            tsi.setG2Tsi(gop2_txt.getText());
            tsi.setSalleG1(s1_txt.getText());
            tsi.setSalleG2(s2_txt.getText());
            em.getTransaction().begin();
            em.persist(tsi);
            em.getTransaction().commit();
            em.close();
            annuler(event);
        }
    }
     @FXML
    void verifier(ActionEvent event) {

    connection = handler.getConnection();
         if(empty()&&recherch_mat()&&recherch_disp()&&verif()&&Repmat()&&Repdur()&&possible_salle()&&possible_salleg1()&&possible_salleg21()&&possible_salleg22()&&possible_salleg31()&&possible_salleg32()&&possible_salleg41()&&possible_salleg42()&& possible_salleecom11()&&possible_sallegecom12()&&possible_sallegecom21()&& possible_sallegecom22())
     {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("interface d'information");
         alert.setContentText("Normalement bien planifier d'examen");
         alert.showAndWait();  
     }
    }
    private boolean empty()
{
    if(jour.getText().isEmpty()|horaire_txt.getText().isEmpty()| mats_txt.getText().isEmpty() | durs_txt.getText().isEmpty() |s1_txt.getText().isEmpty()|date_txt.getText().isEmpty()|s2_txt.getText().isEmpty()|grp_txt.getText().isEmpty()|gop2_txt.getText().isEmpty())
                {   Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("erreur de remplissage");
                    alert.setContentText("Veuillez remplir ce champ");
                    alert.showAndWait();
                    return false;
        
                    }
    return true;
}
   private boolean Repmat()
{   
    String mStr = mats_txt.getText().replace( "'" , "''" );


try{
            String q1 = "SELECT matiere_tsi FROM tsi where matiere_tsi like '%"+mStr+"%'";
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
            String q1 = "SELECT horaire_tsi, date FROM tsi where date='"+date_txt.getText()+"' and horaire_tsi ='"+horaire_txt.getText()+"'";
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
private boolean recherch_mat()
            
{ String mStr = mats_txt.getText().replace( "'" , "''" ); 
   try{
            String q1 = "SELECT examen FROM mati where classe like '%1TSI%'  and examen  like '%"+mStr+"%' ";

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
                       alert.setContentText(mats_txt.getText()+ " n'existe pas dans le liste de matiéres verifier cette liste ou change le matiéres");
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
    String mStr = mats_txt.getText().replace( "'" , "''" );
   try {
            pst = connection.prepareStatement("SELECT distinct(day) FROM disponibilites where subject like '"+mStr+"%'  AND activitestages LIKE 'C%'");
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
{
String s =autoincrtID();  

    String mStr = mats_txt.getText().replace( "'" , "''" );
    
try{
            String q1 = "SELECT day FROM disponibilites where day = '"+jour.getText()+"'  AND subject like '%"+mStr+"%'  AND activitestages LIKE 'C%' ";
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
                       alert.setContentText("Aucune enseignant disponibilie au " +jour.getText() +" pour "+mats_txt.getText()+" les jours disponibles sont "+s);
                       alert.show();
                       return false;
                       
                   }
                                    
            }catch(SQLException e1)
                {
                    e1.printStackTrace();
 
                }
            return true;
    }



private boolean possible_salle()
 {
        try {
            pst = connection.prepareStatement("SELECT salleg1 FROM lfig where salleg1='"+s1_txt.getText()+"' and date='"+date_txt.getText()+"' and horaire ='"+horaire_txt.getText()+"' ");
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
                       alert.setContentText("Attention vous reservez la salle "+ s1_txt.getText());
                       alert.show();
                       return false;
                       
                   }
                                    
            }catch(SQLException e1)
                {
                    e1.printStackTrace();
 
                }
            return true;
    
 }
private boolean possible_salleg1()
 {
        try {
            pst = connection.prepareStatement("SELECT salleg1 FROM LFIG where salleg1='"+s2_txt.getText()+"' and date='"+date_txt.getText()+"' and horaire ='"+horaire_txt.getText()+"'");
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
                       alert.setContentText("Attention vous reservez la salle "+ s2_txt.getText());
                       alert.show();
                       return false;
                       
                   }
                                    
            }catch(SQLException e1)
                {
                    e1.printStackTrace();
 
                }
return true;
    
 }
private boolean possible_salleg21()
 {
        try {
            pst = connection.prepareStatement("SELECT salleg2 FROM LFIG where salleg2='"+s1_txt.getText()+"' and date='"+date_txt.getText()+"' and horaire ='"+horaire_txt.getText()+"'");
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
                       alert.setContentText("Attention vous reservez la salle "+ s1_txt.getText());
                       alert.show();
                       return false;
                       
                   }
                                    
            }catch(SQLException e1)
                {
                    e1.printStackTrace();
 
                }
return true;
    
 }
private boolean possible_salleg22()
 {
        try {
            pst = connection.prepareStatement("SELECT salleg2 FROM LFIG where salleg2='"+s1_txt.getText()+"' and date='"+date_txt.getText()+"' and horaire ='"+horaire_txt.getText()+"'");
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
                       alert.setContentText("Attention vous reservez la salle"+ s1_txt.getText());
                       alert.show();
                       return false;
                       
                   }
                                    
            }catch(SQLException e1)
                {
                    e1.printStackTrace();
 
                }
return true;
    
 }

private boolean possible_salleg31()
 {
        try {
            pst = connection.prepareStatement("SELECT salleg3 FROM LFIG where salleg3='"+s1_txt.getText()+"' and date='"+date_txt.getText()+"' and horaire ='"+horaire_txt.getText()+"'");
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
                       alert.setContentText("Attention vous reservez la salle"+ s1_txt.getText());
                       alert.show();
                       return false;
                       
                   }
                                    
            }catch(SQLException e1)
                {
                    e1.printStackTrace();
 
                }
return true;
    
 }
private boolean possible_salleg32()
 {
        try {
            pst = connection.prepareStatement("SELECT salleg3 FROM LFIG where salleg3='"+s2_txt.getText()+"' and date='"+date_txt.getText()+"' and horaire ='"+horaire_txt.getText()+"'");
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
                       alert.setContentText("Attention vous reservez la salle"+ s2_txt.getText());
                       alert.show();
                       return false;
                       
                   }
                                    
            }catch(SQLException e1)
                {
                    e1.printStackTrace();
 
                }
return true;
    
 }
private boolean possible_salleg41()
 {
        try {
            pst = connection.prepareStatement("SELECT salleg4 FROM LFIG where salleg4='"+s1_txt.getText()+"' and date='"+date_txt.getText()+"' and horaire ='"+horaire_txt.getText()+"'");
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
                       alert.setContentText("Attention vous reservez la salle"+ s1_txt.getText());
                       alert.show();
                       return false;
                       
                   }
                                    
            }catch(SQLException e1)
                {
                    e1.printStackTrace();
 
                }
return true;
    
 }
private boolean possible_salleg42()
 {
        try {
            pst = connection.prepareStatement("SELECT salleg4 FROM LFIG where salleg4='"+s2_txt.getText()+"' and date='"+date_txt.getText()+"' and horaire ='"+horaire_txt.getText()+"'");
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
                       alert.setContentText("Attention vous reservez la salle"+ s2_txt.getText());
                       alert.show();
                       return false;
                       
                   }
                                    
            }catch(SQLException e1)
                {
                    e1.printStackTrace();
 
                }
return true;
    
 }
private boolean possible_salleecom11()
 {
        try {
            pst = connection.prepareStatement("SELECT salle_g1 FROM ecom where salle_g1='"+s1_txt.getText()+"' and date_ecom='"+date_txt.getText()+"' and horaire_ecom ='"+horaire_txt.getText()+"'");
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
                       alert.setContentText("Attention vous reservez la salle"+ s1_txt.getText());
                       alert.show();
                       return false;
                       
                   }
                                    
            }catch(SQLException e1)
                {
                    e1.printStackTrace();
 
                }
            return true;
    
 }
private boolean possible_sallegecom12()
 {
        try {
            pst = connection.prepareStatement("SELECT salle_g1 FROM ecom where salle_g1='"+s2_txt.getText()+"' and date_ecom='"+date_txt.getText()+"' and horaire_ecom ='"+horaire_txt.getText()+"'");
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
                       alert.setContentText("Attention vous reservez la salle"+ s2_txt.getText());
                       alert.show();
                       return false;
                       
                   }
                                    
            }catch(SQLException e1)
                {
                    e1.printStackTrace();
 
                }
            return true;
    
 }
private boolean possible_sallegecom21()
 {
        try {
            pst = connection.prepareStatement("SELECT lle_g2 FROM ecom where lle_g2='"+s1_txt.getText()+"' and date_ecom='"+date_txt.getText()+"' and horaire_ecom ='"+horaire_txt.getText()+"'");
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
                       alert.setContentText("Attention vous reservez la salle"+ s1_txt.getText());
                       alert.show();
                       return false;
                       
                   }
                                    
            }catch(SQLException e1)
                {
                    e1.printStackTrace();
 
                }
            return true;
    
 }
private boolean possible_sallegecom22()
 {
        try {
            pst = connection.prepareStatement("SELECT lle_g2 FROM ecom where lle_g2='"+s2_txt.getText()+"' and date_ecom='"+date_txt.getText()+"' and horaire_ecom ='"+horaire_txt.getText()+"'");
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
                       alert.setContentText("Attention vous reservez la salle"+s2_txt.getText());
                       alert.show();
                       return false;
                       
                   }
                                    
            }catch(SQLException e1)
                {
                    e1.printStackTrace();
 
                }
            return true;
    
 }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        em = TsicalenController.emf.createEntityManager();
    handler = new dbconnect();
    
    } 
}