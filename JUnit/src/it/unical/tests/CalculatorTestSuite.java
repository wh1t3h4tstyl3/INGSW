package it.unical.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

// This class put together a Suite of Tests classes

@RunWith(Suite.class)
@SuiteClasses({CalculatorBasicTest.class, CalculatorAdvancedTest.class})

public class CalculatorTestSuite {
	
}
