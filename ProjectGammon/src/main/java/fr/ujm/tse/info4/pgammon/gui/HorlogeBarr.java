package fr.ujm.tse.info4.pgammon.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.ujm.tse.info4.pgammon.models.Horloge;
import fr.ujm.tse.info4.pgammon.models.HorlogeEvent;
import fr.ujm.tse.info4.pgammon.models.HorlogeEventListener;
/**
 * Fournit un composant pour afficher l'horloge sous forme de barre
 * @author Jean-Mi
 *
 */
public class HorlogeBarr extends JPanel implements HorlogeEventListener {
	private static final long serialVersionUID = 1946775586045691887L;
	private final int LABEL_WIDTH = 50;
	JLabel timeLbl;
	Horloge horloge;
	
	/**
	 * affiche l'horloge dans une barre
	 * @param horloge Horloge associée
	 */
	public HorlogeBarr(Horloge horloge) {
		setHorloge(horloge);
		build();
		
	}
	
	
	
	/**
	 * Set l'horloge
	 * @param h horloge
	 */
	public void setHorloge(Horloge h) {

		if(horloge != null)
			horloge.removeListener(this);
		this.horloge = h;
		if(horloge != null)
			horloge.addListener(this);
		
		
		setVisible(horloge != null);
	}




	private void build() {
		setLayout(null);
		setOpaque(false);
		timeLbl = new JLabel("");
		timeLbl.setForeground(new Color(0xCCCCCC));
		timeLbl.setBounds(10,0,LABEL_WIDTH-10,20);
		add(timeLbl);
	}




	@Override
	protected void paintComponent(Graphics g) {
		if(horloge == null)
			return;
		
		Graphics2D g2 = (Graphics2D) g.create(); 
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
		
		Paint p;
		int h = getHeight(); 
		int w = getWidth(); 
		int time_width = (w - LABEL_WIDTH) - (int) ((w - LABEL_WIDTH)*horloge.getRapport());
		
		// Arriere plan
		p = new Color(0xDDDDDD);
		
		g2.setPaint(p); 
		g2.fillRect(LABEL_WIDTH+6, 6, time_width-9, h-11); 
		
		// Bordure
		p = new Color(0xAAAAAA);
		g2.setStroke(new BasicStroke(3.0f) );
		g2.setPaint(p); 
		g2.drawRect(2+LABEL_WIDTH,2, w-4 - LABEL_WIDTH , h-4);
		
		
		g2.dispose(); 
		
	}
	@Override
	protected void paintBorder(Graphics g) {}




	@Override
	public void finHorloge(HorlogeEvent horloge) {}




	@Override
	public void updateHorloge(HorlogeEvent evt) {
		if(evt.getSource() == horloge)
			repaint();
		
		if(timeLbl != null)
			timeLbl.setText(horloge.getTempsRestant());
	}
}
