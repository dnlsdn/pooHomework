package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Labirinto.LabirintoBuilder;

public class ComandoVaiTest {
	
	private ComandoVai comandoVai;
	private Partita partita;
	private Labirinto labirinto;
	private IO io;
	
	

	@Before
	public void setUp() throws Exception {
		comandoVai = new ComandoVai();
		labirinto = new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addStanzaVincente("Aula N10")
				.addAdiacenza("Atrio", "Aula N10", "sud")
				.addAdiacenza("Aula N10", "Atrio", "nord")
				.getLabirinto();
		partita = new Partita(labirinto);
		io = new IOConsole(new Scanner(System.in));
		comandoVai.setIO(io);
	}
	
	/*Test riguardanti */

	@Test
	public void testVaiInDirezioneNulla() {
		comandoVai.setParametro(null);
		comandoVai.esegui(partita);
		assertEquals(partita.getStanzaCorrente().getNome(), "Atrio");
	}
	
	@Test
	public void testVaiInDirezioneNonValida() {
		comandoVai.setParametro("up");
		comandoVai.esegui(partita);
		assertEquals(partita.getStanzaCorrente().getNome(), "Atrio");
	}
	
	@Test
	public void testVaiInDirezioneValida() {
		comandoVai.setParametro("sud");
		comandoVai.esegui(partita);
		
		assertEquals(partita.getStanzaCorrente().getNome(), "Aula N10");
	}
	
	/*Test riguardanti i CFU*/
	
	@Test
	public void testCfuInalteratiDirezioneNonValida() {
		comandoVai.setParametro("up");
		comandoVai.esegui(partita);
		
		assertEquals(partita.getGiocatore().getCfu(), 20);
	}
	
	@Test
	public void testCfuAggiornatiDirezioneValida() {
		comandoVai.setParametro("sud");
		comandoVai.esegui(partita);
		
		assertEquals(partita.getGiocatore().getCfu(), 19);
	}

}
