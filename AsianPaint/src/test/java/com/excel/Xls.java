package com.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Xls {
	static String mobileNumber;
	public static ArrayList<Object[]>getDataFromExcel(String sheetName) throws IOException
	{
		
		ArrayList<Object[]>myData=new ArrayList<Object[]>();
String filePath="./src\\test\\java\\com\\excel";
String fileName="TestData1.xlsx";

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
        
        int rows = sheet.getLastRowNum() - sheet.getFirstRowNum();
        int cols = sheet.getRow(0).getLastCellNum()-sheet.getRow(0).getFirstCellNum();
        
        System.out.println("No. of rows = " + rows + " and No. of columns = " + cols);
        
        for (int i = 1; i <= rows; i++)
        {
            Row row = sheet.getRow(i);
            
            String firstNmae = row.getCell(0).getStringCellValue();
            String lastName = row.getCell(1).getStringCellValue();
             mobileNumber=row.getCell(2).getStringCellValue();
            Object obj[]= {firstNmae,lastName,mobileNumber};
            myData.add(obj);
        }
        
        wBook.close();
        inp.close();
        System.out.println("mobile"+mobileNumber);
        return myData;
    

	}
	
	
}
