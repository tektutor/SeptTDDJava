package org.tektutor;

import java.util.Stack;

public class RPNCalculator {

	private double firstInput, secondInput, result;
	private Stack<Double> numberStack;
	
	public RPNCalculator() {
		firstInput = secondInput = result = 0.0;
		numberStack = new Stack<Double>();
	}

	private void extractInputs() {
		secondInput = numberStack.pop();
		firstInput  = numberStack.pop();
	}


	private boolean isMathOperator( String token ) {
		String mathOperators = "+-*/";
		return mathOperators.contains(token);
	}

	public double calculate ( String rpnMathExpression ) {

		String rpnTokens[] = rpnMathExpression.split ( " " );

		IMathOperator mathOperator = null;

		for ( String token : rpnTokens ) {

			if ( isMathOperator ( token ) ) {
				extractInputs();
				mathOperator = MathFactory.getMathObject ( token ) ;
				result = mathOperator.calculate(firstInput, secondInput);
				numberStack.push ( result );
			}
			else
				numberStack.push ( Double.parseDouble ( token ) );
		}

		return numberStack.pop();

	}

}
