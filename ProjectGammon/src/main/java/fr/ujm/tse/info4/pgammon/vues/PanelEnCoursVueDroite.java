package fr.ujm.tse.info4.pgammon.vues;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.ujm.tse.info4.pgammon.gui.AfficheurScore;
import fr.ujm.tse.info4.pgammon.gui.IconMonochromeType;
import fr.ujm.tse.info4.pgammon.gui.MonochromeButton;
import fr.ujm.tse.info4.pgammon.gui.MonochromeIconButton;
import fr.ujm.tse.info4.pgammon.models.CouleurCase;
import fr.ujm.tse.info4.pgammon.models.EtatSession;
import fr.ujm.tse.info4.pgammon.models.Partie;

public class PanelEnCoursVueDroite extends JPanel{

	private static final long serialVersionUID = -7846360859879404327L;
	//composant des images de jouer partie
	//composant panel droit
	private MonochromeIconButton back;
	private MonochromeIconButton dices;
	private AfficheurScore videau;
	private Partie partie;
	
	

public PanelEnCoursVueDroite(Partie p){
	partie = p;
	build();
}


private void build() {
	setLayout(null);
	setOpaque(false);
	
		
		//
		//panel du coté droit
		//
		
		
		//composant et label d'annuler coup
		back = new MonochromeIconButton(IconMonochromeType.RETOUR,"MonochromeIconButton","NOIR");
		back.setSizeBig();
		back.setBounds(10, 34, back.getPreferredSize().width, back.getPreferredSize().height);
		add(back);
		
		JLabel labback = new JLabel("<html>Annuler<br>coup");
		labback.setBounds(20, 79, 80, 60);
		add(labback);
		
		
		//composant avec label de lancer de dès
		dices = new MonochromeIconButton(IconMonochromeType.DES,"MonochromeIconButton","NOIR");
		dices.setSizeBig();
		dices.setBounds(10, 259, dices.getPreferredSize().width, dices.getPreferredSize().height);
		add(dices);
		
		JLabel labdices = new JLabel("<html>Lancer<br>dés");
		labdices.setForeground(new Color(0xCCCCCC));
		labdices.setBounds(20, 304, 80, 60);
		add(labdices);
		
		//creation composant et label du videau
		//attention ici j'ai pris la largeur et hauteur du dices
		videau = new AfficheurScore(partie.getVideau().getvideau(),CouleurCase.BLANC);
		videau.setBounds(10, 379, dices.getPreferredSize().width, dices.getPreferredSize().height);
		add(videau);
		
		JLabel labvideau = new JLabel("<html>Lancer<br>videau");
		labvideau.setForeground(new Color(0xCCCCCC));
		labvideau.setBounds(20, 429, 80, 60);
		add(labvideau);
		
	}

public void updateVideau()
{
	videau.setScore(partie.getVideau().getvideau());
}
public MonochromeIconButton getBack() {
	return back;
}


public MonochromeIconButton getDices() {
	return dices;
}


public AfficheurScore getVideau() {
	return videau;
}
		
	
		

	

}
