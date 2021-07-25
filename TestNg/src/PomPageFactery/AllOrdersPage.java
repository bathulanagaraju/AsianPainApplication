package PomPageFactery;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllOrdersPage
{   
	public WebDriver driver;
	@CacheLookup
	@FindBy(linkText = "Check All") WebElement linkCheckAll;
	//@FindBy(linkText = "Check All") WebElement linkCheckAll;
	@FindBy(linkText = "Uncheck All") WebElement linkUnCheckAll;
	@FindBy(id = " ctl00_MainContent_btnDelete") WebElement cmdDelete;
	@FindBy(linkText = "View all orders") WebElement linkViewAllOrders;
	@FindBy(linkText = "View all products") WebElement linkViewAllProducts;
	@FindBy(linkText = "Order") WebElement linkOrder;
	@FindBy(linkText = "Logout") WebElement linkLofout;
	public AllOrdersPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickCheckAll() 
	{
		linkCheckAll.click();
	}
	public void clickUnCheckall()
	{
		linkUnCheckAll.click();
	}
	public void clickDelete()
	{
		cmdDelete.click();
	}
	public void clickViewAllOrders()
	{
		linkViewAllOrders.click();
	}
	public void clickViewAllProducts()
	{
		linkViewAllProducts.click();
	}
	public void clickOrder() 
	{
		linkOrder.click();
	}
	public void clickLogout() throws InterruptedException
	{
		linkLofout.click();
	Thread.sleep(5000);
	driver.close();
	}
	public String getTitleName()
	{
		return driver.getTitle();
	}
	public void quite()
	{
		driver.quit();
	}

	
}
