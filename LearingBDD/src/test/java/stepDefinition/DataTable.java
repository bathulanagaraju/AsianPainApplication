package stepDefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DataTable 
{
	String baseUrl="http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx";

	WebDriver driver;
	@Given("the user navigates to login screen")
	public void the_user_navigates_to_login_screen() {
		System.out.println("the user navigates to login screen");
		
	  
	}

	@When("user enters credentials")
	public void user_enters_credentials(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		
		List<List<String>> myData=dataTable.asLists();
		for(List<String> e:myData) {
			System.out.println(myData.get(0).get(0));
		}
		
		/*List<Map<String, String>> myData=dataTable.asMaps();
		System.out.println(myData);//return map 
		
		System.out.println("userName "+myData.get(2).get("userName"));
		System.out.println("password "+myData.get(2).get("password"));
		
		for (Map<String, String> map : myData)
		{
			System.out.println("username is  "+map.get("userName"));
			System.out.println("Password is  "+map.get("password"));
		}*/
	    }

	@When("user hits login button")
	public void user_hits_login_button() {


	   }

	@Then("user sees his account")
	public void user_sees_his_account() {
		
	   }



}
