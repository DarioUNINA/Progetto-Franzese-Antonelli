package dto;

public class AreeTematiche {

	private String nomeArea;

	public AreeTematiche() {
	}
	
	public AreeTematiche(String nomeArea) {
		this.nomeArea = nomeArea;
	}

	public String getNomeArea() {
		return nomeArea;
	}

	public void setNomeArea(String nomeArea) {
		this.nomeArea = nomeArea;
	}

	public String toString() {
		return nomeArea;
		
	}
}
