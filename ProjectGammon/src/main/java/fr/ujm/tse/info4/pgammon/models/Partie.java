// 
//
//  @ Projet : Project Gammon
//  @ Fichier : Partie.java
//  @ Date : 12/12/2012
//  @ Auteurs : DONG Chuan, BONNETTO Benjamin, FRANCON Adrien, POTHELUNE Jean-Michel
//
//

package fr.ujm.tse.info4.pgammon.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import org.jdom2.Element;

import fr.ujm.tse.info4.pgammon.exeption.TourNonJouableException;

public class Partie {
	private ParametreJeu parametreJeu;
	private Videau videau;
	private ArrayList<DeSixFaces> deSixFaces;
	private Tablier tablier;
	private StatistiquePartie statistique;
	private CouleurCase joueurEnCour;
	private ArrayList<Tour> historiqueToursJoueur;
	private int idPartie;
	private boolean partieFini;
	private boolean tourFini;
	private int deUtiliser;

	public Partie(ParametreJeu p) {
		parametreJeu = p;
		tablier = new Tablier();
		videau = new Videau();
		statistique = new StatistiquePartie();
		historiqueToursJoueur = new ArrayList<Tour>();
		
		deSixFaces = new ArrayList<DeSixFaces>();
		
		//ces variables permet de connaitre l'état de la partie
		tourFini=true;
		partieFini = false;
	}
	
	public Partie(int idPartie ,ParametreJeu p) {
		parametreJeu = p;
		this.idPartie = idPartie;
		
		tablier = new Tablier();
		videau = new Videau();
		statistique = new StatistiquePartie();
		historiqueToursJoueur = new ArrayList<Tour>();
		deSixFaces = new ArrayList<DeSixFaces>();
		
		//ces variables permet de connaitre l'état de la partie
		tourFini=true;
		partieFini = false;
	}


	public void LancerPartie() {
		partieFini = false;
		choixPremierJoueurLancementPartie();
		//lancerDes();

		//on ajout un tour dans l'historique
		//historiqueToursJoueur.add(new Tour(joueurEnCour, deSixFaces));
		}
	
	public void debutTour()
	{
		historiqueToursJoueur.add(new Tour(joueurEnCour, deSixFaces));
	}

	public void changerTour(){

		if (tablier.isTouteDameMarquee(joueurEnCour))
			finPartie();
		else {
			if (joueurEnCour == CouleurCase.BLANC)
				joueurEnCour = CouleurCase.NOIR;
			else
				joueurEnCour = CouleurCase.BLANC;
		}
		
		deSixFaces = new ArrayList<DeSixFaces>();
		//lancerDes();
		tourFini = true;

	}

	public void finPartie() {
		//System.out.println("le joueur "+joueurEnCour + " a gagnée");
			partieFini=true;
		
	}

	
	public void choixPremierJoueurLancementPartie() {
		ArrayList<DeSixFaces> deChoix = new ArrayList<DeSixFaces>();
		deChoix.add(new DeSixFaces(joueurEnCour));
		deChoix.add(new DeSixFaces(joueurEnCour));
		
		if(deChoix.get(0).getValeur() == deChoix.get(1).getValeur())
		{
			choixPremierJoueurLancementPartie();
		}
		else if(deChoix.get(0).getValeur() > deChoix.get(1).getValeur())
			joueurEnCour = CouleurCase.BLANC;
		else
			joueurEnCour = CouleurCase.NOIR;	
	}

	public boolean jouerCoup(int caseDepartInt, int caseArriveeInt) {
		Coup coup = tablier.intToCoup(caseDepartInt, caseArriveeInt, joueurEnCour);
			return jouerCoup(coup.getCaseDepart(), coup.getCaseArriver());
	}
	
