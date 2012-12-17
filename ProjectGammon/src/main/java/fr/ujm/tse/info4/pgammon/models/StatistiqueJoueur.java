// 
//
//  @ Projet : Project Gammon
//  @ Fichier : StatistiqueJoueur.java
//  @ Date : 12/12/2012
//  @ Auteurs : DONG Chuan, BONNETTO Benjamin, FRANCON Adrien, POTHELUNE Jean-Michel
//
//




package fr.ujm.tse.info4.pgammon.models;

import java.util.HashMap;
import java.util.Map;

import org.jdom2.Element;


public class StatistiqueJoueur
{
	private int partiesJouees;
	private int nbVictoires;
	private Map<Joueur,Integer> nbrDePartieContreJoueur;
	private float tempsJeu;
	
	public StatistiqueJoueur(){
		partiesJouees=0;
		nbVictoires=0;
		nbrDePartieContreJoueur = new HashMap<>();
		tempsJeu=0;
		
	}
	
	public void getPourcentageVictoire()
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public void getEnnemiFavoris()
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public void ajouterTempsJeu(float temps)
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public void ajouterVictoire()
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public void ajouterDefaite()
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public void ajouterAdvesaire(Joueur j)
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public void sauvegarder(Element profilsElement)
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public void charger(Element statistiqueJoueurElement)
	{
		//TODO
		throw new UnsupportedOperationException();
	}

	public int getPartiesJouees() {
		return partiesJouees;
	}

	public void setPartiesJouees(int partiesJouees) {
		this.partiesJouees = partiesJouees;
	}

	public int getNbVictoires() {
		return nbVictoires;
	}
	
	public int getNbDefaites() {
		return(partiesJouees-nbVictoires);
	}

	public void setNbVictoires(int nbVictoires) {
		this.nbVictoires = nbVictoires;
	}

	public Map<Joueur, Integer> getNbrDePartieContreJoueur() {
		return nbrDePartieContreJoueur;
	}

	public void setNbrDePartieContreJoueur(
			Map<Joueur, Integer> nbrDePartieContreJoueur) {
		this.nbrDePartieContreJoueur = nbrDePartieContreJoueur;
	}

	public float getTempsJeu() {
		return tempsJeu;
	}

	public void setTempsJeu(float tempsJeu) {
		this.tempsJeu = tempsJeu;
	}
	
	
}
