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
import java.util.Iterator;
import java.util.List;

import org.jdom2.Attribute;
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
		listeCase= new ArrayList<Case>();
		caseVictoire = new ArrayList<Case>();
		caseBarre= new ArrayList<Case>();
		initialiserCase();
	}
	
	public Tablier()
	{
		partie= null;
		
		listeCase= new ArrayList<Case>();
		caseVictoire = new ArrayList<Case>();
		caseBarre= new ArrayList<Case>();
		initialiserCase();
	}
	
	public void initialiserCase(ArrayList<Case> listCase)
	{
		listeCase = new ArrayList<Case>();
		for (Case case1 : listCase) {
			listeCase.add(case1);
		}
		caseVictoire = new ArrayList<Case>();
		caseBarre = new ArrayList<Case>();
	}
	
	public void initialiserCaseBarre(ArrayList<Case> listCase)
	{
		caseBarre.add(listCase.get(0));
		caseBarre.add(listCase.get(1));
	}
	
	public void initialiserCaseVictoire(ArrayList<Case> listCase)
	{
		caseVictoire.add(listCase.get(0));
		caseVictoire.add(listCase.get(1));
	}
	/**
	 * Initialiser tous les cases dans le tablier
	 */
	public void initialiserCase()
	{
		
		listeCase.clear();
		caseVictoire.clear();
		caseBarre.clear();
		
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
	
	public void reinitialisationCase()
	{
		caseVictoire.get(0).setCase(CouleurCase.BLANC, 0);
		caseVictoire.get(1).setCase(CouleurCase.NOIR, 0);
		
		caseBarre.get(0).setCase(CouleurCase.BLANC, 0);
		caseBarre.get(1).setCase(CouleurCase.NOIR, 0);
		
		for (int i=0;i<24;i++)
		{
			if(i==0)
				listeCase.get(i).setCase(CouleurCase.BLANC, 2);
			else if(i==5)
				listeCase.get(i).setCase(CouleurCase.NOIR, 5);
			else if(i==7)
				listeCase.get(i).setCase(CouleurCase.NOIR, 3);
			else if(i==11)
				listeCase.get(i).setCase(CouleurCase.BLANC, 5);
			else if(i==12)
				listeCase.get(i).setCase(CouleurCase.NOIR, 5);
			else if(i==16)
				listeCase.get(i).setCase(CouleurCase.BLANC, 3);
			else if(i==18)
				listeCase.get(i).setCase(CouleurCase.BLANC, 5);
			else if(i==23)
				listeCase.get(i).setCase(CouleurCase.NOIR, 2);
			else
				listeCase.get(i).setCase(CouleurCase.VIDE, 0);	
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
	/**
	 * Verifier si c'est possible de deplacer entre les deux cases
	 * @param cDepart case depart
	 * @param cArrivee case arrivee
	 * @return boolean
	 */
	public boolean isCoupPossible(Case cDepart, Case cArrivee)
	{
		if (cDepart.getNbDame() == 0)
			return false;
		
		if(getCaseBarre(cDepart.getCouleurDame()).getNbDame() !=0 
				&& (cDepart.getPosition() != 0 && cDepart.getCouleurDame() ==CouleurCase.BLANC 
				|| cDepart.getPosition() != 25 && cDepart.getCouleurDame()==CouleurCase.NOIR ))
				return false;
		
		if (cArrivee.isCaseVictoire()){
			if (peutMarquerDame(cDepart.getCouleurDame()) 
					&& cArrivee.getCouleurDame() == cDepart.getCouleurDame())
				return true;
			else
				return false;
		}

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
	
	public boolean isCaseAvant(Case caseDame)
	{
		int nbDame = 0;
		
		if(caseDame.getCouleurDame() == CouleurCase.BLANC)
		{
			for (int i=18;i<(caseDame.getPosition()-1);i++)
			{
				if (getListeCase().get(i).getCouleurDame() == CouleurCase.BLANC)
					nbDame += getListeCase().get(i).getNbDame();
			}
		}
		else
		{
			for (int i=5;i>=caseDame.getPosition();i--)
			{
				if (getListeCase().get(i).getCouleurDame() == CouleurCase.NOIR)
					nbDame += getListeCase().get(i).getNbDame();
			}
		}
		
		
		if (nbDame==0)
			return false;
		else
			return true;
	}
	
	public boolean peutMarquerDame(CouleurCase Couleur)
	{
		int nbDame = 0;
		
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
	/**
	 * Recuperer le case arivee possible avec un case et un de donnee 
	 * @param c Case Depart
	 * @param de Un de 
	 * @return Case Arivee
	 */
	public Case getCaseADistance(Case c, DeSixFaces de)
	{
		if(c.getCouleurDame() == CouleurCase.BLANC){
			int blacnADistance = c.getPosition()+de.getValeur();
			if(blacnADistance <= 24){
				return listeCase.get(blacnADistance-1);
			}
			else{
				return caseVictoire.get(0);
			}
		}
		else
		{
			int noirADistance =c.getPosition()-de.getValeur();
			if(noirADistance >= 1){
				return listeCase.get(noirADistance-1);
			}
			else{
				return caseVictoire.get(1);
			}
		}	
	}
	
    /**
     * Verifier dans CaseBarre (Noir ou Blanc) il y a des damns
     * @param couleur Couleur de CaseBarre
     * @return turn = il y a des damns.  false = il y a rien
     */
	public boolean isDameDansCaseBarre(CouleurCase couleur)
	{
		if(getCaseBarre(couleur).getNbDame() == 0)
			return false;
		else
			return true;
				
	}
	/**
	 * Recuperer tous les cases possibles
	 * @param de Un de 
	 * @param couleur Couleur de joueur en cours
	 * @return une liste de tous les cases possibles
	 */
	public List<Coup> getCoupsPossibles(DeSixFaces de,CouleurCase couleur)
	{
		List<Coup> liste = new ArrayList<Coup>();
		
		List<Case> listeCase = getAllCase();
		
		for (Case case1 : listeCase) {
			if(case1.getCouleurDame()== couleur && !de.isUtilise()){
				Case tmpDepart = case1;
				Case tmpArrivee = getCaseADistance(tmpDepart,de);
				if(isCoupPossible(tmpDepart,tmpArrivee)){
					Coup tmpCoup = new Coup(tmpDepart,tmpArrivee);
					liste.add(tmpCoup);
				}
			}
		}
		return liste;
	}
	/**
	 * Recuperer tous les coups possibles selon les valeurs de des
	 * @param des Une liste de des
	 * @param couleur Couleur de joueur en cours
	 * @return une listes de coups possibles
	 */
	public List<Coup> getCoupsPossibles(List<DeSixFaces> des,CouleurCase couleur)
	{	
		int somme = 0;
		
		if(des.size()==2){
			
			List<Coup> listeUnDe = new ArrayList<Coup>();
			
			for (DeSixFaces tmpDe : des){
				listeUnDe.addAll(getCoupsPossibles(tmpDe,couleur));
				somme = somme + tmpDe.getValeur();
			}
			
			DeSixFaces sommeDe = new DeSixFaces(des.get(0).getCouleurDe(),somme);
			List<Coup> listeDeuxDes = getCoupsPossibles(sommeDe,couleur);
			
			listeDeuxDes.addAll(listeUnDe);
			
			return listeDeuxDes;
		}
		
		else{//Si 4 des
			
			DeSixFaces sommeQuatreDe = new DeSixFaces(des.get(0).getCouleurDe(),4*des.get(0).getValeur());
			DeSixFaces sommeTroisDe = new DeSixFaces(des.get(0).getCouleurDe(),3*des.get(0).getValeur());
			DeSixFaces sommedeuxDe = new DeSixFaces(des.get(0).getCouleurDe(),2*des.get(0).getValeur());
			
			List<Coup> listeQuatre = getCoupsPossibles(sommeQuatreDe,couleur);
			
			listeQuatre.addAll(getCoupsPossibles(sommeTroisDe,couleur));
			listeQuatre.addAll(getCoupsPossibles(sommedeuxDe,couleur));
			listeQuatre.addAll(getCoupsPossibles(des.get(0),couleur));
			
			return listeQuatre;
		}
	}
	/**
	 * Sauvegarder tous les infos sur tablier sous Racine partie
	 * @param partie Racine de Tablier dans fichiers XML
	 */
	public void sauvegarder(Element partie)
	{
		Element tablierXML = new Element("tablier");
	    partie.addContent(tablierXML);
	    
	    Element casesXML = new Element("Cases");
	    tablierXML.addContent(casesXML);
	    
	    for(int i = 0;i<listeCase.size();i++){
	    	
	    	Element CaseXML = new Element("Case");
	    	casesXML.addContent(CaseXML);
		    
		    Attribute idCase = new Attribute("id",String.valueOf(listeCase.get(i).getPosition()));
		    CaseXML.setAttribute(idCase);
		    
			    Element couleurDameXML = new Element("couleurDame");
			    couleurDameXML.setText(String.valueOf(listeCase.get(i).getCouleurDame()));
			    CaseXML.addContent(couleurDameXML);
			    
			    Element nbrDameXML = new Element("nbrDame");
			    nbrDameXML.setText(String.valueOf(listeCase.get(i).getNbDame()));
			    CaseXML.addContent(nbrDameXML);
	    }
	    
	    Element CaseVictoiresXML = new Element("CaseVictoires");
	    tablierXML.addContent(CaseVictoiresXML);
	    
	    for(int i = 0;i<caseVictoire.size();i++){
	    	
	    	Element CaseVictoireXML = new Element("CaseVictoire");
	    	CaseVictoiresXML.addContent(CaseVictoireXML);
	    	
	    	Attribute idCaseVictoire = new Attribute("id",String.valueOf(caseVictoire.get(i).getPosition()));
	    	CaseVictoireXML.setAttribute(idCaseVictoire);
		    
			    Element couleurDameVXML = new Element("couleurDame");
			    couleurDameVXML.setText(String.valueOf(caseVictoire.get(i).getCouleurDame()));
			    CaseVictoireXML.addContent(couleurDameVXML);
			    
			    Element nbrDameVXML = new Element("nbrDame");
			    nbrDameVXML.setText(String.valueOf(caseVictoire.get(i).getNbDame()));
			    CaseVictoireXML.addContent(nbrDameVXML);
	    }
	    
	    Element CaseBarsXML = new Element("CaseBars");
	    tablierXML.addContent(CaseBarsXML);
	    
	    for(int i = 0;i<caseBarre.size();i++){
	    	
	    	Element CaseBarXML = new Element("CaseBar");
	    	CaseBarsXML.addContent(CaseBarXML);
	    	
	    	Attribute idCaseBar = new Attribute("id",String.valueOf(caseBarre.get(i).getPosition()));
	    	CaseBarXML.setAttribute(idCaseBar);
		    
			    Element couleurDameBXML = new Element("couleurDame");
			    if(caseBarre.get(i).getPosition() == 0)
			    	couleurDameBXML.setText(String.valueOf(CouleurCase.BLANC));
			    else
			    	couleurDameBXML.setText(String.valueOf(CouleurCase.NOIR));
			    CaseBarXML.addContent(couleurDameBXML);
			    
			    Element nbrDameBXML = new Element("nbrDame");
			    nbrDameBXML.setText(String.valueOf(caseBarre.get(i).getNbDame()));
			    CaseBarXML.addContent(nbrDameBXML);
	    }
	}
	/**
	 * charger tous les infos sur tablier sous Racine partie
	 * @param partie Racine de Tablier dans fichiers XML
	 */
	public void charger(Element Partie)
	{
		listeCase = new ArrayList<Case>();
		
		List<Element> listlisteCase = Partie.getChild("tablier").getChild("Cases").getChildren("Case");
		Iterator<Element> ia = listlisteCase.iterator();
		 
		while(ia.hasNext()){
			Case tmpCase = new Case();
			tmpCase.charger(ia.next());
			listeCase.add(tmpCase);
		}
		
		caseVictoire = new ArrayList<Case>();
		
		List<Element> listcaseVictoire = Partie.getChild("tablier").getChild("CaseVictoires").getChildren("CaseVictoire");
		Iterator<Element> ib = listcaseVictoire.iterator();
		 
		while(ib.hasNext()){
			Case tmpCase = new Case();
			tmpCase.charger(ib.next());
			caseVictoire.add(tmpCase);
		}
		
		caseBarre = new ArrayList<Case>();
		
		List<Element> listcaseBarre = Partie.getChild("tablier").getChild("CaseBars").getChildren("CaseBar");
		Iterator<Element> ic = listcaseBarre.iterator();
		 
		while(ic.hasNext()){
			Case tmpCase = new Case();
			tmpCase.charger(ic.next());
			caseBarre.add(tmpCase);
		}
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
	
	public Case getCaseVictoire(CouleurCase couleur) {
		if(couleur == CouleurCase.BLANC)
			return caseVictoire.get(0);
		else
			return caseVictoire.get(1);
	}

	public ArrayList<Case> getCaseBarre() {
		return caseBarre;
	}
	
	public Case getCase(int position,CouleurCase couleur) {
		
		if (position >=1 && position <= 24)
			return listeCase.get(position-1);
		else if (position == 25 && couleur.equals(CouleurCase.BLANC))
			return caseVictoire.get(0);
		else if (position == 0 && couleur.equals(CouleurCase.NOIR))
			return caseVictoire.get(1);
		else if (position == 0 && couleur.equals(CouleurCase.BLANC))
			return caseBarre.get(0);
		else if( position == 25 && couleur.equals(CouleurCase.NOIR))
			return caseBarre.get(1);
		else
			return null;
	}
	
	public Case getCaseBarre(CouleurCase couleur) {
		if(couleur == CouleurCase.BLANC)
			return caseBarre.get(0);
		else
			return caseBarre.get(1);
	}
		
	public ArrayList<Case> getAllCase() {
		ArrayList<Case> listAllCase = new ArrayList<Case>();
		for (Case case1 : listeCase) {
			listAllCase.add(case1);
		}
		for (Case case1 : caseVictoire) {
			listAllCase.add(case1);
		}
		for (Case case1 : caseBarre) {
			listAllCase.add(case1);
		}
		return listAllCase;
	}

	public Partie getPartie() {
		return partie;
	}
	
	
	
}
