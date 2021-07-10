package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EditPersonalInformation
{
  public WebDriver driver;
  @CacheLookup
  @FindBy(id = "editProfile") WebElement linkEdit;
	@FindBy(name = "profile_fname") WebElement textFirstName;
	@FindBy(name = "profile_lname") WebElement textLastName;
	@FindBy(xpath  = "//ul[@class='input-list-grp col-md-6']/li[3]/input[@type='date']") WebElement textDob;
	@FindBy(xpath = "//select[@class='ui-datepicker-year']") WebElement selYear;
	@FindBy(xpath = "//select[@class='ui-datepicker-month']") WebElement selMonth;
	@FindBy(xpath = "//table[@class='ui-datepicker-calendar']/tbody/tr[2]/td[4]/a") WebElement selDay;
	@FindBy(name = "profile_mobile") WebElement textMobileNumber;
	@FindBy(xpath = "//a[@class='global-button-white btn-style2 ap_user_profile_btn']") WebElement linkupdate;
	@FindBy(xpath = "//div[@id='profile_mobile-error']") WebElement errorMessage;
	public EditPersonalInformation(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnEdit()
	{
		linkEdit.click();
	}
	public void clickOnFirstName(String firstNmae)
	{   textFirstName.clear();
		textFirstName.sendKeys(firstNmae);
	}
	public void clickOnLastName(String lastName)
	{   textLastName.clear();
		textLastName.sendKeys(lastName);
	}
	public void selectDob()
	{
		textDob.click();
		Select year=new Select(selYear);
		year.selectByVisibleText("2011");
		year.selectByVisibleText("2001");
		year.selectByVisibleText("1998");
		Select month=new Select(selMonth);
		month.selectByVisibleText("Aug");
		selDay.click();
		
	}
	public void clickOnMobile(String mobileNumber)
	{   textMobileNumber.clear();
		textMobileNumber.sendKeys(mobileNumber);
	}
	public String errorMessage()
	{
	String error=errorMessage.getText();
	return error;
	}
	public void clickOnUpdate()
	{
		linkupdate.click();
	}
	
	
}
