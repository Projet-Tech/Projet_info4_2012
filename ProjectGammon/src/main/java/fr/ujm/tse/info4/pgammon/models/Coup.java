// 
//
//  @ Projet : Project Gammon
//  @ Fichier : Coup.java
//  @ Date : 12/12/2012
//  @ Auteurs : DONG Chuan, BONNETTO Benjamin, FRANCON Adrien, POTHELUNE Jean-Michel
//
//




package fr.ujm.tse.info4.pgammon.models;


public class Coup
{
	private Case caseDepart;
	private Case caseArriver;
	
	public Coup()
	{
		this.caseDepart = null;
		this.caseArriver = null;
	}
	
	public Coup(Case caseDepart, Case caseArriver)
	{
		this.caseDepart = caseDepart;
		this.caseArriver = caseArriver;
	}

	public Case getCaseDepart() {
		return caseDepart;
	}

	public void setCaseDepart(Case caseDepart) {
		this.caseDepart = caseDepart;
	}

	public Case getCaseArriver() {
		return caseArriver;
	}

	public void setCaseArriver(Case caseArriver) {
		this.caseArriver = caseArriver;
	}
	
	
}
