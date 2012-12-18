package fr.ujm.tse.info4.pgammon.test.vues;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;

import fr.ujm.tse.info4.pgammon.controleur.ControleurPartie;
import fr.ujm.tse.info4.pgammon.models.Joueur;
import fr.ujm.tse.info4.pgammon.models.NiveauAssistant;
import fr.ujm.tse.info4.pgammon.models.ParametreJeu;
import fr.ujm.tse.info4.pgammon.models.Partie;
import fr.ujm.tse.info4.pgammon.models.Profils;
import fr.ujm.tse.info4.pgammon.vues.VueListeJoueur;

public class TestVueListeJoueur {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Test vue Liste Joueur");
		
		Profils tmp = new Profils();
		
		tmp.ajouter("DONG Chuan","Image DONG",NiveauAssistant.NON_UTILISE);
		tmp.ajouter("BONNETTO Benjamin","Image Ben",NiveauAssistant.COMPLET);
		tmp.ajouter("FRANCON Adrien","Image Adrien",NiveauAssistant.COMPLET);
		tmp.ajouter("POTHELUNE Jean-Michel","Image JM",NiveauAssistant.SIMPLE);
		tmp.ajouter("DONG Chuan","Image DONG",NiveauAssistant.NON_UTILISE);

	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(816,638);
		Container panel = frame.getContentPane();
		panel.setLayout(new FlowLayout());
		
		VueListeJoueur vueListeJoueur = new VueListeJoueur(tmp);
		frame.setContentPane(vueListeJoueur);
		
		
			
		
		frame.setVisible(true);
	}
}
