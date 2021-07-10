package stepDefinition;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import dataProvider.ConfigFileReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.MyprofilePageOject;
import utility.Base;

public class Myprofile extends Base
{
	WebDriver driver;
	ConfigFileReader configFileReader;
	MyprofilePageOject myprofilePageOject;
	@Given("customer should be on Home page")
	public void customer_should_be_on_Home_page() {
		configFileReader=new ConfigFileReader();
	  driver =Myprofile.lonchApplication("chrom", configFileReader.getApplicationUrl(), configFileReader.getDriverPath());
	    Myprofile.login(driver);
	  myprofilePageOject=new MyprofilePageOject(driver);
	}

	@When("customer click on the profile icon")
	public void customer_click_on_the_profile_icon() {
	   myprofilePageOject.clickOnMyProfileIcon();
	}

	@When("click on My profile")
	public void click_on_My_profile() {
	   myprofilePageOject.clickOnMyProgile();
	}

	@Then("customer  should be on My Profile page")
	public void customer_should_be_on_My_Profile_page() {
	   String actualTitle="My Profile";
	   String pageTitle=Myprofile.getPageTitle(driver);
	   assertEquals(actualTitle, pageTitle);
	}
}
