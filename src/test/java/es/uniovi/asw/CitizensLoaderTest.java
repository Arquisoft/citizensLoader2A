package es.uniovi.asw;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import es.uniovi.asw.modelos.Citizen;

public class CitizensLoaderTest {
    CitizensLoader excel;
    CitizensLoader txt;

    @Before
    public void cargaExcel() throws IOException {
	excel = new CitizensLoader();
	excel.load("excel", "src/test/resources/test.xlsx");
    }

    @Before
    public void cargaTxt() throws IOException {
	txt = new CitizensLoader();
	txt.load("texto", "src/test/resources/test.txt");
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

    // El suppressWarning es porque la clase Date que usamos al cargar la fecha
    // está obsoleta
    @SuppressWarnings("deprecation")
    @Test
    public void testParserTxt() {
	int size = txt.getCitizens().size() - 1;
	Citizen listTxt = txt.getCitizens().get(size);
	// El usuario de control para comprobar que todo se carga correctamente
	// será el último de la lista del txt
	assertTrue(listTxt.getNombre().equals("Luis"));
	assertTrue(listTxt.getApellidos().equals("López Fernando"));
	assertTrue(listTxt.getEmail().equals("luis@example"));
	Date date = new Date("02/03/1970");
	// assertTrue(listTxt.getFechaNacimiento() == date);
	assertTrue(listTxt.getDireccionPostal().equals("C/Real Oviedo 2"));
	assertTrue(listTxt.getNacionalidad().equals("Español"));
	assertTrue(listTxt.getDni().equals("19160962F"));
    }

}
