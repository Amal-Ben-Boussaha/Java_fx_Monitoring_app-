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

/**
 * FXML Controller class
 *
 * @author Amal Ben Boussaha
 */
public class PlannificationdsController implements Initializable {
@FXML
    private TableView<Planningdsfx> planningds;

    @FXML
    private TableColumn<Planningdsfx, Number> id;

    @FXML
    private TableColumn<Planningdsfx, String> nomcomplt;

    @FXML
    private TableColumn<Planningdsfx, String> j1s1;

    @FXML
    private TableColumn<Planningdsfx, String> j1s2;

    @FXML
    private TableColumn<Planningdsfx, String> j1s3;

    @FXML
    private TableColumn<Planningdsfx, String> j1s4;

    @FXML
    private TableColumn<Planningdsfx, String> j2s1;

    @FXML
    private TableColumn<Planningdsfx, String> j2s2;

    @FXML
    private TableColumn<Planningdsfx, String> j2s3;

    @FXML
    private TableColumn<Planningdsfx, String> j2s4;
    
    @FXML
    private TableColumn<Planningdsfx, String> j3s1;

    @FXML
    private TableColumn<Planningdsfx, String> j3s2;

    @FXML
    private TableColumn<Planningdsfx, String> j3s3;

    @FXML
    private TableColumn<Planningdsfx, String> j3s4;

    @FXML
    private TableColumn<Planningdsfx, String> j4s1;

    @FXML
    private TableColumn<Planningdsfx, String> j4s2;

    @FXML
    private TableColumn<Planningdsfx, String> j4s3;

    @FXML
    private TableColumn<Planningdsfx, String> j4s4;

    @FXML
    private TableColumn<Planningdsfx, String> j5s1;

    @FXML
    private TableColumn<Planningdsfx, String> j5s2;

    @FXML
    private TableColumn<Planningdsfx, String> j5s3;

    @FXML
    private TableColumn<Planningdsfx, String> j5s4;

    @FXML
    private TableColumn<Planningdsfx, String> j6s1;

    @FXML
    private TableColumn<Planningdsfx, String> j6s2;

    @FXML
    private TableColumn<Planningdsfx, String> j6s3;

    @FXML
    private TableColumn<Planningdsfx, String> j6s4;

