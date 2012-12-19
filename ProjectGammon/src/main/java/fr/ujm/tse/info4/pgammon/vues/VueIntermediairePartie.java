package fr.ujm.tse.info4.pgammon.vues;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;

import javax.swing.JPanel;

import fr.ujm.tse.info4.pgammon.gui.MonochromeButton;

public class VueIntermediairePartie extends JPanel{
	private static final long serialVersionUID = -8524922151654361657L;
	
	private VueNouvelleSession vueNouvelleSession;
	private VueChargerPartie vueChargerPartie;
	
	private Boolean fenetreAAfficher;
	
	private MonochromeButton boutonReprendre;
	private MonochromeButton boutonRetour;
	
	private MonochromeButton boutonNouvellePartie;
	
	
	//pasage de parametre de booleen pour savoir quelle fenetre afficher
	public VueIntermediairePartie(Boolean fenetre){
		
		fenetreAAfficher=fenetre;
		build();
		
	}

	private void build() {
		setLayout(null);
		setOpaque(false);
		
		vueNouvelleSession = new VueNouvelleSession();
		vueNouvelleSession.setBounds(0, 80, 800, 520);
		add(vueNouvelleSession);
		
		vueChargerPartie = new VueChargerPartie();
		vueChargerPartie.setBounds(0, 80, 800, 520);
		add(vueChargerPartie);
		
		boutonRetour = new MonochromeButton("Retour");
		boutonRetour.setBounds(550, 15, 200, 50);
		add(boutonRetour);
		
		boutonReprendre = new MonochromeButton("Reprendre");
		boutonReprendre.setBounds(300, 15, 200, 50);
		add(boutonReprendre);
		
		boutonNouvellePartie = new MonochromeButton("Nouvelle partie");
		boutonNouvellePartie.setBounds(50, 15, 200, 50);
		add(boutonNouvellePartie);
		
		
		if(fenetreAAfficher == true){
			vueNouvelleSession.setVisible(true);
			vueChargerPartie.setVisible(false);
		}
		else{
			vueNouvelleSession.setVisible(false);
			vueChargerPartie.setVisible(true);
		}
		
	}

	public VueNouvelleSession getVueNouvelleSession() {
		return vueNouvelleSession;
	}

	public VueChargerPartie getVueChargerPartie() {
		return vueChargerPartie;
	}

	public MonochromeButton getBoutonRetour() {
		return boutonRetour;
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
