package it.unical.tests;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import it.unical.businesslogic.Calculator;

public class CalculatorAdvancedTest {
	
	private static Calculator calculator;
	
	@BeforeClass
	public static void init() {
		calculator = new Calculator();
	}
	
	@Test
	public void advancedMultiplicationTest() {
		Assert.assertEquals(1000000, calculator.multiplication(1000, 1000));
	}
}
