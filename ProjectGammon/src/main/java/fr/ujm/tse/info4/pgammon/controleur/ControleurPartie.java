// 
//
//  @ Projet : Project Gammon
//  @ Fichier : ControleurPartie.java
//  @ Date : 12/12/2012
//  @ Auteurs : DONG Chuan, BONNETTO Benjamin, FRANCON Adrien, POTHELUNE Jean-Michel
//
//

package fr.ujm.tse.info4.pgammon.controleur;
import java.util.ArrayList;

import fr.ujm.tse.info4.pgammon.models.Case;
import fr.ujm.tse.info4.pgammon.models.CouleurCase;
import fr.ujm.tse.info4.pgammon.models.Partie;
import fr.ujm.tse.info4.pgammon.vues.VuePartie;


public class ControleurPartie
{
	private Partie partie;
	private VuePartie vuePartie;
	private ControleurTablier controleurTablier;
	
	public  ControleurPartie(Partie partie)
	{
		
		this.partie = partie;
		testInitialisation();
		vuePartie = new VuePartie(partie);
		controleurTablier = new ControleurTablier(partie,vuePartie.getVueTablier());
		build();
	}

	private void build() {
		//TODO
	}
	
	public Partie getPartie() {
		return partie;
	}

	public VuePartie getVuePartie() {
		return vuePartie;
	}

	public ControleurTablier getControleurTablier() {
		return controleurTablier;
	}
	
	private void testInitialisation(){
		ArrayList<Case> lCase = new ArrayList<Case>();
		
		lCase.add(new Case(CouleurCase.NOIR, 5, 1));
		lCase.add(new Case(CouleurCase.NOIR, 5, 2));
		lCase.add(new Case(CouleurCase.NOIR, 5, 3));
		lCase.add(new Case(CouleurCase.VIDE, 0, 4));
		lCase.add(new Case(CouleurCase.VIDE, 0, 5));
		lCase.add(new Case(CouleurCase.VIDE, 0, 6));
		lCase.add(new Case(CouleurCase.VIDE, 0, 7));
		lCase.add(new Case(CouleurCase.VIDE, 0, 8));
		lCase.add(new Case(CouleurCase.VIDE, 0, 9));
		lCase.add(new Case(CouleurCase.VIDE, 0, 10));
		lCase.add(new Case(CouleurCase.VIDE, 0, 12));
		lCase.add(new Case(CouleurCase.VIDE, 0, 13));
		lCase.add(new Case(CouleurCase.VIDE, 0, 14));
		lCase.add(new Case(CouleurCase.VIDE, 0, 15));
		lCase.add(new Case(CouleurCase.VIDE, 0, 16));
		lCase.add(new Case(CouleurCase.VIDE, 0, 17));
		lCase.add(new Case(CouleurCase.VIDE, 0, 18));
		lCase.add(new Case(CouleurCase.VIDE, 0, 19));
		lCase.add(new Case(CouleurCase.VIDE, 0, 20));
		lCase.add(new Case(CouleurCase.VIDE, 0, 21));
		lCase.add(new Case(CouleurCase.BLANC, 5, 22));
		lCase.add(new Case(CouleurCase.BLANC, 5, 23));
		lCase.add(new Case(CouleurCase.BLANC, 5, 24));

		partie.getTablier().initialiserCase(lCase);
	}
	
}
