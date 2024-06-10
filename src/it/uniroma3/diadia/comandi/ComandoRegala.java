package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoRegala extends AbstractComando implements Comando{
	public final static String NOME_COMANDO = "regala";
	

	@Override
	public void esegui(Partita partita) {
		if (this.getParametro() == null) {
			System.out.println("Quale dei seguenti attrezzi vuoi regalare?");
			partita.getGiocatore().getBorsa().toString();
		}
		
		if(partita.getGiocatore().getBorsa().hasAttrezzo(this.getParametro())) {
			Attrezzo attrezzoDaRegalare = partita.getGiocatore().getBorsa().getAttrezzo(this.getParametro());
			partita.getStanzaCorrente().getPersonaggio().riceviRegalo(attrezzoDaRegalare, partita);
		}else {
			System.out.println("Non possiedi l'attrezzo " + this.getParametro());
		}
	}
	
	@Override
	public String getNome() {
		return NOME_COMANDO;
	}
}
