package it.finsoft.RoomReserve.service;

import org.springframework.stereotype.Service;

@Service
public interface SecurityService {
	public void autologin(String username, String password);
	 public String findLoggedInUsername();

}
