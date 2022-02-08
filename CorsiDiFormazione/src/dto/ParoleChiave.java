package dto;

public class ParoleChiave {
	private String parolaChiave;

	
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
