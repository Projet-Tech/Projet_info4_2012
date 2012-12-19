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

import fr.ujm.tse.info4.pgammon.gui.ChangementTourAnimation;
import fr.ujm.tse.info4.pgammon.gui.MonochromeButton;
import fr.ujm.tse.info4.pgammon.gui.MonochromeVue;

public class VueMenu extends MonochromeVue {

	private static final long serialVersionUID = 3060121008717453091L;
	public static final String img_menu = "images/menu_bg.png";
	
	//déclaration des variables de boutons
	private MonochromeButton boutonnouvellepartie;
	private MonochromeButton boutonreprendrepartie;
	private MonochromeButton boutonajouter;
	private MonochromeButton boutonaide;
	private MonochromeButton boutonquitter;
	
	private ImageIcon icon;
	
	public VueMenu(){
		
		build();
	}
	
	private void build() {
		
		//récupération de l'image
		try{
			icon = new ImageIcon(img_menu);
		}catch(Exception err){
			System.err.println(err);
		}
		
		//ceci est fait pour pouvoir déplacer nos panels dans le panel
		setLayout(null);
		
		//déclaration des 2 panels un contenant les boutons
		//et un autre pour pouvoir centrer le panel
		JPanel conteneurgrid = new JPanel();
		JPanel conteneurbouton = new JPanel();
		
		BorderLayout bl = new BorderLayout();//permet de pourvoir centrer les composants
		GridLayout gl = new GridLayout(6, 1);//permet de contenir les boutons en colonne
		
		//paramètre du conteneur de grid
		conteneurgrid.setBounds(200, 150, 400, 400);//positionnement relatif du conteneur avec ses dimensions
		conteneurgrid.setOpaque(false);
		
		
		
		//paramètre du conteneur de bouton
		gl.setVgap(10);//permet de faire un espacement de 10 entre chaque bouton
		conteneurbouton.setLayout(gl);
		conteneurbouton.setPreferredSize(new Dimension(400,350));//redimensionnement de la fenêtre
		conteneurbouton.setOpaque(false);//transparence de la fenêtre pour avoir le même fond

		
		
		boutonnouvellepartie = new MonochromeButton("Nouvelle partie");
		conteneurbouton.add(boutonnouvellepartie);
		
		boutonreprendrepartie = new MonochromeButton("Reprendre partie");
		conteneurbouton.add(boutonreprendrepartie);
		
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
	
	public MonochromeButton getBoutonNouvellePartie() {
		return boutonnouvellepartie;
	}

	public MonochromeButton getBoutonReprendrePartie() {
		return boutonreprendrepartie;
	}

	public MonochromeButton getBoutonAjouter() {
		return boutonajouter;
	}

	public MonochromeButton getBoutonAide() {
		return boutonaide;
	}
	
	public MonochromeButton getBoutonQuitter() {
		return boutonquitter;
	}

	@Override
	protected void paintComponent(Graphics g) {
		
		g.drawImage(icon.getImage(),0,0,this);
		
	}
}
