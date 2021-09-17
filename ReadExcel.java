package testLeaftestcases;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ReadExcel {
	//@DataProvider
 public static String[][] readcreateleadData(String fileName) throws IOException
 {
	 XSSFWorkbook wb = new XSSFWorkbook("./data/"+fileName+".xlsx");
	 XSSFSheet ws = wb.getSheet("sheet1");
	// XSSFRow row = ws.getRow(1);
	// XSSFCell cell = row.getCell();
	 int rowcount = ws.getLastRowNum();
	 int cellcount = ws.getRow(0).getLastCellNum();
	 String[][] data = new String[rowcount][cellcount];
	 for(int i = 1;i<=rowcount;i++)
	 {
		 for(int j=0;j<cellcount;j++) {
			 
			String text = ws.getRow(i).getCell(j).getStringCellValue();
			System.out.println(text);
			data[i-1][j]= text;
		}
		 
	 }
	
	 wb.close();
	 return data;
	
	 
 }
	
	
}
