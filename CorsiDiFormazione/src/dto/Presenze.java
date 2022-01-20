package dto;

public class Presenze {
	
	private String	matricola;
	private String	idLezione;
	
	
	public Presenze(String matricola, String idLezione) {
		this.matricola = matricola;
		this.idLezione = idLezione;
	}


	public String getMatricola() {
		return matricola;
	}


	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}


	public String getIdLezione() {
		return idLezione;
	}


	public void setIdLezione(String idLezione) {
		this.idLezione = idLezione;
	}
	
	
	
	
}
