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
import fr.ujm.tse.info4.pgammon.models.Session;

public class VueChargerPartie extends JPanel{

	private static final long serialVersionUID = 2698819973936287585L;
	
	private MonochromeButton boutonCommencer;
	
	private Session session;
	
	private MonochromeListe<Session>  sessions;
	
	private PanelParametresVueCharger panelParametresVueCharger;
	
	public VueChargerPartie(){
		
		build();
	}

	private void build() {
		setLayout(null);	
		setOpaque(false);
		
		panelParametresVueCharger = new PanelParametresVueCharger();
		panelParametresVueCharger.setBounds(450, 35, 300, 340);
		add(panelParametresVueCharger);
		
		
		//il faut que j'ajoute les sessions
		
		//sessions = new MonochromeListe<>("Parties enregistrées",new Vector<Session>(session.ge),new SessionCellRenderer());
		//sessions.setBounds(40, 50, 330, 450);
		//add(sessions);
		
		
		boutonCommencer = new MonochromeButton("Commencer");
		boutonCommencer.setBounds(300, 440, 200, 50);
		add(boutonCommencer);
		
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
