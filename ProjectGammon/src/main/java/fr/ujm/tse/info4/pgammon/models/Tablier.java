// 
//
//  @ Projet : Project Gammon
//  @ Fichier : Tablier.java
//  @ Date : 12/12/2012
//  @ Auteurs : DONG Chuan, BONNETTO Benjamin, FRANCON Adrien, POTHELUNE Jean-Michel
//
//




package fr.ujm.tse.info4.pgammon.models;

import java.util.ArrayList;
import java.util.List;

import org.jdom2.Element;


public class Tablier
{
	private ArrayList<Case> listeCase;
	private ArrayList<Case> caseVictoire;
	private ArrayList<Case> caseBarre;
	private Partie partie;
	
	

	public Tablier(Partie p)
	{
		partie=p;
		initialiserCase();
	}
	
	public Tablier()
	{
		partie= null;
		initialiserCase();
	}
	
	public void initialiserCase()
	{
		listeCase = new ArrayList<Case>();
		caseVictoire = new ArrayList<Case>();
		caseBarre = new ArrayList<Case>();
		
		caseVictoire.add(new Case(CouleurCase.BLANC, 0, 25));
		caseVictoire.add(new Case(CouleurCase.NOIR, 0, 0));
		
		caseBarre.add(new Case(CouleurCase.BLANC, 0, 0));
		caseBarre.add(new Case(CouleurCase.NOIR, 0, 25));
		
		for (int i=1;i<=24;i++)
		{
			if(i==1)
				listeCase.add(new Case(CouleurCase.BLANC, 2, i));
			else if(i==6)
				listeCase.add(new Case(CouleurCase.NOIR, 5, i));
			else if(i==8)
				listeCase.add(new Case(CouleurCase.NOIR, 3, i));
			else if(i==12)
				listeCase.add(new Case(CouleurCase.BLANC, 5, i));
			else if(i==13)
				listeCase.add(new Case(CouleurCase.NOIR, 5, i));
			else if(i==17)
				listeCase.add(new Case(CouleurCase.BLANC, 3, i));
			else if(i==19)
				listeCase.add(new Case(CouleurCase.BLANC, 5, i));
			else if(i==24)
				listeCase.add(new Case(CouleurCase.NOIR, 2, i));
			else
				listeCase.add(new Case(CouleurCase.VIDE, 0, i));	
		}		
	}
	
	public int distanceDeuxCase(Case cDepart, Case cArrivee)
	{
		return cArrivee.getPosition()-cDepart.getPosition();
	}
	
	public boolean isCoupPossible(Case cDepart, Case cArrivee)
	{
		if (cArrivee.isCaseVictoire()){
			if (peutMarquerDame(cDepart.getCouleurDame()) 
					&& cArrivee.getCouleurDame() == cDepart.getCouleurDame())
				return true;
			else
				return false;
		}

		if (distanceDeuxCase(cDepart,cArrivee)<0 && cDepart.getCouleurDame() == CouleurCase.BLANC 
				|| distanceDeuxCase(cDepart,cArrivee)>0 && cDepart.getCouleurDame() == CouleurCase.NOIR )
			return false;
		if(cDepart.getCouleurDame() == cArrivee.getCouleurDame())
			return true;
		else
		{
			if (cArrivee.getNbDame()<=1)
				return true;
			else
				return false;
		}
	}
	
	public boolean deplacerDame(Case cDepart, Case cArrivee)
	{
		if(isCoupPossible(cDepart,cArrivee))
		{
			//enregistrement de la couleur de la case de départ
			CouleurCase couleurCaseDepart =  cDepart.getCouleurDame();
			//suppresion du jeton si possible
			if (!cDepart.moinDame())
				return false;
			//ajout de la dame
			cArrivee.ajoutDame(couleurCaseDepart);
			
			return true;
		}
		else
			return false;
		
	}
	
	public int getCaseCouleur(CouleurCase couleur)
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	
	public boolean peutMarquerDame(CouleurCase Couleur)
	{
		int nbDame = 0;
		int a;
		int b;
		
		if(Couleur == CouleurCase.BLANC)
		{
			nbDame += getCaseBarre().get(0).getNbDame();
			for (int i=0;i<18;i++)
			{
				if (getListeCase().get(i).getCouleurDame() == CouleurCase.BLANC)
					nbDame += getListeCase().get(i).getNbDame();
			}
		}
		else
		{
			nbDame += getCaseBarre().get(1).getNbDame();
			for (int i=6;i<24;i++)
			{
				if (getListeCase().get(i).getCouleurDame() == CouleurCase.NOIR)
					nbDame += getListeCase().get(i).getNbDame();
			}
		}
		
		
		if (nbDame==0)
			return true;
		else
			return false;
	}
	
	public boolean isTouteDameMarquee(CouleurCase couleur)
	{
		if (couleur == CouleurCase.BLANC && getCaseVictoire().get(0).getNbDame() == 10
				|| couleur == CouleurCase.NOIR && getCaseVictoire().get(1).getNbDame() == 10 )
			return true;
		else 
			return false;
			
	}
	
	public Case getCaseADistance(Case c, DeSixFaces de)
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
	
	
	
	
	
	/**
	 * Serialisation
	 *
	 */
	
	
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
	
	
	/**
	 * 
	 * GETTERS
	 * 
	 */
	
	public ArrayList<Case> getListeCase() {
		return listeCase;
	}

	public ArrayList<Case> getCaseVictoire() {
		return caseVictoire;
	}

	public ArrayList<Case> getCaseBarre() {
		return caseBarre;
	}

	public Partie getPartie() {
		return partie;
	}
	
	
	
}
