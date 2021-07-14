package testNG;

import org.testng.annotations.Test;

import dataProvider.ConfigFileReader;
import pageFactory.UploadProfilePageObject;
import utility.Base;

import org.testng.annotations.BeforeTest;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class UploadProfileTestNG extends Base
{
	WebDriver driver;
	ConfigFileReader configFileReader;
	UploadProfilePageObject object;
  @Test
  public void uploadProfilePicter() throws AWTException, InterruptedException 
  {
	  Base.myProfile(driver);
	  object.clickOnUpload();
	  
	  
	  
  }
  @BeforeMethod
  public void lanchApplication() 
  {
	  configFileReader=new ConfigFileReader();
	  driver=UploadProfileTestNG.lonchApplication("chrom", configFileReader.getApplicationUrl(), configFileReader.getDriverPath());
	  UploadProfileTestNG.login(driver);
	  object=new UploadProfilePageObject(driver);
  }

  @AfterMethod
  public void stop() 
  {
	 
  }

}
