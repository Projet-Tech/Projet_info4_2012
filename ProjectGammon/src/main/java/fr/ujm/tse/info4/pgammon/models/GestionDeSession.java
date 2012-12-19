package fr.ujm.tse.info4.pgammon.models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
		
	}
	
	public void charger(){
		
	}
	
}
