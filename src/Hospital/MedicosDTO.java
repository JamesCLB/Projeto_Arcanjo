package Hospital;

public class MedicosDTO {
	private String nome;
	private String senha;
	private String cpf;
	private String crm;
	private String especialidade;
	
	public MedicosDTO (String medicos, String senha, String cpf, String crm, String especialidade ) {
		this.nome = nome ;
		this.cpf = cpf ;
		this.senha = senha;
		this.crm = crm ;
		this.especialidade = especialidade;
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	@Override
	public String toString() {
		return "MedicosDTO [nome=" + nome + ", senha=" + senha + ", cpf=" + cpf + ", crm=" + crm + ", especialidade="
				+ especialidade + "]";
	}
	
	
	
}
