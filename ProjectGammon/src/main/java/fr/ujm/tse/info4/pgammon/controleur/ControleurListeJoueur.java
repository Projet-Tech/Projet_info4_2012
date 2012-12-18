package fr.ujm.tse.info4.pgammon.controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import org.jdom2.JDOMException;

import fr.ujm.tse.info4.pgammon.models.Profils;
import fr.ujm.tse.info4.pgammon.vues.VueAjouterJoueur;
import fr.ujm.tse.info4.pgammon.vues.VueListeJoueur;

public class ControleurListeJoueur {

	private VueListeJoueur vueListeJoueur;
	private ControleurPrincipal controleurPrincipal;
	private Profils profil;
	private VueAjouterJoueur vueAjouterJoueur;
	
	public ControleurListeJoueur(ControleurPrincipal controleurPrincipal) 
	{
		this.controleurPrincipal = controleurPrincipal;
		//TODO a changer
		profil = Profils.getProfils();
		//
		
		vueListeJoueur = new VueListeJoueur(profil);
		controleurPrincipal.getFrame().setContentPane(vueListeJoueur);
		build();
	}
	
	public void build()
	{
		listenerBouttonRetour();
		listenerBouttonAjouter();
	}
	
	
	public void listenerBouttonRetour()
	{
		vueListeJoueur.getRetour().addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				vueListeJoueur.setVisible(false);
				profil.sauvegarder();
				controleurPrincipal.retourMenu();
			}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
		});
	}

	public void listenerBouttonAjouter()
	{
		vueListeJoueur.getAjouter().addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				vueListeJoueur.afficheEditerProfil();
				vueAjouterJoueur = vueListeJoueur.getVueAjouterJoueur();
				buildEditerProfil();
			}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
		});
	}
	
	public void buildEditerProfil(){
		listenerBouttonFermerEditerProfil();
	}
	
	public void listenerBouttonFermerEditerProfil(){
		vueAjouterJoueur.getRetour().addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				vueListeJoueur.masqueEditerProfil();
			}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
		});
	}
}
