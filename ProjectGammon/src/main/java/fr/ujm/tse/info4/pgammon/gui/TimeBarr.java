package fr.ujm.tse.info4.pgammon.gui;

import java.awt.Dimension;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import fr.ujm.tse.info4.pgammon.models.DeSixFaces;
import fr.ujm.tse.info4.pgammon.models.Deplacement;
import fr.ujm.tse.info4.pgammon.models.Tour;

public class TimeBarr extends JPanel {
	private static final long serialVersionUID = 1318001554445843500L;
	private List<Tour> tours;
	private int count;
	
	public TimeBarr(List<Tour> tours) {
		this.tours = tours;
		
		build();
	}

	private void build() {
		setLayout(null);
		setOpaque(false);
		count = 0;
		for (Tour tour : tours) {
			int length = tour.getDeSixFaces().size();
			List<DeSixFaces> des = tour.getDeSixFaces();
			List<Deplacement> deplacements = tour.getListDeplacement();
			
			for( int i = 0; i < length ; i++ ){
				Deplacement dep = null;
				DeSixFaces de = des.get(i);
				if(deplacements != null && deplacements.size()>i){
					dep = deplacements.get(i);
				}
				TimeBarrElement elt = new TimeBarrElement(de, dep);
				elt.setBounds(elt.getPreferredSize().width * count, 0,
						elt.getPreferredSize().width, elt.getPreferredSize().height);
				System.out.println(elt.getBounds());
				add(elt);
				count++;
			}
			
		}
		setPreferredSize(new Dimension((count)*35, 100));
	}
	
}
