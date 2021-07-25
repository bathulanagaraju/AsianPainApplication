package testng;

import org.testng.annotations.Test;

import liberey.Utility;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TestCase1 {
	String expectedTitle="Web Orders Login";
	String actualTitle=null;
	WebDriver driver;
  @Test
  public void verifyLoginPage() 
  {
	  actualTitle=Utility.getPageTitle(driver);
      Assert.assertEquals(actualTitle, expectedTitle);
  }
  @BeforeTest
  public void intilization()
  {
	  String baseUrl = "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx";
       driver=Utility.lonchApplication(1, baseUrl);
  }

  @AfterTest
  public void stop() 
  {
	  driver.quit();
	  
  }

}
