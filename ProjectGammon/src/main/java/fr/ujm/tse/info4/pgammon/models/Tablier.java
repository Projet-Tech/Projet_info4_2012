// 
//
//  @ Projet : Project Gammon
//  @ Fichier : Tablier.java
//  @ Date : 12/12/2012
//  @ Auteurs : DONG Chuan, BONNETTO Benjamin, FRANCON Adrien, POTHELUNE Jean-Michel
//
//




package fr.ujm.tse.info4.pgammon.models;

import java.util.List;

import org.jdom2.Element;


public class Tablier
{
	private Case listeCase;
	private Object caseVictoire;
	private Object caseBarre;
	private Partie partie;
	public Tablier(Partie p)
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public int distanceDeuxCase(Case cDepart, Case cArrivee)
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public boolean isCoupPossible(Case cDepart, Case cArrivee)
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public void deplacerDame(Case cDepart, Case cArrivee)
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public int getCaseCouleur(CouleurCase couleur)
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public boolean peutMarquerDame(Object Couleur)
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public boolean isTouteDameMarquee(Object Couleur)
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public Case getCaseADistance(Case c, De de)
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
	
	public void sauvegarder(Element partieElement)
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public void charger(Element tablierElement)
	{
		//TODO
		throw new UnsupportedOperationException();
	}
}
