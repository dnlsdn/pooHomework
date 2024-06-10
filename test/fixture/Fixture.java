package fixture;

import java.util.List;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.ambienti.Labirinto;

public class Fixture {
	public static IOSimulator creaEAvviaSimulazione(Labirinto labirinto, List<String> righeInput) throws Exception {
		IOSimulator ioSimulator = new IOSimulator(righeInput);
		DiaDia diadia = new DiaDia(ioSimulator, labirinto);
		diadia.gioca();
		return ioSimulator;
	}
}
