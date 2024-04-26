package it.uniroma3.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {

	private String[] elencoComandi = { "vai", "aiuto", "fine", "prendi", "posa", "guarda" };
	private IO io;

	@Override
	public void esegui(Partita partita) {
		for (int i = 0; i < elencoComandi.length; i++)
			this.io.mostraMessaggio(elencoComandi[i] + " ");
		this.io.mostraMessaggio("");
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
