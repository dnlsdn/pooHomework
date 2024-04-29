package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class TestBorsa {
	
	private Borsa testBorsa;

	@Before
	public void setUp(){
		testBorsa = new Borsa();
	}

	/*Test addAttrezzo*/
	@Test
	public void testAggiungoAttrezzoBorsaVuota() {
		Attrezzo testAttrezzo = creaEImpostaAttrezzo(testBorsa, "testAttrezzo", 1);
		assertEquals(testAttrezzo, testBorsa.getAttrezzo("testAttrezzo"));
	}
	
	@Test
	public void testAggiungiNAttrezzi() {
		creaEImpostaNAttrezzi(testBorsa, 3);
		assertEquals(6, testBorsa.getPeso());
	}
	
	@Test
	public void testAggiungiAttrezziBorsaPiena() {
		creaEImpostaNAttrezzi(testBorsa, 5);
		Attrezzo testAttrezzoDiTroppo = new Attrezzo("testAttrezzoDiTroppo", 1);
		assertFalse(testBorsa.addAttrezzo(testAttrezzoDiTroppo));
	}
	
	/* Test per hasAttrezzo*/
	@Test
	public void testRicercaInBorsaVuota() {
		assertFalse(testBorsa.hasAttrezzo("testAttrezzo")); 
	}
	
	@Test
	public void testAttrezzoPresenteSingleton() {
		creaEImpostaAttrezzo(testBorsa, "testAttrezzo", 1);
		assertTrue(testBorsa.hasAttrezzo("testAttrezzo")); 
	}
	
	@Test
	public void testAttrezzoPresenteNonSingleton() {
		creaEImpostaNAttrezzi(testBorsa, 3);
		assertTrue(testBorsa.hasAttrezzo("testAttrezzo_2")); 
	}
	
	@Test
	public void testRicercaAttrezzoNonPresenteNonSingleton() {
		creaEImpostaNAttrezzi(testBorsa, 3);
		assertFalse(testBorsa.hasAttrezzo("testAttrezzo")); 
	}
	
	@Test
	public void testRimuoviAttrezzoInBorsaVuota() {
		assertNull(testBorsa.removeAttrezzo("testAttrezzo"));
	}
	
	@Test
	public void testRimuoviAttrezzoPresenteInBorsaPiena() {
		creaEImpostaNAttrezzi(testBorsa, 5);
		assertNotNull(testBorsa.removeAttrezzo("testAttrezzo_4"));
	}
	
	@Test
	public void testRimuoviAttrezzoNonPresenteInBorsaPiena() {
		creaEImpostaNAttrezzi(testBorsa, 5);
		assertNull(testBorsa.removeAttrezzo("testAttrezzo"));
	}
	
	
	/*Funzioni di appoggio*/
	
	private Attrezzo creaEImpostaAttrezzo(Borsa testBorsa, String nome, int peso) {
		Attrezzo testAttrezzo = new Attrezzo(nome, peso);
		testBorsa.addAttrezzo(testAttrezzo);
		return testAttrezzo;
	}
	
	private void creaEImpostaNAttrezzi(Borsa testBorsa, int n) {
		for (int i = 0; i < n; i++) {
			creaEImpostaAttrezzo(testBorsa, "testAttrezzo_"+i, 2);
		}
	}
}
