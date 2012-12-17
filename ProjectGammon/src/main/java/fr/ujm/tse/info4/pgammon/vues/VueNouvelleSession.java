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

public class VueNouvelleSession extends JPanel{
	
	//déclaration des variables
	private static final long serialVersionUID = -5590865478480555417L;
	
	private MonochromeButton listejoueur;
	private MonochromeButton commencer; 
	private MonochromeButton changercouleur; 

	public VueNouvelleSession(){
			
			build();
		}
	
	private void build() {
		// TODO Auto-generated method stub
		
		//ceci est fait pour pouvoir déplacer nos panels dans le panel
		setLayout(null);
		
		MonochromePanel paneljoueur1 = new MonochromePanel();
		MonochromePanel paneljoueur2 = new MonochromePanel();
		MonochromePanel panelparamètre = new MonochromePanel();
		
		
		 listejoueur = new MonochromeButton();
		 commencer = new MonochromeButton();
		 changercouleur = new MonochromeButton();
		 
		 paneljoueur1.setLayout(new FlowLayout());
		 paneljoueur1.setBounds(50, 50, 200, 100);

		 
		 add(paneljoueur1);
		
		
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
