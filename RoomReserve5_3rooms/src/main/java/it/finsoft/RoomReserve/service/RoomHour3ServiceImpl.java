package it.finsoft.RoomReserve.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.finsoft.RoomReserve.model.RoomHour3;
import it.finsoft.RoomReserve.repository.RoomHour3Repository;

@Service
public class RoomHour3ServiceImpl implements RoomHour3Service {

	@Autowired
	private RoomHour3Repository roomrepos;

	@Override
	public List<RoomHour3> findRooms() {
		return roomrepos.findAll();
	}

	@Override
	public Optional<RoomHour3> findById(long id) {
		return roomrepos.findById(id);
	}

	@Override
	public void saveRoomhour(RoomHour3 roomhour) {
		roomrepos.save(roomhour);
	}

	@Override
	public void saverooms() {

		List<RoomHour3> roomhours = roomrepos.findAll();
		if (roomhours.isEmpty()) {

			String days[] = { "Monday", "Tuseday", "Wednesday", "Thursday", "Friday" };
			for (String element : days) {
				for (int i = 0; i < 5; i++) {
					RoomHour3 r = new RoomHour3(element, i + 1, false);
					roomhours.add(r);
				}
			}
			roomrepos.saveAll(roomhours);// saves in mysql
		}
	}
}
