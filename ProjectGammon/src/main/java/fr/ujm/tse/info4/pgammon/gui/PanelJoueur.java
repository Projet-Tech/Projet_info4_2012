package fr.ujm.tse.info4.pgammon.gui;

import fr.ujm.tse.info4.pgammon.models.Joueur;

public class PanelJoueur extends MonochromePanel{
	
	private static final long serialVersionUID = 7553310687895062778L;
	private Joueur joueur;
	
		public PanelJoueur(Joueur j){
			super(j.getPseudo());
			joueur=j;
			joueur = new Joueur();
			
		}
		
		public void setJoueur(Joueur j){
			joueur=j;
			setTitle(joueur.getPseudo());
		}

}
