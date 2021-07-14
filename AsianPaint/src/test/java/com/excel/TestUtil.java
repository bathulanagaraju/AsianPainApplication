package com.excel;

import java.util.ArrayList;
import java.util.Iterator;

import dataProvider.ConfigFileReader;

public class TestUtil 
{
	static Xls_Reader reader;
	public static ArrayList<Object[]>getDataFromExcel(String sheatName)
	{
		ConfigFileReader configFileReader=new ConfigFileReader();
		ArrayList<Object[]>myData=new ArrayList<Object[]>();
		reader=new Xls_Reader("./src\\test\\java\\com\\excel\\TestData1.xlsx");
		
		if(sheatName=="PersonalInformation") {
		String firstName=reader.getCellData("PersonalInformation", "FirstName", 2);
		String lastNmae=reader.getCellData("PersonalInformation", "LastName", 2);
		String mobileNumber=reader.getCellData("PersonalInformation", "MobileNumber", 2);
		
		Object ob[]= {firstName,lastNmae,mobileNumber};
		myData.add(ob);
		}
		
		else if(sheatName=="InvalidMobileNumber")
		{
			for(int rowNum=2;rowNum<=reader.getRowCount("InvalidMobileNumber");rowNum++)
			{
				String mobileNumber=reader.getCellData("InvalidMobileNumber", "MobileNumber", rowNum);
				Object ob[]= {mobileNumber};
				myData.add(ob);
			}
		}
		else if(sheatName=="LeasThanDigitMobileNumber")
		{
			for(int rowNum=2;rowNum<=reader.getRowCount("LeasThanDigitMobileNumber");rowNum++)
			{
				String mobileNumber=reader.getCellData("LeasThanDigitMobileNumber", "MobileNumber", rowNum);
				Object ob[]= {mobileNumber};
				myData.add(ob);
			}
		}
		return myData;
	}

	


}
