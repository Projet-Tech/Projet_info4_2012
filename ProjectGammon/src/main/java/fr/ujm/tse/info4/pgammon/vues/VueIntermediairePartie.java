package fr.ujm.tse.info4.pgammon.vues;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import fr.ujm.tse.info4.pgammon.gui.Avatar;
import fr.ujm.tse.info4.pgammon.gui.MonochromeButton;
import fr.ujm.tse.info4.pgammon.gui.MonochromeVue;
import fr.ujm.tse.info4.pgammon.models.Joueur;
import fr.ujm.tse.info4.pgammon.models.NiveauAssistant;
import fr.ujm.tse.info4.pgammon.models.ParametreJeu;
import fr.ujm.tse.info4.pgammon.models.Session;

public class VueIntermediairePartie extends MonochromeVue{
	private static final long serialVersionUID = -8524922151654361657L;
	
	private VueNouvelleSession vueNouvelleSession;
	private VueChargerPartie vueChargerPartie;
	
	private Boolean fenetreAAfficher;
	
	private MonochromeButton boutonReprendre;
	private MonochromeButton boutonRetour;
	
	private MonochromeButton boutonNouvellePartie;
	
	//TODO a gere dynamiquement
	Joueur jBlanc = new Joueur(1, "ben", Avatar.CHAT_JAUNE.getPath(),NiveauAssistant.NON_UTILISE);
	Joueur jNoir = new Joueur(2, "JM", Avatar.CHEVAL.getPath(), NiveauAssistant.COMPLET);
	
	Joueur jBlanc2 = new Joueur(3, "Benjamin", Avatar.YEUX_ROUGES.getPath(),NiveauAssistant.NON_UTILISE);
	Joueur jNoir2 = new Joueur(4, "Jean", Avatar.FLEUR.getPath(), NiveauAssistant.COMPLET);
	
	ParametreJeu param = new ParametreJeu(0, 5, true, jBlanc, jNoir);
	ParametreJeu param2 = new ParametreJeu(10000, 3, true, jBlanc2, jNoir2);
	ArrayList<Session> listSession;
	
	
	
	//pasage de parametre de booleen pour savoir quelle fenetre afficher
	public VueIntermediairePartie(Boolean fenetre){
		
		fenetreAAfficher=fenetre;
		build();
		
	}

	public Boolean getFenetreAAfficher() {
		return fenetreAAfficher;
	}

	public void setFenetreAAfficher(Boolean fenetreAAfficher) {
		this.fenetreAAfficher = fenetreAAfficher;
	}

	public MonochromeButton getBoutonReprendre() {
		return boutonReprendre;
	}

	public MonochromeButton getBoutonNouvellePartie() {
		return boutonNouvellePartie;
	}

	private void build() {
		setLayout(null);
		setOpaque(false);
		
		listSession = new ArrayList<>();
		
		listSession.add(new Session(1,param));
		listSession.add(new Session(2,param2));
		
		vueNouvelleSession = new VueNouvelleSession();
		vueNouvelleSession.setBounds(0, 80, 794, 495);
		add(vueNouvelleSession);
		
		vueChargerPartie = new VueChargerPartie(listSession);
		vueChargerPartie.setBounds(0, 80, 794, 495);
		add(vueChargerPartie);
		
		boutonRetour = new MonochromeButton("Retour");
		boutonRetour.setBounds(550, 15, 200, 50);
		add(boutonRetour);
		
		//problème sur action de bouton donc effacement de ceux-ci
		
		boutonReprendre = new MonochromeButton("Charger");
		boutonReprendre.setBounds(300, 15, 200, 50);
		add(boutonReprendre);
		boutonReprendre.setVisible(false);
		
		
		
		boutonNouvellePartie = new MonochromeButton("Nouvelle partie");
		boutonNouvellePartie.setBounds(50, 15, 200, 50);
		add(boutonNouvellePartie);
		boutonNouvellePartie.setVisible(false);
		
		if(fenetreAAfficher == true){
			vueNouvelleSession.setVisible(true);

			vueChargerPartie.setVisible(true);
			vueChargerPartie.setVisible(false);
		}
		else{
			vueNouvelleSession.setVisible(false);
			vueChargerPartie.setVisible(true);
		}
		
		listenerboutonReprendre();
		listenerboutonNouvellePartie();
		
	}
	

	private void listenerboutonNouvellePartie()
	{
		boutonNouvellePartie.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				if(fenetreAAfficher == false){
					vueNouvelleSession.setVisible(true);
					vueChargerPartie.setVisible(false);
					fenetreAAfficher=true;
				}
			}
			@Override
			public void mousePressed(MouseEvent e) {}		
			@Override
			public void mouseExited(MouseEvent e) {}			
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}
	
	private void listenerboutonReprendre()
	{
		boutonReprendre.addMouseListener(new MouseListener() {
			
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
				if(fenetreAAfficher == true){
					vueNouvelleSession.setVisible(false);
					vueChargerPartie.setVisible(true);
					fenetreAAfficher=false;
				}
			}
		});
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
