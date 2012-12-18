package fr.ujm.tse.info4.pgammon.controleur;

import java.io.IOException;

import org.jdom2.JDOMException;

import fr.ujm.tse.info4.pgammon.models.Profils;
import fr.ujm.tse.info4.pgammon.vues.VueListeJoueur;

public class ControleurListeJoueur {

	public ControleurListeJoueur(ControleurPrincipal controleurPrincipal) 
	{
		//TODO a changer
		Profils tmp = new Profils();
		try {
			tmp.charger();
		} catch (JDOMException e) {
			
			//todo message probleme
		}catch (IOException e){
			//todo message probleme
		}
	
		//
		
		VueListeJoueur vueListeJoueur = new VueListeJoueur(tmp);
		controleurPrincipal.getFrame().setContentPane(vueListeJoueur);
		build();
	}
	
	public void build()
	{
		
	}
}
