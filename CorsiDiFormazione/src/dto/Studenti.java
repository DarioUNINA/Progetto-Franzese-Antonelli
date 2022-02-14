package dto;

import java.util.Vector;

public class Studenti {

	private String matricola;
	private String nome;
	private String cognome;
	private Vector<Iscrizioni> iscrizioni;
	
	public Studenti() {
		
	}
	public Studenti(String matricola, String nome, String cognome) {
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
	}
	
	public Studenti(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String toString() {
		return this.nome + " " +  this.cognome;
	}
}
