package junitTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import JavaCode.Calculator;

public class CalculatorTest {
	Calculator c;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		Calculator c=new Calculator();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception 
	{
		
	}

	@Before
	public void setUp() throws Exception 
	{
               System.out.println("before ");
	}

	@After
	public void tearDown() throws Exception 
	{
		System.out.println("after ");
	}

	@Test
	public void testAdd() 
	{
		int ans=c.add(3,5);
		System.out.println("add "+ans);

	}
	@Test
	public void testSub()
	{
		int  ans=c.sub(3,5);
		System.out.println("sub "+ans);
		
	}
	@Test
	public void testMul()
	{
		int  ans=c.mul(3,5);
		System.out.println("mul "+ans);

	}
	@Test
	public void testDiv() 
	{
		double ans=c.div(10,2);
		System.out.println("div "+ans);
	}

}
