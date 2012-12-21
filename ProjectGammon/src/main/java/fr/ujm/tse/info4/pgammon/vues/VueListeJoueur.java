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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import fr.ujm.tse.info4.pgammon.gui.Avatar;
import fr.ujm.tse.info4.pgammon.gui.AvatarList;
import fr.ujm.tse.info4.pgammon.gui.ImageAvatar;
import fr.ujm.tse.info4.pgammon.gui.JoueurCellRenderer;
import fr.ujm.tse.info4.pgammon.gui.MonochromeButton;
import fr.ujm.tse.info4.pgammon.gui.MonochromeListe;
import fr.ujm.tse.info4.pgammon.gui.MonochromeVue;
import fr.ujm.tse.info4.pgammon.gui.OpaqueBG;
import fr.ujm.tse.info4.pgammon.models.Joueur;
import fr.ujm.tse.info4.pgammon.models.Profils;

public class VueListeJoueur extends MonochromeVue{

	/**
	 * Cette classe permet de faire la visualisation de la vue liste joueur
	 * Elle comporte d'autres classe comme panel vue liste joueur description et la monochrome liste
	 */
	private static final long serialVersionUID = 9216988183357324981L;
	
	private Profils profil;
	private Joueur j;
	
	private PanelVueListeJoueurDescription panelDescription;
	private MonochromeListe<Joueur> listeJoueur;
	
	private String path = "";


	private VueAjouterJoueur vueAjouterJoueur;
	private MonochromeButton boutonAjouter;
	private MonochromeButton boutonSelectionner;
	private MonochromeButton boutonRetour;
	private OpaqueBG bg;
	
	private AvatarList listeAvatar;
	
	private ImageAvatar imgjoueur;
	
	/**
	 * Constructeur de la classe
	 */
	public VueListeJoueur(){
		
		profil = Profils.getProfils();
		build();
		
		listeJoueur.getList().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (listeJoueur.getList().getSelectedValue() !=null){
					j=listeJoueur.getList().getSelectedValue();
					System.out.println(j);
					updateData();
						
				}
			}
		});
		
		
		
	}
	
	/**
	 * 
	 */
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
		updateListe();
	}
	
	
	private void build() {
		setLayout(null);
		setOpaque(false);
		
		j = null;
		
		//création de la fenetre d'ajouter joueur

		bg = new OpaqueBG();
		
		listeAvatar = new AvatarList();
		listeAvatar.setBounds(0, 0, 800, 600);
		add(listeAvatar);
		listeAvatar.setVisible(false);

		vueAjouterJoueur = new VueAjouterJoueur();
		vueAjouterJoueur.setBounds(200, 150, 400, 300);
		add(vueAjouterJoueur);
		add(bg);
		masqueEditerProfil();
		
		panelDescription = new PanelVueListeJoueurDescription(j);
		panelDescription.setBounds(420, 50, 330, 450);
		add(panelDescription);
		panelDescription.setVisible(false);
		
		listeJoueur = new MonochromeListe<>("Joueurs enregistrés",profil.getList(),new JoueurCellRenderer());
		listeJoueur.setBounds(40, 50, 330, 450);
		add(listeJoueur);
		
		boutonAjouter = new MonochromeButton("Ajouter un nouveau joueur");
		boutonAjouter.setBounds(50, 530, 300, 50);
		add(boutonAjouter);
		
		boutonSelectionner = new MonochromeButton("Selectionner");
		boutonSelectionner.setBounds(420, 530, 150, 50);
		add(boutonSelectionner);
		
		boutonRetour = new MonochromeButton("Retour");
		boutonRetour.setBounds(600, 530, 150, 50);
		add(boutonRetour);
		
		listenerchangerAvatar();
		listenerAjouterAvatar();
	}
	
	private void listenerAjouterAvatar(){
	
		listeAvatar.getAjouter().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				path = listeAvatar.getPath();
				
				vueAjouterJoueur.setPath(path);
				listeAvatar.setVisible(false);
				updateListe();
			}
		});
	
	}
	
	private void listenerchangerAvatar()
	{
		vueAjouterJoueur.getchangerAvatar().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}		
			@Override
			public void mouseExited(MouseEvent e) {}			
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				listeAvatar.setVisible(true);
			}
		});
	}
	
	public void updateListe(){
		listeJoueur.updateList(new JoueurCellRenderer());
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
		return boutonAjouter;
	}


	public MonochromeButton getSelectionner() {
		return boutonSelectionner;
	}


	public MonochromeButton getRetour() {
		return boutonRetour;
	}
	
	public VueAjouterJoueur getVueAjouterJoueur() {
		return vueAjouterJoueur;
	}
	
	

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Joueur getJ() {
		return j;
	}
	
	

	public void setJ(Joueur j) {
		this.j = j;
		updateData();
	}

	public AvatarList getListeAvatar() {
		return listeAvatar;
	}

	public ImageAvatar getImgjoueur() {
		return imgjoueur;
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


