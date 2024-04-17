package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando{
	
	private String[] elencoComandi;
	private IOConsole io;
	
	public ComandoAiuto(String[] elencoComandi) {
		this.elencoComandi = elencoComandi;
	}

	@Override
	public void esegui(Partita partita) {
		for (int i = 0; i < this.elencoComandi.length; i++)
			System.out.println(this.elencoComandi[i] + " ");
		System.out.println("");
		
	}

	@Override
	public void setParametro(String parametro) {}

	@Override
	public String getNome() {
		return "aiuto";
	}

	@Override
	public String getParametro() {
		return "Questo comando non ha parametri";
	}

	@Override
	public void setIO(IOConsole io) {
		this.io = io;	
	}

}
