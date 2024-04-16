package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando{

	@Override
	public void esegui(Partita partita) {
		System.out.println("Questo comando non è valido");
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public String getNome() {
		return "comando non valido";
	}

	@Override
	public String getParametro() {
		return "Questo comando non ha parametri";
	}
	
}
