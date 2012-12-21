package fr.ujm.tse.info4.pgammon.gui;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;

import javax.swing.JButton;



/**
 * Fond noir avec dégradé
 * @author Jean-Mi
 *
 */
public class OpaqueBG extends JButton {
	private static final long serialVersionUID = 6429362621593431481L;
	public OpaqueBG() {
		super();
		setOpaque(false);
		setLayout(null);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create(); 
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
		
		Paint p;
		int h = getHeight(); 
		int w = getWidth(); 
		
    	g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.9f));

		// Arriere plan
		p = new RadialGradientPaint(new Point2D.Double(getWidth() / 2.0,
                getHeight() / 2.0), 
                getHeight(),
                new float[] { 0.0f, 0.8f },
                new Color[] { new Color(0x333333), new Color(0x000000) },
                RadialGradientPaint.CycleMethod.NO_CYCLE);
		
		g2.setPaint(p); 
		g2.fillRect(0, 0, w, h); 
		
		
		g2.dispose(); 
		
	}
	@Override
	protected void paintBorder(Graphics g) {}
	
}
