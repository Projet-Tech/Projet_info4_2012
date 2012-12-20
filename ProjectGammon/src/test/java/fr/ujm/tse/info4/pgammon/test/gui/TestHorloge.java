package fr.ujm.tse.info4.pgammon.test.gui;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;

import fr.ujm.tse.info4.pgammon.gui.HorlogeBarr;
import fr.ujm.tse.info4.pgammon.models.Horloge;


public class TestHorloge {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Test Design");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(816,638);
		
		Container panel = frame.getContentPane();
		panel.setLayout(null);

		panel.setBackground(new Color(0x00000));
		
		Horloge h = new Horloge(10000);
		HorlogeBarr hb  = new HorlogeBarr(h);
		hb.setBounds(0,100,600,50);		
		panel.add(hb);
		h.start();
		
		frame.setVisible(true);
	}
}
