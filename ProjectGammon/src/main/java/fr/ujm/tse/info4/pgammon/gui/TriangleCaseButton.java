package fr.ujm.tse.info4.pgammon.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;

import fr.ujm.tse.info4.pgammon.models.Case;
import fr.ujm.tse.info4.pgammon.models.CouleurCase;

public class TriangleCaseButton extends CaseButton{
	private static final long serialVersionUID = -7438830652988320775L;
	private CouleurCase couleur;
	private static final String PION_NOIR_PATH = "images/pion_noir.png";
	private static final String PION_BLANC_PATH = "images/pion_blanc.png";
	
	private final int MAX_DAMES_DRAWED = 6;
	private final int DAME_SEPARATION = 27;
	private ImageIcon icon;
	private Label label;
	
	public TriangleCaseButton(Case _case, CouleurCase _couleur) {
		super(_case);
		couleur = _couleur;
		build();
	}
	private void build() {
		setOpaque(false);
		setLayout(null);
		setPreferredSize(new Dimension(30,200));
		icon = new ImageIcon();
		label = new Label();
		
		updateDatas();

		
	}
	
	//TODO Ecouteur de changement!
	
	private void updateDatas() {
		remove(label);
		if(getCase() == null || getCase().getCouleurDame() == CouleurCase.VIDE){
			icon = new ImageIcon();
			label = new Label();
		}
		else{
			String iconRef = (getCase().getCouleurDame()==CouleurCase.BLANC)?PION_BLANC_PATH:PION_NOIR_PATH;
			try{
				icon = new ImageIcon(iconRef);
			}catch(Exception err){
				//TODO : Creer une icone par défaut
				System.err.println(err);
			}
			/*
			if(getCase().getNbDame()>MAX_DAMES_DRAWED){

				String nb = new Integer(getCase().getNbDame()).toString();
				label = new Label(nb);
				label.setFont(new Font("Arial", Font.BOLD, 15));
				label.setForeground(new Color(0x000000));
				label.setAlignment(CENTER);
				label.setBounds(0,32,40,40);
				label.repaint();
				add(label);
				System.out.println(label.getLocation());
			}
			*/
		}
		

	}
	@Override
	protected void paintComponent(Graphics g) {
		drawTriangle(g);
		drawDames(g);
	}
	
	private void drawDames(Graphics g) {
		Case c = getCase();
		if(c == null)
			return;

		CouleurCase couleurDames = c.getCouleurDame();
		int count = Math.min(c.getNbDame(), MAX_DAMES_DRAWED);
		
		if(couleurDames == CouleurCase.VIDE || count == 0)
			return;
		
		Graphics2D g2 = (Graphics2D) g.create(); 
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		

		int off = 0;
		if(model.isRollover()) off ++;
		if(model.isPressed()) off ++;
		
		for(int i=0; i < count ;i++)
		{
			int y = i*(DAME_SEPARATION)+(i+1)*off;
			g2.drawImage(icon.getImage(),0,y,this);
		}
		if(getCase().getNbDame()>MAX_DAMES_DRAWED){

			String nb = new Integer(getCase().getNbDame()).toString();
			g2.setFont(new Font("Arial",Font.BOLD,18));
			
			if(c.getCouleurDame()==CouleurCase.BLANC)
				g2.setColor(new Color(0x111111));
			else
				g2.setColor(new Color(0xCCCCCC));
			
			g2.drawChars(nb.toCharArray(), 0, nb.length(),11-(nb.length()-1)*5,  MAX_DAMES_DRAWED*(DAME_SEPARATION+off)-6);
			System.out.println();
		}

		g2.dispose(); 
	}


	private void drawTriangle(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g.create(); 
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		Paint p;
		
		int w = getWidth();
		
		//Définition du triangle
		int largeurTriangle = 23;
		int hauteurTriangle = (getCouleur() == CouleurCase.BLANC)?170:200;
		
		Point p1 = new Point((w-largeurTriangle)/2,0);
		Point p2 = new Point((w+largeurTriangle)/2,0) ;
		Point p3 = new Point(w/2,hauteurTriangle);

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
