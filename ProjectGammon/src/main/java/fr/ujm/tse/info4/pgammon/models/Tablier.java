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
	
	public boolean sensDeplacementCorrect(Case cDepart, Case cArrivee)
	{
		if (distanceDeuxCase(cDepart,cArrivee)<0 && cDepart.getCouleurDame() == CouleurCase.BLANC 
				|| distanceDeuxCase(cDepart,cArrivee)>0 && cDepart.getCouleurDame() == CouleurCase.NOIR )
			return false;
		else
			return true;
	}
	
	public boolean isCoupPossible(Case cDepart, Case cArrivee)
	{
		if (cDepart.getNbDame() == 0)
			return false;
		
		if (cArrivee.isCaseVictoire()){
			if (peutMarquerDame(cDepart.getCouleurDame()) 
					&& cArrivee.getCouleurDame() == cDepart.getCouleurDame())
				return true;
			else
				return false;
		}

		/*if (sensDeplacementCorrect)
			return false;*/
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
	public boolean siDameManger(Case cDepart, Case cArrivee)
	{
		if(cDepart.getCouleurDame() != cArrivee.getCouleurDame() 
				&& cArrivee.getCouleurDame() != CouleurCase.VIDE 
				&& cArrivee.getNbDame()==1)
			return true;
		else
			return false;
	}
	
	public Coup intToCoup(int cDepartInt, int cArriveeInt,CouleurCase couleurCaseDepart)
	{
		Coup coup = new Coup();
		
		if (cDepartInt == 0 && couleurCaseDepart == CouleurCase.BLANC)
			coup.setCaseDepart(caseBarre.get(0));
		else if (cDepartInt == 25 && couleurCaseDepart == CouleurCase.NOIR)
			coup.setCaseDepart(caseBarre.get(1));
		else if (cDepartInt != 0 && cDepartInt != 25)
			coup.setCaseDepart(listeCase.get(cDepartInt-1));
			
		if (cArriveeInt == 25 && couleurCaseDepart == CouleurCase.BLANC)
			coup.setCaseArriver(caseVictoire.get(0));
		else if (cArriveeInt == 0 && couleurCaseDepart == CouleurCase.NOIR)
			coup.setCaseArriver(caseVictoire.get(1));
		else if (cArriveeInt != 0 && cArriveeInt != 25)
			coup.setCaseArriver(listeCase.get(cArriveeInt-1));
		
		
		return coup;
	}
	
	public boolean deplacerDame(int cDepartInt, int cArriveeInt,CouleurCase couleurCaseDepart)
	{
		Coup coup = intToCoup(cDepartInt,cArriveeInt,couleurCaseDepart);
		return deplacerDame(coup.getCaseDepart(),coup.getCaseArriver());
	}
	public boolean deplacerDame(Case cDepart, Case cArrivee)
	{
		
		if(isCoupPossible(cDepart,cArrivee))
		{
			//enregistrement de la case de départ
			Case CaseDepartSave =  new Case(cDepart.getCouleurDame(),cDepart.getNbDame(),cDepart.getPosition());
			
			//suppresion du jeton si possible
			if (!cDepart.moinDame())
				return false;
			//ajout de la dame
			
			if (siDameManger(CaseDepartSave,cArrivee))
			{
				if ( cArrivee.getCouleurDame()==CouleurCase.BLANC)
					caseBarre.get(0).ajoutDame(CouleurCase.BLANC);
				else
					caseBarre.get(1).ajoutDame(CouleurCase.NOIR);
			}
				
			cArrivee.ajoutDame(CaseDepartSave.getCouleurDame());
			
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
		if (couleur == CouleurCase.BLANC && getCaseVictoire().get(0).getNbDame() == 15
				|| couleur == CouleurCase.NOIR && getCaseVictoire().get(1).getNbDame() == 15 )
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
