package fr.ujm.tse.info4.pgammon.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.RenderingHints;

import fr.ujm.tse.info4.pgammon.models.Case;
import fr.ujm.tse.info4.pgammon.models.CouleurCase;

public class TriangleCaseButton extends CaseButton{
	private static final long serialVersionUID = -7438830652988320775L;
	private CouleurCase couleur;
	
	public TriangleCaseButton(Case _case, CouleurCase _couleur) {
		super(_case);
		couleur = _couleur;
		setPreferredSize(new Dimension(24,200));

		setOpaque(false);
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		drawTriangle(g);
	}
	
	private void drawTriangle(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g; 
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		Paint p;
		
		
		//Définition du triangle
		int largeurTriangle = 23;
		int hauteurTriangle = (getCouleur() == CouleurCase.BLANC)?170:200;
		
		Point p1 = new Point(0,0);
		Point p2 = new Point(largeurTriangle,0) ;
		Point p3 = new Point(largeurTriangle/2,hauteurTriangle);

		int[] xs = { p1.x, p2.x, p3.x };
		int[] ys = { p1.y, p2.y, p3.y };
		Polygon triangle = new Polygon(xs, ys, xs.length);
		

		
		
		//Tracage du fond.
		if (!model.isEnabled()) { 
			setForeground(Color.GRAY);
			p = new Color(0x444444);
		}else if(model.isPressed())
		{

			p = (getCouleur() == CouleurCase.BLANC)?new Color(0xFFFFFF):new Color(0x777777);
		}
		else{ 
			if (model.isRollover()) { 
				p = (getCouleur() == CouleurCase.BLANC)?new Color(0xEEEEEE):new Color(0x555555);
			} else { 
				p = (getCouleur() == CouleurCase.BLANC)?new Color(0xCECECE):new Color(0x333333);				
			} 
		} 
		g2.setPaint(p);
		g2.fillPolygon(triangle);
		
		// Tracage de la Bordure
		if (model.isPressed()) { 
			p = (getCouleur() == CouleurCase.BLANC)?new Color(0xAAAAAA):new Color(0x666666);
		} else { 
			p = (getCouleur() == CouleurCase.BLANC)?new Color(0x888888):new Color(0x444444);				
		} 
		g2.setStroke(new BasicStroke(2.0f) );
		g2.setPaint(p); 
		g2.drawPolygon(triangle);
		
		
		g2.dispose(); 
	}


	@Override
	protected void paintBorder(Graphics g){
		//super.paintBorder(g);
	}
	
	public CouleurCase getCouleur() {
		return couleur;
	}

	public void setCouleur(CouleurCase couleur) {
		this.couleur = couleur;
	}
}
