package org.tektutor;

public class Mobile {

	private ICamera camera = null;

	public Mobile ( ICamera camera ) {
		this.camera = camera;
	}

	public boolean powerOn() {

		System.out.println ( "Real mobile powerOn ..." );

		if ( camera.ON() ) {
			System.out.println ("Power ON positive logic ...");
			return true;

		}

		System.out.println ("Power ON exceptional logic ...");
		return false;
	}

}
