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
   static final String QUERY = "SELECT * FROM Pacientes";

   public static void main(String[] args) {
      // Open a connection
      try(Connection conexao = DriverManager.getConnection(URL, USER, PASS);
         Statement statement = conexao.createStatement();
         ResultSet rs = statement.executeQuery(QUERY);
      ) {		      
         while(rs.next()){
            //Display values
            System.out.print(" Nome: " + rs.getString("nome"));
            System.out.print(" Nascimento " + rs.getDate("nascimento"));
            System.out.print(" Cpf : " + rs.getInt("cpf"));
            System.out.print(" Numero " + rs.getInt("Numero"));
            System.out.print(" Contato" + rs.getString("contato"));
            System.out.print(" Historico " + rs.getString("historico"));
            System.out.print(" Nascimento " + rs.getInt("nascimento"));
            System.out.print(" Sexo " + rs.getString("sexo"));
            System.out.print(" Nascimento " + rs.getInt("nascimento"));
            System.out.print(" Peso " + rs.getDouble("peso"));
            System.out.print(" Sintomas " + rs.getString("sintomas "));
         }
      } catch (SQLException erro) {
         System.out.println(" ERRO"); 
      } 
      
   }
}