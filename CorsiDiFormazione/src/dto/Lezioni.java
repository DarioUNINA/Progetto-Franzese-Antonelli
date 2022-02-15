package dto;

import java.util.Date;
import java.util.Vector;
import java.sql.Time;

public class Lezioni {

	private	Time durata;
	private String titolo;
	private String descrizione;
	private Time orario;
	private String idCorso;
	private String idLezione;
	private Date data;
	private Corsi corso;
	private Vector<Presenze> presenze;
	
	public Lezioni() {
	}
	
	public Lezioni(Time durata, String titolo, String descrizione, Time orario, String idCorso, String idLezione,
			Date data) {
		this.durata = durata;
		this.titolo = titolo;
		this.descrizione = descrizione;
		this.orario = orario;
		this.idCorso = idCorso;
		this.idLezione = idLezione;
		this.data = data;
	}
	
	public Lezioni(Time durata, String titolo, String descrizione, Time orario, String idCorso,	Date data) {
		
		this.durata = durata;
		this.titolo = titolo;
		this.descrizione = descrizione;
		this.orario = orario;
		this.idCorso = idCorso;
		this.idLezione = idLezione;
		this.data = data;
	}

	public Time getDurata() {
		return durata;
	}

	public void setDurata(Time durata) {
		this.durata = durata;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Time getOrario() {
		return orario;
	}

	public void setOrario(Time orario) {
		this.orario = orario;
	}

	public String getIdCorso() {
		return idCorso;
	}

	public void setIdCorso(String idCorso) {
		this.idCorso = idCorso;
	}

	public String getIdLezione() {
		return idLezione;
	}

	public void setIdLezione(String idLezione) {
		this.idLezione = idLezione;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	public Corsi getCorso() {
		return corso;
	}

	public void setCorso(Corsi corso) {
		this.corso = corso;
	}

	public Vector<Presenze> getPresenze() {
		return presenze;
	}

	public void setPresenze(Vector<Presenze> presenze) {
		this.presenze = presenze;
	}

	public String toString() {
		return this.titolo;

	}

}
