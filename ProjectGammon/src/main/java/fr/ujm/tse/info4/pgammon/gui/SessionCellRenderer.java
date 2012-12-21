package fr.ujm.tse.info4.pgammon.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import fr.ujm.tse.info4.pgammon.models.CouleurCase;
import fr.ujm.tse.info4.pgammon.models.Session;

public class SessionCellRenderer extends JPanel implements ListCellRenderer<Session> {
	private static final long serialVersionUID = 2809364114788243599L;
	JLabel label_j1;
	JLabel label_j2;
	AfficheurScore label_score_j1;
	AfficheurScore label_score_j2;
	
	JLabel nom1_intermediaire;
	JLabel nom2_intermediaire;
	
	
	public SessionCellRenderer() {
		setLayout(null);
		setPreferredSize(new Dimension(100, 60));
		
		label_score_j1 = new AfficheurScore(0,CouleurCase.BLANC);
		label_score_j1.setBounds(290, 0, 25, 25);
		add(label_score_j1);
		
		label_j1 = new JLabel();	
		label_j1.setBounds(10, 0, 300, 30);
		label_j1.setFont(new Font("Arial",Font.BOLD,18));
		add(label_j1);
		
		
		
		label_j2 = new JLabel();
		label_j2.setBounds(10, 30, 300, 30);
		label_j2.setFont(new Font("Arial",Font.BOLD,18));
		add(label_j2);
		
		label_score_j2 = new AfficheurScore(0,CouleurCase.NOIR);
		label_score_j2.setBounds(290, 30, 25, 25);
		add(label_score_j2);
		
		
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Session> list,
			Session j, int index, boolean isSelected, boolean cellHasFocus) {
		
					
		label_j1.setForeground(new Color(0xCCCCCC));
		label_j2.setForeground(new Color(0xCCCCCC));
		Color bgColor;
		if(isSelected)
			if(cellHasFocus)
				bgColor = new Color(0x333333);
			else
				bgColor = new Color(0x252525);
		else 
			if(cellHasFocus)
				bgColor = new Color(0x202020);
			else
				bgColor = new Color(0x111111);
		setBackground(bgColor);
		setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0x555555)));

		try{
			label_j1.setText(j.getPartieEnCours().getParametreJeu().getJoueurBlanc().getPseudo());
			label_j2.setText(j.getPartieEnCours().getParametreJeu().getJoueurNoir().getPseudo());
					setAlignmentX(0.5f);
			label_score_j1.setScore(j.getScores().get(j.getPartieEnCours().getParametreJeu().getJoueurBlanc()));
			label_score_j2.setScore(j.getScores().get(j.getPartieEnCours().getParametreJeu().getJoueurNoir()));
		}catch(Exception e){

			label_j1.setText("");
			label_j2.setText("");
					setAlignmentX(0.5f);
			label_score_j1.setScore(0);
			label_score_j2.setScore(0);
		}
			
		return this;
	}

}
