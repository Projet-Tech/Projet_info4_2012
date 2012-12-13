// 
//
//  @ Projet : Project Gammon
//  @ Fichier : Partie.java
//  @ Date : 12/12/2012
//  @ Auteurs : DONG Chuan, BONNETTO Benjamin, FRANCON Adrien, POTHELUNE Jean-Michel
//
//




package fr.ujm.tse.info4.pgammon.models;

import java.util.List;
import java.util.Timer;

import org.jdom2.Element;


public class Partie
{
	private ParametreJeu parametreJeu;
	private Videau videau;
	private List<DeSixFaces> deSixFaces;
	private Tablier tablier;
	private StatistiquePartie statistique;
	private CouleurCase joueurEnCour;
	private List<Tour> HistoriqueToursJoueur;
	private int idPartie;
	private Timer timerTour;
	public Partie(ParametreJeu p)
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	private void changerTour()
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	private void finPartie()
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	private void onFinTimer()
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public void choixPremierJoueurLancementPartie()
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public boolean jouerCoup(Case caseDepart, Case caseArrivee)
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public boolean jouerCoup(Coup coup)
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public void annulerDernierCoup()
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public void lancerDes()
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public void doublerVideau()
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public void refusVideau()
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public void deplacementAleatoire()
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public List<Coup> getCoupsPossibles(DeSixFaces de)
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public List<Coup> getCoupsPossibles(Case c)
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public List<Coup> getCoupsPossibles()
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public boolean isCoupPossible(Case caseDepart, Case caseArrivee)
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public void historisationDeplacement(Case depart, Case arrivee, Object isBattue, Object isRentre)
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public void lectureProchainCoup()
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public void lecturePrecedentCoup()
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public void sauvegarder(Element sessionElement)
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public void charger(Element partieElement)
	{
		//TODO
		throw new UnsupportedOperationException();
	}
}
