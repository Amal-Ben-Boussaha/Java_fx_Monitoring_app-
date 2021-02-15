
package Controller;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
public class PlanningSCController implements Initializable {
    @FXML
    private TableView<Planningscfx> planningsr;
    @FXML
    private TableColumn<Planningscfx, Number> id;

    @FXML
    private TableColumn<Planningscfx, String> nc;

    @FXML
    private TableColumn<Planningscfx, String> j1s1;

    @FXML
    private TableColumn<Planningscfx, String> j1s2;

    @FXML
    private TableColumn<Planningscfx, String> j2s1;

    @FXML
    private TableColumn<Planningscfx, String> j2s2;

    @FXML
    private TableColumn<Planningscfx, String> j3s1;

    @FXML
    private TableColumn<Planningscfx, String> j3s2;

    @FXML
    private TableColumn<Planningscfx, String> j4s1;

    @FXML
    private TableColumn<Planningscfx, String> j4s2;

    @FXML
    private TableColumn<Planningscfx, String> j5s1;

    @FXML
    private TableColumn<Planningscfx, String> j5s2;

    @FXML
    private TableColumn<Planningscfx, String> j6s1;

    @FXML
    private TableColumn<Planningscfx, String> j6s2;

    @FXML
    private TableColumn<Planningscfx, String> j7s1;

    @FXML
    private TableColumn<Planningscfx, String> j7s2;

    @FXML
    private TableColumn<Planningscfx, String> j8s1;

    @FXML
    private TableColumn<Planningscfx, String> j8s2;

    @FXML
    private TableColumn<Planningscfx, String> j9s1;

    @FXML
    private TableColumn<Planningscfx, String> j9s2;

    @FXML
    private TableColumn<Planningscfx, String> j10s1;

    @FXML
    private TableColumn<Planningscfx, String> j10s2;

    @FXML
    private TableColumn<Planningscfx, String> j11s1;

    @FXML
    private TableColumn<Planningscfx, String> j11s2;

    @FXML
    private TableColumn<Planningscfx, String> j12s1;

    @FXML
    private TableColumn<Planningscfx, String> j12s2;

    @FXML
    private TableColumn<Planningscfx, String> j13s1;

    @FXML
    private TableColumn<Planningscfx, String> j13s2;

    @FXML
    private TableColumn<Planningscfx, String> j14s1;

    @FXML
    private TableColumn<Planningscfx, String> j14s2;

    @FXML
    private TableColumn<Planningscfx, String> j15s1;

    @FXML
    private TableColumn<Planningscfx, String> j15s2;

    @FXML
    private TableColumn<Planningscfx, String> nbre;
    private Connection connection;
    private dbconnect handler;
    private PreparedStatement pst;  
    ResultSet rs;
    EntityManager em;  
    public static EntityManagerFactory emf;
     ObservableList<Planningscfx> data;
    
    @FXML
    void afficher(ActionEvent event) {
        emf=Persistence.createEntityManagerFactory("ESENPU");
        em = PlanningSCController.emf.createEntityManager();
        emf=Persistence.createEntityManagerFactory("ESENPU");
        planningsr.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        List<Planningsc>lst = em.createQuery("SELECT p FROM Planningsc p").getResultList();
        
        data=FXCollections.observableArrayList();
        for(Planningsc lst1:lst){
           
        data.add(new Planningscfx(lst1.getIdPlanningSC(),lst1.getNomcomplt()
                ,lst1.getJ1s1(),lst1.getJ1s2(),lst1.getJ2s1(),lst1.getJ2s2(),lst1.getJ3s1(),lst1.getJ3s2()
                 ,lst1.getJ4s1(),lst1.getJ4s2(),lst1.getJ5s1(),lst1.getJ5s2()
                ,lst1.getJ6s1(),lst1.getJ6s2()
                ,lst1.getJ7s1(),lst1.getJ7s2(),lst1.getJ8s1(),lst1.getJ8s2(),lst1.getJ9s1(),lst1.getJ9s2()
                ,lst1.getJ10s1(),lst1.getJ10s2(),lst1.getJ11s1(),lst1.getJ11s2(),lst1.getJ12s1()
                ,lst1.getJ12s2(),lst1.getJ13s1(),lst1.getJ13s2()
                ,lst1.getJ14s1(),lst1.getJ14s2(),lst1.getJ15s1(),lst1.getJ15s2(),lst1.getNbre()
        ));
        }
        planningsr.setItems(data);
        id.setCellValueFactory(cell->cell.getValue().getIdPlanningSCProperty());
        nc.setCellValueFactory(cell->cell.getValue().getNomcompltProperty());
        j1s1.setCellValueFactory(cell->cell.getValue().getJ1s1Property());
        j1s2.setCellValueFactory(cell->cell.getValue().getJ1s2Proprty());
        j2s1.setCellValueFactory(cell->cell.getValue().getJ2s1Property());
        j2s2.setCellValueFactory(cell->cell.getValue().getJ2s2Property());
        j3s1.setCellValueFactory(cell->cell.getValue().getJ3s1Property());
        j3s2.setCellValueFactory(cell->cell.getValue().getJ3s2Property());
        j4s1.setCellValueFactory(cell->cell.getValue().getJ4s1Property());
        j4s2.setCellValueFactory(cell->cell.getValue().getJ4s2Property());
        j5s1.setCellValueFactory(cell->cell.getValue().getJ5s1PRoperty());
        j5s2.setCellValueFactory(cell->cell.getValue().getJ5s2Property());
        j6s1.setCellValueFactory(cell->cell.getValue().getJ6s1Property());
        j6s2.setCellValueFactory(cell->cell.getValue().getJ6s2Property());
        j7s1.setCellValueFactory(cell->cell.getValue().getJ7s1Property());
        j7s2.setCellValueFactory(cell->cell.getValue().getJ7s2Property());
        j8s1.setCellValueFactory(cell->cell.getValue().getJ8s1Property());
        j8s2.setCellValueFactory(cell->cell.getValue().getJ8s2Property());
        j9s1.setCellValueFactory(cell->cell.getValue().getJ9s1Property());
        j9s2.setCellValueFactory(cell->cell.getValue().getJ9s2Property());
        j10s1.setCellValueFactory(cell->cell.getValue().getJ10s1Property());
        j10s2.setCellValueFactory(cell->cell.getValue().getJ10s2Property());
        j11s1.setCellValueFactory(cell->cell.getValue().getJ11s1Property());
        j11s2.setCellValueFactory(cell->cell.getValue().getJ11s2Property());
        j12s1.setCellValueFactory(cell->cell.getValue().getJ12s1Property());
        j12s2.setCellValueFactory(cell->cell.getValue().getJ12s2Property());
        j13s1.setCellValueFactory(cell->cell.getValue().getJ13s1Property());
        j13s2.setCellValueFactory(cell->cell.getValue().getJ13s2Property());
        j14s1.setCellValueFactory(cell->cell.getValue().getJ14s1Property());
        j14s2.setCellValueFactory(cell->cell.getValue().getJ14s2Property());
        j15s1.setCellValueFactory(cell->cell.getValue().getJ15s1Property());
        j15s2.setCellValueFactory(cell->cell.getValue().getJ15s2Property());
        nbre.setCellValueFactory(cell->cell.getValue().getNbreProperty());
        
    }

