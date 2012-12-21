package fr.ujm.tse.info4.pgammon.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;

import fr.ujm.tse.info4.pgammon.models.Case;
import fr.ujm.tse.info4.pgammon.models.CouleurCase;
/**
 * Fournie le composant d'affichage des Cases triangles
 * @author Jean-Mi
 *
 */
public class TriangleCaseButton extends CaseButton{
	private static final long serialVersionUID = -7438830652988320775L;
	private CouleurCase couleur;



	private final int MAX_DAMES_DRAWED = 5;
	private final int DAME_SEPARATION = 27;
	
	private boolean isDirectionUp;
	
	/**
	 * Triangle synchronisé avec une case
	 * @param _case Case associée
	 * @param _couleur Couleur physique de la case
	 * @param _isDirectionUp Sens de la case
	 */
	public TriangleCaseButton(Case _case, CouleurCase _couleur,  boolean _isDirectionUp) {
		super(_case);
		couleur = _couleur;
		isDirectionUp = _isDirectionUp;
		build();
	}
	public TriangleCaseButton(Case _case, CouleurCase _couleur) {
		super(_case);
		couleur = _couleur;
		isDirectionUp = true;
		build();
	}
	private void build() {
		setOpaque(false);
		setLayout(null);
		setPreferredSize(new Dimension(33,180));
		
		updateDatas();

		
	}
	
	
	private void updateDatas() {

		
		
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
		/*
		float ratio = 1;
		if(nb_dames>=MAX_DAMES_DRAWED){
			ratio = (float)(MAX_DAMES_DRAWED)/(float)(nb_dames); 
		}
		*/
		ImageIcon icon;
		if(getCase().getCouleurDame() == CouleurCase.VIDE){
			icon = new ImageIcon();
		}
		else if(isPossible()){
			icon = (getCase().getCouleurDame()==CouleurCase.BLANC)?iconeAideBlanc:iconeAideNoir;;
		}else{
			icon = (getCase().getCouleurDame()==CouleurCase.BLANC)?iconeBlanche:iconeNoire;
		}
		
		for(int i=0; i < count ;i++)
		{
			int y;
			if(isDirectionUp)
				y = getHeight()-((i+1)*(DAME_SEPARATION)+(i+1)*(off));
			else
				y = i*(DAME_SEPARATION)+(i+1)*off;
			

			
			g2.drawImage(icon.getImage(),0,y,this);
		}
		if(nb_dames>MAX_DAMES_DRAWED){

			String nb = new Integer(nb_dames).toString();
			g2.setFont(new Font("Arial",Font.BOLD,18));
			
			if(c.getCouleurDame()==CouleurCase.BLANC)
				g2.setColor(new Color(0x111111));
			else
				g2.setColor(new Color(0xCCCCCC));
			int y;
			if(isDirectionUp)
				y = getHeight() - (MAX_DAMES_DRAWED)*(DAME_SEPARATION+off)-6+DAME_SEPARATION;
			else
				y = MAX_DAMES_DRAWED*(DAME_SEPARATION+off)-6;
			
			g2.drawChars(nb.toCharArray(), 0, nb.length(),11-(nb.length()-1)*5, y);
		}

		if(isCandidate() &&  c.getNbDame() > 0){
			int i = count+1;
			int y;
			if(isDirectionUp)
				y = (int) (getHeight()-(i+0.2)*(DAME_SEPARATION)+(i+1)*(-off));
			else
				y = (int) ((i-0.8)*(DAME_SEPARATION)+(i+1)*off);
			ImageIcon iconTransp = (getCase().getCouleurDame()==CouleurCase.BLANC)?iconeBlancheTransp:iconeNoireTransp;
			g2.drawImage(iconTransp.getImage(),0,y,this);
		}
		g2.dispose(); 
	}


	private void drawTriangle(Graphics g) {
		updateDatas();
		Graphics2D g2 = (Graphics2D) g.create(); 
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		Paint p;
		
		int w = getWidth();
		int h = getHeight();
		//Définition du triangle
		int largeurTriangle = w;
		int hauteurTriangle = (int) (h*0.96);
		if(couleur == CouleurCase.BLANC)
			hauteurTriangle *= 0.9;
		
		Point p1;
		Point p2;
		Point p3;

		if(isDirectionUp){
			p1 = new Point((w-largeurTriangle)/2,h);
			 p2 = new Point((w+largeurTriangle)/2,h) ;
			 p3 = new Point(w/2,h-hauteurTriangle);
		}else{
			p1 = new Point((w-largeurTriangle)/2,0);
			 p2 = new Point((w+largeurTriangle)/2,0) ;
			 p3 = new Point(w/2,hauteurTriangle);
		}
		int[] xs = { p1.x, p2.x, p3.x };
		int[] ys = { p1.y, p2.y, p3.y };
		Polygon triangle = new Polygon(xs, ys, xs.length);
		

		
		
		//Tracage du fond.
		if (isPossible()) { 
			p = new Color(0x000099);
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
		if(isPossible())
			p = new Color(0x0000FF);
		else if (model.isPressed()) { 
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
