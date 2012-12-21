package fr.ujm.tse.info4.pgammon.test.gui;

import javax.swing.JFrame;

import fr.ujm.tse.info4.pgammon.gui.MonochromeVue;

public class TestMonochromeVue {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Test Design");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(816,638);

		MonochromeVue mv = new MonochromeVue();
		
		frame.setContentPane(mv);
		mv.afficherTransition("aa", "bb");
		
		frame.setVisible(true);
	}
}
