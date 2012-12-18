package fr.ujm.tse.info4.pgammon.vues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.ujm.tse.info4.pgammon.gui.MonochromeButton;
import fr.ujm.tse.info4.pgammon.gui.MonochromeCheckbox;
import fr.ujm.tse.info4.pgammon.gui.MonochromePanel;
import fr.ujm.tse.info4.pgammon.models.CouleurCase;
import fr.ujm.tse.info4.pgammon.models.Joueur;

public class PanelVueListeJoueurDescription extends MonochromePanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7183137442304137995L;
	
	private Joueur joueur;
	
	
	public static final String pionblanc = "images/big_pion_blanc.png";
	public static final String pionnoir = "images/big_pion_noir.png";
	private ImageIcon imgjoueur;
	private ImageIcon imgpion;
	
	
	
	private MonochromeCheckbox coupPossible;
	private MonochromeCheckbox conseilCoup;
	
	private JLabel nomJoueur;
	private JLabel statisitques;
	private JLabel conteneurimgjoueur;
	private JLabel conteneurimgpion;
	
	private MonochromeButton modifier;
	private MonochromeButton supprimer;
	
		public PanelVueListeJoueurDescription(Joueur j){
			super("Description");
			joueur=j;
			
			build();
			updateData();
		}
		
		public void setJoueur(Joueur j){
			joueur=j;
		}
		
		public void updateData(){
			nomJoueur.setText(joueur.getPseudo());
			statisitques.setText("<html>" +new Integer(joueur.getStat().getPartiesJouees()).toString()+
					"<br>"+new Integer(joueur.getStat().getNbVictoires()).toString() +
					"<br>"+new Integer(joueur.getStat().getNbDefaites()).toString() +
					"<br>"+new Float(joueur.getStat().getPourcentageVictoire()).toString() +
					"<br>Ennemi favori" +
					"<br>"+new Float(joueur.getStat().getTempsJeu()).toString());
		}
		
		public void build(){
			
			
			
			JLabel textStat = new JLabel();
			conteneurimgjoueur = new JLabel();
			conteneurimgpion = new JLabel();
			coupPossible = new MonochromeCheckbox("<html> Afficher les <br> coups possibles");
			conseilCoup = new MonochromeCheckbox("<html> conseiller le <br> prochain coup");
			
			JLabel labStat = new JLabel("Statistiques");
			labStat.setForeground(new Color(0xCCCCCC));
			labStat.setBounds(15, 140, 200, 50);
			add(labStat);
			
			
			JLabel labConfig = new JLabel("Configuration de l'assistant");
			labConfig.setForeground(new Color(0xCCCCCC));
			labConfig.setBounds(15, 290, 200, 50);
			add(labConfig);
			
			
			//creation panel pour positionnement text
			JPanel posPseudo = new JPanel();
			
			posPseudo.setLayout(new BorderLayout());
			posPseudo.setBounds(140,40,180,50);
			posPseudo.setOpaque(false);
			
			//label de d'ecriture du nom de joueur 
			nomJoueur = new JLabel();
			nomJoueur.setForeground(new Color(0xCCCCCC));
			nomJoueur.setFont(new Font("Arial", Font.BOLD, 20));
			nomJoueur.setHorizontalAlignment(0);
			add(posPseudo);
			posPseudo.add(nomJoueur);
			
			
			//creation panel pour positionnement text des stats
			JPanel posStat = new JPanel();
			
			posStat.setLayout(new BorderLayout());
			posStat.setBounds(180, 180, 140, 100);
			posStat.setOpaque(false);
			
			//label de d'ecriture du nom de joueur 
			statisitques = new JLabel();
			statisitques.setText("test");
			statisitques.setForeground(new Color(0xCCCCCC));
			statisitques.setFont(new Font("Arial",Font.HANGING_BASELINE,12));
			//statisitques.setHorizontalAlignment(0);
			add(posStat);
			posStat.add(statisitques);
			
			//affichage des stats du joueur
			textStat.setForeground(new Color(0xCCCCCC));
			textStat.setText("<html>Partie jouées" +
					"<br>Victoires" +
					"<br>Défaites" +
					"<br>Pourcentage de victoire" +
					"<br>Ennemi favori" +
					"<br>Temps de jeu");
			textStat.setBounds(15, 130, 140, 200);
			textStat.setFont(new Font("Arial",Font.HANGING_BASELINE,12));
			
			
			//creation composant checbox
			conseilCoup.setForeground(new Color(0xCCCCCC));
			conseilCoup.setBounds(180, 320, 150, 50);
			conseilCoup.setOpaque(false);
			
			//creation composant checbox
			coupPossible.setForeground(new Color(0xCCCCCC));
			coupPossible.setBounds(15, 320, 150, 50);
			coupPossible.setOpaque(false);
			
			//conteneurimgpion
			
			add(coupPossible);
			add(conseilCoup);
			add(textStat);
			
			modifier = new MonochromeButton("Modifier");
			modifier.setBounds(15, 380, 140, 50);
			add(modifier);
			
			supprimer = new MonochromeButton("Supprimer");
			supprimer.setBounds(175, 380, 140, 50);
			add(supprimer);
			
		}
		
		
		
		
		
		public MonochromeButton getModifier() {
			return modifier;
		}

		public MonochromeButton getSupprimer() {
			return supprimer;
		}

		public ImageIcon getImgjoueur() {
			return imgjoueur;
		}

		public void setImgjoueur(ImageIcon imgjoueur) {
			this.imgjoueur = imgjoueur;
		}

		public MonochromeCheckbox getCoupPossible() {
			return coupPossible;
		}

		public void setCoupPossible(MonochromeCheckbox couppossible) {
			this.coupPossible = couppossible;
		}

		public MonochromeCheckbox getConseilCoup() {
			return conseilCoup;
		}

		public void setConseilcoup(MonochromeCheckbox conseilcoup) {
			this.conseilCoup = conseilCoup;
		}


		public Joueur getJoueur() {
			return joueur;
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			
			
		}

}
