package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class TestStanzaBloccata {

	private Stanza stanzaAdiacente;
	private StanzaBloccata stanzaBloccata;
	private Attrezzo attrezzo;

	@Before
	public void setUp() {
		this.stanzaAdiacente = new Stanza("adiacente");
		this.stanzaBloccata = new StanzaBloccata("nome", "attrezzo", "sud");
		this.attrezzo = new Attrezzo("attrezzo", 2);
	}

	@Test
	public void testGetStanza() {
		stanzaBloccata.impostaStanzaAdiacente("sud", stanzaAdiacente);
		stanzaBloccata.addAttrezzo(attrezzo);

		assertSame(stanzaAdiacente, stanzaBloccata.getStanzaAdiacente("sud"));
	}

	@Test
	public void testNoGetStanza() {
		stanzaBloccata.impostaStanzaAdiacente("sud", stanzaAdiacente);

		assertNotEquals(stanzaAdiacente.getNome(), stanzaBloccata.getStanzaAdiacente("sud").getNome());
	}

	@Test
	public void testStanzaBloccata() {
		stanzaBloccata.impostaStanzaAdiacente("sud", stanzaAdiacente);
		String frase = "la stanza adiacente e' bloccata";

		assertEquals(frase, stanzaBloccata.getDescrizione("sud"));
	}
}
