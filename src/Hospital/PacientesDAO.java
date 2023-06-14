package Hospital;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class PacientesDAO {
	private DatabaseConnection conexao;
	public PacientesDAO(DatabaseConnection conexao) {
		this.conexao = conexao;
	}
	
	
	/*
	public List<PacientesDTO> listaPacientes() {
		try (PreparedStatement ps = (PreparedStatement) ((Statement) this.conexao).executeQuery("SELECT * FROM medicos")) {
			ResultSet rs =  ps.executeQuery();
			List<PacientesDTO> PacientesLista = new ArrayList<>();
			while(rs.next()) {
				PacientesDTO paciente = new PacientesDTO(rs.getString("nome"), null, rs.getString("senha"), rs.getString("cpf"), rs.getString("crf"), rs.getString("especialidade"), null, 0, null);
				PacientesLista.addAll(PacientesLista);	
			}
			return PacientesLista;
		} catch (SQLException e) {
			e.printStackTrace();
		};
		return null;
	}*/
}
