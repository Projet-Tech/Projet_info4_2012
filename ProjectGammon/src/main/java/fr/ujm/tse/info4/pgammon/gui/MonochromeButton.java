package fr.ujm.tse.info4.pgammon.gui;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import javax.swing.ButtonModel;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * Bouton avec extension de design
 * @author Jean-Mi
 *
 */
public class MonochromeButton extends JButton {
	
	private static final long serialVersionUID = 1L;
	String text;
	JLabel label;
	float alpha = 1f;
	
	/**
	 * Nouveau bouton vide.
	 */
	public MonochromeButton(){
		super();
	}
	/**
	 * Nouveau bouton avec texte.
	 * @param str : label du bouton.
	 */
	public MonochromeButton(String str) {

		super();
		text = str;

		build();
	
	}

	/**
	 * Nouveau bouton avec texte.
	 * @param text : label du bouton.
	 * @param icon : Not Implemented yet.
	 */
	public MonochromeButton(String text, Icon icon) {
		super();
		this.text = text;
		build();
	}

	private void build() {
		setOpaque(false);
		label = new JLabel(text);
		label.setFont(new Font("Arial",Font.PLAIN,20));
		label.setPreferredSize(getPreferredSize());
		label.setAlignmentX(CENTER_ALIGNMENT);
		label.setForeground(new Color(0xF2F2F2));
		add(label);
	}
	
	@Override
	public void setPreferredSize(Dimension preferredSize) {
		super.setPreferredSize(preferredSize);
		label.setPreferredSize(preferredSize);
	}
	@Override
	protected void paintComponent(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g.create(); 
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		float alphaCoef = 1;
			if(isEnabled()==false)
				alphaCoef = 0.3f;
    	g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha*alphaCoef));
 
		int h = getHeight(); 
		int w = getWidth(); 
		
		Paint p;
		ButtonModel model = getModel(); 

		
		// Fond
		if (!model.isEnabled()) { 
			setForeground(Color.GRAY);
			p = new Color(0x444444);
		}
		else { 
			if (model.isRollover()) { 
				p = new Color(0x333333);
			} else { 
				p = new Color(0x222222);
			} 
		} 
		g2.setPaint(p); 
		g2.fillRect(0, 0, w, h); 

		 
		// Bordure
		if (model.isPressed()) { 
			p = new Color(0x555555);
		} else { 
			p = new Color(0x888888);
		} 
		g2.setStroke(new BasicStroke(5.0f) );
		g2.setPaint(p); 
		g2.drawRect(1, 1, w - 3, h - 3);
			
		g2.dispose(); 
		
	}
	
	@Override
	protected void paintBorder(Graphics g) {
		
		//super.paintBorder(g);
		
	}
	
	
	/**
	 * Change le texte du bouton
	 */
	@Override
	public void setText(String text){
		this.text = text;
		label.setText(text);
	}
	
	/**
	 * Change la transparence du bouton
	 * @param value : valeur de la transparence entre 0.0f et 1.0f
	 */
	public void setAlpha(float value){
		alpha = value;
	}



}
