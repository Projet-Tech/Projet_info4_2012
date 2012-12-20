package fr.ujm.tse.info4.pgammon.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;

import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.ujm.tse.info4.pgammon.models.Horloge;

public class HorlogeBarr extends JPanel {
	private final int LABEL_WIDTH = 50;
	JLabel timeLbl;
	Horloge horloge;
	
	
	public HorlogeBarr(Horloge horloge) {
		setHorloge(horloge);
		build();
		
	}
	
	
	

	private void setHorloge(Horloge h) {
		this.horloge = h;
		
	}




	private void build() {
		setLayout(null);
		timeLbl = new JLabel("aa:bb");
		timeLbl.setBounds(0,0,100,50);
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

		int time_width = (int) ((w - LABEL_WIDTH)*horloge.getRapport());
				
		// Arriere plan
		p = new RadialGradientPaint(new Point2D.Double(getWidth() / 2.0,
                getHeight() / 2.0), 
                getHeight(),
                new float[] { 0.0f, 0.8f },
                new Color[] { new Color(0x333333), new Color(0x000000) },
                RadialGradientPaint.CycleMethod.NO_CYCLE);
		
		g2.setPaint(p); 
		g2.fillRect(LABEL_WIDTH, 0, time_width, h); 
		
		// Bordure
		p = new Color(0x808080);
		g2.setStroke(new BasicStroke(5.0f) );
		g2.setPaint(p); 
		g2.drawRect(2+LABEL_WIDTH, 0, w - 5 - LABEL_WIDTH , h - 5 );
		
		
		g2.dispose(); 
		
	}
	@Override
	protected void paintBorder(Graphics g) {}
}
