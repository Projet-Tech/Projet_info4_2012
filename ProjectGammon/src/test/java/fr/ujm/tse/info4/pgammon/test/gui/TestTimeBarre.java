package fr.ujm.tse.info4.pgammon.test.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import fr.ujm.tse.info4.pgammon.gui.TimeBarr;
import fr.ujm.tse.info4.pgammon.gui.TimeBarrElement;
import fr.ujm.tse.info4.pgammon.models.Case;
import fr.ujm.tse.info4.pgammon.models.CouleurCase;
import fr.ujm.tse.info4.pgammon.models.DeSixFaces;
import fr.ujm.tse.info4.pgammon.models.Deplacement;
import fr.ujm.tse.info4.pgammon.models.Joueur;
import fr.ujm.tse.info4.pgammon.models.NiveauAssistant;
import fr.ujm.tse.info4.pgammon.models.ParametreJeu;
import fr.ujm.tse.info4.pgammon.models.Partie;
import fr.ujm.tse.info4.pgammon.models.Tour;
import fr.ujm.tse.info4.pgammon.vues.VuePartie;

public class TestTimeBarre {
	
	private final static DeSixFaces B1 = new DeSixFaces(CouleurCase.BLANC, 1);
	private final static DeSixFaces B2 = new DeSixFaces(CouleurCase.BLANC, 2);
	private final static DeSixFaces B3 = new DeSixFaces(CouleurCase.BLANC, 3);
	private final static DeSixFaces B4 = new DeSixFaces(CouleurCase.BLANC, 4);
	private final static DeSixFaces B5 = new DeSixFaces(CouleurCase.BLANC, 5);
	private final static DeSixFaces B6 = new DeSixFaces(CouleurCase.BLANC, 6);
	private final static DeSixFaces N1 = new DeSixFaces(CouleurCase.NOIR, 1);
	private final static DeSixFaces N2 = new DeSixFaces(CouleurCase.NOIR, 2);
	private final static DeSixFaces N3 = new DeSixFaces(CouleurCase.NOIR, 3);
	private final static DeSixFaces N4 = new DeSixFaces(CouleurCase.NOIR, 4);
	private final static DeSixFaces N5 = new DeSixFaces(CouleurCase.NOIR, 5);
	private final static DeSixFaces N6 = new DeSixFaces(CouleurCase.NOIR, 6);
	private final static Case CN = new Case(CouleurCase.NOIR, 0, 0);
	private final static Case CB = new Case(CouleurCase.BLANC, 0, 25);
	private final static Case C1 = new Case(CouleurCase.NOIR, 0, 3);
	private final static Case C2 = new Case(CouleurCase.BLANC, 0, 3);
	public static void main(String[] args) {
		JFrame frame = new JFrame("Test Design");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(816,638);
		
		Container panel = frame.getContentPane();
		panel.setLayout(new FlowLayout());
		panel.setBackground(Color.BLACK);
		
		
		List<Tour> tours = new ArrayList<>();
		{
			ArrayList<DeSixFaces> d = new ArrayList<>();
			d.add(B1);
			d.add(B4);
			Tour t = new Tour(CouleurCase.BLANC,d);
			t.addDeplacement(new Deplacement(C1, C2, false));
			t.addDeplacement(new Deplacement(C1, CB, false));
			tours.add(t);
		}
		{
			ArrayList<DeSixFaces> d = new ArrayList<>();
			d.add(N2);
			d.add(N6);
			Tour t = new Tour(CouleurCase.BLANC,d);
			t.addDeplacement(new Deplacement(C1, C2, false));
			tours.add(t);
		}
		{
			ArrayList<DeSixFaces> d = new ArrayList<>();
			d.add(B2);
			d.add(B2);
			d.add(B2);
			d.add(B2);
			Tour t = new Tour(CouleurCase.BLANC,d);
			t.addDeplacement(new Deplacement(C1, C2, false));
			t.addDeplacement(new Deplacement(C1, CB, false));
			t.addDeplacement(new Deplacement(C1, C2, false));
			t.addDeplacement(new Deplacement(C1, C2, false));
			tours.add(t);
		}
		{
			ArrayList<DeSixFaces> d = new ArrayList<>();
			d.add(N4);
			d.add(N5);
			Tour t = new Tour(CouleurCase.BLANC,d);
			tours.add(t);
		}
		{
			ArrayList<DeSixFaces> d = new ArrayList<>();
			d.add(B1);
			d.add(B4);
			Tour t = new Tour(CouleurCase.BLANC,d);
			t.addDeplacement(new Deplacement(C1, C2, false));
			t.addDeplacement(new Deplacement(C1, C2, false));
			tours.add(t);
		}
		{
			ArrayList<DeSixFaces> d = new ArrayList<>();
			d.add(N2);
			d.add(N6);
			Tour t = new Tour(CouleurCase.BLANC,d);
			t.addDeplacement(new Deplacement(C1, C2, false));
			tours.add(t);
		}
		{
			ArrayList<DeSixFaces> d = new ArrayList<>();
			d.add(B2);
			d.add(B2);
			d.add(B2);
			d.add(B2);
			Tour t = new Tour(CouleurCase.BLANC,d);
			t.addDeplacement(new Deplacement(C1, C2, false));
			t.addDeplacement(new Deplacement(C1, C2, false));
			t.addDeplacement(new Deplacement(C1, C2, false));
			t.addDeplacement(new Deplacement(C1, C2, false));
			tours.add(t);
		}
		{
			ArrayList<DeSixFaces> d = new ArrayList<>();
			d.add(N4);
			d.add(N5);
			Tour t = new Tour(CouleurCase.BLANC,d);
			tours.add(t);
		}		{
			ArrayList<DeSixFaces> d = new ArrayList<>();
			d.add(B1);
			d.add(B4);
			Tour t = new Tour(CouleurCase.BLANC,d);
			t.addDeplacement(new Deplacement(C1, C2, false));
			t.addDeplacement(new Deplacement(C1, CB, false));
			tours.add(t);
		}
		{
			ArrayList<DeSixFaces> d = new ArrayList<>();
			d.add(N2);
			d.add(N6);
			Tour t = new Tour(CouleurCase.BLANC,d);
			t.addDeplacement(new Deplacement(C1, CN, false));
			tours.add(t);
		}
		{
			ArrayList<DeSixFaces> d = new ArrayList<>();
			d.add(B2);
			d.add(B2);
			d.add(B2);
			d.add(B2);
			Tour t = new Tour(CouleurCase.BLANC,d);
			t.addDeplacement(new Deplacement(C1, C2, false));
			t.addDeplacement(new Deplacement(C1, CB, false));
			t.addDeplacement(new Deplacement(C1, C2, false));
			t.addDeplacement(new Deplacement(C1, C2, false));
			tours.add(t);
		}
		{
			ArrayList<DeSixFaces> d = new ArrayList<>();
			d.add(N4);
			d.add(N5);
			Tour t = new Tour(CouleurCase.BLANC,d);
			tours.add(t);
		}		{
			ArrayList<DeSixFaces> d = new ArrayList<>();
			d.add(B1);
			d.add(B4);
			Tour t = new Tour(CouleurCase.BLANC,d);
			t.addDeplacement(new Deplacement(C1, C2, false));
			t.addDeplacement(new Deplacement(C1, C2, false));
			tours.add(t);
		}
		{
			ArrayList<DeSixFaces> d = new ArrayList<>();
			d.add(N2);
			d.add(N6);
			Tour t = new Tour(CouleurCase.BLANC,d);
			t.addDeplacement(new Deplacement(C1, C2, true));
			tours.add(t);
		}
		{
			ArrayList<DeSixFaces> d = new ArrayList<>();
			d.add(B2);
			d.add(B2);
			d.add(B2);
			d.add(B2);
			Tour t = new Tour(CouleurCase.BLANC,d);
			t.addDeplacement(new Deplacement(C1, C2, false));
			t.addDeplacement(new Deplacement(C1, C2, false));
			t.addDeplacement(new Deplacement(C1, C2, false));
			t.addDeplacement(new Deplacement(C1, C2, false));
			tours.add(t);
		}
		{
			ArrayList<DeSixFaces> d = new ArrayList<>();
			d.add(N4);
			d.add(N5);
			Tour t = new Tour(CouleurCase.BLANC,d);
			tours.add(t);
		}		{
			ArrayList<DeSixFaces> d = new ArrayList<>();
			d.add(B1);
			d.add(B4);
			Tour t = new Tour(CouleurCase.BLANC,d);
			t.addDeplacement(new Deplacement(C1, C2, false));
			t.addDeplacement(new Deplacement(C1, C2, false));
			tours.add(t);
		}
		{
			ArrayList<DeSixFaces> d = new ArrayList<>();
			d.add(N2);
			d.add(N6);
			Tour t = new Tour(CouleurCase.BLANC,d);
			t.addDeplacement(new Deplacement(C1, C2,false));
			tours.add(t);
		}
		{
			ArrayList<DeSixFaces> d = new ArrayList<>();
			d.add(B2);
			d.add(B2);
			d.add(B2);
			d.add(B2);
			Tour t = new Tour(CouleurCase.BLANC,d);
			t.addDeplacement(new Deplacement(C1, CB, false));
			t.addDeplacement(new Deplacement(C1, C2, true));
			t.addDeplacement(new Deplacement(C1, C2, false));
			tours.add(t);
		}
		{
			ArrayList<DeSixFaces> d = new ArrayList<>();
			d.add(N4);
			d.add(N5);
			Tour t = new Tour(CouleurCase.BLANC,d);
			tours.add(t);
		}
		
		TimeBarr tb = new TimeBarr(tours);
		panel.add(tb);
		frame.setVisible(true);
	}
}
