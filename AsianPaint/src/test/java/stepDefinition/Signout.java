package stepDefinition;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import dataProvider.ConfigFileReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.MyprofilePageOject;
import pageFactory.SignoutPageObject;

public class Signout 
{
	WebDriver driver;
	ConfigFileReader configFileReader;
	SignoutPageObject object;
	@Given("user is on Login  Asianpaint Application")
	public void customer_is_on_Login_Asianpaint_Application() {
		configFileReader=new ConfigFileReader();
		driver=Edit.lonchApplication("chrom", configFileReader.getApplicationUrl(), configFileReader.getDriverPath());
		Edit.login(driver);
		object=new SignoutPageObject(driver);

	}
	@When("user click on  profile icon")
	public void customer_click_on_profile_icon() {
	   object.clickOnMyProfileIcon();
	}
	@When("user click on the signout")
	public void customer_click_on_the_signout() {
		object.clickOnSignout();
	}

	@Then("user should be  signout the application")
	public void customer_should_be_signout_the_application() {
		boolean actualStatus=false;
		boolean status=	object.signoutConformation();
		assertEquals(actualStatus, status);

	}


}
