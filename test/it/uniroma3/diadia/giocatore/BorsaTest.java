package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {
	
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
	
	/*Test contenuto ordinato per PESO*/
	
	@Test
	public void testGetContenutoOrdinatoPerPeso_InsiemeVuoto() {
		List<Attrezzo> l = testBorsa.getContenutoOrdinatoPerPeso();
		assertTrue(l.size() == 0);
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPeso_Singleton() {
		testBorsa.addAttrezzo(new Attrezzo("uno", 1));
		List<Attrezzo> l = testBorsa.getContenutoOrdinatoPerPeso();
		assertTrue(l.size() == 1);
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPeso_DoubletonPesoDiverso() {
		Attrezzo a1 = new Attrezzo("a", 2), b1 = new Attrezzo("b", 1);
		testBorsa.addAttrezzo(a1);
		testBorsa.addAttrezzo(b1);
		List<Attrezzo> l = testBorsa.getContenutoOrdinatoPerPeso();
				
		assertEquals(new ArrayList<>(Arrays.asList(b1, a1)), l);
	}
	
	@Test
	public void testGetContenutoOrdinatoPerNome_DoubletonPesoUguale() {
		Attrezzo a1 = new Attrezzo("a", 1), b1 = new Attrezzo("b", 1);
		testBorsa.addAttrezzo(a1);
		testBorsa.addAttrezzo(b1);
		List<Attrezzo> l = testBorsa.getContenutoOrdinatoPerNome();
		assertEquals(new ArrayList<>(Arrays.asList(a1, b1)), l);
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPeso_MoltiAttrezzi() {
		Attrezzo a1 = new Attrezzo("a", 1);
		Attrezzo b3 = new Attrezzo("b", 3);
		Attrezzo c2 = new Attrezzo("c", 2);
		Attrezzo d3 = new Attrezzo("d", 3);
		Attrezzo e1 = new Attrezzo("e", 1);
		testBorsa.addAttrezzo(a1);
		testBorsa.addAttrezzo(b3);
		testBorsa.addAttrezzo(c2);
		testBorsa.addAttrezzo(d3);
		testBorsa.addAttrezzo(e1);
		List<Attrezzo> l = testBorsa.getContenutoOrdinatoPerPeso();
		assertEquals(new ArrayList<>(Arrays.asList(a1, e1, c2, b3, d3)), l);
	}
	
	/*Test contenuto ordinato per NOME*/
	
	@Test
	public void testGetContenutoOrdinatoPerNome_InsiemeVuoto() {
		List<Attrezzo> l = testBorsa.getContenutoOrdinatoPerNome();
		assertTrue(l.size() == 0);
	}
	
	@Test
	public void testGetContenutoOrdinatoPerNome_Singleton() {
		testBorsa.addAttrezzo(new Attrezzo("uno", 1));
		List<Attrezzo> l = testBorsa.getContenutoOrdinatoPerNome();
		assertTrue(l.size() == 1);
	}
	
	@Test
	public void testGetContenutoOrdinatoPerNome_DoubletonPesoDiverso() {
		Attrezzo a1 = new Attrezzo("a", 2), b1 = new Attrezzo("b", 1);
		testBorsa.addAttrezzo(b1);
		testBorsa.addAttrezzo(a1);
		List<Attrezzo> l = testBorsa.getContenutoOrdinatoPerNome();
		assertEquals(new ArrayList<>(Arrays.asList(a1, b1)), l);
	}

	
	@Test
	public void testGetContenutoOrdinatoPerNome_MoltiAttrezzi() {
		Attrezzo a1 = new Attrezzo("a", 1);
		Attrezzo b3 = new Attrezzo("b", 3);
		Attrezzo c2 = new Attrezzo("c", 2);
		Attrezzo d3 = new Attrezzo("d", 3);
		Attrezzo e1 = new Attrezzo("e", 1);
		testBorsa.addAttrezzo(c2);
		testBorsa.addAttrezzo(d3);
		testBorsa.addAttrezzo(b3);
		testBorsa.addAttrezzo(e1);
		testBorsa.addAttrezzo(a1);
		List<Attrezzo> l = testBorsa.getContenutoOrdinatoPerNome();
		assertEquals(new ArrayList<>(Arrays.asList(a1, b3, c2, d3, e1)), l);
	}
	
	/*Test contenuto raggruppato per peso*/
	
	@Test
	public void testGetContenutoRaggruppatoPerPeso_InsiemeVuoto() {
		Map<Integer, Set<Attrezzo>> m= testBorsa.getContenutoRaggruppatoPerPeso();
		assertTrue(m.size() == 0);
	}
	
	@Test
	public void testGetContenutoRaggruppatoPerPeso_Singleton() {
		testBorsa.addAttrezzo(new Attrezzo("uno", 1));
		Map<Integer, Set<Attrezzo>> m= testBorsa.getContenutoRaggruppatoPerPeso();
		assertTrue(m.size() == 1);
	}
	
	@Test
	public void testGetContenutoRaggruppatoPerPeso_DoubletonPesoDiverso() {
		Attrezzo a1 = new Attrezzo("a", 2), b1 = new Attrezzo("b", 1);
		testBorsa.addAttrezzo(b1);
		testBorsa.addAttrezzo(a1);
		Map<Integer, Set<Attrezzo>> m= testBorsa.getContenutoRaggruppatoPerPeso();
		
		Map<Integer, Set<Attrezzo>> m2 = new HashMap<>();
		
		m2.put(1, new HashSet<>(Arrays.asList(b1)));
		m2.put(2, new HashSet<>(Arrays.asList(a1)));
		
		assertEquals(m2, m);
	}
	
	
	@Test
	public void testGetContenutoRaggruppatoPerPeso_MoltiAttrezzi() {
		Attrezzo a1 = new Attrezzo("a", 1);
		Attrezzo b3 = new Attrezzo("b", 3);
		Attrezzo c2 = new Attrezzo("c", 2);
		Attrezzo d3 = new Attrezzo("d", 3);
		Attrezzo e1 = new Attrezzo("e", 1);
		testBorsa.addAttrezzo(c2);
		testBorsa.addAttrezzo(d3);
		testBorsa.addAttrezzo(b3);
		testBorsa.addAttrezzo(e1);
		testBorsa.addAttrezzo(a1);
		
		Map<Integer, Set<Attrezzo>> m= testBorsa.getContenutoRaggruppatoPerPeso();
		
		
		Map<Integer, Set<Attrezzo>> m2 = new HashMap<>();
		
		m2.put(1, new HashSet<>(Arrays.asList(a1, e1)));
		m2.put(3, new HashSet<>(Arrays.asList(b3, d3)));
		m2.put(2, new HashSet<>(Arrays.asList(c2)));
		
		assertEquals(m2, m);
	}
	/*Test contenuto raggruppato per peso*/
	
	@Test
	public void testGetSortedSetOrdinatoPerPeso_InsiemeVuoto() {
		SortedSet<Attrezzo> ss = testBorsa.getSortedSetOrdinatoPerPeso();
		assertTrue(ss.size() == 0);
	}
	
	@Test
	public void testGetSortedSetOrdinatoPerPeso_Singleton() {
		testBorsa.addAttrezzo(new Attrezzo("uno", 1));
		SortedSet<Attrezzo> ss = testBorsa.getSortedSetOrdinatoPerPeso();
		assertTrue(ss.size() == 1);
	}
	
	@Test
	public void testGetSortedSetOrdinatoPerPeso_DoubletonPesoDiverso() {
		Attrezzo a1 = new Attrezzo("a", 2), b1 = new Attrezzo("b", 1);
		testBorsa.addAttrezzo(b1);
		testBorsa.addAttrezzo(a1);
		
		Set<Attrezzo> ss = testBorsa.getSortedSetOrdinatoPerPeso();
		Attrezzo[] ss2= {b1, a1};
		
		assertArrayEquals(ss.toArray(), ss2);
	}
	
	@Test
	public void testGetSortedSetOrdinatoPerPeso_DoubletonPesoUguale() {
		Attrezzo a1 = new Attrezzo("a", 1), b1 = new Attrezzo("b", 1);
		testBorsa.addAttrezzo(b1);
		testBorsa.addAttrezzo(a1);
		
		Set<Attrezzo> ss = testBorsa.getSortedSetOrdinatoPerPeso();
		Attrezzo[] ss2= {a1, b1};
		
		assertArrayEquals(ss.toArray(), ss2);
	}
	
	
	@Test
	public void testGetSortedSetOrdinatoPerPeso_MoltiAttrezzi() {
		Attrezzo a1 = new Attrezzo("a", 1);
		Attrezzo b3 = new Attrezzo("b", 3);
		Attrezzo c2 = new Attrezzo("c", 2);
		Attrezzo d3 = new Attrezzo("d", 3);
		Attrezzo e1 = new Attrezzo("e", 1);
		testBorsa.addAttrezzo(c2);
		testBorsa.addAttrezzo(d3);
		testBorsa.addAttrezzo(b3);
		testBorsa.addAttrezzo(e1);
		testBorsa.addAttrezzo(a1);
		
		Set<Attrezzo> ss = testBorsa.getSortedSetOrdinatoPerPeso();
		Attrezzo[] ss2= {a1, e1, c2, b3, d3};
		
		assertArrayEquals(ss.toArray(), ss2);
	}
	
	@Test
	public void testToStringBorsa() {
		creaEImpostaNAttrezzi(testBorsa, 3);
		System.out.println(this.testBorsa.toString());
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
