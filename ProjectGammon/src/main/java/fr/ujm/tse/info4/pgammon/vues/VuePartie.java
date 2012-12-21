package fr.ujm.tse.info4.pgammon.vues;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import fr.ujm.tse.info4.pgammon.gui.HorlogeBarr;
import fr.ujm.tse.info4.pgammon.gui.MonochromeVue;
import fr.ujm.tse.info4.pgammon.models.CouleurCase;
import fr.ujm.tse.info4.pgammon.models.EtatSession;
import fr.ujm.tse.info4.pgammon.models.Partie;

public class VuePartie extends MonochromeVue{
	
	/**
	 * Cette classe nous permet de gérer toute la Vue d'une partie.
	 * Elle est composé de plusieurs autres vues ce qui nous permettra de les gérer
	 */
	private static final long serialVersionUID = 2417367501490643145L;
	
	//recuperation de l'image de fond
	public static final ImageIcon img_fond = new ImageIcon("images/fond_partie.png");
	public static final ImageIcon img_fleche_big = new ImageIcon("images/fleches_big.png");

	private Partie partie;
	private VueTablier vueTablier;
	private EtatSession etat;
	
	
	
	
	
	private PanelTermineVueDroite panelDroitRevoir;
	
	private PanelEnCoursVueDroite panelDroitEnCours;
	
	private PanelEnCoursVueBas panelEnCoursVueBas;
	
	private PanelTermineVueBas panelTermineVueBas;
	
	private PanelJoueurVuePartie panelJoueur1;
	private PanelJoueurVuePartie panelJoueur2;
	private HorlogeBarr horlogeBarr;
	
	/**
	 * Constructeur de la classe VuePartie
	 * Cette fonction permettra de lancer la construction de la page VuePartie
	 * @param partie Il faut un paramètre de partie
	 * 
	 */
	public VuePartie(Partie partie) {
		this.partie = partie;
		vueTablier = new VueTablier(partie);

		setOpaque(false);
		build();
	}
	
	
	/**
	 * Méthode permettant de construire les éléments de la vue et appelant toutes les vues 
	 * de la partie
	 */
	private void build() {
		
		
		setPreferredSize(new Dimension(800,600));
		setOpaque(false);

		setLayout(null);
		vueTablier.setBounds(173, 5, 547, 446);
		add(vueTablier);
		
		
		
		//
		//
		//
		etat=EtatSession.EN_COURS;

		horlogeBarr = new HorlogeBarr(null);
		horlogeBarr.setBounds(122,455,598,20);		
		add(horlogeBarr);
		
		//creation des panels de la partie
		panelDroitEnCours = new PanelEnCoursVueDroite(partie);
		panelDroitEnCours.setBounds(720,0,80,476);
		add(panelDroitEnCours);

		panelTermineVueBas = new PanelTermineVueBas();
		panelTermineVueBas.setBounds(0,480,800,95);
		add(panelTermineVueBas);
		
		panelEnCoursVueBas = new PanelEnCoursVueBas();
		panelEnCoursVueBas.setBounds(0,480,800,95);
		add(panelEnCoursVueBas);
		panelDroitRevoir = new PanelTermineVueDroite();
		panelDroitRevoir.setBounds(720,0,80,476);
		add(panelDroitRevoir);
		
		panelJoueur1 = new PanelJoueurVuePartie(partie.getParametreJeu().getJoueurBlanc(), CouleurCase.BLANC);
		panelJoueur1.setBounds(10, 5, 150, 210);
		add(panelJoueur1);
		
		
		panelJoueur2 = new PanelJoueurVuePartie(partie.getParametreJeu().getJoueurNoir(), CouleurCase.NOIR);
		panelJoueur2.setBounds(10, 235, 150, 215);
		add(panelJoueur2);
		

		setEtat(getEtat());
	}
	

