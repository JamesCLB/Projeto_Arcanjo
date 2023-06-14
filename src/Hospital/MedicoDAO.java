package Hospital;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;
public class MedicoDAO {
	private DatabaseConnection conexao;
	public MedicoDAO(DatabaseConnection conexao) {
		this.conexao = conexao;
	}
	public List<MedicosDTO> listarMedicos() {
		try (PreparedStatement ps = this.conexao.executeQuery("SELECT * FROM medicos")) {
			ResultSet rs =  ps.executeQuery();
			List<MedicosDTO> medicosLista = new ArrayList<>();
			while(rs.next()) {
				MedicosDTO medico = new MedicosDTO(rs.getString("nome"), rs.getString("senha"), rs.getString("cpf"), rs.getString("crf"), rs.getString("especialidade"));
				medicosLista.add(medico);	
			}
			return medicosLista;
		} catch (SQLException e) {
			e.printStackTrace();
		};
		return null;
	}
}
