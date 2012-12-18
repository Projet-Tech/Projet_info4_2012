package fr.ujm.tse.info4.pgammon.controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import fr.ujm.tse.info4.pgammon.vues.VueIntermediairePartie;

public class ControleurIntermediairePartie {

	private ControleurPrincipal controleurPrincipal;
	private boolean isNouvellePartie;
	private VueIntermediairePartie vueCreationPartie;
	
	public ControleurIntermediairePartie(boolean isNouvellePartie,ControleurPrincipal controleurPrincipal)
	{
		this.controleurPrincipal = controleurPrincipal;
		this.isNouvellePartie = isNouvellePartie;
		
		vueCreationPartie = new VueIntermediairePartie(isNouvellePartie);
		controleurPrincipal.getFrame().setContentPane(vueCreationPartie);
		
		build();
	}
	
	public void build()
	{
		listenerVueCreationPartie();
	}
	
	public void listenerVueCreationPartie()
	{
		vueCreationPartie.getVueNouvelleSession().getBoutonRetour().addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				vueCreationPartie.setVisible(false);
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
