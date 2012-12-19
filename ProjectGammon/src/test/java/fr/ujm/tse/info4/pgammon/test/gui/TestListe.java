package fr.ujm.tse.info4.pgammon.test.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;

import fr.ujm.tse.info4.pgammon.gui.BarreCaseButton;
import fr.ujm.tse.info4.pgammon.gui.CaseButton;
import fr.ujm.tse.info4.pgammon.gui.DeButton;
import fr.ujm.tse.info4.pgammon.gui.JoueurCellRenderer;
import fr.ujm.tse.info4.pgammon.gui.MonochromeButton;
import fr.ujm.tse.info4.pgammon.gui.MonochromeListe;
import fr.ujm.tse.info4.pgammon.gui.TriangleCaseButton;
import fr.ujm.tse.info4.pgammon.models.Case;
import fr.ujm.tse.info4.pgammon.models.CouleurCase;
import fr.ujm.tse.info4.pgammon.models.DeSixFaces;
import fr.ujm.tse.info4.pgammon.models.Joueur;
import fr.ujm.tse.info4.pgammon.models.NiveauAssistant;

public class TestListe {

	

	private static MonochromeListe<Joueur> listeJoueur;

	private static Vector<Joueur> js;

	public static void main(String[] args) {
		JFrame frame = new JFrame("Test Design");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(816,638);

		Container panel = frame.getContentPane();
		panel.setLayout(null);

		panel.setBackground(Color.BLACK);
		
		js  = new Vector<>();
		
		js.add(new Joueur(1, "ben", "beauGoss",NiveauAssistant.NON_UTILISE) );
		js.add(new Joueur(2, "JM", "null", NiveauAssistant.COMPLET));
		listeJoueur = new MonochromeListe<>("Coucou", js, new JoueurCellRenderer());

		listeJoueur.setBounds(100,100,300,400);
		panel.add(listeJoueur);
		
		
		MonochromeButton btn = new MonochromeButton("+");
		btn.setBounds(600,100,150,50);
		panel.add(btn);
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				js.add(new Joueur(2, "JM", "null", NiveauAssistant.COMPLET));
				listeJoueur.updateList(new JoueurCellRenderer());
			}
		});
		frame.setVisible(true);
	}
}
