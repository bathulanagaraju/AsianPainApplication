package PomPageFactery;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import POM.AllOrders;
import liberey.Utility;

public class TestCase {
	WebDriver driver;
	String baseUrl="http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx";
	String activelTitle="Web Orders";
	LoginPage loginPage;
	AllOrdersPage allOrdersPage;
	
	
  @Test
  public void verifyHompePage() throws InterruptedException
  {
	
	 allOrdersPage=new AllOrdersPage(driver);
	 String title= allOrdersPage.getTitleName();
	 System.out.println(title);
	 if(title.equals(activelTitle))
	 {
		 allOrdersPage.clickOrder();
		 Thread.sleep(5000);
		 allOrdersPage.clickLogout();
		 Thread.sleep(5000);
		
	 }
	 else
	 {
		 allOrdersPage.quite();
	 }
	  
	  
  }
  @BeforeTest
  public void launchPage()
  {
	  driver=Utility.lonchApplication(1, baseUrl);
	  loginPage =new LoginPage(driver);
	 // PageFactory.initElements(driver, loginPage);
	  loginPage.loginPage("Tester", "test");
	  
	  
  }
  @AfterTest
  public void stop()
  {
	 driver.quit(); 
  }
}
