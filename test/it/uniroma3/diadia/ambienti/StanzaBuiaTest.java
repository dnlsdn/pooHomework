package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {
	
	private StanzaBuia stanzaBuia;

	@Before
	public void setUp() throws Exception {
		stanzaBuia = new StanzaBuia("StanzaBuia", "lanterna");
	}

	@Test
	public void testDescrizioneSenzaAttrezzoNecessario() {
		assertEquals(stanzaBuia.getDescrizione(), "Qui c'è un buio pesto");
	}

}
