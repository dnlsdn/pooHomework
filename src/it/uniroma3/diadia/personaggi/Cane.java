package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio {
	
	private static final String MESSAGGIO_MORSO = "Il cane ti ha morso!!!";
	public static final String CIBO_PREFERITO = "osso";

	public Cane(String nome, String presentazione) {
		super(nome, presentazione);
	}

	@Override
	public String agisci(Partita partita) {
		int cfuCorrenti = partita.getGiocatore().getCfu();
		partita.getGiocatore().setCfu(cfuCorrenti-1);
		return MESSAGGIO_MORSO;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		if (attrezzo.getNome() == CIBO_PREFERITO) {
			partita.getStanzaCorrente().addAttrezzo(new Attrezzo("collare", 1));
			return "Grazie per l'osso, ecco un attrezzo in regalo";
		}
		int cfu_correnti = partita.getGiocatore().getCfu();
		partita.getGiocatore().setCfu(--cfu_correnti);
		return "Non è il mio cibo preferito, i cfu sono stati diminuiti";
	}
}
