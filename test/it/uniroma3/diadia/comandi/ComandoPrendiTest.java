package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Labirinto.LabirintoBuilder;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendiTest {

	private ComandoPrendi comandoPrendi;
	private Partita partita;
	private IOConsole io;
	private Attrezzo attrezzo;
	private Labirinto labirinto;

	@Before
	public void setUp() {
		this.comandoPrendi = new ComandoPrendi();
		this.labirinto = new LabirintoBuilder()
				.addStanzaIniziale("Biblioteca")
				.addStanzaVincente("N10")
				.getLabirinto();
		this.partita = new Partita(labirinto);
		this.io = new IOConsole(new Scanner(System.in));
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
			Attrezzo nuovoAttrezzo = new Attrezzo("nuovoAttrezzo"+i, 1);
			partita.getGiocatore().getBorsa().addAttrezzo(nuovoAttrezzo);
		}
	}
}
