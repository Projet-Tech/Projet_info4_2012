package fr.ujm.tse.info4.pgammon.test.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;

import fr.ujm.tse.info4.pgammon.gui.Avatar;
import fr.ujm.tse.info4.pgammon.gui.AvatarList;
import fr.ujm.tse.info4.pgammon.gui.ImageAvatar;

public class TestImages {

	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Test Design");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(816,638);
		
		Container panel = frame.getContentPane();
		panel.setLayout(null);

		panel.setBackground(new Color(0x00000));
		
		{
			ImageAvatar a = new ImageAvatar(Avatar.CHAT_JAUNE);
			a.setPreferredSize(new Dimension(100,100));
			panel.add(a);
		}
		{
			AvatarList al = new AvatarList();
			al.setBounds(0,0,800,600);
			panel.add(al);
		}
		
		frame.setVisible(true);
	}
}
