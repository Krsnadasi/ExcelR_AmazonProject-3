package PageObjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AccessExcelSheet {
	static File file=new File("./ExternalFiles/ExcelProject-3.xlsx");
    
	public static XSSFSheet ExcelCategory() throws IOException
	{FileInputStream fis=new FileInputStream(file);
	 XSSFWorkbook workBook=new XSSFWorkbook(fis);
	 XSSFSheet sheet=workBook.getSheet("CategoryList");
	  return sheet;	
	}
	
	public static XSSFSheet ExcelRegistration() throws IOException
	{FileInputStream fis=new FileInputStream(file);
	 XSSFWorkbook workBook=new XSSFWorkbook(fis);
	 XSSFSheet sheet=workBook.getSheet("Registration");
	  return sheet;	
	}
}
