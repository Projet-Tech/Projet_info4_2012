package fr.ujm.tse.info4.pgammon.test.vues;

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JFrame;

import fr.ujm.tse.info4.pgammon.vues.VueMenu;

public class TestMenu {
	
	public static void main(String[] args) {
	JFrame frame = new JFrame("Test Menu");

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(816,638);
	Container panel = frame.getContentPane();
	panel.setLayout(new FlowLayout());
	
	VueMenu menu = new VueMenu();
	frame.setContentPane(menu);
	
	
	frame.setVisible(true);
	
	}
}
