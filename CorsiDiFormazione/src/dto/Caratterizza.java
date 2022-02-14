package dto;

public class Caratterizza {

	private String parolaChiave;
	private String idCorso;
	private Corsi corso;
	private ParoleChiave paroleChiave;
	
	
	public Caratterizza(String parolaChiave, String idCorso) {
		this.parolaChiave = parolaChiave;
		this.idCorso = idCorso;
	}


	public String getParolaChiave() {
		return parolaChiave;
	}


	public void setParolaChiave(String parolaChiave) {
		this.parolaChiave = parolaChiave;
	}


	public String getIdCorso() {
		return idCorso;
	}


	public void setIdCorso(String idCorso) {
		this.idCorso = idCorso;
	}
	
	
}
