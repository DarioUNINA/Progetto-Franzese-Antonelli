package dto;

import java.util.Vector;

public class Operatori {

	private String idOperatore;
	private String nomeUtente;
	private String password;
	private Vector<Corsi> corsi;
	private DomandeOperatori domandeOperatore;
	
	public Operatori(String idOperatore, String nomeUtente, String password) {
		this.idOperatore = idOperatore;
		this.nomeUtente = nomeUtente;
		this.password = password;
	}
	
	public Operatori(String nomeUtente, String password) {
		this.nomeUtente = nomeUtente;
		this.password = password;
	}
	
	public Operatori(String nomeUtente) {
		this.nomeUtente = nomeUtente;
	}
	
	public Vector<Corsi> getCorsi() {
		return corsi;
	}

	public void setCorsi(Vector<Corsi> corsi) {
		this.corsi = corsi;
	}

	public DomandeOperatori getDomandeOperatore() {
		return domandeOperatore;
	}

	public void setDomandeOperatore(DomandeOperatori domandeOperatore) {
		this.domandeOperatore = domandeOperatore;
	}
	
	public String getIdOperatore() {
		return idOperatore;
	}

	public void setIdOperatore(String idOperatore) {
		this.idOperatore = idOperatore;
	}

	public String getNomeUtente() {
		return nomeUtente;
	}

	public void setNomeUtente(String nomeUtente) {
		this.nomeUtente = nomeUtente;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
