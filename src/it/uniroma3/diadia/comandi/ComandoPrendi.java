package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi extends AbstractComando implements Comando{
	private static final String NOME_COMANDO = "prendi";
	

	@Override
	public void esegui(Partita partita) {
		if (partita.getLabirinto().getStanzaCorrente().hasAttrezzo(parametro)) {

			Attrezzo attrezzoPrendi = partita.getLabirinto().getStanzaCorrente().getAttrezzo(parametro);

			partita.getLabirinto().getStanzaCorrente().removeAttrezzo(attrezzoPrendi);
			partita.getGiocatore().getBorsa().addAttrezzo(attrezzoPrendi);
			io.mostraMessaggio("Hai preso: " + parametro);

		} else {
			io.mostraMessaggio("Non è possibile prendere l'attrezzo desiderato \n");
		}
		
	}
	
	@Override
	public String getNome() {
		return NOME_COMANDO;
	}
}
