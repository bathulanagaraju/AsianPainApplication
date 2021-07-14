package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import dataProvider.ConfigFileReader;
import pageFactory.MyprofilePageOject;

public class Base 
{
	static ConfigFileReader configFileReader;
	public static WebDriver lonchApplication(String browser, String baseUrl,String  driverPath)
	{

		WebDriver driver;
		 configFileReader=new ConfigFileReader();
		
		switch(browser) {
		case "chrom":
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver =new ChromeDriver();
			break;

		default:
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver =new ChromeDriver();
			break;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(35, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		driver.get(baseUrl);
		return driver;
	}
     
	public static void login(WebDriver driver) 
	{
		MyprofilePageOject myprofilePageOject=new MyprofilePageOject(driver);
		try {
			myprofilePageOject.login(configFileReader.getMobileNumber());
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	public static void myProfile(WebDriver driver)
	{
	   MyprofilePageOject myprofilePageOject=new MyprofilePageOject(driver);
	   myprofilePageOject.clickOnMyProfileIcon();
	   myprofilePageOject.clickOnMyProgile();
	}
	public static String getPageTitle(WebDriver driver)
	{
		return driver.getTitle();
	}
	public static void stop(WebDriver driver)
	{
		driver.quit();
	}
	
}
