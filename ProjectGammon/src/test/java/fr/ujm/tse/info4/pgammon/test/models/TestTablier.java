package fr.ujm.tse.info4.pgammon.test.models;

import fr.ujm.tse.info4.pgammon.models.Tablier;

public class TestTablier {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

		System.out.println("Lancement du test de la Tablier");

		// verification de l'initialisation du tablier
		Tablier tab1 = new Tablier();
		System.out.println("TABLIER : ");
		for(int i=0;i<tab1.getListeCase().size();i++)
			System.out.println(tab1.getListeCase().get(i).getPosition()
					+" : "+tab1.getListeCase().get(i).getCouleurDame()
					+" _ "+tab1.getListeCase().get(i).getNbDame());
		
		System.out.println("CASE VICTOIRE : ");
		for(int i=0;i<tab1.getCaseVictoire().size();i++)
			System.out.println(tab1.getCaseVictoire().get(i).getPosition()
					+" : "+tab1.getCaseVictoire().get(i).getCouleurDame()
					+" _ "+tab1.getCaseVictoire().get(i).getNbDame());
		
		System.out.println("CASE BARRE : ");
		for(int i=0;i<tab1.getCaseBarre().size();i++)
			System.out.println(tab1.getCaseBarre().get(i).getPosition()
					+" : "+tab1.getCaseBarre().get(i).getCouleurDame()
					+" _ "+tab1.getCaseBarre().get(i).getNbDame());
		
		// test deplacement dame
		tab1.deplacerDame(tab1.getListeCase().get(0), tab1.getListeCase().get(1));
		
		tab1.deplacerDame(tab1.getListeCase().get(5), tab1.getListeCase().get(6));
		tab1.deplacerDame(tab1.getListeCase().get(5), tab1.getListeCase().get(6));
		tab1.deplacerDame(tab1.getListeCase().get(5), tab1.getListeCase().get(6));
		tab1.deplacerDame(tab1.getListeCase().get(5), tab1.getListeCase().get(6));
		tab1.deplacerDame(tab1.getListeCase().get(0), tab1.getListeCase().get(5));
		
		tab1.deplacerDame(tab1.getListeCase().get(3), tab1.getListeCase().get(5));
		
		System.out.println("TABLIER : ");
		for(int i=0;i<tab1.getListeCase().size();i++)
			System.out.println(tab1.getListeCase().get(i).getPosition()
					+" : "+tab1.getListeCase().get(i).getCouleurDame()
					+" _ "+tab1.getListeCase().get(i).getNbDame());
		
		System.out.println("CASE BARRE : ");
		for(int i=0;i<tab1.getCaseBarre().size();i++)
			System.out.println(tab1.getCaseBarre().get(i).getPosition()
					+" : "+tab1.getCaseBarre().get(i).getCouleurDame()
					+" _ "+tab1.getCaseBarre().get(i).getNbDame());

		
		
	}

}
