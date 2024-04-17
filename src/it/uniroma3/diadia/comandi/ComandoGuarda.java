package it.uniroma3.diadia.comandi;

import java.util.Iterator;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.*;;

public class ComandoGuarda implements Comando{

	private IOConsole io;

	@Override
	public void esegui(Partita partita) {
		System.out.println(partita.getStanzaCorrente().toString()+ partita.getGiocatore().toString());
	}

	@Override
	public void setParametro(String parametro) {}
	
	@Override
	public String getNome() {
		return "guarda";
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
