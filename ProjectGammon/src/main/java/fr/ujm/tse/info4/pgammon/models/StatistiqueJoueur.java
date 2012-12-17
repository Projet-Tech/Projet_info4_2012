// 
//
//  @ Projet : Project Gammon
//  @ Fichier : StatistiqueJoueur.java
//  @ Date : 12/12/2012
//  @ Auteurs : DONG Chuan, BONNETTO Benjamin, FRANCON Adrien, POTHELUNE Jean-Michel
//
//




package fr.ujm.tse.info4.pgammon.models;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.jdom2.Element;


public class StatistiqueJoueur
{
	private int partiesJouees;
	private int nbVictoires;
	private Map<Joueur,Integer> nbrDePartieContreJoueur;
	private float tempsJeu;
	
	public StatistiqueJoueur(){
		partiesJouees=0;
		nbVictoires=0;
		nbrDePartieContreJoueur = new HashMap<>();
		tempsJeu=0;	
	}
	
	public float getPourcentageVictoire()
	{
		float pourcentage = nbVictoires/(float)partiesJouees;
		return pourcentage;
	}
	
	public String getEnnemiFavoris()
	{
		Iterator<Entry<Joueur, Integer>> it = nbrDePartieContreJoueur.entrySet().iterator();
		int maxValue = 0; 
		Joueur maxKey = null;
		while (it.hasNext()) {
			Map.Entry<Joueur, Integer> entry = (Map.Entry<Joueur, Integer>) it.next();
			int value = entry.getValue();
			Joueur key = entry.getKey();
			if(value > maxValue){
				maxKey = key;
			}
		}
		return maxKey.getPseudo();
	}
	
	public void ajouterTempsJeu(float temps)
	{
		tempsJeu = tempsJeu + temps;
	}
	
	public void ajouterVictoire(){
		nbVictoires=nbVictoires+1;
		partiesJouees=partiesJouees+1;
	}
	
	public void ajouterDefaite()
	{
		partiesJouees=partiesJouees+1;
	}
	
	public void ajouterAdversaire(Joueur Adversaire)
	{	
		if(nbrDePartieContreJoueur.get(Adversaire)==null){
			nbrDePartieContreJoueur.put(Adversaire, 1);
		}
		int i = nbrDePartieContreJoueur.get(Adversaire);
		nbrDePartieContreJoueur.put(Adversaire,i+1);
	}
	
	public void sauvegarder(Element profilsElement)
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public void charger(Element statistiqueJoueurElement)
	{
		//TODO
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * GETTERS
	 * 
	 */
	
	public float getTempsJeu() {
		return tempsJeu;
	}
	
	public Map<Joueur, Integer> getNbrDePartieContreJoueur() {
		return nbrDePartieContreJoueur;
	}

	public int getNbDefaites() {
		return(partiesJouees-nbVictoires);
	}
	
	public int getPartiesJouees() {
		return partiesJouees;
	}

	public int getNbVictoires() {
		return nbVictoires;
	}
	
	/**
	 * 
	 * SETTERS
	 * 
	 */
	
	public void setTempsJeu(float tempsJeu) {
		this.tempsJeu = tempsJeu;
	}

	public void setNbrDePartieContreJoueur(
			Map<Joueur, Integer> nbrDePartieContreJoueur) {
		this.nbrDePartieContreJoueur = nbrDePartieContreJoueur;
	}
	
	public void setNbVictoires(int nbVictoires) {
		this.nbVictoires = nbVictoires;
	}

	public void setPartiesJouees(int partiesJouees) {
		this.partiesJouees = partiesJouees;
	}
}
