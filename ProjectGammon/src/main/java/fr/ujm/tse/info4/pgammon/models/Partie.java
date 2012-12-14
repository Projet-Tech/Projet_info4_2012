// 
//
//  @ Projet : Project Gammon
//  @ Fichier : Partie.java
//  @ Date : 12/12/2012
//  @ Auteurs : DONG Chuan, BONNETTO Benjamin, FRANCON Adrien, POTHELUNE Jean-Michel
//
//




package fr.ujm.tse.info4.pgammon.models;

import java.util.List;
import java.util.Timer;

import org.jdom2.Element;


public class Partie
{
	private ParametreJeu parametreJeu;
	private Videau videau;
	private List<DeSixFaces> deSixFaces;
	private Tablier tablier;
	private StatistiquePartie statistique;
	private CouleurCase joueurEnCour;
	private List<Tour> HistoriqueToursJoueur;
	private int idPartie;
	private Timer timerTour;
	
	
	public Partie(ParametreJeu p)
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public void LancerPartie(ParametreJeu p)
	{
		
	}
	
	private void changerTour()
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	private void finPartie()
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	private void onFinTimer()
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public void choixPremierJoueurLancementPartie()
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public boolean jouerCoup(Case caseDepart, Case caseArrivee)
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public boolean jouerCoup(Coup coup)
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public void annulerDernierCoup()
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public void lancerDes()
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public void doublerVideau()
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public void refusVideau()
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public void deplacementAleatoire()
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
	
	public boolean isCoupPossible(Case caseDepart, Case caseArrivee)
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public void historisationDeplacement(Case depart, Case arrivee, Object isBattue, Object isRentre)
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public void lectureProchainCoup()
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public void lecturePrecedentCoup()
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	
	
	
	
	/* SERIALISATION*/
	
	public void sauvegarder(Element sessionElement)
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public void charger(Element partieElement)
	{
		//TODO
		throw new UnsupportedOperationException();
	}

	
	
	
	
	/* GETTERS ET SETTERS*/
	
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

	public List<DeSixFaces> getDeSixFaces() {
		return deSixFaces;
	}

	public void setDeSixFaces(List<DeSixFaces> deSixFaces) {
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

	public void setHistoriqueToursJoueur(List<Tour> historiqueToursJoueur) {
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
	
	
}
