package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Sample 
{
	String baseUrl="http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx";

	WebDriver driver;
	@Before
	public void befoore() {
		System.out.println("before senario");
		System.setProperty("webdriver.chrome.driver", "E:\\softwere\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();

	}
	@After
	public void after() {
		System.out.println("after senario ");
	}
	@Given("this is step one")
	public void this_is_step_one() {
	   System.out.println("step1");
	}

	@When("user performs step two")
	public void user_performs_step_two() {
		 System.out.println("step2");
	}

	@Then("final step will be done")
	public void final_step_will_be_done() {
		 System.out.println("step3");
	}
	@Given("user is on weborders page")
	public void user_is_on_weborders_page() {
		String pageTitle=driver.getTitle();
		System.out.println("pagetiltle is "+pageTitle);
	
	}

	@When("user clicks on View all Products link")
	public void user_clicks_on_View_all_Products_link() {
		driver.findElement(By.linkText("View all products")).click();
	   
	}

	@When("user counts number of products available")
	public void user_counts_number_of_products_available() {
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='ProductsTable']/tbody/tr"));
		int count = rows.size()-1;
		System.out.println("ROW COUNT : "+count);
	}

	@Then("user displays no of products")
	public void user_displays_no_of_products() {
	WebElement	 products = driver.findElement(By.xpath("//table[@class='ProductsTable']/tbody"));
	
		List<WebElement>  allColums= products.findElements(By.xpath("tr/td[1]"));
		
		for (WebElement columeName : allColums) {
			System.out.println(columeName.getText());
		}
	
	
	   
	}

}
