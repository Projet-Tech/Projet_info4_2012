package fr.ujm.tse.info4.pgammon.test.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;

import fr.ujm.tse.info4.pgammon.gui.MonochromeButton;
import fr.ujm.tse.info4.pgammon.gui.MonochromePanel;

public class TestDesign {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Test Design");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,600);
		
		Container panel = frame.getContentPane();
		panel.setLayout(new FlowLayout());

		MonochromePanel mp = new MonochromePanel("MonochromePanel");
		mp.setPreferredSize(new Dimension(400, 500));
		
		panel.add(mp);
		panel.setBackground(new Color(0x00000));
		{
			MonochromeButton mbtn = new MonochromeButton("Button1");
			mbtn.setPreferredSize(new Dimension(200, 60));
			panel.add(mbtn);
		}
		{
			MonochromeButton mbtn = new MonochromeButton("MonochromeButton2");
			mbtn.setPreferredSize(new Dimension(300, 60));
			panel.add(mbtn);
		}
		frame.setVisible(true);
	}
}
