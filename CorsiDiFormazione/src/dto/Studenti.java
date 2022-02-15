package dto;

import java.util.Vector;

public class Studenti {

	private String matricola;
	private String nome;
	private String cognome;
	private Vector<Iscrizioni> iscrizioni;
	private Vector<Presenze> presenze;
	
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

	public Vector<Iscrizioni> getIscrizioni() {
		return iscrizioni;
	}
	public void setIscrizioni(Vector<Iscrizioni> iscrizioni) {
		this.iscrizioni = iscrizioni;
	}
	public Vector<Presenze> getPresenze() {
		return presenze;
	}
	public void setPresenze(Vector<Presenze> presenze) {
		this.presenze = presenze;
	}
	public String toString() {
		return this.nome + " " +  this.cognome;
	}
}
