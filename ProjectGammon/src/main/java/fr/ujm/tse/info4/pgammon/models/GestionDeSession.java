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

public class GestionDeSession {
	public List<Session> listSession = new ArrayList<Session>();
	private static GestionDeSession gestionDeSession;
	
	private GestionDeSession(){
		
	}
	
	public static GestionDeSession getGestionDeSession() throws IOException, JDOMException{
		
		if(gestionDeSession == null){
			gestionDeSession = new GestionDeSession();  
			gestionDeSession.charger();
		} 
		return gestionDeSession; 
	}
	
	public void sauvegarder(){
		
		for(int i=0;i<listSession.size();i++){
	        try{
	        	String tmpNom = "Session"+String.valueOf(listSession.get(i).getIdSession());
				Element racine = new Element(tmpNom);
				Document document = new Document(racine);
				listSession.get(i).sauvegarder(racine);
				XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
				String tmpPath = "sauvegarde/"+tmpNom+".xml"; 
				sortie.output(document, new FileOutputStream(tmpPath));
	        }catch(Exception e){
				System.out.println("Erreur d'enregistrement");
			}
		}
	}
	
	public void charger() throws JDOMException, IOException{
		SAXBuilder builder = new SAXBuilder();
		
		
		Document document = builder.build("sauvegarde/profils.xml");
		Element racine = document.getRootElement();
		
	//	listJoueurs = racine.getChildren("joueurs");
		//Iterator<Element> it = listJoueurs.iterator();
		 
		// while(it.hasNext()){
		//	 Joueur j = new Joueur();
		//	 j.charger(it.next());
		//	 joueurs.add(j);
		 }	 
		
	//}
	
	public List<Session> getListSession() {
		return listSession;
	}

	public void setListSession(List<Session> listSession) {
		this.listSession = listSession;
	}

	
	
}
