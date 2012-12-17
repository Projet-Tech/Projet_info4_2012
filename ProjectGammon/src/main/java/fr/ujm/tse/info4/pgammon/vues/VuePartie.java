package fr.ujm.tse.info4.pgammon.vues;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Paint;
import java.awt.RadialGradientPaint;
import java.awt.geom.Point2D;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.ujm.tse.info4.pgammon.gui.IconMonochromeType;
import fr.ujm.tse.info4.pgammon.gui.MonochromeButton;
import fr.ujm.tse.info4.pgammon.gui.MonochromeIconButton;
import fr.ujm.tse.info4.pgammon.gui.MonochromeLabel;
import fr.ujm.tse.info4.pgammon.models.EtatSession;
import fr.ujm.tse.info4.pgammon.models.Partie;

public class VuePartie extends JPanel{
	private static final long serialVersionUID = 2417367501490643145L;
	
	//recuperation de l'image de fond
	public static final ImageIcon img_fond = new ImageIcon("images/fond_partie.png");
	
	private Partie partie;
	private VueTablier vueTablier;
	private EtatSession etat;
	
	//composant des images de jouer partie
	//composant panel droit
	MonochromeIconButton back;
	MonochromeIconButton dices;
	MonochromeButton videau;
	
	
	//composante panel bas
	MonochromeIconButton help;
	MonochromeIconButton plus;
	MonochromeIconButton x_black;
	MonochromeButton scorej1;
	MonochromeButton scorej2;
	
	//composante des images de revoir partie
	MonochromeIconButton next;
	MonochromeIconButton undo;
	MonochromeIconButton x_white;
	
	
	
	public VuePartie(Partie partie) {
		this.partie = partie;
		vueTablier = new VueTablier(partie);
		build();
	}
	
