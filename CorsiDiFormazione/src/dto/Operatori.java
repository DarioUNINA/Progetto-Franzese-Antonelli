package dto;

public class Operatori {

	private String idOperatore;
	private String nomeUtente;
	private String password;
	
	
	public Operatori(String idOperatore, String nomeUtente, String password) {
		this.idOperatore = idOperatore;
		this.nomeUtente = nomeUtente;
		this.password = password;
	}
	
	public Operatori(String nomeUtente, String password) {
		this.nomeUtente = nomeUtente;
		this.password = password;
	}
	
	public Operatori(String nomeUtente) {
		this.nomeUtente = nomeUtente;
	}
	
	public String getIdOperatore() {
		return idOperatore;
	}

	public void setIdOperatore(String idOperatore) {
		this.idOperatore = idOperatore;
	}

	public String getNomeUtente() {
		return nomeUtente;
	}

	public void setNomeUtente(String nomeUtente) {
		this.nomeUtente = nomeUtente;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
