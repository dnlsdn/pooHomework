package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando{

	private IOConsole io;

	@Override
	public void esegui(Partita partita) {
		System.out.println("Questo comando non è valido");
	}

	@Override
	public void setParametro(String parametro) {}
	
	@Override
	public String getNome() {
		return "comando non valido";
	}

	@Override
	public String getParametro() {
		return null;
	}
	
	@Override
	public void setIO(IOConsole io) {
		this.io = io;	
	}
	
}
