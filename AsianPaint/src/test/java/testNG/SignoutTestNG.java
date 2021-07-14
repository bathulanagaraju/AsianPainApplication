package testNG;

import org.testng.annotations.Test;

import dataProvider.ConfigFileReader;
import pageFactory.MyprofilePageOject;
import pageFactory.SignoutPageObject;
import stepDefinition.Edit;

import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class SignoutTestNG {
	WebDriver driver;
	ConfigFileReader configFileReader;
	 SignoutPageObject object;
	 MyprofilePageOject myprofilePageOject;
	@Test
	public void signout() 
	{
		myprofilePageOject.clickOnMyProfileIcon();
		object.clickOnSignout();
		boolean actualStatus=false;
		boolean status=	object.signoutConformation();
		Assert.assertEquals(actualStatus, status);
	}
	@BeforeMethod
	public void launchApplication() 
	{
		configFileReader=new ConfigFileReader();
		driver=Edit.lonchApplication("chrom", configFileReader.getApplicationUrl(), configFileReader.getDriverPath());
		Edit.login(driver);
		myprofilePageOject=new MyprofilePageOject(driver);
		object=new SignoutPageObject(driver);
	}

	@AfterMethod
	public void stop()
	{
		driver.quit();
	}

}
