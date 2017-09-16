package org.tektutor;

import org.junit.Test;
import static org.junit.Assert.*;

public class RPNCalculatorTest {


	@Test
	public void testSimpleAddition() {
		RPNCalculator rpnCalculator = new RPNCalculator();
		double actualResult = rpnCalculator.calculate( "10 15 +" );
		double expectedResult = 25.0;
		assertEquals ( expectedResult, actualResult, 0.001 );

		actualResult = rpnCalculator.calculate( "100 15 +" );
		expectedResult = 115.0;
		assertEquals ( expectedResult, actualResult, 0.001 );

	}

	@Test
	public void testSimpleSubtraction() {
		RPNCalculator rpnCalculator = new RPNCalculator();
		double actualResult = rpnCalculator.calculate( "100 15 -" );
		double expectedResult = 85.0;
		assertEquals ( expectedResult, actualResult, 0.001 );

		actualResult = rpnCalculator.calculate( "115 15 -" );
		expectedResult = 100.0;
		assertEquals ( expectedResult, actualResult, 0.001 );

	}

	@Test
	public void testSimpleMultiplication() {
		RPNCalculator rpnCalculator = new RPNCalculator();
		double actualResult = rpnCalculator.calculate( "100 10 *" );
		double expectedResult = 1000.0;
		assertEquals ( expectedResult, actualResult, 0.001 );

		actualResult = rpnCalculator.calculate( "15 10 *" );
		expectedResult = 150.0;
		assertEquals ( expectedResult, actualResult, 0.001 );

	}

	@Test
	public void testSimpleDivision() {
		RPNCalculator rpnCalculator = new RPNCalculator();
		double actualResult = rpnCalculator.calculate( "100 10 /" );
		double expectedResult = 10.0;
		assertEquals ( expectedResult, actualResult, 0.001 );

		actualResult = rpnCalculator.calculate( "150 10 /" );
		expectedResult = 15.0;
		assertEquals ( expectedResult, actualResult, 0.001 );

	}

	@Test
	public void testComplexRPNMathExpression() {
		RPNCalculator rpnCalculator = new RPNCalculator();
		double actualResult = rpnCalculator.calculate( "100 20 / 20 10 + *" );
		double expectedResult = 150.0;
		assertEquals ( expectedResult, actualResult, 0.001 );
	}
}
