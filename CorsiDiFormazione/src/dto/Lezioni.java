package dto;

import java.sql.Date;
import java.time.LocalDate;

public class Lezioni {

	private String durata;
	private String titolo;
	private String descrizione;
	private String orario;
	private String idCorso;
	private String idLezione;
	private Date data;
	
	public Lezioni() {
	}
	
	public Lezioni(String durata, String titolo, String descrizione, String orario, String idCorso, String idLezione,
			Date data) {
		this.durata = durata;
		this.titolo = titolo;
		this.descrizione = descrizione;
		this.orario = orario;
		this.idCorso = idCorso;
		this.idLezione = idLezione;
		this.data = data;
	}

	public String getDurata() {
		return durata;
	}

	public void setDurata(String durata) {
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

	public String getOrario() {
		return orario;
	}

	public void setOrario(String orario) {
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
	
	public String toString() {
		return this.titolo;

	}

}
