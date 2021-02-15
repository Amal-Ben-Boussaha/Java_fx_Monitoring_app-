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
public class LfigcalendrierFrmController implements Initializable {

    @FXML
    private TextField daye_txt,jour;

    @FXML
    private TextField mat_txt;

    @FXML
    private TextField hor_txt;

    @FXML
    private TextField dur_txt;

    @FXML
    private TextField g1_txt;

    @FXML
    private TextField g2_txt;

    @FXML
    private TextField g3_txt;

    @FXML
    private TextField g4_txt;

    @FXML
    private TextField salle_txt;

    @FXML
    private TextField salle2_txt;

    @FXML
    private TextField salle3_txt;

    @FXML
    private TextField sall4_txt;
    private  dbconnect handler ;
    private Connection connection;
    private PreparedStatement pst;
    private ResultSet rs;
    boolean editmode = false;
    double x= 0,y =0;
    EntityManager em;
    Lfig lfig;
   @Override
    public void initialize(URL url, ResourceBundle rb) {
     
    em = CalendreirController.emf.createEntityManager();
    handler = new dbconnect();
    }   
    @FXML
    private void dragged(MouseEvent event) {
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
    
    public void setLfig(int idLf) {
        Query q = em.createQuery("SELECT l FROM Lfig l WHERE l.idLf = :idLf");
        q.setParameter("idLf", new Integer(idLf));
        lfig = (Lfig) q.getSingleResult();
        jour.setText(lfig.getJour());
        daye_txt.setText(lfig.getDate());
        mat_txt.setText(lfig.getMatiere());
        hor_txt.setText(lfig.getHoraire());
        dur_txt.setText(lfig.getDuree());
        g1_txt.setText(lfig.getGrp1());
        g2_txt.setText(lfig.getGrp2());
        g3_txt.setText(lfig.getGrp3());
        g4_txt.setText(lfig.getG4());
        salle_txt.setText(lfig.getSalleg1());
        salle2_txt.setText(lfig.getSalleg2());
        salle3_txt.setText(lfig.getSalleg3());
        sall4_txt.setText(lfig.getSalleg4());
        
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
            lfig = new Lfig();
        }
        if(empty()&&recherch_mat()&&verif()&&possible_salleg12()&&possible_salle11()&&possible_salleg21()&&possible_salleg22()&&possible_salleg31()&&possible_salleg32()&&possible_salleg41()&&possible_salleg42())
           
        {if(possible_salleecom11()&&possible_sallegecom12()&&possible_sallegecom13()&&possible_salleg14()&& possible_sallegecom21()&&possible_sallegecom22()&&possible_sallegecom23()&&possible_salleg24())
        {   lfig.setJour(jour.getText());
            lfig.setDate(daye_txt.getText());
            lfig.setMatiere(mat_txt.getText());
            lfig.setHoraire(hor_txt.getText());
            lfig.setDuree(dur_txt.getText());
            lfig.setGrp1(g1_txt.getText());
            lfig.setGrp2(g2_txt.getText());
            lfig.setGrp3(g3_txt.getText());
            lfig.setG4(g4_txt.getText());
            lfig.setSalleg1(salle_txt.getText());
            lfig.setSalleg2(salle2_txt.getText());
            lfig.setSalleg3(salle3_txt.getText());
            lfig.setSalleg4(sall4_txt.getText());
            
            em.getTransaction().begin();
            em.persist(lfig);
            em.getTransaction().commit();
            em.close();
            annuler(event);
        }
        }
            
            }
    

