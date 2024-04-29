package it.uniroma3.comandi;

import it.uniroma3.diadia.IO;

public interface FabbricaDiComandi {
	public Comando costruisciComando(String istruzione, IO io);
}
