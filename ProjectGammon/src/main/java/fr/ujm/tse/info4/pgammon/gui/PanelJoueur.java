package fr.ujm.tse.info4.pgammon.gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.LayoutManager;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.ujm.tse.info4.pgammon.models.CouleurCase;
import fr.ujm.tse.info4.pgammon.models.Joueur;

public class PanelJoueur extends MonochromePanel{
	
	private static final long serialVersionUID = 7553310687895062778L;
	private Joueur joueur;
	private CouleurCase couleur;
	
	
	public static final String pionblanc = "images/big_pion_blanc.png";
	public static final String pionnoir = "images/big_pion_noir.png";
	private ImageIcon imgjoueur;
	private ImageIcon imgpion;
	
	
	private MonochromeCheckbox couppossible;
	private MonochromeCheckbox conseilcoup;
	private JLabel affichestat;
	private JLabel conteneurimgjoueur;
	private JLabel conteneurimgpion;
	
		public PanelJoueur(Joueur j,CouleurCase coul){
			super(j.getPseudo());
			joueur=j;
			joueur = new Joueur();
			couleur=coul;
			
			build();
			
		}
		
		public void setJoueur(Joueur j){
			joueur=j;
			setTitle(joueur.getPseudo());
		}
		
		public void build(){
			
			//récupération de l'image
			try{
				if(couleur.equals(CouleurCase.BLANC)){
					imgpion = new ImageIcon(pionblanc);
				}
				else{
					imgpion = new ImageIcon(pionnoir);
				}
				
			}catch(Exception err){
				System.err.println(err);
			}
			
			affichestat = new JLabel();
			conteneurimgjoueur = new JLabel();
			conteneurimgpion = new JLabel();
			couppossible = new MonochromeCheckbox("<html> Afficher les <br> coups possibles");
			conseilcoup = new MonochromeCheckbox("<html> conseiller le <br> prochain coup");
			
			
			
			//affichage des stats du joueur
			affichestat.setForeground(new Color(0xCCCCCC));
			
			affichestat.setBounds(130, 25, 200, 50);
			affichestat.setFont(new Font("Arial",Font.HANGING_BASELINE,12));
			
			affichestat.setText("<html> Vitoires &nbsp : "
						+new Integer(joueur.getStat().getNbVictoires()).toString()
						+"<br>Défaites : "+joueur.getStat().getNbDefaites()
						);
			
			//creation composant checbox
			conseilcoup.setForeground(new Color(0xCCCCCC));
			conseilcoup.setBounds(190, 90, 150, 50);
			conseilcoup.setOpaque(false);
			
			//creation composant checbox
			couppossible.setForeground(new Color(0xCCCCCC));
			couppossible.setBounds(10, 90, 150, 50);
			couppossible.setOpaque(false);
			
			//conteneurimgpion
			
			add(couppossible);
			add(conseilcoup);
			add(affichestat);
		}
		
		
		
		public ImageIcon getImgjoueur() {
			return imgjoueur;
		}

		public void setImgjoueur(ImageIcon imgjoueur) {
			this.imgjoueur = imgjoueur;
		}

		public MonochromeCheckbox getCouppossible() {
			return couppossible;
		}

		public void setCouppossible(MonochromeCheckbox couppossible) {
			this.couppossible = couppossible;
		}

		public MonochromeCheckbox getConseilcoup() {
			return conseilcoup;
		}

		public void setConseilcoup(MonochromeCheckbox conseilcoup) {
			this.conseilcoup = conseilcoup;
		}

		public JLabel getAffichestat() {
			return affichestat;
		}

		public void setAffichestat(JLabel affichestat) {
			this.affichestat = affichestat;
		}

		public Joueur getJoueur() {
			return joueur;
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.drawImage(imgpion.getImage(),250,40,this);
			
			
		}
		

}
