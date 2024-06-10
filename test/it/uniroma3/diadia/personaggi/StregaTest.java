package it.uniroma3.diadia.personaggi;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Labirinto.LabirintoBuilder;

public class StregaTest {

	private Labirinto labirinto;
	private Partita partita;
	private Strega strega;
	

	@Before
	public void setUp() throws Exception {
		labirinto = new LabirintoBuilder()
				.addStanzaIniziale("Iniziale")
				.addAttrezzo("scudo", 2)
				
				.addStanza("StanzaPiu")
				.addAttrezzo("Galil", 3)
				.addAttrezzo("MP5", 3)
				
				.addStanza("StanzaMeno")
				
				.addAdiacenza("Iniziale", "StanzaPiu", "nord")
				.addAdiacenza("Iniziale", "StanzaMeno", "sud")
				
				.getLabirinto();
		partita = new Partita(labirinto);
		strega = new Strega("Befana", "Bau");
	}

	@Test
	public void testSpostaSeHaSalutato() {
		assertEquals(partita.getStanzaCorrente().getNome(), "Iniziale");
		strega.saluta();
		strega.agisci(partita);
		assertEquals(partita.getStanzaCorrente().getNome(), "StanzaPiu");
	}
	
	@Test
	public void testSpostaSeNonHaSalutato() {
		assertEquals(partita.getStanzaCorrente().getNome(), "Iniziale");
		strega.agisci(partita);
		assertEquals(partita.getStanzaCorrente().getNome(), "StanzaMeno");
	}

}
