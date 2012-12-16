package fr.ujm.tse.info4.pgammon.vues;

import javax.swing.JPanel;

import fr.ujm.tse.info4.pgammon.models.Partie;

public class VuePartie extends JPanel{
	private static final long serialVersionUID = 2417367501490643145L;
	private Partie partie;
	private VueTablier vt;
	public VuePartie(Partie partie) {
		this.partie = partie;
		vt = new VueTablier(partie);
		build();
	}
	private void build() {
		add(vt);
	}
	public VueTablier getVt() {
		return vt;
	}
	
	
	
}
