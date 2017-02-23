package es.uniovi.asw.reportWriter;

import java.io.IOException;

public interface EmailWriter {
	
	void write(String email) throws IOException;
}
