package es.uniovi.asw;

import java.io.IOException;

import es.uniovi.asw.parser.CitizensReader;
import es.uniovi.asw.parser.ExcelCitizensReader;

public class ExcelCitizensLoader extends CitizensLoader {
	
	public static void main(String... args) throws IOException {
		//new ExcelCitizensLoader().load("src/test/resources/test.xlsx"); // Por si hay problemas con la de abajo
		new ExcelCitizensLoader().load(args[0]);
	}
	
	@Override
	protected CitizensReader getReader() {
		return new ExcelCitizensReader();
	}
	
}
