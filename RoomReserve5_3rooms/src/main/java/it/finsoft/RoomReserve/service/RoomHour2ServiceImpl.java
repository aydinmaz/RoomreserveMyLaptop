package it.finsoft.RoomReserve.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.finsoft.RoomReserve.model.RoomHour2;
import it.finsoft.RoomReserve.repository.RoomHour2Repository;

@Service
public class RoomHour2ServiceImpl implements RoomHour2Service {

	@Autowired
	private RoomHour2Repository roomrepos;

	@Override
	public List<RoomHour2> findRooms() {
		return roomrepos.findAll();
	}

	@Override
	public Optional<RoomHour2> findById(long id) {
		return roomrepos.findById(id);
	}

	@Override
	public void saveRoomhour(RoomHour2 roomhour) {
		roomrepos.save(roomhour);
	}

	@Override
	public void saverooms() {

		List<RoomHour2> roomhours = roomrepos.findAll();
		if (roomhours.isEmpty()) {
			String days[] = { "Monday", "Tuseday", "Wednesday", "Thursday", "Friday" };
			for (String element : days) {
				for (int i = 0; i < 5; i++) {
					RoomHour2 r = new RoomHour2(element, i + 1, false);
					roomhours.add(r);
				}
			}
			roomrepos.saveAll(roomhours);// saves in mysql
		}

	}
}
