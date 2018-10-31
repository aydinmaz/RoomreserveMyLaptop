package it.finsoft.RoomReserve.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.finsoft.RoomReserve.model.Room;
import it.finsoft.RoomReserve.repository.RoomRepository;

@Controller
public class RoomController {

	@Autowired //
	private RoomRepository x;

	@RequestMapping(value = "/reservation", method = RequestMethod.POST)
	public String reservation(@RequestParam("room_id") String room_id, @RequestParam("hour_id") String hour_id,
			Model model) {
		System.out.println("idt: " + room_id + " h:" + hour_id);
		Long room_idlong = Long.parseLong(room_id);
		// room_id ro be Long cast mikonim chon baayd bar asas in id tu repository
		// search konim,va agar
		// tu file roomrepository negah koni ma search ro bar asas Long tarif kardim
		// ama baray hour_id lazem nist in kaar ro bokonim,chon alan dige koll ettelaat
		// room ba id ye folan (masalan 1) ro darim
		// va dakhel in ettelaat search mikonim va na dakhel repository
		Optional<Room> room = x.findById(room_idlong);
		boolean old_value;
		switch (hour_id) {
		case "1":
			old_value = room.get().isHour1confirm();
			if (old_value)
				room.get().setHour1confirm(false);
			else
				room.get().setHour1confirm(true);
			break;
		case "2":
			old_value = room.get().isHour2confirm();
			if (old_value)
				room.get().setHour2confirm(false);
			else
				room.get().setHour2confirm(true);
			break;
		case "3":
			old_value = room.get().isHour3confirm();
			if (old_value)
				room.get().setHour3confirm(false);
			else
				room.get().setHour3confirm(true);
			break;
		case "4":
			old_value = room.get().isHour4confirm();
			if (old_value)
				room.get().setHour4confirm(false);
			else
				room.get().setHour4confirm(true);
			break;
		case "5":
			old_value = room.get().isHour5confirm();
			if (old_value)
				room.get().setHour5confirm(false);
			else
				room.get().setHour5confirm(true);
			break;
		}

		x.save(room.get());
		List<Room> rooms2 = x.findAll();
		model.addAttribute("rooms2", rooms2);
		return "reservation";

	}

	@RequestMapping(value = "/reservation", method = RequestMethod.GET)
	public String reservation(Model model) {

		List<Room> rooms2 = new ArrayList<>();
		System.out.println(rooms2);

		rooms2 = x.findAll();

		// for(Room r : rooms2)
		// System.out.println(r.getId()+" "+r.getDay()+" "+r.getHour1());
		model.addAttribute("rooms2", rooms2);

		return "reservation";

	}

}
