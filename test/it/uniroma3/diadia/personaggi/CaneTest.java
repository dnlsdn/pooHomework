package it.uniroma3.diadia.personaggi;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Labirinto.LabirintoBuilder;

public class CaneTest {
	private Labirinto labirinto;
	private Partita partita;
	private Cane cane;
	

	@Before
	public void setUp() throws Exception {
		labirinto = new LabirintoBuilder()
				.addStanzaIniziale("Iniziale")
				.getLabirinto();
		partita = new Partita(labirinto);
		cane = new Cane("Rasha", "Bau");
	}

	@Test
	public void testAgisci() {
		assertTrue(partita.getGiocatore().getCfu() == 20);
		cane.agisci(partita);
		assertTrue(partita.getGiocatore().getCfu() == 19);
	}

}
