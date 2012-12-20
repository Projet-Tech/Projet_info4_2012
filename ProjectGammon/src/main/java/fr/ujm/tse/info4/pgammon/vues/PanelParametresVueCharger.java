package fr.ujm.tse.info4.pgammon.vues;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
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
import fr.ujm.tse.info4.pgammon.gui.Avatar;
import fr.ujm.tse.info4.pgammon.gui.ImageAvatar;
import fr.ujm.tse.info4.pgammon.gui.MonochromeLabel;
import fr.ujm.tse.info4.pgammon.gui.MonochromePanel;
import fr.ujm.tse.info4.pgammon.models.CouleurCase;
import fr.ujm.tse.info4.pgammon.models.Joueur;
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
	
	private ImageAvatar imgjoueurBlanc;
	private ImageAvatar imgjoueurNoir;
	
	private JLabel nomJoueurBlanc;
	private JLabel nomJoueurNoir;
	
	public static final String pionblanc = "images/big_pion_blanc.png";
	public static final String pionnoir = "images/big_pion_noir.png";
	private ImageIcon imgpionBlanc;
	private ImageIcon imgpionNoir;
	
	
	public PanelParametresVueCharger(Session s){
		super("Paramètres");
		session = s;
		
		build();
	}
	
	public void setSession(Session s){
		session=s;
		updateData();
	}
	
	public void updateData(){
		lab_parties.setText(new Integer(session.getParametreSession().getNbrPartieGagnante()/1000).toString());
		lab_temps.setText(new Integer(session.getParametreSession().getSecondesParTour()/1000).toString());
		scorej1.setScore(session.getScores().get(session.getPartieEnCours().getParametreJeu().getJoueurBlanc()));
		scorej2.setScore(session.getScores().get(session.getPartieEnCours().getParametreJeu().getJoueurNoir()));
		imgjoueurBlanc.setPath(session.getPartieEnCours().getParametreJeu().getJoueurBlanc().getImageSource());
		imgjoueurNoir.setPath(session.getPartieEnCours().getParametreJeu().getJoueurNoir().getImageSource());
		nomJoueurBlanc.setText(session.getPartieEnCours().getParametreJeu().getJoueurBlanc().getPseudo());
		nomJoueurNoir.setText(session.getPartieEnCours().getParametreJeu().getJoueurNoir().getPseudo());
		
		if(session.getPartieEnCours().getParametreJeu().isUtiliseVideau() == true){
			text_videau.setText("Le videau est utilisé");
		}
		else{
			text_videau.setText("Le videau n'est pas utilisé");
		}
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
				
				
				
			lab_parties = new MonochromeLabel(new Integer(session.getParametreSession().getNbrPartieGagnante()/1000).toString());
			lab_parties.setBounds(20, 290, 110, 40);
			add(lab_parties);
				
			lab_temps = new MonochromeLabel(new Integer(session.getParametreSession().getSecondesParTour()/1000).toString());
			lab_temps.setBounds(170, 290, 110, 40);
			add(lab_temps);
			
			
			scorej1 = new AfficheurScore(session.getScores().get(session.getPartieEnCours().getParametreJeu().getJoueurBlanc()), CouleurCase.BLANC);
			scorej1.setBounds(95, 70, 40, 40);
			add(scorej1);
			
			scorej2 = new AfficheurScore(session.getScores().get(session.getPartieEnCours().getParametreJeu().getJoueurNoir()), CouleurCase.NOIR);
			scorej2.setBounds(160, 70, 40, 40);
			add(scorej2);
			
			imgjoueurBlanc = new ImageAvatar(session.getPartieEnCours().getParametreJeu().getJoueurBlanc().getImageSource());
			imgjoueurBlanc.setBounds(15, 70, 70, 70);
			add(imgjoueurBlanc);
			
			imgjoueurNoir = new ImageAvatar(session.getPartieEnCours().getParametreJeu().getJoueurNoir().getImageSource());
			imgjoueurNoir.setBounds(210, 70, 70, 70);
			add(imgjoueurNoir);
			
			
			text_parties = new JLabel();
			text_parties.setText("<html>Nombre de partie<br> pour la session");
			text_parties.setForeground(new Color(0xCCCCCC));
			text_parties.setBounds(20, 180, 300, 50);
			add(text_parties);
			
			text_temps = new JLabel();
			text_temps.setText("<html>Limitation du temps <br>par tour en seconde");
			text_temps.setForeground(new Color(0xCCCCCC));
			text_temps.setBounds(170, 180, 300, 50);
			add(text_temps);
			
			nomJoueurBlanc = new JLabel();
			nomJoueurBlanc.setText(session.getPartieEnCours().getParametreJeu().getJoueurBlanc().getPseudo());
			nomJoueurBlanc.setForeground(new Color(0xCCCCCC));
			nomJoueurBlanc.setFont(new Font("Arial", Font.BOLD, 22));
			nomJoueurBlanc.setBounds(15, 28, 120, 50);
			add(nomJoueurBlanc);
			
			nomJoueurNoir = new JLabel();
			nomJoueurNoir.setText(session.getPartieEnCours().getParametreJeu().getJoueurNoir().getPseudo());
			nomJoueurNoir.setForeground(new Color(0xCCCCCC));
			nomJoueurNoir.setFont(new Font("Arial", Font.BOLD, 22));
			nomJoueurNoir.setBounds(160, 28, 120, 50);
			add(nomJoueurNoir);
			
			text_videau = new JLabel();
			text_videau.setForeground(new Color(0xCCCCCC));
			text_videau.setBounds(20, 330, 300, 50);
			add(text_videau);
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(iconeparties.getImage(),50,230,this);
		g.drawImage(iconetime.getImage(),200,230,this);
		g.drawImage(imgpionBlanc.getImage(),60,115,this);
		g.drawImage(imgpionNoir.getImage(),187,115,this);
	}
	


}
