package fr.ujm.tse.info4.pgammon.controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import org.jdom2.JDOMException;

import fr.ujm.tse.info4.pgammon.models.Profils;
import fr.ujm.tse.info4.pgammon.vues.VueListeJoueur;

public class ControleurListeJoueur {

	private VueListeJoueur vueListeJoueur;
	private ControleurPrincipal controleurPrincipal;
	private Profils profil;
	
	public ControleurListeJoueur(ControleurPrincipal controleurPrincipal) 
	{
		this.controleurPrincipal = controleurPrincipal;
		//TODO a changer
		profil = Profils.getProfils();
		try {
			profil.charger();
		} catch (JDOMException e) {
			
			//todo message probleme
		}catch (IOException e){
			//todo message probleme
		}
	
		//
		
		vueListeJoueur = new VueListeJoueur(profil);
		controleurPrincipal.getFrame().setContentPane(vueListeJoueur);
		build();
	}
	
	public void build()
	{
		listenerBouttonRetour();

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
}
