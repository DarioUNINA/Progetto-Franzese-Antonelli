package dto;

import java.util.Vector;

public class ParoleChiave {
	
	private String parolaChiave;
	private Vector<Caratterizza> caratterizza;

	
	public ParoleChiave() {
	}
		
	public  ParoleChiave(String parolaChiave) {
		this.parolaChiave = parolaChiave;
	}
	
	public String getParolaChiave() {
		return parolaChiave;
	}

	public void setParolaChiave(String parolaChiave) {
		this.parolaChiave = parolaChiave;
	}
	
	public String toString() {
		return parolaChiave;
		
	}

}
