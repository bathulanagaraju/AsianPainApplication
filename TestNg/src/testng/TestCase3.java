package testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase3 {
	@Test
	  public void tc1() {
	      
	      System.out.println("I am test case 1.");
	  }
	  
	  @Test
	  public void tc2() {
	      
	      System.out.println("I am test case 2.");
	      
	  }
	  
	  @BeforeMethod
	  public void beforeMethod() {
	      
	      System.out.println("I beforeMethod method.");
	  }

	 

	  @AfterMethod
	  public void afterMethod() {
	      
	      System.out.println("I afterMethod method.");
	  }

	 

	  @BeforeClass
	  public void beforeClass() {
	      
	      System.out.println("I beforeClass method.");
	  }

	 

	  @AfterClass
	  public void afterClass() {
	      
	      System.out.println("I afterClass method.");
	  }

	 

	  @BeforeTest
	  public void beforeTest() {
	      
	      System.out.println("I beforeTest method.");
	  }

	 

	  @AfterTest
	  public void afterTest() {
	      
	      System.out.println("I afterTest method.");
	  }

	 

	  @BeforeSuite
	  public void beforeSuite() {
	      
	      System.out.println("I beforeSuite method.");
	  }

	 

	  @AfterSuite
	  public void afterSuite() {
	      
	      System.out.println("I afterSuite method.");
	  }
}
