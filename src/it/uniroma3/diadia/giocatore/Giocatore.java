package it.uniroma3.diadia.giocatore;

public class Giocatore {
	
	static final private int CFU_INIZIALI = 20;
	
	private Borsa borsa;
	private int cfu;

	
	public Giocatore() {
		this.cfu = CFU_INIZIALI;
		this.borsa = new Borsa();
	}
	
	public Borsa getBorsa() {
		return this.borsa;
	}
	
	public int getCfu() {
		return this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		
		result.append("\nNumero CFU: " + this.cfu + "\n");
		result.append("Attrezzi in borsa: " + getBorsa().toString());
		
		return result.toString();
	}
}
