// 
//
//  @ Projet : Project Gammon
//  @ Fichier : Session.java
//  @ Date : 12/12/2012
//  @ Auteurs : DONG Chuan, BONNETTO Benjamin, FRANCON Adrien, POTHELUNE Jean-Michel
//
//




package fr.ujm.tse.info4.pgammon.models;

import java.util.HashMap;
import java.util.Map;


public class Session
{
	private int idSession;
	private Partie partieEnCours;


	private Map<Joueur, Integer> scores;
	private EtatSession etatSession;
	private ParametreJeu parametreSession;
	
	public Session(int idSession,ParametreJeu parametreJeu)
	{
		this.idSession = idSession;
		etatSession = EtatSession.CONFIGURATION;
		parametreSession = parametreJeu;
		scores = new HashMap<Joueur, Integer>();
		scores.put(parametreSession.getJoueurBlanc(),0);
		scores.put(parametreSession.getJoueurNoir(),0);
		
		partieEnCours = new Partie(parametreSession);
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
	
	public void LancerPartie()
	{
		partieEnCours.LancerPartie();
	}
	
	public void finPartie()
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
	
	public Partie getPartieEnCours() {
		return partieEnCours;
	}



}

