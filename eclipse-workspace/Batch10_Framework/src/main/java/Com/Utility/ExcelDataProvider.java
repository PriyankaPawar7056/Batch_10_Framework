package Com.Utility;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	
	public ExcelDataProvider() throws IOException {   //Constructor
		
		String path="C:\\Users\\rpgsa\\eclipse-workspace\\Batch10_Framework\\TestData\\Data.xlsx";
		FileInputStream file=new FileInputStream(path);
		 wb=new XSSFWorkbook(file);
	}
	
	public String getStringData(String sheetname,int row,int cell) {
		return wb.getSheet("Sheet1").getRow(row).getCell(cell).getStringCellValue();
	}

}
