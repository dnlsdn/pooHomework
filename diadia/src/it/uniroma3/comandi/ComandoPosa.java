package it.uniroma3.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {
	private String nomeAttrezzo;
	private IO io;

	@Override
	public void esegui(Partita partita) {
		if (partita.getGiocatore().getBorsa().hasAttrezzo(this.nomeAttrezzo)) {
			Attrezzo attrezzoPosa = partita.getGiocatore().getBorsa().removeAttrezzo(this.nomeAttrezzo);
			if (partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzoPosa)) {
				io.mostraMessaggio("Hai posato: " + this.nomeAttrezzo);
			} else {
				io.mostraMessaggio("La stanza è piena, l'attrezzo non è stato posato");
				partita.getGiocatore().getBorsa().addAttrezzo(attrezzoPosa);
			}
		} else {
			io.mostraMessaggio("Non è presente l'attrezzo " + this.nomeAttrezzo);
		}

	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;

	}

	@Override
	public void getNome() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getParametro() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setIO(IO io) {
		this.io = io;
	}

}
