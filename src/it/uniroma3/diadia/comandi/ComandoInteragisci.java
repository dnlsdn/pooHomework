package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoInteragisci extends AbstractComando implements Comando{
	
	private static final String NOME_COMANDO = "interagisci";
	private static final String MESSAGGIO_CON_CHI = "Con chi dovrei interagire?";
	private String messaggio;

	@Override
	public void esegui(Partita partita) {
		AbstractPersonaggio personaggio = partita.getStanzaCorrente().getPersonaggio();
		
		if(personaggio!= null) {
			this.messaggio = personaggio.agisci(partita);
			io.mostraMessaggio(messaggio);
		}else {
			io.mostraMessaggio(MESSAGGIO_CON_CHI);
		}
		
	}
	
	public String getMessaggio() {
		return this.messaggio;
	}

	@Override
	public String getNome() {
		return NOME_COMANDO;
	}
}
