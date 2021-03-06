package it.finsoft.RoomReserve.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.finsoft.RoomReserve.model.Room;
import it.finsoft.RoomReserve.model.User;
import it.finsoft.RoomReserve.repository.UserRepository;
import it.finsoft.RoomReserve.service.RoomService;
import it.finsoft.RoomReserve.service.SecurityService;

@Controller
public class RoomController {

	@Autowired
	private RoomService roomservice;

	@Autowired
	private UserRepository usrrpsitry;

	@Autowired
	private SecurityService securityService;

	@RequestMapping(value = "/reservation", method = RequestMethod.GET)
	public String reservation(Model model) { // List<Room> rooms2= new ArrayList<>();
		roomservice.saveAllRooms();
		List<Room> rooms2 = roomservice.findAll();
		String usernameOfloggeduser = securityService.findLoggedInUsername();
		model.addAttribute("currentuser", usernameOfloggeduser);
		model.addAttribute("rooms2", rooms2);
		return "reservation";
	}

	@RequestMapping(value = "/reservationTest", method = RequestMethod.GET)
	public void reservationAjax(HttpServletRequest req) {
		// String id = req.getParameter("room_id");
		String id = req.getParameter("room_id");// in room_id dar jsp dar ajax neveshte shode ,yani dakhele httpreq
												// ,room_id gozashte shode
		Long id_room = Long.parseLong(id);
		System.out.println("idt: " + id);
		System.out.println("idt: " + id_room);
		// your logic here
		Optional<Room> clickedroom = roomservice.findById(id_room);
		boolean clickedroom_value;
		clickedroom_value = clickedroom.get().isConfirm();

		String usernameOfloggeduser = securityService.findLoggedInUsername();
		User currentuser = usrrpsitry.findByUsername(usernameOfloggeduser);

		List<Room> roomsOfcurrentuser = currentuser.getRooms();

		if (!clickedroom_value) {
			clickedroom.get().setConfirm(true);
			roomsOfcurrentuser.add(clickedroom.get());
			clickedroom.get().setUser(currentuser);
		} else {
			clickedroom.get().setConfirm(false);
			roomsOfcurrentuser.remove(clickedroom.get());
			clickedroom.get().setUser(null);
		}

		roomservice.saveRoom(clickedroom.get());

	}

}
