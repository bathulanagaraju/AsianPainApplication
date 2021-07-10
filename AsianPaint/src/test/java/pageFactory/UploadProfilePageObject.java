package pageFactory;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dataProvider.ConfigFileReader;

public class UploadProfilePageObject 
{
	public WebDriver driver;
	@CacheLookup
	@FindBy(xpath = "//label[text()='Upload']") WebElement linkUpload;
	public UploadProfilePageObject(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnUpload() throws AWTException, InterruptedException
	{
		linkUpload.click();
		ConfigFileReader configFileReader=new ConfigFileReader();
		 Thread.sleep(5000);
		 Robot rb = new Robot();
		StringSelection str = new StringSelection("C:\\Users\\ASUS\\OneDrive\\Desktop\\cap\\CAP\\flower.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);

		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);

		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

	}

}
