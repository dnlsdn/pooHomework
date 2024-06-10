package it.uniroma3.diadia.ambienti;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.CaricatoreLabirinto;
import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Labirinto {
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	private Stanza stanzaIniziale;
	
	private Labirinto() {};
	
	private Labirinto(String nomeFile) throws FileNotFoundException, FormatoFileNonValidoException {
		CaricatoreLabirinto c = new CaricatoreLabirinto(nomeFile);
		c.carica();
		this.stanzaIniziale = c.getStanzaIniziale();
		this.stanzaCorrente = this.stanzaIniziale;
		this.stanzaVincente = c.getStanzaVincente();
	}
	
	

	public Stanza getStanzaIniziale() {
		return stanzaIniziale;
	}
	
	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}

	public Stanza getStanzaCorrente() {
		return stanzaCorrente;
	}
	
	public void setStanzaIniziale(Stanza stanzaIniziale) {
		this.stanzaIniziale = stanzaIniziale;
	}

	public void setStanzaVincente(Stanza stanzaVincente) {
		this.stanzaVincente = stanzaVincente;
	}
	
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}
	
	public static LabirintoBuilder newBuilder(String labirinto) throws FileNotFoundException, FormatoFileNonValidoException {
		return new LabirintoBuilder(labirinto);
	}
	
	
	public static class LabirintoBuilder {
		private Labirinto labirinto;
		private Stanza ultimaAggiunta;
		private Map<String, Stanza> nome2stanza;
		
		public LabirintoBuilder() {
			this.labirinto = new Labirinto();
			this.nome2stanza = new HashMap<String, Stanza>();
		}
		
		public LabirintoBuilder(String labirinto) throws FileNotFoundException, FormatoFileNonValidoException {
			this.labirinto = new Labirinto(labirinto);
			this.nome2stanza = new HashMap<>();
		}
		
		public LabirintoBuilder addStanzaIniziale(String nomeStanzaIniziale) {
			Stanza iniziale = new Stanza(nomeStanzaIniziale);
			this.labirinto.setStanzaIniziale(iniziale);
			this.labirinto.setStanzaCorrente(iniziale);
			this.aggiungiAMappaEAggiornaUltima(iniziale);
			return this;
		}
		
		public LabirintoBuilder addStanzaVincente(String nomeStanzaVincente) {
			Stanza vincente = new Stanza(nomeStanzaVincente);
			this.labirinto.setStanzaVincente(vincente);
			this.aggiungiAMappaEAggiornaUltima(vincente);
			return this;
		}
		
		public LabirintoBuilder addAdiacenza(String partenza, String adiacente, String direzione) {
			Stanza stanzaPartenza =  this.nome2stanza.get(partenza);
			Stanza stanzaAdiacente =  this.nome2stanza.get(adiacente);
			stanzaPartenza.impostaStanzaAdiacente(direzione, stanzaAdiacente);
			return this;
		}
		
		public LabirintoBuilder addAttrezzo(String nomeStanza, String nome, int peso) {
			Attrezzo a = new Attrezzo(nome, peso);
			this.nome2stanza.get(nomeStanza).addAttrezzo(a);
			return this;
		}
		
		public LabirintoBuilder addAttrezzo(String nome, int peso) {
			Attrezzo a = new Attrezzo(nome, peso);
			this.ultimaAggiunta.addAttrezzo(a);
			return this;
		}
		
		public LabirintoBuilder addStanza(String nome) {
			Stanza stanza = new Stanza(nome);
			this.aggiungiAMappaEAggiornaUltima(stanza);
			return this;
		}
		
		public LabirintoBuilder addStanzaMagica(String nome, int soglia) {
			StanzaMagica stanza = new StanzaMagica(nome, soglia);
			this.aggiungiAMappaEAggiornaUltima(stanza);
			return this;
		}
		public LabirintoBuilder addStanzaBuia(String nome, String attrezzoPerVedere) {
			StanzaBuia stanza = new StanzaBuia(nome, attrezzoPerVedere);
			this.aggiungiAMappaEAggiornaUltima(stanza);
			return this;
		}
		public LabirintoBuilder addStanzaBloccata(String nome, String direzioneBloccata, String attrezzoPerSbloccare) {
			StanzaBloccata stanza = new StanzaBloccata(nome, direzioneBloccata, attrezzoPerSbloccare);
			this.aggiungiAMappaEAggiornaUltima(stanza);
			return this;
		}
		
		private void aggiungiAMappaEAggiornaUltima(Stanza stanza) {
			this.ultimaAggiunta = stanza;
			this.nome2stanza.put(stanza.getNome(), stanza);
		}

		public Labirinto getLabirinto() {
			return this.labirinto;
		}

		public Map<String, Stanza> getListaStanze() {
			return nome2stanza;
		}

	}
}
