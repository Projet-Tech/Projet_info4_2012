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

import fr.ujm.tse.info4.pgammon.gui.ChangementTourAnimation;
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
	private ChangementTourAnimation tourAnimation;
	
	
	
	
	private PanelTermineVueDroite paneldroitrevoir;
	
	private PanelEnCoursVueDroite paneldroitencours;
	
	private PanelEnCoursVueBas panelEnCoursVueBas;
	
	
	public VuePartie(Partie partie) {
		this.partie = partie;
		vueTablier = new VueTablier(partie);
		build();
	}
	
	private void build() {

		tourAnimation = new ChangementTourAnimation("", "");

		tourAnimation.setBounds(0,0,800,600);
		add(tourAnimation);
		
		setPreferredSize(new Dimension(800,600));
		setOpaque(false);

		setLayout(null);
		vueTablier.setBounds(173, 30, 547, 446);
		add(vueTablier);
		
		//
		//
		//
		etat=EtatSession.EN_COURS;
		
		
		//creation des panels de la partie
		paneldroitencours = new PanelEnCoursVueDroite();
		paneldroitencours.setBounds(720,0,80,476);
		add(paneldroitencours);
		
		panelEnCoursVueBas = new PanelEnCoursVueBas();
		panelEnCoursVueBas.setBounds(0,505,800,95);
		add(panelEnCoursVueBas);
		
		paneldroitrevoir = new PanelTermineVueDroite();
		paneldroitrevoir.setBounds(720,0,80,476);
		add(paneldroitrevoir);
		
		
		
		//changement des panels en fonctionde l'etat
		if(etat.equals(EtatSession.EN_COURS)){
			
			paneldroitencours.setVisible(true);
			paneldroitrevoir.setVisible(false);
		
		}
		
		else if(etat.equals(EtatSession.TERMINEE)){
		
			paneldroitencours.setVisible(false);
			paneldroitrevoir.setVisible(true);
			
		}
		
etat=EtatSession.EN_COURS;
		
	
		
		
		if(etat.equals(EtatSession.EN_COURS)){
				
			paneldroitencours.setVisible(true);
			paneldroitrevoir.setVisible(false);
		
		}
		
		else if(etat.equals(EtatSession.TERMINEE)){
		
			paneldroitencours.setVisible(false);
			paneldroitrevoir.setVisible(true);
		}
		
	}
	
	
	
	


	public Partie getPartie() {
		return partie;
	}

	public EtatSession getEtat() {
		return etat;
	}


	public VueTablier getVueTablier() {
		return vueTablier;
	}
	
	
	
	public PanelEnCoursVueBas getPanelEnCoursVueBas() {
		return panelEnCoursVueBas;
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


	public void afficherTransition(String titre, String text){
		tourAnimation.end();
		tourAnimation.setText(text);
		tourAnimation.setTitle(titre);
		tourAnimation.restart();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		g.drawImage(img_fond.getImage(),0,0,this);
		super.paintComponent(g);
		
	}
	
	
}
