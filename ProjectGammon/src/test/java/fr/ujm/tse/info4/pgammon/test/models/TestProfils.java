package fr.ujm.tse.info4.pgammon.test.models;

import fr.ujm.tse.info4.pgammon.models.NiveauAssistant;
import fr.ujm.tse.info4.pgammon.models.Profils;

public class TestProfils {

	public static void main(String[] args) {

		System.out.println("Lancement du test de la Partie");
		
		Profils tmp = new Profils();
				
		tmp.ajouter("DONG Chuan","Image DONG",NiveauAssistant.NON_UTILISE);
		tmp.ajouter("BONNETTO Benjamin","Image Ben",NiveauAssistant.COMPLET);
		tmp.ajouter("FRANCON Adrien","Image Adrien",NiveauAssistant.COMPLET);
		tmp.ajouter("POTHELUNE Jean-Michel","Image JM",NiveauAssistant.SIMPLE);
		tmp.afficher();
		
		System.out.println("Supprimer");
		tmp.supprimer(tmp.getList().get(0));
		tmp.afficher();
		
		System.out.println("Modifier Image Source");
		tmp.modifierImageSource("XXXXXX", tmp.getList().get(0));
		tmp.afficher();
		
		System.out.println("Modifier Pseudo");
		tmp.modifierPseudo("JOJO",tmp.getList().get(0));
		tmp.afficher();
		
		tmp.getList().get(0).getStat().ajouterAdversaire(j)
		
		
	}
}
