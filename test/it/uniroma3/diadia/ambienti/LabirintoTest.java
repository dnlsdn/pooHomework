package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto.LabirintoBuilder;

public class LabirintoTest {
	private Labirinto labirinto;
	
	@Before
	public void setUp() {
		labirinto = new LabirintoBuilder()
			.addStanzaIniziale("Atrio")
			.addStanzaVincente("Biblioteca")
			.getLabirinto();
	}
	
	@Test
	public void testStanzaCorrenteCorretta() {
		assertEquals("Atrio", labirinto.getStanzaCorrente().getNome());
	}

	@Test
	public void testStanzaVincenteCorretta() {
		assertEquals("Biblioteca", labirinto.getStanzaVincente().getNome());
	}
	
	@Test
	public void testStanzaCorrenteNotNull() {
		assertNotNull(labirinto.getStanzaCorrente());
	}

	@Test
	public void testStanzaVincenteNotNull() {
		assertNotNull(labirinto.getStanzaVincente());
	}

	@Test
	public void testSetStanzaCorrente() {
		Stanza stanza = new Stanza("nuovaStanza");
		labirinto.setStanzaCorrente(stanza);
		assertEquals(stanza, labirinto.getStanzaCorrente());
	}

}
