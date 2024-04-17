package it.uniroma3.diadia.comandi;

import java.util.Scanner;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;


public class FabbricaDiComandiFisarmonica implements FabbricaDiComandi{
	
	static final private String[] elencoComandi = { "vai", "aiuto", "fine", "prendi", "posa", "guarda" };
	private IOConsole io;

	@Override
	public Comando costruisciComando(String istruzione, IO io) {
		Scanner scannerDiParole = new Scanner(istruzione);

		String nomeComando = null;
		String parametro = null;
		Comando comando = null;

		if (scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next();
		if (scannerDiParole.hasNext())
			parametro = scannerDiParole.next();

		if (nomeComando == null)
			comando = new ComandoNonValido();
		else if (nomeComando.equals("vai")) comando = new ComandoVai(parametro);
		else if (nomeComando.equals("prendi")) comando = new ComandoPrendi(parametro);
		else if (nomeComando.equals("posa")) comando = new ComandoPosa(parametro);
		else if (nomeComando.equals("aiuto")) comando = new ComandoAiuto(elencoComandi);
		else if (nomeComando.equals("fine")) comando = new ComandoFine();
		else if (nomeComando.equals("guarda")) comando = new ComandoGuarda();
		else comando = new ComandoNonValido();

		comando.setParametro(parametro);
		comando.setIO(this.io);
		return comando;
	}

}