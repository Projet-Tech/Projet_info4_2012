package fr.ujm.tse.info4.pgammon.test.vues;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;

import fr.ujm.tse.info4.pgammon.vues.VueChargerPartie;
import fr.ujm.tse.info4.pgammon.vues.VueMenu;

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
		
		VueChargerPartie charger = new VueChargerPartie();
		frame.setContentPane(charger);
		
		
		frame.setVisible(true);
		

	}

}
