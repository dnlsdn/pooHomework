package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoNonValido extends AbstractComando implements Comando{

	private static final String NOME_COMANDO = "comando non valido";

	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio("Questo comando non è valido");
	}
	
	@Override
	public String getNome() {
		return NOME_COMANDO;
	}

}