    @FXML
    private TableColumn<Planningdsfx, String> nbre;
    private Connection connection;
    private dbconnect handler;
    private PreparedStatement pst;  
    private ResultSet rs;
    EntityManager em;  
    public static EntityManagerFactory emf;
    ObservableList<Planningdsfx> data;
    private int entrejour()
    {
        int i=0;
           try {
            pst = connection.prepareStatement("SELECT count(idPlanningDS) FROM planningds");
            rs = pst.executeQuery();
            while(rs.next())
            {
                i=rs.getInt(1);
           
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
            pst = connection.prepareStatement("SELECT j1s1 FROM planningds where idPlanningDS='1'");
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
            pst = connection.prepareStatement("SELECT j2s1 FROM planningds where idPlanningDS='1' ");
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
            pst = connection.prepareStatement("SELECT j3s1 FROM planningds where idPlanningDS='1' ");
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
            pst = connection.prepareStatement("SELECT j4s1 FROM planningds where idPlanningDS='1' ");
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
            pst = connection.prepareStatement("SELECT j5s1 FROM planningds where idPlanningDS='1' ");
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
            pst = connection.prepareStatement("SELECT j6s1 FROM planningds where idPlanningDS='1' ");
             rs = pst.executeQuery();
            while(rs.next())
            {
                day6=day5+" "+rs.getString(1);
            }} catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
 
   return day6;
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
            }
    else if(!Mate.equals("")&&M.equals("0"))
    {
        M=Mate;
    }
    else 
    { M=M;}
   
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
              
            }
    else if(!Mate.equals("")&&M.equals("0"))
    {
        M=Mate;
    }
    else 
    { M=M;}
  
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
                    {   
                    M=rs.getString(1);
                         
                }
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
     }
     
    return S;
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
               
            }
    else if(!T.equals("")&&M.equals("0"))
    {
        M=T;
    }
    else 
    { M=M;}
    
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
               
            }
    else if(!T.equals("")&&M.equals("0"))
    {
        M=T;
    }
    else 
    { M=M;}
   
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
               
            }
    else if(!T.equals("")&&M.equals("0"))
    {
        M=T;
    }
    else 
    { M=M;}
    
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
                
            }
    else if(!T.equals("")&&M.equals("0"))
    {
        M=T;
    }
    else 
    { M=M;}
   
    return M;
}
private String ListeEns(String L,String Hor)
{       int a=0;
     String S="";
     String K= Matieres3e(L,Hor);
     String[] E =K.split("  ");
     while (a<E.length)
     {
        S=S+nomEns(E[a]);
        a++;
     }
     
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
                
            }
    else if(!T.equals("")&&M.equals("0"))
    {
        M=T;
    }
    else 
    { M=M;}
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
            }
    else if(!T.equals("")&&M.equals("0"))
    {
        M=T;
    }
    else  
    { M=M;}
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
            }
    else if(!T.equals("")&&M.equals("0"))
    {
        M=T;
    }
    else 
    { M=M;}
    return M;
}      
private String Matieres2m(String mat,String S)
{  String M="";

        try {
                pst = connection.prepareStatement("SELECT matieres from mecom2 where date ='"+mat+"'and horaire ='"+S+"' ");
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
   
    return M;
}
private String Matieresw2(String mat,String S)
{
String T=Matieres2m(mat,S);
String M="";

        try {
                pst = connection.prepareStatement("SELECT matieres_wi from wi2 where date_wi ='"+mat+"'and horaire_wi='"+S+"' ");
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
            }
    else if(!T.equals("")&&M.equals("0"))
    {
        M=T;
    }
    else 
    { M=M;}
    return M;}
private String Matieres2b(String mat,String S)
{  String T=Matieres2v(mat,S);
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
    return M;}      
private String Matieres2v(String mat,String S)
{String T=Matieresw2(mat,S);
String M="";

        try {
                pst = connection.prepareStatement("SELECT matieres_vic from vic2 where date_vic ='"+mat+"'and horaire_vic='"+S+"' ");
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
            }
    else if(!T.equals("")&&M.equals("0"))
    {
        M=T;
    }
    else 
    { M=M;}
    return M;
}      

private String Listes(String L,String Hor)
{    int a=0;
     String S="";
     String K= Matieres1b(L,Hor);
     String[] E =K.split("  ");
     while (a<E.length)
     {   
     S=S+nomEns(E[a]);
         a++;
     }
     return S;
}
private String Listes2(String L,String Hor)
{    int a=0;
     String S="";
     String K= Matieres2b(L,Hor);
     String[] E =K.split("  ");
     while (a<E.length)
     {S=S+nomEns(E[a]);
         a++;
     }
     
     return S;
}
private String ensgdisp(String date)
{String d="";
         try {
                pst = connection.prepareStatement("SELECT distinct(teachers) from disponibilites where day ='"+date+"' ");
                 rs = pst.executeQuery();
                 while(rs.next())
                
                 {d=d+"  "+rs.getString(1)+"  ";
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
String M2=Listes2(d,s);
String List=L+L1+M+h+M2;
return List;
}
private void plannning1()
    {  
        String S = Jour6();
        String[] G =S.split(" ");
        int i=1,j=1,j1=1,j2=1,j3=1,f=1,f1=1,f2=1,f3=1,k=1,k1=1,k2=1,k3=1,a=1,a1=1,a2=1,a3=1,s=1,s1=1,s2=1,s3=1,l=1,l1=1,l2=1,l3=1;
        while(i<G.length)
        { 
          if(i==1)
           {
               
               String S1= horaire1S1();
               String[] A =S1.split(" ");
               int compteur=1;
               while(compteur<A.length)
              
               {
               if(A[compteur].equals("S1"))
                {   String Ens = K(G[i],A[compteur]);
                    String[] E =Ens.split("  ");
                    while(j<E.length)
                     { 
                          String nom =GradeEns(E[j]);
                          
                          if(!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences"))
                        {
                            try
                                {
                                    String update = "UPDATE planningds SET `j1s1`='1', `j1s2`='1' where nomcomplt like '%"+E[j]+"%' ";
                                    pst = connection.prepareStatement(update);
                                    pst.execute();
                                }   catch (SQLException e)
                                             {
                                                 e.printStackTrace();
                                             }
                           j++;
                        }else
                        {
                            try
                                       {
                                String update = "UPDATE planningds SET j1s1='1' where nomcomplt like '%"+E[j]+"%' ";
                                        pst = connection.prepareStatement(update);
                                        pst.execute();
                               
                                    }catch (SQLException e)
                                            {e.printStackTrace();}
                                        j++;
                                }
                        }
                        }
                        else
                   if(A[compteur].equals("S2"))
                           {    String Ens = K(G[i],A[compteur]);
                               String[] E =Ens.split("  ");
                                
                                        while(j1<E.length)
                                        {
                                           
                                            String nom =GradeEns(E[j1]);
                                            if(!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences"))
                                                {
                                                    try
                                                    {   String update = "UPDATE planningds SET `j1s1`='1', `j1s2`='1' where nomcomplt like '%"+E[j1]+"%' ";
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
                                                    {
                                                        String update = "UPDATE planningds SET j1s2='1' where nomcomplt like '%"+E[j1]+"%' ";
                           
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                               
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();}
                                                    j1++;
                                                }
                                        }
                                    
                           }else if(A[compteur].equals("S3"))
                           {   
                               String Ens = K(G[i],A[compteur]);
                               String[] E =Ens.split("  ");
                                
                                        while(j2<E.length)
                                        {
                                            
                                            String nom =GradeEns(E[j2]);
                                            if(!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences"))
                                                {
                                                    try
                                                    {   String update = "UPDATE planningds SET `j1s2`='1', `j1s3`='1' where nomcomplt like '%"+E[j2]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();
                                                            }
                                                    j2++;
                                                }
                                            else
                                                {
                                                    try
                                                    {
                                                        String update = "UPDATE planningds SET j1s3='1' where nomcomplt like '%"+E[j2]+"%' ";
                           
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                               
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();}
                                                    j2++;
                                                }
                                        }
                                    
                           }else if(A[compteur].equals("S4"))
                           {   
                               String Ens = K(G[i],A[compteur]);
                               String[] E =Ens.split("  ");
                                
                                        while(j3<E.length)
                                        {
                                           
                                            String nom =GradeEns(E[j3]);
                                            if(!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences"))
                                                {
                                                    try
                                                    {
                                                        String update = "UPDATE planningds SET `j1s3`='1', `j1s4`='1' where nomcomplt like '%"+E[j3]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();
                                                            }
                                                    j3++;
                                                }
                                            else
                                                {
                                                    try
                                                    {   String update = "UPDATE planningds SET j1s4='1' where nomcomplt like '%"+E[j3]+"%' ";
                           
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                               
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();}
                                                    j3++;
                                                }}}
               compteur++;}}
            else
              
                if(i==3)
                {
            
               String S1= horaire1S1();
               String[] A =S1.split(" ");
               int compteur=1;
               while(compteur<A.length)
              
               {
               if(A[compteur].equals("S1"))
                { 
                    String Ens = K(G[i],A[compteur]);
                    String[] E =Ens.split("  ");
                    while(f<E.length)
                     { 
                          String nom =GradeEns(E[f]);
                        if(!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences"))
                        {
                            try
                                {
                                
                                    String update = "UPDATE planningds SET `j2s1`='1', `j2s2`='1' where nomcomplt like '%"+E[f]+"%' ";
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
                                       {
                                        String update = "UPDATE planningds SET j2s1='1' where nomcomplt like '%"+E[f]+"%' ";
                                        pst = connection.prepareStatement(update);
                                        pst.execute();
                               
                                    }catch (SQLException e)
                                            {e.printStackTrace();}
                                        f++;
                                }
                        }
                        }
                        else
                   if(A[compteur].equals("S2"))
                           {   
                               String Ens = K(G[i],A[compteur]);
                               String[] E =Ens.split("  ");
                                
                                        while(f1<E.length)
                                        {
                                            String nom =GradeEns(E[f1]);
                                            if(!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences"))
                                                {
                                                    try
                                                    {   String update = "UPDATE planningds SET `j2s1`='1', `j2s2`='1' where nomcomplt like '%"+E[f1]+"%' ";
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
                                                    {
                                                        String update = "UPDATE planningds SET j2s2='1' where nomcomplt like '%"+E[f1]+"%' ";
                           
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                               
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();}
                                                    f1++;
                                                }
                                        }
                                    
                           }else if(A[compteur].equals("S3"))
                           {    
                               String Ens = K(G[i],A[compteur]);
                               String[] E =Ens.split("  ");
                                
                                        while(f2<E.length)
                                        {
                                           
                                            String nom =GradeEns(E[f2]);
                                            if(!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences"))
                                                {
                                                    try
                                                    {
                                                        String update = "UPDATE planningds SET `j2s2`='1', `j2s3`='1' where nomcomplt like '%"+E[f2]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();
                                                            }
                                                    f2++;
                                                }
                                            else
                                                {
                                                    try
                                                    {
                                                        String update = "UPDATE planningds SET j2s3='1' where nomcomplt like '%"+E[f2]+"%' ";
                           
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                               
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();}
                                                    f2++;
                                                }
                                        }
                                    
                           }else if(A[compteur].equals("S4"))
                           {   
                               String Ens = K(G[i],A[compteur]);
                               String[] E =Ens.split("  ");
                                
                                        while(f3<E.length)
                                        {
                                          
                                            String nom =GradeEns(E[f3]);
                                            if(!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences"))
                                                {
                                                    try
                                                    {
                                                        String update = "UPDATE planningds SET `j2s3`='1', `j2s4`='1' where nomcomplt like '%"+E[f3]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();
                                                            }
                                                    f3++;
                                                }
                                            else
                                                {
                                                    try
                                                    {
                                                        String update = "UPDATE planningds SET j2s4='1' where nomcomplt like '%"+E[f3]+"%' ";
                           
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                               
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();}
                                                    f3++;
                                                }}}
               compteur++;}}
           else if(i==5)
           
           {
               
               String S1= horaire1S1();
               String[] A =S1.split(" ");
               int compteur=1;
               while(compteur<A.length)
              
               {
               if(A[compteur].equals("S1"))
                { 
                   String Ens = K(G[i],A[compteur]);
                    String[] E =Ens.split("  ");
                    while(k<E.length)
                     { 
                          String nom =GradeEns(E[k]);
                        if(!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences"))
                        {
                            try
                                {
                                String update = "UPDATE planningds SET `j3s1`='1', `j3s2`='1' where nomcomplt like '%"+E[k]+"%' ";
                                    pst = connection.prepareStatement(update);
                                    pst.execute();
                                }   catch (SQLException e)
                                             {
                                                 e.printStackTrace();
                                             }
                           k++;
                        }else
                        {
                            try
                                       {
                                String update = "UPDATE planningds SET j3s1='1' where nomcomplt like '%"+E[k]+"%' ";
                                        pst = connection.prepareStatement(update);
                                        pst.execute();
                               
                                    }catch (SQLException e)
                                            {e.printStackTrace();}
                                        k++;
                                }
                        }
                        }
                        else
                   if(A[compteur].equals("S2"))
                           {   
                       String Ens = K(G[i],A[compteur]);
                               String[] E =Ens.split("  ");
                                
                                        while(k1<E.length)
                                        {
                                            
                                            String nom =GradeEns(E[k1]);
                                            if(!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences"))
                                                {
                                                    try
                                                    {
                                                        String update = "UPDATE planningds SET `j3s1`='1', `j3s2`='1' where nomcomplt like '%"+E[k1]+"%' ";
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
                                                    {
                                                        
                                                        String update = "UPDATE planningds SET j3s2='1' where nomcomplt like '%"+E[k1]+"%' ";
                           
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                               
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();}
                                                    k1++;
                                                }
                                        }
                                    
                           }else if(A[compteur].equals("S3"))
                           {    
                               String Ens = K(G[i],A[compteur]);
                               String[] E =Ens.split("  ");
                                
                                        while(k2<E.length)
                                        {
                                           
                                            String nom =GradeEns(E[k2]);
                                            if(!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences"))
                                                {
                                                    try
                                                    {
                                                        String update = "UPDATE planningds SET `j3s2`='1', `j3s3`='1' where nomcomplt like '%"+E[k2]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();
                                                            }
                                                    k2++;
                                                }
                                            else
                                                {
                                                    try
                                                    {   String update = "UPDATE planningds SET j3s3='1' where nomcomplt like '%"+E[k2]+"%' ";
                           
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                               
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();}
                                                    k2++;
                                                }
                                        }
                                    
                           }else if(A[compteur].equals("S4"))
                           {   
                               String Ens = K(G[i],A[compteur]);
                               String[] E =Ens.split("  ");
                                
                                        while(k3<E.length)
                                        {
                                           
                                            String nom =GradeEns(E[k3]);
                                            if(!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences"))
                                                {
                                                    try
                                                    {   String update = "UPDATE planningds SET `j3s3`='1', `j3s4`='1' where nomcomplt like '%"+E[k3]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();
                                                            }
                                                    k3++;
                                                }
                                            else
                                                {
                                                    try
                                                    {   String update = "UPDATE planningds SET j3s4='1' where nomcomplt like '%"+E[k3]+"%' ";
                           
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                               
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();}
                                                    k3++;
                                                }}}
               compteur++;}}         else 
                     if(i==7)
           
           { 
              
               String S1= horaire1S1();
               String[] A =S1.split(" ");
               int compteur=1;
               while(compteur<A.length)
              
               {
               if(A[compteur].equals("S1"))
                {   String Ens = K(G[i],A[compteur]);
                    String[] E =Ens.split("  ");
                    while(a<E.length)
                     { 
                          String nom =GradeEns(E[a]);
                        if(!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences"))
                        {
                            try
                                {
                                    String update = "UPDATE planningds SET `j4s1`='1', `j4s2`='1' where nomcomplt like '%"+E[a]+"%' ";
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
                                       {
                                        String update = "UPDATE planningds SET j4s1='1' where nomcomplt like '%"+E[a]+"%' ";
                                        pst = connection.prepareStatement(update);
                                        pst.execute();
                               
                                    }catch (SQLException e)
                                            {e.printStackTrace();}
                                        a++;
                                }
                        }
                        }
                        else
                   if(A[compteur].equals("S2"))
                           {   
                               String Ens = K(G[i],A[compteur]);
                               String[] E =Ens.split("  ");
                                
                                        while(a1<E.length)
                                        {
                                          
                                            String nom =GradeEns(E[a1]);
                                            if(!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences"))
                                                {
                                                    try
                                                    {
                                                        String update = "UPDATE planningds SET `j4s1`='1', `j4s2`='1' where nomcomplt like '%"+E[a1]+"%' ";
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
                                                    {
                                                        String update = "UPDATE planningds SET j4s2='1' where nomcomplt like '%"+E[a1]+"%' ";
                           
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                               
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();}
                                                    a1++;
                                                }
                                        }
                                    
                           }else if(A[compteur].equals("S3"))
                           {    
                       String Ens = K(G[i],A[compteur]);
                               String[] E =Ens.split("  ");
                                
                                        while(a2<E.length)
                                        {
                                        
                                            String nom =GradeEns(E[a2]);
                                            if(!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences"))
                                                {
                                                    try
                                                    {
                                                        String update = "UPDATE planningds SET `j4s2`='1', `j4s3`='1' where nomcomplt like '%"+E[a2]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();
                                                            }
                                                    a2++;
                                                }
                                            else
                                                {
                                                    try
                                                    {
                                                        String update = "UPDATE planningds SET j4s3='1' where nomcomplt like '%"+E[a2]+"%' ";
                           
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                               
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();}
                                                    a2++;
                                                }
                                        }
                                    
                           }else if(A[compteur].equals("S4"))
                           {    
                       String Ens = K(G[i],A[compteur]);
                               String[] E =Ens.split("  ");
                                
                                        while(a3<E.length)
                                        {
                       
                                            String nom =GradeEns(E[a3]);
                                            if(!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences"))
                                                {
                                                    try
                                                    {
                                                        String update = "UPDATE planningds SET `j4s3`='1', `j4s4`='1' where nomcomplt like '%"+E[a3]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();
                                                            }
                                                    a3++;
                                                }
                                            else
                                                {
                                                    try
                                                    {
                                                        String update = "UPDATE planningds SET j4s4='1' where nomcomplt like '%"+E[a3]+"%' ";
                           
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                               
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();}
                                                    a3++;
                                                }}}
               compteur++;}}
                     else
               if(i==9)
           
           {   
               
               String S1= horaire1S1();
               String[] A =S1.split(" ");
               int compteur=1;
               while(compteur<A.length)
              
               {
               if(A[compteur].equals("S1"))
                {   
                    String Ens = K(G[i],A[compteur]);
                    String[] E =Ens.split("  ");
                    while(s<E.length)
                     { 
                          String nom =GradeEns(E[s]);
                        if(!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences"))
                        {
                            try
                                {
                                    String update = "UPDATE planningds SET `j5s1`='1', `j5s2`='1' where nomcomplt like '%"+E[s]+"%' ";
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
                                       {
                                        String update = "UPDATE planningds SET j5s1='1' where nomcomplt like '%"+E[s]+"%' ";
                                        pst = connection.prepareStatement(update);
                                        pst.execute();
                               
                                    }catch (SQLException e)
                                            {e.printStackTrace();}
                                        s++;
                                }
                        }
                        }
                        else
                   if(A[compteur].equals("S2"))
                           {   
                               String Ens = K(G[i],A[compteur]);
                               String[] E =Ens.split("  ");
                                
                                        while(s1<E.length)
                                        {
                                           
                                            String nom =GradeEns(E[s1]);
                                            if(!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences"))
                                                {
                                                    try
                                                    {   String update = "UPDATE planningds SET `j5s1`='1', `j5s2`='1' where nomcomplt like '%"+E[s1]+"%' ";
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
                                                    {
                                                        String update = "UPDATE planningds SET j5s2='1' where nomcomplt like '%"+E[s1]+"%' ";
                           
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                               
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();}
                                                    s1++;
                                                }
                                        }
                                    
                           }else if(A[compteur].equals("S3"))
                           {  
                       String Ens = K(G[i],A[compteur]);
                               String[] E =Ens.split("  ");
                                
                                        while(s2<E.length)
                                        {
                                           
                                            String nom =GradeEns(E[s2]);
                                            if(!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences"))
                                                {
                                                    try
                                                    {  String update = "UPDATE planningds SET `j5s2`='1', `j5s3`='1' where nomcomplt like '%"+E[s2]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();
                                                            }
                                                    s2++;
                                                }
                                            else
                                                {
                                                    try
                                                    {
                                                        String update = "UPDATE planningds SET j5s3='1' where nomcomplt like '%"+E[s2]+"%' ";
                           
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                               
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();}
                                                    s2++;
                                                }
                                        }
                                    
                           }else if(A[compteur].equals("S4"))
                           {    
                               String Ens = K(G[i],A[compteur]);
                               String[] E =Ens.split("  ");
                                
                                        while(s3<E.length)
                                        {
                                           
                                            String nom =GradeEns(E[s3]);
                                            if(!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences"))
                                                {
                                                    try
                                                    {
                                                        String update = "UPDATE planningds SET `j5s3`='1', `j5s4`='1' where nomcomplt like '%"+E[s3]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();
                                                            }
                                                    s3++;
                                                }
                                            else
                                                {
                                                    try
                                                    {
                                                        String update = "UPDATE planningds SET j5s4='1' where nomcomplt like '%"+E[s3]+"%' ";
                           
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                               
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();}
                                                    s3++;
                                                }}}
               compteur++;}}
               else 
                   if(i==11)
           
           {
                       
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
                                {
                                
                                    String update = "UPDATE planningds SET `j6s1`='1', `j6s2`='1' where nomcomplt like '%"+E[l]+"%' ";
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
                                       {
                                        String update = "UPDATE planningds SET j6s1='1' where nomcomplt like '%"+E[l]+"%' ";
                                        pst = connection.prepareStatement(update);
                                        pst.execute();
                               
                                    }catch (SQLException e)
                                            {e.printStackTrace();}
                                        l++;
                                }
                        }
                        }
                        else
                   if(A[compteur].equals("S2"))
                           {  
                               String Ens = K(G[i],A[compteur]);
                               String[] E =Ens.split("  ");
                                
                                        while(l1<E.length)
                                        {
                                            
                                            String nom =GradeEns(E[l1]);
                                            if(!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences"))
                                                {
                                                    try
                                                    {
                                                        String update = "UPDATE planningds SET `j6s1`='1', `j6s2`='1' where nomcomplt like '%"+E[l1]+"%' ";
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
                                                    {
                                                        String update = "UPDATE planningds SET j6s2='1' where nomcomplt like '%"+E[l1]+"%' ";
                           
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                               
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();}
                                                    l1++;
                                                }
                                        }
                                    
                           }else if(A[compteur].equals("S3"))
                           {    
                               String Ens = K(G[i],A[compteur]);
                               String[] E =Ens.split("  ");
                                
                                        while(l2<E.length)
                                        {
                                
                                            String nom =GradeEns(E[l2]);
                                            if(!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences"))
                                                {
                                                    try
                                                    {
                                                        String update = "UPDATE planningds SET `j6s2`='1', `j6s3`='1' where nomcomplt like '%"+E[l2]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();
                                                            }
                                                    l2++;
                                                }
                                            else
                                                {
                                                    try
                                                    {   String update = "UPDATE planningds SET j6s3='1' where nomcomplt like '%"+E[l2]+"%' ";
                           
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                               
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();}
                                                    l2++;
                                                }
                                        }
                                    
                           }else if(A[compteur].equals("S4"))
                           {    
                               String Ens = K(G[i],A[compteur]);
                               String[] E =Ens.split("  ");
                                
                                        while(k<E.length)
                                        {
                                           
                                            String nom =GradeEns(E[l3]);
                                            if(!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences"))
                                                {
                                                    try
                                                    {   String update = "UPDATE planningds SET `j6s3`='1', `j6s4`='1' where nomcomplt like '%"+E[l3]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();
                                                            }
                                                    l3++;
                                                }
                                            else
                                                {
                                                    try
                                                    {
                                                        String update = "UPDATE planningds SET j6s4='1' where nomcomplt like '%"+E[l3]+"%' ";
                           
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                               
                                                    }catch (SQLException e)
                                                            {e.printStackTrace();}
                                                    l3++;
                                                }}}
               compteur++;}break;}i=i+2;
    }
    }
private int nombensg(String d)
   {String k="";
 int i=0;
  String insert = "Select count('"+d+"') from planningds where "+d+"='1'";
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
            String insert = "SELECT sum(j1s1 + j1s2+j1s3+j1s4+j2s1 +j2s2 +j2s3+j2s4+j3s1 +j3s2+j3s3+j3s4+j4s1+j4s2+j4s3+j4s4+j5s1 +j5s2+j5s3+j5s4+j6s1 +j6s2+j6s3+j6s4) from  planningds where nomcomplt like '%"+nomc+"%'";
        try
        {  
            pst = connection.prepareStatement(insert);
            rs=pst.executeQuery();
            while(rs.next())
            {
                N=rs.getString("sum(j1s1 + j1s2+j1s3+j1s4+j2s1 +j2s2 +j2s3+j2s4+j3s1 +j3s2+j3s3+j3s4+j4s1+j4s2+j4s3+j4s4+j5s1 +j5s2+j5s3+j5s4+j6s1 +j6s2+j6s3+j6s4)");
                }
        }
        catch (SQLException e1)
            {
                e1.printStackTrace();
            }
i = Integer.parseInt(N);
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
   int i=0;
   
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
   int i=0;
   
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
   
   return i;
   }
   
private int Salle2m(String Date,String S)
   {int i;
   int j= S2Mecom(Date,S),d=S2Mbds(Date,S),e=S2wi(Date,S),c=S2vic(Date,S);
   i=j+d+e+c;
   
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
   
   return i;
   }
   private int Salle3eme(String Date,String S)
   {int i;
   int j= nb3l(Date,S),d=nb31(Date,S),e=nb32(Date,S);
   i=j+d+e;
   
   return i;
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
   return i;
   }
   private boolean existe(String Jour,String nom)
{boolean S;
    int i=exp(Jour,nom);
    if(i==0){
    return false;
    }return true;
}
private int exp(String Jour,String nom)
   {String M="";
   int i=0;
   
     try {
                pst = connection.prepareStatement("SELECT count("+Jour+") from planningds where nomcomplt like '%"+nom+"%' and "+Jour+" ='1' ");
                 rs = pst.executeQuery();
                
                 rs = pst.executeQuery();
                 while(rs.next())
                {   
                M=rs.getString("count("+Jour+")");
                  }
   } catch (SQLException ex) {
                    ex.printStackTrace();
                }
   i = Integer.parseInt(M);
   return i;
   }

   private void PlanningSeance()
   {
       String S = Jour6();
       String[] G =S.split(" ");
       int i=0,j=1,g,a=1,l=1,c=1,z=1,q=1,h=1;
        while(i<=G.length)
        {
            if(i==0)
                {
                  
                        String hor=horaire1S1();
                        String []A=hor.split(" ");

                        int cop=1;
                        while(cop<A.length)
                        {
                            if(A[cop].equals("S1"))
                            {   int K=nombensg("j1s1");  
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
                                       int nbsur=nbSurvillance(lis[n]);
                                        
                                        String nom =GradeEns(lis[n]);
                                        int max=maxsurgrade(nom);
                                        boolean SS=existe("j1s1",lis[n]);
                                        boolean SSS=existe("j1s2",lis[n]);
                                     boolean SSSS=existe("j1s3",lis[n]);
                                        boolean SSSSS=existe("j1s4",lis[n]);
                                     
                                        if((!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences")))
                                        {
                                                if(nbsur<=max && ((SS==false && SSS==false) && (SSSS==false&& SSSSS==false)))
                                                {

                                                        try{String update = "UPDATE planningds SET j1s1='1',j1s2='1',j1s3='1' where nomcomplt  like '%"+lis[n]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                        } catch (SQLException e)
                                                        {
                                                            e.printStackTrace();

                                                        }
                                                        s++;
                                                }else if(nbsur<=max &&( (SSS==true && SSSS==true)&&SSSSS==false))
                                                {
                                                            try{
                                                        String update = "UPDATE planningds SET j1s1='1' where nomcomplt  like '%"+lis[n]+"%' ";
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
              { 
                  int K=nombensg("j1s2");  
                  int nbsalle1=nombsalle(G[i+1],A[cop]);
                  int nbsalle2=nombsalle1(G[i+1],A[cop]);
                  int nbsalle3=Salle2eme(G[i+1],A[cop]);
                  int nbsalle4=Salle3eme(G[i+1],A[cop]);
                  int nbsalle5=Salle1M(G[i+1],A[cop]);
                  int nbsalle6=Salle2m(G[i+1],A[cop]);
                  String dispens =ensgdisp(G[i]);
                  String []lis=dispens.split("  ");
                  int nombre=0,n1=0;
                  int s1=K+nombre;
                  int nb=(nbsalle1+nbsalle2+nbsalle3+nbsalle4+nbsalle5+nbsalle6)*2;
                  while(nb!=0&&s1<=nb)
                    {
                       
                        int nbsur=nbSurvillance(lis[n1]);
                        
                        String nom =GradeEns(lis[n1]);
                        int max=maxsurgrade(nom);

                        boolean SS=existe("j1s1",lis[n1]);
                        
                        boolean SSS=existe("j1s2",lis[n1]);
                       
                        boolean SSSS=existe("j1s3",lis[n1]);
                       
                        boolean SSSSS=existe("j1s4",lis[n1]);
                       

                        if((!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences")))
                            { 

                                    if(nbsur<=max && ((SS==false && SSS==false) && (SSSS==false&& SSSSS==false)))
                                    {
                                        try
                                        {
                                           
                                            String update = "UPDATE planningds SET`j1s2`='1',j1s3='1',j1s4='1' where nomcomplt  like '%"+lis[n1]+"%' ";
                                            pst = connection.prepareStatement(update);
                                            pst.execute();
                                       } catch (SQLException e)
                                       {
                                           e.printStackTrace();

                                       }
                                       s1++;
                                    }else

                                    if(nbsur<=max && ((SS==false&&SSS==false) && (SSSS==true && SSSSS==true) ))
                                    {
                                        try
                                        {
                                            String update = "UPDATE planningds SET j1s2='1' where nomcomplt  like '%"+lis[n1]+"%' ";
                                            pst = connection.prepareStatement(update);
                                            pst.execute();
                                       } catch (SQLException e)
                                       {
                                           e.printStackTrace();

                                       }
                                       s1++;
                                    }else if(nbsur<=max &&( (SSS==true && SSSS==true)&&(SSSSS==false&&SS==false)))
                                                {
                                                            try{
                                                                
                                                        String update = "UPDATE planningds SET j1s4='1' where nomcomplt  like '%"+lis[n1]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                        } catch (SQLException e)
                                                        {
                                                            e.printStackTrace();

                                                        }
                                                        s1++;

                                                }
                            }
               n1++;
                    }
              }else
                  if(A[cop].equals("S3"))
                            {   
                                int K=nombensg("j1s3");  
                                int nbsalle1=nombsalle(G[i+1],A[cop]);
                                int nbsalle2=nombsalle1(G[i+1],A[cop]);
                                int nbsalle3=Salle2eme(G[i+1],A[cop]);
                                int nbsalle4=Salle3eme(G[i+1],A[cop]);
                                int nbsalle5=Salle1M(G[i+1],A[cop]);
                                int nbsalle6=Salle2m(G[i+1],A[cop]);
                                String dispens =ensgdisp(G[i]);
                                String []lis=dispens.split("  ");
                                int nombre=0,n2=0;
                                int s2=K+nombre;
                                int nb=(nbsalle1+nbsalle2+nbsalle3+nbsalle4+nbsalle5+nbsalle6)*2;
                                while(nb!=0&&s2<nb)
                                {
                                        int nbsur=nbSurvillance(lis[n2]);
                                        String nom =GradeEns(lis[n2]);
                                        int max=maxsurgrade(nom);
                                        boolean SS=existe("j1s1",lis[n2]);
                                 
                                    boolean SSS=existe("j1s2",lis[n2]);
                                    
                                    boolean SSSS=existe("j1s3",lis[n2]);
                                    
                                    boolean SSSSS=existe("j1s4",lis[n2]);
                                    
                                    
                                    if((!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences")))
                                        { 
                                        if(nbsur<=max && ((SS==false && SSS==false) && (SSSS==false&& SSSSS==false)))
                                                {
                                                    try
                                                    {
                                                        
                                                        String update = "UPDATE planningds SET j1s1='1',`j1s2`='1',j1s3='1' where nomcomplt  like '%"+lis[n2]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                   } catch (SQLException e)
                                                   {
                                                       e.printStackTrace();

                                                   }
                                                   s2++;
                                                }else

                                                if(nbsur<=max && (((SS==true &&SSS==true)&& (SSSS==false&& SSSSS==false)) ))
                                                {
                                                    try
                                                    {
                                                       
                                                        String update = "UPDATE planningds SET j1s3='1' where nomcomplt  like '%"+lis[n2]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                   } catch (SQLException e)
                                                   {
                                                       e.printStackTrace();

                                                   }
                                                   s2++;
                                                }
                                    else if(nbsur<=max &&( (SSS==true && SSSS==true)&&(SSSSS==false&&SS==false)))
                                                {
                                                            try{
                                                        String update = "UPDATE planningds SET j1s1='1' where nomcomplt  like '%"+lis[n2]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                        } catch (SQLException e)
                                                        {
                                                            e.printStackTrace();

                                                        }
                                                        s2++;

                                                }
                                        }
                           n2++;
                                }}
              else if (A[cop].equals("S4"))
              {   int K=nombensg("j1s4");  
                  int nbsalle1=nombsalle(G[i+1],A[cop]);
                  int nbsalle2=nombsalle1(G[i+1],A[cop]);
                  int nbsalle3=Salle2eme(G[i+1],A[cop]);
                  int nbsalle4=Salle3eme(G[i+1],A[cop]);
                  int nbsalle5=Salle1M(G[i+1],A[cop]);
                  int nbsalle6=Salle2m(G[i+1],A[cop]);
                  String dispens =ensgdisp(G[i]);
                  String []lis=dispens.split("  ");
                  int nombre=0,n3=0;
                  int s3=K+nombre;
                  int nb=(nbsalle1+nbsalle2+nbsalle3+nbsalle4+nbsalle5+nbsalle6)*2;
                  while(nb!=0&&s3<=nb)
                    {
                        int nbsur=nbSurvillance(lis[n3]);
                        String nom =GradeEns(lis[n3]);
                        int max=maxsurgrade(nom);
                        boolean SS=existe("j1s1",lis[n3]);
                        boolean SSS=existe("j1s2",lis[n3]);
                        boolean SSSS=existe("j1s3",lis[n3]);
                        boolean SSSSS=existe("j1s4",lis[n3]);
                 
                      
                        if((!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences")))
                            { if(nbsur<=max && ((SS==false && SSS==false)&&(SSSS==false&&SSSSS==false) ))
                                    {
                                        try
                                        {
                              
                                            String update = "UPDATE planningds SET`j1s2`='1',j1s3='1',j1s4='1' where nomcomplt  like '%"+lis[n3]+"%' ";
                                            pst = connection.prepareStatement(update);
                                            pst.execute();
                                       } catch (SQLException e)
                                       {
                                           e.printStackTrace();

                                       }
                                       s3++;
                                    }else

                                    if(nbsur<=max && ((SSSSS==true && SSSS==true)&&(SS==false&&SSS==false) ))
                                    {
                                        try
                                        {
                                            
                                            String update = "UPDATE planningds SET j1s2='1' where nomcomplt  like '%"+lis[n3]+"%' ";
                                            pst = connection.prepareStatement(update);
                                            pst.execute();
                                       } catch (SQLException e)
                                       {
                                           e.printStackTrace();

                                       }
                                       s3++;

                                    }else if(nbsur<=max &&( (SSS==true && SSSS==true)&&(SSSSS==false&&SS==false)))
                                                {
                                                            try{
                                                        String update = "UPDATE planningds SET j1s4='1' where nomcomplt  like '%"+lis[n3]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                        } catch (SQLException e)
                                                        {
                                                            e.printStackTrace();

                                                        }
                                                        s3++;

                                                }
                            }
               n3++;
                    }
              }
              cop++;}

        }
 else 
            if(i==2)
                {
                        String hor=horaire1S1();
                        String []A=hor.split(" ");

                        int cop=1;
                        while(cop<A.length)
                        {
                            if(A[cop].equals("S1"))
                            {  int K=nombensg("j2s1");  
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

                                        int nbsur=nbSurvillance(lis[n]);
                                        
                                        String nom =GradeEns(lis[n]);
                                        int max=maxsurgrade(nom);
                                        boolean SS=existe("j2s1",lis[n]);
                                       
                                        boolean SSS=existe("j2s2",lis[n]);
                                        
                                        boolean SSSS=existe("j2s3",lis[n]);
                                        
                                        boolean SSSSS=existe("j2s4",lis[n]);
                                    
                                        if((!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences")))
                                        {
                                 
                                            if(nbsur<=max && ((SS==false && SSS==false) && (SSSS==false&& SSSSS==false)))
                                                {

                                                        try{
                                                            
                                                        String update = "UPDATE planningds SET j2s1='1',j2s2='1',j2s3='1' where nomcomplt  like '%"+lis[n]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                        } catch (SQLException e)
                                                        {
                                                            e.printStackTrace();

                                                        }
                                                        s++;
                                                }else if(nbsur<=max &&( (SSS==true && SSSS==true)&&SSSSS==false))
                                                {
                                                            try{
                                                        String update = "UPDATE planningds SET j2s1='1' where nomcomplt  like '%"+lis[n]+"%' ";
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
              {  int K=nombensg("j2s2");  
                  int nbsalle1=nombsalle(G[i+1],A[cop]);
                  int nbsalle2=nombsalle1(G[i+1],A[cop]);
                  int nbsalle3=Salle2eme(G[i+1],A[cop]);
                  int nbsalle4=Salle3eme(G[i+1],A[cop]);
                  int nbsalle5=Salle1M(G[i+1],A[cop]);
                  int nbsalle6=Salle2m(G[i+1],A[cop]);
                  String dispens =ensgdisp(G[i]);
                  String []lis=dispens.split("  ");
                  int nombre=0,n1=0;
                  int s1=K+nombre;
                  int nb=(nbsalle1+nbsalle2+nbsalle3+nbsalle4+nbsalle5+nbsalle6)*2;
                  while(nb!=0&&s1<=nb)
                    {
                        int nbsur=nbSurvillance(lis[n1]);
                       
                        String nom =GradeEns(lis[n1]);
                        int max=maxsurgrade(nom);

                        boolean SS=existe("j2s1",lis[n1]);
                      
                        boolean SSS=existe("j2s2",lis[n1]);
                        
                        boolean SSSS=existe("j2s3",lis[n1]);
                       
                      boolean SSSSS=existe("j2s4",lis[n1]);
                      
                        if((!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences")))
                            {       if(nbsur<=max && ((SS==false && SSS==false) && (SSSS==false&& SSSSS==false)))
                                    {
                                        try
                                        {
                                            String update = "UPDATE planningds SET`j2s2`='1',j2s3='1',j2s4='1' where nomcomplt  like '%"+lis[n1]+"%' ";
                                            pst = connection.prepareStatement(update);
                                            pst.execute();
                                       } catch (SQLException e)
                                       {
                                           e.printStackTrace();

                                       }
                                       s1++;
                                    }else

                                    if(nbsur<=max && ((SS==false&&SSS==false) && (SSSS==true && SSSSS==true) ))
                                    {
                                        try
                                        {
                                           
                                            String update = "UPDATE planningds SET j2s2='1' where nomcomplt  like '%"+lis[n1]+"%' ";
                                            pst = connection.prepareStatement(update);
                                            pst.execute();
                                       } catch (SQLException e)
                                       {
                                           e.printStackTrace();

                                       }
                                       s1++;
                                    }else if(nbsur<=max &&( (SSS==true && SSSS==true)&&(SSSSS==false&&SS==false)))
                                                {
                                                            try{
                                                        String update = "UPDATE planningds SET j2s4='1' where nomcomplt  like '%"+lis[n1]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                        } catch (SQLException e)
                                                        {
                                                            e.printStackTrace();

                                                        }
                                                        s1++;

                                                }
                            }
               n1++;
                    }
              }else
                  if(A[cop].equals("S3"))
                            {  
                                int K=nombensg("j1s3");  
                                int nbsalle1=nombsalle(G[i+1],A[cop]);
                                int nbsalle2=nombsalle1(G[i+1],A[cop]);
                                int nbsalle3=Salle2eme(G[i+1],A[cop]);
                                int nbsalle4=Salle3eme(G[i+1],A[cop]);
                                int nbsalle5=Salle1M(G[i+1],A[cop]);
                                int nbsalle6=Salle2m(G[i+1],A[cop]);
                                String dispens =ensgdisp(G[i]);
                                String []lis=dispens.split("  ");
                                int nombre=0,n2=0;
                                int s2=K+nombre;
                                int nb=(nbsalle1+nbsalle2+nbsalle3+nbsalle4+nbsalle5+nbsalle6)*2;
                                while(nb!=0&&s2<nb)
                                {int nbsur=nbSurvillance(lis[n2]);
                                        String nom =GradeEns(lis[n2]);
                                        int max=maxsurgrade(nom);
                                        boolean SS=existe("j2s1",lis[n2]);
                                        boolean SSS=existe("j2s2",lis[n2]);
                                        boolean SSSS=existe("j2s3",lis[n2]);
                                        boolean SSSSS=existe("j2s4",lis[n2]);
                                 
                                    if((!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences")))
                                        {   if(nbsur<=max && ((SS==false && SSS==false) && (SSSS==false&& SSSSS==false)))
                                                {
                                                    try
                                                    {   String update = "UPDATE planningds SET j2s1='1',`j2s2`='1',j2s3='1' where nomcomplt  like '%"+lis[n2]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                   } catch (SQLException e)
                                                   {
                                                       e.printStackTrace();

                                                   }
                                                   s2++;
                                                }else

                                                if(nbsur<=max && (((SS==true &&SSS==true)&& (SSSS==false&& SSSSS==false)) ))
                                                {
                                                    try
                                                    {
                                                     
                                                        String update = "UPDATE planningds SET j2s3='1' where nomcomplt  like '%"+lis[n2]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                   } catch (SQLException e)
                                                   {
                                                       e.printStackTrace();

                                                   }
                                                   s2++;
                                                }
                                    else if(nbsur<=max &&( (SSS==true && SSSS==true)&&(SSSSS==false&&SS==false)))
                                                {
                                                            try{
                                                        String update = "UPDATE planningds SET j2s1='1' where nomcomplt  like '%"+lis[n2]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                        } catch (SQLException e)
                                                        {
                                                            e.printStackTrace();

                                                        }
                                                        s2++;

                                                }
                                        }
                           n2++;
                                }}
              else if (A[cop].equals("S4"))
              {  
                  int K=nombensg("j2s4");  
                  int nbsalle1=nombsalle(G[i+1],A[cop]);
                  int nbsalle2=nombsalle1(G[i+1],A[cop]);
                  int nbsalle3=Salle2eme(G[i+1],A[cop]);
                  int nbsalle4=Salle3eme(G[i+1],A[cop]);
                  int nbsalle5=Salle1M(G[i+1],A[cop]);
                  int nbsalle6=Salle2m(G[i+1],A[cop]);
                  String dispens =ensgdisp(G[i]);
                  String []lis=dispens.split("  ");
                  int nombre=0,n3=0;
                  int s3=K+nombre;
                  int nb=(nbsalle1+nbsalle2+nbsalle3+nbsalle4+nbsalle5+nbsalle6)*2;
                  while(nb!=0&&s3<=nb)
                    {
                      
                        int nbsur=nbSurvillance(lis[n3]);
                
                        String nom =GradeEns(lis[n3]);
                        int max=maxsurgrade(nom);
                        boolean SS=existe("j2s1",lis[n3]);
                        
                        boolean SSS=existe("j2s2",lis[n3]);
                    
                        boolean SSSS=existe("j2s3",lis[n3]);
                       
                        boolean SSSSS=existe("j2s4",lis[n3]);
                       

                        if((!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences")))
                            { 
                                    if(nbsur<=max && ((SS==false && SSS==false)&&(SSSS==false&&SSSSS==false) ))
                                    {
                                        try
                                        {
                                          
                                            String update = "UPDATE planningds SET`j2s2`='1',j1s3='1',j2s4='1' where nomcomplt  like '%"+lis[n3]+"%' ";
                                            pst = connection.prepareStatement(update);
                                            pst.execute();
                                       } catch (SQLException e)
                                       {
                                           e.printStackTrace();

                                       }
                                       s3++;
                                    }else

                                    if(nbsur<=max && ((SSSSS==true && SSSS==true)&&(SS==false&&SSS==false) ))
                                    {
                                        try
                                        {  String update = "UPDATE planningds SET j2s2='1' where nomcomplt  like '%"+lis[n3]+"%' ";
                                            pst = connection.prepareStatement(update);
                                            pst.execute();
                                       } catch (SQLException e)
                                       {
                                           e.printStackTrace();

                                       }
                                       s3++;

                                    }else if(nbsur<=max &&( (SSS==true && SSSS==true)&&(SSSSS==false&&SS==false)))
                                                {
                                                            try{
                                                        String update = "UPDATE planningds SET j2s4='1' where nomcomplt  like '%"+lis[n3]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                        } catch (SQLException e)
                                                        {
                                                            e.printStackTrace();

                                                        }
                                                        s3++;

                                                }
                            }
               n3++;
                    }
              }
              cop++;}
                }
        else if(i==4)
        {              
                        String hor=horaire1S1();
                        String []A=hor.split(" ");

                        int cop=1;
                        while(cop<A.length)
                        {
                            if(A[cop].equals("S1"))
                            {   int K=nombensg("j3s1");  
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

                                        int nbsur=nbSurvillance(lis[n]);
                                        String nom =GradeEns(lis[n]);
                                        int max=maxsurgrade(nom);
                                        boolean SS=existe("j3s1",lis[n]);
                                        boolean SSS=existe("j3s2",lis[n]);
                                        boolean SSSS=existe("j3s3",lis[n]);
                                        boolean SSSSS=existe("j3s4",lis[n]);
                              
                                        if((!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences")))
                                        {
                                            
                                                if(nbsur<=max && ((SS==false && SSS==false) && (SSSS==false&& SSSSS==false)))
                                                {

                                                        try{
                                                        String update = "UPDATE planningds SET j3s1='1',j3s2='1',j3s3='1' where nomcomplt  like '%"+lis[n]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                        } catch (SQLException e)
                                                        {
                                                            e.printStackTrace();

                                                        }
                                                        s++;
                                                }else if(nbsur<=max &&( (SSS==true && SSSS==true)&&SSSSS==false))
                                                {
                                                            try{
                                                        String update = "UPDATE planningds SET j3s1='1' where nomcomplt  like '%"+lis[n]+"%' ";
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
              {  
                  int K=nombensg("j3s2");  
                  int nbsalle1=nombsalle(G[i+1],A[cop]);
                  int nbsalle2=nombsalle1(G[i+1],A[cop]);
                  int nbsalle3=Salle2eme(G[i+1],A[cop]);
                  int nbsalle4=Salle3eme(G[i+1],A[cop]);
                  int nbsalle5=Salle1M(G[i+1],A[cop]);
                  int nbsalle6=Salle2m(G[i+1],A[cop]);
                  String dispens =ensgdisp(G[i]);
                  String []lis=dispens.split("  ");
                  int nombre=0,n1=0;
                  int s1=K+nombre;
                  int nb=(nbsalle1+nbsalle2+nbsalle3+nbsalle4+nbsalle5+nbsalle6)*2;
                  while(nb!=0&&s1<=nb)
                    {
                       
                        int nbsur=nbSurvillance(lis[n1]);
                        String nom =GradeEns(lis[n1]);
                        int max=maxsurgrade(nom);

                        boolean SS=existe("j3s1",lis[n1]);
                        boolean SSS=existe("j3s2",lis[n1]);
                        boolean SSSS=existe("j3s3",lis[n1]);
                        boolean SSSSS=existe("j3s4",lis[n1]);
                       
                        if((!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences")))
                            { 
                            

                                    if(nbsur<=max && ((SS==false && SSS==false) && (SSSS==false&& SSSSS==false)))
                                    {
                                        try
                                        {
                                         
                                            String update = "UPDATE planningds SET`j3s2`='1',j3s3='1',j3s4='1' where nomcomplt  like '%"+lis[n1]+"%' ";
                                            pst = connection.prepareStatement(update);
                                            pst.execute();
                                       } catch (SQLException e)
                                       {
                                           e.printStackTrace();

                                       }
                                       s1++;
                                    }else

                                    if(nbsur<=max && ((SS==false&&SSS==false) && (SSSS==true && SSSSS==true) ))
                                    {
                                        try
                                        {
                                            String update = "UPDATE planningds SET j3s2='1' where nomcomplt  like '%"+lis[n1]+"%' ";
                                            pst = connection.prepareStatement(update);
                                            pst.execute();
                                       } catch (SQLException e)
                                       {
                                           e.printStackTrace();

                                       }
                                       s1++;
                                    }else if(nbsur<=max &&( (SSS==true && SSSS==true)&&(SSSSS==false&&SS==false)))
                                                {
                                                            try{
                                                                
                                                        String update = "UPDATE planningds SET j3s4='1' where nomcomplt  like '%"+lis[n1]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                        } catch (SQLException e)
                                                        {
                                                            e.printStackTrace();

                                                        }
                                                        s1++;

                                                }}
               n1++;
                    }
              }else
                  if(A[cop].equals("S3"))
                            {  
                                int K=nombensg("j3s3");  
                                int nbsalle1=nombsalle(G[i+1],A[cop]);
                                int nbsalle2=nombsalle1(G[i+1],A[cop]);
                                int nbsalle3=Salle2eme(G[i+1],A[cop]);
                                int nbsalle4=Salle3eme(G[i+1],A[cop]);
                                int nbsalle5=Salle1M(G[i+1],A[cop]);
                                int nbsalle6=Salle2m(G[i+1],A[cop]);
                                String dispens =ensgdisp(G[i]);
                                String []lis=dispens.split("  ");
                                int nombre=0,n2=0;
                                int s2=K+nombre;
                                int nb=(nbsalle1+nbsalle2+nbsalle3+nbsalle4+nbsalle5+nbsalle6)*2;
                                while(nb!=0&&s2<nb)
                                {

                                        int nbsur=nbSurvillance(lis[n2]);
                                      
                                        String nom =GradeEns(lis[n2]);
                                        int max=maxsurgrade(nom);
                                        boolean SS=existe("j3s1",lis[n2]);
                                       
                                        boolean SSS=existe("j3s2",lis[n2]);
                                       
                                    boolean SSSS=existe("j3s3",lis[n2]);
                                    
                                    boolean SSSSS=existe("j3s4",lis[n2]);
                                        
                                    if((!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences")))
                                        {   if(nbsur<=max && ((SS==false && SSS==false) && (SSSS==false&& SSSSS==false)))
                                                {
                                                    try
                                                    {
                                                      
                                                        String update = "UPDATE planningds SET j3s1='1',`j3s2`='1',j3s3='1' where nomcomplt  like '%"+lis[n2]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                   } catch (SQLException e)
                                                   {
                                                       e.printStackTrace();

                                                   }
                                                   s2++;
                                                }else

                                                if(nbsur<=max && (((SS==true &&SSS==true)&& (SSSS==false&& SSSSS==false)) ))
                                                {
                                                    try
                                                    {
                                                      
                                                        String update = "UPDATE planningds SET j3s3='1' where nomcomplt  like '%"+lis[n2]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                   } catch (SQLException e)
                                                   {
                                                       e.printStackTrace();

                                                   }
                                                   s2++;
                                                }
                                    else if(nbsur<=max &&( (SSS==true && SSSS==true)&&(SSSSS==false&&SS==false)))
                                                {
                                                            try{
                                                        String update = "UPDATE planningds SET j3s1='1' where nomcomplt  like '%"+lis[n2]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                        } catch (SQLException e)
                                                        {
                                                            e.printStackTrace();

                                                        }
                                                        s2++;

                                                }
                                        }
                           n2++;
                                }}
              else if (A[cop].equals("S4"))
              {   
                  int K=nombensg("j3s4");  
                  int nbsalle1=nombsalle(G[i+1],A[cop]);
                  int nbsalle2=nombsalle1(G[i+1],A[cop]);
                  int nbsalle3=Salle2eme(G[i+1],A[cop]);
                  int nbsalle4=Salle3eme(G[i+1],A[cop]);
                  int nbsalle5=Salle1M(G[i+1],A[cop]);
                  int nbsalle6=Salle2m(G[i+1],A[cop]);
                  String dispens =ensgdisp(G[i]);
                  String []lis=dispens.split("  ");
                  int nombre=0,n3=0;
                  int s3=K+nombre;
                  int nb=(nbsalle1+nbsalle2+nbsalle3+nbsalle4+nbsalle5+nbsalle6)*2;
                  while(nb!=0&&s3<=nb)
                    {
                        int nbsur=nbSurvillance(lis[n3]);
                        String nom =GradeEns(lis[n3]);
                        int max=maxsurgrade(nom);
                        boolean SS=existe("j3s1",lis[n3]);
                  
                      boolean SSS=existe("j3s2",lis[n3]);
                        boolean SSSS=existe("j3s3",lis[n3]);
                        boolean SSSSS=existe("j3s4",lis[n3]);
                        if((!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences")))
                            { 
                                    if(nbsur<=max && ((SS==false && SSS==false)&&(SSSS==false&&SSSSS==false) ))
                                    {
                                        try
                                        {
                                          
                                            String update = "UPDATE planningds SET`j3s2`='1',j3s3='1',j3s4='1' where nomcomplt  like '%"+lis[n3]+"%' ";
                                            pst = connection.prepareStatement(update);
                                            pst.execute();
                                       } catch (SQLException e)
                                       {
                                           e.printStackTrace();

                                       }
                                       s3++;
                                    }else

                                    if(nbsur<=max && ((SSSSS==true && SSSS==true)&&(SS==false&&SSS==false) ))
                                    {
                                        try
                                        {
                                            String update = "UPDATE planningds SET j3s2='1' where nomcomplt  like '%"+lis[n3]+"%' ";
                                            pst = connection.prepareStatement(update);
                                            pst.execute();
                                       } catch (SQLException e)
                                       {
                                           e.printStackTrace();

                                       }
                                       s3++;

                                    }else if(nbsur<=max &&( (SSS==true && SSSS==true)&&(SSSSS==false&&SS==false)))
                                                {
                                                            try{
                                                        String update = "UPDATE planningds SET j3s4='1' where nomcomplt  like '%"+lis[n3]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                        } catch (SQLException e)
                                                        {
                                                            e.printStackTrace();

                                                        }
                                                        s3++;

                                                }
                            }
               n3++;
                    }
              }
              cop++;}

       }
        else 
            if(i==6)
                {
                       
                        String hor=horaire1S1();
                        String []A=hor.split(" ");

                        int cop=1;
                        while(cop<A.length)
                        {
                            if(A[cop].equals("S1"))
                            {                                   int K=nombensg("j4s1");  
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
                                {   int nbsur=nbSurvillance(lis[n]);
                                        String nom =GradeEns(lis[n]);
                                        int max=maxsurgrade(nom);
                                        boolean SS=existe("j4s1",lis[n]);
                                 
                                 boolean SSS=existe("j4s2",lis[n]);
                                 
                                 boolean SSSS=existe("j4s3",lis[n]);
                                 
                                 boolean SSSSS=existe("j4s4",lis[n]);
                                 
                                 
                                        if((!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences")))
                                        {
                                 
                                            if(nbsur<=max && ((SS==false && SSS==false) && (SSSS==false&& SSSSS==false)))
                                                {

                                                        try{
                                                        String update = "UPDATE planningds SET j4s1='1',j4s2='1',j4s3='1' where nomcomplt  like '%"+lis[n]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                        } catch (SQLException e)
                                                        {
                                                            e.printStackTrace();

                                                        }
                                                        s++;
                                                }else if(nbsur<=max &&( (SSS==true && SSSS==true)&&SSSSS==false))
                                                {
                                                            try{
                                                        String update = "UPDATE planningds SET j4s1='1' where nomcomplt  like '%"+lis[n]+"%' ";
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
              {   
                  int K=nombensg("j4s2");  
                  int nbsalle1=nombsalle(G[i+1],A[cop]);
                  int nbsalle2=nombsalle1(G[i+1],A[cop]);
                  int nbsalle3=Salle2eme(G[i+1],A[cop]);
                  int nbsalle4=Salle3eme(G[i+1],A[cop]);
                  int nbsalle5=Salle1M(G[i+1],A[cop]);
                  int nbsalle6=Salle2m(G[i+1],A[cop]);
                  String dispens =ensgdisp(G[i]);
                  String []lis=dispens.split("  ");
                  int nombre=0,n1=0;
                  int s1=K+nombre;
                  int nb=(nbsalle1+nbsalle2+nbsalle3+nbsalle4+nbsalle5+nbsalle6)*2;
                  while(nb!=0&&s1<=nb)
                    {
                       
                        int nbsur=nbSurvillance(lis[n1]);
                        String nom =GradeEns(lis[n1]);
                        int max=maxsurgrade(nom);

                        boolean SS=existe("j4s1",lis[n1]);
                        boolean SSS=existe("j4s2",lis[n1]);
                        boolean SSSS=existe("j4s3",lis[n1]);
                        boolean SSSSS=existe("j4s4",lis[n1]);
                    
                        if((!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences")))
                            { 
                            
                                    if(nbsur<=max && ((SS==false && SSS==false) && (SSSS==false&& SSSSS==false)))
                                    {
                                        try
                                        {
                                          
                                            String update = "UPDATE planningds SET`j4s2`='1',j4s3='1',j4s4='1' where nomcomplt  like '%"+lis[n1]+"%' ";
                                            pst = connection.prepareStatement(update);
                                            pst.execute();
                                       } catch (SQLException e)
                                       {
                                           e.printStackTrace();

                                       }
                                       s1++;
                                    }else

                                    if(nbsur<=max && ((SS==false&&SSS==false) && (SSSS==true && SSSSS==true) ))
                                    {
                                        try
                                        {
                                           
                                            String update = "UPDATE planningds SET j4s2='1' where nomcomplt  like '%"+lis[n1]+"%' ";
                                            pst = connection.prepareStatement(update);
                                            pst.execute();
                                       } catch (SQLException e)
                                       {
                                           e.printStackTrace();

                                       }
                                       s1++;
                                    }else if(nbsur<=max &&( (SSS==true && SSSS==true)&&(SSSSS==false&&SS==false)))
                                                {
                                                            try{
                                                        String update = "UPDATE planningds SET j4s4='1' where nomcomplt  like '%"+lis[n1]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                        } catch (SQLException e)
                                                        {
                                                            e.printStackTrace();

                                                        }
                                                        s1++;

                                                }
                            }
               n1++;
                    }
              }else
                  if(A[cop].equals("S3"))
                            { 
                                int K=nombensg("j4s3");  
                                int nbsalle1=nombsalle(G[i+1],A[cop]);
                                int nbsalle2=nombsalle1(G[i+1],A[cop]);
                                int nbsalle3=Salle2eme(G[i+1],A[cop]);
                                int nbsalle4=Salle3eme(G[i+1],A[cop]);
                                int nbsalle5=Salle1M(G[i+1],A[cop]);
                                int nbsalle6=Salle2m(G[i+1],A[cop]);
                                String dispens =ensgdisp(G[i]);
                                String []lis=dispens.split("  ");
                                int nombre=0,n2=0;
                                int s2=K+nombre;
                                int nb=(nbsalle1+nbsalle2+nbsalle3+nbsalle4+nbsalle5+nbsalle6)*2;
                                while(nb!=0&&s2<nb)
                                {
          int nbsur=nbSurvillance(lis[n2]);

                                    String nom =GradeEns(lis[n2]);
                                        int max=maxsurgrade(nom);
                                        boolean SS=existe("j4s1",lis[n2]);
                                    
                                    boolean SSS=existe("j4s2",lis[n2]);
                                        boolean SSSS=existe("j4s3",lis[n2]);
                                        boolean SSSSS=existe("j4s4",lis[n2]);
                                    if((!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences")))
                                        {   if(nbsur<=max && ((SS==false && SSS==false) && (SSSS==false&& SSSSS==false)))
                                                {
                                                    try
                                                    {
                                                        
                                                        String update = "UPDATE planningds SET j4s1='1',`j4s2`='1',j4s3='1' where nomcomplt  like '%"+lis[n2]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                   } catch (SQLException e)
                                                   {
                                                       e.printStackTrace();

                                                   }
                                                   s2++;
                                                }else

                                                if(nbsur<=max && (((SS==true &&SSS==true)&& (SSSS==false&& SSSSS==false)) ))
                                                {
                                                    try
                                                    {
                                                        String update = "UPDATE planningds SET j4s3='1' where nomcomplt  like '%"+lis[n2]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                   } catch (SQLException e)
                                                   {
                                                       e.printStackTrace();

                                                   }
                                                   s2++;
                                                }
                                    else if(nbsur<=max &&( (SSS==true && SSSS==true)&&(SSSSS==false&&SS==false)))
                                                {
                                                            try{
                                                        String update = "UPDATE planningds SET j4s1='1' where nomcomplt  like '%"+lis[n2]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                        } catch (SQLException e)
                                                        {
                                                            e.printStackTrace();

                                                        }
                                                        s2++;

                                                }
                                        }
                           n2++;
                                }}
              else if (A[cop].equals("S4"))
              {  
                  int K=nombensg("j4s4");  
                  int nbsalle1=nombsalle(G[i+1],A[cop]);
                  int nbsalle2=nombsalle1(G[i+1],A[cop]);
                  int nbsalle3=Salle2eme(G[i+1],A[cop]);
                  int nbsalle4=Salle3eme(G[i+1],A[cop]);
                  int nbsalle5=Salle1M(G[i+1],A[cop]);
                  int nbsalle6=Salle2m(G[i+1],A[cop]);
                  String dispens =ensgdisp(G[i]);
                  String []lis=dispens.split("  ");
                  int nombre=0,n3=0;
                  int s3=K+nombre;
                  int nb=(nbsalle1+nbsalle2+nbsalle3+nbsalle4+nbsalle5+nbsalle6)*2;
                  while(nb!=0&&s3<=nb)
                    {
                       
                        int nbsur=nbSurvillance(lis[n3]);
                        String nom =GradeEns(lis[n3]);
                        int max=maxsurgrade(nom);
                        boolean SS=existe("j4s1",lis[n3]);
                        boolean SSS=existe("j4s2",lis[n3]);
                        boolean SSSS=existe("j4s3",lis[n3]);
                        boolean SSSSS=existe("j4s4",lis[n3]);
                        if((!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences")))
                            {       if(nbsur<=max && ((SS==false && SSS==false)&&(SSSS==false&&SSSSS==false) ))
                                    {
                                        try
                                        {
                                            String update = "UPDATE planningds SET`j4s2`='1',j4s3='1',j4s4='1' where nomcomplt  like '%"+lis[n3]+"%' ";
                                            pst = connection.prepareStatement(update);
                                            pst.execute();
                                       } catch (SQLException e)
                                       {
                                           e.printStackTrace();

                                       }
                                       s3++;
                                    }else

                                    if(nbsur<=max && ((SSSSS==true && SSSS==true)&&(SS==false&&SSS==false) ))
                                    {
                                        try
                                        {
                                          
                                            String update = "UPDATE planningds SET j4s2='1' where nomcomplt  like '%"+lis[n3]+"%' ";
                                            pst = connection.prepareStatement(update);
                                            pst.execute();
                                       } catch (SQLException e)
                                       {
                                           e.printStackTrace();

                                       }
                                       s3++;

                                    }else if(nbsur<=max &&( (SSS==true && SSSS==true)&&(SSSSS==false&&SS==false)))
                                                {
                                                            try{
                                                        String update = "UPDATE planningds SET j4s4='1' where nomcomplt  like '%"+lis[n3]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                        } catch (SQLException e)
                                                        {
                                                            e.printStackTrace();

                                                        }
                                                        s3++;

                                                }
                            }
               n3++;
                    }
              }
              cop++;}

                }else
                if(i==8)
                 {
                                       String hor=horaire1S1();
                        String []A=hor.split(" ");

                        int cop=1;
                        while(cop<A.length)
                        {
                            if(A[cop].equals("S1"))
                            {   
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
                                while(nb!=0&&s<nb)
                                {

                                        
                                        int nbsur=nbSurvillance(lis[n]);
                                        String nom =GradeEns(lis[n]);
                                        int max=maxsurgrade(nom);
                                        boolean SS=existe("j5s1",lis[n]);
                                        boolean SSS=existe("j5s2",lis[n]);
                                        boolean SSSS=existe("j5s3",lis[n]);
                                        boolean SSSSS=existe("j5s4",lis[n]);
                                        if((!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences")))
                                        {
                                        
                                            if(nbsur<=max && ((SS==false && SSS==false) && (SSSS==false&& SSSSS==false)))
                                                {
            String update = "UPDATE planningds SET j5s1='1',j5s2='1',j5s3='1' where nomcomplt  like '%"+lis[n]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                        } catch (SQLException e)
                                                        {
                                                            e.printStackTrace();

                                                        }
                                                        s++;
                                                }else if(nbsur<=max &&( (SSS==true && SSSS==true)&&SSSSS==false))
                                                {
                                                            try{
                                                        String update = "UPDATE planningds SET j5s1='1' where nomcomplt  like '%"+lis[n]+"%' ";
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
              {   int K=nombensg("j5s2");  
                  int nbsalle1=nombsalle(G[i+1],A[cop]);
                  int nbsalle2=nombsalle1(G[i+1],A[cop]);
                  int nbsalle3=Salle2eme(G[i+1],A[cop]);
                  int nbsalle4=Salle3eme(G[i+1],A[cop]);
                  int nbsalle5=Salle1M(G[i+1],A[cop]);
                  int nbsalle6=Salle2m(G[i+1],A[cop]);
                  String dispens =ensgdisp(G[i]);
                  String []lis=dispens.split("  ");
                  int nombre=0,n1=0;
                  int s1=K+nombre;
                  int nb=(nbsalle1+nbsalle2+nbsalle3+nbsalle4+nbsalle5+nbsalle6)*2;
                  while(nb!=0&&s1<=nb)
                    {
                        int nbsur=nbSurvillance(lis[n1]);
                        String nom =GradeEns(lis[n1]);
                        int max=maxsurgrade(nom);

                        boolean SS=existe("j5s1",lis[n1]);
                      
                        boolean SSS=existe("j5s2",lis[n1]);
                        boolean SSSS=existe("j5s3",lis[n1]);
                        boolean SSSSS=existe("j5s4",lis[n1]);
                        if((!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences")))
                            {       if(nbsur<=max && ((SS==false && SSS==false) && (SSSS==false&& SSSSS==false)))
                                    {
                                        try
                                        {
                                            String update = "UPDATE planningds SET`j5s2`='1',j5s3='1',j5s4='1' where nomcomplt  like '%"+lis[n1]+"%' ";
                                            pst = connection.prepareStatement(update);
                                            pst.execute();
                                       } catch (SQLException e)
                                       {
                                           e.printStackTrace();

                                       }
                                       s1++;
                                    }else

                                    if(nbsur<=max && ((SS==false&&SSS==false) && (SSSS==true && SSSSS==true) ))
                                    {
                                        try
                                        {
                                            
                                            String update = "UPDATE planningds SET j5s2='1' where nomcomplt  like '%"+lis[n1]+"%' ";
                                            pst = connection.prepareStatement(update);
                                            pst.execute();
                                       } catch (SQLException e)
                                       {
                                           e.printStackTrace();

                                       }
                                       s1++;
                                    }else if(nbsur<=max &&( (SSS==true && SSSS==true)&&(SSSSS==false&&SS==false)))
                                                {
                                                            try{
                                                                
                                                        String update = "UPDATE planningds SET j5s4='1' where nomcomplt  like '%"+lis[n1]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                        } catch (SQLException e)
                                                        {
                                                            e.printStackTrace();

                                                        }
                                                        s1++;

                                                }
                            }
               n1++;
                    }
              }else
                  if(A[cop].equals("S3"))
                            { 
                                int K=nombensg("j1s3");  
                                int nbsalle1=nombsalle(G[i+1],A[cop]);
                                int nbsalle2=nombsalle1(G[i+1],A[cop]);
                                int nbsalle3=Salle2eme(G[i+1],A[cop]);
                                int nbsalle4=Salle3eme(G[i+1],A[cop]);
                                int nbsalle5=Salle1M(G[i+1],A[cop]);
                                int nbsalle6=Salle2m(G[i+1],A[cop]);
                                String dispens =ensgdisp(G[i]);
                                String []lis=dispens.split("  ");
                                int nombre=0,n2=0;
                                int s2=K+nombre;
                                int nb=(nbsalle1+nbsalle2+nbsalle3+nbsalle4+nbsalle5+nbsalle6)*2;
                                while(nb!=0&&s2<nb)
                                {

                              
                                    int nbsur=nbSurvillance(lis[n2]);
                                    
                                    String nom =GradeEns(lis[n2]);
                                        int max=maxsurgrade(nom);
                                        boolean SS=existe("j5s1",lis[n2]);
                                       
                                        boolean SSS=existe("j5s2",lis[n2]);
                                        boolean SSSS=existe("j5s3",lis[n2]);
                                        boolean SSSSS=existe("j5s4",lis[n2]);
                                       
                                    if((!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences")))
                                        {   if(nbsur<=max && ((SS==false && SSS==false) && (SSSS==false&& SSSSS==false)))
                                                {
                                                    try
                                                    {
                                                        String update = "UPDATE planningds SET j5s1='1',`j5s2`='1',j5s3='1' where nomcomplt  like '%"+lis[n2]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                   } catch (SQLException e)
                                                   {
                                                       e.printStackTrace();

                                                   }
                                                   s2++;
                                                }else

                                                if(nbsur<=max && (((SS==true &&SSS==true)&& (SSSS==false&& SSSSS==false)) ))
                                                {
                                                    try
                                                    {
                                                        String update = "UPDATE planningds SET j5s3='1' where nomcomplt  like '%"+lis[n2]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                   } catch (SQLException e)
                                                   {
                                                       e.printStackTrace();

                                                   }
                                                   s2++;
                                                }
                                    else if(nbsur<=max &&( (SSS==true && SSSS==true)&&(SSSSS==false&&SS==false)))
                                                {
                                                            try{
                                                                String update = "UPDATE planningds SET j5s1='1' where nomcomplt  like '%"+lis[n2]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                        } catch (SQLException e)
                                                        {
                                                            e.printStackTrace();

                                                        }
                                                        s2++;

                                                }
                                        }
                           n2++;
                                }}
              else if (A[cop].equals("S4"))
              {  int K=nombensg("j5s4");  
                  int nbsalle1=nombsalle(G[i+1],A[cop]);
                  int nbsalle2=nombsalle1(G[i+1],A[cop]);
                  int nbsalle3=Salle2eme(G[i+1],A[cop]);
                  int nbsalle4=Salle3eme(G[i+1],A[cop]);
                  int nbsalle5=Salle1M(G[i+1],A[cop]);
                  int nbsalle6=Salle2m(G[i+1],A[cop]);
                  String dispens =ensgdisp(G[i]);
                  String []lis=dispens.split("  ");
                  int nombre=0,n3=0;
                  int s3=K+nombre;
                  int nb=(nbsalle1+nbsalle2+nbsalle3+nbsalle4+nbsalle5+nbsalle6)*2;
                  while(nb!=0&&s3<=nb)
                    {
                       
                        int nbsur=nbSurvillance(lis[n3]);
                        String nom =GradeEns(lis[n3]);
                        int max=maxsurgrade(nom);
                        boolean SS=existe("j5s1",lis[n3]);
                        boolean SSS=existe("j5s2",lis[n3]);
                        boolean SSSS=existe("j5s3",lis[n3]);
                        boolean SSSSS=existe("j5s4",lis[n3]);
                        if((!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences")))
                            { if(nbsur<=max && ((SS==false && SSS==false)&&(SSSS==false&&SSSSS==false) ))
                                    {
                                        try
                                        {
                             
                                            String update = "UPDATE planningds SET`j5s2`='1',j5s3='1',j5s4='1' where nomcomplt  like '%"+lis[n3]+"%' ";
                                            pst = connection.prepareStatement(update);
                                            pst.execute();
                                       } catch (SQLException e)
                                       {
                                           e.printStackTrace();

                                       }
                                       s3++;
                                    }else

                                    if(nbsur<=max && ((SSSSS==true && SSSS==true)&&(SS==false&&SSS==false) ))
                                    {
                                        try
                                        {
                                         
                                            String update = "UPDATE planningds SET j5s2='1' where nomcomplt  like '%"+lis[n3]+"%' ";
                                            pst = connection.prepareStatement(update);
                                            pst.execute();
                                       } catch (SQLException e)
                                       {
                                           e.printStackTrace();

                                       }
                                       s3++;

                                    }else if(nbsur<=max &&( (SSS==true && SSSS==true)&&(SSSSS==false&&SS==false)))
                                                {
                                                            try{
                                                                String update = "UPDATE planningds SET j5s4='1' where nomcomplt  like '%"+lis[n3]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                        } catch (SQLException e)
                                                        {
                                                            e.printStackTrace();

                                                        }
                                                        s3++;

                                                }
                            }
               n3++;
                    }
              }
              cop++;}

                 }else 
                    if(i==10)
                    {
                   
                        String hor=horaire1S1();
                        String []A=hor.split(" ");

                        int cop=1;
                        while(cop<A.length)
                        {
                            if(A[cop].equals("S1"))
                            {   int K=nombensg("j6s1");  
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
                                        int nbsur=nbSurvillance(lis[n]);
                                        String nom =GradeEns(lis[n]);
                                        int max=maxsurgrade(nom);
                                        boolean SS=existe("j6s1",lis[n]);
                                        boolean SSS=existe("j6s2",lis[n]);
                                        boolean SSSS=existe("j6s3",lis[n]);
                                        boolean SSSSS=existe("j6s4",lis[n]);
                                        if((!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences")))
                                        {
                                                if(nbsur<=max && ((SS==false && SSS==false) && (SSSS==false&& SSSSS==false)))
                                                {

                                                        try{
                                                            
                                                        String update = "UPDATE planningds SET j6s1='1',j6s2='1',j6s3='1' where nomcomplt  like '%"+lis[n]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                        }
                                                    catch (SQLException e)
                                                        {
                                                            e.printStackTrace();

                                                        }
                                                        s++;
                                                }else if(nbsur<=max &&( (SSS==true && SSSS==true)&&SSSSS==false))
                                                {
                                                            try{
                                                                
                                                        String update = "UPDATE planningds SET j6s1='1' where nomcomplt  like '%"+lis[n]+"%' ";
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
              {  
                                int K=nombensg("j6s2");  
                  int nbsalle1=nombsalle(G[i+1],A[cop]);
                  int nbsalle2=nombsalle1(G[i+1],A[cop]);
                  int nbsalle3=Salle2eme(G[i+1],A[cop]);
                  int nbsalle4=Salle3eme(G[i+1],A[cop]);
                  int nbsalle5=Salle1M(G[i+1],A[cop]);
                  int nbsalle6=Salle2m(G[i+1],A[cop]);
                  String dispens =ensgdisp(G[i]);
                  String []lis=dispens.split("  ");
                  int nombre=0,n1=0;
                  int s1=K+nombre;
                  int nb=(nbsalle1+nbsalle2+nbsalle3+nbsalle4+nbsalle5+nbsalle6)*2;
                  while(nb!=0&&s1<=nb)
                    {
                       
                        int nbsur=nbSurvillance(lis[n1]);
                       
                        String nom =GradeEns(lis[n1]);
                        int max=maxsurgrade(nom);

                        boolean SS=existe("j6s1",lis[n1]);
                      
                        boolean SSS=existe("j6s2",lis[n1]);
                      
                      boolean SSSS=existe("j6s3",lis[n1]);
                      
                      boolean SSSSS=existe("j6s4",lis[n1]);
                      
                      if((!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences")))
                            { 
                          if(nbsur<=max && ((SS==false && SSS==false) && (SSSS==false&& SSSSS==false)))
                                    {
                                        try
                                        {
                          
                                            String update = "UPDATE planningds SET`j6s2`='1',j6s3='1',j6s4='1' where nomcomplt  like '%"+lis[n1]+"%' ";
                                            pst = connection.prepareStatement(update);
                                            pst.execute();
                                       } catch (SQLException e)
                                       {
                                           e.printStackTrace();

                                       }
                                       s1++;
                                    }else

                                    if(nbsur<=max && ((SS==false&&SSS==false) && (SSSS==true && SSSSS==true) ))
                                    {
                                        try
                                        {
                                            String update = "UPDATE planningds SET j6s2='1' where nomcomplt  like '%"+lis[n1]+"%' ";
                                            pst = connection.prepareStatement(update);
                                            pst.execute();
                                       } catch (SQLException e)
                                       {
                                           e.printStackTrace();

                                       }
                                       s1++;
                                    }else if(nbsur<=max &&( (SSS==true && SSSS==true)&&(SSSSS==false&&SS==false)))
                                                {
                                                            try{
                                                        String update = "UPDATE planningds SET j6s4='1' where nomcomplt  like '%"+lis[n1]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                        } catch (SQLException e)
                                                        {
                                                            e.printStackTrace();

                                                        }
                                                        s1++;

                                                }
                            }
               n1++;
                    }
              }else
                  if(A[cop].equals("S3"))
                            { 
                      int K=nombensg("j6s3");  
                                int nbsalle1=nombsalle(G[i+1],A[cop]);
                                int nbsalle2=nombsalle1(G[i+1],A[cop]);
                                int nbsalle3=Salle2eme(G[i+1],A[cop]);
                                int nbsalle4=Salle3eme(G[i+1],A[cop]);
                                int nbsalle5=Salle1M(G[i+1],A[cop]);
                                int nbsalle6=Salle2m(G[i+1],A[cop]);
                                String dispens =ensgdisp(G[i]);
                                String []lis=dispens.split("  ");
                                int nombre=0,n2=0;
                                int s2=K+nombre;
                                int nb=(nbsalle1+nbsalle2+nbsalle3+nbsalle4+nbsalle5+nbsalle6)*2;
                                while(nb!=0&&s2<nb)
                                {
                                    int nbsur=nbSurvillance(lis[n2]);
                                    
                                    String nom =GradeEns(lis[n2]);
                                        int max=maxsurgrade(nom);
                                        boolean SS=existe("j6s1",lis[n2]);
                                        boolean SSS=existe("j6s2",lis[n2]);
                                        boolean SSSS=existe("j6s3",lis[n2]);
                                        boolean SSSSS=existe("j6s4",lis[n2]);
                                    if((!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences")))
                                        {
                                        if(nbsur<=max && ((SS==false && SSS==false) && (SSSS==false&& SSSSS==false)))
                                                {
                                                    try
                                                    {   String update = "UPDATE planningds SET j6s1='1',`j6s2`='1',j6s3='1' where nomcomplt  like '%"+lis[n2]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                   } catch (SQLException e)
                                                   {
                                                       e.printStackTrace();

                                                   }
                                                   s2++;
                                                }else

                                                if(nbsur<=max && (((SS==true &&SSS==true)&& (SSSS==false&& SSSSS==false)) ))
                                                {
                                                    try
                                                    {   String update = "UPDATE planningds SET j6s3='1' where nomcomplt  like '%"+lis[n2]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                   } catch (SQLException e)
                                                   {
                                                       e.printStackTrace();

                                                   }
                                                   s2++;
                                                }
                                    else if(nbsur<=max &&( (SSS==true && SSSS==true)&&(SSSSS==false&&SS==false)))
                                                {
                                                            try{
                                                        String update = "UPDATE planningds SET j6s1='1' where nomcomplt  like '%"+lis[n2]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                        } catch (SQLException e)
                                                        {
                                                            e.printStackTrace();

                                                        }
                                                        s2++;

                                                }
                                        }
                           n2++;
                                }}
              else if (A[cop].equals("S4"))
              {   int K=nombensg("j6s4");  
                  int nbsalle1=nombsalle(G[i+1],A[cop]);
                  int nbsalle2=nombsalle1(G[i+1],A[cop]);
                  int nbsalle3=Salle2eme(G[i+1],A[cop]);
                  int nbsalle4=Salle3eme(G[i+1],A[cop]);
                  int nbsalle5=Salle1M(G[i+1],A[cop]);
                  int nbsalle6=Salle2m(G[i+1],A[cop]);
                  String dispens =ensgdisp(G[i]);
                  String []lis=dispens.split("  ");
                  int nombre=0,n3=0;
                  int s3=K+nombre;
                  int nb=(nbsalle1+nbsalle2+nbsalle3+nbsalle4+nbsalle5+nbsalle6)*2;
                  while(nb!=0&&s3<=nb)
                    {
                        int nbsur=nbSurvillance(lis[n3]);
                        String nom =GradeEns(lis[n3]);
                        int max=maxsurgrade(nom);
                        boolean SS=existe("j6s1",lis[n3]);
                        boolean SSS=existe("j6s2",lis[n3]);
                        boolean SSSS=existe("j6s3",lis[n3]);
                        boolean SSSSS=existe("j6s4",lis[n3]);
                  
                        if((!nom.equals("Professeur")&&!nom.equals("Vacataire")&&!nom.equals("Maitre de conférences")))
                            {       if(nbsur<=max && ((SS==false && SSS==false)&&(SSSS==false&&SSSSS==false) ))
                                    {
                                        try
                                        {
                                            String update = "UPDATE planningds SET`j6s2`='1',j6s3='1',j6s4='1' where nomcomplt  like '%"+lis[n3]+"%' ";
                                            pst = connection.prepareStatement(update);
                                            pst.execute();
                                       } catch (SQLException e)
                                       {
                                           e.printStackTrace();

                                       }
                                       s3++;
                                    }else

                                    if(nbsur<=max && ((SSSSS==true && SSSS==true)&&(SS==false&&SSS==false) ))
                                    {
                                        try
                                        {
                                       
                                            String update = "UPDATE planningds SET j6s2='1' where nomcomplt  like '%"+lis[n3]+"%' ";
                                            pst = connection.prepareStatement(update);
                                            pst.execute();
                                       } catch (SQLException e)
                                       {
                                           e.printStackTrace();

                                       }
                                       s3++;

                                    }else if(nbsur<=max &&( (SSS==true && SSSS==true)&&(SSSSS==false&&SS==false)))
                                                {
                                                            try{
                                                        String update = "UPDATE planningds SET j6s4='1' where nomcomplt  like '%"+lis[n3]+"%' ";
                                                        pst = connection.prepareStatement(update);
                                                        pst.execute();
                                                        } catch (SQLException e)
                                                        {
                                                            e.printStackTrace();

                                                        }
                                                        s3++;

                                                }
                            }
               n3++;
                    }
              }
              cop++;}

                    break;}
      i++;   
      }
      
        }


    @FXML
    void afficher(ActionEvent event) {
        emf=Persistence.createEntityManagerFactory("ESENPU");
        em = PlannificationdsController.emf.createEntityManager();
        emf=Persistence.createEntityManagerFactory("ESENPU");
        planningds.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        List<Planningds>lst = em.createQuery("SELECT p FROM Planningds p").getResultList();
        
        data=FXCollections.observableArrayList();
        for(Planningds lst1:lst){
           
        data.add(new Planningdsfx(lst1.getIdPlanningDS(),lst1.getNomcomplt(),lst1.getJ1s1(),lst1.getJ1s2(),lst1.getJ1s3(),lst1.getJ1s4(),lst1.getJ2s1(),lst1.getJ2s2(),lst1.getJ2s3(),lst1.getJ2s4(),lst1.getJ3s1(),lst1.getJ3s2(),lst1.getJ3s3()
                ,lst1.getJ3s4(),lst1.getJ4s1(),lst1.getJ4s2(),lst1.getJ4s3(),lst1.getJ4s4(),lst1.getJ5s1(),lst1.getJ5s2(),lst1.getJ5s3(),lst1.getJ5s4(),lst1.getJ6s1(),lst1.getJ6s2(),lst1.getJ6s3(),lst1.getJ6s4(),lst1.getNbre()
     ));
        }
        planningds.setItems(data);
        id.setCellValueFactory(cell->cell.getValue().getIdPlanningDSProperty());
        nomcomplt.setCellValueFactory(cell->cell.getValue().getNomcompltProperty());
        j1s1.setCellValueFactory(cell->cell.getValue().getJ1s1Property());
        j1s2.setCellValueFactory(cell->cell.getValue().getJ1s2Proprty());
        j1s3.setCellValueFactory(cell->cell.getValue().getJ1s3Property());
        j1s4.setCellValueFactory(cell->cell.getValue().getJ1s4Property());
        j2s1.setCellValueFactory(cell->cell.getValue().getJ2s1Property());
        j2s2.setCellValueFactory(cell->cell.getValue().getJ2s2Property());
        j2s3.setCellValueFactory(cell->cell.getValue().getJ2s3Property());
        j2s4.setCellValueFactory(cell->cell.getValue().getJ2s4Property());
        j3s1.setCellValueFactory(cell->cell.getValue().getJ3s1Property());
        j3s2.setCellValueFactory(cell->cell.getValue().getJ3s2Property());
        j3s3.setCellValueFactory(cell->cell.getValue().getJ3s3Property());
        j3s4.setCellValueFactory(cell->cell.getValue().getJ3s4Property());
        j4s1.setCellValueFactory(cell->cell.getValue().getJ4s1Property());
        j4s2.setCellValueFactory(cell->cell.getValue().getJ4s2Property());
        j4s3.setCellValueFactory(cell->cell.getValue().getJ4s3Property());
        j4s4.setCellValueFactory(cell->cell.getValue().getJ4s4Property());
        j5s1.setCellValueFactory(cell->cell.getValue().getJ5s1PRoperty());
        j5s2.setCellValueFactory(cell->cell.getValue().getJ5s2Property());
        j5s3.setCellValueFactory(cell->cell.getValue().getJ5s3Property());
        j5s4.setCellValueFactory(cell->cell.getValue().getJ5s4Property());
        j6s1.setCellValueFactory(cell->cell.getValue().getJ6s1Property());
        j6s2.setCellValueFactory(cell->cell.getValue().getJ6s2Property());
        j6s3.setCellValueFactory(cell->cell.getValue().getJ6s3Property());
        j6s4.setCellValueFactory(cell->cell.getValue().getJ6s4Property());
        nbre.setCellValueFactory(cell->cell.getValue().getNbreProperty());
        
    }

    @FXML
    void ajouter(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/frmseanceds.fxml"));
        AnchorPane  mainPane = (AnchorPane)loader.load();
        Scene scene = new Scene(mainPane);
        stage.setTitle("Ajouter Nouvelle survillance");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        FrmseancedsController ctrl = loader.getController();
        stage.showAndWait();
        
    }

    @FXML
    void demarrer(ActionEvent event) {
        connection = handler.getConnection();
      int i=entrejour();
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
            stage.showAndWait();*/
            try
        {
            
                String insert ="INSERT INTO planningds SELECT id, nomcomplt,'','','','','','','','','','','','','','','','','','','',' ',' ',' ',' ',' ',''FROM enseignant";
                pst = connection.prepareStatement(insert);
        
                pst.execute();
         
                } 
        catch (SQLException e1)
             {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("veuillez vous supprimer la première ligne de la table enseignant pour éviter des erreurs probables");
                    alert.setContentText("Erreur de remplissage");
                    alert.showAndWait();
             }
        finally 
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
        
    }
        plannning1();
    }

    @FXML
    void modifier(ActionEvent event) throws IOException {
        connection = handler.getConnection();
        int row =planningds.getSelectionModel().getSelectedIndex();
        if(row <0)return; 
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/frmseanceds.fxml"));
        AnchorPane  mainPane = (AnchorPane)loader.load();
        Scene scene = new Scene(mainPane);
        stage.setTitle("Modifier séance surveillance");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        FrmseancedsController ctrl = loader.getController();
        ctrl.setplanning(data.get(row).getIdPlanningDS());
        stage.showAndWait();
        afficher(event);
    }

    @FXML
    void supprimer(ActionEvent event) {
         connection = handler.getConnection();
        int row =planningds.getSelectionModel().getSelectedIndex();
        if(row <0)return;
         Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
        alert.setTitle("Conformation de suppression");
        alert.setHeaderText(null);
        alert.setContentText("Vous etes sure?");
        Optional <ButtonType>action = alert.showAndWait();
        
        if(action.get()==ButtonType.OK){
       
        em = PlannificationdsController.emf.createEntityManager();
        Query q =em.createQuery("SELECT p FROM Planningds p WHERE p.idPlanningDS = :idPlanningDS");
        q.setParameter("idPlanningDS", data.get(row).getIdPlanningDS());
        Planningds P = (Planningds) q.getSingleResult();
        em.getTransaction().begin();
        em.remove(P);
        em.getTransaction().commit();
        em.close();
        
        afficher(event);
    }
    }

    @FXML
    void telecharger(ActionEvent event) throws DocumentException, SQLException, FileNotFoundException {
        connection = handler.getConnection();
       int k=entrejour();
        try
        {
        int rowno=0;
        rs=pst.executeQuery("Select * from planningds");
        ResultSetMetaData rsmd =rs.getMetaData();
        int colnc=rsmd.getColumnCount();
        while(rs.next())
        {
            rowno = rowno+1;
        }
        rs.first();
        Document d = new Document(PageSize.A6.rotate());
        PdfWriter.getInstance(d,new FileOutputStream ("planningDS.pdf"));
        PdfPTable pt = new PdfPTable(colnc);
        pt.setWidthPercentage(100);
        pt.setHorizontalAlignment(100);
        d.open();
        
        d.add(new Paragraph("AVIS AUX ENSEIGNANTS"));
        d.add(new Paragraph());
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
        rs.next();
        }
        d.add(pt);
        d.close();
        }catch(SQLException e )
        {
            e.printStackTrace();
        }
    }
@FXML
    void vider(ActionEvent event) {
        connection = handler.getConnection();
        int i=minid(),j=maxid();
        Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
        alert.setTitle("Conformation de suppression");
        alert.setHeaderText(null);
        alert.setContentText("Attention!! si vous aves clique Qui tout les contunu sera supprimer!!");
        Optional <ButtonType>action = alert.showAndWait();
        if(action.get()==ButtonType.OK){
            alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Notification");
                    alert.setContentText("Veuillez Vous Attende Quelque Seconde");
                    alert.showAndWait();
         while(i<=j)
        {
        try{
        String sql ="delete from planningds where idPlanningDS="+i+"";
        pst = connection.prepareStatement(sql);
        pst.executeUpdate();
        }
        catch (SQLException e1)
            {
                e1.printStackTrace();
            
            }        
i++;
        }
        }
}
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        handler = new dbconnect();
        emf=Persistence.createEntityManagerFactory("ESENPU");
        em = PlannificationdsController.emf.createEntityManager();
        emf=Persistence.createEntityManagerFactory("ESENPU");
        
    }  }
