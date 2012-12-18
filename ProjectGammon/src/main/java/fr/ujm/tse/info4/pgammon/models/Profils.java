// 
//
//  @ Projet : Project Gammon
//  @ Fichier : Profils.java
//  @ Date : 12/12/2012
//  @ Auteurs : DONG Chuan, BONNETTO Benjamin, FRANCON Adrien, POTHELUNE Jean-Michel
//
//




package fr.ujm.tse.info4.pgammon.models;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class Profils
{
	public List<Joueur> joueurs = new ArrayList<Joueur>();
	private List<Element> listJoueurs;
	private static  Profils Profil;
	
	private Profils()
	{
		
	}
	
	public static Profils getProfils()
	{
		if(Profil == null){
			  Profil = new Profils();
		}
	    
		return Profil; 
		
	}
	
	
	public void sauvegarder()
	{
		Element racine = new Element("profils");
		Document document = new Document(racine);
		
		for(int i=0;i<joueurs.size();i++){
			joueurs.get(i).sauvegarder(racine);
		}
	
		try{
			//TOTO SECURITY
			XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
			sortie.output(document, new FileOutputStream("sauvegarde/profils.xml"));
	   
		}catch(Exception e){
			System.out.println("Erreur d'enregistrement");
		}
	}
	
	public void charger() throws JDOMException, IOException
	{
		 SAXBuilder builder = new SAXBuilder();
		 Document document = builder.build("sauvegarde/profils.xml");
		 Element racine = document.getRootElement();
		
		 listJoueurs = racine.getChildren("joueurs");
		 Iterator<Element> it = listJoueurs.iterator();
		 
		 while(it.hasNext()){
			 Joueur j = new Joueur();
			 j.charger(it.next());
			 joueurs.add(j);
		 }
		 
		 //Pour charger MAP<Joueur,Integer> dans Stat de chaque joueur
		 Iterator<Element> itStat = listJoueurs.iterator();
		 while(itStat.hasNext()){
			 Element e = itStat.next();//"e" est pour le premier child "joueurs"
			 Iterator<Element> itContre = e.getChild("statistiqueJoueur").getChild("nbrDePartieContreJoueur").getChildren("joueurs").iterator();
			 while(itContre.hasNext()){
				 Element c = itContre.next();//"c" est pour le deuxeme child "joueurs"
				 for(int i=0;i<joueurs.size();i++){
					 if(joueurs.get(i).getId()== Integer.valueOf(e.getAttributeValue("id")))//Chercher lequel joueur qu'on va charger leur MAP.
						 for(int j=0;j<joueurs.size();j++){
							 if(joueurs.get(j).getId()== Integer.valueOf(c.getAttributeValue("id"))){//Chercher lequel joueur est L'Adversaire
								 Joueur jcontre = joueurs.get(j);
								 joueurs.get(i).getStat().getNbrDePartieContreJoueur().put(jcontre,Integer.valueOf(c.getChildText("nbrPartie")));
							 }
						 }
				 }
			 }
		 }
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
