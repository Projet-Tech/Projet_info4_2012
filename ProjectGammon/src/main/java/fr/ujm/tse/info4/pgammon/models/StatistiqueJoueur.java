// 
//
//  @ Projet : Project Gammon
//  @ Fichier : StatistiqueJoueur.java
//  @ Date : 12/12/2012
//  @ Auteurs : DONG Chuan, BONNETTO Benjamin, FRANCON Adrien, POTHELUNE Jean-Michel
//
//




package fr.ujm.tse.info4.pgammon.models;

import java.util.Map;

import org.jdom2.Element;


public class StatistiqueJoueur
{
	private int partiesJouees;
	private int nbVictoires;
	private Map<Joueur,Integer> nbrDePartieContreJoueur;
	private float tempsJeu;
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
}
