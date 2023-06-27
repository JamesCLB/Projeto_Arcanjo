package Hospital;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;
public class MedicoDAO {
	public void insereMedico( Connection conn, String nomeMedico, String senha, String cpf, String crm, String especialidade  ) {
		try{		      
			Statement stmt = conn.createStatement();
			String comandoAddMedico = "INSERT INTO medicos VALUES ('"+ nomeMedico +"', '" + senha + "', '"+ cpf +"', '" + crm + "', '" + especialidade + "')";

			stmt.executeUpdate(comandoAddMedico);  	  
		} catch (SQLException ee) {
			ee.printStackTrace();
		}
	}
	public void procuraMedicoCPF(Connection conn, String cpf, JTextArea areaInfo) throws SQLException {
		String buscaCPF = "SELECT * FROM medicos WHERE cpf = '" + cpf + "'";
		Statement stmt = conn.createStatement();
		ResultSet resultSet = stmt.executeQuery(buscaCPF);
		if(resultSet.next()) {
			String nome = resultSet.getString("nome");
			String senha = resultSet.getString("senha");
			String cpff = resultSet.getString("cpf");
			String crm = resultSet.getString("crm");
			String especialidade = resultSet.getString("especialidade");
			
			areaInfo.append("Nome: " + nome + "\n");
			areaInfo.append("\n");
			areaInfo.append("Senha: " + senha + "\n");
			areaInfo.append("\n");
			areaInfo.append("Cpf: " + cpff + "\n");
			areaInfo.append("\n");
			areaInfo.append("CRM: " + crm + "\n");
			areaInfo.append("\n");
			areaInfo.append("Especialidade: " + especialidade + "\n");
		}
		else {
			areaInfo.append("CPF não identificado");
		}
		resultSet.close();
		stmt.close();
	}
}