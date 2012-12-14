package fr.ujm.tse.info4.pgammon.test.models;

import fr.ujm.tse.info4.pgammon.models.*;

import junit.framework.TestCase;

public class TestPartie extends TestCase {

	public void testIsDirectory()
	{
		Joueur jBlanc = new Joueur(1,"ben","beauGoss",NiveauAssistant.NON_UTILISE);
		Joueur jNoir = new Joueur(1,"ben","beauGoss",NiveauAssistant.NON_UTILISE);
		ParametreJeu param = new  ParametreJeu(0,3,true,jBlanc,jNoir);
		Partie p = new Partie(param);
		
	    
	}
	
	
}
