package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaTest {
	
	StanzaMagica stanzaMagica;

	@Before
	public void setUp() throws Exception {
		stanzaMagica = new StanzaMagica("MagicaTest");
	}

	/* Test per addAttrezzo */
	@Test
	public void testAggiungoUnAttrezzoSottoSoglia(){
		Attrezzo testAttrezzo = creaEimpostaAttrezzo(stanzaMagica, "testAttrezzo", 1);
		assertEquals(testAttrezzo, stanzaMagica.getAttrezzo("testAttrezzo"));
	}
	
	@Test
	public void testAggiungoUnAttrezzoSopraSoglia(){
		creaEimpostaNAttrezzi(stanzaMagica, 3);
		creaEimpostaAttrezzo(stanzaMagica, "abcd", 2);
		assertEquals(new Attrezzo("dcba", 4), stanzaMagica.getAttrezzo("dcba"));
	}	
	
	
	
	/*Funzioni di appoggio*/
	public Attrezzo creaEimpostaAttrezzo(StanzaMagica stanzaMagica, String nome, int peso) {
		Attrezzo testAttrezzo = new Attrezzo(nome, peso);
		stanzaMagica.addAttrezzo(testAttrezzo);
		return testAttrezzo;
	}
	
	public void creaEimpostaNAttrezzi(StanzaMagica stanzaMagica, int n) {
		Attrezzo testAttrezzo;
		for (int i = 0; i < n; i++) {
			testAttrezzo = new Attrezzo("testAttrezzo"+i, i);
			stanzaMagica.addAttrezzo(testAttrezzo);
		}
	}

}
