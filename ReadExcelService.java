package serviceNow;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelService {
	public static String[][] readExcelservicenow(String fileName) throws IOException
	{
		XSSFWorkbook wb = new XSSFWorkbook("./data/" +fileName+ ".xlsx");
		XSSFSheet ws = wb.getSheet("Assignincident");
		int lastRowNum = ws.getLastRowNum();
		int  lastCellNum = ws.getRow(0).getLastCellNum();
		String[][] data = new String[lastRowNum][lastCellNum];
		for(int i =1;i<=lastRowNum;i++)
		{
			for(int j =0;j<lastCellNum;j++)
			{
				String text = ws.getRow(i).getCell(j).getStringCellValue();
				System.out.println(text);
				data[i-1][j]=text;
			}
		}
		wb.close();
		return data;
		
	}

}
