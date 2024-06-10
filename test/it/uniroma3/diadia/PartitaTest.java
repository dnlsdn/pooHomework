package it.uniroma3.diadia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import fixture.Fixture;
import it.uniroma3.diadia.ambienti.Labirinto;

public class PartitaTest {
	
	
	private Partita testPartita;
	private Labirinto labirinto;

	@Before
	public void setUp(){
		labirinto = new Labirinto.LabirintoBuilder()
				.addStanzaIniziale("N10")
				.getLabirinto();
		
		testPartita = new Partita(labirinto);
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
	
	@Test
	public void testPartitaInteraVinta() throws Exception {
		Labirinto labirintoVinta = new Labirinto.LabirintoBuilder()
				.addStanzaIniziale("Iniziale")
				.addAttrezzo("osso", 1)
				
				.addStanzaVincente("Vincente")
				.addAttrezzo("pala", 2)
				
				.addStanza("Atrio")
				.addAttrezzo("libro", 2)
				
				.addAdiacenza("Iniziale", "Atrio", "sud")
				.addAdiacenza("Atrio", "Iniziale", "nord")
				
				.addAdiacenza("Vincente", "Atrio", "ovest")
				.addAdiacenza("Atrio", "Vincente", "est")
				
				.getLabirinto();
		
		IOSimulator io = Fixture.creaEAvviaSimulazione(labirintoVinta, Arrays.asList("vai sud", "prendi libro",  "vai est"));
		assertTrue(io.hasMessaggio());
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.nextMessaggio());
		
		assertTrue(io.hasMessaggio());
		assertTrue(io.nextMessaggio().contains("Atrio"));
		
		assertTrue(io.hasMessaggio());
		assertTrue(io.nextMessaggio().contains("libro"));
		
		assertTrue(io.hasMessaggio());
		assertTrue(io.nextMessaggio().contains("Vincente"));
		
		assertTrue(io.hasMessaggio());
		assertTrue(io.nextMessaggio().contains("vinto"));
		
	}

}
