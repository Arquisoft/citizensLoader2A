package es.uniovi.asw;

import static org.junit.Assert.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.uniovi.asw.modelos.Citizen;

public class CitizensLoaderTest {
	
    private CitizensLoader excel;

    @Before
    public void cargaExcel() throws IOException {
	excel = new CitizensLoader();
	excel.load("excel", "src/test/resources/test.xlsx");
    }


    // El suppressWarning es porque la clase Date que usamos al cargar la fecha
    // está obsoleta
    @SuppressWarnings("deprecation")
    @Test
    public void testParserExcel() {
		int size = excel.getCitizens().size() - 1;
		Citizen listExcel = excel.getCitizens().get(size);
		// El usuario de control para comprobar que todo se carga correctamente
		// será el último de la lista del excel
		assertTrue(listExcel.getNombre().equals("Ana"));
		assertTrue(listExcel.getApellidos().equals("Torres Pardo"));
		assertTrue(listExcel.getEmail().equals("ana@example.com"));
		Date date = new Date("01/01/1960");
		// assertTrue(listExcel.getFechaNacimiento() == date);
		assertTrue(listExcel.getDireccionPostal().equals("Av. De la Constitución 8"));
		assertTrue(listExcel.getNacionalidad().equals("Español"));
		assertTrue(listExcel.getDni().equals("09940449X"));
    }

    @Test
    public void testCitizensLoaderFromTxt() throws IOException {
    	CitizensLoader citizensLoader = new CitizensLoader();
		citizensLoader.load("texto", "src/test/resources/test.txt");
		List<Citizen> citizens = citizensLoader.getCitizens();
		assertEquals(6, citizens.size());
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		Citizen pablo = citizens.get(0);
		assertEquals(pablo.getNombre(), "Pablo");
		assertEquals(pablo.getApellidos(), "Alonso Gil");
		assertEquals(pablo.getEmail(), "pablo@example.com");
		String fechaNacimientoPablo = dateFormat.format(pablo.getFechaNacimiento());
		assertEquals(fechaNacimientoPablo, "10/10/1985");
		assertEquals(pablo.getDireccionPostal(), "Calle Mayor 2");
		assertEquals(pablo.getNacionalidad(), "Noruega");
		assertEquals(pablo.getDni(), "90500084Y");
		
		Citizen eva = citizens.get(5);
		assertEquals(eva.getNombre(), "Eva");
		assertEquals(eva.getApellidos(), "Belmonte Blanco");
		assertEquals(eva.getEmail(), "eva@example.com");
		String fechaNacimientoEva = dateFormat.format(eva.getFechaNacimiento());
		assertEquals(fechaNacimientoEva, "02/05/1960");
		assertEquals(eva.getDireccionPostal(), "Avenida del sur 5");
		assertEquals(eva.getNacionalidad(), "Italiana");
		assertEquals(eva.getDni(), "59120962S");
    }

}
