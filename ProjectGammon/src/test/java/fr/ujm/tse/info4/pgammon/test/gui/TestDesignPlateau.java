package fr.ujm.tse.info4.pgammon.test.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;

import fr.ujm.tse.info4.pgammon.gui.TriangleCaseButton;
import fr.ujm.tse.info4.pgammon.models.Case;
import fr.ujm.tse.info4.pgammon.models.CouleurCase;

public class TestDesignPlateau {
	
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Test Design");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,600);
		
		Container panel = frame.getContentPane();
		panel.setLayout(new FlowLayout());

		panel.setBackground(new Color(0x00000));
		
		{
			TriangleCaseButton t1 = new TriangleCaseButton(null, CouleurCase.BLANC);
			panel.add(t1);
		}
		{
			TriangleCaseButton t2 = new TriangleCaseButton(null, CouleurCase.NOIR);
			panel.add(t2);
		}
		frame.setVisible(true);
	}
}
