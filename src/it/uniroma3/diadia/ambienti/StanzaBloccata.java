package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.IO;

public class StanzaBloccata extends Stanza{
	private String nomeAttrezzoNecessario;
	private String direzioneBloccata;
	private IO io;

	public StanzaBloccata(String nome, String nomeAttrezzoNecessario, String direzioneBloccata) {
		super(nome);
		this.nomeAttrezzoNecessario = nomeAttrezzoNecessario;
		this.direzioneBloccata = direzioneBloccata;
	}

	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if (super.hasAttrezzo(nomeAttrezzoNecessario)) {
			return super.getStanzaAdiacente(direzione);
		}

		io.mostraMessaggio("La direzione " + direzione + " non è raggiungibile");
		return this;
	}

	@Override
	public String getDescrizione() {
		StringBuilder s = new StringBuilder();
		s.append("Direzione bloccata: " + this.direzioneBloccata);
		s.append("Attrezzo sbloccante: " + this.nomeAttrezzoNecessario);

		return s.toString();
	}
}


