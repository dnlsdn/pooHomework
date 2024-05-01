package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPrendi;

public class ComandoPrendiTest {

	private ComandoPrendi comandoPrendi;
	private Partita partita;
	private IOConsole io;
	private Attrezzo attrezzo;

	@Before
	public void setUp() {
		this.comandoPrendi = new ComandoPrendi();
		this.partita = new Partita();
		this.io = new IOConsole();
		comandoPrendi.setIO(io);
		this.attrezzo = new Attrezzo("attrezzo", 2);
	}

	@Test
	public void testAttrezzoPreso() {
		partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzo);
		comandoPrendi.setParametro("attrezzo");
		comandoPrendi.esegui(partita);
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("attrezzo"));
	}

	@Test
	public void testAttrezzoNonPreso() {
		aggiungiAttrezziGiocatore();
		partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzo);
		comandoPrendi.setParametro("attrezzo");
		comandoPrendi.esegui(partita);
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("attrezzo"));
	}

	@Test
	public void testAttrezzoInesistente() {
		comandoPrendi.setParametro("attrezzo");
		comandoPrendi.esegui(partita);
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("attrezzo"));
	}

	public void aggiungiAttrezziGiocatore() {
		for (int i = 0; i < 11; i++) {
			Attrezzo nuovoAttrezzo = new Attrezzo("nuovoAttrezzo", 1);
			partita.getGiocatore().getBorsa().addAttrezzo(nuovoAttrezzo);
		}
	}
}
