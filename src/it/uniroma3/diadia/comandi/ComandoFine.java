package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando {
	private IO io;

	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio("Grazie di aver giocato!");

	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

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
