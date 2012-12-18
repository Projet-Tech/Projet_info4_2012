package fr.ujm.tse.info4.pgammon.test.models;

import java.io.IOException;

import org.jdom2.JDOMException;

import fr.ujm.tse.info4.pgammon.models.Profils;

public class TestProfilsCharger {
	
	public static void main(String[] arg) throws JDOMException, IOException{
		System.out.println("Lancement du test de la Partie");
		
		Profils tmp = Profils.getProfils();
		
		
		tmp.charger();
		tmp.afficher();
		tmp.sauvegarder();
	}
}
