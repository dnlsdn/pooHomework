package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public abstract class AbstractPersonaggio {
	private String nome;
	private String presentazione;
	private Boolean haSalutato;
	
	public AbstractPersonaggio(String nome, String presentazione) {
		super();
		this.nome = nome;
		this.presentazione = presentazione;
		this.haSalutato = false;
	}

	public String getNome() {
		return nome;
	}

	public Boolean haSalutato() {
		return this.haSalutato;
	}
	
	public String saluta() {
		StringBuilder risposta = new StringBuilder("Ciao, io sono " + this.nome);
		
		if(!haSalutato) risposta.append(this.presentazione);
		else risposta.append("Ci siamo già presentati!");
		
		this.haSalutato = true;
		return risposta.toString();
	}
	
	abstract public String agisci(Partita partita);
	
	public abstract String riceviRegalo(Attrezzo attrezzo, Partita partita);
	
	@Override
	public String toString() {
		return this.nome;
	}
}
