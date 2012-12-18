package fr.ujm.tse.info4.pgammon.vues;

import javax.swing.JPanel;

public class VueIntermediairePartie extends JPanel{
	private static final long serialVersionUID = -8524922151654361657L;
	
	private VueNouvelleSession vueNouvelleSession;
	private VueChargerPartie vueChargerPartie;
	
	private Boolean fenetreAAfficher;
	
	
	//pasage de parametre de booleen pour savoir quelle fenetre afficher
	public VueIntermediairePartie(Boolean fenetre){
		
		fenetreAAfficher=fenetre;
		build();
		
	}

	private void build() {
		setLayout(null);
		setOpaque(false);
		
		vueNouvelleSession = new VueNouvelleSession();
		vueNouvelleSession.setBounds(0, 0, 800, 600);
		add(vueNouvelleSession);
		
		vueChargerPartie = new VueChargerPartie();
		vueChargerPartie.setBounds(0, 0, 800, 600);
		add(vueChargerPartie);
		
		
		if(fenetreAAfficher == true){
			vueNouvelleSession.setVisible(true);
			vueChargerPartie.setVisible(false);
		}
		else{
			vueNouvelleSession.setVisible(false);
			vueChargerPartie.setVisible(true);
		}
		
	}

}
