package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import fixture.Fixture;
import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Labirinto.LabirintoBuilder;

public class ComandoFineTest {
	
	Labirinto labirinto;

	@Before
	public void setUp() throws Exception {
		labirinto = new LabirintoBuilder()
				.addStanzaIniziale("inizio")
				.getLabirinto();		
	}

	@Test
	public void testComandoFine() throws Exception {
		IOSimulator ioSimulator = Fixture.creaEAvviaSimulazione(labirinto, Arrays.asList("fine"));
		assertTrue(ioSimulator.hasMessaggio());
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, ioSimulator.nextMessaggio());
		assertTrue(ioSimulator.hasMessaggio());
		assertEquals(ComandoFine.MESSAGGIO_FINE, ioSimulator.nextMessaggio());
	}
}
