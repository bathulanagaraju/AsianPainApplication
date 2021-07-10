package testNG;

import org.testng.annotations.Test;

import com.excel.Xls_Reader;

import dataProvider.ConfigFileReader;
import pageFactory.EditPersonalInformation;
import stepDefinition.Edit;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class EditPersonalInfoTestNG {
	WebDriver driver;
	EditPersonalInformation editPersonalInformation;
	ConfigFileReader configFileReader;
	Xls_Reader reader=new Xls_Reader("./src\\test\\java\\com\\excel\\testdata.xlsx");
  @Test(priority = 1)
  public void editPersonalInfo() 
  {
	  String firstName=reader.getCellData("PersonalInfo", "FirstName", 2);
	  String lastName=reader.getCellData("PersonalInfo", "LastName", 2);
	  String mobileNumber=reader.getCellData("PersonalInfo", "MobileNumber", 2);
	  editPersonalInformation.clickOnEdit();
	  editPersonalInformation.clickOnFirstName(firstName);
	  editPersonalInformation.clickOnLastName(lastName);
	  editPersonalInformation.selectDob();
	  editPersonalInformation.clickOnMobile(mobileNumber);
	  editPersonalInformation.clickOnUpdate();
  }
  @Test(priority = 2)
  public void editMobileNumber(String mobileNumber) 
  {
	  for(int i=2;i<=reader.getRowCount("MobileNumber");i++)
	  {
		  editPersonalInformation.clickOnEdit();
		  editPersonalInformation.clickOnMobile(mobileNumber);
		  editPersonalInformation.errorMessage();
		  
	  }
  }
  @BeforeTest
  public void launchApplication() {
	  configFileReader=new ConfigFileReader();
      driver=Edit.lonchApplication("chrom", configFileReader.getApplicationUrl(), configFileReader.getDriverPath());
      Edit.login(driver);
      Edit.myProfile(driver);
      editPersonalInformation=new EditPersonalInformation(driver);
  }

  @AfterTest
  public void stop() {
	  driver.quit();
  }

}
