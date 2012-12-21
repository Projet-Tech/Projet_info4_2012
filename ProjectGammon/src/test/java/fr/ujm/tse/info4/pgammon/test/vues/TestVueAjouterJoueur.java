package fr.ujm.tse.info4.pgammon.test.vues;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;

import fr.ujm.tse.info4.pgammon.vues.VueAjouterJoueur;

public class TestVueAjouterJoueur {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Test ajouter joueur");
	
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(816,638);
		Container panel = frame.getContentPane();
		panel.setLayout(new FlowLayout());
		
		VueAjouterJoueur ajout = new VueAjouterJoueur();
		frame.setContentPane(ajout);
		
		
		frame.setVisible(true);
	}

}
