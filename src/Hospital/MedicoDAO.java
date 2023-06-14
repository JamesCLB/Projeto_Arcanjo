package Hospital;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class MedicoDAO {
	/*
	private DatabaseConnection conexao;
	public MedicoDAO(DatabaseConnection conexao) {
		this.conexao = conexao;
	}*/
	private static final String URL = "jdbc:mysql://localhost/arcanjo";
	public void addMedico(MedicosDTO medicodto) {
		try (Connection conexao = DriverManager.getConnection(URL)){
			PreparedStatement statement = conexao.prepareStatement("INSERT INTO medicos (nome, senha, cpf, crm, especialidade) VALUES (?, ?, ?, ?, ?)");
			
			statement.setString(1, medicodto.getNome());
			statement.setString(2, medicodto.getSenha());
			statement.setString(3, medicodto.getCpf());
			statement.setString(4, medicodto.getCrm());
			statement.setString(5, medicodto.getEspecialidade());
			
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
