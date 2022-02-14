package dto;

import java.util.Vector;

public class DomandeSicurezza {
	
	private String idDomanda;
	private String domanda;
	private Vector<DomandeOperatori> domandaSicurezza;
	
	public String getIdDomanda() {
		return idDomanda;
	}

	public void setIdDomanda(String idDomanda) {
		this.idDomanda = idDomanda;
	}
	
	public DomandeSicurezza(String idDomanda) {
		this.idDomanda = idDomanda;
	}
	
	public String getDomanda() {
		return domanda;
	}

	public void setDomanda(String domanda) {
		this.domanda = domanda;
	}

	public DomandeSicurezza() {}
	
	public String toString() {
		return this.getDomanda();
	}
}
