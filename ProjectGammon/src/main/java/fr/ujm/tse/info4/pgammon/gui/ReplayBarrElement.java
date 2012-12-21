package fr.ujm.tse.info4.pgammon.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import fr.ujm.tse.info4.pgammon.models.CouleurCase;
import fr.ujm.tse.info4.pgammon.models.DeSixFaces;
import fr.ujm.tse.info4.pgammon.models.Deplacement;

public class ReplayBarrElement extends JPanel {
	private static final long serialVersionUID = -6139180165139138217L;
	private CouleurCase couleur;
	private DeSixFaces de;
	private Deplacement deplacement;

	public static final ImageIcon priseNoir = new ImageIcon("images/defaite_pion_noir.png");
	public static final ImageIcon priseBlanc = new ImageIcon("images/defaite_pion_blanc.png");
	public static final ImageIcon rentreeNoir = new ImageIcon("images/victoire_pion_noir.png");
	public static final ImageIcon rentreeBlanc = new ImageIcon("images/victoire_pion_blanc.png");
	public static final ImageIcon impossibleNoir = new ImageIcon("images/coup_impossible_noir.png");
	public static final ImageIcon impossibleBlanc = new ImageIcon("images/coup_impossible_blanc.png");
	
	public ReplayBarrElement( DeSixFaces de , Deplacement deplacement) {
		super();
		this.deplacement = deplacement;
		this.couleur = de.getCouleurDe();
		this.de = de;
		
		build();
	}
	
	private void build() {

		setPreferredSize(new Dimension(30,100));
		setLayout(null);
		DeButton dbtn = new DeButton(de);
		dbtn.setBounds(-1, 0,
				dbtn.getPreferredSize().width , dbtn.getPreferredSize().height);
		add(dbtn);
	}

	@Override
	protected void paintComponent(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g.create(); 
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
 
		int h = getHeight(); 
		int w = getWidth(); 
		
		Paint p;
		
		// Fond
		p = (couleur==CouleurCase.BLANC)?new Color(0xEEEEEE):new Color(0x111111);
		g2.setPaint(p); 
		g2.fillRect(0, 0, w, h); 
		
		ImageIcon icon = new ImageIcon();
		 
		if(deplacement == null){
			icon = (couleur==CouleurCase.BLANC)?impossibleBlanc:impossibleNoir;	
		}
		else{
			if(deplacement.isCaseRentree()){
				icon = (couleur==CouleurCase.BLANC)?rentreeBlanc:rentreeNoir;
			}
			else if(deplacement.isSiCaseBattue()){
				icon = (couleur==CouleurCase.BLANC)?priseBlanc:priseNoir;
			}
		}

		g2.drawImage(icon.getImage(),0,60,this);
		
		g2.dispose();
		
	}
}
