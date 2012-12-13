// 
//
//  @ Projet : Project Gammon
//  @ Fichier : Tour.java
//  @ Date : 12/12/2012
//  @ Auteurs : DONG Chuan, BONNETTO Benjamin, FRANCON Adrien, POTHELUNE Jean-Michel
//
//




package fr.ujm.tse.info4.pgammon.models;

import java.util.List;

import org.jdom2.Element;


public class Tour
{
	private List<DeSixFaces> deSixFaces;
	private List<Deplacement> coup;
	private CouleurCase couleurJoueur;
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
