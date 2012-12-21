package fr.ujm.tse.info4.pgammon.test.models;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestUnitPartie extends TestCase {

	public TestUnitPartie(String testPartie) {
		super(testPartie);
	}

	public static Test suitePartie() {
		return new TestSuite(TestUnitPartie.class);
	}

	
	public void PremierTest() {
		
		assertTrue( true );
	}
	

}
