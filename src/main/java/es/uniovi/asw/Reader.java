package es.uniovi.asw;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import es.uniovi.asw.Modelos.Citizen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Reader {
	

	    private static final String fichero = "/CitizensLoader2A/Citizens.xlsx";

	    public static void main(String[] args) {
	    	
	    	List<String> Citizen = new ArrayList();

	        try {

	            FileInputStream excelFile = new FileInputStream(new File(fichero));
	            Workbook workbook = new XSSFWorkbook(excelFile);
	            Sheet datatypeSheet = workbook.getSheetAt(0);
	            Iterator<Row> iterator = datatypeSheet.iterator();

	            while (iterator.hasNext()) {

	                Row currentRow = iterator.next();
	                Iterator<Cell> cellIterator = currentRow.iterator();

	                while (cellIterator.hasNext()) {

	                    Cell currentCell = cellIterator.next();	              
	                    if (currentCell.getCellTypeEnum() == CellType.STRING) {
	                        //System.out.print(currentCell.getStringCellValue() + "-");
	                    	Citizen.add(currentCell.getStringCellValue());
	                    } else if (currentCell.getCellTypeEnum() != CellType.STRING) {
	                      //Añadir codigo para el DATE

	                    }

	                }
	                System.out.println();

	            }
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	    }
	}


