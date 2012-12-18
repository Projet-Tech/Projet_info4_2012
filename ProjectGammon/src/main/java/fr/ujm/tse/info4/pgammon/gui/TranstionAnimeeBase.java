package fr.ujm.tse.info4.pgammon.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import javax.swing.JPanel;

public abstract class TranstionAnimeeBase extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 8608824468305555276L;
	protected int duree;
	protected int interval;


	private Timer timer;
	protected int value;
	
	public TranstionAnimeeBase(int interval, int duree) {
		this.duree = duree;
		this.interval = interval;
		timer = new Timer(interval, this);
	}

	public TranstionAnimeeBase(int interval) {
		this.duree = Integer.MAX_VALUE;
		this.interval = interval;
		timer = new Timer(interval, this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		value+=interval;
		repaint();
		if(value > duree)
			stop();
			
	}



	
	public void start(){
		timer.start();
	}
	
	public void stop(){
		timer.stop();
	}

	public void end(){
		setValue(duree);
		stop();
	}
	public void restart(){
		this.value = 0;
		timer.start();
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public float getRapport(){
		return (float)(value)/(float)(duree);
	}
}
