package dto;

public class Iscrizioni {

	private boolean ammesso;
	private String matricola;
	private String idCorso;
	private Corsi corso;
	private Studenti studente;
	
	public Iscrizioni(boolean ammesso, String matricola, String idCorso) {
		this.ammesso = ammesso;
		this.matricola = matricola;
		this.idCorso = idCorso;
	}

	public boolean isAmmesso() {
		return ammesso;
	}

	public void setAmmesso(boolean ammesso) {
		this.ammesso = ammesso;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
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

	public Studenti getStudente() {
		return studente;
	}

	public void setStudente(Studenti studente) {
		this.studente = studente;
	}

	
}
