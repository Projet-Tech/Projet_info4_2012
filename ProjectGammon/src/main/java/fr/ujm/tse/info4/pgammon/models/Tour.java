// 
//
//  @ Projet : Project Gammon
//  @ Fichier : Tour.java
//  @ Date : 12/12/2012
//  @ Auteurs : DONG Chuan, BONNETTO Benjamin, FRANCON Adrien, POTHELUNE Jean-Michel
//
//

package fr.ujm.tse.info4.pgammon.models;

import java.util.ArrayList;
import java.util.List;

import org.jdom2.Element;


public class Tour
{
	private ArrayList<DeSixFaces> deSixFaces;
	

	private ArrayList<Deplacement> listDeplacement;
	private CouleurCase couleurJoueur;
	
	public Tour(CouleurCase couleurJoueur,ArrayList<DeSixFaces> deSixFaces)
	{
		this.couleurJoueur = couleurJoueur;
		this.deSixFaces = deSixFaces;
		this.listDeplacement = new ArrayList<Deplacement>();
	}
	
	

	public void addDeplacement(Deplacement deplacement)
	{
		listDeplacement.add(deplacement);
	}
	
	public void supprimerDernierDeplacement()
	{
		listDeplacement.remove(listDeplacement.size()-1);
	}
	
	public Deplacement getDernierDeplacement()
	{	if (listDeplacement.size()!=0)
			return listDeplacement.get(listDeplacement.size()-1);
		else
			return null;
	}
	
	
	public CouleurCase getCouleurJoueur() {
		return couleurJoueur;
	}
	
	public ArrayList<DeSixFaces> getDeSixFaces() {
		return deSixFaces;
	}
	
	public ArrayList<Deplacement> getListDeplacement(){
		return listDeplacement;
	}
	
	
	// SERIALISATION
	public void sauvegarder(Element partieElement)
	{
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public void charger(Element tourElement)
	{
		//TODO
		throw new UnsupportedOperationException();
	}
}
