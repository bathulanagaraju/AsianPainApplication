package stepDefinition;

import io.cucumber.java.en.Given;

public class Tage 
{
	@Given("login is successful")
	public void login_is_successful() {
		System.out.println("Login successful.");
	}



	@Given("login has failed")
	public void login_has_failed() {
		System.out.println("Login failed.");
	}



	@Given("user registers on portal")
	public void user_registers_on_portal() {
		System.out.println("New user registers.");
	}



	@Given("user searches a product")
	public void user_searches_a_product() {
		System.out.println("User performs product search.");
	}



	@Given("user adds a product to the cart")
	public void user_adds_a_product_to_the_cart() {
		System.out.println("User adds a product to the cart.");
	}



	@Given("user adds more products to the cart")
	public void user_adds_more_products_to_the_cart() {
		System.out.println("User adds more product to the cart.");
	}



	@Given("user removes a product from the cart")
	public void user_removes_a_product_from_the_cart() {
		System.out.println("User removes a product to the cart.");
	}



	@Given("user increases product quantity in the cart")
	public void user_increases_product_quantity_in_the_cart() {
		System.out.println("User increases the product quantity.");
	}



	@Given("user decreases product quantity in the cart")
	public void user_decreases_product_quantity_in_the_cart() {
		System.out.println("User decreases the product quantity.");
	}



	@Given("user removes all items from cart")
	public void user_removes_all_items_from_cart() {
		System.out.println("User removes all items from the cart.");
	}



	@Given("user makes cash payment")
	public void user_makes_cash_payment() {
		System.out.println("User makes cash payment.");
	}



	@Given("user applies for gift voucher")
	public void user_applies_for_gift_voucher() {
		System.out.println("User applies for a gift voucher.");
	}



	@Given("user selects home delivery option")
	public void user_selects_home_delivery_option() {
		System.out.println("User opts for home delivery.");
	}



	@Given("user selects payment type as {string}")
	public void user_selects_payment_type_as(String paymentTyp) {
		System.out.println("User selects payment type as: " + paymentTyp);
	}

}
