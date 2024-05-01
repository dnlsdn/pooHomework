package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPosa;

public class ComandoPosaTest {

	private ComandoPosa comandoPosa;
	private Partita partita;
	private Attrezzo attrezzo;
	private IOConsole io;

	@Before
	public void setUp() {
		this.comandoPosa = new ComandoPosa();
		this.io = new IOConsole();
		comandoPosa.setIO(io);
		this.partita = new Partita();
		this.attrezzo = new Attrezzo("attrezzo", 2);
	}

	@Test
	public void testAttrezzoPosato() {
		comandoPosa.setParametro("attrezzo");
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		comandoPosa.esegui(partita);

		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("attrezzo"));
	}

	@Test
	public void testAttrezzoNonPosato() {
		creaEAggiungiAttrezziStanza();
		comandoPosa.setParametro("attrezzo");
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		comandoPosa.esegui(partita);

		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("attrezzo"));
	}

	@Test
	public void testNoAttrezzoBorsa() {
		comandoPosa.setParametro("attrezzo");
		comandoPosa.esegui(partita);
		assertFalse(partita.getLabirinto().getStanzaCorrente().hasAttrezzo("attrezzo"));
	}

	public void creaEAggiungiAttrezziStanza() {
		for (int i = 0; i < 11; i++) {
			Attrezzo newAttrezzo = new Attrezzo("nuovo", 1);
			partita.getLabirinto().getStanzaCorrente().addAttrezzo(newAttrezzo);
		}
	}
}
