package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

/**
 * Cerca di andare in una direzione. Se c'e' una stanza ci entra e ne stampa il
 * nome, altrimenti stampa un messaggio di errore
 */

public class ComandoVai implements Comando {
	
	private String direzione;
	private IOConsole io;

	public ComandoVai(String direzione) {
		this.direzione = direzione;
	}
	/**
	 * esecuzione del comando
	 */
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null;

		if(direzione == null) {
			System.out.println("Dove vuoi andare? Devi specificare una direzione");
			return;
		}
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
		if (prossimaStanza == null) {
			System.out.println("Direzione inesistente");
			return;
		}
		partita.setStanzaCorrente(prossimaStanza);
		System.out.println("Sei ora nella stanza: " + prossimaStanza.getNome());
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu() -1);

	} 
	@Override
	public void setParametro(String parametro) {
		this.direzione= parametro;
	}

	@Override
	public String getNome() {
		return "vai";
	}

	@Override
	public String getParametro() {
		return this.direzione;
	}
	
	@Override
	public void setIO(IOConsole io) {
		this.io = io;	
	}
}