    @FXML
    void verifier(ActionEvent event) {
        connection = handler.getConnection();
         if(empty()&&recherch_mat()&&Repmat()&&Repdur()&&recherch_disp()&&verif()&&possible_salleg14() &&possible_salleg12()&&possible_salle11()&&possible_salleg21()&&possible_salleg22()&&possible_salleg31()&&possible_salleg32()&&possible_salleg41()&&possible_salleg42()&&possible_salleecom11()&&possible_sallegecom12()&&possible_sallegecom13()&&possible_sallegecom21()&&possible_sallegecom22()&&possible_sallegecom23()&&possible_salleg24())
     {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("interface d'information");
         alert.setContentText("Normalement bien planifier d'examen");
         alert.showAndWait();
                    
     
     }
    }
     private boolean verif()
 {        connection = handler.getConnection();

        try {
            pst = connection.prepareStatement("SELECT nomseance FROM seanc_examen where nomseance='"+hor_txt.getText()+"'");
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
 //Fonction pour verifier aucune champs vide
    private boolean empty()
{
    if(jour.getText().isEmpty()|hor_txt.getText().isEmpty()| mat_txt.getText().isEmpty() | dur_txt.getText().isEmpty() |salle_txt.getText().isEmpty()|daye_txt.getText().isEmpty())
                {   Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("erreur de remplissage");
                    alert.setContentText("Veuillez remplir ce champ");
                    alert.showAndWait();
                    return false;
        
                    }
    return true;
}
//Fonction pour verifier qui aucune examen plannifier 2 fois
 private boolean Repmat()
{   
    String mStr = mat_txt.getText().replace( "'" , "''" );


try{
            String q1 = "SELECT matiere FROM lfig where matiere like '%"+mStr+"%'";
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
            String q1 = "SELECT horaire date FROM lfig where date='"+daye_txt.getText()+"' and horaire ='"+hor_txt.getText()+"'";
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
private boolean recherch_mat()
            
{ String mStr = mat_txt.getText().replace( "'" , "''" );
    
    
    try{
            String q1 = "SELECT examen FROM mati where classe like '%1LFIG%'  and examen  like '"+mStr+"%' ";

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
                       alert.setContentText(mat_txt.getText()+ "n'existe pas dans le liste de matiéres verifier cette liste ou change le matiéres");
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
    String mStr = mat_txt.getText().replace( "'" , "''" );
    
  
 try {
            pst = connection.prepareStatement("SELECT distinct(day) FROM disponibilites where subject like '"+mStr+"%'  AND activitestages LIKE 'C%' ");
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

    String mStr = mat_txt.getText().replace( "'" , "''" );
    
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
                       alert.setContentText("Aucune enseignant disponibilie au " +jour.getText() +" pour "+mat_txt.getText()+" les jours disponibles sont "+s);
                       alert.show();
                       return false;
                       
                   }
                                    
            }catch(SQLException e1)
                {
                    e1.printStackTrace();
 
                }
            return true;
    }



private boolean possible_salle11()
 {
        try {
            pst = connection.prepareStatement("SELECT salle_g1 FROM tsi where salle_g1='"+salle_txt.getText()+"' and date='"+daye_txt.getText()+"' and horaire_tsi ='"+hor_txt.getText()+"'");
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
                       alert.setContentText("Attention vous reservez la salle"+ salle_txt.getText());
                       alert.show();
                       return false;
                       
                   }
                                    
            }catch(SQLException e1)
                {
                    e1.printStackTrace();
 
                }
            return true;
    
 }
private boolean possible_salleg12()
 {
        try {
            pst = connection.prepareStatement("SELECT salle_g1 FROM tsi where salle_g1='"+salle2_txt.getText()+"' and date='"+daye_txt.getText()+"' and horaire_tsi ='"+hor_txt.getText()+"' ");
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
                       alert.setContentText("Attention vous reservez la salle"+ salle2_txt.getText());
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
            pst = connection.prepareStatement("SELECT salle_g2 FROM tsi where salle_g2='"+salle2_txt.getText()+"' and date='"+daye_txt.getText()+"' and horaire_tsi ='"+hor_txt.getText()+"' ");
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
                       alert.setContentText("Attention vous reservez la salle"+ salle2_txt.getText());
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
            pst = connection.prepareStatement("SELECT salle_g2 FROM tsi where salle_g2='"+salle_txt.getText()+"' and date='"+daye_txt.getText()+"' and horaire_tsi ='"+hor_txt.getText()+"' ");
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
                       alert.setContentText("Attention vous reservez la salle"+ salle_txt.getText()+ " pour 1TSI_G2 au ces temps");
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
            pst = connection.prepareStatement("SELECT salle_g1 FROM tsi where salle_g1='"+salle3_txt.getText()+"' and date='"+daye_txt.getText()+"' and horaire_tsi ='"+hor_txt.getText()+"' ");
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
                       alert.setContentText("Attention vous reservez la salle"+ salle3_txt.getText());
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
            pst = connection.prepareStatement("SELECT salle_g2 FROM tsi where salle_g2='"+salle3_txt.getText()+"' and date='"+daye_txt.getText()+"' and horaire_tsi ='"+hor_txt.getText()+"' ");
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
                       alert.setContentText("Attention vous reservez la salle"+salle3_txt.getText());
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
            pst = connection.prepareStatement("SELECT salle_g1 FROM tsi where salle_g1='"+sall4_txt.getText()+"' and date='"+daye_txt.getText()+"' and horaire_tsi ='"+hor_txt.getText()+"' ");
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
                       alert.setContentText("Attention vous reservez la salle"+ sall4_txt.getText());
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
            pst = connection.prepareStatement("SELECT salle_g2 FROM tsi where salle_g2='"+sall4_txt.getText()+"' and date='"+daye_txt.getText()+"' and horaire_tsi ='"+hor_txt.getText()+"' ");
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
                       alert.setContentText("Attention vous reservez la salle"+ sall4_txt.getText());
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
            pst = connection.prepareStatement("SELECT salle_g1 FROM ecom where salle_g1='"+salle_txt.getText()+"' and date_ecom='"+daye_txt.getText()+"' and horaire_ecom ='"+hor_txt.getText()+"'");
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
                       alert.setContentText("Attention vous reservez la salle"+ salle_txt.getText());
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
            pst = connection.prepareStatement("SELECT salle_g1 FROM ecom where salle_g1='"+salle2_txt.getText()+"' and date_ecom='"+daye_txt.getText()+"' and horaire_ecom ='"+hor_txt.getText()+"' ");
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
                       alert.setContentText("Attention vous reservez la salle"+ salle2_txt.getText());
                       alert.show();
                       return false;
                       
                   }
                                    
            }catch(SQLException e1)
                {
                    e1.printStackTrace();
 
                }
            return true;
    
 }
private boolean possible_sallegecom13()
 {
        try {
            pst = connection.prepareStatement("SELECT salle_g1 FROM ecom where salle_g1='"+salle3_txt.getText()+"' and date_ecom='"+daye_txt.getText()+"' and horaire_ecom ='"+hor_txt.getText()+"'");
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
                       alert.setContentText("Attention vous reservez la salle"+ salle3_txt.getText());
                       alert.show();
                       return false;
                       
                   }
                                    
            }catch(SQLException e1)
                {
                    e1.printStackTrace();
 
                }
            return true;
    
 }
private boolean possible_salleg14()
 {
        try {
            pst = connection.prepareStatement("SELECT salle_g1 FROM ecom where salle_g1='"+sall4_txt.getText()+"'  and date_ecom='"+daye_txt.getText()+"' and horaire_ecom ='"+hor_txt.getText()+"'");
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
                       alert.setContentText("Attention vous reservez la salle"+ sall4_txt.getText());
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
            pst = connection.prepareStatement("SELECT lle_g2 FROM ecom where lle_g2='"+salle_txt.getText()+"' and date_ecom='"+daye_txt.getText()+"' and horaire_ecom ='"+hor_txt.getText()+"'");
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
                       alert.setContentText("Attention vous reservez la salle"+ salle_txt.getText());
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
            pst = connection.prepareStatement("SELECT lle_g2 FROM ecom where lle_g2='"+salle2_txt.getText()+"' and date_ecom='"+daye_txt.getText()+"' and horaire_ecom ='"+hor_txt.getText()+"'");
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
                       alert.setContentText("Attention vous reservez la salle"+salle2_txt.getText());
                       alert.show();
                       return false;
                       
                   }
                                    
            }catch(SQLException e1)
                {
                    e1.printStackTrace();
 
                }
            return true;
    
 }
private boolean possible_sallegecom23()
 {
        try {
            pst = connection.prepareStatement("SELECT lle_g2 FROM ecom where lle_g2='"+salle3_txt.getText()+"'  and date_ecom='"+daye_txt.getText()+"' and horaire_ecom ='"+hor_txt.getText()+"'");
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
                       alert.setContentText("Attention vous reservez la salle"+ salle3_txt.getText());
                       alert.show();
                       return false;
                       
                   }
                                    
            }catch(SQLException e1)
                {
                    e1.printStackTrace();
 
                }
            return true;
    
 }
private boolean possible_salleg24()
 {
        try {
            pst = connection.prepareStatement("SELECT lle_g2 FROM ecom where lle_g2='"+sall4_txt.getText()+"' and date_ecom='"+daye_txt.getText()+"' and horaire_ecom ='"+hor_txt.getText()+"'");
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
                       alert.setContentText("Attention vous reservez la salle"+ sall4_txt.getText());
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
