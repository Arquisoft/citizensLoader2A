package es.uniovi.asw;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import es.uniovi.asw.modelos.Citizen;
import es.uniovi.asw.parser.CitizensReader;
import es.uniovi.asw.parser.ExcelCitizensReader;
import es.uniovi.asw.parser.TextCitizensReader;
import es.uniovi.asw.persistence.Jpa;

public class CitizensLoader {

	private List<Citizen> citizens;

	public static void main(String... args) {
		try {
			new CitizensLoader().load((String) args[0], (String) args[1]);
			// Por si hay problemas con la de arriba
			// new CitizensLoader().load("excel", "src/test/resources/test.xlsx");
			// new CitizensLoader().load("texto", "src/test/resources/test.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void load(String formato, String filePath) throws IOException {
		citizens = getReader(formato).readCitizens(filePath);
		printCitizens(citizens, filePath);
		// Comprobaciones (¿Alguno de los usuarios que he leido está ya en la
		// base de datos?)
		// Insertar en base de datos
	}

	protected List<Citizen> getCitizens() {
		return citizens;
	}

	/**
	 * Crea y devuelve el reader adecuado
	 */
	private CitizensReader getReader(String formato) {
		if ("excel".equals(formato)) {
			return new ExcelCitizensReader();
		} else if ("texto".equals(formato)) {
			return new TextCitizensReader();
		}
		return null;
	}

	private void printCitizens(List<Citizen> citizens, String filePath) {
		System.out.println("Estos son los usuarios presentes en el fichero " + filePath + ":");
		for (Citizen citizen : citizens) {
			System.out.println(citizen);
		}
	}

	private void loadDB(List<Citizen> citizens) {
		EntityManager EM = Jpa.getEntityManager();
		EntityTransaction ET = EM.getTransaction();
		ET.begin();
		for (Citizen c : citizens) {
			EM.persist(c);
		}
		ET.commit();
	}

	/** Comprobar para cada ciudadano si ya esta en la BD **/
	public boolean isCitizenEqualTo(Citizen c) {
		Long numero = (Long) Jpa
				.getEntityManager()
				.createQuery(
						"SELECT COUNT(c)" + " FROM CITIZEN C"
								+ " WHERE C.DNI = ?1")
				.setParameter(1, c.getDni()).getSingleResult();
		return numero != 0;
	}

}
