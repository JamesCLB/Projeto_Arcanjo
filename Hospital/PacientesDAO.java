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
public class PacientesDAO {
	/**
	 * @wbp.parser.entryPoint
	 */
	public void inserePaciente(Connection conn, String NomePaciente, String NascimentoPaciente, String CpfPaciente, String NumeroPaciente, String ContatoPaciente,String HistoricoPaciente, String SexoPaciente, String PesoPaciente , String SintomasPaciente, String id_salas  ) {
		try{		      
			Statement stmt = conn.createStatement();
			String comandoAddPacientes = "INSERT INTO pacientes VALUES ('"+NomePaciente+"', '" + NascimentoPaciente + "', '"+ CpfPaciente +"', '" + NumeroPaciente+ "', '" + ContatoPaciente + "','" + HistoricoPaciente + "','" + SexoPaciente + "','" + PesoPaciente + "','" + SintomasPaciente + "','"+ id_salas +"');";
			stmt.executeUpdate(comandoAddPacientes);  	  
		} catch (SQLException eEe) {
			eEe.printStackTrace();
		}
	}
	
	public void procuraPacienteCPF(Connection conn, String cpf, JTextArea areaInfo) throws SQLException {
		String buscaCPF = "SELECT * FROM pacientes WHERE cpf = '" + cpf + "'";
		Statement stmt = conn.createStatement();
		ResultSet resultSet = stmt.executeQuery(buscaCPF);
		if(resultSet.next()) {
			String nome = resultSet.getString("nome");
			String cpff = resultSet.getString("cpf");
			String dataNasc = resultSet.getString("nascimento");
			String numero = resultSet.getString("numero");
			String cttEmerg = resultSet.getString("contato");
			String historico = resultSet.getString("historico");
			String sexo = resultSet.getString("sexo");
			float peso = resultSet.getFloat("peso");
			String sintomas = resultSet.getString("sintomas");
			String id_salas = resultSet.getString("id_salas");
			
			areaInfo.append("Nome: " + nome + "\n");
			areaInfo.append("\n");
			areaInfo.append("CPF: " + cpf + "\n");
			areaInfo.append("\n");
			areaInfo.append("Data de Nascimento : " + dataNasc + "\n");
			areaInfo.append("\n");
			areaInfo.append("Numero de Telefone: " + numero + "\n");
			areaInfo.append("\n");
			areaInfo.append("Contato de Emergência : " + cttEmerg + "\n");
			areaInfo.append("\n");
			areaInfo.append("Histórico : " + historico + "\n");
			areaInfo.append("\n");
			areaInfo.append("Sexo : " + sexo + "\n");
			areaInfo.append("\n");
			areaInfo.append("Peso : " + peso + "\n");
			areaInfo.append("\n");
			areaInfo.append("Sintomas : " + sintomas + "\n");
			areaInfo.append("\n");
			areaInfo.append("Sala : " + id_salas + "\n");
			
		}
		else {
			areaInfo.append("CPF não identificado");
		}
		resultSet.close();
		stmt.close();
	}
}