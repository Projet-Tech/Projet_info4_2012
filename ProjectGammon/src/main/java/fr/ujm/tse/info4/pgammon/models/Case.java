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
	private int position;

	public Case(int position)
	{
		this.position = position;
		this.couleurDame = CouleurCase.VIDE;
		this.nbDame = 0;
	}
	
	public Case(int position, CouleurCase couleur)
	{
		this.position = position;
		this.couleurDame = couleur;
		this.nbDame = 0;
	}
	
	public Case(int position, CouleurCase couleur,int nombreDame)
	{
		this.position = position;
		this.couleurDame = couleur;
		this.nbDame = nombreDame;
	}
	
	public boolean isCaseVictoire()
	{
		//TODO
		throw new UnsupportedOperationException();
	}

	public CouleurCase getCouleurDame() {
		return couleurDame;
	}

	public void setCouleurDame(CouleurCase couleurDame) {
		this.couleurDame = couleurDame;
	}

	public int getNbDame() {
		return nbDame;
	}

	public void setNbDame(int nbDame) {
		this.nbDame = nbDame;
	}

	public int getPosition() {
		return position;
	}
}
