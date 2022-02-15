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

	public Corsi getCorso() {
		return corso;
	}


	public void setCorso(Corsi corso) {
		this.corso = corso;
	}


	public ParoleChiave getParoleChiave() {
		return paroleChiave;
	}


	public void setParoleChiave(ParoleChiave paroleChiave) {
		this.paroleChiave = paroleChiave;
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
