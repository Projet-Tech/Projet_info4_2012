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


public class Session
{
	private int idSession;
	private int idMaxPartie;
	private Partie partieEnCours;

	private Joueur JoueurGagnantSession;
	private HashMap<Joueur, Integer> scores;
	private EtatSession etatSession;
	private ParametreJeu parametreSession;
	
	public Session(int idSession,ParametreJeu parametreJeu)
	{
		this.idSession = idSession;
		idMaxPartie=1;
		etatSession = EtatSession.CONFIGURATION;
		parametreSession = parametreJeu;
		scores = new HashMap<Joueur, Integer>();
		scores.put(parametreSession.getJoueurBlanc(),0);
		scores.put(parametreSession.getJoueurNoir(),0);
		JoueurGagnantSession =null;
		nouvellePartie();
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
	private void finSession()
	{
		JoueurGagnantSession.getStat().ajouterVictoire();
		
		if (JoueurGagnantSession == parametreSession.getJoueurBlanc())
			parametreSession.getJoueurNoir().getStat().ajouterDefaite();
		else
			parametreSession.getJoueurBlanc().getStat().ajouterDefaite();
	
	}
	
	public void nouvellePartie()
	{
		idMaxPartie ++;
		partieEnCours = new Partie(idMaxPartie,parametreSession);
	}
	
	
	
	public void LancerPartie()
	{
		partieEnCours.LancerPartie();
	}
	
	public void finPartie()
	{
		int videau = partieEnCours.getVideau().getvideau();
		CouleurCase CouleurVictorieuse = partieEnCours.getJoueurEnCour();	
		scores.put(parametreSession.getJoueur(CouleurVictorieuse),scores.get(parametreSession.getJoueur(CouleurVictorieuse))+videau);
	}
	
	
	public void verifFinSession()
	{
		if(scores.get(parametreSession.getJoueurBlanc()) >= parametreSession.getNbrPartieGagnante())
		{
			etatSession = EtatSession.TERMINEE;
			JoueurGagnantSession = parametreSession.getJoueurBlanc();
		}
		else if(scores.get(parametreSession.getJoueurNoir()) >= parametreSession.getNbrPartieGagnante())
		{
			etatSession = EtatSession.TERMINEE;
			JoueurGagnantSession = parametreSession.getJoueurBlanc();
		}
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

	public Joueur getJoueurGagnantSession() {
		return JoueurGagnantSession;
	}
	
	public HashMap<Joueur, Integer> getScores() {
		return scores;
	}

	public boolean isSessionFini()
	{
		if (JoueurGagnantSession == null)
			return false;
		else
			return true;
	}

	public ParametreJeu getParametreSession() {
		return parametreSession;
	}




}

