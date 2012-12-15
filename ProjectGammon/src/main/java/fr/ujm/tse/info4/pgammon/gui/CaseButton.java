package fr.ujm.tse.info4.pgammon.gui;

import fr.ujm.tse.info4.pgammon.models.Case;
import fr.ujm.tse.info4.pgammon.models.CouleurCase;

public class CaseButton {
	private Case c;
	private CouleurCase couleur;
	
	public CaseButton(Case _case, CouleurCase _couleur){
		c = _case;
	}

	
	
	
	public Case getCase() {
		return c;
	}

	public void setCase(Case _case) {
		c = _case;
	}




	public CouleurCase getCouleur() {
		return couleur;
	}




	public void setCouleur(CouleurCase couleur) {
		this.couleur = couleur;
	}
	
}
