package fr.ujm.tse.info4.pgammon.test.models;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import fr.ujm.tse.info4.pgammon.models.Joueur;
import fr.ujm.tse.info4.pgammon.models.NiveauAssistant;
import fr.ujm.tse.info4.pgammon.models.ParametreJeu;
import fr.ujm.tse.info4.pgammon.models.Partie;

public class TestUnitPartie extends TestCase {

	public TestUnitPartie(String testPartie) {
		super(testPartie);
	}

	public static Test suitePartie() {
		return new TestSuite(TestUnitPartie.class);
	}

	public void premierTest() {
		Joueur jBlanc = new Joueur(1, "ben", "beauGoss",
				NiveauAssistant.NON_UTILISE);
		Joueur jNoir = new Joueur(2, "JM", "null",
				NiveauAssistant.COMPLET);
		ParametreJeu param = new ParametreJeu(0, 3, true, jBlanc, jNoir);
		Partie p = new Partie(param);
		
		assertTrue( true );
	}

}
