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
import fr.ujm.tse.info4.pgammon.gui.PanelJoueur;
import fr.ujm.tse.info4.pgammon.models.CouleurCase;
import fr.ujm.tse.info4.pgammon.models.EtatSession;
import fr.ujm.tse.info4.pgammon.models.Partie;

public class VuePartie extends JPanel{
	private static final long serialVersionUID = 2417367501490643145L;
	
	//recuperation de l'image de fond
	public static final ImageIcon img_fond = new ImageIcon("images/fond_partie.png");
	
	private Partie partie;
	private VueTablier vueTablier;
	private EtatSession etat;
	
	
	
	//composante panel bas
	MonochromeIconButton help;
	MonochromeIconButton plus;
	MonochromeIconButton x_black;
	MonochromeButton scorej1;
	MonochromeButton scorej2;
	
	
	private PanelTermineVueDroite paneldroitrevoir;
	
	private PanelEnCoursVueDroite paneldroitencours;
	
	
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
		
	
		
		
		if(etat.equals(EtatSession.EN_COURS)){
			
			paneldroitencours = new PanelEnCoursVueDroite();
			paneldroitencours.setBounds(720,0,80,476);
			add(paneldroitencours);
		
		
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
		scorej1.setBounds(270, 5, x_black.getPreferredSize().width, x_black.getPreferredSize().height);
		conteneurboutonbasjouerpartie.add(scorej1);
		
		scorej2 = new MonochromeButton("3");
		scorej2.setBounds(350, 5, x_black.getPreferredSize().width, x_black.getPreferredSize().height);
		conteneurboutonbasjouerpartie.add(scorej2);
		
		JLabel labscore = new JLabel("Scores");
		labscore.setForeground(new Color(0xCCCCCC));
		labscore.setBounds(320, 50, 130, 60);
		conteneurboutonbasjouerpartie.add(labscore);
		
		}
		
		else if(etat.equals(EtatSession.TERMINEE)){
		
			paneldroitrevoir = new PanelTermineVueDroite();
			paneldroitrevoir.setBounds(720,0,80,476);
			add(paneldroitrevoir);
			
		}
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

	public MonochromeIconButton getHelp() {
		return help;
	}

	public MonochromeIconButton getPlus() {
		return plus;
	}

	public MonochromeIconButton getX_black() {
		return x_black;
	}


	public VueTablier getVueTablier() {
		return vueTablier;
	}
	
	
	
	
	public PanelEnCoursVueDroite getPaneldroitencours() {
		return paneldroitencours;
	}

	public PanelTermineVueDroite getPaneldroitrevoir() {
		return paneldroitrevoir;
	}

	public void setPaneldroitrevoir(PanelTermineVueDroite paneldroitrevoir) {
		this.paneldroitrevoir = paneldroitrevoir;
	}

	@Override
	protected void paintComponent(Graphics g) {
		
		g.drawImage(img_fond.getImage(),0,0,this);
		super.paintComponent(g);
		
	}
	
	
}
