package fr.ujm.tse.info4.pgammon.controleur;

import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentSkipListSet;

import javax.swing.JFrame;

import fr.ujm.tse.info4.pgammon.models.Joueur;
import fr.ujm.tse.info4.pgammon.models.Profils;
import fr.ujm.tse.info4.pgammon.vues.VueAjouterJoueur;
import fr.ujm.tse.info4.pgammon.vues.VueListeJoueur;

public class ControleurListeJoueur implements Controleur{

	private VueListeJoueur vueListeJoueur;
	private Controleur controleur;
	private Profils profil;
	private VueAjouterJoueur vueAjouterJoueur;
	private Boolean flag = true;
    private Integer id = 0;
    private boolean isCharger;
    private JFrame frame;
    
	public ControleurListeJoueur (boolean isCharger,Controleur controleur) 
	{
		this.controleur = controleur;
		//TODO a changer
		profil = Profils.getProfils();
		//
		
		this.isCharger = isCharger;
		
		vueListeJoueur = new VueListeJoueur(profil);
		controleur.getControleur().getFrame().setContentPane(vueListeJoueur);
		build();
	}
	
	
	
	public void build()
	{
		listenerBouttonRetour();
		listenerBouttonAjouter();
		listenerBouttonModifier();
		listenerBouttonSupprimer();
		listenerBouttonSelection();
	}
	public void listenerBouttonSelection()
	{
		if (isCharger)
		{
			vueListeJoueur.getSelectionner().addMouseListener(new MouseListener() {
				
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
					if (isCharger)
					{
						if (vueListeJoueur.getPanelDescription().getJoueur() !=null){
							Joueur j=vueListeJoueur.getPanelDescription().getJoueur();
							((ControleurIntermediairePartie)controleur).retour(j);
							vueListeJoueur.setVisible(false);
							profil.sauvegarder();
						}
						else
						{
							//vueListeJoueur.afficherFenetreDemande("Accepter vous le videau ?", null).addActionListener(new ActionListener() {
						}
					}
					else
					{
						vueListeJoueur.setVisible(false);
						profil.sauvegarder();
						controleur.retour();
					}
				}
			});
		}
		else
			vueListeJoueur.getSelectionner().setVisible(false);
	}
	public void listenerBouttonRetour()
	{
		vueListeJoueur.getRetour().addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				vueListeJoueur.setVisible(false);
				profil.sauvegarder();
				controleur.retour();
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
				
				flag = true;
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
		vueListeJoueur.getPanelDescription().getModifier().addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				vueListeJoueur.afficheEditerProfil();
				vueAjouterJoueur = vueListeJoueur.getVueAjouterJoueur();
				vueAjouterJoueur.setPath(vueListeJoueur.getPanelDescription().getJoueur().getImageSource());
				flag = false;
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
	
	public void listenerBouttonSupprimer(){
		vueListeJoueur.getPanelDescription().getSupprimer().addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				profil.supprimer(vueListeJoueur.getPanelDescription().getJoueur());
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
		
		if(flag){
			vueAjouterJoueur.getnomPseudo().setText("");
		}else{
			vueAjouterJoueur.getnomPseudo().setText(vueListeJoueur.getPanelDescription().getJoueur().getPseudo());
		}
		
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

			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				vueAjouterJoueur.setPath(vueListeJoueur.getPanelDescription().getJoueur().getImageSource());
				if(flag){
					boolean drapeau = true;
					
					Joueur tmpJoueur = new Joueur();		 
					tmpJoueur.setPseudo(vueAjouterJoueur.getnomPseudo().getText());	
					tmpJoueur.setImageSource(vueListeJoueur.getVueAjouterJoueur().getChemin());
					Date date = new Date();
					id = 10000*date.getMonth()+1000*date.getDay()+100*date.getHours()+10*date.getMinutes()+date.getSeconds();
					
					tmpJoueur.setId(id);
					
					for(int i=0;i<profil.getList().size();i++){
						if((int)tmpJoueur.getId()== (int)profil.getList().get(i).getId()){
							drapeau = false;
						}
					}
					
					if(drapeau){
						profil.getList().add(tmpJoueur);
						//System.out.println("what !!!!!!!!");
						profil.afficher();
					}
					
				}else{
					vueListeJoueur.getPanelDescription().getJoueur().setPseudo(vueAjouterJoueur.getnomPseudo().getText());
					vueListeJoueur.getPanelDescription().getJoueur().setImageSource(vueListeJoueur.getVueAjouterJoueur().getChemin());
				}
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



	@Override
	public Controleur getControleur() {
		return this;
	}
	
	@Override
	public JFrame getFrame() {
		return frame;
	}



	@Override
	public void retour() {
		// TODO Auto-generated method stub
		
	}

				
	
}
