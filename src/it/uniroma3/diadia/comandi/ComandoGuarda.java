package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;;

public class ComandoGuarda extends AbstractComando implements Comando{

	private static final String NOME_COMANDO = "guarda";

	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio(partita.getStanzaCorrente().toString()+ partita.getGiocatore().toString());
	}
	
	@Override
	public String getNome() {
		return NOME_COMANDO;
	}
}
