package testng;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import liberey.Utility;

public class Demo1 {
	String expectedTitle="Web Orders Login";
	String ectualTitle=null;
  @Test
  public void verifyLoginPage() 
  {
		String baseUrl = "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx";
         WebDriver driver=Utility.lonchApplication(1, baseUrl);
         ectualTitle=Utility.getPageTitle(driver);
         Assert.assertEquals(ectualTitle, expectedTitle);
         driver.quit();
  }
}
