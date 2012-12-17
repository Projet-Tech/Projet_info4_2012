package fr.ujm.tse.info4.pgammon.test.controleur;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;

import fr.ujm.tse.info4.pgammon.controleur.ControleurPartie;
import fr.ujm.tse.info4.pgammon.models.Joueur;
import fr.ujm.tse.info4.pgammon.models.NiveauAssistant;
import fr.ujm.tse.info4.pgammon.models.ParametreJeu;
import fr.ujm.tse.info4.pgammon.models.Partie;

public class TestControleurPartie {

			public static void main(String[] args) {
				JFrame frame = new JFrame("Test Controleur");

		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        frame.setSize(816,638);
				
				Container panel = frame.getContentPane();
				panel.setLayout(new FlowLayout());

				
				
				// creation des parametre et joueur
				Joueur jBlanc = new Joueur(1, "ben", "beauGoss",
						NiveauAssistant.NON_UTILISE);
				Joueur jNoir = new Joueur(2, "JM", "null", NiveauAssistant.COMPLET);

				ParametreJeu param = new ParametreJeu(0, 3, true, jBlanc, jNoir);
				Partie p = new Partie(param);
				p.LancerPartie();
				
				ControleurPartie controleurPartie = new ControleurPartie(p);
			
				panel.add(controleurPartie.getVuePartie());
				
				frame.setVisible(true);
			}
	
}
