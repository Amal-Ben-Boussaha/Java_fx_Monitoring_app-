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

public class FrmEcomController implements Initializable {
    @FXML
    private TextField d_txt;
    @FXML
    private TextField jour;

    @FXML
    private TextField m_txt;

    @FXML
    private TextField h_txt;

    @FXML
    private TextField du_txt;

    @FXML
    private TextField ngp_txt;

    @FXML
    private TextField ngp2_txt;

    @FXML
    private TextField sg1_txt;

    @FXML
    private TextField sg2_txt;
    private  dbconnect handler ;
    private Connection connection;
    private PreparedStatement pst;
    private ResultSet rs;
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
    EntityManager em;
    Ecom ecom;
     public void setEcom(int idecom)
     {
        Query q = em.createQuery("SELECT e FROM Ecom e WHERE e.idecom = :idecom");
        q.setParameter("idecom", new Integer(idecom));
        ecom = (Ecom) q.getSingleResult();
        d_txt.setText(ecom.getDateEcom());
        jour.setText(ecom.getJourEcom());
        m_txt.setText(ecom.getMatiereEcom());
        h_txt.setText(ecom.getHoraireEcom());
        du_txt.setText(ecom.getDureeEcom());
        ngp_txt.setText(ecom.getG1Ecom());
        ngp2_txt.setText(ecom.getG2Ecom());
        sg1_txt.setText(ecom.getSalleG1());
        sg2_txt.setText(ecom.getLleG2());
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
            ecom = new Ecom();
        }
        if(empty()&&recherch_mat()&&verif()&&possible_salle()&&possible_salleg1()&&possible_salleg21()&&possible_salleg22()&&possible_salleg31()&&possible_salleg32()&&possible_salleg41()&&possible_salleg42()&&pos_tsig11()&&pos_tsig12()&&pos_tsig21()&&pos_tsig22())
           
