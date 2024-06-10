package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends AbstractPersonaggio {
	
	private static final String MESSAGGIO_HAI_SALUTATO = "Hai salutato, verrai trasferito in una stanza adiacente con più attrezzi";
	private static final String MESSAGGIO_NON_HAI_SALUTATO = "Non hai salutato, verrai trasferito in una stanza adiacente con meno attrezzi";

	public Strega(String nome, String presentazione) {
		super(nome, presentazione);
	}

	@Override
	public String agisci(Partita partita) {
		int numAttrezziStanzaCorrente = partita.getStanzaCorrente().getAttrezzi().size();
		
		if(haSalutato()) {
			for(Stanza s: partita.getStanzaCorrente().getMapStanzeAdiacenti().values()) {
				if(s.getAttrezzi().size() >  numAttrezziStanzaCorrente) {
					partita.setStanzaCorrente(s);
				}
			}
			return MESSAGGIO_HAI_SALUTATO;
		}else {
			for(Stanza s: partita.getStanzaCorrente().getMapStanzeAdiacenti().values()) {
				if(s.getAttrezzi().size() <  numAttrezziStanzaCorrente) {
					partita.setStanzaCorrente(s);
				}
			}
			return MESSAGGIO_NON_HAI_SALUTATO;
		}
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		return "hahahaha";
	}
}
