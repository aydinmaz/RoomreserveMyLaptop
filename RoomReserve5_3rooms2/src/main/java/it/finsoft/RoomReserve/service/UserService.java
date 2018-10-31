package it.finsoft.RoomReserve.service;

import org.springframework.stereotype.Service;

import it.finsoft.RoomReserve.model.User;

@Service
public interface UserService {

	 public void save(User user);
	 public User findByUsername(String username);
	 public User findByEmail(String email);
	
}
