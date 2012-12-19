package fr.ujm.tse.info4.pgammon.controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import org.jdom2.JDOMException;

import fr.ujm.tse.info4.pgammon.models.Joueur;
import fr.ujm.tse.info4.pgammon.models.Profils;
import fr.ujm.tse.info4.pgammon.vues.PanelVueListeJoueurDescription;
import fr.ujm.tse.info4.pgammon.vues.VueAjouterJoueur;
import fr.ujm.tse.info4.pgammon.vues.VueListeJoueur;

public class ControleurListeJoueur {

	private VueListeJoueur vueListeJoueur;
	private ControleurPrincipal controleurPrincipal;
	private Profils profil;
	private VueAjouterJoueur vueAjouterJoueur;
	private PanelVueListeJoueurDescription panelVueListeJoueurDescription;
	
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
		listenerBouttonModifier();
		listenerBouttonSupprimer();
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
	
	public void listenerBouttonModifier(){
		vueListeJoueur.getAjouter().addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				vueListeJoueur.afficheEditerProfil();
				vueAjouterJoueur = vueListeJoueur.getVueAjouterJoueur();
				buildEditerProfilModifier();
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
	
	public void listenerBouttonSupprimer(){
		
	}
	
	
	public void buildEditerProfil(){
		listenerBouttonFermerEditerProfil();
		listenerBouttonEnregistrerEditerProfil();
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

	public void listenerBouttonEnregistrerEditerProfil(){
		vueAjouterJoueur.getenregistrer().addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				Joueur tmpJoueur = new Joueur();
				tmpJoueur.setPseudo(vueAjouterJoueur.getnomPseudo().getText());	
				profil.getList().add(tmpJoueur);
				//vueListeJoueur.updateData();
				vueListeJoueur.masqueEditerProfil();
				//vueListeJoueur.getListeJoueur().getList().updateUI();
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

	public void buildEditerProfilModifier(){
		listenerBouttonFermerEditerProfil();
		listenerBouttonEnregistrerEditerProfil();
	}
}
