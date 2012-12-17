package fr.ujm.tse.info4.pgammon.test.vues;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;

import fr.ujm.tse.info4.pgammon.models.Joueur;
import fr.ujm.tse.info4.pgammon.models.NiveauAssistant;
import fr.ujm.tse.info4.pgammon.models.ParametreJeu;
import fr.ujm.tse.info4.pgammon.vues.VueNouvelleSession;



public class TestVueNouvelleSession {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			JFrame frame = new JFrame("Test Menu");

		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(800,600);
			Container panel = frame.getContentPane();
			panel.setLayout(new FlowLayout());
			
			Joueur jBlanc = new Joueur(1, "ben", "beauGoss",
					NiveauAssistant.NON_UTILISE);
			Joueur jNoir = new Joueur(2, "JM", "null", NiveauAssistant.COMPLET);

			ParametreJeu param = new ParametreJeu(0, 3, true, jBlanc, jNoir);
			
			VueNouvelleSession nouvellesession = new VueNouvelleSession();
			
			nouvellesession.setJoueur1(jBlanc);
			nouvellesession.setJoueur2(jNoir);
			frame.setContentPane(nouvellesession);
			
			
			frame.setVisible(true);
			
	}

	

}
