package fr.ujm.tse.info4.pgammon.vues;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import fr.ujm.tse.info4.pgammon.models.Partie;

public class VuePartie extends JPanel{
	private static final long serialVersionUID = 2417367501490643145L;
	
	public static final String img_fond = "images/fond_partie.png";
	private ImageIcon imgfond;
	
	private Partie partie;
	private VueTablier vueTablier;
	
	
	public VuePartie(Partie partie) {
		this.partie = partie;
		vueTablier = new VueTablier(partie);
		build();
	}
	
	private void build() {
		setPreferredSize(new Dimension(800,600));
		setOpaque(false);
		//récupération de l'image
				try{
					imgfond = new ImageIcon(img_fond);
				}catch(Exception err){
					System.err.println(err);
				}
				
		setLayout(null);
		vueTablier.setBounds(173, 30, 547, 446);
		add(vueTablier);
	}
	
	public VueTablier getVueTablier() {
		return vueTablier;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		g.drawImage(imgfond.getImage(),0,0,this);
		super.paintComponent(g);
	}
	
	
}
