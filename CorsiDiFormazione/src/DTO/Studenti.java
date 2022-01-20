package dto;

public class Studenti {

	private String Matricola;
	private String Nome;
	private String Cognome;

	public String getMatricola() {
		return Matricola;
	}

	public void setMatricola(String matricola) {
		Matricola = matricola;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCognome() {
		return Cognome;
	}

	public void setCognome(String cognome) {
		Cognome = cognome;
	}

	public Studenti(String Matricola, String Nome, String Congome) {

		this.Cognome = Cognome;
		this.Matricola = Matricola;
		this.Nome = Nome;

	}

}
