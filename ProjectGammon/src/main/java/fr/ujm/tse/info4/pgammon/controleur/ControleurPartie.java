// 
//
//  @ Projet : Project Gammon
//  @ Fichier : ControleurPartie.java
//  @ Date : 12/12/2012
//  @ Auteurs : DONG Chuan, BONNETTO Benjamin, FRANCON Adrien, POTHELUNE Jean-Michel
//
//

package fr.ujm.tse.info4.pgammon.controleur;
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
	
	
}
