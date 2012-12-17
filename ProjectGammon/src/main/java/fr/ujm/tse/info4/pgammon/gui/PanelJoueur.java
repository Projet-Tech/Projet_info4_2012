package fr.ujm.tse.info4.pgammon.gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.ujm.tse.info4.pgammon.models.Joueur;

public class PanelJoueur extends MonochromePanel{
	
	private static final long serialVersionUID = 7553310687895062778L;
	private Joueur joueur;
	private ImageIcon imgjoueur;
	private ImageIcon imgpion;
	private MonochromeCheckbox couppossible;
	private MonochromeCheckbox conseilcoup;
	private JLabel affichestat;
	private JLabel conteneurimgjoueur;
	private JLabel conteneurimgpion;
	
		public PanelJoueur(Joueur j){
			super(j.getPseudo());
			joueur=j;
			joueur = new Joueur();
			build();
			
		}
		
		public void setJoueur(Joueur j){
			joueur=j;
			setTitle(joueur.getPseudo());
		}
		
		public void build(){
			
			
			affichestat = new JLabel();
			conteneurimgjoueur = new JLabel();
			conteneurimgpion = new JLabel();
			couppossible = new MonochromeCheckbox("<html> Afficher les <br> coups possibles");
			conseilcoup = new MonochromeCheckbox("<html> conseiller le <br> prochain coup");
			
			affichestat.setForeground(new Color(0xCCCCCC));
			
			affichestat.setBounds(130, 25, 200, 50);
			affichestat.setFont(new Font("Arial",Font.HANGING_BASELINE,12));
			
			affichestat.setText("<html> Vitoires &nbsp : "
						+new Integer(joueur.getStat().getNbVictoires()).toString()
						+"<br>Défaites : "+joueur.getStat().getNbDefaites()
						);
			
			conseilcoup.setForeground(new Color(0xCCCCCC));
			conseilcoup.setBounds(10, 90, 200, 50);
			conseilcoup.setFont(new Font("Arial",Font.HANGING_BASELINE,12));
			conseilcoup.setOpaque(false);
			
			
			add(conseilcoup);
			add(affichestat);
		}
		

}
