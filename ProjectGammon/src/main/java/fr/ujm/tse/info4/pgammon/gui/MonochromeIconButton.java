package fr.ujm.tse.info4.pgammon.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import fr.ujm.tse.info4.pgammon.models.CouleurCase;

public class MonochromeIconButton extends JButton{
	private static final long serialVersionUID = -8152217751563954978L;
	public static final String BLANC = "BALNC";
	public static final String NOIR  = "NOIR";
	
	private String couleur;
	private ImageIcon icon;
	private JLabel label; 
	
	
	public MonochromeIconButton(String iconRef, String text, String couleur){
		
		this.couleur = couleur;
		
		build(iconRef, text);
		
	}
	
	public MonochromeIconButton(String iconRef, String text){
		
		couleur = BLANC;
		build(iconRef, text);
		
	}

	private void build(String iconRef, String text) {
		try{
			icon = new ImageIcon(iconRef);
		}catch(Exception err){
			//TODO : Creer une icone par défaut
			System.err.println(err);
		}
		label = new JLabel(text);
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g.create(); 
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
		
		int h = getHeight(); 
		int w = getWidth(); 
		
		Paint p;
		
		//Fond
		if (!model.isEnabled()) { 
			setForeground(Color.GRAY);
			p = new Color(0x444444);
		}else{ 
			if (model.isRollover()) 
				p = (couleur.equals(BLANC))?new Color(0xAAAAAA):new Color(0x666666);
			else 
				p = (couleur.equals(BLANC))?new Color(0xCCCCCC):new Color(0x888888);
		} 
		g2.setPaint(p); 
		g2.fillRect(0, 0, w, h); 
		
		
		// Bordure
		if (model.isPressed())
			p = (couleur.equals(BLANC))?new Color(0x777777):new Color(0x333333);
		else 
			p = (couleur.equals(BLANC))?new Color(0x888888):new Color(0x444444);
		g2.setStroke(new BasicStroke(5.0f) );
		g2.setPaint(p); 
		g2.drawRect(0, 0, w-1 , h-1);
		
		// Icone
		g2.drawImage(icon.getImage(),3,3,this);
		
		g2.dispose(); 
	}
	
	@Override
	protected void paintBorder(Graphics g) {
		//super.paintBorder(g);
	}

	public ImageIcon getIcon() {
		return icon;
	}

	public String getLabel() {
		return label.toString();
	}
}
