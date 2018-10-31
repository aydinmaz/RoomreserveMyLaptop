package it.finsoft.RoomReserve.model;



import javax.persistence.*;

@Entity 
public class Room {
	private Long id;
	private String  day;
	private int  hour;
	private boolean confirm;
	private User user;


	public Room() {
		super();
	}
	

	public Room(String day, int hour, boolean confirm) {
		super();
		this.day = day;
		this.hour = hour;
		this.confirm = confirm;
	}

	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() 
	{  return id;     }
	public void setId(Long id)
	{  this.id = id;  }
	
	
	 public int getHour() 
	 {  return hour;   }
	public void setHour(int hour) 
	{   this.hour = hour;  }

	
	public String getDay() 
	{  return day;  }
	public void setDay(String day) 
	{  this.day = day; }

	
	public boolean isConfirm() 
	{  return confirm; }
    public void setConfirm(boolean confirm) 
    {   this.confirm = confirm;  }

    @OneToOne//(cascade = CascadeType.ALL)
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

   
	
}