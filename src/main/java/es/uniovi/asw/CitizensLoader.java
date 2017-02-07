package es.uniovi.asw;

import java.io.IOException;
import java.util.List;

import es.uniovi.asw.Modelos.Citizen;
import es.uniovi.asw.parser.CitizensReader;

public abstract class CitizensLoader {

	public void load(String filePath) throws IOException {
		List<Citizen> citizens = getReader().readCitizens(filePath); 
		printCitizens(citizens);
		//Comprobaciones
		//Insertar en base de datos
	}
	
	/**
	 * Factory method, si queremos añadir más tipos de readers en el futuro no hay 
	 * que cambiar ninguna clase ni recompilar. Principio de abierto cerrado:  abierto para
	 * extensión, y cerrado para modificación.
	 *
	 */
	abstract protected CitizensReader getReader();
	
	private void printCitizens(List<Citizen> citizens) {
		for (Citizen citizen : citizens) {
			System.out.println(citizen);
		}
	}

}
