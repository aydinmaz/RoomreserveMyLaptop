package it.finsoft.RoomReserve.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import it.finsoft.RoomReserve.model.RoomHour2;

@Service
public interface RoomHour2Service {

	public void saverooms();

	public List<RoomHour2> findRooms();

	public Optional<RoomHour2> findById(long id);

	public void saveRoomhour(RoomHour2 roomhour);

}
