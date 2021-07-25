package POM;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AllOrders 
{
	public WebDriver driver;
	By linkCheckAll =By.linkText("Check All");
	By linkUncheckAll=By.linkText("Uncheck All");
	By cmdDelete=By.id("ctl00_MainContent_btnDelete");
	By linkViewallorders=By.linkText("View all orders");
	By linkViewallproducts=By.linkText("View all products");
	By linkOrder=By.linkText("Order");
	By cmdLogout=By.linkText("Logout");
	public AllOrders(WebDriver driver) {
		super();
		this.driver = driver;
	}
	public void clickCheckAll() 
	{
		driver.findElement(linkCheckAll).click();
	}
	public void clickUnCheckall()
	{
		driver.findElement(linkUncheckAll).click();
	}
	public void clickDelete()
	{
		driver.findElement(cmdDelete).click();
	}
	public void clickViewAllOrders()
	{
		driver.findElement(linkViewallorders).click();
	}
	public void clickViewAllProducts()
	{
		driver.findElement(linkViewallproducts).click();
	}
	public void clickOrder() 
	{
	    driver.findElement(linkOrder).click();	
	}
	public void clickLogout() throws InterruptedException
	{
	driver.findElement(cmdLogout).click();
	Thread.sleep(5000);
	driver.close();
	}
	public String getTitleName()
	{
		return driver.getTitle();
	}

}
