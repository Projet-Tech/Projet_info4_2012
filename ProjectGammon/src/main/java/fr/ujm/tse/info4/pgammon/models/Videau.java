// 
//
//  @ Projet : Project Gammon
//  @ Fichier : Videau.java
//  @ Date : 12/12/2012
//  @ Auteurs : DONG Chuan, BONNETTO Benjamin, FRANCON Adrien, POTHELUNE Jean-Michel
//
//




package fr.ujm.tse.info4.pgammon.models;



public class Videau extends De
{
	private int valeur;
	
	public Videau()
	{
		valeur = 1;
	}
	
	
	public int doubler()
	{
		valeur = valeur*2;
		return valeur;
	}
	
	public int getvideau()
	{
		return valeur;
	}
	

}
