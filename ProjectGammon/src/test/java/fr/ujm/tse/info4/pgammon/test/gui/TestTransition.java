package fr.ujm.tse.info4.pgammon.test.gui;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;

import fr.ujm.tse.info4.pgammon.gui.ChangementTourAnimation;

public class TestTransition {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("TestTransition");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,600);
		
		Container panel = frame.getContentPane();
		panel.setLayout(null);
		
		ChangementTourAnimation chg = new ChangementTourAnimation("Au tour de Petit Poney!","Joueur blanc");
		frame.setContentPane(chg);
		
		frame.setVisible(true);
	}
}
