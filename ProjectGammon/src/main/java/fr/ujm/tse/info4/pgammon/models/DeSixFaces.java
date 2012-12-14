// 
//
//  @ Projet : Project Gammon
//  @ Fichier : DeSixFaces.java
//  @ Date : 12/12/2012
//  @ Auteurs : DONG Chuan, BONNETTO Benjamin, FRANCON Adrien, POTHELUNE Jean-Michel
//
//


package fr.ujm.tse.info4.pgammon.models;

import org.jdom2.Element;


public class DeSixFaces extends De
{
	/* VARIABLES */
	
	private int valeur;
	private boolean isUtilise;
	private CouleurCase couleurDe;
	
	/* FUNCTION */

	public DeSixFaces(CouleurCase couleurCase)
	{
		isUtilise = false;
		valeur = (int)(Math.random()*6);
		couleurDe = couleurCase;
	}
	
	public DeSixFaces(CouleurCase couleurCase, int valeur)
	{
		isUtilise = false;
		this.valeur = valeur;
		this.couleurDe = couleurCase;
	}
	
	public void utiliser()
	{
		isUtilise= true;
	}
	
	
	public void sauvegarder(Element partieElement)
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public void charger(Element desixfacesElement)
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	
	
	/* GETTERS ET SETTERS */
	
	public int getValeur() {
		return valeur;
	}

	public boolean isUtilise() {
		return isUtilise;
	}

	public CouleurCase getCouleurDe() {
		return couleurDe;
	}
	
	
}
