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
	
		
	public ParametreJeu(int secondesParTour, int nbrPartieGagnante, boolean utiliseVideau,Joueur joueurBlanc,Joueur joueurNoir )
	{
		this.secondesParTour = secondesParTour;
		this.nbrPartieGagnante = nbrPartieGagnante;
		this.utiliseVideau = utiliseVideau;
		this.joueurBlanc = joueurBlanc;
		this.joueurNoir = joueurNoir;
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

	
	
	
	public int getSecondesParTour() {
		return secondesParTour;
	}

	public int getNbrPartieGagnante() {
		return nbrPartieGagnante;
	}

	public boolean isUtiliseVideau() {
		return utiliseVideau;
	}

	public Joueur getJoueurBlanc() {
		return joueurBlanc;
	}

	public Joueur getJoueurNoir() {
		return joueurNoir;
	}
	
	public Joueur getJoueur(CouleurCase couleurJoueur) {
		if (couleurJoueur == CouleurCase.BLANC)
			return joueurBlanc;
		else
			return joueurNoir;
	}






}
