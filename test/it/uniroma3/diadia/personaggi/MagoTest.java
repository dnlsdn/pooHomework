package it.uniroma3.diadia.personaggi;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Labirinto.LabirintoBuilder;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class MagoTest {

	private Labirinto labirinto;
	private Partita partita;
	private Mago mago;
	

	@Before
	public void setUp() throws Exception {
		labirinto = new LabirintoBuilder()
				.addStanzaIniziale("Iniziale")
				.getLabirinto();
		partita = new Partita(labirinto);
		mago = new Mago("Merlino", "Bau", new Attrezzo("spada", 5));
	}

	@Test
	public void testAgisci() {
		assertTrue(partita.getStanzaCorrente().getAttrezzi().size() == 0);
		mago.agisci(partita);
		assertTrue(partita.getStanzaCorrente().getAttrezzi().size() == 1);
		mago.agisci(partita);
		assertTrue(partita.getStanzaCorrente().getAttrezzi().size() == 1);
	}

}
