package fr.ujm.tse.info4.pgammon.test.models;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import fr.ujm.tse.info4.pgammon.models.Case;
import fr.ujm.tse.info4.pgammon.models.CouleurCase;
import fr.ujm.tse.info4.pgammon.models.Coup;
import fr.ujm.tse.info4.pgammon.models.DeSixFaces;
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
	
	public void testgetCaseADistance(){
		Tablier t1 = new Tablier();
		DeSixFaces deBlanc = new DeSixFaces(CouleurCase.BLANC,6);
		DeSixFaces deNoir = new DeSixFaces(CouleurCase.NOIR,6);
		assertEquals(t1.getCaseADistance(t1.getListeCase().get(18), deBlanc),t1.getCaseVictoire().get(0));
		assertEquals(t1.getCaseADistance(t1.getListeCase().get(16), deBlanc),t1.getListeCase().get(22));
		assertEquals(t1.getCaseADistance(t1.getListeCase().get(5), deNoir),t1.getCaseVictoire().get(1));
		assertEquals(t1.getCaseADistance(t1.getListeCase().get(7), deNoir),t1.getListeCase().get(1));
		assertEquals(t1.getCaseADistance(t1.getCaseBarre(CouleurCase.BLANC), deBlanc),t1.getListeCase().get(5));
	}
	
	public void testgetCoupsPossiblesListe(){
		Tablier t1 = new Tablier();
		
		List<DeSixFaces> listeDeuxDes = new ArrayList<DeSixFaces>();
		listeDeuxDes.add(new DeSixFaces(CouleurCase.BLANC,1));
		listeDeuxDes.add(new DeSixFaces(CouleurCase.BLANC,2));

		List<Coup> tmpListeDeuxDes = t1.getCoupsPossibles(listeDeuxDes,CouleurCase.BLANC);
		//2+1=5 deplacer 5
		assertEquals(tmpListeDeuxDes.get(0).getCaseArriver(),t1.getListeCase().get(3));
		assertEquals(tmpListeDeuxDes.get(1).getCaseArriver(),t1.getListeCase().get(14));
		assertEquals(tmpListeDeuxDes.get(2).getCaseArriver(),t1.getListeCase().get(19));
		assertEquals(tmpListeDeuxDes.get(3).getCaseArriver(),t1.getListeCase().get(21));
		//deplacer 1
		assertEquals(tmpListeDeuxDes.get(4).getCaseArriver(),t1.getListeCase().get(1));
		assertFalse(tmpListeDeuxDes.get(5).getCaseArriver().getPosition()==t1.getListeCase().get(21).getPosition());
		assertEquals(tmpListeDeuxDes.get(5).getCaseArriver(),t1.getListeCase().get(17));
		assertEquals(tmpListeDeuxDes.get(6).getCaseArriver(),t1.getListeCase().get(19));
		//deplace 2
		assertEquals(tmpListeDeuxDes.get(7).getCaseArriver(),t1.getListeCase().get(2));
		assertEquals(tmpListeDeuxDes.get(8).getCaseArriver(),t1.getListeCase().get(13));
		assertEquals(tmpListeDeuxDes.get(9).getCaseArriver(),t1.getListeCase().get(18));
		assertEquals(tmpListeDeuxDes.get(10).getCaseArriver(),t1.getListeCase().get(20));
		
		//Pour tester les situations special,on refait tablier 
		ArrayList<Case> listeCase = new ArrayList<Case>();
		for (int i=1;i<=24;i++)
		{
			if(i==19) listeCase.add(new Case(CouleurCase.BLANC, 2, i));
			else if(i==20) listeCase.add(new Case(CouleurCase.BLANC, 5, i));
			else if(i==21) listeCase.add(new Case(CouleurCase.BLANC, 3, i));
			else if(i==22) listeCase.add(new Case(CouleurCase.BLANC, 3, i));
			else if(i==23) listeCase.add(new Case(CouleurCase.BLANC, 2, i));
			
			else if(i==1) listeCase.add(new Case(CouleurCase.NOIR, 5, i));
			else if(i==2) listeCase.add(new Case(CouleurCase.NOIR, 3, i));
		    else if(i==3) listeCase.add(new Case(CouleurCase.NOIR, 5, i));
			else if(i==4) listeCase.add(new Case(CouleurCase.NOIR, 2, i));
			
			else listeCase.add(new Case(CouleurCase.VIDE, 0, i));	
		}		
		
		Tablier t2 = new Tablier();
		t2.initialiserCase(listeCase);
		
		List<DeSixFaces> listeQutreDes = new ArrayList<DeSixFaces>();
		for(int i=0;i<4;i++){
			listeQutreDes.add(new DeSixFaces(CouleurCase.BLANC,2));
		}
		
		List<Coup> tmpListeQutreDes = t2.getCoupsPossibles(listeQutreDes,CouleurCase.BLANC);
		//deplace 8
		assertEquals(tmpListeQutreDes.get(0).getCaseArriver(),t2.getAllCase().get(24));
		assertEquals(tmpListeQutreDes.get(1).getCaseArriver(),t2.getAllCase().get(24));
		assertEquals(tmpListeQutreDes.get(2).getCaseArriver(),t2.getAllCase().get(24));
		assertEquals(tmpListeQutreDes.get(3).getCaseArriver(),t2.getAllCase().get(24));
		assertEquals(tmpListeQutreDes.get(4).getCaseArriver(),t2.getAllCase().get(24));
		//deplace 6
		assertEquals(tmpListeQutreDes.get(5).getCaseArriver(),t2.getAllCase().get(24));
		assertEquals(tmpListeQutreDes.get(6).getCaseArriver(),t2.getAllCase().get(24));
		assertEquals(tmpListeQutreDes.get(7).getCaseArriver(),t2.getAllCase().get(24));
		assertEquals(tmpListeQutreDes.get(8).getCaseArriver(),t2.getAllCase().get(24));
		assertEquals(tmpListeQutreDes.get(9).getCaseArriver(),t2.getAllCase().get(24));
		//deplace 4
		assertEquals(tmpListeQutreDes.get(10).getCaseArriver(),t2.getAllCase().get(22));
		assertEquals(tmpListeQutreDes.get(11).getCaseArriver(),t2.getAllCase().get(23));
		assertEquals(tmpListeQutreDes.get(12).getCaseArriver(),t2.getAllCase().get(24));
		assertEquals(tmpListeQutreDes.get(13).getCaseArriver(),t2.getAllCase().get(24));
		assertEquals(tmpListeQutreDes.get(14).getCaseArriver(),t2.getAllCase().get(24));
		//deplace 2
		assertEquals(tmpListeQutreDes.get(15).getCaseArriver(),t2.getAllCase().get(20));
		assertEquals(tmpListeQutreDes.get(16).getCaseArriver(),t2.getAllCase().get(21));
		assertEquals(tmpListeQutreDes.get(17).getCaseArriver(),t2.getAllCase().get(22));
		assertEquals(tmpListeQutreDes.get(18).getCaseArriver(),t2.getAllCase().get(23));
		assertEquals(tmpListeQutreDes.get(19).getCaseArriver(),t2.getAllCase().get(24));
		
	}
	

}

