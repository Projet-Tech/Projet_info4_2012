package fr.ujm.tse.info4.pgammon.gui;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;
import java.awt.RenderingHints;

public class ChangementTourAnimation extends TranstionAnimeeBase {
	private static final long serialVersionUID = 2507637341332121993L;
	private char[] c_titre;
	private char[] c_text;
	
	public ChangementTourAnimation(String titre, String text) {
		super(20,2000);
		setTitle(titre);
		setText(text);
		setOpaque(false);
	}
	
	@Override
	public void setText(String text){
		String _texte = text + " - " + text + " - " + text + " - " + text + " - " + text + " - " + text + " - " + text + " - " + text + " - " + text + " - " + text + " - " + text + " - " + text + " - " + text;
		c_text = _texte.toCharArray();
		
	}

	public void setTitle(String title){
		c_titre = title.toCharArray();
	}
	private Point getTitlePosition(){
		return new Point((int) (300 *getWidth()/800* getRapport()-5000*((0.5-getRapport())*(0.5-getRapport())*(0.5-getRapport()))),285 );
	}
	
	
	private Point getTextPosition(){
		return new Point((int) (-200+200 * getRapport()),450 );
	}
	
	private Point getTextPosition2(){
		return new Point((int) (-300+300 * getRapport()),520 );
	}
	
	private float getTitleAlpha(){
		float alpha = 2*(0.5f-getRapport());
		alpha *= alpha;
		alpha = 1-alpha;
		if(alpha<0) alpha = 0;
		if(alpha>1)alpha=1;
		return alpha;
	}
	
	private float getBGAlpha(){
		float alpha = 2*(0.5f-getRapport());
		alpha *= alpha;
		alpha = 1-alpha;
		if(alpha<0) alpha = 0;
		if(alpha>1)alpha=1;
		return alpha;
	}
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		drawFullBackground(g2);
		drawBandeau(g2);
		drawTitle(g2);
		drawText(g2);

		g2.dispose(); 
	}


	private void drawText(Graphics2D g2) {
		
		g2.setFont(new Font("Arial",Font.ITALIC | Font.BOLD,25));
		g2.setColor(new Color(0xFFFFFF));
    	g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, getTitleAlpha()));

		Point p = getTextPosition();
		g2.drawChars(c_text, 0, c_text.length,p.x, p.y);


		g2.setFont(new Font("Arial",Font.ITALIC | Font.BOLD,60));
    	g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, getTitleAlpha()*0.2f));

		p = getTextPosition2();
		//g2.drawChars(c_text, 0, c_text.length,p.x, p.y);
		
		g2.setFont(new Font("Arial",Font.ITALIC | Font.BOLD,80));
		g2.drawChars(c_text, 0, c_text.length,(int) (p.x*1.2), 150);
	}


	private void drawTitle(Graphics2D g2) {
		g2.setFont(new Font("Arial",Font.ITALIC | Font.BOLD,45));
		g2.setColor(new Color(0xFFFFFF));
    	g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, getTitleAlpha()));

		Point p = getTitlePosition();
		g2.drawChars(c_titre, 0, c_titre.length,p.x, p.y);
	}


	private void drawBandeau(Graphics2D g2) {

		//int h = getHeight(); 
		int w = getWidth(); 
		
		Paint p;

    	g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f*getBGAlpha()));
		p = new Color(0x333333);
		 
		g2.setPaint(p); 
		g2.fillRect(0, 200, w, 150); 

    	g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
	}


	private void drawFullBackground(Graphics2D g2) {

		int h = getHeight(); 
		int w = getWidth(); 
		
		Paint p;

    	g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f*getBGAlpha()));
		p = new Color(0);
		g2.setPaint(p); 
		g2.fillRect(0, 0, w, h); 
		
	}
}
