package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa extends AbstractComando implements Comando{
	
	private static final String NOME_COMANDO = "posa";
	

	@Override
	public void esegui(Partita partita) {
		if (partita.getGiocatore().getBorsa().hasAttrezzo(parametro)) {
			Attrezzo attrezzoPosa = partita.getGiocatore().getBorsa().removeAttrezzo(parametro);
			if (partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzoPosa)) {
				io.mostraMessaggio("Hai posato: " + parametro);
			}else {
				io.mostraMessaggio("La stanza è piena, l'attrezzo non è stato posato");
				partita.getGiocatore().getBorsa().addAttrezzo(attrezzoPosa);
			}
		} else {
			io.mostraMessaggio("Non è presente l'attrezzo " + parametro);
		}
		
	}
	
	@Override
	public String getNome() {
		return NOME_COMANDO;
	}
}
