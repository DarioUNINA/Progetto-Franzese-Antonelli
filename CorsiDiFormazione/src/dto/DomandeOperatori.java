package dto;

public class DomandeOperatori {
	
	private String idDomanda;
	private String idOperatore;
	private String risposta;
	
	

	public String getIdDomanda() {
		return idDomanda;
	}

	public void setDomanda(String idDomanda) {
		this.idDomanda = idDomanda;
	}

	public String getIdOperatore() {
		return idOperatore;
	}

	public void setIdOperatore(String idOperatore) {
		this.idOperatore = idOperatore;
	}

	public String getRisposta() {
		return risposta;
	}

	public void setRisposta(String risposta) {
		this.risposta = risposta;
	}

	public DomandeOperatori(String idDomanda, String idOperatore, String risposta) {
		this.idDomanda = idDomanda;
		this.idOperatore = idOperatore;
		this.risposta = risposta;
	}
	
}
