// 
//
//  @ Projet : Project Gammon
//  @ Fichier : ParametreJeu.java
//  @ Date : 12/12/2012
//  @ Auteurs : DONG Chuan, BONNETTO Benjamin, FRANCON Adrien, POTHELUNE Jean-Michel
//
//




package fr.ujm.tse.info4.pgammon.models;

import org.jdom2.Element;


public class ParametreJeu
{
	private int secondesParTour;
	private int nbrPartieGagnante;
	private boolean utiliseVideau;
	public Joueur joueurBlanc;
	public Joueur joueurNoir;
	public ParametreJeu(Object secondesParTour, Object nbrPartieGagnante, Object utiliseVideau)
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public void sauvegarder(Element sessionElement)
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public void charger(Element parametreJeuElement)
	{
		//TODO
		throw new UnsupportedOperationException();
	}
}
