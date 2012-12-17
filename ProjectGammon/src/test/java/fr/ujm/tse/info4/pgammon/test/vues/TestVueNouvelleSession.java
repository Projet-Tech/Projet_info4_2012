package fr.ujm.tse.info4.pgammon.test.vues;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;

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
			
			VueNouvelleSession nouvellesession = new VueNouvelleSession();
			frame.setContentPane(nouvellesession);
			
			
			frame.setVisible(true);
			
	}

	

}
