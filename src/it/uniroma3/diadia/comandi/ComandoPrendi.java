package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando{
	private String nomeAttrezzo;
	
	public ComandoPrendi(String nomeAttrezzo) {
		this.nomeAttrezzo = nomeAttrezzo;
	}

	@Override
	public void esegui(Partita partita) {
		if (partita.getLabirinto().getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {

			Attrezzo attrezzoPrendi = partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);

			partita.getLabirinto().getStanzaCorrente().removeAttrezzo(attrezzoPrendi);
			partita.getGiocatore().getBorsa().addAttrezzo(attrezzoPrendi);
			System.out.println("Hai preso: " + nomeAttrezzo);

		} else {
			System.out.println("Non è possibile prendere l'attrezzo desiderato \n");
		}
		
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
		
	}
	
	@Override
	public String getNome() {
		return "prendi";
	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}

}
