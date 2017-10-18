package it.unical.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import it.unical.businesslogic.Calculator;

public class CalculatorBasicTest {
	
	private static Calculator calculator;
	
	@BeforeClass
	public static void init() {
		// The BeforeClass prepare all for tests and is the first method launched
		System.out.println("BeforeClass");
		calculator = new Calculator();
	}
	
	@Before
	public void beforeTests() {
		// The Before is launched before every single test method for setting up stuff
		System.out.println("Before");
	}
	
	@Test(timeout = 1000)
	public void multiplicationWorks() {
		// Max time execution is setted to 1000 ms
		System.out.println(calculator + " multiplicationWorks");
		Assert.assertEquals(10, calculator.multiplication(2, 5));
	}
	
	@Test
	public void additionWorks() {
		System.out.println(calculator + " additionWorks");
		Assert.assertEquals(50, calculator.addition(30, 20));
	}
	
	@Test(expected = ArithmeticException.class)
	// This test expects indicated exception to be raised
	public void divisionWorks() {
		calculator.division(10, 0);
	}
}
