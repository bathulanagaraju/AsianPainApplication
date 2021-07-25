package PomPageFactery;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	public WebDriver driver;
	@FindBy(how =How.ID,using = "ctl00_MainContent_username" )  WebElement textUserName;
	@FindBy(how =How.ID,using = "ctl00_MainContent_password" )  WebElement textPassword;
	@FindBy(how =How.ID,using = "ctl00_MainContent_login_button" )  WebElement cmdLogin;
	//@CacheLookup
	//@FindBy(id = "ctl00_MainContent_username") WebElement userName;
	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void enterUserName(String uName)
	{
		textUserName.sendKeys("Tester");
		
	}
	public  void  enterPassword(String passwd)
	{
           textPassword.sendKeys("test");
		
	}
	public void clickLogin()
	{
		cmdLogin.click();
		
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
