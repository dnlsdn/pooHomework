package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {

	private Direzione direzioneBloccata;
	private String attrezzoSbloccante;

	public StanzaBloccata(String nome, String direzioneBloccata, String attrezzoSbloccante) {
		super(nome);
		this.direzioneBloccata = Direzione.valueOf(direzioneBloccata);
		this.attrezzoSbloccante = attrezzoSbloccante;
	}



	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(direzioneBloccata.equals(Direzione.valueOf(direzione)) && !this.hasAttrezzo(attrezzoSbloccante)) {
			return this;
		}
		return super.getStanzaAdiacente(direzione);
	}

	@Override
	public String getDescrizione() {
		String bloccata = "Stanza bloccata nella direzione: "+ direzioneBloccata+"\nPrendi il " + attrezzoSbloccante + " e posalo nella stanza";

		if(!this.hasAttrezzo(attrezzoSbloccante))
			return bloccata;
		return super.getDescrizione();
	}
}


