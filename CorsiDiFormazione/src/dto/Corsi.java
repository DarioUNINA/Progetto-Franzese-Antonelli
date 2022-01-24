package dto;

public class Corsi {

	private String Nome;
	private String Descrizione;
	private int PresenzeMin;
	private int MaxPartecipanti;
	private String IdCorso;
	private String ParoleChiave;
	private boolean Terminato;
	private String IdOperatore;

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getDescrizione() {
		return Descrizione;
	}

	public void setDescrizione(String descrizione) {
		Descrizione = descrizione;
	}

	public int getPresenzeMin() {
		return PresenzeMin;
	}

	public void setPresenzeMin(int presenzeMin) {
		PresenzeMin = presenzeMin;
	}

	public int getMaxPartecipanti() {
		return MaxPartecipanti;
	}

	public void setMaxPartecipanti(int maxPartecipanti) {
		MaxPartecipanti = maxPartecipanti;
	}

	public String getIdCorso() {
		return IdCorso;
	}

	public void setIdCorso(String idCorso) {
		IdCorso = idCorso;
	}

	public String getParoleChiave() {
		return ParoleChiave;
	}

	public void setParoleChiave(String paroleChiave) {
		ParoleChiave = paroleChiave;
	}

	public boolean isTerminato() {
		return Terminato;
	}

	public void setTerminato(boolean terminato) {
		Terminato = terminato;
	}

	public Corsi(String Nome, String Descrizione, int PresenzeMin, int MaxPartecipanti, String IdCorso,
			String ParoleChiave, boolean Terminato, String IdOperatore) {
		this.Nome = Nome;
		this.Descrizione = Descrizione;
		this.PresenzeMin = PresenzeMin;
		this.MaxPartecipanti = MaxPartecipanti;
		this.IdCorso = IdCorso;
		this.ParoleChiave = ParoleChiave;
		this.Terminato = Terminato;
		this.IdOperatore = IdOperatore;
	}
}