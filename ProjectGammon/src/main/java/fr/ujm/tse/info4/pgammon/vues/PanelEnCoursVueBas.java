package fr.ujm.tse.info4.pgammon.vues;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.ujm.tse.info4.pgammon.gui.IconMonochromeType;
import fr.ujm.tse.info4.pgammon.gui.MonochromeButton;
import fr.ujm.tse.info4.pgammon.gui.MonochromeIconButton;

public class PanelEnCoursVueBas extends JPanel{
	
	private static final long serialVersionUID = 1587735370301921370L;
	
	//composante panel bas
		MonochromeIconButton help;
		MonochromeIconButton plus;
		MonochromeIconButton x_black;
		MonochromeButton scorej1;
		MonochromeButton scorej2;


	public PanelEnCoursVueBas(){
		
		build();
	}


	private void build() {
		setLayout(null);
		setOpaque(false);
		
		//
		//panel du bas
		//
		
		
		//composant et label d'aide
		help = new MonochromeIconButton(IconMonochromeType.AIDE,"MonochromeIconButton","NOIR");
		help.setSizeBig();
		help.setBounds(600, 5, help.getPreferredSize().width, help.getPreferredSize().height);
		add(help);
		
		JLabel labhelp = new JLabel("Aide");
		labhelp.setForeground(new Color(0xCCCCCC));
		labhelp.setBounds(617, 50, 80, 60);
		add(labhelp);
		
		//composant et label d'annuler nouvelle session
		plus = new MonochromeIconButton(IconMonochromeType.PLUS,"MonochromeIconButton","NOIR");
		plus.setSizeBig();
		plus.setBounds(700, 5, plus.getPreferredSize().width, plus.getPreferredSize().height);
		add(plus);
		
		JLabel labplus = new JLabel("Nouvelle session");
		labplus.setForeground(new Color(0xCCCCCC));
		labplus.setBounds(680, 50, 130, 60);
		add(labplus);
		
		//composant et label d'annuler interrompre session
		x_black = new MonochromeIconButton(IconMonochromeType.X_NOIR,"MonochromeIconButton","NOIR");
		x_black.setSizeBig();
		x_black.setBounds(500, 5, x_black.getPreferredSize().width, x_black.getPreferredSize().height);
		add(x_black);
		
		JLabel labx_black = new JLabel("Interrompre session");
		labx_black.setForeground(new Color(0xCCCCCC));
		labx_black.setBounds(470, 50, 130, 60);
		add(labx_black);
		
		
		//composant et label du score
		scorej1 = new MonochromeButton("4");
		scorej1.setBounds(270, 5, x_black.getPreferredSize().width, x_black.getPreferredSize().height);
		add(scorej1);
		
		scorej2 = new MonochromeButton("3");
		scorej2.setBounds(350, 5, x_black.getPreferredSize().width, x_black.getPreferredSize().height);
		add(scorej2);
		
		JLabel labscore = new JLabel("Scores");
		labscore.setForeground(new Color(0xCCCCCC));
		labscore.setBounds(320, 50, 130, 60);
		add(labscore);
		
	}


	public MonochromeIconButton getHelp() {
		return help;
	}


	public MonochromeIconButton getPlus() {
		return plus;
	}


	public MonochromeIconButton getX_black() {
		return x_black;
	}


	public MonochromeButton getScorej1() {
		return scorej1;
	}


	public MonochromeButton getScorej2() {
		return scorej2;
	}
	
	

}
