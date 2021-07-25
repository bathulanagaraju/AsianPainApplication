package PomTestcase;

import org.openqa.selenium.WebDriver;

import POM.AllOrders;
import POM.LoginPage;
import liberey.Utility;

public class TestCase 
{
	public static void main(String[] args) 
	{
		String baseUrl="http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx";
		String title="Web Orders";
		WebDriver driver=Utility.lonchApplication(1, baseUrl);
		LoginPage loginPage=new LoginPage(driver);
		AllOrders  allOrders=new AllOrders(driver);
		loginPage.loginPage("Tester", "test");
		allOrders.clickOrder();
		driver.navigate().back();
		driver.navigate().refresh();
		String pageTitle=allOrders.getTitleName();
		if (pageTitle.equals(title)) 
		{
			try {
				allOrders.clickLogout();
			} catch (InterruptedException e) 
			{

				e.printStackTrace();
			}

		}
		else 
		{
			driver.quit();
		}

	}

}
