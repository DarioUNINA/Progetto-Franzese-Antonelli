package dto;

public class Temi {

	private String NomeArea;
	private String IdCorso;

	public Temi(String NomeArea, String IdCorso) {
		this.NomeArea = NomeArea;
		this.IdCorso = IdCorso;
	}

	public String getNomeArea() {
		return NomeArea;
	}

	public void setNomeArea(String nomeArea) {
		NomeArea = nomeArea;
	}

	public String getIdCorso() {
		return IdCorso;
	}

	public void setIdCorso(String idCorso) {
		IdCorso = idCorso;
	}

}