	public boolean jouerCoup(Case caseDepart, Case caseArrivee) {
		
		
		if(isCoupPossible(caseDepart,caseArrivee))
		{
			CouleurCase joueurEnemie;
			
			if (joueurEnCour == CouleurCase.BLANC)
				joueurEnemie = CouleurCase.NOIR;
			else
				joueurEnemie = CouleurCase.BLANC;
			
			int nbDameBarre = tablier.getCaseBarre(joueurEnemie).getNbDame();
			
			if (tablier.deplacerDame(caseDepart, caseArrivee))
			{
				deSixFaces.get(deUtiliser).utiliser();
				
				getDernierTour().addDeplacement(new Deplacement(caseDepart, caseArrivee,(nbDameBarre < tablier.getCaseBarre(joueurEnemie).getNbDame())));
				
				return true;
			}
			else
				return false;
		}
		else
			return false;
	}

	public boolean jouerCoup(Coup coup) {
		return jouerCoup(coup.getCaseDepart(),coup.getCaseArriver());
	}
	public boolean peutMarquerCetteDame(Case caseDame,DeSixFaces de)
	{
		Case caseVictoire;
		
		caseVictoire = tablier.getCaseVictoire(joueurEnCour);
		
			if (((tablier.distanceDeuxCase(caseDame, caseVictoire) == de.getValeur() 
					&& joueurEnCour == CouleurCase.BLANC)
					|| (tablier.distanceDeuxCase(caseDame, caseVictoire) == -de.getValeur() 
							&& joueurEnCour == CouleurCase.NOIR))
					&& !de.isUtilise())
				{return true;
				}
			else if (((tablier.distanceDeuxCase(caseDame, caseVictoire) < de.getValeur() 
					&& joueurEnCour == CouleurCase.BLANC && !tablier.isCaseAvant(caseDame))
					|| (tablier.distanceDeuxCase(caseDame, caseVictoire) > -de.getValeur() 
							&& joueurEnCour == CouleurCase.NOIR)&& !tablier.isCaseAvant(caseDame))
					&& !de.isUtilise())
				{return true;
				}

			return false;

	}
	

	public boolean peutMarquerCetteDame(Case caseDame)
	{
		boolean siDeExiste = false;
		int deUtiliser =0;
		Case caseVictoire;
		
		caseVictoire = tablier.getCaseVictoire(joueurEnCour);
		
		
		for (int i=0;i<deSixFaces.size();i++){
			if (((tablier.distanceDeuxCase(caseDame, caseVictoire) == deSixFaces.get(i).getValeur() 
					&& joueurEnCour == CouleurCase.BLANC)
					|| (tablier.distanceDeuxCase(caseDame, caseVictoire) == -deSixFaces.get(i).getValeur() 
							&& joueurEnCour == CouleurCase.NOIR))
					&& !deSixFaces.get(i).isUtilise())
				{siDeExiste = true;
				deUtiliser = i;}
			else if (((tablier.distanceDeuxCase(caseDame, caseVictoire) > deSixFaces.get(i).getValeur() 
					&& joueurEnCour == CouleurCase.BLANC && !tablier.isCaseAvant(caseDame))
					|| (tablier.distanceDeuxCase(caseDame, caseVictoire) > -deSixFaces.get(i).getValeur() 
							&& joueurEnCour == CouleurCase.NOIR)&& !tablier.isCaseAvant(caseDame))
					&& !deSixFaces.get(i).isUtilise())
				{siDeExiste = true;
				deUtiliser = i;}
			{
				
			}
		}
		if (!siDeExiste)
			return false;
			
		return true;
	}
	
