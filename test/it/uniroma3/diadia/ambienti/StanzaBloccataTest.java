package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {

	private Stanza stanzaAdiacente;
	private StanzaBloccata stanzaBloccata;
	private Attrezzo attrezzo;

	@Before
	public void setUp() {
		this.stanzaAdiacente = new Stanza("adiacente");
		this.stanzaBloccata = new StanzaBloccata("bloccata", "sud", "attrezzo");
		this.attrezzo = new Attrezzo("attrezzo", 2);
	}

	@Test
	public void testGetStanzaSenzaAttrezzo() {
		stanzaBloccata.impostaStanzaAdiacente("sud", stanzaAdiacente);
		assertEquals(stanzaBloccata, stanzaBloccata.getStanzaAdiacente("sud"));
	}

	@Test
	public void testGetStanzaConAttrezzo() {
		stanzaBloccata.addAttrezzo(attrezzo);
		stanzaBloccata.impostaStanzaAdiacente("sud", stanzaAdiacente);
		assertEquals(stanzaAdiacente, stanzaBloccata.getStanzaAdiacente("sud"));

	}
}
