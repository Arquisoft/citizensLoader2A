package es.uniovi.asw.parser.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import es.uniovi.asw.modelos.Citizen;

public class TxtWriter implements Writer {

	@Override
	public void writer(Citizen citizen) {

		String path = "src/main/resources/";

		BufferedWriter BufferedWriter = null;

		try {
			BufferedWriter = new BufferedWriter(new FileWriter(path + citizen.getDni() + ".txt"));
			BufferedWriter.write(citizen.getNombre() + "Su usuario es:" + citizen.getNombreUsuario()
					+ "y su contraseña es:" + citizen.getContrasena());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			if (BufferedWriter != null) {
				try {
					BufferedWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
