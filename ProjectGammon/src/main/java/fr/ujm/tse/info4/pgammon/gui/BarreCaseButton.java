package fr.ujm.tse.info4.pgammon.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;

import fr.ujm.tse.info4.pgammon.models.Case;
import fr.ujm.tse.info4.pgammon.models.CouleurCase;

public class BarreCaseButton extends CaseButton {
	
	private static final long serialVersionUID = 1696544283522096083L;
	private final int MAX_DAMES_DRAWED = 5;
	private final int DAME_SEPARATION = 27;
	
	public BarreCaseButton(Case _case) {
		super(_case);
		build();
	}
	
	private void build() {
		setOpaque(false);
		setLayout(null);
		setPreferredSize(new Dimension(33,150));
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		drawDames(g);
	}
	
	private void drawDames(Graphics g) {
		Case c = getCase();
		if(c == null)
			return;

		int h = getHeight();
		CouleurCase couleurDames = c.getCouleurDame();

		if(couleurDames == CouleurCase.VIDE || c.getNbDame() == 0)
			return;
		
		int nb_dames = c.getNbDame();
		if(isCandidate())
			nb_dames--;

		int count = Math.min(nb_dames, MAX_DAMES_DRAWED);

		
		
		Graphics2D g2 = (Graphics2D) g.create(); 
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		

		int off = 0;
		if(model.isRollover()) off ++;
		if(model.isPressed()) off ++;
		
		float ratio = 1;
		if(nb_dames>=MAX_DAMES_DRAWED){
			ratio = (float)(MAX_DAMES_DRAWED)/(float)(nb_dames); 
		}
		
		ImageIcon icon;
		if(getCase().getCouleurDame() == CouleurCase.VIDE){
			icon = new ImageIcon();
		}else{
			icon = (getCase().getCouleurDame()==CouleurCase.BLANC)?iconeBlanche:iconeNoire;
		}
		
		for(int i=0; i < count ;i++)
		{
			int y = (int) ((h-DAME_SEPARATION)/2+(i-(count-1)/2f)*(DAME_SEPARATION)+off);
			g2.drawImage(icon.getImage(),0,y,this);
		}
		
		if(nb_dames>MAX_DAMES_DRAWED){

			String nb = new Integer(nb_dames).toString();
			g2.setFont(new Font("Arial",Font.BOLD,18));
			
			if(c.getCouleurDame()==CouleurCase.BLANC)
				g2.setColor(new Color(0x111111));
			else
				g2.setColor(new Color(0xCCCCCC));
			int y = (h/2)+6;
			
			g2.drawChars(nb.toCharArray(), 0, nb.length(),11-(nb.length()-1)*5, y);
		}

		if(isCandidate() &&  c.getNbDame() > 0){
			int i = count+1;
			int y = (int) ((i-0.5)*(DAME_SEPARATION)+(i+1)*off);
			g2.drawImage(icon.getImage(),0,y,this);
		}
		g2.dispose(); 
	}

	@Override
	protected void paintBorder(Graphics g) {
		//super.paintBorder(g);
	}
}
