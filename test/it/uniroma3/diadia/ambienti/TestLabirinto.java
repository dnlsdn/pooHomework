package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestLabirinto {
	private Labirinto labirinto;
	
	@Before
	public void setUp() {
		labirinto = new Labirinto();
	}
	
	@Test
	public void testStanzaCorrenteCorretta() {
		assertEquals("Atrio", labirinto.getStanzaCorrente().getNome());
	}

	@Test
	public void testStanzaVincenteCorretta() {
		assertEquals("Biblioteca", labirinto.getStanzaVincente().getNome());
	}

}