	public void annulerDernierCoup() {
		Deplacement dernierDeplacement;
		
		Tour dernierTour = getDernierTour();
		if (dernierTour != null)
			dernierDeplacement = getDernierTour().getDernierDeplacement();
		else
			dernierDeplacement =null;
		
		if (dernierDeplacement!=null){
			for (DeSixFaces de : dernierTour.getDeSixFaces()) {
				if (de.isUtilise() && de.getValeur() == Math.abs(tablier.distanceDeuxCase(dernierDeplacement.getCaseArriver(), dernierDeplacement.getCaseDepart())))
				{
					//recuperation de la couleur de la dame manger
					CouleurCase CaseArriverSaveCouleur;
					if (dernierDeplacement.getCaseArriver().getCouleurDame() == CouleurCase.BLANC)
						CaseArriverSaveCouleur = CouleurCase.NOIR;
					else
						CaseArriverSaveCouleur = CouleurCase.BLANC;
					
					tablier.deplacerDame(dernierDeplacement.getCaseArriver(),dernierDeplacement.getCaseDepart());
					de.notUtiliser();
					if(getDernierTour().getDernierDeplacement().isSiCaseBattue())
					{
						tablier.deplacerDame(tablier.getCaseBarre(CaseArriverSaveCouleur),dernierDeplacement.getCaseArriver());
					}
					if (tourFini)
					{
						tourFini = false;
						deSixFaces = dernierTour.getDeSixFaces();
						joueurEnCour = dernierTour.getCouleurJoueur();
					}
					dernierTour.supprimerDernierDeplacement();
					return;
				}
			}
		}
	}

	public boolean siDesUtilises()
	{
		for (int i=0;i<deSixFaces.size();i++){
			if (!deSixFaces.get(i).isUtilise())
				return false;
		}
		return true;
	}
	public void lancerDes() {
		deSixFaces = new ArrayList<DeSixFaces>();
		deSixFaces.add(new DeSixFaces(joueurEnCour));
		deSixFaces.add(new DeSixFaces(joueurEnCour));
		if (deSixFaces.get(0).getValeur() == deSixFaces.get(1).getValeur()) {
			deSixFaces.add(new DeSixFaces(joueurEnCour, deSixFaces.get(0)
					.getValeur()));
			deSixFaces.add(new DeSixFaces(joueurEnCour, deSixFaces.get(0)
					.getValeur()));
		}	
		tourFini=false;
		debutTour();
	}

	public void doublerVideau() {
		videau.doubler();
	}

	public void refusVideau() {
		finPartie();
	}

	public void deplacementAleatoire() throws TourNonJouableException {
		 List<Coup> casesPossible = getCoupsPossibles();
		 if (casesPossible.size() != 0)
			 jouerCoup(casesPossible.get((int)(Math.random()*casesPossible.size())));
		 else
			 throw new TourNonJouableException("Pas de possibilité de faire un déplacement");
	}

	public List<Coup> getCoupsPossibles(DeSixFaces de) {
		// TODO
		throw new UnsupportedOperationException();
	}

	public List<Case> getCoupsPossibles(Case c) {
		ArrayList<Case> caseReturn = new ArrayList<Case>() ;
		Case caseArriver;
			for (DeSixFaces de : deSixFaces) {
				if (!de.isUtilise())
					{
						caseArriver = tablier.getCaseADistance(c, de);
						if(isCoupPossible(c,caseArriver))
						{
							caseReturn.add(caseArriver);
						}
					}
			}
		
		return caseReturn;
		
		
	}

	public List<Coup> getCoupsPossibles() {
		int somme = 0;

		List<Coup> listeUnDe = new ArrayList<Coup>();
		
		for (Case caseDame : tablier.getAllCase()) {
			if(caseDame.getCouleurDame() == joueurEnCour)
			{
				for (DeSixFaces tmpDe : deSixFaces){
					for (Case caseDametmp : getCoupsPossibles(caseDame)) {
						listeUnDe.add(new Coup(caseDame, caseDametmp));
					}
					
				}
			}
		}	
		return listeUnDe;
	}

