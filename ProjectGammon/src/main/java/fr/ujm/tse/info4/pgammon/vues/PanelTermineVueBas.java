package fr.ujm.tse.info4.pgammon.vues;

import java.awt.Color;

import javax.swing.JPanel;

import fr.ujm.tse.info4.pgammon.gui.ReplayBarr;

public class PanelTermineVueBas extends JPanel{
	/**
	 * Cette classe affiche le revisionnage de la partie en appelant la replay barre
	 */


	private static final long serialVersionUID = -4862879609262291182L;
	private ReplayBarr replayBarr;
	public PanelTermineVueBas(){
		build();
	}

	private void build() {
		setLayout(null);
		setBackground(Color.BLACK);
		replayBarr = new ReplayBarr(null);
		replayBarr.setBounds(0,000,800,300);
		add(replayBarr);
	}
	
	/**
	 * Getter de replay barr
	 * @return retourne la classe de replay barr
	 */
	public ReplayBarr getReplayBarr() {
		return replayBarr;
	}

}
