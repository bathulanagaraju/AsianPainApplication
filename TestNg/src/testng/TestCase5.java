package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCase5 {
	String baseUrl = "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx";
	String expectedTitle = "Web Orders";
	String actualTitle = null;
	WebDriver driver;



	@Test(dataProvider = "credentials")
	public void verifyHomePage(String username,String password) throws InterruptedException {

		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(username);
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys(password);
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
		Thread.sleep(1500);

		actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);

		driver.findElement(By.linkText("Logout")).click();
	}



	@DataProvider(name = "credentials")
	public Object[][] getLoginData() {
		return new Object[][] {
			{ "Tester", "test" },
			{ "Tester123", "test@123" },
		};
	}



	@BeforeTest
	public void initialization() {

		System.setProperty("webdriver.chrome.driver", "E:\\softwere\\chromedriver.exe");        
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);



	}



	@AfterTest
	public void stop() {

		driver.quit();
	}
}
