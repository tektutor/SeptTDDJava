package org.tektutor;

import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class SavingsAccountTest {
	private SavingsAccount realAccount = null;
 	private SavingsAccount accountSpy = null;

	@BeforeClass
	public static void oneTimeInit() {
		System.out.println ("One time initialization ...");
	}

	@Before
	public void initializeTestCase() {
		realAccount = new SavingsAccount();
		//Partial mocking
		accountSpy = spy ( realAccount );
	}

	@After
	public void cleanupTestCase() {
		realAccount = null;
		accountSpy = null;
	}

	@AfterClass
	public static void oneTimeCleanup() {
		System.out.println ("One time cleanup...");
	}


	@Test
	public void testDepositWhenBalanceIsFifteenThousand() 
		throws DBServerIsDownException {
		

		//Stubbing - hardcoding the return value of dependent method
		doReturn( 15000.00 ).doReturn(2000.00).when ( accountSpy ).getBalance();

		double actualBalance = accountSpy.deposit ( 10000.00 );
		double expectedBalance = 25000.00;

		assertEquals ( expectedBalance, actualBalance, 0.0001 );
	}

	@Test( expected=DBServerIsDownException.class )
	public void testDepositWhenDBServerIsDown() 
		throws DBServerIsDownException {
		
		//Partial mocking
		SavingsAccount accountSpy = spy ( realAccount );

		//Stubbing - hardcoding the return value of dependent method
		doThrow( new DBServerIsDownException() )
			.when ( accountSpy ).getBalance();

		accountSpy.deposit ( anyDouble() );
	}


}
