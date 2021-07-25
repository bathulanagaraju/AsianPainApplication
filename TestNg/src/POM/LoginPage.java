package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage
{
	public WebDriver driver;
	By textUaerName=By.id("ctl00_MainContent_username");
	By textPassword=By.id("ctl00_MainContent_password");
	By cmdLogin=By.id("ctl00_MainContent_login_button");
	public LoginPage(WebDriver driver)
	{
		super();
		this.driver = driver;
	}
	public void enterUserName(String uName)
	{
		driver.findElement(textUaerName).sendKeys(uName);
		
	}
	public  void  enterPassword(String passwd)
	{
		driver.findElement(textPassword).sendKeys(passwd);
		
	}
	public void clickLogin()
	{
		driver.findElement(cmdLogin).click();
		
	}
	public void loginPage(String uname ,String passwd)
	{
		this.enterUserName(uname);
		this.enterPassword(passwd);
		this.clickLogin();
		
	}
	public String getTitleName() 
	{
		return driver.getTitle();
		
	}

}