	public boolean isCoupPossible(Case caseDepart, Case caseArrivee) {
		// verification de l'existance du de;
				boolean siDeExiste = false;
				deUtiliser =0;
				
				for (int i=0;i<deSixFaces.size();i++){
					
					if(peutMarquerCetteDame(caseDepart,deSixFaces.get(i)) && caseArrivee.isCaseVictoire() && caseArrivee.getCouleurDame() == caseDepart.getCouleurDame())
					{
						siDeExiste = true;
						deUtiliser = i;
					}
					else if (((tablier.distanceDeuxCase(caseDepart, caseArrivee) == deSixFaces.get(i).getValeur() 
							&& joueurEnCour == CouleurCase.BLANC)
							|| (tablier.distanceDeuxCase(caseDepart, caseArrivee) == -deSixFaces.get(i).getValeur() 
									&& joueurEnCour == CouleurCase.NOIR))
								&& !deSixFaces.get(i).isUtilise())
					{
						siDeExiste = true;
						deUtiliser = i;
					}

				}
				if (!siDeExiste)
					return false;
				
				if (tablier.sensDeplacementCorrect(caseDepart, caseArrivee))
				{
					return tablier.isCoupPossible(caseDepart, caseArrivee);
				}
				else
					return false;
			}

	
	public boolean isCoupPossible(Case caseDepart) {
		boolean possible=false;
		for (DeSixFaces de : deSixFaces) {
			if(isCoupPossible(caseDepart,tablier.getCaseADistance(caseDepart, de)) 
					&& !de.isUtilise())
				possible=true;
		}
		return possible;
	}

	public void historisationDeplacement(Case depart, Case arrivee,
			Object isBattue, Object isRentre) {
		// TODO
		throw new UnsupportedOperationException();
	}
	
	public boolean hasCoupPossible() {
		for (Case caseDame : tablier.getAllCase()) {
			if((!tablier.isDameDansCaseBarre(joueurEnCour) && caseDame.getCouleurDame() == joueurEnCour)
					|| caseDame.isCaseBarre())
				for (DeSixFaces de : deSixFaces) {
					if(!de.isUtilise())
						if(isCoupPossible(caseDame,tablier.getCaseADistance(caseDame, de)))
							return true;
				}
		}
		return false;	
	}

	public Tour getDernierTour()
	{
		if (historiqueToursJoueur.size() != 0)
			return historiqueToursJoueur.get(historiqueToursJoueur.size()-1);
		else
			return null;
	}
	
	
	
	public void lectureProchainCoup() {
		// TODO
		throw new UnsupportedOperationException();
	}

	public void lecturePrecedentCoup() {
		// TODO
		throw new UnsupportedOperationException();
	}

	/* SERIALISATION */

	public void sauvegarder(Element sessionElement) {
		// TODO
		throw new UnsupportedOperationException();
	}

	public void charger(Element partieElement) {
		// TODO
		throw new UnsupportedOperationException();
	}

	/* GETTERS ET SETTERS */

	public ParametreJeu getParametreJeu() {
		return parametreJeu;
	}

	public void setParametreJeu(ParametreJeu parametreJeu) {
		this.parametreJeu = parametreJeu;
	}

	public Videau getVideau() {
		return videau;
	}

	public void setVideau(Videau videau) {
		this.videau = videau;
	}

	public ArrayList<DeSixFaces> getDeSixFaces() {
		return deSixFaces;
	}

	public void setDeSixFaces(ArrayList<DeSixFaces> deSixFaces) {
		this.deSixFaces = deSixFaces;
	}

	public Tablier getTablier() {
		return tablier;
	}

	public void setTablier(Tablier tablier) {
		this.tablier = tablier;
	}

	public StatistiquePartie getStatistique() {
		return statistique;
	}

	public void setStatistique(StatistiquePartie statistique) {
		this.statistique = statistique;
	}

	public CouleurCase getJoueurEnCour() {
		return joueurEnCour;
	}

	public void setJoueurEnCour(CouleurCase joueurEnCour) {
		this.joueurEnCour = joueurEnCour;
	}

	public List<Tour> getHistoriqueToursJoueur() {
		return historiqueToursJoueur;
	}

	public void setHistoriqueToursJoueur(ArrayList<Tour> historiqueToursJoueur) {
		this.historiqueToursJoueur = historiqueToursJoueur;
	}

	public int getIdPartie() {
		return idPartie;
	}

	public void setIdPartie(int idPartie) {
		this.idPartie = idPartie;
	}


	public boolean isPartieFini() {
		return partieFini;
	}


	public boolean isTourFini() {
		return tourFini;
	}
	
}
