package Hospital;
import java.sql.Date;

public class PacientesDTO {
	private String nome;
	private Date nascimento;
	private String cpf;
	private String numero;
	private String contato;
	private String historico;
	private String sexo;
	private float peso;
	private String sintomas;

	public PacientesDTO(String nome, Date nascimento, String cpf, String numero, String contato, String historico, String sexo, float peso, String sintomas) {
		this.nome = nome;
		this.nascimento = nascimento;
		this.numero = numero;
		this.contato = contato;
		this.historico = historico;
		this.cpf = cpf;
		this.sexo = sexo;
		this.peso = peso;
		this.sintomas = sintomas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getHistorico() {
		return historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public String getSintomas() {
		return sintomas;
	}

	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}
	@Override
	public String toString() {
		return "PacientesDTO [nome=" + nome + ", nascimento=" + nascimento + ", cpf=" + cpf + ", numero=" + numero
				+ ", contato=" + contato + ", historico=" + historico + ", sexo=" + sexo + ", peso=" + peso
				+ ", sintomas=" + sintomas + "]";
	};
}
