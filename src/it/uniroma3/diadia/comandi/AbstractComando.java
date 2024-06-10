package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public abstract class AbstractComando implements Comando{
	public IO io;
	private final static String NOME = "abstract comando";
	public String parametro;
	
	@Override
    public abstract void esegui(Partita partita);
    
    @Override
    public void setParametro(String parametro) {
    	this.parametro = parametro;
    }
    
    @Override
    public String getParametro() {
    	return this.parametro;
    }

    @Override
    public String getNome() {
    	return NOME;
    }
    
    @Override
	public void setIO(IO io) {
    	this.io = io;
    }
    
    public IO getIO() {
    	return this.io;
    }
}
