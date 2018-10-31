package it.finsoft.RoomReserve.model;

import javax.persistence.Entity;

@Entity
public class RoomHour1 extends RoomHourBase{

	public RoomHour1() {
		super();
	}

	public RoomHour1(String day, int hour, boolean confirm) {
		super();
		this.day = day;
		this.hour = hour;
		this.confirm = confirm;
	}
}
