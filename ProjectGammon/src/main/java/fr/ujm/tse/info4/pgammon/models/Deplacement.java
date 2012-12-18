// 
//
//  @ Projet : Project Gammon
//  @ Fichier : Deplacement.java
//  @ Date : 12/12/2012
//  @ Auteurs : DONG Chuan, BONNETTO Benjamin, FRANCON Adrien, POTHELUNE Jean-Michel
//
//




package fr.ujm.tse.info4.pgammon.models;

import org.jdom2.Element;


public class Deplacement
{
	private Case caseDepart;
	private Case caseArriver;
	private boolean siCaseBattue;

	public Deplacement(Case caseDepart, Case caseArriver, boolean siCaseBattue)
	{
		this.caseDepart = caseDepart;
		this.caseArriver = caseArriver;
		this.siCaseBattue = siCaseBattue;
	}
	public void sauvegarder(Element tourElement)
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public void charger(Element deplacementElement)
	{
		//TODO
		throw new UnsupportedOperationException();
	}

	
	public Case getCaseDepart() {
		return caseDepart;
	}

	public Case getCaseArriver() {
		return caseArriver;
	}

	public boolean isSiCaseBattue() {
		return siCaseBattue;
	}


	public boolean isCaseRentree() {
		return caseArriver.isCaseVictoire();
	}


	
	
	
}
