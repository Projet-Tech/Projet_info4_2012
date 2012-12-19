package fr.ujm.tse.info4.pgammon.vues;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import fr.ujm.tse.info4.pgammon.gui.AfficheurScore;
import fr.ujm.tse.info4.pgammon.gui.MonochromeLabel;
import fr.ujm.tse.info4.pgammon.gui.MonochromePanel;
import fr.ujm.tse.info4.pgammon.models.CouleurCase;
import fr.ujm.tse.info4.pgammon.models.Session;

public class PanelParametresVueCharger extends MonochromePanel{

	
	private static final long serialVersionUID = 7111414911070584708L;
	
	private AfficheurScore scorej1;
	private AfficheurScore scorej2;
	
	private MonochromeLabel lab_parties;
	private MonochromeLabel lab_temps;
	
	private JLabel text_parties;
	private JLabel text_temps;
	private JLabel text_videau;
	
	public static final String imgparties 	= "images/parties.png";
	public static final String imgtime 	= "images/time.png";

	private ImageIcon iconeparties;
	private ImageIcon iconetime;
	
	private Session session;
	
	
	public static final String pionblanc = "images/big_pion_blanc.png";
	public static final String pionnoir = "images/big_pion_noir.png";
	private ImageIcon imgpionBlanc;
	private ImageIcon imgpionNoir;
	
	
	public PanelParametresVueCharger(Session s){
		super("Paramètres");
		session = s;
		
		build();
	}
	
	public void build(){
		
		setLayout(null);
		
		
		//récupération de l'image
				try{
					iconeparties = new ImageIcon(imgparties);
					iconetime = new ImageIcon(imgtime);
					imgpionBlanc = new ImageIcon(pionblanc);
					imgpionNoir = new ImageIcon(pionnoir);
				}catch(Exception err){
					System.err.println(err);
				}
				
				
				
			lab_parties = new MonochromeLabel(new Integer(session.getParametreSession().getNbrPartieGagnante()).toString());
			lab_parties.setBounds(20, 290, 110, 40);
			add(lab_parties);
				
			lab_temps = new MonochromeLabel(new Integer(session.getParametreSession().getSecondesParTour()).toString());
			lab_temps.setBounds(170, 290, 110, 40);
			add(lab_temps);
			
			
			scorej1 = new AfficheurScore(session.getScores().get(session.getPartieEnCours().getParametreJeu().getJoueurBlanc()), CouleurCase.BLANC);
			scorej1.setBounds(95, 70, 40, 40);
			add(scorej1);
			
			scorej2 = new AfficheurScore(session.getScores().get(session.getPartieEnCours().getParametreJeu().getJoueurNoir()), CouleurCase.NOIR);
			scorej2.setBounds(165, 70, 40, 40);
			add(scorej2);
			
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(iconeparties.getImage(),50,230,this);
		g.drawImage(iconetime.getImage(),200,230,this);
		g.drawImage(imgpionBlanc.getImage(),50,110,this);
		g.drawImage(imgpionNoir.getImage(),205,110,this);
	}
	


}
