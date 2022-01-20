package dto;

public class Presenze {

	private String Matricola;
	private String IdLezione;

	public Presenze(String Matricola, String IdLezione) {
		this.Matricola = Matricola;
		this.IdLezione = IdLezione;
	}

	public String getMatricola() {
		return Matricola;
	}

	public void setMatricola(String matricola) {
		Matricola = matricola;
	}

	public String getIdLezione() {
		return IdLezione;
	}

	public void setIdLezione(String idLezione) {
		IdLezione = idLezione;
	}

}
