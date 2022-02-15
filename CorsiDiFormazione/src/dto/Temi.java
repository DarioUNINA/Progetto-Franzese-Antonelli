package dto;

public class Temi {

	private String nomeArea;
	private String idCorso;
	private Corsi corso;
	private AreeTematiche areaTematica;
	
	
		public Temi(String nomeArea, String idCorso) {
		this.nomeArea = nomeArea;
		this.idCorso = idCorso;
	}

		
	public String getNomeArea() {
		return nomeArea;
	}

	public void setNomeArea(String nomeArea) {
		this.nomeArea = nomeArea;
	}

	public String getIdCorso() {
		return idCorso;
	}

	public void setIdCorso(String idCorso) {
		this.idCorso = idCorso;
	}


	public Corsi getCorso() {
		return corso;
	}


	public void setCorso(Corsi corso) {
		this.corso = corso;
	}


	public AreeTematiche getAreaTematica() {
		return areaTematica;
	}


	public void setAreaTematica(AreeTematiche areaTematica) {
		this.areaTematica = areaTematica;
	}

}
