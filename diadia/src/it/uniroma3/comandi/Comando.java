package it.uniroma3.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public interface Comando {
	public void esegui(Partita partita);

	public void setParametro(String parametro);

	public void getNome();

	public void getParametro();

	public void setIO(IO io);
}