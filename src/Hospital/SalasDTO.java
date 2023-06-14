package Hospital;

public abstract class SalasDTO {

	
	private int id;
	private String nome;
	private String status;
	
	public SalasDTO (int id, String nome, String status) {
		this.id = id ;
		this.nome = nome;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "SalasDTO [id=" + id + ", nome=" + nome + ", status=" + status + "]";
	}
	
}

	