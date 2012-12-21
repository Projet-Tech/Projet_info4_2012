// 
//
//  @ Projet : Project Gammon
//  @ Fichier : ControleurPrincipal.java
//  @ Date : 12/12/2012
//  @ Auteurs : DONG Chuan, BONNETTO Benjamin, FRANCON Adrien, POTHELUNE Jean-Michel
//
//

package fr.ujm.tse.info4.pgammon.controleur;

import java.awt.Container;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;

import javax.swing.JFrame;

import fr.ujm.tse.info4.pgammon.models.Master;
import fr.ujm.tse.info4.pgammon.models.ParametreJeu;
import fr.ujm.tse.info4.pgammon.models.Session;
import fr.ujm.tse.info4.pgammon.vues.VueIntermediairePartie;
import fr.ujm.tse.info4.pgammon.vues.VueMenu;

public class ControleurPrincipal implements Controleur{

	private VueMenu vueMenu;
	private Session session;
	private Master master;
	private JFrame frame;
	private VueIntermediairePartie creationPartie;
	private ControleurPrincipal controleurPrincipal;
	
	public ControleurPrincipal(Master master) {
		this.master = master;
		controleurPrincipal= this;
		frame = new JFrame("jeu de backgammon");
		session =null;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		//frame.setSize(816, 638);
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		Container panel = frame.getContentPane();
		panel.setLayout(new FlowLayout());

		vueMenu = new VueMenu();
		frame.setContentPane(vueMenu);
	
		frame.setVisible(true);

		build();
	}

	public void build() {
		listenerButtonQuitter();
		listenerButtonNouvellePartie();
		listenerButtonReprendrePartie();
		listenerButtonAjouter();
		listenerBoutonAide();
	}

	/**
	 * 
	 * listenerButtonNouvellePartie
	 * 
	 */	
	private void listenerButtonNouvellePartie()
	{
		vueMenu.getBoutonNouvellePartie().addMouseListener(new MouseListener() {
			
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
				vueMenu.setVisible(false);
				ControleurIntermediairePartie controleurIntermediairePartie = new ControleurIntermediairePartie(true,controleurPrincipal);	
			}
		});
	}
	
	private void listenerButtonReprendrePartie()
	{
		vueMenu.getBoutonReprendrePartie().addMouseListener(new MouseListener() {
			
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
				vueMenu.setVisible(false);
				ControleurIntermediairePartie	controleurIntermediairePartie = new ControleurIntermediairePartie(false,controleurPrincipal);
			}
		});
	}
	
	
	private void listenerButtonAjouter()
	{
		vueMenu.getBoutonAjouter().addMouseListener(new MouseListener() {
			
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
				vueMenu.setVisible(false);
				ControleurListeJoueur controleurListeJoueur = new ControleurListeJoueur(false,controleurPrincipal);	
			}
		});
	}
	
	
	/**
	 * 
	 * listenerButtonQuitter
	 * 
	 */
	private void listenerButtonQuitter() {
		vueMenu.getBoutonQuitter().addMouseListener(new MouseListener() {

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
				frame.dispose();
			}
		});
	}
	
	private void listenerBoutonAide(){
		
		vueMenu.getBoutonAide().addMouseListener(new MouseListener() {
			
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
			   
				URI uri = URI.create("http://www.google.fr/url?sa=t&rct=j&q=&esrc=s&source=web&cd=1&ved=0CEoQFjAA&url=http%3A%2F%2Ffr.wikipedia.org%2Fwiki%2FBackgammon&ei=R0XUUM6YL4yHhQelkYHYBQ&usg=AFQjCNEOHnc7riItGN_di3jAPILrXp9twA&sig2=uesTfMvnLMwYI8reGb-vWw&bvm=bv.1355534169,d.ZG4&cad=rja");
				try {
					Desktop.getDesktop().browse(uri);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
	}

	public JFrame getFrame() {
		return frame;
	}
	@Override
	public void retour()
	{
		frame.setContentPane(vueMenu);
		vueMenu.setVisible(true);
	}
	
	public void nouvelleSession(ParametreJeu parametreJeu)
	{
		master.lancerSession(parametreJeu);
		session = master.getSession();
		session.LancerPartie();
		ControleurPartie controleurPartie = new ControleurPartie(session,this);
		
		frame.setContentPane(controleurPartie.getVuePartie());
		
	}
	

	public void finSession()
	{
		master.arreterSession(session.getIdSession());
		//session = master.getSession();
		//session.LancerPartie();
		//ControleurPartie controleurPartie = new ControleurPartie(session,this);
		
		//frame.setContentPane(controleurPartie.getVuePartie());
		
	}
	
	public void chargerSession(Session session)
	{
		master.chargerSession(session);
		session = master.getSession();
		//session.LancerPartie();
		ControleurPartie controleurPartie = new ControleurPartie(session,this);
		
		frame.setContentPane(controleurPartie.getVuePartie());
		
	}

	@Override
	public Controleur getControleur() {
		return this;
	}
}
