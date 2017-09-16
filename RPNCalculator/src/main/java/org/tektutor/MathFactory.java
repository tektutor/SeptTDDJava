package org.tektutor;

import java.util.HashMap;

public class MathFactory {
	private static HashMap<String, String> mathOperatorToClassName; 

	static {
		mathOperatorToClassName = new HashMap<String,String>();

		mathOperatorToClassName.put ( "+", "org.tektutor.Addition" );
		mathOperatorToClassName.put ( "-", "org.tektutor.Subtraction" );
		mathOperatorToClassName.put ( "*", "org.tektutor.Multiplication" );
		mathOperatorToClassName.put ( "/", "org.tektutor.Division" );
	}

	public static IMathOperator getMathObject ( String operator ) {
		IMathOperator mathOperator = null;

		String className = mathOperatorToClassName.get ( operator );

		try {
			mathOperator = (IMathOperator )Class.forName ( className ).newInstance();
		}
		catch ( Exception e ) {
			e.printStackTrace();
		}

		return mathOperator;

	}

}
