// 
//
//  @ Projet : Project Gammon
//  @ Fichier : Videau.java
//  @ Date : 12/12/2012
//  @ Auteurs : DONG Chuan, BONNETTO Benjamin, FRANCON Adrien, POTHELUNE Jean-Michel
//
//




package fr.ujm.tse.info4.pgammon.models;



public class Videau
{
	private int valeur;
	
	public Videau()
	{
		valeur = 1;
	}
	
	public Videau(int valeur)
	{
		this.valeur = valeur;
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
