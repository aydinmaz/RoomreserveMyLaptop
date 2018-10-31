package it.finsoft.RoomReserve.model;

import javax.persistence.*;

@Entity 
public class Room {
	private Long id;
	private String  hour1;
	private boolean hour1confirm;
	private String  hour2;
	private boolean hour2confirm;
	private String  hour3;
	private boolean hour3confirm;
	private String  hour4;
	private boolean hour4confirm;
	private String  hour5;
	private boolean hour5confirm;
	private String  day;
	
	
	
	
	
	
	
//	@Override
//	public String toString() {
//		return "" + hour1confirm + "," + hour2confirm + ","
//				+ hour3confirm + "," + hour4confirm + "," + hour5confirm;
//	}






	public Room() {
		super();
	}
	
	


	

	public Room(String hour1, boolean hour1confirm, String hour2, boolean hour2confirm, String hour3,
			boolean hour3confirm, String hour4, boolean hour4confirm, String hour5, boolean hour5confirm, String day) {
		super();
		this.hour1 = hour1;
		this.hour1confirm = hour1confirm;
		this.hour2 = hour2;
		this.hour2confirm = hour2confirm;
		this.hour3 = hour3;
		this.hour3confirm = hour3confirm;
		this.hour4 = hour4;
		this.hour4confirm = hour4confirm;
		this.hour5 = hour5;
		this.hour5confirm = hour5confirm;
		this.day = day;
	}






	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	 public String getHour1() {
		return hour1;
	}


	public void setHour1(String hour1) {
		this.hour1 = hour1;
	}


	public String getHour2() {
		return hour2;
	}


	public void setHour2(String hour2) {
		this.hour2 = hour2;
	}


	public String getHour3() {
		return hour3;
	}


	public void setHour3(String hour3) {
		this.hour3 = hour3;
	}


	public String getHour4() {
		return hour4;
	}


	public void setHour4(String hour4) {
		this.hour4 = hour4;
	}


	public String getHour5() {
		return hour5;
	}


	public void setHour5(String hour5) {
		this.hour5 = hour5;
	}


	public String getDay() {
			return day;
		}
		public void setDay(String day) {
			this.day = day;
		}

		public boolean isHour1confirm() {
			return hour1confirm;
		}
        public void setHour1confirm(boolean hour1confirm) {
			this.hour1confirm = hour1confirm;
		}

		public boolean isHour2confirm() {
			return hour2confirm;
		}
        public void setHour2confirm(boolean hour2confirm) {
			this.hour2confirm = hour2confirm;
		}


		public boolean isHour3confirm() {
			return hour3confirm;
		}
        public void setHour3confirm(boolean hour3confirm) {
			this.hour3confirm = hour3confirm;
		}


		public boolean isHour4confirm() {
			return hour4confirm;
		}
        public void setHour4confirm(boolean hour4confirm) {
			this.hour4confirm = hour4confirm;
		}


		public boolean isHour5confirm() {
			return hour5confirm;
		}
		public void setHour5confirm(boolean hour5confirm) {
			this.hour5confirm = hour5confirm;
		}


}