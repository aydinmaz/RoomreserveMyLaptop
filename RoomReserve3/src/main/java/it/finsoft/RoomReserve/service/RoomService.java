package it.finsoft.RoomReserve.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import it.finsoft.RoomReserve.model.Room;

@Service
public interface RoomService {

	public Optional<Room> findById(long id);
	
	public void saveRoom(Room room);
	
	public List<Room> findAll();
	
	public void saveAllRooms();
}
