package fr.ujm.tse.info4.pgammon.controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import fr.ujm.tse.info4.pgammon.models.CouleurCase;
import fr.ujm.tse.info4.pgammon.models.Joueur;
import fr.ujm.tse.info4.pgammon.models.NiveauAssistant;
import fr.ujm.tse.info4.pgammon.models.ParametreJeu;
import fr.ujm.tse.info4.pgammon.vues.VueIntermediairePartie;

public class ControleurIntermediairePartie implements Controleur{

	private ControleurPrincipal controleurPrincipal;
	private ControleurIntermediairePartie controleurIntermediairePartie;
	private boolean isNouvellePartie;
	private VueIntermediairePartie vueCreationPartie;
	private JFrame frame;
	private CouleurCase joueurEnCourDeModification;
	
	public ControleurIntermediairePartie(boolean isNouvellePartie,ControleurPrincipal controleurPrincipal)
	{
		this.controleurPrincipal = controleurPrincipal;
		this.isNouvellePartie = isNouvellePartie;
		controleurIntermediairePartie = this;
		vueCreationPartie = new VueIntermediairePartie(this.isNouvellePartie);
		controleurPrincipal.getFrame().setContentPane(vueCreationPartie);
		frame = controleurPrincipal.getFrame();
		build();
	}
	
	public void build()
	{
		listenerRetour();
		listenerCommencer();
		listenerCommencerCharger();
		listenerChargerJoueur1();
		listenerChargerJoueur2();
	}
	
	public void listenerRetour()
	{
		vueCreationPartie.getBoutonRetour().addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				vueCreationPartie.setVisible(false);
				controleurPrincipal.retour();
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
	
	public void listenerCommencer()
	{
		vueCreationPartie.getVueNouvelleSession().getBoutoncommencer().addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				int temp = vueCreationPartie.getVueNouvelleSession().getPanelparamètre().getNbTemps()*1000;
				int nbPartie = vueCreationPartie.getVueNouvelleSession().getPanelparamètre().getNbParties();
				boolean videau = vueCreationPartie.getVueNouvelleSession().getPanelparamètre().getVideau().isSelected();
				
				//TODO gerer dynamiquement les joueurs
				Joueur jBlanc =  vueCreationPartie.getVueNouvelleSession().getPaneljoueur1().getJoueur();
				Joueur jNoir = vueCreationPartie.getVueNouvelleSession().getPaneljoueur2().getJoueur();
				
				//Creation des paramétres de jeu.
				ParametreJeu param = new ParametreJeu(temp,nbPartie,videau,jBlanc,jNoir);
				vueCreationPartie.setVisible(false);
				controleurPrincipal.nouvelleSession(param);
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
	
	public void listenerCommencerCharger()
	{
		vueCreationPartie.getVueChargerPartie().getBoutonCommencer().addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				vueCreationPartie.setVisible(false);
				controleurPrincipal.chargerSession(vueCreationPartie.getVueChargerPartie().getSession());
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
	


	public void  listenerChargerJoueur1(){
		vueCreationPartie.getVueNouvelleSession().getBoutonChangerJoueurBlanc().addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				vueCreationPartie.setVisible(false);
				ControleurListeJoueur controleurListeJoueur = new ControleurListeJoueur(true,controleurIntermediairePartie);
				joueurEnCourDeModification = CouleurCase.BLANC;
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
	
	public void  listenerChargerJoueur2(){
		vueCreationPartie.getVueNouvelleSession().getBoutonChangerJoueurNoir().addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				vueCreationPartie.setVisible(false);
				ControleurListeJoueur controleurListeJoueur = new ControleurListeJoueur(true,controleurIntermediairePartie);
				joueurEnCourDeModification = CouleurCase.NOIR;
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
	
	@Override
	public Controleur getControleur() {
		return this;
	}
	
	@Override
	public JFrame getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}

	@Override
	public void retour() {
		getFrame().setContentPane(vueCreationPartie);
		vueCreationPartie.setVisible(true);

		//build();
	}
	
	public void retour(Joueur j) {
		getFrame().setContentPane(vueCreationPartie);
		vueCreationPartie.setVisible(true);
		if (joueurEnCourDeModification == CouleurCase.BLANC)
			vueCreationPartie.getVueNouvelleSession().setJoueur1(j);
		else
			vueCreationPartie.getVueNouvelleSession().setJoueur2(j);
		//TODO  mettre a jour la fenétre
		//build();
	}
	
	
}
