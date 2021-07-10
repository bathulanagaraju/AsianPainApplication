package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyprofilePageOject
{
	public WebDriver driver;
	@CacheLookup
	@FindBy(xpath = "//span[@class=\"spriteIcon-Aprevamp profileIcon\"]") WebElement linkForLoginMyProfileIcon;
	@FindBy(xpath = "//div[@class='profile-holder']/a/span[@class='spriteIcon-Aprevamp profileIcon-active']") WebElement linkMyProfileIcon;
	@FindBy(xpath ="//ul/li/a[@href=\"https://www.asianpaints.com/my-profile.html\"]") WebElement linkMyprofile;
	@FindBy(xpath = "//button[@class='ctaText validate-login  modal__variant-login--submit']") WebElement cmdloginOtpSubmit;
	@FindBy(xpath = "//button[@class='ctaText modal__variant-login--submit']") WebElement cmdSubmit;
	@FindBy(xpath = "//input[@id=\'loginMobile\']") WebElement textMobilNumber;
	public MyprofilePageOject(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnMyProfileIcon() {
		linkMyProfileIcon.click();
	}
	public void clickOnMyProgile() {
		linkMyprofile.click();
	}
	public void login(String mobileNumber) throws InterruptedException
	{
	  linkForLoginMyProfileIcon.click();
	  textMobilNumber.sendKeys(mobileNumber);
	  cmdSubmit.click();
	  Thread.sleep(25000);
	  cmdloginOtpSubmit.click();
	  
	  
	}
	

}
