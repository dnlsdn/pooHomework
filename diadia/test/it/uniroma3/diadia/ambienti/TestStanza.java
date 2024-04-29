package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class TestStanza {
	Stanza testStanza;
	
	@Before
	public void setUp() {
		testStanza = new Stanza("testStanza");
	}
	
	/* Test per impostaStanzaAdiacente */
	@Test
	public void testImpostaStanzaAdiacente(){
		Stanza testAdiacente = creaEimpostaAdiacente(testStanza, "nord");
		assertEquals(testAdiacente, testStanza.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testCambiaStanzaAdiacente() {
		Stanza testAdiacente = creaEimpostaAdiacente(testStanza, "nord");
		Stanza testAltraStanza = creaEimpostaAdiacente(testStanza, "sud");
		
		assertEquals(testAltraStanza, testStanza.getStanzaAdiacente("sud"));
	}
	
	@Test
	public void testImpostaAdiacenteDiAdiacente() {
		Stanza testAdiacente = creaEimpostaAdiacente(testStanza, "nord");
		Stanza testAdiacenteAdiacente = creaEimpostaAdiacente(testAdiacente, "nord");
		assertEquals(testAdiacenteAdiacente, testStanza.getStanzaAdiacente("nord").getStanzaAdiacente("nord"));
		
	}
	
	/* Test per addAttrezzo */
	@Test
	public void testAggiungoUnAttrezzo(){
		Attrezzo testAttrezzo = creaEimpostaAttrezzo(testStanza, "testAttrezzo", 1);
		assertEquals(testAttrezzo, testStanza.getAttrezzo("testAttrezzo"));
	}
	
	@Test
	public void testAggiungoNAttrezzi(){
		creaEimpostaNAttrezzi(testStanza, 10);
		assertEquals(10, testStanza.getAttrezzi().length);
	}
	
	@Test
	public void testInserimentoTroppiAttrezzi() {
		creaEimpostaNAttrezzi(testStanza, 10);
		Attrezzo testAttrezzoDiTroppo = new Attrezzo("testAttrezzoDiTroppo", 10);
		assertFalse(testStanza.addAttrezzo(testAttrezzoDiTroppo));
	}
	
	
	/* Test per hasAttrezzo*/
	@Test
	public void testRicercaInStanzaVuota() {
		assertFalse(testStanza.hasAttrezzo("testAttrezzo")); 
	}
	
	@Test
	public void testAttrezzoPresenteSingleton() {
		creaEimpostaAttrezzo(testStanza, "testAttrezzo", 1);
		assertTrue(testStanza.hasAttrezzo("testAttrezzo")); 
	}
	
	@Test
	public void testAttrezzoPresenteNonSingleton() {
		creaEimpostaNAttrezzi(testStanza, 10);
		assertTrue(testStanza.hasAttrezzo("testAttrezzo_5")); 
	}
	
	@Test
	public void testRicercaAttrezzoNonPresenteNonSingleton() {
		creaEimpostaNAttrezzi(testStanza, 10);
		assertFalse(testStanza.hasAttrezzo("testAttrezzo")); 
	}
	
	
	/*Test per removeAttrezzo*/
	@Test
	public void testRimuoviAttrezzoInStanzaVuota() {
		Attrezzo testAttrezzo = new Attrezzo("testAttrezzo", 1);
		assertFalse(testStanza.removeAttrezzo(testAttrezzo));
	}
	
	@Test
	public void testRimuoviAttrezzoPresenteInStanzaPiena() {
		creaEimpostaNAttrezzi(testStanza, 10);
		Attrezzo testAttrezzo = testStanza.getAttrezzo("testAttrezzo_5");
		assertTrue(testStanza.removeAttrezzo(testAttrezzo));
	}
	
	@Test
	public void testRimuoviAttrezzoNonPresenteInStanzaPiena() {
		Attrezzo testAttrezzo = new Attrezzo("testAttrezzo", 1);
		assertFalse(testStanza.removeAttrezzo(testAttrezzo));
	}
	
	
	
	
	/*Funzioni di appoggio*/
	
	private Stanza creaEimpostaAdiacente(Stanza stanza, String direzione ) {
		Stanza testAdiacente = new Stanza("testAdiacente");
		stanza.impostaStanzaAdiacente(direzione, testAdiacente);
		return testAdiacente;
	}
	
	private Attrezzo creaEimpostaAttrezzo(Stanza testStanza, String nome, int peso) {
		Attrezzo testAttrezzo = new Attrezzo(nome, peso);
		testStanza.addAttrezzo(testAttrezzo);
		return testAttrezzo;
	}
	
	private void creaEimpostaNAttrezzi(Stanza testStanza, int n){
		for (int i = 0; i < n; i++) {
			creaEimpostaAttrezzo(testStanza, "testAttrezzo_" +i, i);
		}
	}
	

	
	
	
	
}
