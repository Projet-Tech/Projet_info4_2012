// 
//
//  @ Projet : Project Gammon
//  @ Fichier : Case.java
//  @ Date : 12/12/2012
//  @ Auteurs : DONG Chuan, BONNETTO Benjamin, FRANCON Adrien, POTHELUNE Jean-Michel
//
//

package fr.ujm.tse.info4.pgammon.models;

import org.jdom2.Element;

public class Case {
	private CouleurCase couleurDame;
	private int nbDame;
	private int position;

	public Case(CouleurCase couleur, int nbDame, int position) {
		this.couleurDame = couleur;
		this.nbDame = nbDame;
		this.position = position;
	}
	
	public Case() {
		
	}
	
	public void charger(Element Case){
			
			switch(Case.getChildText("couleurDame")){
				case "BLANC":couleurDame=CouleurCase.BLANC;break;
				case "NOIR":couleurDame=CouleurCase.NOIR;break;
				case "VIDE":couleurDame=CouleurCase.VIDE;
			}
			
			nbDame = Integer.valueOf(Case.getChildText("nbrDame"));
			position = Integer.valueOf(Case.getAttributeValue("id"));

	}
	
	public void chargerBV(Element Case){
		
		switch(Case.getChildText("couleurDame")){
			case "BLANC":couleurDame=CouleurCase.BLANC;break;
			case "NOIR":couleurDame=CouleurCase.NOIR;break;
			case "VIDE":couleurDame=CouleurCase.VIDE;
		}
		
		nbDame = Integer.valueOf(Case.getChildText("nbrDame"));
}

	public boolean isCaseVictoire() {
		if (position == 25 && couleurDame == CouleurCase.BLANC
				|| position == 0 && couleurDame == CouleurCase.NOIR)
			return true;
		else
			return false;
	}
	public boolean isCaseBarre() {
		if (position == 0 && couleurDame == CouleurCase.BLANC
				|| position == 25 && couleurDame == CouleurCase.NOIR)
			return true;
		else
			return false;
	}

	public boolean ajoutDame(CouleurCase couleur) {
		
		//Si la case et de la même couleur on ajout une dame
		if (this.couleurDame == couleur) {
			nbDame += 1;
			return true;
		} 
		//sinon si la case est vide on change de couleur et on increment
		else if(this.couleurDame == CouleurCase.VIDE)
		{
			nbDame += 1;
			this.couleurDame = couleur;
			return true;
		}
		//sinon si la case et de la couleur inverse et que il y a moins d'un jeton
		//on change juste de couleur
		else if (nbDame <= 1) {
			this.couleurDame = couleur;
			return true;
		} 
		//sinon probléme
		else
			return false;

	}

	public boolean moinDame() {
		if (nbDame >= 1) {
			nbDame -= 1;
			if (nbDame == 0)
				couleurDame = CouleurCase.VIDE;
			return true;
		} else
			return false;

	}

	/**
	 * 
	 * Getters
	 * 
	 */

	public CouleurCase getCouleurDame() {
		return couleurDame;
	}

	public int getNbDame() {
		return nbDame;
	}

	public int getPosition() {
		return position;
	}
	
	public void setCouleurDame(CouleurCase _couleurDame) {
		couleurDame = _couleurDame;
	}
	
	public void setNbDame(int _NbDame) {
		nbDame = _NbDame;
	}
	
	public void setPosition(int _Position) {
		position = _Position;
	}
	
	public void setCase(CouleurCase couleur, int nbDame) {
		this.couleurDame = couleur;
		this.nbDame = nbDame;
	
	}
	
}
