package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import liberey.Utility;

public class TestCae2 {
	String expectedTitle="Web Orders Login";
	String actualTitle=null;
	String actualTitle1=null;
	WebDriver driver;
	 String baseUrl = "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx";
	
  @Test(priority = 1)
  public void verifyLoginPage()
  {
	  actualTitle=Utility.getPageTitle(driver);
      Assert.assertEquals(actualTitle, expectedTitle);
      driver.findElement(By.id(actualTitle)).sendKeys("Test");
      driver.findElement(By.id(actualTitle)).sendKeys("test");
      driver.findElement(By.id(actualTitle)).click();
  }
  @Test(priority = 2)
  public void verifyHomePage()
  {
	  
  }
  @BeforeTest
  public void intilization()
  {
	  driver=Utility.lonchApplication(1, baseUrl);  
	  
  }
  @AfterTest
  public void stop()
  {
	  driver.findElement(By.linkText("Logout")).click();
	  driver.quit();
  }
}
