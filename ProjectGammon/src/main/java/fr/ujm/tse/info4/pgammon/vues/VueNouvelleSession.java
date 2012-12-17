package fr.ujm.tse.info4.pgammon.vues;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;

import javax.swing.JPanel;

import fr.ujm.tse.info4.pgammon.gui.MonochromeButton;
import fr.ujm.tse.info4.pgammon.gui.MonochromePanel;
import fr.ujm.tse.info4.pgammon.gui.PanelJoueur;
import fr.ujm.tse.info4.pgammon.gui.PanelParametre;
import fr.ujm.tse.info4.pgammon.models.Joueur;

public class VueNouvelleSession extends JPanel{
	
	//déclaration des variables
	private static final long serialVersionUID = -5590865478480555417L;
	
	private MonochromeButton listejoueur;
	private MonochromeButton commencer; 
	private MonochromeButton changercouleur; 
	private PanelJoueur paneljoueur1;
	private PanelJoueur paneljoueur2;
	private PanelParametre panelparamètre;
	
	private Joueur j1;
	private Joueur j2;
	
	public VueNouvelleSession(){
			
			build();
		}
	
	private void build() {
		// TODO Auto-generated method stub
		
		//ceci est fait pour pouvoir déplacer nos panels dans le panel
		setLayout(null);
		
		j1 = new Joueur();
		j2 = new Joueur();
		
		paneljoueur1 = new PanelJoueur(j1);
		paneljoueur2 = new PanelJoueur(j2);
		panelparamètre = new PanelParametre();
		
		
		 listejoueur = new MonochromeButton();
		 commencer = new MonochromeButton();
		 changercouleur = new MonochromeButton();
		 
		 
		 paneljoueur1.setBounds(50, 50, 200, 100);
		 
		 
		 paneljoueur2.setBounds(50, 350, 200, 100);
		 
		 
		 panelparamètre.setBounds(400, 50, 200, 400);

		 
		 add(paneljoueur1);
		 add(paneljoueur2);
		 add(panelparamètre);
		
		
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
	
	public void setJoueur1(Joueur jBlanc){
		paneljoueur1.setJoueur(jBlanc);
		j1=jBlanc;
		
	}

	public void setJoueur2(Joueur jNoir) {
		paneljoueur2.setJoueur(jNoir);
		j2=jNoir;
		
	}


}
