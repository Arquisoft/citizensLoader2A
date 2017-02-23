package es.uniovi.asw;

import static org.junit.Assert.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;

import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.model.exception.BusinessException;

public class CitizensLoaderTest {

    @Test
    public void testCitizensLoaderFromTxt() throws IOException, BusinessException {
    	CitizensLoader citizensLoader = new CitizensLoader();
		citizensLoader.load("texto", "src/test/resources/test.txt");
		List<Citizen> citizens = citizensLoader.getCitizens();
		assertEquals(7, citizens.size());
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		Citizen pablo = citizens.get(0);
		assertEquals(pablo.getNombre(), "Pablo");
		assertEquals(pablo.getApellidos(), "Alonso Gil");
		assertEquals(pablo.getEmail(), "pablo@example.com");
		String fechaNacimientoPablo = dateFormat.format(pablo.getFechaNacimiento());
		assertEquals(fechaNacimientoPablo, "10/10/1985");
		assertEquals(pablo.getDireccionPostal(), "Calle Mayor 2");
		assertEquals(pablo.getNacionalidad(), "Noruega");
		assertEquals(pablo.getDni(), "90500094Y");
		assertEquals(pablo.getNombreUsuario(), "pablo@example.com");
		assertEquals(pablo.getContrasena(), "Pablo123");
		
		Citizen eva = citizens.get(5);
		assertEquals(eva.getNombre(), "Eva");
		assertEquals(eva.getApellidos(), "Belmonte Blanco");
		assertEquals(eva.getEmail(), "eva@example.com");
		String fechaNacimientoEva = dateFormat.format(eva.getFechaNacimiento());
		assertEquals(fechaNacimientoEva, "02/05/1960");
		assertEquals(eva.getDireccionPostal(), "Avenida del sur 5");
		assertEquals(eva.getNacionalidad(), "Italiana");
		assertEquals(eva.getDni(), "59120962S");
		assertEquals(eva.getNombreUsuario(), "eva@example.com");
		assertEquals(eva.getContrasena(), "Eva123");
    }
    
    
    @Test
    public void testCitizensLoaderFromExcel() throws IOException, BusinessException {
    	CitizensLoader citizensLoader = new CitizensLoader();
		citizensLoader.load("excel", "src/test/resources/test.xlsx");
		List<Citizen> citizens = citizensLoader.getCitizens();
		assertEquals(3, citizens.size());
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		Citizen juan = citizens.get(0);
		assertEquals(juan.getNombre(), "Juan");
		assertEquals(juan.getApellidos(), "Torres Pardo");
		assertEquals(juan.getEmail(), "juan@example.com");
		String fechaNacimientoJuan = dateFormat.format(juan.getFechaNacimiento());
		assertEquals(fechaNacimientoJuan, "10/10/1985");
		assertEquals(juan.getDireccionPostal(), "C/ Federico García Lorca 2");
		assertEquals(juan.getNacionalidad(), "Español");
		assertEquals(juan.getDni(), "90500084Y");
		assertEquals(juan.getNombreUsuario(), "juan@example.com");
		assertEquals(juan.getContrasena(), "Juan123");
		
		Citizen ana = citizens.get(2);
		assertEquals(ana.getNombre(), "Ana");
		assertEquals(ana.getApellidos(), "Torres Pardo");
		assertEquals(ana.getEmail(), "ana@example.com");
		String fechaNacimientoAna = dateFormat.format(ana.getFechaNacimiento());
		assertEquals(fechaNacimientoAna, "01/01/1960");
		assertEquals(ana.getDireccionPostal(), "Av. De la Constitución 8");
		assertEquals(ana.getNacionalidad(), "Español");
		assertEquals(ana.getDni(), "09940449X");
		assertEquals(ana.getNombreUsuario(), "ana@example.com");
		assertEquals(ana.getContrasena(), "Ana123");
    }

}
