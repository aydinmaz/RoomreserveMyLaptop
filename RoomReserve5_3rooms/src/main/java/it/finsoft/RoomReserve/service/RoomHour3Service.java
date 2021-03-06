package it.finsoft.RoomReserve.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import it.finsoft.RoomReserve.model.RoomHour3;

@Service
public interface RoomHour3Service {

	public void saverooms();

	public List<RoomHour3> findRooms();

	public Optional<RoomHour3> findById(long id);

	public void saveRoomhour(RoomHour3 roomhour);
}
