package fr.ujm.tse.info4.pgammon.test.vues;

import java.awt.Container;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JFrame;

import fr.ujm.tse.info4.pgammon.gui.Avatar;
import fr.ujm.tse.info4.pgammon.models.Joueur;
import fr.ujm.tse.info4.pgammon.models.NiveauAssistant;
import fr.ujm.tse.info4.pgammon.models.ParametreJeu;
import fr.ujm.tse.info4.pgammon.models.Session;
import fr.ujm.tse.info4.pgammon.vues.VueChargerPartie;

public class TestVueChargerPartie {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("Test Menu");

	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(816,638);
		Container panel = frame.getContentPane();
		panel.setLayout(new FlowLayout());
		
		Joueur jBlanc = new Joueur(1, "ben", Avatar.CHAT_JAUNE.getPath(),NiveauAssistant.NON_UTILISE);
		Joueur jNoir = new Joueur(2, "JM", Avatar.CHEVAL.getPath(), NiveauAssistant.COMPLET);
		
		ParametreJeu param = new ParametreJeu(0, 3, true, jBlanc, jNoir);
		ArrayList<Session> listSession;
		listSession = new ArrayList<>();
		
		listSession.add(new Session(1,param));
		listSession.add(new Session(2,param));
		
		
		
		
		
		
		VueChargerPartie charger = new VueChargerPartie(listSession);
		frame.setContentPane(charger);
		
		
		frame.setVisible(true);
		

	}

}
