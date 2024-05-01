package it.uniroma3.diadia;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class PartitaTest {

	Partita testPartita;

	@Before
	public void setUp() {
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

}
