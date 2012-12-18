package fr.ujm.tse.info4.pgammon.vues;

import javax.swing.JPanel;

import fr.ujm.tse.info4.pgammon.gui.MonochromeButton;

public class VueIntermediairePartie extends JPanel{
	private static final long serialVersionUID = -8524922151654361657L;
	
	private VueNouvelleSession vueNouvelleSession;
	private VueChargerPartie vueChargerPartie;
	
	private Boolean fenetreAAfficher;
	
	private MonochromeButton boutonReprendre;
	private MonochromeButton boutonRetour;
	
	private MonochromeButton boutonNouvellePartie;
	
	
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
		
		boutonRetour = new MonochromeButton("Retour");
		boutonRetour.setBounds(500, 10, 200, 50);
		add(boutonRetour);
		
		boutonReprendre = new MonochromeButton("Reprendre");
		boutonReprendre.setBounds(300, 10, 200, 50);
		add(boutonReprendre);
		
		boutonNouvellePartie = new MonochromeButton("Nouvelle partie");
		boutonNouvellePartie.setBounds(150, 10, 200, 50);
		add(boutonNouvellePartie);
		
		
		if(fenetreAAfficher == true){
			vueNouvelleSession.setVisible(true);
			vueChargerPartie.setVisible(false);
		}
		else{
			vueNouvelleSession.setVisible(false);
			vueChargerPartie.setVisible(true);
		}
		
	}

	public VueNouvelleSession getVueNouvelleSession() {
		return vueNouvelleSession;
	}

	public VueChargerPartie getVueChargerPartie() {
		return vueChargerPartie;
	}

	public MonochromeButton getBoutonRetour() {
		return boutonRetour;
	}

	
	
}
