package it.uniroma3.diadia.comandi;

import java.util.Iterator;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.*;;

public class ComandoGuarda implements Comando{
	private Attrezzo[] attrezziInStanza;
	

	@Override
	public void esegui(Partita partita) {
		
		System.out.println("Nome stanza: " + partita.getStanzaCorrente().getNome());
		attrezziInStanza = partita.getStanzaCorrente().getAttrezzi();
		
		stampaAttrezziInStanza();
		System.out.println("CFU disponibili: " + partita.getGiocatore().getCfu());
	}
	
	public void stampaAttrezziInStanza() {
		System.out.print("Attrezzi in stanza: ");
		for (int i = 0; i < attrezziInStanza.length; i++) {
			if (attrezziInStanza[i] != null) {
				System.out.print(attrezziInStanza[i] + " ");
			}
		}
		System.out.println("");
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String getNome() {
		return "guarda";
	}

	@Override
	public String getParametro() {
		return "Questo comando non ha parametri";
	}

}