	/**
	 * Getters de partie
	 * Cette méthode retourne une partie
	 * @return Retourne une partie
	 * 
	 */
	public Partie getPartie() {
		return partie;
	}
	

	/**
	 * Setters de partie
	 * Cette méthode permet de changer les valeurs d'une partie
	 * @param partie Passer en paramètre une partie
	 * 
	 */
	public void setPartie(Partie partie) {
		this.partie = partie;
		vueTablier.setVisible(false);
		vueTablier = new VueTablier(partie);
		vueTablier.setBounds(173, 30, 547, 446);
		
		panelDroitEnCours.setPartie(partie);
		add(vueTablier);
		
	}

	/**
	 * Getter de etat session
	 * @return Récupère l'etat de la session
	 */
	public EtatSession getEtat() {
		return etat;
	}

	/**
	 * Setter de l'état de la session 
	 * Cette méthode permet de gérer l'affichage des vues en fonction de l'état de la session
	 * @param etat c'est une énumération de l'état en cours
	 */
	public  void setEtat(EtatSession etat ) {
		this.etat = etat;
		//changement des panels en fonctionde l'etat
		if(etat.equals(EtatSession.EN_COURS)){
			
			panelDroitEnCours.setVisible(true);
			panelDroitRevoir.setVisible(false);
		
		}
		else{
		
			panelDroitEnCours.setVisible(false);
			panelDroitRevoir.setVisible(true);
			
		}
		
		
		if(etat.equals(EtatSession.REPLAY)){
			panelTermineVueBas.setVisible(true);
			panelEnCoursVueBas.setVisible(false);
		}
		else{
			panelTermineVueBas.setVisible(false);
			panelEnCoursVueBas.setVisible(true);
		}
	}
	

	/**
	 * Setter qui change la vue tablier
	 * @return
	 */
	public VueTablier getVueTablier() {
		return vueTablier;
	}
	
	
	/**
	 * Setter qui change la vue basse en état en cours de la partie
	 * @return
	 */
	public PanelEnCoursVueBas getPanelEnCoursVueBas() {
		return panelEnCoursVueBas;
	}

	/**
	 * Getter qui change la vue droite en état en cours de la partie
	 * @return
	 */
	public PanelEnCoursVueDroite getPaneldroitencours() {
		return panelDroitEnCours;
	}

	/**
	 * Getter qui retourne la vue droite en état terminé de la partie
	 * @return
	 */
	public PanelTermineVueDroite getPaneldroitrevoir() {
		return panelDroitRevoir;
	}

	
	/**
	 * Setter qui change la vue droite en état terminé de la partie
	 * @param paneldroitrevoir
	 */
	public void setPaneldroitrevoir(PanelTermineVueDroite paneldroitrevoir) {
		this.panelDroitRevoir = paneldroitrevoir;
	}
	
	
	

	/**
	 * Getter du panel de la vue basse en état terminé de la partie
	 * @return
	 */
	public PanelTermineVueBas getPanelTermineVueBas() {
		return panelTermineVueBas;
	}

	/**
	 * Getter du panel du joueur blanc
	 * @return
	 */
	public PanelJoueurVuePartie getPaneljoueur1() {
		return panelJoueur1;
	}

	/**
	 *  Getter du panel du joueur noir
	 * @return 
	 */
	public PanelJoueurVuePartie getPaneljoueur2() {
		return panelJoueur2;
	}
	
	/**
	 * Surcharge de la méthode de création des composants
	 * Cette methode affichera l'image de fond
	 */
	@Override
	protected void paintComponent(Graphics g) {
		
		g.drawImage(img_fond.getImage(),0,0,this);

		super.paintComponent(g);
		
	}
	
	/**
	 * Renvoie le composant HorlogeBarre de la vue.
	 * @return horlogeBarr : le composant HorlogeBarre de la vue
	 */
	public HorlogeBarr getHorlogeBarr() {
		return horlogeBarr;
	}
	
	
}
