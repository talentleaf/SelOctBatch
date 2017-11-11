package util;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ReadExcel {
	
	
	public Object[][] readExcel(String fileName) throws IOException {
		XSSFRow firstRow;
		//open workBook
		XSSFWorkbook wBook = new XSSFWorkbook("./data/"+fileName+".xlsx");
		//got to sheet
		XSSFSheet sheet = wBook.getSheetAt(0);
		//find number of row count
		int rowCount = sheet.getLastRowNum();
		int columnCount = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[rowCount][columnCount];
		System.out.println("Row Count: "+ rowCount);
		System.out.println("Column Count: "+ columnCount);
		for (int i = 1; i <=rowCount; i++) {
			 firstRow = sheet.getRow(i);
			 System.out.println(i+" "+columnCount);
			 for (int j = 0; j < columnCount; j++) {
				 XSSFCell cell = firstRow.getCell(j);
				  data[i-1][j] = cell.getStringCellValue();
				System.out.println(data);
			}			
		}
		wBook.close();
		return data;
		
		
		
		
		
		
		
		
		
		
		
	}

}
