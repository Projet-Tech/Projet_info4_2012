package fr.ujm.tse.info4.pgammon.test.vues;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;

import fr.ujm.tse.info4.pgammon.controleur.ControleurPartie;
import fr.ujm.tse.info4.pgammon.gui.Avatar;
import fr.ujm.tse.info4.pgammon.models.Joueur;
import fr.ujm.tse.info4.pgammon.models.NiveauAssistant;
import fr.ujm.tse.info4.pgammon.models.ParametreJeu;
import fr.ujm.tse.info4.pgammon.models.Partie;
import fr.ujm.tse.info4.pgammon.vues.VuePartie;

public class TestVuePartie {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Test vue partie");

	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(816,638);
		Container panel = frame.getContentPane();
		panel.setLayout(new FlowLayout());
		
		Joueur jBlanc = new Joueur(1, "ben", Avatar.CHAT_JAUNE.getPath(),NiveauAssistant.NON_UTILISE);
		Joueur jNoir = new Joueur(2, "JM", Avatar.CHEVAL.getPath(), NiveauAssistant.COMPLET);
		
		ParametreJeu param = new ParametreJeu(0, 3, true, jBlanc, jNoir);
		Partie p = new Partie(param);
		p.LancerPartie();
		
		ControleurPartie controleurPartie = new ControleurPartie(p);
		
		frame.setContentPane(controleurPartie.getVuePartie());
		
		
		frame.setVisible(true);
	}

}
