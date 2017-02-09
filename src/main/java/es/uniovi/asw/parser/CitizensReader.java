package es.uniovi.asw.parser;

import java.io.IOException;
import java.util.List;

import es.uniovi.asw.modelos.Citizen;


public interface CitizensReader {
	
	List<Citizen> readCitizens(String filePath) throws IOException;
	
}
