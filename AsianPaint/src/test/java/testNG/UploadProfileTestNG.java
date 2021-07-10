package testNG;

import org.testng.annotations.Test;

import dataProvider.ConfigFileReader;
import pageFactory.UploadProfilePageObject;
import utility.Base;

import org.testng.annotations.BeforeTest;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class UploadProfileTestNG extends Base
{
	WebDriver driver;
	ConfigFileReader configFileReader;
	UploadProfilePageObject object;
  @Test
  public void uploadProfilePicter() throws AWTException, InterruptedException 
  {
	  object.clickOnUpload();
	  
	  
  }
  @BeforeTest
  public void lanchApplication() 
  {
	  configFileReader=new ConfigFileReader();
	  driver=UploadProfileTestNG.lonchApplication("chrom", configFileReader.getApplicationUrl(), configFileReader.getDriverPath());
	  UploadProfileTestNG.login(driver);
	  object=new UploadProfilePageObject(driver);
  }

  @AfterTest
  public void stop() 
  {
	  driver.quit();
  }

}
