package es.uniovi.asw;

import java.io.IOException;
import java.util.List;

import es.uniovi.asw.business.CitizenService;
import es.uniovi.asw.conf.ServicesFactory;
import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.model.exception.BusinessException;
import es.uniovi.asw.parser.CitizensReader;
import es.uniovi.asw.parser.ExcelCitizensReader;
import es.uniovi.asw.parser.TextCitizensReader;
import es.uniovi.asw.reportWriter.EmailWriter;
import es.uniovi.asw.reportWriter.LogWriter;
import es.uniovi.asw.reportWriter.TxtEmailWriter;

public class CitizensLoader {

	private List<Citizen> citizens;

	public static void main(String... args) {
		try {
			new CitizensLoader().load((String) args[0], (String) args[1]);
			// Por si hay problemas con la de arriba
			// new
			// CitizensLoader().load("excel","src/test/resources/test.xlsx");
			// new CitizensLoader().load("texto","src/test/resources/test.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void load(String formato, String filePath) throws IOException,
			BusinessException {

		CitizenService citizenService = ServicesFactory.getCitizenService();

		citizens = getReader(formato).readCitizens(filePath);
		printCitizens(citizens, filePath);

		for (Citizen citizen : citizens) {
			if (!citizenService.isCitizenInDatabase(citizen)) {
				sendEmail(citizen, new TxtEmailWriter());
				citizenService.newCitizen(citizen);
			} else {
				String mensaje = "El usuario "
						+ citizen.getNombreUsuario()
						+ " ya está registrado.";
				LogWriter.write(mensaje);
			}
		}
	}

	private void sendEmail(Citizen citizen, EmailWriter... writers) throws IOException {
		String email = "To "
				+ citizen.getEmail()
				+ ":\nSaludos "
				+ citizen.getNombre()
				+ ", le informamos de que ha sido registrado correctamente en el sistema de participación ciudadana.\nSu nombre de usuario es: "
				+ citizen.getNombreUsuario();
		for (EmailWriter writer : writers) {
			writer.write(email);
		}

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
		System.out.println("Estos son los usuarios presentes en el fichero "
				+ filePath + ":");
		for (Citizen citizen : citizens) {
			System.out.println(citizen);
		}
	}

}
