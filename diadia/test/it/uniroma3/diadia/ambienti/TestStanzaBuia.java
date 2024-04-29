package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class TestStanzaBuia {

	private StanzaBuia stanzaBuia;
	private Attrezzo attrezzo;

	@Before
	public void setUp() {
		this.stanzaBuia = new StanzaBuia("nome", "attrezzo");
		this.attrezzo = new Attrezzo("attrezzo", 2);
	}

	@Test
	public void testAttrezzoPresente() {
		String vuoto = "";
		assertEquals(vuoto, stanzaBuia.getDescrizione(attrezzo.getNome()));
	}

	@Test
	public void testAttrezzoNonPresente() {
		String giusto = "Qui c'e un buio pesto";
		Attrezzo attrezzoErrato = new Attrezzo("attrezzoDue", 2);
		assertEquals(giusto, stanzaBuia.getDescrizione(attrezzoErrato.getNome()));
	}
}
