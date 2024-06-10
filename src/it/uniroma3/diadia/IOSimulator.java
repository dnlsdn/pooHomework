package it.uniroma3.diadia;

import java.util.ArrayList;
import java.util.List;

public class IOSimulator implements IO{
	
	public List<String> righeInput;
	public List<String> messaggiOutput;
	
	public int indiceRigheInput;
	public int indiceMessaggiOutput;
	public int indiceMessaggiMostrati;
	
	public IOSimulator(List <String> righeInput) {
		this.righeInput = righeInput;
		this.messaggiOutput  = new ArrayList<>();
		this.indiceRigheInput = 0;
		this.indiceMessaggiOutput = 0;
		this.indiceMessaggiMostrati = 0;
	}
	
	@Override
	public void mostraMessaggio(String messaggio) {
		this.messaggiOutput.add(messaggio);
		this.indiceMessaggiOutput++;
	}

	@Override
	public String leggiRiga() {
		return this.righeInput.get(indiceRigheInput++);
	}
	
	public String nextMessaggio() {
		return messaggiOutput.get(indiceMessaggiMostrati++);
	}
	
	public boolean hasMessaggio() {
		return indiceMessaggiMostrati < indiceMessaggiOutput;
	}

}
