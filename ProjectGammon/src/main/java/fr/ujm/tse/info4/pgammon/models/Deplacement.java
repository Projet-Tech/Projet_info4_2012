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
	private double idDeplacement;

	public Deplacement(Case caseDepart, Case caseArriver, boolean siCaseBattue)
	{
		this.caseDepart = caseDepart;
		this.caseArriver = caseArriver;
		this.siCaseBattue = siCaseBattue;
		this.idDeplacement = Math.random()*Double.MAX_VALUE;
	}
	
	public Deplacement()
	{
		this.idDeplacement = Math.random()*Double.MAX_VALUE;
	}
	
	public void sauvegarder(Element deplacementsXML)
	{
		Element deplacementXML = new Element("deplacement");
		deplacementsXML.addContent(deplacementXML);
		
			Element caseDepartXML = new Element("caseDepart");
			caseDepartXML.setText(String.valueOf(caseDepart.getPosition()));
			deplacementXML.addContent(caseDepartXML);
			
			Element caseArriverXML = new Element("caseArriver");
			caseArriverXML.setText(String.valueOf(caseArriver.getPosition()));
			deplacementXML.addContent(caseArriverXML);
			
			Element siCaseBattueXML = new Element("siCaseBattue");
			if(siCaseBattue){
				siCaseBattueXML.setText("true");
			}else{
				siCaseBattueXML.setText("false");
			}
			deplacementXML.addContent(siCaseBattueXML);
	}
	
	public void charger(Element deplacement,Partie partie)
	{
		
		//ATTENTION A NE PAS TOUCHER
		
				
		int positionDepart = Integer.valueOf(deplacement.getChildText("caseDepart"));
		int positionArriver = Integer.valueOf(deplacement.getChildText("caseArriver"));
		CouleurCase couleur;
		
		if (positionDepart==0)
			couleur = CouleurCase.BLANC;
		else if (positionDepart==25)
			couleur = CouleurCase.NOIR;
		else if (positionArriver==0)
			couleur = CouleurCase.NOIR;
		else if (positionArriver==25)
			couleur = CouleurCase.BLANC;
		else if(positionDepart < positionArriver)
			couleur = CouleurCase.BLANC;
		else if(positionDepart > positionArriver)
			couleur = CouleurCase.NOIR;
		else 
			couleur = CouleurCase.VIDE;	
		
		
		
		caseDepart = partie.getTablier().getCase(positionDepart,couleur);
		caseArriver = partie.getTablier().getCase(positionArriver,couleur);
		
		siCaseBattue = Boolean.valueOf(deplacement.getChildText("siCaseBattue"));
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


	public double getIdDeplacement() {
		return idDeplacement;
	}

	
	
}
