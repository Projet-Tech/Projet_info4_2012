package fr.ujm.tse.info4.pgammon.models;

import java.util.EventObject;

public class HorlogeEvent extends EventObject{
	HorlogeEventType type;
	public enum HorlogeEventType{
		FIN,
		UPDATE
	}
	
	
	public HorlogeEvent(Horloge horloge,HorlogeEventType type) {
		super(horloge);
		this.type = type;
	}
	
	public HorlogeEventType getEventType(){
		return type;
	}

	
	
	
	private static final long serialVersionUID = 1570857988187744152L;
}