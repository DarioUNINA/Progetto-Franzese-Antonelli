package dto;

import java.util.Vector;

public class DomandeSicurezza {
	
	private String idDomanda;
	private String domanda;
	private Vector<DomandeOperatori> domandaSicurezza;
	
	
	public DomandeSicurezza() {}
	
	public DomandeSicurezza(String idDomanda) {
		this.idDomanda = idDomanda;
	}
	
	
	public Vector<DomandeOperatori> getDomandaSicurezza() {
		return domandaSicurezza;
	}

	public void setDomandaSicurezza(Vector<DomandeOperatori> domandaSicurezza) {
		this.domandaSicurezza = domandaSicurezza;
	}

	public String getIdDomanda() {
		return idDomanda;
	}

	public void setIdDomanda(String idDomanda) {
		this.idDomanda = idDomanda;
	}
	
	
	public String getDomanda() {
		return domanda;
	}

	public void setDomanda(String domanda) {
		this.domanda = domanda;
	}

	public String toString() {
		return this.getDomanda();
	}
}
