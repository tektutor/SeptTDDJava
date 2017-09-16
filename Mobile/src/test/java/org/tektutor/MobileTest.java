package org.tektutor;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
/*
//This is how Mockito framework generates a dummy mocked object
class MockedCamera implements ICamera {

	public boolean ON() {
		return true; // stubbing - hard coding the return value
	}

	public boolean OFF() {
		return false; // If stubbing isn't done by default mocked
			      // method that returns boolean will return false
	}
}
*/


public class MobileTest {

	@Test
	public void testPowerOnWhenCameraFunctionsNormally() {
		//Mocking
		ICamera mockedCamera = mock ( ICamera.class );

		//Stubbing - hardcoding response of dependent method
		when ( mockedCamera.ON() ).thenReturn ( true );
		
		Mobile mobile = new Mobile( mockedCamera ); //Construct DI

		assertTrue( mobile.powerOn() );
		verify ( mockedCamera, times(1) ).ON(); 
		
	}

}
