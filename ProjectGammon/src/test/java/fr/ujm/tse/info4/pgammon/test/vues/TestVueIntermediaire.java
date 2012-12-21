package fr.ujm.tse.info4.pgammon.test.vues;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import fr.ujm.tse.info4.pgammon.vues.VueIntermediairePartie;

public class TestVueIntermediaire {

	public static void main(String[] args){
		Boolean test=true;
		
		JFrame frame = new JFrame("Test Menu");

	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(816,638);
		Container panel = frame.getContentPane();
		panel.setLayout(new FlowLayout());
		
		VueIntermediairePartie creationPartie = new VueIntermediairePartie(test);
		frame.setContentPane(creationPartie);
		
		
		frame.setVisible(true);
	}
	
	

}
