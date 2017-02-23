package es.uniovi.asw.reportWriter;

import java.io.IOException;

import es.uniovi.asw.reportWriter.util.Writer;

public class TxtEmailWriter implements EmailWriter {
	
	private static final String fileName = "src/test/resources/emails.txt";
	
	@Override
	public void write(String email) throws IOException {
		Writer.write(fileName, email);
	}

}
