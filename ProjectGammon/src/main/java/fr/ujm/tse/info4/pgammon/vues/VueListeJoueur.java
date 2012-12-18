package fr.ujm.tse.info4.pgammon.vues;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;
import java.util.Vector;

import javax.swing.JPanel;

import fr.ujm.tse.info4.pgammon.gui.JoueurCellRenderer;
import fr.ujm.tse.info4.pgammon.gui.MonochromeButton;
import fr.ujm.tse.info4.pgammon.gui.MonochromeListe;
import fr.ujm.tse.info4.pgammon.models.Joueur;
import fr.ujm.tse.info4.pgammon.models.Profils;

public class VueListeJoueur extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9216988183357324981L;
	
	private Profils profil;
	
	private PanelVueListeJoueurDescription panelDescription;
	private MonochromeListe<Joueur> listeJoueur;
	
	private MonochromeButton ajouter;
	private MonochromeButton selectionner;
	private MonochromeButton retour;
	
	
	public VueListeJoueur(Profils mp){
		profil = mp;
		build();
		
	}
	
	
	private void build() {
		setLayout(null);
		setOpaque(false);
		
		
		panelDescription = new PanelVueListeJoueurDescription(profil.getList().get(1));
		panelDescription.setBounds(420, 50, 330, 450);
		add(panelDescription);
		
		listeJoueur = new MonochromeListe<>("Joueurs enregistrés",new Vector<Joueur>(profil.getList()),new JoueurCellRenderer());
		listeJoueur.setBounds(40, 50, 330, 450);
		add(listeJoueur);
		
		ajouter = new MonochromeButton("Ajouter un nouveau joueur");
		ajouter.setBounds(50, 530, 300, 50);
		add(ajouter);
		
		selectionner = new MonochromeButton("Selectionner");
		selectionner.setBounds(420, 530, 150, 50);
		add(selectionner);
		
		retour = new MonochromeButton("Retour");
		retour.setBounds(600, 530, 150, 50);
		add(retour);
		
		
		
		
	}
	
	


	public Profils getProfil() {
		return profil;
	}


	public PanelVueListeJoueurDescription getPanelDescription() {
		return panelDescription;
	}


	public MonochromeListe<Joueur> getListeJoueur() {
		return listeJoueur;
	}


	public MonochromeButton getAjouter() {
		return ajouter;
	}


	public MonochromeButton getSelectionner() {
		return selectionner;
	}


	public MonochromeButton getRetour() {
		return retour;
	}


	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create(); 
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
		
		Paint p;
		int h = getHeight(); 
		int w = getWidth(); 
		
		// Arriere plan
		p = new RadialGradientPaint(new Point2D.Double(getWidth() / 2.0,
                getHeight() / 2.0), 
                getHeight(),
                new float[] { 0.0f, 0.8f },
                new Color[] { new Color(0x333333), new Color(0x000000) },
                RadialGradientPaint.CycleMethod.NO_CYCLE);
		
		g2.setPaint(p); 
		g2.fillRect(0, 0, w, h); 
		
		// Bordure
		p = new Color(0x808080);
		g2.setStroke(new BasicStroke(5.0f) );
		g2.setPaint(p); 
		g2.drawRect(2, 0, w - 5 , h - 5 );
		
		
		g2.dispose(); 
		
	}

}
