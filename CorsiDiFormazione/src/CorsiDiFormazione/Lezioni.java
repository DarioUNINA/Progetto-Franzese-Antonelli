package CorsiDiFormazione;

import java.time.LocalDate;

public class Lezioni {
	
	private String Durata;
	private String Titolo;
	private String Descrizione;
	private String Orario;
	private String IdCorso;
	private String IdLezione;
	private LocalDate Data;
	
	
	public Lezioni(String Durata, String Titolo, String Descrizione, String Orario, String IdCorso, String IdLezione,
			LocalDate Data) {
		this.Durata = Durata;
		this.Titolo = Titolo;
		this.Descrizione = Descrizione;
		this.Orario = Orario;
		this.IdCorso = IdCorso;
		this.IdLezione = IdLezione;
		this.Data = Data;
	}
	public String getDurata() {
		return Durata;
	}
	public void setDurata(String durata) {
		Durata = durata;
	}
	public String getTitolo() {
		return Titolo;
	}
	public void setTitolo(String titolo) {
		Titolo = titolo;
	}
	public String getDescrizione() {
		return Descrizione;
	}
	public void setDescrizione(String descrizione) {
		Descrizione = descrizione;
	}
	public String getOrario() {
		return Orario;
	}
	public void setOrario(String orario) {
		Orario = orario;
	}
	public String getIdCorso() {
		return IdCorso;
	}
	public void setIdCorso(String idCorso) {
		IdCorso = idCorso;
	}
	public String getIdLezione() {
		return IdLezione;
	}
	public void setIdLezione(String idLezione) {
		IdLezione = idLezione;
	}
	public LocalDate getData() {
		return Data;
	}
	public void setData(LocalDate data) {
		Data = data;
	}

}
