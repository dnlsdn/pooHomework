package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccata extends Stanza{
	private String nomeAttrezzoNecessario;
	private String direzioneBloccata;

	public StanzaBloccata(String nome, String nomeAttrezzoNecessario, String direzioneBloccata) {
		super(nome);
		this.nomeAttrezzoNecessario = nomeAttrezzoNecessario;
		this.direzioneBloccata = direzioneBloccata;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		Attrezzo[] attrezziPresenti = super.getAttrezzi();
		for (int i = 0; i < attrezziPresenti.length; i++) {
			if (attrezziPresenti[i] != null && attrezziPresenti[i].getNome() == this.nomeAttrezzoNecessario) {
				return super.getStanzaAdiacente(direzione);
			}
		}
		System.out.println("La direzione " + direzione + " non è raggiungibile");
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


