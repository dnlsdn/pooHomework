package it.uniroma3.diadia.comandi;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto extends AbstractComando implements Comando{
	
	private String[] elencoComandi;
	private final static String NOME_COMANDO = "aiuto";
	
	public ComandoAiuto() {
		try {
			elencoComandi = getElencoComandiFromPackagePath();
		} catch (Exception e) {
			System.out.println("Non è stato possibile recuperare l'elenco dei comandi");
		}
	}
	

	private String[] getElencoComandiFromPackagePath() {
		List<String> elencoComandi = new ArrayList<>();
		
		String packagePath = ComandoAiuto.class.getPackageName().replace(".", "/");
		ClassLoader classLoader = ComandoAiuto.class.getClassLoader();
		
		File packageDir = new File(classLoader.getResource(packagePath).getFile());
		File[] files = packageDir.listFiles();
		
		for(File f : files) {
			if (f.getName().endsWith(".class")
					&& f.getName().startsWith("Comando")
					&& !f.getName().contains("Test")) {
				String daAggiungere = f.getName().replace(".class", "").replace("Comando", "").toLowerCase();
				if (!daAggiungere.equals("nonvalido") && daAggiungere.length()!= 0) {
					elencoComandi.add(daAggiungere);
				}
			}
		}
		
		String[] elencoComandiArray =  elencoComandi.toArray(new String[0]);
		return elencoComandiArray;
		
	}


	@Override
	public void esegui(Partita partita) {
		for (int i = 0; i < this.elencoComandi.length; i++)
			io.mostraMessaggio(this.elencoComandi[i] + " ");
		io.mostraMessaggio("");
		
	}

	@Override
	public String getNome() {
		return NOME_COMANDO;
	}
}
