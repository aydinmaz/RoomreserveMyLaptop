package it.finsoft.RoomReserve.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.finsoft.RoomReserve.model.RoomHour1;
import it.finsoft.RoomReserve.repository.RoomHour1Repository;

@Service
public class RoomHour1ServiceImpl implements RoomHour1Service {

	@Autowired
	private RoomHour1Repository roomrepos;

	@Override
	public List<RoomHour1> findRooms() {
		return roomrepos.findAll();
	}

	@Override
	public Optional<RoomHour1> findById(long id) {
		return roomrepos.findById(id);
	}

	@Override
	public void saveRoomhour(RoomHour1 roomhour) {
		roomrepos.save(roomhour);
	}

	@Override
	public void saverooms() {

		List<RoomHour1> roomhours = roomrepos.findAll();
		if (roomhours.isEmpty()) {
			String days[] = { "Monday", "Tuseday", "Wednesday", "Thursday", "Friday" };
			for (String element : days) {
				for (int i = 0; i < 5; i++) {
					RoomHour1 r = new RoomHour1(element, i + 1, false);
					roomhours.add(r);
				}
			}
			roomrepos.saveAll(roomhours);// saves in mysql
		}

	}
}
