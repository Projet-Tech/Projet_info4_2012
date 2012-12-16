package fr.ujm.tse.info4.pgammon.test.models;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import fr.ujm.tse.info4.pgammon.models.Case;
import fr.ujm.tse.info4.pgammon.models.CouleurCase;
import fr.ujm.tse.info4.pgammon.models.Tablier;



public class TestUnitTablier extends TestCase {

	public TestUnitTablier(String testTablier) {
		super(testTablier);
	}

	public static Test suiteTablier() {
		return new TestSuite(TestUnitTablier.class);
	}

	
	public void PremierTest() {
		
		assertTrue( true );
	}
	
	public void testDistanceDeuxCase() {
		
		Tablier t1 = new Tablier();
		t1.initialiserCase();
		assertEquals(t1.distanceDeuxCase(t1.getCaseBarre().get(0),t1.getCaseVictoire().get(0)), 25);
		assertEquals(t1.distanceDeuxCase(t1.getCaseBarre().get(1),t1.getCaseVictoire().get(1)), -25);
		assertEquals(t1.distanceDeuxCase(t1.getListeCase().get(0),t1.getCaseVictoire().get(0)), 24);
		assertEquals(t1.distanceDeuxCase(t1.getListeCase().get(23),t1.getCaseVictoire().get(1)), -24);
	}
	
	public void testPeutMarquerDame(){
		Tablier t1 = new Tablier();
		t1.initialiserCase();
		assertFalse(t1.peutMarquerDame(CouleurCase.BLANC));
		assertFalse(t1.peutMarquerDame(CouleurCase.NOIR));
		
		// deplacement de toute les dames blanches
		for (int i=0;i<2;i++)
			t1.deplacerDame(t1.getListeCase().get(0), t1.getListeCase().get(22));
		for (int i=0;i<5;i++)
			t1.deplacerDame(t1.getListeCase().get(11), t1.getListeCase().get(21));
		for (int i=0;i<3;i++)
			t1.deplacerDame(t1.getListeCase().get(16), t1.getListeCase().get(20));
		
		System.out.println("TABLIER : ");
		for(int i=0;i<t1.getListeCase().size();i++)
			System.out.println(t1.getListeCase().get(i).getPosition()
					+" : "+t1.getListeCase().get(i).getCouleurDame()
					+" _ "+t1.getListeCase().get(i).getNbDame());
		
		System.out.println("CASE BARRE : ");
		for(int i=0;i<t1.getCaseBarre().size();i++)
			System.out.println(t1.getCaseBarre().get(i).getPosition()
					+" : "+t1.getCaseBarre().get(i).getCouleurDame()
					+" _ "+t1.getCaseBarre().get(i).getNbDame());
		
		assertTrue(t1.peutMarquerDame(CouleurCase.BLANC));
		assertFalse(t1.peutMarquerDame(CouleurCase.NOIR));
		
		// deplacement de toute les dames noires
		t1.initialiserCase();
		for (int i=0;i<2;i++)
			t1.deplacerDame(t1.getListeCase().get(23), t1.getListeCase().get(1));
		for (int i=0;i<5;i++)
			t1.deplacerDame(t1.getListeCase().get(12), t1.getListeCase().get(4));
		for (int i=0;i<3;i++)
			t1.deplacerDame(t1.getListeCase().get(7), t1.getListeCase().get(2));
		
		
		assertTrue(t1.peutMarquerDame(CouleurCase.NOIR));
		assertFalse(t1.peutMarquerDame(CouleurCase.BLANC));

	}

}

