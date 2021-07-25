package stepDefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps 
{
	String baseUrl="http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx";

	WebDriver driver;
	
	Action pressDel ;
	Action pressTab;
	@Given("the user is on login screen")
	public void the_user_is_on_login_screen()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\softwere\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);

	}

	@When("user enters valid usernam")
	public void user_enters_valid_usernam() {
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
	}

	@When("user enters valid passwor")
	public void user_enters_valid_passwor() {
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");

	}

	@When("user clicks login button")
	public void user_clicks_login_button() {
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();

	}

	@Then("user should be on weborders page")
	public void user_should_be_on_weborders_page() {
		String pageTitle=driver.getTitle();
		System.out.println("pagetiltle is "+pageTitle);
	}

	@When("user clicks on Order link")
	public void user_clicks_on_Order_link() 
	{
		driver.findElement(By.linkText("Order")).click();
	}

	@When("user select the product type")
	public void user_select_the_product_type() 
	{


		Select prods = new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
		prods.selectByVisibleText("FamilyAlbum");
	}

	@When("user enter the quantity as {string}")
	public void user_enter_the_quantity_as(String quantity) {
		Actions actions = new Actions(driver);

		Action pressTab = actions.sendKeys(Keys.TAB).build();
		pressTab.perform();

		Action pressDel = actions.sendKeys(Keys.DELETE).build();
		pressDel.perform();

		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys(quantity);
		pressTab.perform();
	}

	@When("user enter the price as  {string}")
	public void user_enter_the_price_as(String price) {
		Actions actions = new Actions(driver);

		Action pressTab = actions.sendKeys(Keys.TAB).build();
		pressTab.perform();

		Action pressDel = actions.sendKeys(Keys.DELETE).build();
		pressDel.perform();
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtUnitPrice")).sendKeys(price);
		pressTab.perform();
	}

	@When("user enter the discount as {string}")
	public void user_enter_the_discount_as(String discount) {

		Actions actions = new Actions(driver);

		Action pressTab = actions.sendKeys(Keys.TAB).build();
		pressTab.perform();

		Action pressDel = actions.sendKeys(Keys.DELETE).build();
		pressDel.perform();
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtDiscount")).sendKeys(discount);
		pressTab.perform();
	}

	@When("user  calculate total amount")
	public void user_calculate_total_amount() {
		driver.findElement(By.xpath("//input[@value='Calculate']")).click();
	}

	@When("user enter castomer name {string}")
	public void user_enter_castomer_name(String name) {
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys(name);
	}

	@When("user enter street name")
	public void user_enter_street_name_street() {
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys("postofice");
	}

	@When("user enter city name {string}")
	public void user_enter_city_name(String city) {
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys(city);
	}

	@When("user enter zip code {string}")
	public void user_enter_zip_code(String zip) {
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys(zip);
	}

	@When("user select card type")
	public void user_select_card_type() {
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();
		
	}

	@When("user enter card no {string}")
	public void user_enter_card_no(String cardNo) {
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();
		
		
	}
	

	@When("user enter expiry date {string}")
	public void user_enter_expiry_date(String string) {
	}

	@When("user click on process")
	public void user_click_on_process() {
	}

	@When("user click on view all order")
	public void user_click_on_view_all_order() {
	}

	@Then("user can see his data")
	public void user_can_see_his_data() {
	}

	@When("user clicks logout link")
	public void user_clicks_logout_link()
	{
		driver.findElement(By.linkText("Logout")).click();	
	}

	@Then("user should be logged out")
	public void user_should_be_logged_out() throws InterruptedException
	{
		String page=driver.getTitle();
		Thread.sleep(5000);
		
	}

	@Then("user closes browser")
	public void user_closes_browser() {
		driver.quit();
	}

	@When("user enters the quantity ,priceas and discount")
	public void user_enters_the_quantity_priceas_and_discount(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		List<Map<String, String>> myData=dataTable.asMaps();
		
		for (Map<String, String> map : myData) 
		{
			String quantity=map.get("quantity");
			String price=map.get("price");
			String discount=map.get("discount");
			Select prods = new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
			prods.selectByVisibleText("FamilyAlbum");
			Actions actions = new Actions(driver);
			
		    pressTab = actions.sendKeys(Keys.TAB).build();
			pressTab.perform();

			pressDel= actions.sendKeys(Keys.DELETE).build();
			pressDel.perform();
			Thread.sleep(6000);
			driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys(quantity);
			pressTab.perform();
			Thread.sleep(6000);
			pressTab = actions.sendKeys(Keys.TAB).build();
			pressTab.perform();

			 pressDel = actions.sendKeys(Keys.DELETE).build();
			pressDel.perform();
			Thread.sleep(6000);
			driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtUnitPrice")).sendKeys(price);
			pressTab.perform();
			Thread.sleep(6000);
			 pressTab = actions.sendKeys(Keys.TAB).build();
			pressTab.perform();

			 pressDel = actions.sendKeys(Keys.DELETE).build();
			pressDel.perform();
			Thread.sleep(6000);
			driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtDiscount")).sendKeys(discount);
			pressTab.perform();
			Thread.sleep(6000);
			driver.findElement(By.xpath("//input[@value='Calculate']")).click();
			Thread.sleep(6000);
			
			
		}
	}


}
