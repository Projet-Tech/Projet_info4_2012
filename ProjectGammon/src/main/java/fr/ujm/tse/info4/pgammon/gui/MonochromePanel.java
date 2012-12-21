package fr.ujm.tse.info4.pgammon.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * Panel de base affichant un titre et des un cadre noir.
 * Ce panel a un Layout null.
 * @author Jean-Michel
 *
 */
public class MonochromePanel extends JButton {
	
	public static final int TITLE_HEIGHT = 30;
	
	private static final long serialVersionUID = 1L;
	private String title = "";



	private JLabel title_lbl;
	private JPanel pane;
	/**
	 * Construit un MonochromePanel avec le titre passé en parametre
	 * @param title Titre de la fenetre
	 */
	public MonochromePanel(String title) {
		super();
		this.title = title;
		build();
		
	}


	/**
	 * Construit un MonochromePanel sans titre.
	 * Un emplacement est tout de meme réservé pour le titre
	 */
	public MonochromePanel() {
		super();
		build();
	}
	
	/**
	 * Change le titre du panel.
	 * @param title : Nouveau titre
	 */
	public void setTitle(String title) {
		title_lbl.setText(title);
		this.title = title;
	}
	
	private void build() {


		setOpaque(false);
		setLayout(null);
		title_lbl = new JLabel(title);
		title_lbl.setFont(new Font("Arial", Font.BOLD, 22));
		title_lbl.setForeground(new Color(0xB3B3B3));
		title_lbl.setAlignmentX(0);
		title_lbl.setBounds(0, 0, 400, TITLE_HEIGHT);
		title_lbl.repaint();
		

		pane = new JPanel();
		pane.setBounds(0, TITLE_HEIGHT, getWidth(), getHeight()-TITLE_HEIGHT);
		pane.repaint();

		add(title_lbl);
		add(pane);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create(); 
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
		
		Paint p;
		int h = getHeight(); 
		int w = getWidth(); 
		
		// Arriere plan
		p = new RadialGradientPaint(new Point2D.Double(getWidth() / 2.0,
                getHeight() / 2.0), 
                getHeight(),
                new float[] { 0.0f, 0.8f },
                new Color[] { new Color(0x333333), new Color(0x000000) },
                RadialGradientPaint.CycleMethod.NO_CYCLE);
		
		g2.setPaint(p); 
		g2.fillRect(0, TITLE_HEIGHT, w, h-TITLE_HEIGHT); 
		
		// Bordure
		p = new Color(0x808080);
		g2.setStroke(new BasicStroke(5.0f) );
		g2.setPaint(p); 
		g2.drawRect(2, TITLE_HEIGHT, w - 5 , h - 5 - TITLE_HEIGHT);
		
		
		g2.dispose(); 
		
	}


	@Override
	protected void paintBorder(Graphics g) {
		//super.paintBorder(g);
	}



	
}
