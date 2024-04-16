package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;

public class TestPartita {
	
	
	Partita testPartita;

	@Before
	public void setUp(){
		testPartita = new Partita();
	}

	@Test
	public void testLabirintoCreato() {
		assertNotNull(testPartita.getLabirinto());
	}
	
	@Test
	public void testGiocatoreCreato() {
		assertNotNull(testPartita.getGiocatore());
	}
	
	@Test
	public void testPartitaFinita() {
		testPartita.setFinita();
		assertTrue(testPartita.isFinita());
	}
	
	@Test
	public void testPartitaNonFinita() {
		assertFalse(testPartita.isFinita());
	}
	
	@Test
	public void testPartitaNonVinta() {
		assertFalse(testPartita.vinta());
	}
	
	@Test
	public void testPartitaVinta() {
		assertFalse(testPartita.vinta());
	}

}
