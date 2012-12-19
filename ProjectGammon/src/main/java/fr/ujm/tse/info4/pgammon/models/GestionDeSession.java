package fr.ujm.tse.info4.pgammon.models;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class GestionDeSession {
	public List<Session> listSession = new ArrayList<Session>();
	private static GestionDeSession gestionDeSession;
	
	private GestionDeSession(){
		
	}
	
	public static GestionDeSession getGestionDeSession() throws IOException{
		
		if(gestionDeSession == null){
			gestionDeSession = new GestionDeSession();  
			gestionDeSession.charger();
		} 
		return gestionDeSession; 
	}
	
	public void sauvegarder(){
		
		for(int i=0;i<listSession.size();i++){
	        try{
	        	String tmpNom = "Session"+String.valueOf(i);
				Element racine = new Element(tmpNom);
				Document document = new Document(racine);
				listSession.get(i).sauvegarder(racine);
				XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
				String tmpPath = "sauvegarde/"+tmpNom; 
				sortie.output(document, new FileOutputStream(tmpPath));
	        }catch(Exception e){
				System.out.println("Erreur d'enregistrement");
			}
		}
	}
	
	public void charger(){
		
	}
	
}
