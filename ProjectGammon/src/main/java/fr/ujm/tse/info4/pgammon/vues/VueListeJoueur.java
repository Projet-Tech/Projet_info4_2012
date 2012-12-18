package fr.ujm.tse.info4.pgammon.vues;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import fr.ujm.tse.info4.pgammon.gui.JoueurCellRenderer;
import fr.ujm.tse.info4.pgammon.gui.MonochromeButton;
import fr.ujm.tse.info4.pgammon.gui.MonochromeListe;
import fr.ujm.tse.info4.pgammon.models.Joueur;
import fr.ujm.tse.info4.pgammon.models.Profils;

public class VueListeJoueur extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9216988183357324981L;
	
	private Profils profil;
	private Joueur j;
	
	private PanelVueListeJoueurDescription panelDescription;
	private MonochromeListe<Joueur> listeJoueur;
	
	public VueAjouterJoueur getVueAjouterJoueur() {
		return vueAjouterJoueur;
	}


	private VueAjouterJoueur vueAjouterJoueur;
	
	private MonochromeButton ajouter;
	private MonochromeButton selectionner;
	private MonochromeButton retour;
	private OpaqueBG bg;
	
	public VueListeJoueur(Profils mp){
		profil = mp;
		build();
		
		listeJoueur.getList().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				System.out.println(listeJoueur.getList().getSelectedValue());
				j=listeJoueur.getList().getSelectedValue();
				updateData();
			}
		});
		
		
		
	}
	
	public void afficheEditerProfil(){
		vueAjouterJoueur.setVisible(true);
		bg.setVisible(true);
	}
	
	public void masqueEditerProfil(){
		vueAjouterJoueur.setVisible(false);
		bg.setVisible(false);
	}
	public void updateData(){
		panelDescription.setVisible(true);
		panelDescription.setJoueur(j);
	}
	
	
	private void build() {
		setLayout(null);
		setOpaque(false);
		
		j = new Joueur();
		
		//création de la fenetre d'ajouter joueur

		bg = new OpaqueBG();

		vueAjouterJoueur = new VueAjouterJoueur();
		vueAjouterJoueur.setBounds(200, 150, 400, 300);
		add(vueAjouterJoueur);
		add(bg);
		masqueEditerProfil();
		
		panelDescription = new PanelVueListeJoueurDescription(j);
		panelDescription.setBounds(420, 50, 330, 450);
		add(panelDescription);
		panelDescription.setVisible(false);
		
		listeJoueur = new MonochromeListe<>("Joueurs enregistrés",new Vector<Joueur>(profil.getList()),new JoueurCellRenderer());
		listeJoueur.setBounds(40, 50, 330, 450);
		add(listeJoueur);
		
		ajouter = new MonochromeButton("Ajouter un nouveau joueur");
		ajouter.setBounds(50, 530, 300, 50);
		add(ajouter);
		
		selectionner = new MonochromeButton("Selectionner");
		selectionner.setBounds(420, 530, 150, 50);
		add(selectionner);
		
		retour = new MonochromeButton("Retour");
		retour.setBounds(600, 530, 150, 50);
		add(retour);
		
		
		
	}
	
	
	
	


	public Profils getProfil() {
		return profil;
	}


	public PanelVueListeJoueurDescription getPanelDescription() {
		return panelDescription;
	}

	
	public MonochromeListe<Joueur> getListeJoueur() {
		return listeJoueur;
	}


	public MonochromeButton getAjouter() {
		return ajouter;
	}


	public MonochromeButton getSelectionner() {
		return selectionner;
	}


	public MonochromeButton getRetour() {
		return retour;
	}


	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create(); 

		bg.setBounds(getBounds());
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
		g2.fillRect(0, 0, w, h); 
		
		// Bordure
		p = new Color(0x808080);
		g2.setStroke(new BasicStroke(5.0f) );
		g2.setPaint(p); 
		g2.drawRect(2, 0, w - 5 , h - 5 );
		
		
		g2.dispose(); 
		
	}

}




class OpaqueBG extends JButton {
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
		
    	g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));

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

