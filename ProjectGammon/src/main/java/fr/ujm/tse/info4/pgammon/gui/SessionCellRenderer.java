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

import fr.ujm.tse.info4.pgammon.models.Joueur;
import fr.ujm.tse.info4.pgammon.models.Session;

public class SessionCellRenderer extends JPanel implements ListCellRenderer<Session> {
	private static final long serialVersionUID = 2809364114788243599L;
	JLabel label_j1;
	JLabel label_j2;
	JLabel label_end;
	public SessionCellRenderer() {
		//TODO: Ajouter les scores
		//TODO Positionement des composants;
		label_j1 = new JLabel();

		setPreferredSize(new Dimension(100, 45));
		label_j1.setAlignmentX(CENTER_ALIGNMENT);
		label_j1.setAlignmentY(CENTER_ALIGNMENT);
		label_j1.setFont(new Font("Arial",Font.BOLD,18));
		add(label_j1);
		
		label_j2 = new JLabel();

		setPreferredSize(new Dimension(100, 45));
		label_j2.setAlignmentX(CENTER_ALIGNMENT);
		label_j2.setAlignmentY(CENTER_ALIGNMENT);
		label_j2.setFont(new Font("Arial",Font.BOLD,18));
		add(label_j2);
		
		label_end = new JLabel();

		setPreferredSize(new Dimension(100, 45));
		label_end.setAlignmentX(RIGHT_ALIGNMENT);
		label_end.setAlignmentY(CENTER_ALIGNMENT);
		label_end.setFont(new Font("Arial",Font.BOLD,13));
		add(label_end);
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Session> list,
			Session j, int index, boolean isSelected, boolean cellHasFocus) {
		
		label_j1.setForeground(new Color(0x808080));
		label_j2.setForeground(new Color(0x808080));
		label_end.setForeground(new Color(0x808080));
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
		label_j1.setText("joueur1");
		label_j2.setText("joueur2");
		label_end.setText("Interompue a 21h");
		setAlignmentX(0.5f);
		return this;
	}

}
