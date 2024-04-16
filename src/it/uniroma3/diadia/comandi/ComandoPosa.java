package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando{
	
	private String nomeAttrezzo;
	
	public ComandoPosa(String nomeAttrezzo) {
		this.nomeAttrezzo = nomeAttrezzo;
	}

	@Override
	public void esegui(Partita partita) {
		if (partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
			Attrezzo attrezzoPosa = partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
			if (partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzoPosa)) {
				System.out.println("Hai posato: " + nomeAttrezzo);
			}else {
				System.out.println("La stanza è piena, l'attrezzo non è stato posato");
				partita.getGiocatore().getBorsa().addAttrezzo(attrezzoPosa);
			}
		} else {
			System.out.println("Non è presente l'attrezzo " + nomeAttrezzo);
		}
		
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
		
	}
	
	@Override
	public String getNome() {
		return "posa";
	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}

}
