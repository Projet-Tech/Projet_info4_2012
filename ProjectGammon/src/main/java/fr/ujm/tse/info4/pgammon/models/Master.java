// 
//
//  @ Projet : Project Gammon
//  @ Fichier : Master.java
//  @ Date : 12/12/2012
//  @ Auteurs : DONG Chuan, BONNETTO Benjamin, FRANCON Adrien, POTHELUNE Jean-Michel
//
//




package fr.ujm.tse.info4.pgammon.models;

import java.util.ArrayList;

import fr.ujm.tse.info4.pgammon.controleur.ControleurPrincipal;


public class Master
{
	private int idMax;
	private ArrayList<Session> listSession;
	private ControleurPrincipal controleurPrincipal;
	
	public Master()
	{
		idMax= 0;
		controleurPrincipal = new ControleurPrincipal(this);
	}
	public void lancerSession()
	{
		if (peutLancerSession())
		{
			listSession.add(new Session(idMax));
		}
			
	}
	public void arreterSession(int id)
	{
		if(listSession.size()!=0)
		{
			for (Session session : listSession) {
				if(session.getIdSession() == id)
					listSession.remove(session);
			}
		}	
	}
	
	public boolean peutLancerSession()
	{
		//TODO gere le multi THREAD
		if (listSession.size() !=1 )
			return true;
		return false;
	}
	
	public static void main(String[] args) 
	{
		Master master = new Master();
		
		
		
		
	}
}