package dto;

import java.util.Vector;

public class AreeTematiche {

	private String nomeArea;
	private Vector<Temi> temi;

	public AreeTematiche() {
	}
	
	public AreeTematiche(String nomeArea) {
		this.nomeArea = nomeArea;
	}

	public String getNomeArea() {
		return nomeArea;
	}

	public void setNomeArea(String nomeArea) {
		this.nomeArea = nomeArea;
	}

	public Vector<Temi> getTemi() {
		return temi;
	}

	public void setTemi(Vector<Temi> temi) {
		this.temi = temi;
	}

	public String toString() {
		return nomeArea;
		
	}
}
