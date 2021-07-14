package stepDefinition;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import dataProvider.ConfigFileReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.EditPersonalInformation;
import utility.Base;

public class Edit extends Base
{
	WebDriver driver;
	EditPersonalInformation editPersonalInformation;
	ConfigFileReader configFileReader;
	@Given("customer is on MyProfile page")
	public void customer_is_on_MyProfile_page() {
		configFileReader=new ConfigFileReader();
	      driver=Edit.lonchApplication("chrom", configFileReader.getApplicationUrl(), configFileReader.getDriverPath());
	      Edit.login(driver);
	      Edit.myProfile(driver);
	      editPersonalInformation=new EditPersonalInformation(driver);
	}

	@When("custome click on the Edit")
	public void custome_click_on_the_Edit() {
	    editPersonalInformation.clickOnEdit();
	   
	}

	@When("Remove the existing firstname and Enter the valid firstname  as {string}")
	public void remove_the_existing_firstname_and_Enter_the_valid_firstname_as(String firstName) {
	    editPersonalInformation.clickOnFirstName(firstName);
	   
	}

	@When("Remove the existing lastname and Enter the valid lastname as {string}")
	public void remove_the_existing_lastname_and_Enter_the_valid_lastname_as(String lastName) {
	    editPersonalInformation.clickOnLastName(lastName);
	}

	@When("Select the valid DatOfBirth")
	public void select_the_valid_DatOfBirth() {
	    editPersonalInformation.selectDob();
	}

	@When("Remove the existing Mobile number and Enter the valid MobileNumber as {string}")
	public void remove_the_existing_Mobile_number_and_Enter_the_valid_MobileNumber_as(String mobileNumber) {
	    editPersonalInformation.clickOnMobile(mobileNumber); 
	}

	@When("click on the Update")
	public void click_on_the_Update() {
		editPersonalInformation.clickOnUpdate();
	}

	@Then("close the browser")
	public void close_the_browser() {
		Base.stop(driver);
	}
	@When("Remove the existing Mobile Number and Enter the invalid MobileNumber as {string}")
	public void remove_the_existing_Mobile_Number_and_Enter_the_invalid_MobileNumber_as(String mobileNumber) {
	    editPersonalInformation.clickOnMobile(mobileNumber);
	}

	@Then("See the Error message")
	public void see_the_Error_message() {
	   String error= editPersonalInformation.errorMessage();
	   String actualError1="Please enter 10 digits mobile number.";
	   String actualError2="Please enter digits only.";
	   System.out.println("**********************************************");
	   System.out.println(error);
	   System.out.println("***********************************************");
	   if(error==actualError1)
	   {
	   assertEquals(actualError1, error);
	   }
	   else if(error==actualError2)
	   {
		  assertEquals(actualError2, error); 
	   }
	   driver.quit();
	}




}
