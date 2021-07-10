package stepDefinition;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;

import dataProvider.ConfigFileReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.UploadProfilePageObject;
import utility.Base;

public class UploadProfile extends Base
{
	WebDriver driver;
	ConfigFileReader configFileReader;
	UploadProfilePageObject uploadProfilePageObject;
	@Given("customer should be on MyProfile page")
	public void customer_is_on_MyProfile_page() {
		configFileReader=new ConfigFileReader();
	   driver=UploadProfile.lonchApplication("chrom", configFileReader.getApplicationUrl(), configFileReader.getDriverPath());
	   UploadProfile.login(driver);
	   UploadProfile.myProfile(driver);
	   uploadProfilePageObject=new UploadProfilePageObject(driver);
	}
	@When("custome click on the Upload and send the image")
	public void custome_click_on_the_Upload_and_send_the_image() throws AWTException, InterruptedException {
		uploadProfilePageObject.clickOnUpload();
	}

	@Then("customer is  able to upload the profile picter")
	public void customer_is_able_to_upload_the_profile_picter() {
	    
	}
}
