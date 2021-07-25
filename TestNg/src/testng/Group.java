package testng;

import org.testng.annotations.Test;

public class Group {
	@Test(groups = {"Sanity","Regression"})
	  public void testCase1() {
	     
	      System.out.println("Test Case 1: Sanity & Regression Test");
	  }
	 
	  @Test(groups = {"Smoke"})
	  public void testCase2() {
	     
	      System.out.println("Test Case 2: Smoke Test");
	  }
	 
	  @Test(groups = {"Regression"})
	  public void testCase3() {
	     
	      System.out.println("Test Case 3: Regression Test");
	  }
	 
	  @Test(groups = {"Smoke"})
	  public void testCase4() {
	     
	      System.out.println("Test Case 4: Smoke Test");
	  }
	 
	  @Test(groups = {"Regression"})
	  public void testCase5() {
	     
	      System.out.println("Test Case 5: Regression Test");
	  }
	 
	  @Test(groups = {"Sanity"})
	  public void testCase6() {
	     
	      System.out.println("Test Case 6: Sanity Test");
	  }
	 
	  @Test(groups = {"Regression"})
	  public void testCase7() {
	     
	      System.out.println("Test Case 7: Regression Test");
	  }
	 
	  @Test(groups = {"Sanity"})
	  public void testCase8() {
	     
	      System.out.println("Test Case 8: Sanity Test");
	  }
	 
	  @Test(groups = {"Regression"})
	  public void testCase9() {
	     
	      System.out.println("Test Case 9: Regression Test");
	  }
}
