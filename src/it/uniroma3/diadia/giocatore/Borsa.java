package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa{
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Map<String, Attrezzo> attrezzi;
	private int pesoMax;
	private int pesoCorrente;

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA); 
	}
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.pesoCorrente = 0;
		this.attrezzi = new HashMap<>(DEFAULT_PESO_MAX_BORSA); // speriamo bastino...
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		this.pesoCorrente+= attrezzo.getPeso();
		this.attrezzi.put(attrezzo.getNome(), attrezzo);
		return true;
	}
	public int getPesoMax() {
		return pesoMax;
	}
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return attrezzi.get(nomeAttrezzo);
	}
	public int getPeso() {
		return this.pesoCorrente;
	}
	
	public boolean isEmpty() {
		return this.attrezzi.isEmpty();
	}
	
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return attrezzi.containsKey(nomeAttrezzo);
	}
	
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo removed = attrezzi.remove(nomeAttrezzo);
		if(removed!= null) {
			this.pesoCorrente-=removed.getPeso();
		}
		return removed;	
	}
	
	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		List<Attrezzo> l = new ArrayList<>(attrezzi.values());
		ComparatorePeso comp = new ComparatorePeso();
		Collections.sort(l, comp);
		return l;
		}
	
	public List<Attrezzo> getContenutoOrdinatoPerNome(){
		List<Attrezzo> l = new ArrayList<>(attrezzi.values());
		ComparatoreNome comp = new ComparatoreNome();
		Collections.sort(l, comp);
		return l;
	}
	
	public Map<Integer, Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		Map<Integer, Set<Attrezzo>> m = new HashMap<>();
		for(Attrezzo a: attrezzi.values()) {
			Integer peso = a.getPeso();
			if (!m.containsKey(peso)) {
				m.put(peso, new HashSet<>());
			}
			m.get(peso).add(a);
		}
		return m;
	}
	
	SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		ComparatorePeso comp = new ComparatorePeso();
		SortedSet<Attrezzo> ts = new TreeSet<>(comp);
		ts.addAll(attrezzi.values());
		return ts;
	}
	
	
	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			s.append(attrezzi.values().toString());
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
}
	
	
	
	