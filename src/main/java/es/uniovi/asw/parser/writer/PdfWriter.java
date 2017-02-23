package es.uniovi.asw.parser.writer;

import javax.swing.text.Document;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import es.uniovi.asw.modelos.Citizen;

public class PdfWriter implements Writer {

	String path = "src/main/resources/";

	
	@Override
	public void writer(Citizen citizen) {
        PdfWriter writer = new PdfWriter(path+citizen.getDni()+".pdf");
 
        PdfDocument pdf = new PdfDocument(writer);
 
        Document document = new Document(pdf);
        document.add(new Paragraph(citizen.getNombre() + "Su usuario es:" + citizen.getNombreUsuario()
		+ "y su contraseña es:" + citizen.getContrasena()));
         document.close();
	}
}
