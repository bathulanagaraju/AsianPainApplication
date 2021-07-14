package testNG;

import org.testng.annotations.Test;

import com.excel.TestUtil;
import com.excel.Xls;

import dataProvider.ConfigFileReader;
import pageFactory.EditPersonalInformation;
import pageFactory.MyprofilePageOject;
import pageFactory.SignoutPageObject;
import pageFactory.UploadProfilePageObject;
import utility.Base;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class AsianPaintTestNG
{
	WebDriver driver;
	ConfigFileReader configFileReader =new ConfigFileReader();
	MyprofilePageOject myprofilePageOject;
	EditPersonalInformation editPersonalInformation;
	UploadProfilePageObject object;
	 SignoutPageObject object2;
   
	 @BeforeMethod
	  public void launchApplication() {
			
			driver=MyProfileTestNG.lonchApplication("chrom", configFileReader.getApplicationUrl(), configFileReader.getDriverPath());
			MyProfileTestNG.login(driver);
			myprofilePageOject=new MyprofilePageOject(driver);
			editPersonalInformation=new EditPersonalInformation(driver);
			object=new UploadProfilePageObject(driver);
			object2=new SignoutPageObject(driver);
	  }

	 
	 
  @Test(priority = 1)
  public void myProfile() {
	  String actualTitle="My Profile";
		myprofilePageOject.clickOnMyProfileIcon();
		myprofilePageOject.clickOnMyProgile();
		String pageTitle=MyProfileTestNG.getPageTitle(driver);
		Assert.assertEquals(actualTitle, pageTitle);
  }
  @DataProvider
 	public  Iterator<Object[]> getPersonalInfo() throws IOException
 	{
 	  String sheatName=configFileReader.getSheatName1();
 	  System.out.println(sheatName);
 		ArrayList<Object[]>testData=Xls.getDataFromExcel("PersonalInformation");
 		return testData.iterator();
 	}
  @Test(priority = 2)
  public void uploadProfile() throws AWTException, InterruptedException
  {
	  Base.myProfile(driver);
	  object.clickOnUpload();
	  driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
	  boolean actStatues=false;
	boolean status=	object.uploadMessage();
		assertEquals(actStatues,status );
  }
  @Test(priority = 3,dataProvider = "getPersonalInfo")
  public void editProfile(String firstName,String lastName,String mobileNumber) {
	  Base.myProfile(driver);
	  
	  System.out.println(mobileNumber);
	  editPersonalInformation.clickOnEdit();
	  editPersonalInformation.clickOnFirstName(firstName);
	  editPersonalInformation.clickOnLastName(lastName);
	  editPersonalInformation.selectDob();
	  editPersonalInformation.clickOnMobile(mobileNumber);
	  driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
	  editPersonalInformation.clickOnUpdate();
	 
  }
  @DataProvider
	public  Iterator<Object[]> getinvalidMobileNumber()
	{
		String sheatNmae=configFileReader.getSheatName2();
		System.out.println(sheatNmae);
		ArrayList<Object[]>testData=TestUtil.getDataFromExcel("InvalidMobileNumber");
		
		return testData.iterator();
	}
  @Test(priority = 4,dataProvider = "getinvalidMobileNumber")
  public void invalidDigitsMobileNumber(String mobileNumber)
  {           
	  Base.myProfile(driver);
		  editPersonalInformation.clickOnEdit();
		  editPersonalInformation.clickOnMobile(mobileNumber);
		  String error= editPersonalInformation.errorMessage();
		   
		   String actualError2="Please enter digits only.";
		   System.out.println("**********************************************");
		   System.out.println(error);
		   System.out.println("***********************************************");
			  assertEquals(actualError2, error); 
		
		  editPersonalInformation.clickOnMobile( configFileReader.getMobileNumber());
		  editPersonalInformation.clickOnUpdate();
		  configFileReader.getImplicitlyWait();
	 
  }
  @DataProvider
	public  Iterator<Object[]> getLeasThanDigitMobileNumber()
	{
		String sheatNmae=configFileReader.getSheatName2();
		System.out.println(sheatNmae);
		ArrayList<Object[]>testData=TestUtil.getDataFromExcel("LeasThanDigitMobileNumber");
		
		return testData.iterator();
	}
  @Test(priority = 5,dataProvider = "getLeasThanDigitMobileNumber")
  public void invalidLeasThanDigitMobileNumber(String mobileNumber)
  {           
	  Base.myProfile(driver);
		  editPersonalInformation.clickOnEdit();
		  editPersonalInformation.clickOnMobile(mobileNumber);
		  String error= editPersonalInformation.errorMessage();
		   String actualError1="Please enter 10 digits mobile number.";
		
		   System.out.println("**********************************************");
		   System.out.println(error);
		   System.out.println("***********************************************");
		   assertEquals(actualError1, error);
		  editPersonalInformation.clickOnMobile( configFileReader.getMobileNumber());
		  editPersonalInformation.clickOnUpdate();
		  configFileReader.getImplicitlyWait();
	 
  }
  
  
 
  @Test(priority = 6)
  public void signoutApplication()
  {
	  myprofilePageOject.clickOnMyProfileIcon();
		object2.clickOnSignout();
		boolean actualStatus=false;
		boolean status=	object2.signoutConformation();
		Assert.assertEquals(actualStatus, status);
	  
  }
 
	
 
  @AfterMethod
  public void closeApplication() {
	  driver.quit();
  }

}