	private void build() {
		setPreferredSize(new Dimension(800,600));
		setOpaque(false);

		setLayout(null);
		vueTablier.setBounds(173, 30, 547, 446);
		add(vueTablier);
		etat=EtatSession.EN_COURS;
		
		JPanel conteneurboutondroitjouerpartie = new JPanel();
		conteneurboutondroitjouerpartie.setLayout(null);
		conteneurboutondroitjouerpartie.setBounds(720,0,80,476);
		add(conteneurboutondroitjouerpartie);
		
		if(etat.equals(EtatSession.EN_COURS)){
		conteneurboutondroitjouerpartie.setOpaque(false);
		//
		//panel du coté droit
		//
		
		
		//composant et label d'annuler coup
		back = new MonochromeIconButton(IconMonochromeType.RETOUR,"MonochromeIconButton","NOIR");
		back.setSizeBig();
		back.setBounds(10, 34, back.getPreferredSize().width, back.getPreferredSize().height);
		conteneurboutondroitjouerpartie.add(back);
		
		JLabel labback = new JLabel("<html>Annuler<br>coup");
		labback.setBounds(20, 79, 80, 60);
		conteneurboutondroitjouerpartie.add(labback);
		
		
		//composant avec label de lancer de dès
		dices = new MonochromeIconButton(IconMonochromeType.DES,"MonochromeIconButton","NOIR");
		dices.setSizeBig();
		dices.setBounds(10, 259, dices.getPreferredSize().width, dices.getPreferredSize().height);
		conteneurboutondroitjouerpartie.add(dices);
		
		JLabel labdices = new JLabel("<html>Lancer<br>dés");
		labdices.setForeground(new Color(0xCCCCCC));
		labdices.setBounds(20, 304, 80, 60);
		conteneurboutondroitjouerpartie.add(labdices);
		
		//creation composant et label du videau
		//attention ici j'ai pris la largeur et hauteur du dices
		videau = new MonochromeButton("2");
		videau.setBounds(10, 379, dices.getPreferredSize().width, dices.getPreferredSize().height);
		conteneurboutondroitjouerpartie.add(videau);
		
		JLabel labvideau = new JLabel("<html>Lancer<br>videau");
		labvideau.setForeground(new Color(0xCCCCCC));
		labvideau.setBounds(20, 429, 80, 60);
		conteneurboutondroitjouerpartie.add(labvideau);
		
		//
		//panel du bas
		//
		
		JPanel conteneurboutonbasjouerpartie = new JPanel();
		conteneurboutonbasjouerpartie.setLayout(null);
		conteneurboutonbasjouerpartie.setBounds(0,505,800,95);
		conteneurboutonbasjouerpartie.setOpaque(false);
		add(conteneurboutonbasjouerpartie);
		
		//composant et label d'aide
		help = new MonochromeIconButton(IconMonochromeType.AIDE,"MonochromeIconButton","NOIR");
		help.setSizeBig();
		help.setBounds(600, 5, help.getPreferredSize().width, help.getPreferredSize().height);
		conteneurboutonbasjouerpartie.add(help);
		
		JLabel labhelp = new JLabel("Aide");
		labhelp.setForeground(new Color(0xCCCCCC));
		labhelp.setBounds(617, 50, 80, 60);
		conteneurboutonbasjouerpartie.add(labhelp);
		
		//composant et label d'annuler nouvelle session
		plus = new MonochromeIconButton(IconMonochromeType.PLUS,"MonochromeIconButton","NOIR");
		plus.setSizeBig();
		plus.setBounds(700, 5, plus.getPreferredSize().width, plus.getPreferredSize().height);
		conteneurboutonbasjouerpartie.add(plus);
		
		JLabel labplus = new JLabel("Nouvelle session");
		labplus.setForeground(new Color(0xCCCCCC));
		labplus.setBounds(680, 50, 130, 60);
		conteneurboutonbasjouerpartie.add(labplus);
		
		//composant et label d'annuler interrompre session
		x_black = new MonochromeIconButton(IconMonochromeType.X_NOIR,"MonochromeIconButton","NOIR");
		x_black.setSizeBig();
		x_black.setBounds(500, 5, x_black.getPreferredSize().width, x_black.getPreferredSize().height);
		conteneurboutonbasjouerpartie.add(x_black);
		
		JLabel labx_black = new JLabel("Interrompre session");
		labx_black.setForeground(new Color(0xCCCCCC));
		labx_black.setBounds(470, 50, 130, 60);
		conteneurboutonbasjouerpartie.add(labx_black);
		
		
		//composant et label du score
		scorej1 = new MonochromeButton("4");
		scorej1.setBounds(270, 5, dices.getPreferredSize().width, dices.getPreferredSize().height);
		conteneurboutonbasjouerpartie.add(scorej1);
		
		scorej2 = new MonochromeButton("3");
		scorej2.setBounds(350, 5, dices.getPreferredSize().width, dices.getPreferredSize().height);
		conteneurboutonbasjouerpartie.add(scorej2);
		
		JLabel labscore = new JLabel("Scores");
		labscore.setForeground(new Color(0xCCCCCC));
		labscore.setBounds(320, 50, 130, 60);
		conteneurboutonbasjouerpartie.add(labscore);
		
		}
		
		else if(etat.equals(EtatSession.TERMINEE)){
		
			conteneurboutondroitjouerpartie.setForeground(new Color(0xB3B3B3));
			conteneurboutondroitjouerpartie.repaint();
		//bouton pour revoir la partie
		next = new MonochromeIconButton(IconMonochromeType.SUIVANT,"MonochromeIconButton");
		next.setSizeBig();
		next.setBounds(10, 20, next.getPreferredSize().width, next.getPreferredSize().height);
		conteneurboutondroitjouerpartie.add(next);
		
		JLabel labnext = new JLabel("<html>partie<br>suivante");
		labnext.setForeground(new Color(0xCCCCCC));
		labnext.setBounds(15, 70, 80, 60);
		conteneurboutondroitjouerpartie.add(labnext);
		
		undo = new MonochromeIconButton(IconMonochromeType.ANNULER,"MonochromeIconButton");
		undo.setSizeBig();
		undo.setBounds(10, 185, undo.getPreferredSize().width, undo.getPreferredSize().height);
		conteneurboutondroitjouerpartie.add(undo);
		
		JLabel labundo = new JLabel("<html>revoir<br>partie<br>du début");
		labundo.setForeground(new Color(0xCCCCCC));
		labundo.setBounds(10, 240, 80, 60);
		conteneurboutondroitjouerpartie.add(labundo);
		
		x_white = new MonochromeIconButton(IconMonochromeType.X_BLANC,"MonochromeIconButton");
		x_white.setSizeBig();
		x_white.setBounds(10, 350, x_white.getPreferredSize().width, x_white.getPreferredSize().height);
		conteneurboutondroitjouerpartie.add(x_white);
		
		JLabel labx_white = new JLabel("<html>Interrompre<br>la partie");
		labx_white.setForeground(new Color(0xCCCCCC));
		labx_white.setBounds(10, 400, 80, 60);
		conteneurboutondroitjouerpartie.add(labx_white);
		
		}
	}
	
	
	
	public MonochromeButton getVideau() {
		return videau;
	}

	public void setVideau(MonochromeButton videau) {
		this.videau = videau;
	}

	public MonochromeButton getScorej1() {
		return scorej1;
	}

	public void setScorej1(MonochromeButton scorej1) {
		this.scorej1 = scorej1;
	}

	public MonochromeButton getScorej2() {
		return scorej2;
	}

	public void setScorej2(MonochromeButton scorej2) {
		this.scorej2 = scorej2;
	}

	public Partie getPartie() {
		return partie;
	}

	public EtatSession getEtat() {
		return etat;
	}

	public MonochromeIconButton getBack() {
		return back;
	}

	public MonochromeIconButton getDices() {
		return dices;
	}

	public MonochromeIconButton getHelp() {
		return help;
	}

	public MonochromeIconButton getPlus() {
		return plus;
	}

	public MonochromeIconButton getX_black() {
		return x_black;
	}

	public MonochromeIconButton getNext() {
		return next;
	}

	public MonochromeIconButton getUndo() {
		return undo;
	}

	public MonochromeIconButton getX_white() {
		return x_white;
	}

	public VueTablier getVueTablier() {
		return vueTablier;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		g.drawImage(img_fond.getImage(),0,0,this);
		super.paintComponent(g);
		
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
	}
	
	
}
