package dto;

import java.util.Vector;

public class Corsi {

	private String nome;
	private String descrizione;
	private int presenzeMin;
	private int maxPartecipanti;
	private String idCorso;
	private String paroleChiave;
	private String anno;
	private boolean terminato;
	private String idOperatore;
	private Vector<Lezioni> lezioni;
	private Vector<Iscrizioni> iscrizioni;
	private Operatori operatore;
	private Vector<Caratterizza> caratterizza;
	private Vector<Temi> temi;
	
	
	
	public Corsi() {
	}

	public Corsi(String nome, String descrizione, int presenzeMin, int maxPartecipanti, String idCorso,
			String paroleChiave, String anno, boolean terminato, String idOperatore) {
		this.nome = nome;
		this.descrizione = descrizione;
		this.presenzeMin = presenzeMin;
		this.maxPartecipanti = maxPartecipanti;
		this.idCorso = idCorso;
		this.paroleChiave = paroleChiave;
		this.anno = anno;
		this.terminato = terminato;
		this.idOperatore = idOperatore;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public int getPresenzeMin() {
		return presenzeMin;
	}
	public void setPresenzeMin(int presenzeMin) {
		this.presenzeMin = presenzeMin;
	}
	public int getMaxPartecipanti() {
		return maxPartecipanti;
	}
	public void setMaxPartecipanti(int maxPartecipanti) {
		this.maxPartecipanti = maxPartecipanti;
	}
	public String getIdCorso() {
		return idCorso;
	}
	public void setIdCorso(String idCorso) {
		this.idCorso = idCorso;
	}
	public String getParoleChiave() {
		return paroleChiave;
	}
	public void setParoleChiave(String paroleChiave) {
		this.paroleChiave = paroleChiave;
	}
	public String getAnno() {
		return anno;
	}
	public void setAnno(String anno) {
		this.anno = anno;
	}
	public boolean isTerminato() {
		return terminato;
	}
	public void setTerminato(boolean terminato) {
		this.terminato = terminato;
	}
	public String getIdOperatore() {
		return idOperatore;
	}
	public void setIdOperatore(String idOperatore) {
		this.idOperatore = idOperatore;
	}
	
	public String toString() {
		
		return this.nome;
	}	
}