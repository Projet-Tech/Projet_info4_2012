package fr.ujm.tse.info4.pgammon.test.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;

import fr.ujm.tse.info4.pgammon.gui.TriangleCaseButton;
import fr.ujm.tse.info4.pgammon.models.Case;
import fr.ujm.tse.info4.pgammon.models.CouleurCase;
import fr.ujm.tse.info4.pgammon.models.Joueur;
import fr.ujm.tse.info4.pgammon.models.NiveauAssistant;
import fr.ujm.tse.info4.pgammon.models.ParametreJeu;
import fr.ujm.tse.info4.pgammon.models.Partie;
import fr.ujm.tse.info4.pgammon.vues.VuePartie;

public class TestTablier {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Test Design");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,600);
		
		Container panel = frame.getContentPane();
		panel.setLayout(new FlowLayout());

		
		// comment récuperer ce que l'utilisateur saisie.

		System.out.println("Lancement du test de la Partie");

		// creation des parametre et joueur
		Joueur jBlanc = new Joueur(1, "ben", "beauGoss",
				NiveauAssistant.NON_UTILISE);
		Joueur jNoir = new Joueur(2, "JM", "null", NiveauAssistant.COMPLET);

		ParametreJeu param = new ParametreJeu(0, 3, true, jBlanc, jNoir);
		Partie p = new Partie(param);
		p.LancerPartie();
		// partie lancée
		
		VuePartie vp = new VuePartie(p);
		panel.add(vp);
		
		frame.setVisible(true);
	}
}
