package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {

	private String nomeAttrezzo = "";
	private String direzione = "";

	public StanzaBloccata(String nome, String nomeAttrezzo, String direzione) {
		super(nome);
		this.nomeAttrezzo = nomeAttrezzo;
		this.direzione = direzione;
	}

	@Override
	public Stanza getStanzaAdiacente(String dir) {
		if (!super.hasAttrezzo(nomeAttrezzo) && dir.equals(this.direzione)) {
			return this;
		} else {
			return super.getStanzaAdiacente(dir);
		}
	}

	@Override
	public String getDescrizione(String dir) {
		if (!super.hasAttrezzo(nomeAttrezzo) && dir.equals(this.direzione)) {
			return "la stanza adiacente e' bloccata";
		} else {
			return "";
		}
	}
}
