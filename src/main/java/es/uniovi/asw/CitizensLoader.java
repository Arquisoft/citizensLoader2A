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

	public static void main(String... args) throws IOException {

		//new CitizensLoader().load((String) args[0], (String) args[1]);

		// Por si hay problemas con la de arriba
		new CitizensLoader().load("excel", "src/test/resources/test.xlsx"); 
		//new CitizensLoader().load("texto", "src/test/resources/test.txt"); 
	}

	public void load(String formato, String filePath) throws IOException {
		List<Citizen> citizens = getReader(formato).readCitizens(filePath); 
		printCitizens(citizens);
		//Comprobaciones (¿Alguno de los usuarios que he leido está ya en la base de datos?)
		//Insertar en base de datos
	}

	/**
	 * Crea y devuelve el reader adecuado
	 */
	private CitizensReader getReader(String formato) {
		if (formato.equals("excel")) {
			return new ExcelCitizensReader();
		}
		else if(formato.equals("texto")) {
			return new TextCitizensReader();
		}
		return null;
	}

	private void printCitizens(List<Citizen> citizens) {
		for (Citizen citizen : citizens) {
			System.out.println(citizen);
		}
	}

	private void LoadDB(List<Citizen> citizens) {
		EntityManager EM = Jpa.getEntityManager();
		EntityTransaction ET = EM.getTransaction();
		ET.begin();
		for(Citizen c : citizens) {
			EM.persist(c);
		}
		ET.commit();
	}		
	
	
		/** Comprobar para cada ciudadano si ya esta en la BD **/
	 	public boolean IsCitizenEqualTo(Citizen c) {
	 		Long numero = (Long) Jpa.getEntityManager().createQuery("SELECT COUNT(c)"
	 				+ " FROM CITIZEN C"
	 				+ " WHERE C.DNI = ?1")
	 		.setParameter(1, c.getDni()) 
	 		.getSingleResult();
	 		return numero != 0;
	 	}

}
