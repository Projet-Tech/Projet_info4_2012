package fr.ujm.tse.info4.pgammon.test.models;

import fr.ujm.tse.info4.pgammon.models.Joueur;
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
		
		/**
		 * 
		 * Tester StatustiqueJoueur
		 * 
		 */
		
		Joueur A1 = tmp.getList().get(0);//JOJO
		Joueur A2 = tmp.getList().get(1);//Adrien
		Joueur A3 = tmp.getList().get(2);//JM
		// 3 fois avec A2, 2 fois avec A3
		A1.getStat().ajouterAdversaire(A2);
		A1.getStat().ajouterAdversaire(A2);
		A1.getStat().ajouterAdversaire(A2);
		A1.getStat().ajouterAdversaire(A3);
		A1.getStat().ajouterAdversaire(A3);
		//Gagner 2 times,Perdre 3 times
		A1.getStat().ajouterVictoire();
		A1.getStat().ajouterVictoire();
		A1.getStat().ajouterDefaite();
		A1.getStat().ajouterDefaite();
		A1.getStat().ajouterDefaite();
		//Affichier les resultats
		System.out.println("NbVictoire "+A1.getStat().getNbVictoires());
		System.out.println("NbDefaites "+A1.getStat().getNbDefaites());
		System.out.println("PartiesJouees "+A1.getStat().getPartiesJouees());
		System.out.println("Pourcentage "+A1.getStat().getPourcentageVictoire());
		System.out.println("EnnemiFavoirs "+A1.getStat().getEnnemiFavoris());
		
	}
}
