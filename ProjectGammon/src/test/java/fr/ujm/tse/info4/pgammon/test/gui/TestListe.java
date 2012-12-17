package fr.ujm.tse.info4.pgammon.test.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JList;

import fr.ujm.tse.info4.pgammon.gui.JoueurCellRenderer;
import fr.ujm.tse.info4.pgammon.models.Joueur;
import fr.ujm.tse.info4.pgammon.models.NiveauAssistant;
import fr.ujm.tse.info4.pgammon.models.Profils;

public class TestListe {


	public static void main(String[] args) {

		Profils tmp = new Profils();
				
		tmp.ajouter("DONG Chuan","Image DONG",NiveauAssistant.NON_UTILISE);
		tmp.ajouter("BONNETTO Benjamin","Image Ben",NiveauAssistant.COMPLET);
		tmp.ajouter("FRANCON Adrien","Image Adrien",NiveauAssistant.COMPLET);
		tmp.ajouter("POTHELUNE Jean-Michel","Image JM",NiveauAssistant.SIMPLE);
		
		
		JFrame frame = new JFrame("Test Design");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,600);
		
		Container panel = frame.getContentPane();
		panel.setLayout(null);
		
		Vector<Joueur> joueurs = new Vector<>();
		joueurs.add(new Joueur(1, "ben", "beauGoss",
				NiveauAssistant.NON_UTILISE));
		joueurs.add(new Joueur(2, "JM", "null", NiveauAssistant.COMPLET));
		
		
		
		JList<Joueur> j = new JList<>(new Vector(tmp.getList()));
		j.setBounds(100, 100, 200, 500);
		j.setCellRenderer(new JoueurCellRenderer());
		j.setOpaque(false);
		panel.add(j);
		panel.setBackground(new Color(0x00000));
		frame.setVisible(true);
	}
}
