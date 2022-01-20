package dto;

public class Iscrizioni {

	private boolean Ammesso;
	private String Matricola;
	private String IdCorso;

	public Iscrizioni(boolean Ammesso, String Matricola, String IdCorso) {
		this.Ammesso = Ammesso;
		this.Matricola = Matricola;
		this.IdCorso = IdCorso;
	}

	public boolean isAmmesso() {
		return Ammesso;
	}

	public void setAmmesso(boolean ammesso) {
		Ammesso = ammesso;
	}

	public String getMatricola() {
		return Matricola;
	}

	public void setMatricola(String matricola) {
		Matricola = matricola;
	}

	public String getIdCorso() {
		return IdCorso;
	}

	public void setIdCorso(String idCorso) {
		IdCorso = idCorso;
	}

}
