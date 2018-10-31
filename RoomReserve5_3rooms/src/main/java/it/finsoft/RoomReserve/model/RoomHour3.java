package it.finsoft.RoomReserve.model;

import javax.persistence.Entity;

@Entity
public class RoomHour3 extends RoomHourBase {

	
	public RoomHour3() {
		super();
	}

	public RoomHour3(String day, int hour, boolean confirm) {
		super();
		this.day = day;
		this.hour = hour;
		this.confirm = confirm;
	}
}
