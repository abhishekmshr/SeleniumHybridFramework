package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

public XSSFWorkbook wb;	
	public ExcelDataProvider()
	{
		File src=new File("./ApplicationTestData/AppData.xlsx");
		try {
			FileInputStream fis=new FileInputStream(src);
			wb=new XSSFWorkbook(fis);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getData(int sheetIndex,int row,int column)
	{
	String Data=wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue()	;
	return Data;
	}
	
	public String getData(String sheetName,int row,int column)
	{
	String Data=wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue()	;
	return Data;
	}
}
