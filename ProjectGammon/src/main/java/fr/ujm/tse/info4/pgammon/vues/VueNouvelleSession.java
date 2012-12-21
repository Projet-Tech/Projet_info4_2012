package fr.ujm.tse.info4.pgammon.vues;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;

import javax.swing.JPanel;

import fr.ujm.tse.info4.pgammon.gui.IconMonochromeType;
import fr.ujm.tse.info4.pgammon.gui.MonochromeButton;
import fr.ujm.tse.info4.pgammon.gui.MonochromeIconButton;
import fr.ujm.tse.info4.pgammon.gui.MonochromePanel;
import fr.ujm.tse.info4.pgammon.gui.PanelJoueur;
import fr.ujm.tse.info4.pgammon.gui.PanelParametre;
import fr.ujm.tse.info4.pgammon.models.CouleurCase;
import fr.ujm.tse.info4.pgammon.models.Joueur;

public class VueNouvelleSession extends JPanel{
	
	/**
	 * Cette classe reprèsente la vue pour créer une nouvelle session de jeu
	 */
	private static final long serialVersionUID = -5590865478480555417L;
	

	private MonochromeButton boutoncommencer; 
	private MonochromeIconButton boutonchangercouleur; 
	private MonochromeButton boutonRetour;
	private PanelJoueur paneljoueur1;
	private PanelJoueur paneljoueur2;
	private PanelParametre panelparamètre;
	
	private MonochromeButton boutonChangerJoueurBlanc;
	private MonochromeButton boutonChangerJoueurNoir;
	
	private Joueur j1;
	private Joueur j2;

	
	/**
	 * Constructeur de notre classe/vue
	 */
	public VueNouvelleSession(){
			
			build();
		}
	
	
	private void build() {		
		//ceci est fait pour pouvoir déplacer nos panels dans le panel
		setLayout(null);
		
		j1 = null;
		j2 = null;
		
		paneljoueur1 = new PanelJoueur(j1,CouleurCase.BLANC);
		paneljoueur2 = new PanelJoueur(j2,CouleurCase.NOIR);
		panelparamètre = new PanelParametre();
		
		
		boutonRetour = new MonochromeButton("Retour");
		 boutoncommencer = new MonochromeButton("Commencer");
		 
		 boutonchangercouleur = new MonochromeIconButton(IconMonochromeType.SWITCH,"MonochromeIconButton","NOIR");
		 boutonchangercouleur.setSizeBig();
		 boutonchangercouleur.setBounds(10, 34, boutonchangercouleur.getPreferredSize().width, boutonchangercouleur.getPreferredSize().height);
		 add(boutonchangercouleur);
		 
		 boutonChangerJoueurBlanc = new MonochromeButton("Change");
		boutonChangerJoueurBlanc.setBounds(250, 75, 105, 50);
		//boutonChangerJoueurBlanc.setFont(new Font("Arial", Font.PLAIN, 8));
		add(boutonChangerJoueurBlanc);
		
		boutonChangerJoueurNoir = new MonochromeButton("Change");
		boutonChangerJoueurNoir.setBounds(250, 285, 105, 50);
		add(boutonChangerJoueurNoir);
		 
		 
		 paneljoueur1.setBounds(37, 35, 332, 141);
		 
		 paneljoueur2.setBounds(37, 245, 332, 141);
		 
		 panelparamètre.setBounds(420, 35, 344, 352);
		 
		 
		 boutoncommencer.setBounds(200,420,380,58);
		 
		 boutonchangercouleur.setBounds(175,190,55,55);
		 
		 boutonRetour.setBounds(210, 520, 344, 58);
		 
		 add(paneljoueur1);
		 add(paneljoueur2);
		 add(panelparamètre);
		 add(boutoncommencer);
		 add(boutonchangercouleur);
		 add(boutonRetour);
		 
		 listenerboutonchangercouleur();
		
		
	}
	
	
	/**
	 * Getter du bouton pour changer le joueur blanc 
	 * @return retourne la valeur du bouton de changement de joueur blanc
	 */
	public MonochromeButton getBoutonChangerJoueurBlanc() {
		return boutonChangerJoueurBlanc;
	}

	/**
	 * Getter du bouton pour changer le joueur noir
	 * @return retourne la valeur du bouton de changement de joueur noir
	 */
	public MonochromeButton getBoutonChangerJoueurNoir() {
		return boutonChangerJoueurNoir;
	}


	private void listenerboutonchangercouleur()
	{
		boutonchangercouleur.addMouseListener(new MouseListener() {
			
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
				Joueur jou1=j1;
				Joueur jou2=j2;
				setJoueur1(jou2);
				setJoueur2(jou1);
			}
		});
	}
	
	
	/**
	 * Setter du joueur blanc
	 * @param jBlanc Joueur blanc passé en paramètre
	 */
	public void setJoueur1(Joueur jBlanc){
		paneljoueur1.setJoueur(jBlanc);
		j1=jBlanc;
		
	}

	/**
	 * Setter du joueur noir
	 * @param jNoir Joueur noit passé en paramètre
	 */
	public void setJoueur2(Joueur jNoir) {
		paneljoueur2.setJoueur(jNoir);
		j2=jNoir;
		
	}
	
	/**
	 * Getter du bouton commencer partie
	 * @return retourne le bouton commencer
	 */
	public MonochromeButton getBoutoncommencer() {
		return boutoncommencer;
	}

	/**
	 * Getter du bouton changer couleur des joueurs
	 * @return retourne le bouton changer de couleur des joueurs
	 */
	public MonochromeIconButton getBoutonchangercouleur() {
		return boutonchangercouleur;
	}

	/**
	 * Getter du bouton retour menu principal
	 * @return retourne le bouton retour
	 */
	public MonochromeButton getBoutonRetour() {
		return boutonRetour;
	}

	/**
	 * Getter du panel joueur noir permettant l'affichage du panel joueur blanc
	 * @return retourne l'instance du panel paramètre du joueur blanc
	 */
	public PanelJoueur getPaneljoueur1() {
		return paneljoueur1;
	}

	/**
	 * Getter du panel joueur noir permettant l'affichage du panel joueur noir
	 * @return retourne l'instance du panel paramètre du joueur noir
	 */
	public PanelJoueur getPaneljoueur2() {
		return paneljoueur2;
	}

	/**
	 * Getter du panel paramètre permettant l'affichage du panel de paramétrage de partie
	 * @return retourne l'instance du panel paramètre de partie
	 */
	public PanelParametre getPanelparamètre() {
		return panelparamètre;
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
