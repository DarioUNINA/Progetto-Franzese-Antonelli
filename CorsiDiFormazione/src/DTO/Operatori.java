package CorsiDiFormazione;

public class Operatori {
	
	private String IdOperatore;
	private String NomeUtente;
	private String Password;
	
	
	public String getIdOperatore() {
		return IdOperatore;
	}
	public void setIdOperatore(String idOperatore) {
		IdOperatore = idOperatore;
	}
	public String getNomeUtente() {
		return NomeUtente;
	}
	public void setNomeUtente(String nomeUtente) {
		NomeUtente = nomeUtente;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}

	public Operatori(String IdOperatore, String NomeUtente, String Password) {
		
		this.IdOperatore = IdOperatore;
		this.NomeUtente = NomeUtente;
		this.Password = Password;
	}

	
}
