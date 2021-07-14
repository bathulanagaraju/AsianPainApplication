package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignoutPageObject 
{ 
	public WebDriver driver;
	@CacheLookup
	@FindBy(xpath = " //div[@class=\"logged-in-dropdown\"]//child::ul//child::li[3]/a/span") WebElement linkSignout;
	@FindBy(xpath = "//div[@class='profile-holder']/a/span[@class='spriteIcon-Aprevamp profileIcon-active']") WebElement linkMyProfileIcon;
	public SignoutPageObject(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnSignout()
	{
		linkSignout.click();
	}
	public boolean signoutConformation()
	{
	boolean status=linkSignout.isDisplayed();
	return status;
	}
	public void clickOnMyProfileIcon() {
		linkMyProfileIcon.click();
	}

}
