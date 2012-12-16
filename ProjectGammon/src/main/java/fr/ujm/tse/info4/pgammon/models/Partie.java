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
import org.omg.CORBA.SystemException;

public class Partie {
	private ParametreJeu parametreJeu;
	private Videau videau;
	private ArrayList<DeSixFaces> deSixFaces;
	private Tablier tablier;
	private StatistiquePartie statistique;
	private CouleurCase joueurEnCour;
	private ArrayList<Tour> HistoriqueToursJoueur;
	private int idPartie;
	private Timer timerTour;
	private boolean partieFini;

	public Partie(ParametreJeu p) {
		parametreJeu = p;
		tablier = new Tablier();
		videau = new Videau();
		statistique = new StatistiquePartie();
		HistoriqueToursJoueur = new ArrayList<Tour>();
		timerTour = new Timer();
		deSixFaces = new ArrayList<DeSixFaces>();
		partieFini = false;
	}


	public void LancerPartie() {
		choixPremierJoueurLancementPartie();
		lancerDes();
		
	}

	public void changerTour() {

		if (tablier.isTouteDameMarquee(joueurEnCour))
			finPartie();
		else {
			if (joueurEnCour == CouleurCase.BLANC)
				joueurEnCour = CouleurCase.NOIR;
			else
				joueurEnCour = CouleurCase.BLANC;
		}
		
		deSixFaces = new ArrayList<DeSixFaces>();
		lancerDes();
		
		
	}

	private void finPartie() {
		System.out.println("le joueur "+joueurEnCour + " a gagnée");
		partieFini=true;
	}

	private void onFinTimer() {
		// TODO
		throw new UnsupportedOperationException();
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
		
		// verification de l'existance du de;
		boolean siDeExiste = false;
		int deUtiliser =0;
		for (int i=0;i<deSixFaces.size();i++){
			if (((tablier.distanceDeuxCase(caseDepart, caseArrivee) == deSixFaces.get(i).getValeur() 
					&& joueurEnCour == CouleurCase.BLANC)
					|| (tablier.distanceDeuxCase(caseDepart, caseArrivee) == -deSixFaces.get(i).getValeur() 
							&& joueurEnCour == CouleurCase.NOIR))
					&& !deSixFaces.get(i).isUtilise())
				{siDeExiste = true;
				deUtiliser = i;}
		}
		if (!siDeExiste)
			return false;
		
		if (tablier.sensDeplacementCorrect(caseDepart, caseArrivee))
		{
			if (tablier.deplacerDame(caseDepart, caseArrivee))
			{
				deSixFaces.get(deUtiliser).utiliser();
				
				return true;
			}
			else
				return false;
		}
		else
			return false;
	}

	public boolean jouerCoup(Coup coup) {
		if (tablier.sensDeplacementCorrect(coup.getCaseDepart(),
				coup.getCaseArriver()))
			return tablier.deplacerDame(coup.getCaseDepart(),
					coup.getCaseArriver());
		else
			return false;
	}

	public void annulerDernierCoup() {
		// TODO
		throw new UnsupportedOperationException();
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
		deSixFaces.add(new DeSixFaces(joueurEnCour));
		deSixFaces.add(new DeSixFaces(joueurEnCour));
		if (deSixFaces.get(0).getValeur() == deSixFaces.get(1).getValeur()) {
			deSixFaces.add(new DeSixFaces(joueurEnCour, deSixFaces.get(0)
					.getValeur()));
			deSixFaces.add(new DeSixFaces(joueurEnCour, deSixFaces.get(0)
					.getValeur()));
		}
		
		//TODO il faudra enlever cette fonction.
		System.out.println(joueurEnCour + " : ");
		System.out.println("DeSixFace : ");
			for (int i = 0; i < deSixFaces.size(); i++)
				System.out.println(i + " : " + deSixFaces.get(i).getValeur() + " "+ deSixFaces.get(i).isUtilise());
				
	}

	public void doublerVideau() {
		videau.doubler();
	}

	public void refusVideau() {
		finPartie();
	}

	public void deplacementAleatoire() {
		// TODO
		throw new UnsupportedOperationException();
	}

	public List<Coup> getCoupsPossibles(DeSixFaces de) {
		// TODO
		throw new UnsupportedOperationException();
	}

	public List<Coup> getCoupsPossibles(Case c) {
		// TODO
		throw new UnsupportedOperationException();
	}

	public List<Coup> getCoupsPossibles() {
		// TODO
		throw new UnsupportedOperationException();
	}

	public boolean isCoupPossible(Case caseDepart, Case caseArrivee) {
		// TODO
		throw new UnsupportedOperationException();
	}

	public void historisationDeplacement(Case depart, Case arrivee,
			Object isBattue, Object isRentre) {
		// TODO
		throw new UnsupportedOperationException();
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
		return HistoriqueToursJoueur;
	}

	public void setHistoriqueToursJoueur(ArrayList<Tour> historiqueToursJoueur) {
		HistoriqueToursJoueur = historiqueToursJoueur;
	}

	public int getIdPartie() {
		return idPartie;
	}

	public void setIdPartie(int idPartie) {
		this.idPartie = idPartie;
	}

	public Timer getTimerTour() {
		return timerTour;
	}

	public void setTimerTour(Timer timerTour) {
		this.timerTour = timerTour;
	}

	public boolean isPartieFini() {
		return partieFini;
	}
}
