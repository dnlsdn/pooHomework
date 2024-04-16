package it.uniroma3.diadia.ambienti;

import java.util.Iterator;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuia extends Stanza{
	
	private String nomeAttrezzoNecessario;

	public StanzaBuia(String nome, String nomeAttrezzoNecessario) {
		super(nome);
		this.nomeAttrezzoNecessario = nomeAttrezzoNecessario;
		
	}
	
	@Override
    public String getDescrizione() {
		Attrezzo[] attrezziPresenti = super.getAttrezzi();
		for (int i = 0; i < attrezziPresenti.length; i++) {
			if (attrezziPresenti[i] != null && attrezziPresenti[i].getNome() == this.nomeAttrezzoNecessario) {
				return super.getDescrizione();
			}
		}
        return "Qui c'è un buio pesto";
    }
}
