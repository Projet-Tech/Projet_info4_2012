// 
//
//  @ Projet : Project Gammon
//  @ Fichier : Profils.java
//  @ Date : 12/12/2012
//  @ Auteurs : DONG Chuan, BONNETTO Benjamin, FRANCON Adrien, POTHELUNE Jean-Michel
//
//




package fr.ujm.tse.info4.pgammon.models;

import java.util.ArrayList;
import java.util.List;

public class Profils
{
	public List<Joueur> joueurs = new ArrayList<Joueur>();
	
	public void sauvegarder()
	{
		throw new UnsupportedOperationException();
	}
	
	public void charger()
	{
		throw new UnsupportedOperationException();
	}
	
	public void ajouter(String _pseudo,String _imageSource,NiveauAssistant _niveau){
		
		joueurs.add(new Joueur(joueurs.size()+1,_pseudo,_imageSource,_niveau));
		
	}
	
	public void modifierPseudo(String _pseudo,Joueur j){
		
		for(int i=0;i<joueurs.size();i++){
			if(joueurs.get(i).getId()==j.getId()){
				joueurs.get(i).setPseudo(_pseudo);
			}
		}
	}
	
	public void modifierImageSource(String _imageSource,Joueur j){
		
		for(int i=0;i<joueurs.size();i++){
			if(joueurs.get(i).getId()==j.getId()){
				joueurs.get(i).setImageSource(_imageSource);
			}
		}
	}
	
	public void supprimer(Joueur j)
	{
		for(int i=0;i<joueurs.size();i++){
			if(joueurs.get(i).getId()==j.getId()){
				joueurs.remove(i);
			}
		}
	}
	
	public void afficher(){
		for(int i=0;i<joueurs.size();i++){
				System.out.println(joueurs.get(i).getId()+" "+joueurs.get(i).getPseudo()+" "+joueurs.get(i).getImageSource()+" "+joueurs.get(i).getNiveauAssistant());
		}
	}
	
	public List<Joueur> getList(){
		return joueurs;
	}
}