    @FXML
    void ajouter(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/reglageseancerattrapage.fxml"));
        AnchorPane  mainPane = (AnchorPane)loader.load();
        Scene scene = new Scene(mainPane);
        stage.setTitle("Ajouter Nouvelle survillance");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        FrmJourRattrapageController ctrl = loader.getController();
        stage.showAndWait();
        actualiser();
    

    }
    private int entrejour()
    {
        int i=0;
           try {
            pst = connection.prepareStatement("SELECT count(idPlanningSC) FROM planningsc");
            rs = pst.executeQuery();
            while(rs.next())
            {
                i=rs.getInt(1);
             System.out.println(id);
            }
        
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return i;
    }
    private String Jour1()
   {
       String day1="";
    try {
            pst = connection.prepareStatement("SELECT j1s1 FROM planningsc where idPlanningSC='1' ");
             rs = pst.executeQuery();
            while(rs.next())
            {
                day1=rs.getString(1);
            }
        
        
        } catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
 
   return day1;
   }
     private String Jour2()
   {    String day1=Jour1();
       String day2="";
    try {
            pst = connection.prepareStatement("SELECT j2s1 FROM planningsc where idPlanningSC='1' ");
             rs = pst.executeQuery();
            while(rs.next())
            {
                day2=day1+" "+rs.getString(1);
            }
        
        
        } catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
 
   return day2;
   }
    private String Jour3()
   {    String day2=Jour2();
       String day3="";
    try {
            pst = connection.prepareStatement("SELECT j3s1 FROM planningsc where idPlanningSC='1' ");
             rs = pst.executeQuery();
            while(rs.next())
            {
                day3=day2+" "+rs.getString(1);
            }
        
        
        } catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
 
   return day3;
   }
 
 private String Jour4()
   {    String day3=Jour3();
       String day4="";
    try {
            pst = connection.prepareStatement("SELECT j4s1 FROM planningsc where idPlanningSC='1' ");
             rs = pst.executeQuery();
            while(rs.next())
            {
                day4=day3+" "+rs.getString(1);
            }
        
        
        } catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
 
   return day4;
   }
 
 private String Jour5()
   {    String day4=Jour4();
       String day5="";
    try {
            pst = connection.prepareStatement("SELECT j5s1 FROM planningsc where idPlanningSC='1' ");
             rs = pst.executeQuery();
            while(rs.next())
            {
                day5=day4+" "+rs.getString(1);
            }
        
        
        } catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
 
   return day5;
   }
 
 private String Jour6()
   {    String day5=Jour5();
       String day6="";
    try {
            pst = connection.prepareStatement("SELECT j6s1 FROM planningsc where idPlanningSC='1' ");
             rs = pst.executeQuery();
            while(rs.next())
            {
                day6=day5+" "+rs.getString(1);
                 System.out.println(day6);
            }} catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
 
   return day6;
   }
 
 private String Jour7()
   {    String day6=Jour6();
       String day7="";
    try {
            pst = connection.prepareStatement("SELECT j7s1 FROM planningsc where idPlanningSC='1' ");
             rs = pst.executeQuery();
                 while(rs.next())
                {day7=rs.getString(1);
                 
                }if(!day7.equals("")&&!day7.equals(" "))
                 {   
                day7=day6+" "+day7;
                  }
                else if(day7.equals(""))
                 {day7=day6;
                 }
                
     }catch (SQLException ex) {
                    ex.printStackTrace();
                }   
    return day7;
   }
   
 private String Jour8()
   {    String day7=Jour7();
       String day8="";
    
    try {
            pst = connection.prepareStatement("SELECT j8s1 FROM planningsc where idPlanningSC='1' ");
             rs = pst.executeQuery();
            
                 while(rs.next())
                {day8=rs.getString(1);
                 }
                 if(!day8.equals("")&&!day8.equals(" "))
                 {   
                  day8=day7+" "+day8;
                  }
                
                else if(day8.equals(""))
                 {day8=day7;
                 }
             } catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
   return day8;
   }
 
 private String Jour9()
   {    String day8=Jour8();
       String day9="";
    try {
            pst = connection.prepareStatement("SELECT j9s1 FROM planningsc where idPlanningSC='1' ");
                rs = pst.executeQuery();
                 while(rs.next())
                {day9=rs.getString(1);
                 }
                 if(!day9.equals("")&&!day9.equals(" "))
                 {   
                day9=day8+" "+day9;
                  }
                
                else if(day9.equals(""))
                 {day9=day8;
                 }
             } catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
   return day9;
   }
  private String Jour10()
   {    String day9=Jour9();
       String day10="";
    try {
            pst = connection.prepareStatement("SELECT j10s1 FROM planningsc where idPlanningSC='1' ");
             rs = pst.executeQuery();
            
                 while(rs.next())
                {day10=rs.getString(1);
                 }
                 if(!day10.equals("")&&!day10.equals(" "))
                 {   
                day10=day9+" "+day10;
                  }
                
                else if(day10.equals(""))
                 {day10=day9;
                 }
             } catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
   return day10;
   }
   private String Jour11()
   {    String day10=Jour10();
       String day11="";
    try {
            pst = connection.prepareStatement("SELECT j11s1 FROM planningsc where idPlanningSC='1' ");
             rs = pst.executeQuery();
            
                 while(rs.next())
                {day11=rs.getString(1);
                 }
                 if(!day11.equals("")&&!day11.equals(" "))
                 {   
                day11=day10+" "+day11;
                  }
                
                else if(day11.equals(""))
                 {day11=day10;
                 }
             } catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
   return day11;
   }
  private String Jour12()
   {    String day11=Jour11();
       String day12="";
    try {
            pst = connection.prepareStatement("SELECT j12s1 FROM planningsc where idPlanningSC='1' ");
             rs = pst.executeQuery();
           
                 while(rs.next())
                {day12=rs.getString(1);
                 }
                 if(!day12.equals("")&&!day12.equals(" "))
                 {   
                day12=day11+" "+day12;
                  }
                
                else if(day12.equals(""))
                 {day12=day11;
                 }
             } catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
   return day12;
   }
  private String Jour13()
   {    String day12=Jour12();
       String day13="";
    try {
            pst = connection.prepareStatement("SELECT j13s1 FROM planningsc where idPlanningSC='1' ");
             rs = pst.executeQuery();
             while(rs.next())
                {day13=rs.getString(1);
                 }
                 if(!day13.equals("")&&!day13.equals(" "))
                 {   
                day13=day12+" "+day13;
                  }
                
                else if(day13.equals(""))
                 {day13=day12;
                 }
             } catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
   return day13;
   }
  private String Jour14()
   {    String day13=Jour13();
       String day14="";
    try {
            pst = connection.prepareStatement("SELECT j14s1 FROM planningsc where idPlanningSC='1' ");
             rs = pst.executeQuery();
            
                 while(rs.next())
                {day14=rs.getString(1);
                 }
                 if(!day14.equals("")&&!day14.equals(" "))
                 {   
                day14=day13+" "+day14;
                  }
                
                else if(day14.equals(""))
                 {day14=day13;
                 }
             } catch (SQLException ex) 
        {
            ex.printStackTrace();
        }

   return day14;
   }
  private String Jour15()
   {    String day14=Jour14();
       String day15="";
    try {
            pst = connection.prepareStatement("SELECT j15s1 FROM planningsc where idPlanningSC='1' ");
             rs = pst.executeQuery();
                 while(rs.next())
                {day15=rs.getString(1);
                 }
                 if(!day15.equals("")&&!day15.equals(" "))
                 {   
                day15=day14+" "+day15;
                  }
                
                else if(day15.equals(""))
                 {day15=day14;
                 }
             } catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
 System.out.println(day15);
   return day15;
   }
 
   private String nomEns(String mat)
    {       String mStr = mat.replace( "'" , "''" );

        String nom="";
        try {
                pst = connection.prepareStatement("SELECT distinct(prof) from actitvite where matere LIKE '%"+mStr+"%' ");
                 rs = pst.executeQuery();
                 while(rs.next())
                {

                nom=nom +"  "+rs.getString(1);
                 System.out.println(nom);
                }


            } catch (SQLException ex) {
                    ex.printStackTrace();
            }
        return nom;
  }
    private String Matieres(String mat,String Hor)
    {String M="";
    String Mate=Matieresecom(mat,Hor);
    try {
                pst = connection.prepareStatement("SELECT matiere from lfig where date ='"+mat+"' and horaire ='"+Hor+"'");
                 rs = pst.executeQuery();
                 int count =0;
                 while(rs.next())
                {count++;
                if(count ==1)
                {M=rs.getString(1);
                }
                }if(M.equals("")){M="0";}
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
    if(M.equals("0")&&Mate.equals("0") )
    {
        M="0";
    }
    else if(!M.equals("0")&&!Mate.equals("0") )
            {
                M=M+"  "+Mate;
                System.out.println(M);
            }
    else if(!Mate.equals("")&&M.equals("0"))
    {
        M=Mate;
    }
    else 
    { M=M;}
    System.out.println(M);
        return M;
    }
   private String Matierestsi(String mat,String Hor)
    {   String M="";
    
    String Mate=Matieres(mat,Hor);
        try {
                pst = connection.prepareStatement("SELECT matiere_tsi from tsi where date ='"+mat+"'and horaire_tsi='"+Hor+"' ");
                rs = pst.executeQuery();
                 int count =0;
                 while(rs.next())
                {count++;
                if(count ==1)
                {M=rs.getString(1);
                }
                }if(M.equals("")){M="0";}
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
    if(M.equals("0")&&Mate.equals("0") )
    {
        M="0";
    }
    else if(!M.equals("0")&&!Mate.equals("0") )
            {
                M=M+"  "+Mate;
                System.out.println(M);
            }
    else if(!Mate.equals("")&&M.equals("0"))
    {
        M=Mate;
    }
    else 
    { M=M;}
    System.out.println(M);
    return M;
    }
    private String Matieresecom(String mat,String Hor)
    {
        String M="";
        try {
                pst = connection.prepareStatement("SELECT matiere_ecom from ecom where date_ecom ='"+mat+"'and horaire_ecom='"+Hor+"' ");
                 rs = pst.executeQuery();
                 int count =0;
                 while(rs.next())
                {count++;
                if(count ==1)
                {M=rs.getString(1);
                }}if(M.equals("")){M="0";}
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
        return M;
    }
 private String horaire1S1()
{   
   String M="";
        try {
                pst = connection.prepareStatement("SELECT nomseance from seanc_examen");
                 rs = pst.executeQuery();
                 while(rs.next())
                    {
                     M=M+" "+rs.getString(1);
                    }
                 } catch (SQLException ex) {
                    ex.printStackTrace();}
return M;}      
  private String GradeEns(String nomensg)
   {
    String M="";
    try {
                pst = connection.prepareStatement("SELECT grade from enseignant where nomcomplt like '%"+nomensg+"%'");
                 rs = pst.executeQuery();
                 while(rs.next())
                {
                    M=rs.getString(1);
                }
                 
     }catch (SQLException ex) {
                    ex.printStackTrace();
                }
   
    return M;
}  
private String ListesS1(String L,String h)
{    int a=0;
     String S="";
     String K=Matierestsi(L,h);
     String[] E =K.split("  ");
    
     while (a<E.length)
     {
         S=S+nomEns(E[a]);
        a++;
     }    return S;
}
private String Matieres2(String mat,String S)
{String T=Matieres2t(mat,S);
String M="";

        try {
                pst = connection.prepareStatement("SELECT matieres from lfig2 where date ='"+mat+"'and horaire='"+S+"' ");
                rs = pst.executeQuery();
                 int count =0;
                 while(rs.next())
                {count++;
                if(count ==1)
                {M=rs.getString(1);
                }
                }if(M.equals("")){M="0";}
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
    if(M.equals("0")&&T.equals("0") )
    {
        M="0";
    }
    else if(!M.equals("0")&&!T.equals("0") )
            {
                M=M+"  "+T;
                System.out.println(M);
            }
    else if(!T.equals("")&&M.equals("0"))
    {
        M=T;
    }
    else 
    { M=M;}
    System.out.println("1"+M);
    return M;
}     
private String Matieres2t(String mat,String S)
{   
String M="";

        try {
                pst = connection.prepareStatement("SELECT matieres_tsi from tsi2 where date_tsi ='"+mat+"'and horaire_tsi='"+S+"' ");
                rs = pst.executeQuery();
                 int count =0;
                 while(rs.next())
                {count++;
                if(count ==1)
                {M=rs.getString(1);
                }
                }if(M.equals("")){M="0";}
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
    System.out.println(M);
    return M;
}      
private String Matieres2e(String mat,String S)
{String T=Matieres2(mat,S);
String M="";

        try {
                pst = connection.prepareStatement("SELECT matieres_ecom from ecom2 where date_ecom ='"+mat+"'and horaire_ecom='"+S+"' ");
                rs = pst.executeQuery();
                 int count =0;
                 while(rs.next())
                {count++;
                if(count ==1)
                {M=rs.getString(1);
                }
                }if(M.equals("")){M="0";}
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
    if(M.equals("0")&&T.equals("0") )
    {
        M="0";
    }
    else if(!M.equals("0")&&!T.equals("0") )
            {
                M=M+"  "+T;
                System.out.println(M);
            }
    else if(!T.equals("")&&M.equals("0"))
    {
        M=T;
    }
    else 
    { M=M;}
    System.out.println("3"+M);
    return M;
}   
private String ListeMAtEns(String L,String Hor)
{       int a=0;
     String S="";
     
     String K= Matieres2e(L,Hor);
     String[] E =K.split("  ");
     while (a<E.length)
     {S=S+nomEns(E[a]);
        a++;
     } 
     
      System.out.println("bensba ll 2eme "+S);
    return S;
}
private String Matieres3l(String mat,String S)
{ String T=Matieres3t(mat,S);
String M="";

        try {
                pst = connection.prepareStatement("SELECT matieres from lfig3 where date ='"+mat+"'and horaire='"+S+"' ");
                rs = pst.executeQuery();
                 int count =0;
                 while(rs.next())
                {count++;
                if(count ==1)
                {M=rs.getString(1);
                }
                }if(M.equals("")){M="0";}
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
    if(M.equals("0")&&T.equals("0") )
    {
        M="0";
    }
    else if(!M.equals("0")&&!T.equals("0") )
            {
                M=M+"  "+T;
                System.out.println(M);
            }
    else if(!T.equals("")&&M.equals("0"))
    {
        M=T;
    }
    else 
    { M=M;}
    System.out.println("1"+M);
    return M;

}      
private String Matieres3t(String mat,String S)
{
   String M="";

        try {
                pst = connection.prepareStatement("SELECT matiers_tsi from tsi3 where date_tsi ='"+mat+"'and horaire_tsi='"+S+"' ");
                rs = pst.executeQuery();
                 int count =0;
                 while(rs.next())
                {count++;
                if(count ==1)
                {M=rs.getString(1);
                }
                }if(M.equals("")){M="0";}
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
    System.out.println("2"+M);
    return M;

}      
private String Matieres3e(String mat,String S)
{String T=Matieres3l(mat,S);
String M="";

        try {
                pst = connection.prepareStatement("SELECT matieres_ecom from ecom3 where date_ecom ='"+mat+"'and horaire_ecom='"+S+"' ");
                rs = pst.executeQuery();
                 int count =0;
                 while(rs.next())
                {count++;
                if(count ==1)
                {M=rs.getString(1);
                }
                }if(M.equals("")){M="0";}
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
    if(M.equals("0")&&T.equals("0") )
    {
        M="0";
    }
    else if(!M.equals("0")&&!T.equals("0") )
            {
                M=M+"  "+T;
                System.out.println(M);
            }
    else if(!T.equals("")&&M.equals("0"))
    {
        M=T;
    }
    else 
    { M=M;}
    System.out.println("3"+M);
    return M;
}
private String ListeEns(String L,String Hor)
{       int a=0;
     String S="";
     String K= Matieres3e(L,Hor);
     String[] E =K.split("  ");
     while (a<E.length)
     {System.out.print(a);
        S=S+nomEns(E[a]);
        a++;
     }
     System.out.println("bensba ll 3eme"+S);
     return S;
}
private String Matieres1m(String mat,String S)
{String M="";

        try {
                pst = connection.prepareStatement("SELECT matieres from mecom1 where date ='"+mat+"'and horaire ='"+S+"' ");
                rs = pst.executeQuery();
                 int count =0;
                 while(rs.next())
                {count++;
                if(count==1)
                {M=rs.getString(1);
                }
                }if(M.equals("")){M="0";}
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
    System.out.println("1"+M);
    return M;}
private String Matieresw1(String mat,String S)
{
String T=Matieres1m(mat,S);

String M="";

        try {
                pst = connection.prepareStatement("SELECT matieres_wi from wi1 where date_wi ='"+mat+"'and horaire_wi='"+S+"' ");
                rs = pst.executeQuery();
                 int count =0;
                 while(rs.next())
                {count++;
                if(count==1)
                {M=rs.getString(1);
                }
                }if(M.equals("")){M="0";}
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
    if(M.equals("0")&&T.equals("0") )
    {
        M="0";
    }
    else if(!M.equals("0")&&!T.equals("0") )
            {
                M=M+"  "+T;
                System.out.println(M);
            }
    else if(!T.equals("")&&M.equals("0"))
    {
        M=T;
    }
    else 
    { M=M;}
    System.out.println("2"+M);
    return M;
}
private String Matieres1b(String mat,String S)
{   String T=Matieres1v(mat,S);


String M="";

        try {
                pst = connection.prepareStatement("SELECT matieres_mbds from mbds1 where date_mbds ='"+mat+"'and horaire_mbds='"+S+"' ");
                rs = pst.executeQuery();
                 int count =0;
                 while(rs.next())
                {count++;
                if(count ==1)
                {M=rs.getString(1);
                }
                }if(M.equals("")){M="0";}
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
    if(M.equals("0")&&T.equals("0"))
    {
        M="0";
    }
    else if(!M.equals("0")&&!T.equals("0"))
            {
                M=M+"  "+T;
                System.out.println(M);
            }
    else if(!T.equals("")&&M.equals("0"))
    {
        M=T;
    }
    else  
    { M=M;}
    System.out.println("3"+M);
    return M;
}      
private String Matieres1v(String mat,String S)
{String T=Matieresw1(mat,S);

String M="";

        try {
                pst = connection.prepareStatement("SELECT matieres_vic from vic1 where date_vic ='"+mat+"'and horaire_vic='"+S+"' ");
                rs = pst.executeQuery();
                 int count =0;
                 while(rs.next())
                {count++;
                if(count==1)
                {M=rs.getString(1);
                }
                }if(M.equals("")){M="0";}
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
    if(M.equals("0")&&T.equals("0") )
    {
        M="0";
    }
    else if(!M.equals("0")&&!T.equals("0") )
            {
                M=M+"  "+T;
                System.out.println(M);
            }
    else if(!T.equals("")&&M.equals("0"))
    {
        M=T;
    }
    else 
    { M=M;}
    System.out.println("4"+M);
    return M;
}      
private String Matieres2m(String mat,String S)
{  String M="";
        try {
                pst = connection.prepareStatement("SELECT matieres from mecom2 where date ='"+mat+"' and horaire='"+S+"'");
                 rs = pst.executeQuery();
                 int count =0;
                 while(rs.next())
                {count++;
                if(count ==1)
                {M=rs.getString(1);
                }}if(M.equals("")){M="0";}
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
System.out.println("1"+M);
return M; 
}
private String Matieresw2(String mat,String S)
{
String L=Matieres2m(mat,S);
   String M="";
if(!L.equals("0"))
{   try {
                pst = connection.prepareStatement("SELECT matieres_wi from wi2 where date_wi ='"+mat+"'and Horaire_wi='"+S+"' ");
                 rs = pst.executeQuery();
                 
                 while(rs.next())
                {   System.out.println(L);
                   M=rs.getString(1)+"  "+L;
                }


                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
}else
{   try {
                pst = connection.prepareStatement("SELECT matieres_wi from wi2 where date_wi ='"+mat+"'and horaire_wi='"+S+"' ");
                 rs = pst.executeQuery();
                 int count =0;
                 while(rs.next())
                {count++;
                if(count ==1)
                {M=rs.getString(1);
                }}if(M.equals("")){M="0";}
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }}
System.out.println(M);
    return M; 


}
private String Matieres2b(String mat,String S)
{   String T=Matieres2v(mat,S);
String M="";

        try {
                pst = connection.prepareStatement("SELECT matieres_mbds from mbds2 where date_mbds ='"+mat+"'and horaire_mbds='"+S+"' ");
                rs = pst.executeQuery();
                 int count =0;
                 while(rs.next())
                {count++;
                if(count ==1)
                {M=rs.getString(1);
                }
                }if(M.equals("")){M="0";}
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
    if(M.equals("0")&&T.equals("0"))
    {
        M="0";
    }
    else if(!M.equals("0")&&!T.equals("0"))
            {
                M=M+"  "+T;
            }
    else if(!T.equals("")&&M.equals("0"))
    {
        M=T;
    }
    else  
    { M=M;}
    return M; 
}      
private String Matieres2v(String mat,String S)
{String L=Matieresw2(mat,S);
String M="";
if(!L.equals("0"))   
{
        try {
                pst = connection.prepareStatement("SELECT matieres_vic from vic2 where date_vic ='"+mat+"'and horaire_vic='"+S+"' ");
                 rs = pst.executeQuery();
                 while(rs.next())
                {System.out.println(L);
                   M=L+"  "+rs.getString(1);
                }


                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
}
else{
        try {
                pst = connection.prepareStatement("SELECT matieres_vic from vic2 where date_vic ='"+mat+"' and horaire_vic='"+S+"'");
                 rs = pst.executeQuery();
                  int count =0;
                 while(rs.next())
                {count++;
                if(count ==1)
                {M=rs.getString(1);
                }}if(M.equals("")){M="0";}
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }}
System.out.println(M);
    return M; 
}      

private String Listes(String L,String Hor)
{    int a=0;
     String S="";
     String K= Matieres1b(L,Hor);
     String[] E =K.split("  ");
     while (a<E.length)
     {System.out.println(E[a]);
     System.out.println(a);    
     S=S+nomEns(E[a]);
         a++;
     }
     System.out.println(" les ensg Sont:"+S);
     return S;
}
private String Listes2(String L,String Hor)
{    int a=0;
     String S="";
     String K= Matieres2b(L,Hor);
     String[] E =K.split("  ");
     while (a<E.length)
     {System.out.println(E[a]);
     System.out.println(a);    
     S=S+nomEns(E[a]);
         a++;
     }
     System.out.println(" les ensg Sont:"+S);
     return S;
}
private String ensgdisp(String date)
{String d="";
         try {
                pst = connection.prepareStatement("SELECT distinct(teachers) from disponibilites where day ='"+date+"' ");
                 rs = pst.executeQuery();
                 while(rs.next())
                
                 {d=rs.getString(1)+"  "+d;
                  }
                 } catch (SQLException ex) {
                    ex.printStackTrace();
}return d;
}
private String K(String d,String s)
{String L=ListesS1(d,s);
String L1=ListeEns(d,s);
String M=Listes(d,s);
String h=ListeMAtEns(d,s);
String j=Listes2(d,s);
String List=L+L1+M+h+j;
String S=List;
return S;

}
private void plannning1()
    {  
        String S = Jour15();
        String[] G =S.split(" ");
        int i=1,j=1,j1=1,f=1,f1=1,k=1,k1=1,a=1,a1=1,s=1,s1=1,l=1,l1=1,c=1,c1=1,z=1,z1=1,q=1,q1=1,h=1,h1=1,b=1,b1=1,x=1,x1=1,y=1,y1=0,v=1,v1=1,t=1,t1=1;
        while(i<G.length)
        { 
          if(i==1)
           {
               System.out.println(G[i]);
               String S1= horaire1S1();
               String[] A =S1.split(" ");
               int compteur=1;
               while(compteur<A.length)
              {if(A[compteur].equals("S1"))
                {
                    String Ens = K(G[i],A[compteur]);
                    String[] E =Ens.split("  ");
                     while(j<E.length)
                     {    String nom =GradeEns(E[j]);
                     System.out.println(nom);
                     if(!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences"))
                        {    try
                                {System.out.println("CV T3ADA");
                                    String update = "UPDATE planningsc SET `j1s1`='1', `j1s2`='1' where nomcomplt like '%"+E[j]+"%'";
                                    pst = connection.prepareStatement(update);
                                    pst.execute();
                                }   catch (SQLException e)
                                             {
                                                 e.printStackTrace();
                                             }
                           j++;
                        }else{
                                    try
                                    {System.out.println("CV T3ADA");
                                        String update = "UPDATE planningsc SET j1s1='1' where nomcomplt like '%"+E[j]+"%' ";
                           
                                        pst = connection.prepareStatement(update);
                                        pst.execute();
                               
                                    }catch (SQLException e)
                                            {e.printStackTrace();}
                                        j++;}}}
              else if(A[compteur].equals("S2"))
                           {
                               String Ens = K(G[i],A[compteur]);
                               String[] E =Ens.split("  ");
                     
                               if(!A[compteur].equals(""))
                                    {
                                        while(j1<E.length)
                                        {
                                            System.out.println(E[j1]);
                                            String nom =GradeEns(E[j1]);
                                            if(!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences"))
                                                {
                                                    try
                                                    {System.out.println("CV T3ADA");
                                                        String update = "UPDATE planningsc SET `j1s1`='1', `j1s2`='1' where nomcomplt like '%"+E[j1]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();
                                                            }
                                                    j1++;
                                                }
                                            else
                                                {
                                                    try
                                                    {System.out.println("CV T3ADA");
                                                        String update = "UPDATE planningsc SET j1s2='1' where nomcomplt like '%"+E[j1]+"%' ";
                           
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                               
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();}
                                                    j1++;
                                                }}}}compteur++;}}
            else
                if(i==3)
                {System.out.println(G[i]);
               String S1= horaire1S1();
               String[] A =S1.split(" ");
               int compteur=1;
               while(compteur<A.length)
               { if(A[compteur].equals("S1"))
                {
                    String Ens = K(G[i],A[compteur]);
                    String[] E =Ens.split("  ");
                    while(f<E.length)
                     { String nom =GradeEns(E[f]);
                        if(!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences"))
                        {try
                                {System.out.println("CV T3ADA");
                                    String update = "UPDATE planningsc SET `j2s1`='1', `j2s2`='1' where nomcomplt like '%"+E[f]+"%' ";
                                    pst = connection.prepareStatement(update);
                                    pst.execute();
                                }   catch (SQLException e)
                                             {
                                                 e.printStackTrace();
                                             }
                           f++;
                        }else
                                {
                                    try
                                    {System.out.println("CV T3ADA");
                                        String update = "UPDATE planningsc SET j2s1='1' where nomcomplt like '%"+E[f]+"%' ";
                           
                                        pst = connection.prepareStatement(update);
                                        pst.execute();
                               
                                    }catch (SQLException e)
                                            {e.printStackTrace();}
                                        f++;
                                }
                        }
                        }
                        
                           else if(A[compteur].equals("S2"))
                           {
                               String Ens = K(G[i],A[compteur]);
                               String[] E =Ens.split("  ");
                     
                               if(!A[compteur].equals(""))
                                    {
                                        while(f1<E.length)
                                        {
                                            System.out.println(E[f1]);
                                            String nom =GradeEns(E[f1]);
                                            if(!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences"))
                                                {
                                                    try
                                                    {System.out.println("CV T3ADA");
                                                        String update = "UPDATE planningsc SET `j2s1`='1', `j2s2`='1' where nomcomplt like '%"+E[f1]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();
                                                            }
                                                    f1++;
                                                }
                                            else
                                                {
                                                    try
                                                    {System.out.println("CV T3ADA");
                                                        String update = "UPDATE planningsc SET j2s2='1' where nomcomplt like '%"+E[f1]+"%' ";
                           
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                               
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();}
                                                    f1++;
                                                }
                                        }
                                    }}compteur++;}}
           else if(i==5)
           {
               System.out.println(G[i]);
               String S1= horaire1S1();
               String[] A =S1.split(" ");
               int compteur=1;
               while(compteur<A.length)
              {if(A[compteur].equals("S1"))
                {
                    String Ens = K(G[i],A[compteur]);
                    String[] E =Ens.split("  ");
                     while(k<E.length)
                     {    String nom =GradeEns(E[k]);
                     System.out.println(nom);
                     if(!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences"))
                        {    try
                                {System.out.println("CV T3ADA");
                                    String update = "UPDATE planningsc SET `j3s1`='1', `j3s2`='1' where nomcomplt like '%"+E[k]+"%'";
                                    pst = connection.prepareStatement(update);
                                    pst.execute();
                                }   catch (SQLException e)
                                             {
                                                 e.printStackTrace();
                                             }
                           k++;
                        }else{
                                    try
                                    {System.out.println("CV T3ADA");
                                        String update = "UPDATE planningsc SET j3s1='1' where nomcomplt like '%"+E[k]+"%' ";
                           
                                        pst = connection.prepareStatement(update);
                                        pst.execute();
                               
                                    }catch (SQLException e)
                                            {e.printStackTrace();}
                                        k++;}}}
              else if(A[compteur].equals("S2"))
                           {
                               String Ens = K(G[i],A[compteur]);
                               String[] E =Ens.split("  ");
                     
                                        while(k1<E.length)
                                        {
                                            System.out.println(E[k1]);
                                            String nom =GradeEns(E[k1]);
                                            if(!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences"))
                                                {
                                                    try
                                                    {System.out.println("CV T3ADA");
                                                        String update = "UPDATE planningsc SET `j3s1`='1', `j3s2`='1' where nomcomplt like '%"+E[k1]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();
                                                            }
                                                    k1++;
                                                }
                                            else
                                                {
                                                    try
                                                    {System.out.println("CV T3ADA");
                                                        String update = "UPDATE planningsc SET j3s2='1' where nomcomplt like '%"+E[k1]+"%' ";
                           
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                               
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();}
                                                    k1++;
                                                }}}compteur++;}}
            
                     else 
                     if(i==7)
           
           { System.out.println(G[i]);
               String S1= horaire1S1();
               String[] A =S1.split(" ");
               int compteur=1;
               while(compteur<A.length)
               {if(A[compteur].equals("S1"))
                {
                    String Ens = K(G[i],A[compteur]);
                    String[] E =Ens.split("  ");
                        while(a<E.length)
                     { 
                         
                          String nom =GradeEns(E[a]);
                        if(!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences"))
                        {try
                                {System.out.println("CV T3ADA");
                                    String update = "UPDATE planningsc SET `j4s1`='1', `j4s2`='1' where nomcomplt like '%"+E[a]+"%' ";
                                    pst = connection.prepareStatement(update);
                                    pst.execute();
                                }   catch (SQLException e)
                                             {
                                                 e.printStackTrace();
                                             }
                           a++;
                        }else
                            
                                {
                                    try
                                    {System.out.println("CV T3ADA");
                                        String update = "UPDATE planningsc SET j4s1='1' where nomcomplt like '%"+E[a]+"%' ";
                           
                                        pst = connection.prepareStatement(update);
                                        pst.execute();
                               
                                    }catch (SQLException e)
                                            {e.printStackTrace();}
                                        a++;
                                }
                        }
                        }  else if(A[compteur].equals("S2"))
                           {
                               String Ens = K(G[i],A[compteur]);
                               String[] E =Ens.split("  ");
                     
                               if(!A[compteur].equals(""))
                                    {
                                        while(a1<E.length)
                                        {
                                            System.out.println(E[a1]);
                                            String nom =GradeEns(E[a1]);
                                            if(!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences"))
                                                {
                                                    try
                                                    {System.out.println("CV T3ADA");
                                                        String update = "UPDATE planningsc SET `j4s1`='1', `j4s2`='1' where nomcomplt like '%"+E[a1]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();
                                                            }
                                                    a1++;
                                                }
                                            else
                                                {
                                                    try
                                                    {System.out.println("CV T3ADA");
                                                        String update = "UPDATE planningsc SET j4s2='1' where nomcomplt like '%"+E[a1]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                               
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();}
                                                    a1++;}}}}
             compteur++;}}
                    
           else
               if(i==9)
           
           {   System.out.println(G[i]);
               String S1= horaire1S1();
               String[] A =S1.split(" ");
               int compteur=1;
               while(compteur<A.length)
               {if(A[compteur].equals("S1"))
                {
                    String Ens = K(G[i],A[compteur]);
                    String[] E =Ens.split("  ");
                        while(s<E.length)
                     {  String nom =GradeEns(E[s]);
                        if(!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences"))
                        {try
                                {System.out.println("CV T3ADA");
                                    String update = "UPDATE planningsc SET `j5s1`='1', `j5s2`='1' where nomcomplt like '%"+E[s]+"%' ";
                                    pst = connection.prepareStatement(update);
                                    pst.execute();
                                }   catch (SQLException e)
                                             {
                                                 e.printStackTrace();
                                             }
                           s++;
                        }else
                        {
                                    try
                                    {System.out.println("CV T3ADA");
                                        String update = "UPDATE planningsc SET j5s1='1' where nomcomplt like '%"+E[s]+"%' ";
                           
                                        pst = connection.prepareStatement(update);
                                        pst.execute();
                               
                                    }catch (SQLException e)
                                            {e.printStackTrace();}
                                        s++;
                                }
                        }
                        }  else if(A[compteur].equals("S2"))
                           {
                               String Ens = K(G[i],A[compteur]);
                               String[] E =Ens.split("  ");
                     
                               if(!A[compteur].equals(""))
                                    {
                                        while(s1<E.length)
                                        {
                                            System.out.println(E[s1]);
                                            String nom =GradeEns(E[s1]);
                                            if(!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences"))
                                                {
                                                    try
                                                    {System.out.println("CV T3ADA");
                                                        String update = "UPDATE planningsc SET `j5s1`='1', `j5s2`='1' where nomcomplt like '%"+E[s1]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();
                                                            }
                                                    s1++;
                                                }
                                            else
                                                {
                                                    try
                                                    {System.out.println("CV T3ADA");
                                                        String update = "UPDATE planningsc SET j5s2='1' where nomcomplt like '%"+E[s1]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                               
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();}
                                                    s1++;}}}}
             compteur++;}}
                    else if(i==11)
           
           {System.out.println(G[i]);
               String S1= horaire1S1();
               String[] A =S1.split(" ");
               int compteur=1;
               while(compteur<A.length)
              {
               if(A[compteur].equals("S1"))
                {
                    String Ens = K(G[i],A[compteur]);
                    String[] E =Ens.split("  ");
                    while(l<E.length)
                     { 
                          String nom =GradeEns(E[l]);
                        if(!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences"))
                        {
                            try
                                {System.out.println("CV T3ADA");
                                    String update = "UPDATE planningsc SET `j6s1`='1', `j6s2`='1' where nomcomplt like '%"+E[l]+"%' ";
                                    pst = connection.prepareStatement(update);
                                    pst.execute();
                                }   catch (SQLException e)
                                             {
                                                 e.printStackTrace();
                                             }
                           l++;
                        }else
                            
                                {
                                    try
                                    {System.out.println("CV T3ADA");
                                        String update = "UPDATE planningsc SET j6s1='1' where nomcomplt like '%"+E[l]+"%' ";
                           
                                        pst = connection.prepareStatement(update);
                                        pst.execute();
                               
                                    }catch (SQLException e)
                                            {e.printStackTrace();}
                                        l++;
                                }
                        }
                        }
                        
                           else if(A[compteur].equals("S2"))
                           {
                               String Ens = K(G[i],A[compteur]);
                               String[] E =Ens.split("  ");
                     
                               if(!A[compteur].equals(""))
                                    {
                                        while(l1<E.length)
                                        {
                                            System.out.println(E[l1]);
                                            String nom =GradeEns(E[l1]);
                                            if(!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences"))
                                                {
                                                    try
                                                    {System.out.println("CV T3ADA");
                                                        String update = "UPDATE planningsc SET `j6s1`='1', `j6s2`='1' where nomcomplt like '%"+E[l1]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();
                                                            }
                                                    l1++;
                                                }
                                            else
                                                {
                                                    try
                                                    {System.out.println("CV T3ADA");
                                                        String update = "UPDATE planningsc SET j6s2='1' where nomcomplt like '%"+E[l1]+"%' ";
                           
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                               
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();}
                                                    l1++;
                                                }}}}compteur++;}} 
           else if(i==13)
           { System.out.println(G[i]);
               String S1= horaire1S1();
               String[] A =S1.split(" ");
               int compteur=1;
               while(compteur<A.length)
               {
                   if(A[compteur].equals("S1"))
                        {
                        String Ens = K(G[i],A[compteur]);
                        String[] E =Ens.split("  ");
                            while(c<E.length)
                     { 
                         
                          String nom =GradeEns(E[c]);
                        if(!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences"))
                        {
                            
                                try
                                {System.out.println("CV T3ADA");
                                    String update = "UPDATE planningsc SET `j7s1`='1', `j7s2`='1' where nomcomplt like '%"+E[c]+"%' ";
                                    pst = connection.prepareStatement(update);
                                    pst.execute();
                                }   catch (SQLException e)
                                             {
                                                 e.printStackTrace();
                                             }
                           c++;
                        }else
                                {
                                    try
                                    {System.out.println("CV T3ADA");
                                        String update = "UPDATE planningsc SET j7s1='1' where nomcomplt like '%"+E[c]+"%' ";
                           
                                        pst = connection.prepareStatement(update);
                                        pst.execute();
                               
                                    }catch (SQLException e)
                                            {e.printStackTrace();}
                                        c++;
                                }
                        }
                        }
                           else if(A[compteur].equals("S2"))
                           {
                               String Ens = K(G[i],A[compteur]);
                               String[] E =Ens.split("  ");
                                while(c1<E.length)
                                        {
                                            System.out.println(E[c1]);
                                            String nom =GradeEns(E[c1]);
                                            if(!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences"))
                                                {
                                                    try
                                                    {System.out.println("CV T3ADA");
                                                        String update = "UPDATE planningsc SET `j7s1`='1', `j7s2`='1' where nomcomplt like '%"+E[c1]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();
                                                            }
                                                    c1++;
                                                }
                                            else
                                                {
                                                    try
                                                    {System.out.println("CV T3ADA");
                                                        String update = "UPDATE planningsc SET j7s2='1' where nomcomplt like '%"+E[c1]+"%' ";
                           
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                               
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();}
                                                    c1++;
                                                }}}compteur++;}
           }
           else if(i==15)
           
           {   System.out.println("LE DATE EST "+G[i]);
               String S1= horaire1S1();
               String[] A =S1.split(" ");
               int compteur=1;
               while(compteur<A.length){
               if(A[compteur].equals("S1"))
                {
                    String Ens = K(G[i],A[compteur]);
                    String[] E =Ens.split("  ");
                        while(z<E.length)
                     {  String nom =GradeEns(E[z]);
                        if(!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences"))
                        {try
                                {System.out.println("CV T3ADA");
                                    String update = "UPDATE planningsc SET `j8s1`='1', `j8s2`='1' where nomcomplt like '%"+E[z]+"%' ";
                                    pst = connection.prepareStatement(update);
                                    pst.execute();
                                }   catch (SQLException e)
                                             {
                                                 e.printStackTrace();
                                             }
                           z++;
                        }else
                             {
                                    try
                                    {System.out.println("CV T3ADA");
                                        String update = "UPDATE planningsc SET j8s1='1' where nomcomplt like '%"+E[z]+"%' ";
                           
                                        pst = connection.prepareStatement(update);
                                        pst.execute();
                               
                                    }catch (SQLException e)
                                            {e.printStackTrace();}
                                        z++;
                                }
                        }
                        }
                        
                           else if(A[compteur].equals("S2"))
                           {
                               String Ens = K(G[i],A[compteur]);
                               String[] E =Ens.split("  ");
                                        while(z1<E.length)
                                        {
                                            System.out.println(E[z1]);
                                            String nom =GradeEns(E[z1]);
                                            if(!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences"))
                                                {
                                                    try
                                                    {System.out.println("CV T3ADA");
                                                        String update = "UPDATE planningsc SET `j8s1`='1', `j8s2`='1' where nomcomplt like '%"+E[z1]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();
                                                            }
                                                    z1++;
                                                }
                                            else
                                                {
                                                    try
                                                    {System.out.println("CV T3ADA");
                                                        String update = "UPDATE planningsc SET j8s2='1' where nomcomplt like '%"+E[z1]+"%' ";
                           
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                               
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();}
                                                    z1++;}}}compteur++;}}
           else 
                    if(i==17){System.out.println(G[i]);
               String S1= horaire1S1();
               String[] A =S1.split(" ");
               int compteur=1;
               while(compteur<A.length)
              
               { System.out.println("loulitheni"+A[1]+"3");
               if(A[compteur].equals("S1"))
                {
                    String Ens = K(G[i],A[compteur]);
                    String[] E =Ens.split("  ");
                        while(h<E.length)
                     { 
                         
                          String nom =GradeEns(E[h]);
                        if(!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences"))
                        {
                            
                                try
                                {System.out.println("CV T3ADA");
                                    String update = "UPDATE planningsc SET `j9s1`='1', `j9s2`='1' where nomcomplt like '%"+E[h]+"%' ";
                                    pst = connection.prepareStatement(update);
                                    pst.execute();
                                }   catch (SQLException e)
                                             {
                                                 e.printStackTrace();
                                             }
                           h++;
                        }else
                            
                                {
                                    try
                                    {System.out.println("CV T3ADA");
                                        String update = "UPDATE planningsc SET j9s1='1' where nomcomplt like '%"+E[h]+"%' ";
                           
                                        pst = connection.prepareStatement(update);
                                        pst.execute();
                               
                                    }catch (SQLException e)
                                            {e.printStackTrace();}
                                        h++;
                                }
                        }
                        }
                        
                           else if(A[compteur].equals("S2"))
                           {
                               String Ens = K(G[i],A[compteur]);
                               String[] E =Ens.split("  ");
                                        while(h1<E.length)
                                        {
                                            System.out.println(E[h1]);
                                            String nom =GradeEns(E[h1]);
                                            if(!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences"))
                                                {
                                                    try
                                                    {System.out.println("CV T3ADA");
                                                        String update = "UPDATE planningsc SET `j9s1`='1', `j9s2`='1' where nomcomplt like '%"+E[h1]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();
                                                            }
                                                    h1++;
                                                }
                                            else
                                                {
                                                    try
                                                    {System.out.println("CV T3ADA");
                                                        String update = "UPDATE planningsc SET j9s2='1' where nomcomplt like '%"+E[h1]+"%' ";
                           
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                               
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();}
                                                    h1++;}}
                           }compteur++;}}
                    else
                        if(i==19)
                        {System.out.println("LE DATE EST "+G[i]);
                         String S1= horaire1S1();
                         String[] A =S1.split(" ");
                         int compteur=1;
                         while(compteur<A.length)
              
                            {if(A[compteur].equals("S1"))
                            {
                            String Ens = K(G[i],A[compteur]);
                            String[] E =Ens.split("  ");
                             while(q<E.length)
                             { 
                                  System.out.println(E[q]);
                                  String nom =GradeEns(E[q]);
                                  if(!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences"))
                                        {

                                                try
                                                    {
                                                        String update = "UPDATE planningsc SET `j10s1`='1', `j10s2`='1' where nomcomplt like '%"+E[q]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                    }   catch (SQLException e)
                                                                 {
                                                                     e.printStackTrace();
                                                                 }
                                               q++;
                                        }
                                  else

                                        {
                                            try
                                                    {
                                                String update = "UPDATE planningsc SET j10s1='1' where nomcomplt like '%"+E[q]+"%' ";

                                                pst = connection.prepareStatement(update);
                                                pst.execute();

                                            }catch (SQLException e)
                                                    {e.printStackTrace();}
                                                q++;
                                        }
                             }
                            }
                                
                                   else if(A[compteur].equals("S2"))
                           {
                               String Ens = K(G[i],A[compteur]);
                               String[] E =Ens.split("  ");
                               while(q1<E.length)
                                        {
                                            System.out.println(E[q1]);
                                            String nom =GradeEns(E[q1]);
                                            if(!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences"))
                                                {
                                                    try
                                                    {
                                                        String update = "UPDATE planningsc SET `j10s1`='1', `j10s2`='1' where nomcomplt like '%"+E[q1]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();
                                                            }
                                                    q1++;
                                                }
                                            else
                                                {
                                                    try
                                                    {
                                                        String update = "UPDATE planningsc SET j0s2='1' where nomcomplt like '%"+E[q1]+"%' ";
                           
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                               
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();}
                                                    q1++;}}}
                           compteur++;}}
                         else if(i==21)
                        {System.out.println(G[i]);
               String S1= horaire1S1();
               String[] A =S1.split(" ");
               int compteur=1;
               while(compteur<A.length)
               {if(A[compteur].equals("S1"))
                {
                    String Ens = K(G[i],A[compteur]);
                    String[] E =Ens.split("  ");
                        while(b<E.length)
                     { String nom =GradeEns(E[b]);
                        if(!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences"))
                        {try
                                {System.out.println("CV T3ADA");
                                    String update = "UPDATE planningsc SET `j11s1`='1', `j11s2`='1' where nomcomplt like '%"+E[b]+"%' ";
                                    pst = connection.prepareStatement(update);
                                    pst.execute();
                                }   catch (SQLException e)
                                             {
                                                 e.printStackTrace();
                                             }
                           b++;
                        }else
                            
                                {
                                    try
                                    {System.out.println("CV T3ADA");
                                        String update = "UPDATE planningsc SET j11s1='1' where nomcomplt like '%"+E[b]+"%' ";
                           
                                        pst = connection.prepareStatement(update);
                                        pst.execute();
                               
                                    }catch (SQLException e)
                                            {e.printStackTrace();}
                                        b++;
                                }
                        }
                        }
                        
                           else if(A[compteur].equals("S2"))
                           {
                               String Ens = K(G[i],A[compteur]);
                               String[] E =Ens.split("  ");
                                while(b1<E.length)
                                        {
                                            System.out.println(E[b1]);
                                            String nom =GradeEns(E[b1]);
                                            if(!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences"))
                                                {
                                                    try
                                                    {System.out.println("CV T3ADA");
                                                        String update = "UPDATE planningsc SET `j11s1`='1', `j11s2`='1' where nomcomplt like '%"+E[b1]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();
                                                            }
                                                    b1++;
                                                }
                                            else
                                                {
                                                    try
                                                    {System.out.println("CV T3ADA");
                                                        String update = "UPDATE planningsc SET j11s2='1' where nomcomplt like '%"+E[b1]+"%' ";
                           
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                               
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();}
                                                    b1++;}}}compteur++;}}
               else if(i==23)
           {
               System.out.println(G[i]);
               String S1= horaire1S1();
               String[] A =S1.split(" ");
               int compteur=1;
               while(compteur<A.length)
               {if(A[compteur].equals("S1"))
                {
                    String Ens = K(G[i],A[compteur]);
                    String[] E =Ens.split("  ");
                     while(x<E.length)
                     { String nom =GradeEns(E[x]);
                        if(!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences"))
                        {try
                                {System.out.println("CV T3ADA");
                                    String update = "UPDATE planningsc SET `j12s1`='1', `j12s2`='1' where nomcomplt like '%"+E[x]+"%' ";
                                    pst = connection.prepareStatement(update);
                                    pst.execute();
                                }   catch (SQLException e)
                                             {
                                                 e.printStackTrace();
                                             }
                           x++;
                        }else
                            
                                {try
                                    {System.out.println("CV T3ADA");
                                        String update = "UPDATE planningsc SET j12s1='1' where nomcomplt like '%"+E[x]+"%' ";
                                        pst = connection.prepareStatement(update);
                                        pst.execute();
                               
                                    }catch (SQLException e)
                                            {e.printStackTrace();}
                                        x++;
                                }
                        }
                        }
                           else if(A[compteur].equals("S2"))
                           {
                               String Ens = K(G[i],A[compteur]);
                               String[] E =Ens.split("  ");
                               while(x1<E.length)
                                        {
                                            System.out.println(E[x1]);
                                            String nom =GradeEns(E[x1]);
                                            if(!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences"))
                                                {
                                                    try
                                                    {System.out.println("CV T3ADA");
                                                        String update = "UPDATE planningsc SET `j12s1`='1', `j12s2`='1' where nomcomplt like '%"+E[x1]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();
                                                            }
                                                    x1++;
                                                }
                                            else
                                                {
                                                    try
                                                    {System.out.println("CV T3ADA");
                                                        String update = "UPDATE planningsc SET j12s2='1' where nomcomplt like '%"+E[x1]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                               
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();}
                                                    x1++;
                                                }}}compteur++;}}
           else
                   if(i==25)
                   {System.out.println(G[i]);
               String S1= horaire1S1();
               String[] A =S1.split(" ");
               int compteur=1;
               while(compteur<A.length)
               {if(A[compteur].equals("S1"))
                { String Ens = K(G[i],A[compteur]);
                    String[] E =Ens.split("  ");
                     while(v<E.length)
                     {  String nom =GradeEns(E[v]);
                        if(!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences"))
                        {try
                                {System.out.println("CV T3ADA");
                                    String update = "UPDATE planningsc SET `j13s1`='1', `j13s2`='1' where nomcomplt like '%"+E[v]+"%' ";
                                    pst = connection.prepareStatement(update);
                                    pst.execute();
                                }   catch (SQLException e)
                                             {
                                                 e.printStackTrace();
                                             }
                           v++;
                        }else
                            {try
                                    {System.out.println("CV T3ADA");
                                        String update = "UPDATE planningsc SET j13s1='1' where nomcomplt like '%"+E[v]+"%' ";
                           
                                        pst = connection.prepareStatement(update);
                                        pst.execute();
                               
                                    }catch (SQLException e)
                                            {e.printStackTrace();}
                                        v++;}}}else if(A[compteur].equals("S2"))
                           {
                               String Ens = K(G[i],A[compteur]);
                               String[] E =Ens.split("  ");
                                while(v1<E.length)
                                        {
                                            System.out.println(E[v1]);
                                            String nom =GradeEns(E[v1]);
                                            if(!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences"))
                                                {
                                                    try
                                                    {System.out.println("CV T3ADA");
                                                        String update = "UPDATE planningsc SET `j13s1`='1', `j13s2`='1' where nomcomplt like '%"+E[v1]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();
                                                            }
                                                    v1++;
                                                }
                                            else
                                                {
                                                    try
                                                    {System.out.println("CV T3ADA");
                                                        String update = "UPDATE planningsc SET j13s2='1' where nomcomplt like '%"+E[v1]+"%' ";
                           
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                               
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();}
                                                    v1++;
                                                }}}compteur++;}}
               else 
                   if(i==27)
                   {System.out.println(G[i]);
               String S1= horaire1S1();
               String[] A =S1.split(" ");
               int compteur=1;
               while(compteur<A.length)
               {if(A[compteur].equals("S1"))
                {
                    String Ens = K(G[i],A[compteur]);
                    String[] E =Ens.split("  ");
                     while(t<E.length)
                     { String nom =GradeEns(E[t]);
                        if(!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences"))
                        {try
                                {System.out.println("CV T3ADA");
                                    String update = "UPDATE planningsc SET `j14s1`='1', `j14s2`='1' where nomcomplt like '%"+E[t]+"%' ";
                                    pst = connection.prepareStatement(update);
                                    pst.execute();
                                }   catch (SQLException e)
                                             {
                                                 e.printStackTrace();
                                             }
                           t++;
                        }else{
                                    try
                                    {System.out.println("CV T3ADA");
                                        String update = "UPDATE planningsc SET j14s1='1' where nomcomplt like '%"+E[t]+"%' ";
                           
                                        pst = connection.prepareStatement(update);
                                        pst.execute();
                               
                                    }catch (SQLException e)
                                            {e.printStackTrace();}
                                        t++;}}} else if(A[compteur].equals("S2"))
                           {
                               String Ens = K(G[i],A[compteur]);
                               String[] E =Ens.split("  ");
                                   while(t1<E.length)
                                        {
                                            System.out.println(E[t1]);
                                            String nom =GradeEns(E[t1]);
                                            if(!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences"))
                                                {
                                                    try
                                                    {System.out.println("CV T3ADA");
                                                        String update = "UPDATE planningsc SET `j14s1`='1', `j14s2`='1' where nomcomplt like '%"+E[t1]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();
                                                            }
                                                    t1++;
                                                }
                                            else
                                                {
                                                    try
                                                    {System.out.println("CV T3ADA");
                                                        String update = "UPDATE planningsc SET j14s2='1' where nomcomplt like '%"+E[t1]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                               
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();}
                                                    t1++;
                                                }}}compteur++;}}
           else
                   if(i==29)
                   {System.out.println(G[i]);
               String S1= horaire1S1();
               String[] A =S1.split(" ");
               int compteur=1;
               while(compteur<A.length)
               {if(A[compteur].equals("S1"))
                {   String Ens = K(G[i],A[compteur]);
                    String[] E =Ens.split("  ");
                        while(y<E.length)
                     {  String nom =GradeEns(E[y]);
                        if(!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences"))
                        {try
                                {System.out.println("CV T3ADA");
                                    String update = "UPDATE planningsc SET `j15s1`='1', `j15s2`='1' where nomcomplt like '%"+E[y]+"%' ";
                                    pst = connection.prepareStatement(update);
                                    pst.execute();
                                }   catch (SQLException e)
                                             {
                                                 e.printStackTrace();
                                             }
                           y++;
                        }else{try
                                    {System.out.println("CV T3ADA");
                                        String update = "UPDATE planningsc SET j15s1='1' where nomcomplt like '%"+E[y]+"%' ";
                           
                                        pst = connection.prepareStatement(update);
                                        pst.execute();
                               
                                    }catch (SQLException e)
                                            {e.printStackTrace();}
                                        y++;
                                }}}else if(A[compteur].equals("S2"))
                           {
                               String Ens = K(G[i],A[compteur]);
                               String[] E =Ens.split("  ");
                     
                                        while(y1<E.length)
                                        {
                                            System.out.println(E[y1]);
                                            String nom =GradeEns(E[y1]);
                                            if(!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences"))
                                                {
                                                    try
                                                    {System.out.println("CV T3ADA");
                                                        String update = "UPDATE planningsc SET `j15s1`='1', `j15s2`='1' where nomcomplt like '%"+E[y1]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();
                                                            }
                                                    y1++;
                                                }
                                            else
                                                {
                                                    try
                                                    {System.out.println("CV T3ADA");
                                                        String update = "UPDATE planningsc SET j15s2='1' where nomcomplt like '%"+E[y1]+"%' ";
                           
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                               
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();}
                                                    y1++;
                                                }}}compteur++;}
              break;}i=i+2;
    }
    }
    private String SalleDisponibles(String date,String S)
   {String i="";
     try {
                pst = connection.prepareStatement("SELECT salleg1 from lfig where date='"+date+"' and horaire ='"+S+"' ");
                 rs = pst.executeQuery();
                int count =0;
                 while(rs.next())
                {count = count+1;
                 if(count == 1)
                 {   
                i=rs.getString(1);
                  }}
                 if(i.equals(""))
                 {i="a";
                 }} catch (SQLException ex) {
                    ex.printStackTrace();
                }
   return i;
   }
   private String Salle2(String date,String S)
   {String i="";
     try {
                pst = connection.prepareStatement("SELECT salleg2 from lfig where date='"+date+"' and horaire ='"+S+"' ");
                 rs = pst.executeQuery();
                 int count =0;
                 while(rs.next())
                {count = count+1;
                 if(count == 1)
                 {   
                i=rs.getString(1);
                  }}
                 if(i.equals(""))
                 {i="b";
                 }} catch (SQLException ex) {
                    ex.printStackTrace();
                }
   return i;
   }
   private String Salle3(String date,String S)
   {String i="";
     try {
                pst = connection.prepareStatement("SELECT salleg3 from lfig where date='"+date+"' and horaire ='"+S+"' ");
                 rs = pst.executeQuery();
                 int count =0;
                 while(rs.next())
                {count = count+1;
                 if(count == 1)
                 {   
                i=rs.getString(1);
                  }}
                 if(i.equals(""))
                 {     
                 i="c";
                 }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
   return i;
   }private String Salle4(String date,String S)
   {String i="";
     try {
                pst = connection.prepareStatement("SELECT salleg4 from lfig where date='"+date+"' and horaire ='"+S+"' ");
                 rs = pst.executeQuery();
                 int count =0;
                 while(rs.next())
                {count = count+1;
                 if(count == 1)
                 {   
                i=rs.getString(1);}}
                 if(i.equals(""))
                 {       
                 i="d";
                 }} catch (SQLException ex) {
                    ex.printStackTrace();
                }
   return i;
   }
   private int nombsalle(String Date,String S)
   {int i=0;
   String a=SalleDisponibles(Date,S),b=Salle2(Date,S),c=Salle3(Date,S),d=Salle4(Date,S);
   boolean e=true; 
   if((!a.equals("a")&&!b.equals("b"))||(!c.equals("c")&&!d.equals("d")))
   {
   if(a.equals(b))
    {   e=false;
        i=1;
    
    } else
        {i=2;}
    if(c.equals(d)&& e==false)
    {
        i=2;
    }
    else i=4;   
   }else i=0;
   System.out.println("les salle sont"+i);
   return i;
   }
   private String Salle1T(String date,String S)
   {String i="";
     try {
                pst = connection.prepareStatement("SELECT salle_g1 from tsi where date='"+date+"' and horaire_tsi ='"+S+"' ");
                 rs = pst.executeQuery();
                 int count =0;
                 while(rs.next())
                {count = count+1;
                 if(count == 1)
                 {   
                i=rs.getString(1);}}
                 if(i.equals(""))
                 {       
                    i="a";
                 }
                 } catch (SQLException ex) {
                    ex.printStackTrace();
                }
   return i;
   }
   private String Salle2T(String date,String S)
   {String i="";
     try {
                pst = connection.prepareStatement("SELECT salle_g2 from tsi where date='"+date+"' and horaire_tsi ='"+S+"' ");
                 rs = pst.executeQuery();
                 int count =0;
                 while(rs.next())
                {count = count+1;
                 if(count == 1)
                 {   
                i=rs.getString(1);
                }}
                 if(i.equals(""))
                 {i="b";
                 }} catch (SQLException ex) {
                    ex.printStackTrace();
                }
   return i;
   }
   private String Salle1E(String date,String S)
   {String i="";
     try {
                pst = connection.prepareStatement("SELECT salle_g1 from ecom where date_ecom='"+date+"' and horaire_ecom ='"+S+"' ");
                 rs = pst.executeQuery();
                 int count =0;
                 while(rs.next())
                {count = count+1;
                 if(count == 1)
                 {   
                i=rs.getString(1);
                }
                }if(i.equals(""))
                 {i="c";
                 } }catch (SQLException ex) {
                    ex.printStackTrace();
                }
   return i;
   }
   private String Salle2E(String date,String S)
   {String i="";
     try {
                pst = connection.prepareStatement("SELECT lle_g2 from ecom where date_ecom='"+date+"' and horaire_ecom ='"+S+"' ");
                 rs = pst.executeQuery();
                 int count =0;
                 while(rs.next())
                {count = count+1;
                 if(count == 1)
                 {   
                i=rs.getString(1);
                  }
                }
                 if(i.equals(""))
                 {i="d";
                 }
                
     }catch (SQLException ex) {
                    ex.printStackTrace();
                }
   return i;
   }
   
   private int nombsalle1(String Date,String S)
   {int i=0;
   String a=Salle1T(Date,S),b=Salle2T(Date,S),c=Salle1E(Date,S),d=Salle2E(Date,S);
      if((!a.equals("a")&&!b.equals("b"))||(!c.equals("c")&&!d.equals("d")))
   {
       if(a.equals(b))
    { i=1;
    } else
       if(!a.equals("a")) 
       {i=2;}
    if(c.equals(d))
    {
        i=i+1;
    }
    else
        if(!c.equals("c"))
        {i=i+2;}   
   }
   else{ i=0;}
   System.out.println("les salle sont"+i);
   return i;
   }
   private int nombensg(String d)
   {String k="";
 int i;
  String insert = "Select count('"+d+"') from planningsc where "+d+"='1'";
        try
        {  
            pst = connection.prepareStatement(insert);
            rs=pst.executeQuery();
            while(rs.next())
            {
                k=rs.getString("count('"+d+"')");
                }
        }
        catch (SQLException e1)
            {
                e1.printStackTrace();
            }
i = Integer.parseInt(k); 
return i;
}
   private int nbSurvillance(String nomc)
        {String N="";
        int i;
            String insert = "SELECT sum(j1s1 + j1s2+j2s1 +j2s2 +j3s1 +j3s2+j4s1+j4s2+j5s1 +j5s2+j6s1 +j6s2 +j7s1 +j7s2+j8s1 +j8s2+j9s1 +j9s2+j10s1 +j10s2+j11s1+j11s2+j12s1+j12s2+j13s1+j13s2+j14s1+j14s2+j15s1+j15s2) from  planningsc where nomcomplt like '%"+nomc+"%'";
        try
        {  
            pst = connection.prepareStatement(insert);
            rs=pst.executeQuery();
            while(rs.next())
            {
                N=rs.getString("sum(j1s1 + j1s2+j2s1 +j2s2 +j3s1 +j3s2+j4s1+j4s2+j5s1 +j5s2+j6s1 +j6s2 +j7s1 +j7s2+j8s1 +j8s2+j9s1 +j9s2+j10s1 +j10s2+j11s1+j11s2+j12s1+j12s2+j13s1+j13s2+j14s1+j14s2+j15s1+j15s2)");
                }
        }
        catch (SQLException e1)
            {
                e1.printStackTrace();
            }
i = Integer.parseInt(N);
System.out.println("il asteth il fleni haw 9adech 3ase"+i);
return i;
}
private int maxsurgrade(String grade)
{int i;
String L = "";
try {
                pst = connection.prepareStatement("SELECT nbseancemax from grade where nomgrade='"+grade+"' ");
                 rs = pst.executeQuery();
                 
                 while(rs.next())
                {   
                L=rs.getString(1);
                }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
i = Integer.parseInt(L);
System.out.println(" le grade max est "+i);   
return i;
}
private int minsurgrade(String grade)
{int i=0;
String L="";
try {
                pst = connection.prepareStatement("SELECT nbseancemin from grade where nomgrade='"+grade+"'");
                 rs = pst.executeQuery();
                 
                 while(rs.next())
                {   
                L=rs.getString(1);
                  
                }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
i = Integer.parseInt(L);
System.out.println("le grade min"+i);   
return i;
}

private int minid()
    {
        int i=0;
           try {
            pst = connection.prepareStatement("SELECT min(idPlanningSC) FROM planningsc");
            rs = pst.executeQuery();
            while(rs.next())
            {
                i=rs.getInt(1);
             System.out.println(i);
            }
        
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return i;
    }
 private int maxid()
    {
        int i=0;
           try {
            pst = connection.prepareStatement("SELECT max(idPlanningSC) FROM planningsc");
            rs = pst.executeQuery();
            while(rs.next())
            {
                i=rs.getInt(1);
             System.out.println(i);
            }
        
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return i;
    }
   private void nbre()
{
    int i=minid(),j=maxid();
String l="";
    while(i<=j)
    {try {
            pst = connection.prepareStatement("SELECT nomcomplt FROM planningsc where idPlanningSC="+i+"");
            rs = pst.executeQuery();
            while(rs.next())
            {
            l=rs.getString(1);
             System.out.println(l);
            }
        
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        }    int S=nbSurvillance(l);

        try{
                               String update = "UPDATE planningsc SET nbre="+S+" where idPlanningSC="+i+"   ";
                               pst = connection.prepareStatement(update);
                               pst.execute();
                               } catch (SQLException e)
                               {
                                   e.printStackTrace();

                               }
           
i++;}
}
   private int S1Mecom(String date,String S)
   {String M="";
   
   int i;  
   try {
                pst = connection.prepareStatement("SELECT COUNT(salle) from mecom1 where date='"+date+"' and horaire ='"+S+"' ");
                 rs = pst.executeQuery();
                while(rs.next())
                {   
                M=rs.getString("count(salle)");
                  }
   } catch (SQLException ex) {
                    ex.printStackTrace();
                }
   i = Integer.parseInt(M);
   return i;
   }
   private int S2Mecom(String date,String S)
   {String M="";
   
   int i=0;  
   try {
                pst = connection.prepareStatement("SELECT count(salle) from mecom2 where date='"+date+"' and horaire ='"+S+"' ");
                 rs = pst.executeQuery();
                int count =0;
                 while(rs.next())
                {   
                M=rs.getString("count(salle)");
                  }
   } catch (SQLException ex) {
                    ex.printStackTrace();
                }
   i = Integer.parseInt(M);
   return i;
   }
   private int S1Mbds(String date,String S)
   {String M="";
      int i=0;

     try {
                pst = connection.prepareStatement("SELECT count(salle_mbds) from mbds1 where date_mbds='"+date+"' and horaire_mbds ='"+S+"' ");
                 rs = pst.executeQuery();
                 int count =0;
                 while(rs.next())
                {   
                M=rs.getString("count(salle_mbds)");
                  }
   } catch (SQLException ex) {
                    ex.printStackTrace();
                }
   i = Integer.parseInt(M);
   return i;
   }
   private int S2Mbds(String date,String S)
   {String M="";
       int i=0;
   
   try {
                pst = connection.prepareStatement("SELECT count(salle_mbds) from mbds2 where date_mbds='"+date+"' and horaire_mbds ='"+S+"' ");
                 rs = pst.executeQuery();
                 while(rs.next())
                {   
                M=rs.getString("count(salle_mbds)");
                  }
   } catch (SQLException ex) {
                    ex.printStackTrace();
                }
   i = Integer.parseInt(M);
   return i;
   }
   private int S1vic(String date,String S)
   {String M="";
   int i;
   
   try {
                pst = connection.prepareStatement("SELECT count(salle_vic) from vic1 where date_vic='"+date+"' and horaire_vic ='"+S+"' ");
                 rs = pst.executeQuery();
               rs = pst.executeQuery();
                 while(rs.next())
                {   
                M=rs.getString("count(salle_vic)");
                  }
   } catch (SQLException ex) {
                    ex.printStackTrace();
                }
   i = Integer.parseInt(M);
   return i;}
   private int S2vic(String date,String S)
   {String M="";
   int i;
   
   try {
                pst = connection.prepareStatement("SELECT count(salle_vic) from vic2 where date_vic='"+date+"' and horaire_vic ='"+S+"' ");
                 rs = pst.executeQuery();
                 int count =0;
                rs = pst.executeQuery();
                 while(rs.next())
                {   
                M=rs.getString("count(salle_vic)");
                  }
   } catch (SQLException ex) {
                    ex.printStackTrace();
                }
   i = Integer.parseInt(M);
   return i;}
   private int S1Wi(String date,String S)
   {String M="";
   int i;
  
     try {
                pst = connection.prepareStatement("SELECT count(salle_wi) from wi1 where date_wi='"+date+"' and horaire_wi ='"+S+"' ");
                 rs = pst.executeQuery();
                 int count =0;
                 rs = pst.executeQuery();
                 while(rs.next())
                {   
                M=rs.getString("count(salle_wi)");
                  }
   } catch (SQLException ex) {
                    ex.printStackTrace();
                }
   i = Integer.parseInt(M);
   return i;
   }private int S2wi(String date,String S)
   {String M="";
   int i;
 
   try {
                pst = connection.prepareStatement("SELECT count(salle_wi) from wi2 where date_wi='"+date+"' and horaire_wi ='"+S+"' ");
                 rs = pst.executeQuery();
                
                 rs = pst.executeQuery();
                 while(rs.next())
                {   
                M=rs.getString("count(salle_wi)");
                  }
   } catch (SQLException ex) {
                    ex.printStackTrace();
                }
   i = Integer.parseInt(M);
   return i;
   }
   private int Salle1M(String Date,String S)
   {int i;
   
   int j= S1Mecom(Date,S),d=S1Mbds(Date,S),e=S1Wi(Date,S),c=S1vic(Date,S);
   i=j+d+e+c;
   System.out.println(i);
   return i;
   }
   
private int Salle2m(String Date,String S)
   {int i;
   int j= S2Mecom(Date,S),d=S2Mbds(Date,S),e=S2wi(Date,S),c=S2vic(Date,S);
   i=j+d+e+c;
   System.out.println(i);
   return i;
   }
    private String S2L1(String date,String S)
   {String i="";
  
     try {
                pst = connection.prepareStatement("SELECT salle_g1 from lfig2 where date='"+date+"' and horaire ='"+S+"' ");
                 rs = pst.executeQuery();
                int count =0;
                 while(rs.next())
                {count = count+1;
                 if(count == 1)
                 {   
                i=rs.getString(1);
                  }}
                 if(i.equals(""))
                 {i="a";
                 }} catch (SQLException ex) {
                    ex.printStackTrace();
                }
   return i;
   }
   private String S2L2(String date,String S)
   {String i="";
  
     try {
                pst = connection.prepareStatement("SELECT salle_g2 from lfig2 where date='"+date+"' and horaire ='"+S+"' ");
                 rs = pst.executeQuery();
                 int count =0;
                 while(rs.next())
                {count = count+1;
                 if(count == 1)
                 {   
                i=rs.getString(1);
                  }}
                 if(i.equals(""))
                 {i="b";
                 }} catch (SQLException ex) {
                    ex.printStackTrace();
                }
   return i;
   }
   private String S3L1(String date,String S)
   {String i="";
  
     try {
                pst = connection.prepareStatement("SELECT salle_g1 from lfig3 where date='"+date+"' and horaire ='"+S+"' ");
                 rs = pst.executeQuery();
                 int count =0;
                 while(rs.next())
                {count = count+1;
                 if(count == 1)
                 {   
                i=rs.getString(1);
                  }}
                 if(i.equals(""))
                 {     
                 i="a";
                 }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
   return i;
   }private String S3L2(String date,String S)
   {String i="";
  
   try {
                pst = connection.prepareStatement("SELECT salle_g2 from lfig3 where date='"+date+"' and horaire ='"+S+"' ");
                 rs = pst.executeQuery();
                 int count =0;
                 while(rs.next())
                {count = count+1;
                 if(count == 1)
                 {   
                i=rs.getString(1);}}
                 if(i.equals(""))
                 {       
                 i="b";
                 }} catch (SQLException ex) {
                    ex.printStackTrace();
                }
   return i;
   }
   private String S2T1(String date,String S)
   {String i="";
     
   try {
                pst = connection.prepareStatement("SELECT salle_g1_tsi from tsi2 where date_tsi='"+date+"' and horaire_tsi ='"+S+"' ");
                 rs = pst.executeQuery();
                int count =0;
                 while(rs.next())
                {count = count+1;
                 if(count == 1)
                 {   
                i=rs.getString(1);
                  }}
                 if(i.equals(""))
                 {i="c";
                 }
   } catch (SQLException ex) {
                    ex.printStackTrace();
                }
   System.out.println(i);
   return i;
   }
   private String S2T2(String date,String S)
   {String z="";
   try {
                pst = connection.prepareStatement("SELECT salle_g2_tsi from tsi2 where date_tsi='"+date+"' and horaire_tsi ='"+S+"' ");
                 rs = pst.executeQuery();
                 int count =0;
                 while(rs.next())
                {count = count+1;
                 if(count == 1)
                 {   
                z=rs.getString(1);
                  }}
                 if(z.equals(""))
                 {z="d";
                 }
   } catch (SQLException ex) {
                    ex.printStackTrace();
                 }
 System.out.println(z);             
   return z;
   }
   private String S3T1(String date,String S)
   {String i="";
   
     try {
                pst = connection.prepareStatement("SELECT salle_g1_tsi from tsi3 where date_tsi='"+date+"' and horaire_tsi ='"+S+"' ");
                 rs = pst.executeQuery();
                 int count =0;
                 while(rs.next())
                {count = count+1;
                 if(count == 1)
                 {   
                i=rs.getString(1);
                  }}
                 if(i.equals(""))
                 {     
                 i="c";
                 }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
   return i;
   }private String S3T2(String date,String S)
   {String i="";
   
   try {
                pst = connection.prepareStatement("SELECT salle_g2_tsi  from tsi3 where date_tsi='"+date+"' and horaire_tsi ='"+S+"' ");
                 rs = pst.executeQuery();
                 int count =0;
                 while(rs.next())
                {count = count+1;
                 if(count == 1)
                 {   
                i=rs.getString(1);}}
                 if(i.equals(""))
                 {       
                 i="d";
                 }} catch (SQLException ex) {
                    ex.printStackTrace();
                }
   return i;
   }private String S2E1(String date,String S)
   {String i="";
  
     try {
                pst = connection.prepareStatement("SELECT salle_g1_ecom from ecom2 where date_ecom='"+date+"' and horaire_ecom ='"+S+"' ");
                 rs = pst.executeQuery();
                int count =0;
                 while(rs.next())
                {count = count+1;
                 if(count == 1)
                 {   
                i=rs.getString(1);
                  }}
                 if(i.equals(""))
                 {i="e";
                 }} catch (SQLException ex) {
                    ex.printStackTrace();
                }
   return i;
   }
   private String S2E2(String date,String S)
   {String i="";
  
     try {
                pst = connection.prepareStatement("SELECT salle_g2_ecom from ecom2 where date_ecom='"+date+"' and horaire_ecom ='"+S+"' ");
                 rs = pst.executeQuery();
                 int count =0;
                 while(rs.next())
                {count = count+1;
                 if(count == 1)
                 {   
                i=rs.getString(1);
                  }}
                 if(i.equals(""))
                 {i="f";
                 }} catch (SQLException ex) {
                    ex.printStackTrace();
                }
   return i;
   }
   private String S3E1(String date,String S)
   {String i="";

     try {
                pst = connection.prepareStatement("SELECT salle_g1_ecom from ecom3 where date_ecom='"+date+"' and horaire_ecom ='"+S+"' ");
                 rs = pst.executeQuery();
                 int count =0;
                 while(rs.next())
                {count = count+1;
                 if(count == 1)
                 {   
                i=rs.getString(1);
                  }}
                 if(i.equals(""))
                 {     
                 i="e";
                 }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
   return i;
   }private String S3E2(String date,String S)
   {String i="";

     try {
                pst = connection.prepareStatement("SELECT salle_g2_ecom from ecom3 where date_ecom='"+date+"' and horaire_ecom ='"+S+"' ");
                 rs = pst.executeQuery();
                 int count =0;
                 while(rs.next())
                {count = count+1;
                 if(count == 1)
                 {   
                i=rs.getString(1);}}
                 if(i.equals(""))
                 {       
                 i="f";
                 }} catch (SQLException ex) {
                    ex.printStackTrace();
                }
   return i;
   }
   private int Salle2eme(String Date,String S)
   {int i;
   int j= nb(Date,S),d=nb2(Date,S),e=nb3(Date,S);
   i=j+d+e;
   System.out.println("les salle sont :"+i);
   return i;
   }
   private int nb(String Date,String S)
   {int i;
   String a=S2L1(Date,S),b=S2L2(Date,S);
   if(!a.equals("a")&&!b.equals("b")){ 
   if(a.equals(b))
    { i=1;
    } else
       {i=2;}
    
   }else i=0;
   System.out.println(i);
   return i;
   }
   private int nb2(String Date,String S)
   {int i;
  String c=S2E1(Date,S),d=S2E2(Date,S);
   if(!c.equals("e")&&!d.equals("f")){ 
   if(c.equals(d))
    { i=1;
    } else
       {i=2;}
    
   }else i=0;
   System.out.println(i);
   return i;
   }
   private int nb3(String Date,String S)
   {int i;
   String e=S2T1(Date,S),f=S2T2(Date,S);
   if(!e.equals("c")&&!f.equals("d"))
   { 
   if(e.equals(f))
    { i=1;
    } else
       {i=2;}
    
   }
   else i=0;
   System.out.println(i);
   return i;
   }
    private int nb3l(String Date,String S)
   {int i;
   String a=S3L1(Date,S),b=S3L2(Date,S);
   if(!a.equals("a")&&!b.equals("b")){ 
   if(a.equals(b))
    { i=1;
    } else
       {i=2;}
    
   }else i=0;
   System.out.println(i);
   return i;
   }
   private int nb31(String Date,String S)
   {int i;
  String c=S3E1(Date,S),d=S3E2(Date,S);
   if(!c.equals("e")&&!d.equals("f")){ 
   if(c.equals(d))
    { i=1;
    } else
       {i=2;}
    
   }else i=0;
   System.out.println(i);
   return i;
   }
   private int nb32(String Date,String S)
   {int i;
   String e=S3T1(Date,S),f=S3T2(Date,S);
   if(!e.equals("c")&&!f.equals("d"))
   { 
   if(e.equals(f))
    { i=1;
    } else
       {i=2;}
    
   }
   else i=0;
   System.out.println(i);
   return i;
   }
   private int Salle3eme(String Date,String S)
   {int i;
   int j= nb3l(Date,S),d=nb31(Date,S),e=nb32(Date,S);
   i=j+d+e;
   System.out.println(i);
   return i;
   }
   
 private void PlanningSeance2()
   {  
       String S = Jour15();
       String[] G =S.split(" ");
       int i=0,j=1,g,a=1,l=1,c=1,z=1,q=1,h=1;
       while(i<=G.length)
         {
             if(i==0)
            {
                System.out.println(G[i]);
                String hor=horaire1S1();
                String []A=hor.split(" ");
      
                int cop=1;
                while(cop<A.length)
                {
                    if(A[cop].equals("S1"))
                    {   System.out.println(A[cop]);
                        int K=nombensg("j1s1");  
                        int nbsalle1=nombsalle(G[i+1],A[cop]);
                        int nbsalle2=nombsalle1(G[i+1],A[cop]);
                        int nbsalle3=Salle2eme(G[i+1],A[cop]);
                        int nbsalle4=Salle3eme(G[i+1],A[cop]);
                        int nbsalle5=Salle1M(G[i+1],A[cop]);
                        int nbsalle6=Salle2m(G[i+1],A[cop]);
                        String dispens =ensgdisp(G[i]);
                        String []lis=dispens.split("  ");
                        int nombre=0,n=0;
                        int s=K+nombre;
                        int nb=(nbsalle1+nbsalle2+nbsalle3+nbsalle4+nbsalle5+nbsalle6)*2;
                        while(nb!=0&&s<nb)
                        {
                            
                                System.out.println("les salle réservee sont: "+nb);
                                System.out.println("les enseignatns y3esho"+s);
                                System.out.println(lis[n]);
                                int nbsur=nbSurvillance(lis[n]);
                                System.out.println(n);
                                String nom =GradeEns(lis[n]);
                                int max=maxsurgrade(nom);
                                if((!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences")))
                                {
                                    System.out.println("d5el lhne");
                                        if(nbsur<=max)
                                        {
                                            
                                                try{System.out.println("9a3ed yt3ada");
                                                String update = "UPDATE planningsc SET j1s1='1' where nomcomplt  like '%"+lis[n]+"%' ";
                                                pst = connection.prepareStatement(update);
                                                pst.execute();
                                                } catch (SQLException e)
                                                {
                                                    e.printStackTrace();

                                                }
                                                s++;
                                        }         
                                }
                        n++;
                        }
      }else if (A[cop].equals("S2"))
      {   System.out.println("hana taw f 2"+ A[cop]);
          int K=nombensg("j1s2");  
          int nbsalle1=nombsalle(G[i+1],A[cop]);
          int nbsalle2=nombsalle1(G[i+1],A[cop]);
          int nbsalle3=Salle2eme(G[i+1],A[cop]);
          int nbsalle4=Salle3eme(G[i+1],A[cop]);
          int nbsalle5=Salle1M(G[i+1],A[cop]);
          int nbsalle6=Salle2m(G[i+1],A[cop]);
          String dispens =ensgdisp(G[i]);
          String []lis=dispens.split("  ");
          int nombre=0,n=0;
          int s1=K+nombre;
          int nb=(nbsalle1+nbsalle2+nbsalle3+nbsalle4+nbsalle5+nbsalle6)*2;
          while(nb!=0&&s1<=nb)
            {
                System.out.println("les salle réservee sont: "+nb);
                System.out.println("les enseignatns y3esho"+s1);
                System.out.println(lis[n]);
                int nbsur=nbSurvillance(lis[n]);
                System.out.println(n);
                String nom =GradeEns(lis[n]);
                int max=maxsurgrade(nom);
                if((!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences")))
                    { System.out.println("d5el lhne");
                        if(nbsur<=max)
                            {
                                try
                                {
                                    System.out.println("9a3ed yt3ada");
                                    String update = "UPDATE planningsc SET `j1s2`='1' where nomcomplt  like '%"+lis[n]+"%' ";
                                    pst = connection.prepareStatement(update);
                                    pst.execute();
                               } catch (SQLException e)
                               {
                                   e.printStackTrace();

                               }
                               s1++;
                            }         
                    }
       n++;
            }
      }
      cop++;}
      
            }
       
            else 
            if(i==2)
            {
                
                    System.out.println(G[i]);
                    String hor=horaire1S1();
                    String []A=hor.split(" ");
      
                    int cop=1;
                    while(cop<A.length)
                    {
                        if(A[cop].equals("S1"))
                        {
                            System.out.println("hana taw f 3"+ A[cop]);
                            int K=nombensg("j2s1");  
                            int nbsalle1=nombsalle(G[i+1],A[cop]);
                            int nbsalle2=nombsalle1(G[i+1],A[cop]);
                            int nbsalle3=Salle2eme(G[i+1],A[cop]);
                            int nbsalle4=Salle3eme(G[i+1],A[cop]);
                            int nbsalle5=Salle1M(G[i+1],A[cop]);
                            int nbsalle6=Salle2m(G[i+1],A[cop]);
                            String dispens =ensgdisp(G[i]);
                            String []lis=dispens.split("  ");
                            int nombre=0,n=0;
                            int s=K+nombre;
                            int nb=(nbsalle1+nbsalle2+nbsalle3+nbsalle4+nbsalle5+nbsalle6)*2;
                            System.out.println("les salle est"+nb);
                            System.out.println("les ensginanats"+s);
                            System.out.println("les ensginanats"+K);
                            while(nb!=0&&s<nb)
                              {
                                  
                                    System.out.println("les salle réservee sont: "+nb);
                                    System.out.println("les enseignatns y3esho"+s);
                                    System.out.println(lis[n]);
                                    int nbsur=nbSurvillance(lis[n]);
                                    System.out.println(n);
                                    String nom =GradeEns(lis[n]);
                                    int max=maxsurgrade(nom);
                                    if((!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences")))
                                    {
                                        System.out.println("d5el lhne");
                                        if(nbsur<=max)
                                        {
                                                try{System.out.println("9a3ed yt3ada");
                                                String update = "UPDATE planningsc SET j2s1='1'where nomcomplt  like '%"+lis[n]+"%' ";
                                                pst = connection.prepareStatement(update);
                                                pst.execute();
                                                } catch (SQLException e)
                                                {
                                                    e.printStackTrace();

                                                }
                                                s++;
                                        }         
                                    }
                                n++;
                              }
                        }else
                            if (A[cop].equals("S2"))
                            {
                                System.out.println("hana taw f 4"+ A[cop]);
                                int K=nombensg("j2s2");  
                                int nbsalle1=nombsalle(G[i+1],A[cop]);
                                int nbsalle2=nombsalle1(G[i+1],A[cop]);
                                int nbsalle3=Salle2eme(G[i+1],A[cop]);
                                int nbsalle4=Salle3eme(G[i+1],A[cop]);
                                int nbsalle5=Salle1M(G[i+1],A[cop]);
                                int nbsalle6=Salle2m(G[i+1],A[cop]);
                                String dispens =ensgdisp(G[i]);
                                String []lis=dispens.split("  ");
                                int nombre=0,n=0;
                                int s1=K+nombre;
                                int nb=(nbsalle1+nbsalle2+nbsalle3+nbsalle4+nbsalle5+nbsalle6)*2;
                                while(nb!=0&&s1<=nb)
                                  {
                                        System.out.println("les salle réservee sont: "+nb);
                                        System.out.println("les enseignatns y3esho"+s1);
                                        System.out.println(lis[n]);
                                        int nbsur=nbSurvillance(lis[n]);
                                        System.out.println(n);
                                        String nom =GradeEns(lis[n]);
                                        int max=maxsurgrade(nom);
                                        if((!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences")))
                                            { System.out.println("d5el lhne");
                                                if(nbsur<=max)
                                                    {
                                                        try
                                                        {
                                                            System.out.println("9a3ed yt3ada");
                                                            String update = "UPDATE planningsc SET`j2s2`='1' where nomcomplt  like '%"+lis[n]+"%' ";
                                                            pst = connection.prepareStatement(update);
                                                            pst.execute();
                                                       } catch (SQLException e)
                                                       {
                                                           e.printStackTrace();

                                                       }
                                                       s1++;
                                                    }         
                                            }
                               n++;
                                    }
                            }
                              cop++;
                    }

             }
    
             else
                if(i==4)
                    {
                        System.out.println(G[i]);
                        String hor=horaire1S1();
                        String []A=hor.split(" ");
      
                int cop=1;
                while(cop<A.length)
                {
                    if(A[cop].equals("S1"))
                    {   System.out.println("hana taw f loul"+ A[cop]);
                        int K=nombensg("j3s1");  
                        int nbsalle1=nombsalle(G[i+1],A[cop]);
                        int nbsalle2=nombsalle1(G[i+1],A[cop]);
                        int nbsalle3=Salle2eme(G[i+1],A[cop]);
                        int nbsalle4=Salle3eme(G[i+1],A[cop]);
                        int nbsalle5=Salle1M(G[i+1],A[cop]);
                        int nbsalle6=Salle2m(G[i+1],A[cop]);
                        String dispens =ensgdisp(G[i]);
                        System.out.println(dispens);
                        String []lis=dispens.split("  ");
                        int nombre=0,n=0;
                        int s=K+nombre;
                        int nb=(nbsalle1+nbsalle2+nbsalle3+nbsalle4+nbsalle5+nbsalle6)*2;
                        while(nb!=0&&s<nb)
                        {
                            
                                System.out.println("les salle réservee sont: "+nb);
                                System.out.println("les enseignatns y3esho"+s);
                                System.out.println("ggggg"+lis[0]);
                                System.out.println(lis[n]);
                                int nbsur=nbSurvillance(lis[n]);
                                System.out.println(n);
                                String nom =GradeEns(lis[n]);
                                int max=maxsurgrade(nom);
                                if((!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences")))
                                {
                                    System.out.println("d5el lhne");
                                        if(nbsur<=max)
                                        {
                                            
                                                try{System.out.println("9a3ed yt3ada");
                                                String update = "UPDATE planningsc SET j3s1='1' where nomcomplt  like '%"+lis[n]+"%' ";
                                                pst = connection.prepareStatement(update);
                                                pst.execute();
                                                } catch (SQLException e)
                                                {
                                                    e.printStackTrace();

                                                }
                                                s++;
                                        }         
                                }
                        n++;
                        }} else
                            if (A[cop].equals("S2"))
                            {
                                System.out.println("hana taw f 4"+ A[cop]);
                                int K=nombensg("j3s2");  
                                int nbsalle1=nombsalle(G[i+1],A[cop]);
                                int nbsalle2=nombsalle1(G[i+1],A[cop]);
                                int nbsalle3=Salle2eme(G[i+1],A[cop]);
                                int nbsalle4=Salle3eme(G[i+1],A[cop]);
                                int nbsalle5=Salle1M(G[i+1],A[cop]);
                                int nbsalle6=Salle2m(G[i+1],A[cop]);
                                String dispens =ensgdisp(G[i]);
                                String []lis=dispens.split("  ");
                                int nombre=0,n=0;
                                int s1=K+nombre;
                                int nb=(nbsalle1+nbsalle2+nbsalle3+nbsalle4+nbsalle5+nbsalle6)*2;
                                while(nb!=0&&s1<=nb)
                                  {
                                        System.out.println("les salle réservee sont: "+nb);
                                        System.out.println("les enseignatns y3esho"+s1);
                                        System.out.println(lis[n]);
                                        int nbsur=nbSurvillance(lis[n]);
                                        System.out.println(n);
                                        String nom =GradeEns(lis[n]);
                                        int max=maxsurgrade(nom);
                                        if((!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences")))
                                            { System.out.println("d5el lhne");
                                                if(nbsur<=max)
                                                    {
                                                        try
                                                        {
                                                            System.out.println("9a3ed yt3ada");
                                                            String update = "UPDATE planningsc SET`j3s2`='1' where nomcomplt  like '%"+lis[n]+"%' ";
                                                            pst = connection.prepareStatement(update);
                                                            pst.execute();
                                                       } catch (SQLException e)
                                                       {
                                                           e.printStackTrace();

                                                       }
                                                       s1++;
                                                    }         
                                            }
                               n++;
                                    }
                            }
                              cop++;
                    }

             }
             else
            if(i==6)
                {   System.out.println(G[i]);
                    String hor=horaire1S1();
                    String []A=hor.split(" ");
      
                    int cop=1;
                    while(cop<A.length)
                    {
                        if(A[cop].equals("S1"))
                        {
                            System.out.println("hana taw f 3"+ A[cop]);
                            int K=nombensg("j4s1");  
                            int nbsalle1=nombsalle(G[i+1],A[cop]);
                            int nbsalle2=nombsalle1(G[i+1],A[cop]);
                            int nbsalle3=Salle2eme(G[i+1],A[cop]);
                            int nbsalle4=Salle3eme(G[i+1],A[cop]);
                            int nbsalle5=Salle1M(G[i+1],A[cop]);
                            int nbsalle6=Salle2m(G[i+1],A[cop]);
                            String dispens =ensgdisp(G[i]);
                            String [] lis=dispens.split("  ");
                            int nombre=0,n1=0;
                            int s=K+nombre;
                            int nb=(nbsalle1+nbsalle2+nbsalle3+nbsalle4+nbsalle5+nbsalle6)*2;
                            System.out.println("les salle est"+nb);
                            System.out.println("les ensginanats"+s);
                            System.out.println("les ensginanats"+K);
                            while(nb!=0&&s<nb)
                              {     System.out.println("les salle réservee sont: "+nb);
                                    System.out.println("les enseignatns y3esho"+s);
                                    System.out.println(lis[n1]);
                                    int nbsur=nbSurvillance(lis[n1]);
                                    System.out.println(n1);
                                    String nom =GradeEns(lis[n1]);
                                    int max=maxsurgrade(nom);
                                    if((!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences")))
                                    {
                                        System.out.println("d5el lhne");
                                        if(nbsur<=max)
                                        {
                                                try{System.out.println("9a3ed yt3ada");
                                                String update = "UPDATE planningsc SET j4s1='1'where nomcomplt  like '%"+lis[n1]+"%' ";
                                                pst = connection.prepareStatement(update);
                                                pst.execute();
                                                } catch (SQLException e)
                                                {
                                                    e.printStackTrace();

                                                }
                                                s++;
                                        }         
                                    }
                                n1++;
                              }
                        }else
                            if (A[cop].equals("S2"))
                            {
                                System.out.println("hana taw f 4"+ A[cop]);
                                int K=nombensg("j4s2");  
                                int nbsalle1=nombsalle(G[i+1],A[cop]);
                                int nbsalle2=nombsalle1(G[i+1],A[cop]);
                                int nbsalle3=Salle2eme(G[i+1],A[cop]);
                                int nbsalle4=Salle3eme(G[i+1],A[cop]);
                                int nbsalle5=Salle1M(G[i+1],A[cop]);
                                int nbsalle6=Salle2m(G[i+1],A[cop]);
                                String dispens =ensgdisp(G[i]);
                                String []lis=dispens.split("  ");
                                int nombre=0,n=0;
                                int s1=K+nombre;
                                int nb=(nbsalle1+nbsalle2+nbsalle3+nbsalle4+nbsalle5+nbsalle6)*2;
                                while(nb!=0&&s1<=nb)
                                  {
                                        System.out.println("les salle réservee sont: "+nb);
                                        System.out.println("les enseignatns y3esho"+s1);
                                        System.out.println(lis[n]);
                                        int nbsur=nbSurvillance(lis[n]);
                                        System.out.println(n);
                                        String nom =GradeEns(lis[n]);
                                        int max=maxsurgrade(nom);
                                        if((!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences")))
                                            { System.out.println("d5el lhne");
                                                if(nbsur<=max)
                                                    {
                                                        try
                                                        {
                                                            System.out.println("9a3ed yt3ada");
                                                            String update = "UPDATE planningsc SET`j4s2`='1' where nomcomplt  like '%"+lis[n]+"%' ";
                                                            pst = connection.prepareStatement(update);
                                                            pst.execute();
                                                       } catch (SQLException e)
                                                       {
                                                           e.printStackTrace();

                                                       }
                                                       s1++;
                                                    }         
                                            }
                               n++;
                                    }
                            }
                              cop++;
                    }

             }
    
      
        else
                if(i==8)
                    {System.out.println(G[i]);
                    String hor=horaire1S1();
                    String []A=hor.split(" ");
      
                    int cop=1;
                    while(cop<A.length)
                    {
                        if(A[cop].equals("S1"))
                        {
                            System.out.println("hana taw f 3"+ A[cop]);
                            int K=nombensg("j5s1");  
                            int nbsalle1=nombsalle(G[i+1],A[cop]);
                            int nbsalle2=nombsalle1(G[i+1],A[cop]);
                            int nbsalle3=Salle2eme(G[i+1],A[cop]);
                            int nbsalle4=Salle3eme(G[i+1],A[cop]);
                            int nbsalle5=Salle1M(G[i+1],A[cop]);
                            int nbsalle6=Salle2m(G[i+1],A[cop]);
                            String dispens =ensgdisp(G[i]);
                            String []lis=dispens.split("  ");
                            int nombre=0,n=0;
                            int s=K+nombre;
                            int nb=(nbsalle1+nbsalle2+nbsalle3+nbsalle4+nbsalle5+nbsalle6)*2;
                            System.out.println("les salle est"+nb);
                            System.out.println("les ensginanats"+s);
                            System.out.println("les ensginanats"+K);
                            while(nb!=0&&s<nb)
                              {
                                  
                                    System.out.println("les salle réservee sont: "+nb);
                                    System.out.println("les enseignatns y3esho"+s);
                                    System.out.println(lis[n]);
                                    int nbsur=nbSurvillance(lis[n]);
                                    System.out.println(n);
                                    String nom =GradeEns(lis[n]);
                                    int max=maxsurgrade(nom);
                                    if((!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences")))
                                    {
                                        System.out.println("d5el lhne");
                                        if(nbsur<=max)
                                        {
                                                try{System.out.println("9a3ed yt3ada");
                                                String update = "UPDATE planningsc SET j5s1='1'where nomcomplt  like '%"+lis[n]+"%' ";
                                                pst = connection.prepareStatement(update);
                                                pst.execute();
                                                } catch (SQLException e)
                                                {
                                                    e.printStackTrace();

                                                }
                                                s++;
                                        }         
                                    }
                                n++;
                              }
                        }else
                            if (A[cop].equals("S2"))
                            {
                                System.out.println("hana taw f 4"+ A[cop]);
                                int K=nombensg("j5s2");  
                                int nbsalle1=nombsalle(G[i+1],A[cop]);
                                int nbsalle2=nombsalle1(G[i+1],A[cop]);
                                int nbsalle3=Salle2eme(G[i+1],A[cop]);
                                int nbsalle4=Salle3eme(G[i+1],A[cop]);
                                int nbsalle5=Salle1M(G[i+1],A[cop]);
                                int nbsalle6=Salle2m(G[i+1],A[cop]);
                                String dispens =ensgdisp(G[i]);
                                String []lis=dispens.split("  ");
                                int nombre=0,n=0;
                                int s1=K+nombre;
                                int nb=(nbsalle1+nbsalle2+nbsalle3+nbsalle4+nbsalle5+nbsalle6)*2;
                                while(nb!=0&&s1<=nb)
                                  {
                                        System.out.println("les salle réservee sont: "+nb);
                                        System.out.println("les enseignatns y3esho"+s1);
                                        System.out.println(lis[n]);
                                        int nbsur=nbSurvillance(lis[n]);
                                        System.out.println(n);
                                        String nom =GradeEns(lis[n]);
                                        int max=maxsurgrade(nom);
                                        if((!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences")))
                                            { System.out.println("d5el lhne");
                                                if(nbsur<=max)
                                                    {
                                                        try
                                                        {
                                                            System.out.println("9a3ed yt3ada");
                                                            String update = "UPDATE planningsc SET`j5s2`='1' where nomcomplt  like '%"+lis[n]+"%' ";
                                                            pst = connection.prepareStatement(update);
                                                            pst.execute();
                                                       } catch (SQLException e)
                                                       {
                                                           e.printStackTrace();

                                                       }
                                                       s1++;
                                                    }         
                                            }
                               n++;
                                    }
                            }
                              cop++;
                    }

                    }
    
        else 
            if(i==10)
                {                System.out.println(G[i]);
                    String hor=horaire1S1();
                    String []A=hor.split(" ");
      
                    int cop=1;
                    while(cop<A.length)
                    {
                        if(A[cop].equals("S1"))
                        {
                            System.out.println("hana taw f 3"+ A[cop]);
                            int K=nombensg("j6s1");  
                            int nbsalle1=nombsalle(G[i+1],A[cop]);
                            int nbsalle2=nombsalle1(G[i+1],A[cop]);
                            int nbsalle3=Salle2eme(G[i+1],A[cop]);
                            int nbsalle4=Salle3eme(G[i+1],A[cop]);
                            int nbsalle5=Salle1M(G[i+1],A[cop]);
                            int nbsalle6=Salle2m(G[i+1],A[cop]);
                            String dispens =ensgdisp(G[i]);
                            String []lis=dispens.split("  ");
                            int nombre=0,n=0;
                            int s=K+nombre;
                            int nb=(nbsalle1+nbsalle2+nbsalle3+nbsalle4+nbsalle5+nbsalle6)*2;
                            System.out.println("les salle est"+nb);
                            System.out.println("les ensginanats"+s);
                            System.out.println("les ensginanats"+K);
                            while(nb!=0&&s<nb)
                              {
                                  
                                    System.out.println("les salle réservee sont: "+nb);
                                    System.out.println("les enseignatns y3esho"+s);
                                    System.out.println(lis[n]);
                                    int nbsur=nbSurvillance(lis[n]);
                                    System.out.println(n);
                                    String nom =GradeEns(lis[n]);
                                    int max=maxsurgrade(nom);
                                    if((!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences")))
                                    {
                                        System.out.println("d5el lhne");
                                        if(nbsur<=max)
                                        {
                                                try{System.out.println("9a3ed yt3ada");
                                                String update = "UPDATE planningsc SET j6s1='1'where nomcomplt  like '%"+lis[n]+"%' ";
                                                pst = connection.prepareStatement(update);
                                                pst.execute();
                                                } catch (SQLException e)
                                                {
                                                    e.printStackTrace();

                                                }
                                                s++;
                                        }         
                                    }
                                n++;
                              }
                        }else
                            if (A[cop].equals("S2"))
                            {
                                System.out.println("hana taw f 4"+ A[cop]);
                                int K=nombensg("j6s2");  
                                int nbsalle1=nombsalle(G[i+1],A[cop]);
                                int nbsalle2=nombsalle1(G[i+1],A[cop]);
                                int nbsalle3=Salle2eme(G[i+1],A[cop]);
                                int nbsalle4=Salle3eme(G[i+1],A[cop]);
                                int nbsalle5=Salle1M(G[i+1],A[cop]);
                                int nbsalle6=Salle2m(G[i+1],A[cop]);
                                String dispens =ensgdisp(G[i]);
                                String []lis=dispens.split("  ");
                                int nombre=0,n=0;
                                int s1=K+nombre;
                                int nb=(nbsalle1+nbsalle2+nbsalle3+nbsalle4+nbsalle5+nbsalle6)*2;
                                while(nb!=0&&s1<=nb)
                                  {
                                        System.out.println("les salle réservee sont: "+nb);
                                        System.out.println("les enseignatns y3esho"+s1);
                                        System.out.println(lis[n]);
                                        int nbsur=nbSurvillance(lis[n]);
                                        System.out.println(n);
                                        String nom =GradeEns(lis[n]);
                                        int max=maxsurgrade(nom);
                                        if((!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences")))
                                            { System.out.println("d5el lhne");
                                                if(nbsur<=max)
                                                    {
                                                        try
                                                        {
                                                            System.out.println("9a3ed yt3ada");
                                                            String update = "UPDATE planningsc SET`j6s2`='1' where nomcomplt  like '%"+lis[n]+"%' ";
                                                            pst = connection.prepareStatement(update);
                                                            pst.execute();
                                                       } catch (SQLException e)
                                                       {
                                                           e.printStackTrace();

                                                       }
                                                       s1++;
                                                    }         
                                            }
                               n++;
                                    }
                            }
                              cop++;
                    }

             }
    
            else
                if(i==12)
                    {System.out.println(G[i]);
                    String hor=horaire1S1();
                    String []A=hor.split(" ");
      
                    int cop=1;
                    while(cop<A.length)
                    {
                        if(A[cop].equals("S1"))
                        {
                            System.out.println("hana taw f 3"+ A[cop]);
                            int K=nombensg("j7s1");  
                            int nbsalle1=nombsalle(G[i+1],A[cop]);
                            int nbsalle2=nombsalle1(G[i+1],A[cop]);
                            int nbsalle3=Salle2eme(G[i+1],A[cop]);
                            int nbsalle4=Salle3eme(G[i+1],A[cop]);
                            int nbsalle5=Salle1M(G[i+1],A[cop]);
                            int nbsalle6=Salle2m(G[i+1],A[cop]);
                            String dispens =ensgdisp(G[i]);
                            String []lis=dispens.split("  ");
                            int nombre=0,n=0;
                            int s=K+nombre;
                            int nb=(nbsalle1+nbsalle2+nbsalle3+nbsalle4+nbsalle5+nbsalle6)*2;
                            System.out.println("les salle est"+nb);
                            System.out.println("les ensginanats"+s);
                            System.out.println("les ensginanats"+K);
                            while(nb!=0&&s<nb)
                              {
                                  
                                    System.out.println("les salle réservee sont: "+nb);
                                    System.out.println("les enseignatns y3esho"+s);
                                    System.out.println(lis[n]);
                                    int nbsur=nbSurvillance(lis[n]);
                                    System.out.println(n);
                                    String nom =GradeEns(lis[n]);
                                    int max=maxsurgrade(nom);
                                    if((!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences")))
                                    {
                                        System.out.println("d5el lhne");
                                        if(nbsur<=max)
                                        {
                                                try{System.out.println("9a3ed yt3ada");
                                                String update = "UPDATE planningsc SET j7s1='1'where nomcomplt  like '%"+lis[n]+"%' ";
                                                pst = connection.prepareStatement(update);
                                                pst.execute();
                                                } catch (SQLException e)
                                                {
                                                    e.printStackTrace();

                                                }
                                                s++;
                                        }         
                                    }
                                n++;
                              }
                        }else
                            if (A[cop].equals("S2"))
                            {
                                System.out.println("hana taw f 4"+ A[cop]);
                                int K=nombensg("j7s2");  
                                int nbsalle1=nombsalle(G[i+1],A[cop]);
                                int nbsalle2=nombsalle1(G[i+1],A[cop]);
                                int nbsalle3=Salle2eme(G[i+1],A[cop]);
                                int nbsalle4=Salle3eme(G[i+1],A[cop]);
                                int nbsalle5=Salle1M(G[i+1],A[cop]);
                                int nbsalle6=Salle2m(G[i+1],A[cop]);
                                String dispens =ensgdisp(G[i]);
                                String []lis=dispens.split("  ");
                                int nombre=0,n=0;
                                int s1=K+nombre;
                                int nb=(nbsalle1+nbsalle2+nbsalle3+nbsalle4+nbsalle5+nbsalle6)*2;
                                while(nb!=0&&s1<=nb)
                                  {
                                        System.out.println("les salle réservee sont: "+nb);
                                        System.out.println("les enseignatns y3esho"+s1);
                                        System.out.println(lis[n]);
                                        int nbsur=nbSurvillance(lis[n]);
                                        System.out.println(n);
                                        String nom =GradeEns(lis[n]);
                                        int max=maxsurgrade(nom);
                                        if((!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences")))
                                            { System.out.println("d5el lhne");
                                                if(nbsur<=max)
                                                    {
                                                        try
                                                        {
                                                            System.out.println("9a3ed yt3ada");
                                                            String update = "UPDATE planningsc SET`j7s2`='1' where nomcomplt  like '%"+lis[n]+"%' ";
                                                            pst = connection.prepareStatement(update);
                                                            pst.execute();
                                                       } catch (SQLException e)
                                                       {
                                                           e.printStackTrace();

                                                       }
                                                       s1++;
                                                    }         
                                            }
                               n++;
                                    }
                            }
                              cop++;
                    }

             }
    
        else 
                    if(i==14)
                        {System.out.println(G[i]);
                         String hor=horaire1S1();
                         String []A=hor.split(" ");
      
                    int cop=1;
                    while(cop<A.length)
                    {
                        if(A[cop].equals("S1"))
                        {
                            System.out.println("hana taw f 3"+ A[cop]);
                            int K=nombensg("j8s1");  
                            int nbsalle1=nombsalle(G[i+1],A[cop]);
                            int nbsalle2=nombsalle1(G[i+1],A[cop]);
                            int nbsalle3=Salle2eme(G[i+1],A[cop]);
                            int nbsalle4=Salle3eme(G[i+1],A[cop]);
                            int nbsalle5=Salle1M(G[i+1],A[cop]);
                            int nbsalle6=Salle2m(G[i+1],A[cop]);
                            String dispens =ensgdisp(G[i]);
                            String []lis=dispens.split("  ");
                            int nombre=0,n=0;
                            int s=K+nombre;
                            int nb=(nbsalle1+nbsalle2+nbsalle3+nbsalle4+nbsalle5+nbsalle6)*2;
                            System.out.println("les salle est"+nb);
                            System.out.println("les ensginanats"+s);
                            System.out.println("les ensginanats"+K);
                            while(nb!=0&&s<nb)
                              {
                                  
                                    System.out.println("les salle réservee sont: "+nb);
                                    System.out.println("les enseignatns y3esho"+s);
                                    System.out.println(lis[n]);
                                    int nbsur=nbSurvillance(lis[n]);
                                    System.out.println(n);
                                    String nom =GradeEns(lis[n]);
                                    int max=maxsurgrade(nom);
                                    if((!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences")))
                                    {
                                        System.out.println("d5el lhne");
                                        if(nbsur<=max)
                                        {
                                                try{System.out.println("9a3ed yt3ada");
                                                String update = "UPDATE planningsc SET j8s1='1'where nomcomplt  like '%"+lis[n]+"%' ";
                                                pst = connection.prepareStatement(update);
                                                pst.execute();
                                                } catch (SQLException e)
                                                {
                                                    e.printStackTrace();

                                                }
                                                s++;
                                        }         
                                    }
                                n++;
                              }
                        }else
                            if (A[cop].equals("S2"))
                            {
                                System.out.println("hana taw f 4"+ A[cop]);
                                int K=nombensg("j8s2");  
                                int nbsalle1=nombsalle(G[i+1],A[cop]);
                                int nbsalle2=nombsalle1(G[i+1],A[cop]);
                                int nbsalle3=Salle2eme(G[i+1],A[cop]);
                                int nbsalle4=Salle3eme(G[i+1],A[cop]);
                                int nbsalle5=Salle1M(G[i+1],A[cop]);
                                int nbsalle6=Salle2m(G[i+1],A[cop]);
                                String dispens =ensgdisp(G[i]);
                                String []lis=dispens.split("  ");
                                int nombre=0,n=0;
                                int s1=K+nombre;
                                int nb=(nbsalle1+nbsalle2+nbsalle3+nbsalle4+nbsalle5+nbsalle6)*2;
                                while(nb!=0&&s1<=nb)
                                  {
                                        System.out.println("les salle réservee sont: "+nb);
                                        System.out.println("les enseignatns y3esho"+s1);
                                        System.out.println(lis[n]);
                                        int nbsur=nbSurvillance(lis[n]);
                                        System.out.println(n);
                                        String nom =GradeEns(lis[n]);
                                        int max=maxsurgrade(nom);
                                        if((!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences")))
                                            { System.out.println("d5el lhne");
                                                if(nbsur<=max)
                                                    {
                                                        try
                                                        {
                                                            System.out.println("9a3ed yt3ada");
                                                            String update = "UPDATE planningsc SET`j8s2`='1' where nomcomplt  like '%"+lis[n]+"%' ";
                                                            pst = connection.prepareStatement(update);
                                                            pst.execute();
                                                       } catch (SQLException e)
                                                       {
                                                           e.printStackTrace();

                                                       }
                                                       s1++;
                                                    }         
                                            }
                               n++;
                                    }
                            }
                              cop++;
                    }

             }
    
        else if(i==16)
                    {System.out.println(G[i]);
                    String hor=horaire1S1();
                    String []A=hor.split(" ");
      
                    int cop=1;
                    while(cop<A.length)
                    {
                        if(A[cop].equals("S1"))
                        {
                            System.out.println("hana taw f 3"+ A[cop]);
                            int K=nombensg("j9s1");  
                            int nbsalle1=nombsalle(G[i+1],A[cop]);
                            int nbsalle2=nombsalle1(G[i+1],A[cop]);
                            int nbsalle3=Salle2eme(G[i+1],A[cop]);
                            int nbsalle4=Salle3eme(G[i+1],A[cop]);
                            int nbsalle5=Salle1M(G[i+1],A[cop]);
                            int nbsalle6=Salle2m(G[i+1],A[cop]);
                            String dispens =ensgdisp(G[i]);
                            String []lis=dispens.split("  ");
                            int nombre=0,n=0;
                            int s=K+nombre;
                            int nb=(nbsalle1+nbsalle2+nbsalle3+nbsalle4+nbsalle5+nbsalle6)*2;
                            System.out.println("les salle est"+nb);
                            System.out.println("les ensginanats"+s);
                            System.out.println("les ensginanats"+K);
                            while(nb!=0&&s<nb)
                              {
                                  
                                    System.out.println("les salle réservee sont: "+nb);
                                    System.out.println("les enseignatns y3esho"+s);
                                    System.out.println(lis[n]);
                                    int nbsur=nbSurvillance(lis[n]);
                                    System.out.println(n);
                                    String nom =GradeEns(lis[n]);
                                    int max=maxsurgrade(nom);
                                    if((!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences")))
                                    {
                                        System.out.println("d5el lhne");
                                        if(nbsur<=max)
                                        {
                                                try{System.out.println("9a3ed yt3ada");
                                                String update = "UPDATE planningsc SET j9s1='1'where nomcomplt  like '%"+lis[n]+"%' ";
                                                pst = connection.prepareStatement(update);
                                                pst.execute();
                                                } catch (SQLException e)
                                                {
                                                    e.printStackTrace();

                                                }
                                                s++;
                                        }         
                                    }
                                n++;
                              }
                        }else
                            if (A[cop].equals("S2"))
                            {
                                System.out.println("hana taw f 4"+ A[cop]);
                                int K=nombensg("j9s2");  
                                int nbsalle1=nombsalle(G[i+1],A[cop]);
                                int nbsalle2=nombsalle1(G[i+1],A[cop]);
                                int nbsalle3=Salle2eme(G[i+1],A[cop]);
                                int nbsalle4=Salle3eme(G[i+1],A[cop]);
                                int nbsalle5=Salle1M(G[i+1],A[cop]);
                                int nbsalle6=Salle2m(G[i+1],A[cop]);
                                String dispens =ensgdisp(G[i]);
                                String []lis=dispens.split("  ");
                                int nombre=0,n=0;
                                int s1=K+nombre;
                                int nb=(nbsalle1+nbsalle2+nbsalle3+nbsalle4+nbsalle5+nbsalle6)*2;
                                while(nb!=0&&s1<=nb)
                                  {
                                        System.out.println("les salle réservee sont: "+nb);
                                        System.out.println("les enseignatns y3esho"+s1);
                                        System.out.println(lis[n]);
                                        int nbsur=nbSurvillance(lis[n]);
                                        System.out.println(n);
                                        String nom =GradeEns(lis[n]);
                                        int max=maxsurgrade(nom);
                                        if((!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences")))
                                            { System.out.println("d5el lhne");
                                                if(nbsur<=max)
                                                    {
                                                        try
                                                        {
                                                            System.out.println("9a3ed yt3ada");
                                                            String update = "UPDATE planningsc SET`j9s2`='1' where nomcomplt  like '%"+lis[n]+"%' ";
                                                            pst = connection.prepareStatement(update);
                                                            pst.execute();
                                                       } catch (SQLException e)
                                                       {
                                                           e.printStackTrace();

                                                       }
                                                       s1++;
                                                    }         
                                            }
                               n++;
                                    }
                            }
                              cop++;
                    }

             }
                else
            if(i==18)
                {   System.out.println(G[i]);
                    String hor=horaire1S1();
                    String []A=hor.split(" ");
      
                    int cop=1;
                    while(cop<A.length)
                    {
                        if(A[cop].equals("S1"))
                        {
                            System.out.println("hana taw f 3"+ A[cop]);
                            int K=nombensg("j10s1");  
                            int nbsalle1=nombsalle(G[i+1],A[cop]);
                            int nbsalle2=nombsalle1(G[i+1],A[cop]);
                            int nbsalle3=Salle2eme(G[i+1],A[cop]);
                            int nbsalle4=Salle3eme(G[i+1],A[cop]);
                            int nbsalle5=Salle1M(G[i+1],A[cop]);
                            int nbsalle6=Salle2m(G[i+1],A[cop]);
                            String dispens =ensgdisp(G[i]);
                            String []lis=dispens.split("  ");
                            int nombre=0,n=0;
                            int s=K+nombre;
                            int nb=(nbsalle1+nbsalle2+nbsalle3+nbsalle4+nbsalle5+nbsalle6)*2;
                            System.out.println("les salle est"+nb);
                            System.out.println("les ensginanats"+s);
                            System.out.println("les ensginanats"+K);
                            while(nb!=0&&s<nb)
                              {
                                  
                                    System.out.println("les salle réservee sont: "+nb);
                                    System.out.println("les enseignatns y3esho"+s);
                                    System.out.println(lis[n]);
                                    int nbsur=nbSurvillance(lis[n]);
                                    System.out.println(n);
                                    String nom =GradeEns(lis[n]);
                                    int max=maxsurgrade(nom);
                                    if((!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences")))
                                    {
                                        System.out.println("d5el lhne");
                                        if(nbsur<=max)
                                        {
                                                try{System.out.println("9a3ed yt3ada");
                                                String update = "UPDATE planningsc SET j10s1='1'where nomcomplt  like '%"+lis[n]+"%' ";
                                                pst = connection.prepareStatement(update);
                                                pst.execute();
                                                } catch (SQLException e)
                                                {
                                                    e.printStackTrace();

                                                }
                                                s++;
                                        }         
                                    }
                                n++;
                              }
                        }else
                            if (A[cop].equals("S2"))
                            {
                                System.out.println("hana taw f 4"+ A[cop]);
                                int K=nombensg("j10s2");  
                                int nbsalle1=nombsalle(G[i+1],A[cop]);
                                int nbsalle2=nombsalle1(G[i+1],A[cop]);
                                int nbsalle3=Salle2eme(G[i+1],A[cop]);
                                int nbsalle4=Salle3eme(G[i+1],A[cop]);
                                int nbsalle5=Salle1M(G[i+1],A[cop]);
                                int nbsalle6=Salle2m(G[i+1],A[cop]);
                                String dispens =ensgdisp(G[i]);
                                String []lis=dispens.split("  ");
                                int nombre=0,n=0;
                                int s1=K+nombre;
                                int nb=(nbsalle1+nbsalle2+nbsalle3+nbsalle4+nbsalle5+nbsalle6)*2;
                                while(nb!=0&&s1<=nb)
                                  {
                                        System.out.println("les salle réservee sont: "+nb);
                                        System.out.println("les enseignatns y3esho"+s1);
                                        System.out.println(lis[n]);
                                        int nbsur=nbSurvillance(lis[n]);
                                        System.out.println(n);
                                        String nom =GradeEns(lis[n]);
                                        int max=maxsurgrade(nom);
                                        if((!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences")))
                                            { System.out.println("d5el lhne");
                                                if(nbsur<=max)
                                                    {
                                                        try
                                                        {
                                                            System.out.println("9a3ed yt3ada");
                                                            String update = "UPDATE planningsc SET`j10s2`='1' where nomcomplt  like '%"+lis[n]+"%' ";
                                                            pst = connection.prepareStatement(update);
                                                            pst.execute();
                                                       } catch (SQLException e)
                                                       {
                                                           e.printStackTrace();

                                                       }
                                                       s1++;
                                                    }         
                                            }
                               n++;
                                    }
                            }
                              cop++;
                    }

             }
            else 
                if(i==20)
                {
                    System.out.println(G[i]);
                    String hor=horaire1S1();
                    String []A=hor.split(" ");
      
                    int cop=1;
                    while(cop<A.length)
                    {
                        if(A[cop].equals("S1"))
                        {
                            System.out.println("hana taw f 3"+ A[cop]);
                            int K=nombensg("j11s1");  
                            int nbsalle1=nombsalle(G[i+1],A[cop]);
                            int nbsalle2=nombsalle1(G[i+1],A[cop]);
                            int nbsalle3=Salle2eme(G[i+1],A[cop]);
                            int nbsalle4=Salle3eme(G[i+1],A[cop]);
                            int nbsalle5=Salle1M(G[i+1],A[cop]);
                            int nbsalle6=Salle2m(G[i+1],A[cop]);
                            String dispens =ensgdisp(G[i]);
                            String []lis=dispens.split("  ");
                            int nombre=0,n=0;
                            int s=K+nombre;
                            int nb=(nbsalle1+nbsalle2+nbsalle3+nbsalle4+nbsalle5+nbsalle6)*2;
                            System.out.println("les salle est"+nb);
                            System.out.println("les ensginanats"+s);
                            System.out.println("les ensginanats"+K);
                            while(nb!=0&&s<nb)
                              {
                                  
                                    System.out.println("les salle réservee sont: "+nb);
                                    System.out.println("les enseignatns y3esho"+s);
                                    System.out.println(lis[n]);
                                    int nbsur=nbSurvillance(lis[n]);
                                    System.out.println(n);
                                    String nom =GradeEns(lis[n]);
                                    int max=maxsurgrade(nom);
                                    if((!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences")))
                                    {
                                        System.out.println("d5el lhne");
                                        if(nbsur<=max)
                                        {
                                                try{System.out.println("9a3ed yt3ada");
                                                String update = "UPDATE planningsc SET j11s1='1'where nomcomplt  like '%"+lis[n]+"%' ";
                                                pst = connection.prepareStatement(update);
                                                pst.execute();
                                                } catch (SQLException e)
                                                {
                                                    e.printStackTrace();

                                                }
                                                s++;
                                        }         
                                    }
                                n++;
                              }
                        }else
                            if (A[cop].equals("S2"))
                            {
                                System.out.println("hana taw f 4"+ A[cop]);
                                int K=nombensg("j11s2");  
                                int nbsalle1=nombsalle(G[i+1],A[cop]);
                                int nbsalle2=nombsalle1(G[i+1],A[cop]);
                                int nbsalle3=Salle2eme(G[i+1],A[cop]);
                                int nbsalle4=Salle3eme(G[i+1],A[cop]);
                                int nbsalle5=Salle1M(G[i+1],A[cop]);
                                int nbsalle6=Salle2m(G[i+1],A[cop]);
                                String dispens =ensgdisp(G[i]);
                                String []lis=dispens.split("  ");
                                int nombre=0,n=0;
                                int s1=K+nombre;
                                int nb=(nbsalle1+nbsalle2+nbsalle3+nbsalle4+nbsalle5+nbsalle6)*2;
                                while(nb!=0&&s1<=nb)
                                  {
                                        System.out.println("les salle réservee sont: "+nb);
                                        System.out.println("les enseignatns y3esho"+s1);
                                        System.out.println(lis[n]);
                                        int nbsur=nbSurvillance(lis[n]);
                                        System.out.println(n);
                                        String nom =GradeEns(lis[n]);
                                        int max=maxsurgrade(nom);
                                        if((!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences")))
                                            { System.out.println("d5el lhne");
                                                if(nbsur<=max)
                                                    {
                                                        try
                                                        {
                                                            System.out.println("9a3ed yt3ada");
                                                            String update = "UPDATE planningsc SET`j11s2`='1' where nomcomplt  like '%"+lis[n]+"%' ";
                                                            pst = connection.prepareStatement(update);
                                                            pst.execute();
                                                       } catch (SQLException e)
                                                       {
                                                           e.printStackTrace();

                                                       }
                                                       s1++;
                                                    }         
                                            }
                               n++;
                                    }
                            }
                              cop++;
                    }

             }
                else if(i==22)
                    {System.out.println(G[i]);
                    String hor=horaire1S1();
                    String []A=hor.split(" ");
      
                    int cop=1;
                    while(cop<A.length)
                    {
                        if(A[cop].equals("S1"))
                        {
                            System.out.println("hana taw f 3"+ A[cop]);
                            int K=nombensg("j12s1");  
                            int nbsalle1=nombsalle(G[i+1],A[cop]);
                            int nbsalle2=nombsalle1(G[i+1],A[cop]);
                            int nbsalle3=Salle2eme(G[i+1],A[cop]);
                            int nbsalle4=Salle3eme(G[i+1],A[cop]);
                            int nbsalle5=Salle1M(G[i+1],A[cop]);
                            int nbsalle6=Salle2m(G[i+1],A[cop]);
                            String dispens =ensgdisp(G[i]);
                            String []lis=dispens.split("  ");
                            int nombre=0,n=0;
                            int s=K+nombre;
                            int nb=(nbsalle1+nbsalle2+nbsalle3+nbsalle4+nbsalle5+nbsalle6)*2;
                            System.out.println("les salle est"+nb);
                            System.out.println("les ensginanats"+s);
                            System.out.println("les ensginanats"+K);
                            while(nb!=0&&s<nb)
                              {
                                  
                                    System.out.println("les salle réservee sont: "+nb);
                                    System.out.println("les enseignatns y3esho"+s);
                                    System.out.println(lis[n]);
                                    int nbsur=nbSurvillance(lis[n]);
                                    System.out.println(n);
                                    String nom =GradeEns(lis[n]);
                                    int max=maxsurgrade(nom);
                                    if((!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences")))
                                    {
                                        System.out.println("d5el lhne");
                                        if(nbsur<=max)
                                        {
                                                try{System.out.println("9a3ed yt3ada");
                                                String update = "UPDATE planningsc SET j12s1='1'where nomcomplt  like '%"+lis[n]+"%' ";
                                                pst = connection.prepareStatement(update);
                                                pst.execute();
                                                } catch (SQLException e)
                                                {
                                                    e.printStackTrace();

                                                }
                                                s++;
                                        }         
                                    }
                                n++;
                              }
                        }else
                            if (A[cop].equals("S2"))
                            {
                                System.out.println("hana taw f 4"+ A[cop]);
                                int K=nombensg("j12s2");  
                                int nbsalle1=nombsalle(G[i+1],A[cop]);
                                int nbsalle2=nombsalle1(G[i+1],A[cop]);
                                int nbsalle3=Salle2eme(G[i+1],A[cop]);
                                int nbsalle4=Salle3eme(G[i+1],A[cop]);
                                int nbsalle5=Salle1M(G[i+1],A[cop]);
                                int nbsalle6=Salle2m(G[i+1],A[cop]);
                                String dispens =ensgdisp(G[i]);
                                String []lis=dispens.split("  ");
                                int nombre=0,n=0;
                                int s1=K+nombre;
                                int nb=(nbsalle1+nbsalle2+nbsalle3+nbsalle4+nbsalle5+nbsalle6)*2;
                                while(nb!=0&&s1<=nb)
                                  {
                                        System.out.println("les salle réservee sont: "+nb);
                                        System.out.println("les enseignatns y3esho"+s1);
                                        System.out.println(lis[n]);
                                        int nbsur=nbSurvillance(lis[n]);
                                        System.out.println(n);
                                        String nom =GradeEns(lis[n]);
                                        int max=maxsurgrade(nom);
                                        if((!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences")))
                                            { System.out.println("d5el lhne");
                                                if(nbsur<=max)
                                                    {
                                                        try
                                                        {
                                                            System.out.println("9a3ed yt3ada");
                                                            String update = "UPDATE planningsc SET`j12s2`='1' where nomcomplt  like '%"+lis[n]+"%' ";
                                                            pst = connection.prepareStatement(update);
                                                            pst.execute();
                                                       } catch (SQLException e)
                                                       {
                                                           e.printStackTrace();

                                                       }
                                                       s1++;
                                                    }         
                                            }
                               n++;
                                    }
                            }
                              cop++;
                    }

             }
                else if(i==24)
                    {System.out.println(G[i]);
                    String hor=horaire1S1();
                    String []A=hor.split(" ");
      
                    int cop=1;
                    while(cop<A.length)
                    {
                        if(A[cop].equals("S1"))
                        {
                            System.out.println("hana taw f 3"+ A[cop]);
                            int K=nombensg("j13s1");  
                            int nbsalle1=nombsalle(G[i+1],A[cop]);
                            int nbsalle2=nombsalle1(G[i+1],A[cop]);
                            int nbsalle3=Salle2eme(G[i+1],A[cop]);
                            int nbsalle4=Salle3eme(G[i+1],A[cop]);
                            int nbsalle5=Salle1M(G[i+1],A[cop]);
                            int nbsalle6=Salle2m(G[i+1],A[cop]);
                            String dispens =ensgdisp(G[i]);
                            String []lis=dispens.split("  ");
                            int nombre=0,n=0;
                            int s=K+nombre;
                            int nb=(nbsalle1+nbsalle2+nbsalle3+nbsalle4+nbsalle5+nbsalle6)*2;
                            System.out.println("les salle est"+nb);
                            System.out.println("les ensginanats"+s);
                            System.out.println("les ensginanats"+K);
                            while(nb!=0&&s<nb)
                              {
                                  
                                    System.out.println("les salle réservee sont: "+nb);
                                    System.out.println("les enseignatns y3esho"+s);
                                    System.out.println(lis[n]);
                                    int nbsur=nbSurvillance(lis[n]);
                                    System.out.println(n);
                                    String nom =GradeEns(lis[n]);
                                    int max=maxsurgrade(nom);
                                    if((!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences")))
                                    {
                                        System.out.println("d5el lhne");
                                        if(nbsur<=max)
                                        {
                                                try{System.out.println("9a3ed yt3ada");
                                                String update = "UPDATE planningsc SET j13s1='1'where nomcomplt  like '%"+lis[n]+"%' ";
                                                pst = connection.prepareStatement(update);
                                                pst.execute();
                                                } catch (SQLException e)
                                                {
                                                    e.printStackTrace();

                                                }
                                                s++;
                                        }         
                                    }
                                n++;
                              }
                        }else
                            if (A[cop].equals("S2"))
                            {
                                System.out.println("hana taw f 4"+ A[cop]);
                                int K=nombensg("j13s2");  
                                int nbsalle1=nombsalle(G[i+1],A[cop]);
                                int nbsalle2=nombsalle1(G[i+1],A[cop]);
                                int nbsalle3=Salle2eme(G[i+1],A[cop]);
                                int nbsalle4=Salle3eme(G[i+1],A[cop]);
                                int nbsalle5=Salle1M(G[i+1],A[cop]);
                                int nbsalle6=Salle2m(G[i+1],A[cop]);
                                String dispens =ensgdisp(G[i]);
                                String []lis=dispens.split("  ");
                                int nombre=0,n=0;
                                int s1=K+nombre;
                                int nb=(nbsalle1+nbsalle2+nbsalle3+nbsalle4+nbsalle5+nbsalle6)*2;
                                while(nb!=0&&s1<=nb)
                                  {
                                        System.out.println("les salle réservee sont: "+nb);
                                        System.out.println("les enseignatns y3esho"+s1);
                                        System.out.println(lis[n]);
                                        int nbsur=nbSurvillance(lis[n]);
                                        System.out.println(n);
                                        String nom =GradeEns(lis[n]);
                                        int max=maxsurgrade(nom);
                                        if((!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences")))
                                            { System.out.println("d5el lhne");
                                                if(nbsur<=max)
                                                    {
                                                        try
                                                        {
                                                            System.out.println("9a3ed yt3ada");
                                                            String update = "UPDATE planningsc SET`j13s2`='1' where nomcomplt  like '%"+lis[n]+"%' ";
                                                            pst = connection.prepareStatement(update);
                                                            pst.execute();
                                                       } catch (SQLException e)
                                                       {
                                                           e.printStackTrace();

                                                       }
                                                       s1++;
                                                    }         
                                            }
                               n++;
                                    }
                            }
                              cop++;
                    }

             }
                else if(i==26)
                    {System.out.println(G[i]);
                    String hor=horaire1S1();
                    String []A=hor.split(" ");
      
                    int cop=1;
                    while(cop<A.length)
                    {
                        if(A[cop].equals("S1"))
                        {
                            System.out.println("hana taw f 3"+ A[cop]);
                            int K=nombensg("j14s1");  
                            int nbsalle1=nombsalle(G[i+1],A[cop]);
                            int nbsalle2=nombsalle1(G[i+1],A[cop]);
                            int nbsalle3=Salle2eme(G[i+1],A[cop]);
                            int nbsalle4=Salle3eme(G[i+1],A[cop]);
                            int nbsalle5=Salle1M(G[i+1],A[cop]);
                            int nbsalle6=Salle2m(G[i+1],A[cop]);
                            String dispens =ensgdisp(G[i]);
                            String []lis=dispens.split("  ");
                            int nombre=0,n=0;
                            int s=K+nombre;
                            int nb=(nbsalle1+nbsalle2+nbsalle3+nbsalle4+nbsalle5+nbsalle6)*2;
                            System.out.println("les salle est"+nb);
                            System.out.println("les ensginanats"+s);
                            System.out.println("les ensginanats"+K);
                            while(nb!=0&&s<nb)
                              {
                                  
                                    System.out.println("les salle réservee sont: "+nb);
                                    System.out.println("les enseignatns y3esho"+s);
                                    System.out.println(lis[n]);
                                    int nbsur=nbSurvillance(lis[n]);
                                    System.out.println(n);
                                    String nom =GradeEns(lis[n]);
                                    int max=maxsurgrade(nom);
                                    if((!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences")))
                                    {
                                        System.out.println("d5el lhne");
                                        if(nbsur<=max)
                                        {
                                                try{System.out.println("9a3ed yt3ada");
                                                String update = "UPDATE planningsc SET j2s1='1'where nomcomplt  like '%"+lis[n]+"%' ";
                                                pst = connection.prepareStatement(update);
                                                pst.execute();
                                                } catch (SQLException e)
                                                {
                                                    e.printStackTrace();

                                                }
                                                s++;
                                        }         
                                    }
                                n++;
                              }
                        }else
                            if (A[cop].equals("S2"))
                            {
                                System.out.println("hana taw f 4"+ A[cop]);
                                int K=nombensg("j14s2");  
                                int nbsalle1=nombsalle(G[i+1],A[cop]);
                                int nbsalle2=nombsalle1(G[i+1],A[cop]);
                                int nbsalle3=Salle2eme(G[i+1],A[cop]);
                                int nbsalle4=Salle3eme(G[i+1],A[cop]);
                                int nbsalle5=Salle1M(G[i+1],A[cop]);
                                int nbsalle6=Salle2m(G[i+1],A[cop]);
                                String dispens =ensgdisp(G[i]);
                                String []lis=dispens.split("  ");
                                int nombre=0,n=0;
                                int s1=K+nombre;
                                int nb=(nbsalle1+nbsalle2+nbsalle3+nbsalle4+nbsalle5+nbsalle6)*2;
                                while(nb!=0&&s1<=nb)
                                  {
                                        System.out.println("les salle réservee sont: "+nb);
                                        System.out.println("les enseignatns y3esho"+s1);
                                        System.out.println(lis[n]);
                                        int nbsur=nbSurvillance(lis[n]);
                                        System.out.println(n);
                                        String nom =GradeEns(lis[n]);
                                        int max=maxsurgrade(nom);
                                        if((!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences")))
                                            { System.out.println("d5el lhne");
                                                if(nbsur<=max)
                                                    {
                                                        try
                                                        {
                                                            System.out.println("9a3ed yt3ada");
                                                            String update = "UPDATE planningsc SET`j14s2`='1' where nomcomplt  like '%"+lis[n]+"%' ";
                                                            pst = connection.prepareStatement(update);
                                                            pst.execute();
                                                       } catch (SQLException e)
                                                       {
                                                           e.printStackTrace();

                                                       }
                                                       s1++;
                                                    }         
                                            }
                               n++;
                                    }
                            }
                              cop++;
                    }
             }
                else if(i==28)
                {                System.out.println(G[i]);
                    String hor=horaire1S1();
                    String []A=hor.split(" ");
      
                    int cop=1;
                    while(cop<A.length)
                    {
                        if(A[cop].equals("S1"))
                        {
                            System.out.println("hana taw f 3"+ A[cop]);
                            int K=nombensg("j15s1");  
                            int nbsalle1=nombsalle(G[i+1],A[cop]);
                            int nbsalle2=nombsalle1(G[i+1],A[cop]);
                            int nbsalle3=Salle2eme(G[i+1],A[cop]);
                            int nbsalle4=Salle3eme(G[i+1],A[cop]);
                            int nbsalle5=Salle1M(G[i+1],A[cop]);
                            int nbsalle6=Salle2m(G[i+1],A[cop]);
                            String dispens =ensgdisp(G[i]);
                            String []lis=dispens.split("  ");
                            int nombre=0,n=0;
                            int s=K+nombre;
                            int nb=(nbsalle1+nbsalle2+nbsalle3+nbsalle4+nbsalle5+nbsalle6)*2;
                            System.out.println("les salle est"+nb);
                            System.out.println("les ensginanats"+s);
                            System.out.println("les ensginanats"+K);
                            while(nb!=0&&s<nb)
                              {
                                  
                                    System.out.println("les salle réservee sont: "+nb);
                                    System.out.println("les enseignatns y3esho"+s);
                                    System.out.println(lis[n]);
                                    int nbsur=nbSurvillance(lis[n]);
                                    System.out.println(n);
                                    String nom =GradeEns(lis[n]);
                                    int max=maxsurgrade(nom);
                                    if((!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences")))
                                    {
                                        System.out.println("d5el lhne");
                                        if(nbsur<=max)
                                        {
                                                try{System.out.println("9a3ed yt3ada");
                                                String update = "UPDATE planningsc SET j15s1='1'where nomcomplt  like '%"+lis[n]+"%' ";
                                                pst = connection.prepareStatement(update);
                                                pst.execute();
                                                } catch (SQLException e)
                                                {
                                                    e.printStackTrace();

                                                }
                                                s++;
                                        }         
                                    }
                                n++;
                              }
                        }else
                            if (A[cop].equals("S2"))
                            {
                                System.out.println("hana taw f 4"+ A[cop]);
                                int K=nombensg("j15s2");  
                                int nbsalle1=nombsalle(G[i+1],A[cop]);
                                int nbsalle2=nombsalle1(G[i+1],A[cop]);
                                int nbsalle3=Salle2eme(G[i+1],A[cop]);
                                int nbsalle4=Salle3eme(G[i+1],A[cop]);
                                int nbsalle5=Salle1M(G[i+1],A[cop]);
                                int nbsalle6=Salle2m(G[i+1],A[cop]);
                                String dispens =ensgdisp(G[i]);
                                String []lis=dispens.split("  ");
                                int nombre=0,n=0;
                                int s1=K+nombre;
                                int nb=(nbsalle1+nbsalle2+nbsalle3+nbsalle4+nbsalle5+nbsalle6)*2;
                                while(nb!=0&&s1<=nb)
                                  {
                                        System.out.println("les salle réservee sont: "+nb);
                                        System.out.println("les enseignatns y3esho"+s1);
                                        System.out.println(lis[n]);
                                        int nbsur=nbSurvillance(lis[n]);
                                        System.out.println(n);
                                        String nom =GradeEns(lis[n]);
                                        int max=maxsurgrade(nom);
                                        if((!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences")))
                                            { System.out.println("d5el lhne");
                                                if(nbsur<=max)
                                                    {
                                                        try
                                                        {
                                                            System.out.println("9a3ed yt3ada");
                                                            String update = "UPDATE planningsc SET`j15s2`='1' where nomcomplt  like '%"+lis[n]+"%' ";
                                                            pst = connection.prepareStatement(update);
                                                            pst.execute();
                                                       } catch (SQLException e)
                                                       {
                                                           e.printStackTrace();

                                                       }
                                                       s1++;
                                                    }         
                                            }
                               n++;
                                    }
                            }
                              cop++;
                    }

             break;}
    
                
             i++;
        }
   }

 @FXML
    void demmarer(ActionEvent event) throws IOException {
        connection = handler.getConnection();
        /**int i=entrejour();
        if(i==0)
        {   Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Notification");
            alert.setContentText("pour bien génerer le planning il faut entre sous form   \"Jour jj/mm/aaaa\"");
            alert.showAndWait();
        
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/View/FrmJourRattrapage.fxml"));
            AnchorPane  mainPane = (AnchorPane)loader.load();
            Scene scene = new Scene(mainPane);
            stage.setTitle("Ajouter Jour de l'examen");
            stage.setScene(scene);
            stage.initStyle(StageStyle.UNDECORATED);
            FrmJourRattrapageController ctrl = loader.getController();
            stage.showAndWait();
            try
        {
            
                String insert ="INSERT INTO planningsc SELECT id, nomcomplt,'','','','','','','','','','','','','','','','','','','',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','',''FROM enseignant";
                pst = connection.prepareStatement(insert);
        
                pst.execute();
         
                } 
        catch (SQLException e1)
             {
                 e1.printStackTrace();
             }
      /**  finally 
        {
                try{
                      connection.close();
                     }catch(SQLException e1)
                    {e1.printStackTrace(); }}
        }
       else
        {Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Notification");
                    alert.setContentText("planning déjà crée ,Veuillez cliquer sur \"afficher\" pour afficher le planning ou bien sur\"supprimer\" pour démarrer un nouveau planning");
                    alert.showAndWait();
        
    }*/
        plannning1();
      //PlanningSeance2();
     
    }

    @FXML
    void modifier(ActionEvent event) throws IOException {
        connection = handler.getConnection();
        int i1=entrejour();
        int row =planningsr.getSelectionModel().getSelectedIndex();
        if(row <0)return; 
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/reglageseancerattrapage.fxml"));
        AnchorPane  mainPane = (AnchorPane)loader.load();
        Scene scene = new Scene(mainPane);
        stage.setTitle("Modifier séance surveillance");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        FrmJourRattrapageController ctrl = loader.getController();
        ctrl.setplanning(data.get(row).getIdPlanningSC());
        stage.showAndWait();
        actualiser();
    }

    @FXML
    void modifier2(ActionEvent event) {
        connection = handler.getConnection();
        String k= ensgdisp("Samedi");
        System.out.println(k);
        String [] h=k.split("  ");
        int i=0;
        while(i<h.length)
                {
                    System.out.println(i+"  "+h[i]);i++;
                }
    }

    @FXML
    void supprimer(ActionEvent event) {
        connection = handler.getConnection();
        int row =planningsr.getSelectionModel().getSelectedIndex();
        if(row <0)return;
         Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
        alert.setTitle("Conformation de suppression");
        alert.setHeaderText(null);
        alert.setContentText("Vous etes sure?");
        Optional <ButtonType>action = alert.showAndWait();
        
        if(action.get()==ButtonType.OK){
       
        em = PlanningSCController.emf.createEntityManager();
        Query q =em.createQuery("SELECT p FROM Planningsc p WHERE p.idPlanningSC = :idPlanningSC");
        q.setParameter("idPlanningSC", data.get(row).getIdPlanningSC());
       Planningsc P = (Planningsc) q.getSingleResult();
        em.getTransaction().begin();
        em.remove(P);
        em.getTransaction().commit();
        em.close();
        
        actualiser();
    }
    }
    private void actualiser()
    {
        emf=Persistence.createEntityManagerFactory("ESENPU");
        em = PlanningSCController.emf.createEntityManager();
        emf=Persistence.createEntityManagerFactory("ESENPU");
        planningsr.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        List<Planningsc>lst = em.createQuery("SELECT p FROM Planningsc p").getResultList();
        
        data=FXCollections.observableArrayList();
        for(Planningsc lst1:lst){
           
        data.add(new Planningscfx(lst1.getIdPlanningSC(),lst1.getNomcomplt()
                ,lst1.getJ1s1(),lst1.getJ1s2(),lst1.getJ2s1(),lst1.getJ2s2(),lst1.getJ3s1(),lst1.getJ3s2()
                 ,lst1.getJ4s1(),lst1.getJ4s2(),lst1.getJ5s1(),lst1.getJ5s2()
                ,lst1.getJ6s1(),lst1.getJ6s2()
                ,lst1.getJ7s1(),lst1.getJ7s2(),lst1.getJ8s1(),lst1.getJ8s2(),lst1.getJ9s1(),lst1.getJ9s2()
                ,lst1.getJ10s1(),lst1.getJ10s2(),lst1.getJ11s1(),lst1.getJ11s2(),lst1.getJ12s1()
                ,lst1.getJ12s2(),lst1.getJ13s1(),lst1.getJ13s2()
                ,lst1.getJ14s1(),lst1.getJ14s2(),lst1.getJ15s1(),lst1.getJ15s2(),lst1.getNbre()
        ));
        }
        planningsr.setItems(data);
        id.setCellValueFactory(cell->cell.getValue().getIdPlanningSCProperty());
        nc.setCellValueFactory(cell->cell.getValue().getNomcompltProperty());
        j1s1.setCellValueFactory(cell->cell.getValue().getJ1s1Property());
        j1s2.setCellValueFactory(cell->cell.getValue().getJ1s2Proprty());
        j2s1.setCellValueFactory(cell->cell.getValue().getJ2s1Property());
        j2s2.setCellValueFactory(cell->cell.getValue().getJ2s2Property());
        j3s1.setCellValueFactory(cell->cell.getValue().getJ3s1Property());
        j3s2.setCellValueFactory(cell->cell.getValue().getJ3s2Property());
        j4s1.setCellValueFactory(cell->cell.getValue().getJ4s1Property());
        j4s2.setCellValueFactory(cell->cell.getValue().getJ4s2Property());
        j5s1.setCellValueFactory(cell->cell.getValue().getJ5s1PRoperty());
        j5s2.setCellValueFactory(cell->cell.getValue().getJ5s2Property());
        j6s1.setCellValueFactory(cell->cell.getValue().getJ6s1Property());
        j6s2.setCellValueFactory(cell->cell.getValue().getJ6s2Property());
        j7s1.setCellValueFactory(cell->cell.getValue().getJ7s1Property());
        j7s2.setCellValueFactory(cell->cell.getValue().getJ7s2Property());
        j8s1.setCellValueFactory(cell->cell.getValue().getJ8s1Property());
        j8s2.setCellValueFactory(cell->cell.getValue().getJ8s2Property());
        j9s1.setCellValueFactory(cell->cell.getValue().getJ9s1Property());
        j9s2.setCellValueFactory(cell->cell.getValue().getJ9s2Property());
        j10s1.setCellValueFactory(cell->cell.getValue().getJ10s1Property());
        j10s2.setCellValueFactory(cell->cell.getValue().getJ10s2Property());
        j11s1.setCellValueFactory(cell->cell.getValue().getJ11s1Property());
        j11s2.setCellValueFactory(cell->cell.getValue().getJ11s2Property());
        j12s1.setCellValueFactory(cell->cell.getValue().getJ12s1Property());
        j12s2.setCellValueFactory(cell->cell.getValue().getJ12s2Property());
        j13s1.setCellValueFactory(cell->cell.getValue().getJ13s1Property());
        j13s2.setCellValueFactory(cell->cell.getValue().getJ13s2Property());
        j14s1.setCellValueFactory(cell->cell.getValue().getJ14s1Property());
        j14s2.setCellValueFactory(cell->cell.getValue().getJ14s2Property());
        j15s1.setCellValueFactory(cell->cell.getValue().getJ15s1Property());
        j15s2.setCellValueFactory(cell->cell.getValue().getJ15s2Property());
        nbre.setCellValueFactory(cell->cell.getValue().getNbreProperty());
        
    }
     @FXML
    void telecharger(ActionEvent event) throws DocumentException, SQLException, FileNotFoundException {
        connection = handler.getConnection();
        
        Statement st=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        int rowno=0;
        rs=pst.executeQuery("SELECT p FROM Planningsc p");
        ResultSetMetaData rsmd =rs.getMetaData();
        int colnc=rsmd.getColumnCount();
        while(rs.next())
        {
            rowno = rowno+1;
        }
        rs.first();
        Document d = new Document(PageSize.A4.rotate());
        PdfWriter.getInstance(d,new FileOutputStream ("planningRattrapage.pdf"));
        PdfPTable pt = new PdfPTable(colnc);
        pt.setWidthPercentage(100);
        pt.setHorizontalAlignment(100);
        d.open();
        
        d.add(new Paragraph("AVIS AUX ENSEIGNANTS"));
        d.add(new Paragraph("ECOLE SUPERIEURE DE L’ECONOMIE NUMERIQUE",FontFactory.getFont(FontFactory.TIMES_BOLD,18,Font.BOLD,BaseColor.BLUE)));
        d.add(new Paragraph("  "));
        d.add(new Paragraph("                           PLANNING  DES  SURVEILLANCES  DES EXAMENS ",FontFactory.getFont(FontFactory.TIMES_BOLD,18,Font.BOLD)));
        d.add(new Paragraph("                           "+new Date().toString()));
        d.add(new Paragraph("  "));
        
        for(int i=0;i<rowno;i++)
        {
        pt.addCell(""+rs.getString(1));
        pt.addCell(""+rs.getString(2));
        pt.addCell(""+rs.getString(3));
        pt.addCell(""+rs.getString(4));
        pt.addCell(""+rs.getString(5));
        pt.addCell(""+rs.getString(6));
        pt.addCell(""+rs.getString(7));
        pt.addCell(""+rs.getString(8));
        pt.addCell(""+rs.getString(9));
        pt.addCell(""+rs.getString(10));
        pt.addCell(""+rs.getString(11));
        pt.addCell(""+rs.getString(12));
        pt.addCell(""+rs.getString(13));
        pt.addCell(""+rs.getString(14));
        pt.addCell(""+rs.getString(15));
        pt.addCell(""+rs.getString(16));
        pt.addCell(""+rs.getString(17));
        pt.addCell(""+rs.getString(18));
        pt.addCell(""+rs.getString(19));
        pt.addCell(""+rs.getString(20));
        pt.addCell(""+rs.getString(21));
        pt.addCell(""+rs.getString(22));
        pt.addCell(""+rs.getString(23));
        pt.addCell(""+rs.getString(24));
        pt.addCell(""+rs.getString(25));
        pt.addCell(""+rs.getString(26));
        pt.addCell(""+rs.getString(27));
        pt.addCell(""+rs.getString(28));
        pt.addCell(""+rs.getString(29));
        pt.addCell(""+rs.getString(30));
        pt.addCell(""+rs.getString(31));
        pt.addCell(""+rs.getString(32));
        pt.addCell(""+rs.getString(33));
        rs.next();
        }
        d.add(pt);
        d.close();
    }
   @FXML
    void vider(ActionEvent event) {
         connection = handler.getConnection();
        int i=minid(),j=maxid();
        Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
        alert.setTitle("Conformation de suppression");
        alert.setHeaderText(null);
        alert.setContentText("Attention!! si vous allez cliquer oui tout le contenu sera supprimé");
        Optional <ButtonType>action = alert.showAndWait();
        if(action.get()==ButtonType.OK){
            alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Notification");
                    alert.setContentText("Veuillez attendre quelques secondes");
                    alert.showAndWait();
        while(i<=j)
        {
        try{
        String sql ="delete from planningsc where idPlanningSC="+i+"";
        pst = connection.prepareStatement(sql);
        pst.executeUpdate();
        }
        catch (SQLException e1)
            {
                e1.printStackTrace();
            }        
i++;
        }
        }actualiser();
   
    } 
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        handler = new dbconnect();
        emf=Persistence.createEntityManagerFactory("ESENPU");
        em = PlanningSCController.emf.createEntityManager();
        emf=Persistence.createEntityManagerFactory("ESENPU");
        
    }    
    
}
