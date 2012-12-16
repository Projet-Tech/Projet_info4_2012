package fr.ujm.tse.info4.pgammon.vues;

import java.util.List;

import javax.swing.JPanel;

import fr.ujm.tse.info4.pgammon.gui.TriangleCaseButton;
import fr.ujm.tse.info4.pgammon.models.Case;
import fr.ujm.tse.info4.pgammon.models.CouleurCase;
import fr.ujm.tse.info4.pgammon.models.Partie;
import fr.ujm.tse.info4.pgammon.models.Tablier;

public class VueTablier extends JPanel{
	
	private static final long serialVersionUID = -7479996235423541957L;
	private Partie partie;
	private Tablier tablier;

	public VueTablier(Partie partie) {
		this.partie = partie;
		this.tablier = partie.getTablier();
		build();
	}

	private void build() {
		setLayout(null);
		List<Case> cases = tablier.getListeCase();
		
		for(Case c : cases){
			createTriangle(c.getPosition(),c);
		}
	}

	private void createTriangle(int position, Case c) {
		
		CouleurCase couleur = (position%2==0)?CouleurCase.BLANC:CouleurCase.NOIR;
		TriangleCaseButton triangle = new TriangleCaseButton(c,couleur); 
		triangle.setBounds(0, position*100,32 , 100);
		add(triangle);

		triangle.repaint();
	}
}
