package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comandi.ComandoVai;

public class ComandoVaiTest {

	private ComandoVai comandoVai;
	private Stanza stanzaCorrente;
	private Stanza stanzaAdiacente;
	private Partita partita;
	private IO io;

	@Before
	public void setUp() {
		this.comandoVai = new ComandoVai();
		this.stanzaCorrente = new Stanza("Atrio");
		this.stanzaAdiacente = new Stanza("Aula N10");
		this.partita = new Partita();
		comandoVai.setIO(new IOConsole());
	}

	@Test
	public void testDirezioneValida() {
		stanzaCorrente.impostaStanzaAdiacente("sud", stanzaAdiacente);
		comandoVai.setParametro("sud");
		comandoVai.esegui(partita);
		assertEquals(stanzaAdiacente.getNome(), partita.getLabirinto().getStanzaCorrente().getNome());
	}

	@Test
	public void testDirezioneNonValida() {
		Stanza nuovaStanza = new Stanza("nuova");
		partita.getLabirinto().setStanzaCorrente(nuovaStanza);
		comandoVai.setParametro("sud");
		comandoVai.esegui(partita);
		assertEquals(nuovaStanza.getNome(), partita.getLabirinto().getStanzaCorrente().getNome());
	}

	@Test
	public void testDirezioneVuota() {
		comandoVai.esegui(partita);
		assertEquals(stanzaCorrente.getNome(), partita.getLabirinto().getStanzaCorrente().getNome());
	}
}
