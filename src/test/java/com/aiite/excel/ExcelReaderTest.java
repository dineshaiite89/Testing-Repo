package com.aiite.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.lang.model.element.NestingKind;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReaderTest {
	public void excelRead() throws IOException {
		File file = new File("C:\\Users\\dines\\Workspace\\FebProject2\\ExcelFileRead\\src\\test\\resources\\TestData\\Testing.xlsx");
		FileInputStream fileinput = new FileInputStream(file);

		Workbook workbook = new XSSFWorkbook(fileinput);
		
		Sheet sheet = workbook.getSheet("Sheet1");
		int totalRows = sheet.getPhysicalNumberOfRows();

		Row row = sheet.getRow(1);
		Cell cell = row.getCell(1);
		String stringCellValue = cell.getStringCellValue();
		System.out.println(stringCellValue);

		workbook.close();
	}

	public static void main(String[] args) throws IOException {

		File file = new File("C:\\Users\\dines\\Workspace\\FebProject2\\ExcelFileRead\\src\\test\\resources\\TestData\\Testing.xlsx");
		FileInputStream fileinput = new FileInputStream(file);

		Workbook workbook = new XSSFWorkbook(fileinput);
		
		Sheet sheet = workbook.getSheet("Sheet1");
		int totalRows = sheet.getPhysicalNumberOfRows();
		for (int i = 0; i < totalRows; i++) {
			Row row = sheet.getRow(i);
			int totalCells = row.getPhysicalNumberOfCells();
			for (int j = 0; j < totalCells; j++) {
				Cell cell = row.getCell(j);
				CellType cellType = cell.getCellType();
				
				if(cellType == CellType.STRING) {
					String stringCellValue = cell.getStringCellValue();
					System.out.println(stringCellValue);									
				}else if(DateUtil.isCellDateFormatted(cell)) {
					Date dateCellValue = cell.getDateCellValue();
					SimpleDateFormat simpleFormat = new SimpleDateFormat("MM-dd-yyyy");
					String stringDate = simpleFormat.format(dateCellValue);
					System.out.println(stringDate);
					
				}
				else if( cellType == CellType.NUMERIC) {
					double numericCellValue = cell.getNumericCellValue();
					System.out.println(numericCellValue);
				} 
				
			}
		}

		workbook.close();
	}
}
