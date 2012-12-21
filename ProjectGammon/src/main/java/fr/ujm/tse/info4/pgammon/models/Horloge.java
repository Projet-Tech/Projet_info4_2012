package fr.ujm.tse.info4.pgammon.models;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import fr.ujm.tse.info4.pgammon.models.HorlogeEvent.HorlogeEventType;

public class Horloge implements ActionListener{
	private final int UPDATE_PERIOD = 10;
	ArrayList<HorlogeEventListener> listeners = new ArrayList<>();
	Timer timer;
	int duree;
	int value;
	private boolean running;
	public Horloge(int duree_ms) {
		timer = new Timer(UPDATE_PERIOD, this);
		this.duree  = duree_ms;  
		running = false;
	}
	
	public void addListener(HorlogeEventListener listener){
		listeners.add(listener);
	}
	
	public void removeListener(HorlogeEventListener listener){
		listeners.remove(listener);
	}
	
	private void fireFinHorloge(){
		HorlogeEvent event = new HorlogeEvent(this,HorlogeEventType.FIN);
		for (HorlogeEventListener listener : listeners) {
			listener.finHorloge(event);
		}
	}
	
	private void fireUpdate(){
		HorlogeEvent event = new HorlogeEvent(this,HorlogeEventType.UPDATE);
		for (HorlogeEventListener listener : listeners) {
			listener.updateHorloge(event);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		value+=UPDATE_PERIOD;
		if(value > duree){
			stop();
			fireFinHorloge();
		}
		fireUpdate();
	}
	
	public void start(){
		running = true;
		timer.start();
	}
	
	public void stop(){
		running = false;
		timer.stop();
	}

	public void end(){
		setValue(duree);
		stop();
	}
	public void restart(){
		setValue(0);
		start();
	}
	
	public void setValue(int value) {
		this.value = value;
		fireUpdate();
	}

	public void setDuree(int value) {
		this.duree = value;
		fireUpdate();
	}
	public float getRapport(){
		return (float)(value)/(float)(duree);
	}
	
	public Timer getTimer() {
		return timer;
	}
	public int getDuree() {
		return duree;
	}
	public int getValue() {
		return value;
	}
	
	public boolean isRunning(){
		return running;
	}
	
	public String getTempsRestant(){
		int i = (duree - value )/1000; 
		int j=i/60;		
		if(duree == 0){
			return "\u221E";
		}else if(i>60){
			return new Integer(i/60).toString()+" : "+new Integer(i-60*j);
		}
		else{
			return new Integer(i).toString()+" s";
		}
	}
}
