package Hospital;

// https://www.tutorialspoint.com/jdbc/jdbc-select-records.htm

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
   static final String URL = "jdbc:mysql://localhost/arcanjo";
   static final String USER = "root";
   static final String PASS = "root";

   public Connection myDatabaseConnection(){
      
	   Connection conn = null;
	      try{
	    	  conn = DriverManager.getConnection(URL, USER, PASS);
	         
	      } catch (SQLException ee) {
	         ee.printStackTrace();
	      } 
      
	      return conn;
   }
}