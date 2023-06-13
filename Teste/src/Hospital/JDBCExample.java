package Hospital;

// https://www.tutorialspoint.com/jdbc/jdbc-insert-records.htm
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample {
   static final String DB_URL = "jdbc:mysql://localhost/escola";
   static final String USER = "root";
   static final String PASS = "root";

   public static void main(String[] args) {
      // Open a connection
      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
      ) {		      
         // Execute a query
         System.out.println("Inserindo dados em tabela");
//         insert into estudantes values ("9","Carla","10","5");
         
         String sql = "INSERT INTO estudantes VALUES (default, 'Luana', '10', '5')";
         
         stmt.executeUpdate(sql);  	  
      } catch (SQLException e) {
         e.printStackTrace();
      } 
   }
}
