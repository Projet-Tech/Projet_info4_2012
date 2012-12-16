// 
//
//  @ Projet : Project Gammon
//  @ Fichier : Joueur.java
//  @ Date : 12/12/2012
//  @ Auteurs : DONG Chuan, BONNETTO Benjamin, FRANCON Adrien, POTHELUNE Jean-Michel
//
//

package fr.ujm.tse.info4.pgammon.models;

import org.jdom2.Element;


public class Joueur
{
	private int id;
	private String pseudo;
	private String imageSource;
	//private BitmapData image;
	private NiveauAssistant niveauAssistant;
	
	public Joueur()
	{
		this.id = 0;
		this.pseudo="";
		this.imageSource = "";
		this.niveauAssistant = NiveauAssistant.NON_UTILISE;
	}

	public Joueur(int id,String pseudo,String imageSource,NiveauAssistant niveauAssistant)
	{
		this.id = id;
		this.pseudo=pseudo;
		this.imageSource = imageSource;
		this.niveauAssistant = niveauAssistant;
	}
	
	public void sauvegarder(Element profilsElement)
	{
		//TODO sauvegarder
		throw new UnsupportedOperationException();
	}
	
	public void charger(Element joueurElement)
	{
		//TODO charger
		throw new UnsupportedOperationException();
	}
	
	
	
	
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getImageSource() {
		return imageSource;
	}

	public void setImageSource(String imageSource) {
		this.imageSource = imageSource;
	}

	public NiveauAssistant getNiveauAssistant() {
		return niveauAssistant;
	}

	public void setNiveauAssistant(NiveauAssistant niveauAssistant) {
		this.niveauAssistant = niveauAssistant;
	}
}
