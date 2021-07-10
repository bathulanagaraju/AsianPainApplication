package testNG;

import org.testng.annotations.Test;

import dataProvider.ConfigFileReader;
import pageFactory.MyprofilePageOject;
import utility.Base;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class MyProfileTestNG extends Base
{
	WebDriver driver;
	ConfigFileReader configFileReader;
	MyprofilePageOject myprofilePageOject;
	@BeforeTest
	public void launchApplication() 
	{
		configFileReader=new ConfigFileReader();
		driver=MyProfileTestNG.lonchApplication("chrom", configFileReader.getApplicationUrl(), configFileReader.getDriverPath());
		MyProfileTestNG.login(driver);
		myprofilePageOject=new MyprofilePageOject(driver);
	}

	@Test
	public void f()
	{
		String actualTitle="My Profile";
		myprofilePageOject.clickOnMyProfileIcon();
		myprofilePageOject.clickOnMyProgile();
		String pageTitle=MyProfileTestNG.getPageTitle(driver);
		Assert.assertEquals(actualTitle, pageTitle);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
