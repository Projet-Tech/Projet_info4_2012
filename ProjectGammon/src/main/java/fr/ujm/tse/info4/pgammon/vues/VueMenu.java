package fr.ujm.tse.info4.pgammon.vues;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Paint;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import fr.ujm.tse.info4.pgammon.gui.MonochromeButton;

public class VueMenu extends JPanel {

	private static final long serialVersionUID = 3060121008717453091L;
	public static final String img_menu = "images/menu_bg.png";
	
	private MonochromeButton boutonlancerpartie;
	private MonochromeButton boutonnouvellepartie;
	private MonochromeButton boutonajouter;
	private MonochromeButton boutonaide;
	private MonochromeButton boutonquitter;
	
	private ImageIcon icon;
	
	public VueMenu(){
		
		build();
	}
	
	private void build() {
		
		try{
			icon = new ImageIcon(img_menu);
		}catch(Exception err){
			//TODO : Creer une icone par défaut
			System.err.println(err);
		}
		
		setLayout(null);
		
		//déclaration des 2 panels un contenant les boutons
		//et un autre pour pouvoir centrer le panel
		JPanel conteneurgrid = new JPanel();
		JPanel conteneurbouton = new JPanel();
		
		BorderLayout bl = new BorderLayout();//permet de pourvoir centrer les composants
		GridLayout gl = new GridLayout(6, 1);//permet de contenir les boutons en colonne
		
		//paramètre du conteneur de grid
		conteneurgrid.setBounds(200, 150, 400, 400);
		conteneurgrid.setOpaque(false);
		
		
		
		//paramètre du conteneur de bouton
		gl.setVgap(10);//permet de faire un espacement de 10 entre chaque bouton
		conteneurbouton.setLayout(gl);
		conteneurbouton.setPreferredSize(new Dimension(400,350));//redimensionnement de la fenêtre
		conteneurbouton.setOpaque(false);//transparence de la fenêtre pour avoir le même fond

		
		
		boutonlancerpartie = new MonochromeButton("Lancer partie");
		conteneurbouton.add(boutonlancerpartie);
		
		boutonnouvellepartie = new MonochromeButton("Nouvelle partie");
		conteneurbouton.add(boutonnouvellepartie);
		
		boutonajouter = new MonochromeButton("Liste des joueurs");
		conteneurbouton.add(boutonajouter);
		
		boutonaide = new MonochromeButton("A propos");
		conteneurbouton.add(boutonaide);
		
		JPanel vide = new JPanel();
		vide.setOpaque(false);
		conteneurbouton.add(vide);
		
		boutonquitter = new MonochromeButton("Quitter");
		conteneurbouton.add(boutonquitter);
		
		add(conteneurgrid);
		conteneurgrid.add(conteneurbouton);
		
	}
	
	public MonochromeButton getBoutonlancerpartie() {
		return boutonlancerpartie;
	}

	public MonochromeButton getBoutonnouvellepartie() {
		return boutonnouvellepartie;
	}

	public MonochromeButton getBoutonajouter() {
		return boutonajouter;
	}

	public MonochromeButton getBoutonaide() {
		return boutonaide;
	}


	
	@Override
	protected void paintComponent(Graphics g) {
		

		Graphics2D g2 = (Graphics2D) g.create(); 
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
		
		Paint p;
		int h = getHeight(); 
		int w = getWidth(); 
		
		g2.drawImage(icon.getImage(),0,0,this);
		
		g2.dispose(); 
		
	}
}