        {
            ecom.setDateEcom(d_txt.getText());
            ecom.setJourEcom(jour.getText());
            ecom.setMatiereEcom(m_txt.getText());
            ecom.setHoraireEcom(h_txt.getText());
            ecom.setDureeEcom(du_txt.getText());
            ecom.setG1Ecom(ngp_txt.getText());
            ecom.setG2Ecom(ngp2_txt.getText());
            ecom.setSalleG1(sg1_txt.getText());
            ecom.setLleG2(sg2_txt.getText());
            em.getTransaction().begin();
            em.persist(ecom);
            em.getTransaction().commit();
            em.close();
            annuler(event);
        }
    }

    @FXML
    void verifier(ActionEvent event) {
        connection = handler.getConnection();
         if(empty()&&recherch_mat()&&recherch_disp()&&Repmat()&&Repdur()&&verif()&&possible_salle()&&possible_salleg1()&&possible_salleg21()&&possible_salleg22()&&possible_salleg31()&&possible_salleg32()&&possible_salleg41()&&possible_salleg42()&&pos_tsig11()&&pos_tsig12()&&pos_tsig21()&&pos_tsig22())
     {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("interface d'information");
         alert.setContentText("Examen bien planifier");
         alert.showAndWait();  
     }
    }
    private boolean empty()
{
    if(jour.getText().isEmpty()|h_txt.getText().isEmpty()| m_txt.getText().isEmpty() | du_txt.getText().isEmpty() |sg1_txt.getText().isEmpty()|d_txt.getText().isEmpty()|sg2_txt.getText().isEmpty()|ngp_txt.getText().isEmpty()|ngp2_txt.getText().isEmpty())
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
    String mStr = m_txt.getText().replace( "'" , "''" );


try{
            String q1 = "SELECT matiere_ecom FROM ecom where matiere_ecom like '%"+mStr+"%'";
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
            String q1 = "SELECT horaire_ecom, date_ecom FROM ecom where date_ecom='"+d_txt.getText()+"' and horaire_ecom ='"+du_txt.getText()+"'";
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
            
{ String mStr = m_txt.getText().replace( "'" , "''" );
   try{
            String q1 = "SELECT examen FROM mati where classe LIKE '%1ECOM%'  AND examen  LIKE '"+mStr+"%' ";

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
                       alert.setContentText(m_txt.getText()+ " n'existe pas dans la liste des matiéres ");
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
    String mStr = m_txt.getText().replace( "'" , "''" );
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
    private boolean verif()
 {        connection = handler.getConnection();

        try {
            pst = connection.prepareStatement("SELECT nomseance FROM seanc_examen where nomseance='"+h_txt.getText()+"'");
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
 

private boolean recherch_disp()
{String mStr = m_txt.getText().replace( "'" , "''" );
String s =autoincrtID();  

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
                       alert.setContentText("Aucune enseignant disponibilie au " +jour.getText() +" pour "+m_txt.getText()+" les jours disponibles sont "+s);
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
            pst = connection.prepareStatement("SELECT salleg1 FROM lfig where salleg1='"+sg1_txt.getText()+"' and date='"+d_txt.getText()+"' and horaire ='"+h_txt.getText()+"' ");
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
                       alert.setContentText("Attention vous reservez la salle"+ sg1_txt.getText());
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
            pst = connection.prepareStatement("SELECT salleg1 FROM lfig where salleg1='"+sg2_txt.getText()+"' and date='"+d_txt.getText()+"' and horaire='"+h_txt.getText()+"'");
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
                       alert.setContentText("Attention vous reservez la salle"+ sg2_txt.getText());
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
            pst = connection.prepareStatement("SELECT salleg2 FROM lfig where salleg2='"+sg1_txt.getText()+"' and date='"+d_txt.getText()+"' and horaire='"+h_txt.getText()+"'");
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
                       alert.setContentText("Attention vous reservez la salle"+ sg1_txt.getText());
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
            pst = connection.prepareStatement("SELECT salleg2 FROM lfig where salleg2='"+sg2_txt.getText()+"' and date='"+d_txt.getText()+"' and horaire='"+h_txt.getText()+"'");
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
                       alert.setContentText("Attention vous reservez la salle"+ sg2_txt.getText());
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
            pst = connection.prepareStatement("SELECT salleg3 FROM lfig where salleg3='"+sg1_txt.getText()+"' and date='"+d_txt.getText()+"' and horaire='"+h_txt.getText()+"'");
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
                       alert.setContentText("Attention vous reservez la salle"+ sg1_txt.getText());
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
            pst = connection.prepareStatement("SELECT salleg3 FROM lfig where salleg3='"+sg2_txt.getText()+"' and date='"+d_txt.getText()+"' and horaire='"+h_txt.getText()+"'");
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
                       alert.setContentText("Attention vous reservez la salle"+ sg2_txt.getText());
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
            pst = connection.prepareStatement("SELECT salleg4 FROM lfig where salleg4='"+sg1_txt.getText()+"' and date='"+d_txt.getText()+"' and horaire='"+h_txt.getText()+"'");
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
                       alert.setContentText("Attention vous reservez la salle"+ sg1_txt.getText());
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
            pst = connection.prepareStatement("SELECT salleg4 FROM lfig where salleg4='"+sg2_txt.getText()+"' and date='"+d_txt.getText()+"' and horaire='"+h_txt.getText()+"'");
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
                       alert.setContentText("Attention vous reservez la salle"+ sg2_txt.getText());
                       alert.show();
                       return false;
                       
                   }
                                    
            }catch(SQLException e1)
                {
                    e1.printStackTrace();
 
                }
return true;
    
 }


private boolean pos_tsig11()
 {
        try {
            pst = connection.prepareStatement("SELECT salle_g1 FROM tsi where salle_g1='"+sg1_txt.getText()+"' and date='"+d_txt.getText()+"' and horaire_tsi ='"+h_txt.getText()+"'");
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
                       alert.setContentText("Attention vous reservez la salle"+ sg1_txt.getText());
                       alert.show();
                       return false;
                       
                   }
                                    
            }catch(SQLException e1)
                {
                    e1.printStackTrace();
 
                }
            return true;
    
 }
private boolean pos_tsig12()
 {
        try {
            pst = connection.prepareStatement("SELECT salle_g1 FROM tsi where salle_g1='"+sg2_txt.getText()+"' and date='"+d_txt.getText()+"' and horaire_tsi ='"+h_txt.getText()+"'");
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
                       alert.setContentText("Attention vous reservez la salle"+ sg2_txt.getText());
                       alert.show();
                       return false;
                       
                   }
                                    
            }catch(SQLException e1)
                {
                    e1.printStackTrace();
 
                }
            return true;
    
 }
private boolean pos_tsig21()
 {
        try {
            pst = connection.prepareStatement("SELECT salle_g2 FROM tsi where salle_g2='"+sg1_txt.getText()+"' and date='"+d_txt.getText()+"' and horaire_tsi ='"+h_txt.getText()+"' and duree_tsi='"+du_txt.getText()+"'");
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
                       alert.setContentText("Attention vous reservez la salle"+ sg1_txt.getText());
                       alert.show();
                       return false;
                       
                   }
                                    
            }catch(SQLException e1)
                {
                    e1.printStackTrace();
 
                }
            return true;
    
 }
private boolean pos_tsig22()
 {
        try {
            pst = connection.prepareStatement("SELECT salle_g2 FROM tsi where salle_g2='"+sg2_txt.getText()+"' and date='"+d_txt.getText()+"' and horaire_tsi ='"+h_txt.getText()+"' and duree_tsi='"+du_txt.getText()+"'");
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
                       alert.setContentText("Attention vous reservez la salle "+ sg2_txt.getText());
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
        em = EcomCalnController.emf.createEntityManager();
        handler = new dbconnect();
    
    }    
    
}
