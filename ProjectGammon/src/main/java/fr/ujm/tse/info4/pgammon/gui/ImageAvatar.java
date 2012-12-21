package fr.ujm.tse.info4.pgammon.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ImageAvatar extends JButton{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8469198767397141845L;
	public static final String AVATAR_PATH = "images/avatars/";
	private ImageIcon icon;
	private String path;
	

	public ImageAvatar(Avatar avatar){
		setEnabled(false);
		this.setAvatar(avatar); 
		setOpaque(false);
	}
	public ImageAvatar(Avatar avatar,boolean isButton){
		setEnabled(isButton);
		this.setAvatar(avatar); 
		setOpaque(false);
	}


	public ImageAvatar(String path){
		setEnabled(false);
		this.setPath(path);
		setOpaque(false);
	}
	
    @Override
    protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create(); 
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
		Paint p;
		
		int tailleBordure = 3;
		int h = getHeight(); 
		int w = getWidth(); 
		
		int iconW = icon.getImage().getWidth(null);
		int iconH = icon.getImage().getHeight(null);
		
		double scaleX = 0, scaleY = 0;
		if(iconW != 2*tailleBordure && iconH != 2*tailleBordure){
			scaleX = (double)h/(double)(iconW-2*tailleBordure);
			scaleY = (double)w/(double)(iconH-2*tailleBordure);
		}
		
		
		// Icone
		AffineTransform at = new AffineTransform(scaleX,0,0,scaleY, tailleBordure,tailleBordure);
		g2.drawImage(icon.getImage(),at,this);
		
		// Bordure
		p = new Color(0xEEEEEE);
		g2.setStroke(new BasicStroke(2*tailleBordure));
		g2.setPaint(p); 
		g2.drawRect(0, 0, w-1 , h-1);
		
		g2.dispose();
    }
    

	public String getPath() {
		return path;
	}

	public void setAvatar(Avatar avatar) {
		this.path = avatar.getPath();
		this.icon = avatar.getIcon();
		repaint();
	}

	public void setPath(String path) {
		if(path == ""){
			setAvatar(Avatar.DEFAULT);
		}
		else{
			this.path = path;
			this.icon = new ImageIcon(path);
			repaint();
		}
	}
	
	
}
