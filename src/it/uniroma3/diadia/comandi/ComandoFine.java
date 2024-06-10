package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoFine extends AbstractComando implements Comando{
	
	private static final String NOME_COMANDO = "fine";
	final public static String MESSAGGIO_FINE = "Grazie di aver giocato!";

	@Override
	public void esegui(Partita partita) {
		partita.setFinita();
		io.mostraMessaggio(MESSAGGIO_FINE); // si desidera smettere
	}
	
	@Override
	public String getNome() {
		return NOME_COMANDO;
	}
}
