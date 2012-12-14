// 
//
//  @ Projet : Project Gammon
//  @ Fichier : Case.java
//  @ Date : 12/12/2012
//  @ Auteurs : DONG Chuan, BONNETTO Benjamin, FRANCON Adrien, POTHELUNE Jean-Michel
//
//




package fr.ujm.tse.info4.pgammon.models;


public class Case
{
	private CouleurCase couleurDame;
	private int nbDame;
	// si position = 0 case de demarrage
	//1 à 24 = case normal
	//25 =  caseVictoire
	private int position;
	
	public Case(CouleurCase couleur,int nbDame,int position)
	{
		this.couleurDame = couleur;
		this.nbDame = nbDame;
		this.position =position;
	}
	
	public boolean isCaseVictoire()
	{
		if(position==25)
			return true;
		else
			return false;
	}
	
	public void ajoutDame()
	{
		nbDame+=1;
	}
	
	public boolean moinDame()
	{
		if(position >= 1){
			nbDame-=1;
			return true;
		}
		else
			return false;
	}

	/**
	 * 
	 * 
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
	
	
	
}
