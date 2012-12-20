package fr.ujm.tse.info4.pgammon.test.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import fr.ujm.tse.info4.pgammon.gui.HorlogeBarr;
import fr.ujm.tse.info4.pgammon.gui.MonochromeButton;
import fr.ujm.tse.info4.pgammon.models.Horloge;


public class TestHorloge {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Test Design");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(816,638);
		
		Container panel = frame.getContentPane();
		panel.setLayout(null);

		panel.setBackground(new Color(0x00000));
		
		final Horloge h = new Horloge(100000);
		HorlogeBarr hb  = new HorlogeBarr(h);
		hb.setBounds(122,480,598,20);	
		panel.add(hb);
		h.start();
		
		MonochromeButton btn = new MonochromeButton("+");
		btn.setBounds(600,100,150,50);
		panel.add(btn);
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				h.restart();
			}
		});
		
		frame.setVisible(true);
	}
}
