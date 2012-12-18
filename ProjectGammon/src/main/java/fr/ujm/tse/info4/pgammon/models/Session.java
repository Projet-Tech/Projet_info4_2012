// 
//
//  @ Projet : Project Gammon
//  @ Fichier : Session.java
//  @ Date : 12/12/2012
//  @ Auteurs : DONG Chuan, BONNETTO Benjamin, FRANCON Adrien, POTHELUNE Jean-Michel
//
//




package fr.ujm.tse.info4.pgammon.models;

import java.util.Map;


public class Session
{
	private int idSession;
	private Partie partieEnCours;
	private Map<Joueur, Integer> scores;
	private EtatSession etatSession;
	private ParametreJeu parametreSession;
	
	public Session(int idSession)
	{
		this.idSession = idSession;
		etatSession = EtatSession.CONFIGURATION;
	}
	
	private void modifierScore(Joueur j, Videau multiplicateur)
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	
	private EtatSession setEtat(EtatSession etat)
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public void finPartie()
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public Partie lancerPartie()
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public void setJoueurBlanc(Joueur j)
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public void setJoueurNoir(Joueur j)
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public void inverserCouleur()
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public void verifFinSession()
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public void sauvegarder()
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public void charger()
	{
		//TODO
		throw new UnsupportedOperationException();
	}


	public int getIdSession() {
		return idSession;
	}


}

