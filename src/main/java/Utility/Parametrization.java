package Utility;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Parametrization {
	public static String getData(int row, int cell) { 
		try {
			FileInputStream file = new FileInputStream("C:\\PROJECT\\src\\test\\resources\\TestData.xlsx");
			return WorkbookFactory.create(file).getSheet("Customer create").getRow(row).getCell(cell).getStringCellValue();
		} catch (Exception e) {
			System.out.println("❌ Error reading Excel data: " + e.getMessage());
			return null;
		}
	}
}
