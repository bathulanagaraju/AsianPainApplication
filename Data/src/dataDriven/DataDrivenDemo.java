package dataDriven;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import liberey.Utility;



public class DataDrivenDemo {
	
	public static void validateLoginData(String filePath,String fileName,String sheetName) throws IOException {
		
		String baseUrl = "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx";
		String expectedTitle = "Web Orders";
		String actuaTitle = null;
		
		String uName = null;
		String passwd = null;
		
		WebDriver driver = Utility.lonchApplication(1, baseUrl);
		
		File file = new File(filePath + "\\" + fileName);
		
		FileInputStream inp = new FileInputStream(file);
		
		FileOutputStream out = null;
		Workbook wBook = null;
		
		String fileExtn = fileName.substring(fileName.indexOf("."));
		System.out.println(fileExtn);
		
		if(fileExtn.equals(".xlsx"))
		{
			wBook = new XSSFWorkbook(inp);
		}
		else
		{
			wBook = new HSSFWorkbook(inp);
		}
		
		Sheet sheet = wBook.getSheet(sheetName);
		
		int rows = sheet.getLastRowNum() - sheet.getFirstRowNum();//5-0=5
		int cols = sheet.getRow(0).getLastCellNum()-sheet.getRow(0).getFirstCellNum();//3-0=3
		
		System.out.println("No. of rows = " + rows + " and No. of columns = " + cols);
		
		for (int i = 1; i <= rows; i++)
		{
			Row row = sheet.getRow(i);
			
			uName = row.getCell(0).getStringCellValue();
			passwd = row.getCell(1).getStringCellValue();
			System.out.println(uName + "  " + passwd);
			
			Utility.loginPage(driver, uName, passwd);
			
			actuaTitle = Utility.getPageTitle(driver);
			
			if(actuaTitle.contentEquals(expectedTitle))
			{
				System.out.println(uName + " and " + passwd + " are valid credentials.");
				System.out.println("Test iteration passed.");
				driver.findElement(By.linkText("Logout")).click();
				Cell cell = row.createCell(2);
				cell.setCellValue("PASS");
				out = new FileOutputStream(file);
				wBook.write(out);
				out.close();
			}
			else
			{
				System.out.println(uName + " and " + passwd + " are not valid credentials.");
				System.out.println("Test iteration failed.");
				driver.findElement(By.id("ctl00_MainContent_username")).clear();
				Cell cell = row.createCell(2);
				cell.setCellValue("FAIL");
				out = new FileOutputStream(file);
				wBook.write(out);
				out.close();
			}
			
		}
		
		wBook.close();
		inp.close();
		driver.quit();
		
	}

	public static void main(String[] args) throws IOException {
		
		validateLoginData(".\\TestData", "testdata.xlsx", "Sheet1");
	}

}
