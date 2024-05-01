package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {
	private IO io;
	private String nomeAttrezzo;

	@Override
	public void esegui(Partita partita) {
		if (partita.getLabirinto().getStanzaCorrente().hasAttrezzo(this.nomeAttrezzo)) {

			Attrezzo attrezzoPrendi = partita.getLabirinto().getStanzaCorrente().getAttrezzo(this.nomeAttrezzo);

			partita.getLabirinto().getStanzaCorrente().removeAttrezzo(attrezzoPrendi);
			partita.getGiocatore().getBorsa().addAttrezzo(attrezzoPrendi);
			io.mostraMessaggio("Hai preso: " + this.nomeAttrezzo);

		} else {
			io.mostraMessaggio("Non è possibile prendere l'attrezzo desiderato \n");
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
