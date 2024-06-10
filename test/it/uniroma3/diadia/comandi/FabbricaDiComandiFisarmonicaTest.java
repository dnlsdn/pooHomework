package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IOConsole;

public class FabbricaDiComandiFisarmonicaTest {
	
	private FabbricaDiComandiFisarmonica factory;
	private IOConsole io;

	@Before
	public void setUp() throws Exception {
		factory = new FabbricaDiComandiFisarmonica();
		io = new IOConsole(new Scanner(System.in));
	}

	@Test
	public void testCreaComandoVai() {
		Comando comando =  factory.costruisciComando("vai nord", io);
		assertEquals(comando.getNome(), "vai");
		assertEquals(comando.getParametro(), "nord");
	}
	
	@Test
	public void testCreaComandoAiuto() {
		Comando comando =  factory.costruisciComando("aiuto", io);
		assertEquals(comando.getNome(), "aiuto");
	}
	
	@Test
	public void testCreaComandoFine() {
		Comando comando =  factory.costruisciComando("fine", io);
		assertEquals(comando.getNome(), "fine");
	}
	
	@Test
	public void testCreaComandoGuarda() {
		Comando comando =  factory.costruisciComando("guarda", io);
		assertEquals(comando.getNome(), "guarda");
	}
	
	@Test
	public void testCreaComandoPosa() {
		Comando comando =  factory.costruisciComando("posa osso", io);
		assertEquals(comando.getNome(), "posa");
		assertEquals(comando.getParametro(), "osso");
	}
	
	@Test
	public void testCreaComandoPrendi() {
		Comando comando =  factory.costruisciComando("prendi osso", io);
		assertEquals(comando.getNome(), "prendi");
		assertEquals(comando.getParametro(), "osso");
	}
	@Test
	public void testCreaComandoNonValido() {
		Comando comando =  factory.costruisciComando("abc", io);
		assertEquals(comando.getNome(), "comando non valido");
	}

}
