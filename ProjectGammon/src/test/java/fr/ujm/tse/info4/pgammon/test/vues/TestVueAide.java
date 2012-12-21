package fr.ujm.tse.info4.pgammon.test.vues;

import java.awt.Container;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import javax.swing.JFrame;

import fr.ujm.tse.info4.pgammon.vues.VueMenu;

public class TestVueAide {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Test Menu");

	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(816,638);
		Container panel = frame.getContentPane();
		panel.setLayout(new FlowLayout());
		
		VueMenu menu = new VueMenu();
		frame.setContentPane(menu);
		
		
		frame.setVisible(true);
		
		menu.getBoutonAide().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}		
			@Override
			public void mouseExited(MouseEvent e) {}			
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {
				//System.out.println("je suis la");
			   
				URI uri = URI.create("http://www.google.fr/url?sa=t&rct=j&q=&esrc=s&source=web&cd=1&ved=0CEoQFjAA&url=http%3A%2F%2Ffr.wikipedia.org%2Fwiki%2FBackgammon&ei=R0XUUM6YL4yHhQelkYHYBQ&usg=AFQjCNEOHnc7riItGN_di3jAPILrXp9twA&sig2=uesTfMvnLMwYI8reGb-vWw&bvm=bv.1355534169,d.ZG4&cad=rja");
				try {
					Desktop.getDesktop().browse(uri);
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
	}

}
