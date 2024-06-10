package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class GiocatoreTest {
	Giocatore testGiocatore;

	@Before
	public void setUp(){
		testGiocatore = new Giocatore();
	}

	@Test
	public void testCFUIniziali() {
		assertEquals(20, testGiocatore.getCfu());
	}
	
	@Test
	public void testCambiaCFU() {
		testGiocatore.setCfu(30);
		assertEquals(30, testGiocatore.getCfu());
	}

}
