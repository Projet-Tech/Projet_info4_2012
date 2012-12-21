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
import java.util.Iterator;
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
	
	public Tour()
	{
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
	public void sauvegarder(Element historiqueToursJoueurXML)
	{
		Element tourXML = new Element("tour");
		historiqueToursJoueurXML.addContent(tourXML);
			
			Element couleurJoueurXML = new Element("couleurJoueur");
			couleurJoueurXML.setText(String.valueOf(couleurJoueur));
			tourXML.addContent(couleurJoueurXML);
		
			Element deSixFacesXML = new Element("deSixFaces");
			tourXML.addContent(deSixFacesXML);
			
			for(int i=0;i<deSixFaces.size();i++){
				deSixFaces.get(i).sauvegarder(deSixFacesXML);
			}
			
			Element deplacementsXML = new Element("deplacements");
			tourXML.addContent(deplacementsXML);
			
			for(int i=0;i<listDeplacement.size();i++){
				listDeplacement.get(i).sauvegarder(deplacementsXML);
			}
	}
	
	public void charger(Element tour,Partie partie)
	{
		switch(tour.getChildText("couleurJoueur")){
			case "BLANC":couleurJoueur = CouleurCase.BLANC;break;
			case "NOIR":couleurJoueur = CouleurCase.NOIR;break;
			case "VIDE":couleurJoueur = CouleurCase.VIDE;
		}
		
		List<Element> listdeSixFaces = tour.getChild("deSixFaces").getChildren("deSixFace");
		Iterator<Element> i = listdeSixFaces.iterator();
		 
		deSixFaces = new ArrayList<DeSixFaces>();
		
		while(i.hasNext()){
			DeSixFaces tmpDe = new DeSixFaces();
			tmpDe.charger(i.next());
			deSixFaces.add(tmpDe);
		}
		
		List<Element> listlistDeplacement = tour.getChild("deplacements").getChildren("deplacement");
		Iterator<Element> it = listlistDeplacement.iterator();
		
		listDeplacement = new ArrayList<Deplacement>();
		
		while(it.hasNext()){
			Deplacement tmpDeplacement = new Deplacement();
			tmpDeplacement.charger(it.next(),partie);
			listDeplacement.add(tmpDeplacement);
		}
		
	}
}
