package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertFalse;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Labirinto.LabirintoBuilder;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosaTest {

	private ComandoPosa comandoPosa;
	private Partita partita;
	private Attrezzo attrezzo;
	private IOConsole io;
	private Labirinto labirinto;

	@Before
	public void setUp() {
		this.comandoPosa = new ComandoPosa();
		this.io = new IOConsole((new Scanner(System.in)));
		comandoPosa.setIO(io);
		labirinto = new LabirintoBuilder()
						.addStanzaIniziale("Biblioteca")
						.addStanzaVincente("N10")
						.getLabirinto();
				
				
		this.partita = new Partita(labirinto);
		this.attrezzo = new Attrezzo("attrezzo", 2);
	}

	@Test
	public void testAttrezzoPosato() {
		comandoPosa.setParametro("attrezzo");
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		comandoPosa.esegui(partita);

		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("attrezzo"));
	}

	@Test
	public void testAttrezzoNonPosato() {
		creaEAggiungiAttrezziStanza();
		comandoPosa.setParametro("attrezzo");
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		comandoPosa.esegui(partita);

		assertFalse(partita.getStanzaCorrente().hasAttrezzo("attrezzo"));
	}

	@Test
	public void testNoAttrezzoBorsa() {
		comandoPosa.setParametro("attrezzo");
		comandoPosa.esegui(partita);
		assertFalse(partita.getLabirinto().getStanzaCorrente().hasAttrezzo("attrezzo"));
	}

	public void creaEAggiungiAttrezziStanza() {
		for (int i = 0; i < 11; i++) {
			Attrezzo newAttrezzo = new Attrezzo("nuovo"+i, 1);
			partita.getLabirinto().getStanzaCorrente().addAttrezzo(newAttrezzo);
		}
	}
}
