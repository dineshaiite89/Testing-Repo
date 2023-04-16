package com.aiite.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUpdateTest {

	
	public static void main(String[] args) throws IOException, ParseException {
		
		File file = new File("C:\\Users\\dines\\Workspace\\FebProject2\\ExcelFileRead\\src\\test\\resources\\TestData\\Testing.xlsx");
		FileInputStream fileinput = new FileInputStream(file);

		Workbook workbook = new XSSFWorkbook(fileinput);
		
		Sheet sheet = workbook.getSheet("Sheet1");
		int totalRows = sheet.getPhysicalNumberOfRows();

		Row row = sheet.getRow(1);
		Cell cell = row.getCell(2);
		
//		cell.setCellValue("Gayathri S");
		Date simpleDate = new SimpleDateFormat("dd-MM-yyyy").parse("12-10-2002");

		cell.setCellValue(simpleDate);
		
		FileOutputStream outputStream = new FileOutputStream(file);
		
		workbook.write(outputStream);
		
		outputStream.close();
		fileinput.close();
		workbook.close();
		
		
	}
}
