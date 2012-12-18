// 
//
//  @ Projet : Project Gammon
//  @ Fichier : ControleurPartie.java
//  @ Date : 12/12/2012
//  @ Auteurs : DONG Chuan, BONNETTO Benjamin, FRANCON Adrien, POTHELUNE Jean-Michel
//
//

package fr.ujm.tse.info4.pgammon.controleur;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import fr.ujm.tse.info4.pgammon.models.Case;
import fr.ujm.tse.info4.pgammon.models.CouleurCase;
import fr.ujm.tse.info4.pgammon.models.NiveauAssistant;
import fr.ujm.tse.info4.pgammon.models.Partie;
import fr.ujm.tse.info4.pgammon.models.Session;
import fr.ujm.tse.info4.pgammon.vues.VuePartie;


public class ControleurPartie
{
	private Session session;
	private Partie partie;
	private VuePartie vuePartie;
	private ControleurTablier controleurTablier;
	
	//Ce constructeur seras detruit
	public  ControleurPartie(Partie partie)
	{
		
		this.partie = partie;
		//testInitialisation();
		vuePartie = new VuePartie(partie);
		build();
		controleurTablier = new ControleurTablier(partie,vuePartie);
	}
	
	public  ControleurPartie(Session session)
	{
		this.session =session;
		this.partie = this.session.getPartieEnCours();
		//testInitialisation();
		vuePartie = new VuePartie(partie);
		build();
		controleurTablier = new ControleurTablier(partie,vuePartie);
	}

	private void build() {
		vuePartie.getPaneldroitencours().getBack().addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				partie.annulerDernierCoup();
				vuePartie.updateUI();
				vuePartie.getVueTablier().updateDes();
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			@Override
			public void mouseExited(MouseEvent arg0) {}
			@Override
			public void mousePressed(MouseEvent arg0) {}
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
		});
		
		vuePartie.getPaneldroitencours().getDices().addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(partie.isTourFini())
				{
					partie.lancerDes();
					if(!partie.hasCoupPossible())
					{
						//TODO affichage plus de coup possible
						controleurTablier.changerTour();
					}
				}
				vuePartie.updateUI();
				vuePartie.getVueTablier().updateUI();
				vuePartie.getVueTablier().updateDes();
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			@Override
			public void mouseExited(MouseEvent arg0) {}
			@Override
			public void mousePressed(MouseEvent arg0) {}
			@Override
			public void mouseReleased(MouseEvent arg0) {}			
		});
		
		vuePartie.getPaneljoueur1().getCouppossible().addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(partie.getParametreJeu().getJoueurBlanc().getNiveauAssistant() == NiveauAssistant.NON_UTILISE )
					partie.getParametreJeu().getJoueurBlanc().setNiveauAssistant(NiveauAssistant.SIMPLE);
				else
					partie.getParametreJeu().getJoueurBlanc().setNiveauAssistant(NiveauAssistant.NON_UTILISE);
				vuePartie.getPaneljoueur1().updateData();
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			@Override
			public void mouseExited(MouseEvent arg0) {}
			@Override
			public void mousePressed(MouseEvent arg0) {}
			@Override
			public void mouseReleased(MouseEvent arg0) {}
		});
		
		vuePartie.getPaneljoueur2().getCouppossible().addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(partie.getParametreJeu().getJoueurNoir().getNiveauAssistant() == NiveauAssistant.NON_UTILISE )
					partie.getParametreJeu().getJoueurNoir().setNiveauAssistant(NiveauAssistant.SIMPLE);
				else
					partie.getParametreJeu().getJoueurNoir().setNiveauAssistant(NiveauAssistant.NON_UTILISE);
				vuePartie.getPaneljoueur2().updateData();
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			@Override
			public void mouseExited(MouseEvent arg0) {}
			@Override
			public void mousePressed(MouseEvent arg0) {}
			@Override
			public void mouseReleased(MouseEvent arg0) {}
		});
		
		
		
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
		
		lCase.add(new Case(CouleurCase.NOIR, 3, 1));
		lCase.add(new Case(CouleurCase.NOIR, 3, 2));
		lCase.add(new Case(CouleurCase.NOIR, 3, 3));
		lCase.add(new Case(CouleurCase.NOIR, 2, 4));
		lCase.add(new Case(CouleurCase.NOIR, 2, 5));
		lCase.add(new Case(CouleurCase.NOIR, 2, 6));
		lCase.add(new Case(CouleurCase.VIDE, 0, 7));
		lCase.add(new Case(CouleurCase.VIDE, 0, 8));
		lCase.add(new Case(CouleurCase.VIDE, 0, 9));
		lCase.add(new Case(CouleurCase.VIDE, 0, 10));
		lCase.add(new Case(CouleurCase.VIDE, 0, 11));
		lCase.add(new Case(CouleurCase.VIDE, 0, 12));
		lCase.add(new Case(CouleurCase.VIDE, 0, 13));
		lCase.add(new Case(CouleurCase.VIDE, 0, 14));
		lCase.add(new Case(CouleurCase.VIDE, 0, 15));
		lCase.add(new Case(CouleurCase.VIDE, 0, 16));
		lCase.add(new Case(CouleurCase.VIDE, 0, 17));
		lCase.add(new Case(CouleurCase.VIDE, 0, 18));
		lCase.add(new Case(CouleurCase.VIDE, 0, 19));
		lCase.add(new Case(CouleurCase.BLANC, 2, 20));
		lCase.add(new Case(CouleurCase.BLANC, 2, 21));
		lCase.add(new Case(CouleurCase.BLANC, 3, 22));
		lCase.add(new Case(CouleurCase.BLANC, 3, 23));
		lCase.add(new Case(CouleurCase.BLANC, 3, 24));

		partie.getTablier().initialiserCase(lCase);
		
		lCase = new ArrayList<Case>();
		lCase.add(new Case(CouleurCase.BLANC, 0, 25));
		lCase.add(new Case(CouleurCase.NOIR, 0, 0));
		partie.getTablier().initialiserCaseVictoire(lCase);
		
		lCase = new ArrayList<Case>();
		lCase.add(new Case(CouleurCase.BLANC, 2, 0));
		lCase.add(new Case(CouleurCase.NOIR, 0, 25));
		partie.getTablier().initialiserCaseBarre(lCase);
		
	}
	
}
