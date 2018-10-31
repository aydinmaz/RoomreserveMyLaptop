package it.finsoft.RoomReserve.model;

import javax.persistence.Entity;

@Entity
public class RoomHour2 extends RoomHourBase {

	public RoomHour2() {
		super();
	}

	public RoomHour2(String day, int hour, boolean confirm) {
		super();
		this.day = day;
		this.hour = hour;
		this.confirm = confirm;
	}
	
}
