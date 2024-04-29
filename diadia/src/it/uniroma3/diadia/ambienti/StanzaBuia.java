package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {

	private String nomeAttrezzo = "";

	public StanzaBuia(String nome, String nomeAttrezzo) {
		super(nome);
		this.nomeAttrezzo = nomeAttrezzo;
	}

	@Override
	public String getDescrizione(String nomeAttrezzo) {
		System.out.println("ok");
		if (!nomeAttrezzo.equals(this.nomeAttrezzo)) {
			return "Qui c'e un buio pesto";
		} else {
			return "";
		}
	}
}
