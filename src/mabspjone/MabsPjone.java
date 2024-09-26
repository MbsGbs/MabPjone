
package mabspjone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class MabsPjone {
    //Connection Method to SQLITE
public static Connection connectDB() {
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC"); // Load the SQLite JDBC driver
            con = DriverManager.getConnection("jdbc:sqlite:Testapp"); // Establish connection
            System.out.println("Connection Successful");
        } catch (Exception e) {
            System.out.println("Connection Failed: " + e);
        }
        return con;
    }
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    connectDB();
      

       System.out.println("Enter Firstname: "); 
       String fn = sc.nextLine();
        System.out.println("Enter Lastname: "); 
               String ln = sc.nextLine();
         System.out.println("Enter Email: ");
                String ems = sc.nextLine();
         System.out.println("Enter status: ");
                String sts = sc.nextLine();
       String sql = "INSERT INTO tbl_Students (s_firstname, s_lastname, s_email, s_status) VALUES (?, ?, ?, ?);";
       
       try{
           Connection con = connectDB();
           PreparedStatement pst = con.prepareStatement(sql);
           pst.setString(1, fn);
           pst.setString(1, ln);
            pst.setString(1, ems);
           pst.setString(1, sts);
          pst.executeUpdate();
           System.out.println("Insert Successfully!! ");  
       }catch (SQLException ex){
           System.out.println("Connection Error: "+ex.getMessage());
         
       }
                
                
                
    }
    
}
