package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbconnect {
    dbconnect(){
    
    
    
    }
public  static dbconnect getInstance(){
return new dbconnect();

}
public Connection getConnection(){
     Connection conn = null;
        try{
            
             conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/esen","root","");
            if(conn != null)
            {
                System.out.println("connected to database");
            }
            
            }catch(SQLException e)
        {
        e.printStackTrace();
        }
return conn;
}
}