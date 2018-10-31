package it.finsoft.RoomReserve.controller;

import java.security.Principal;
//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.finsoft.RoomReserve.model.RoomHour;
import it.finsoft.RoomReserve.model.User;
import it.finsoft.RoomReserve.repository.RoomRepository;
import it.finsoft.RoomReserve.repository.UserRepository;
import it.finsoft.RoomReserve.service.SecurityService;
import it.finsoft.RoomReserve.service.UserService;
import it.finsoft.RoomReserve.validator.UserValidator;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private SecurityService securityService;

	@Autowired //
	private RoomRepository roomrpstry;

	@Autowired
	private UserRepository usrrpsitry;

	@Autowired
	private UserValidator userValidator;

	@RequestMapping(value = "registration", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("userForm", new User());
		return "registration";
	}

	@RequestMapping(value = "registration", method = RequestMethod.POST)
	public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
		userValidator.validate(userForm, bindingResult);
		if (bindingResult.hasErrors()) {
			return "/registration";
		}
		userService.save(userForm);
		securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());
		return "welcome";
	}

	@RequestMapping(value = "/reservation", method = RequestMethod.GET)
	public String reservation(Model model, Principal principal)
	// public String reservation(Model model)
	{ // List<Room> rooms2= new ArrayList<>();
		List<RoomHour> rooms = roomrpstry.findAll();

		// String usernameOfloggeduser = securityService.findLoggedInUsername();
		User currentuser = usrrpsitry.findByUsername(principal.getName());
		// User currentuser = usrrpsitry.findByUsername(usernameOfloggeduser);//har do
		// ravesh mishe ,ya prinicial ya in.
		model.addAttribute("currentuser", currentuser);
		model.addAttribute("rooms1", rooms);
		return "reservation";
	}

	@RequestMapping(value = "/reservationTest", method = RequestMethod.GET)
	public void reservationAjax(HttpServletRequest req) {
		// String id = req.getParameter("room_id");
		String id = req.getParameter("room_id");// in room_id dar jsp dar ajax neveshte shode ,yani dakhele httpreq
												// ,room_id gozashte shode

//	    	String id_part1 = id.substring(0,1);
//	    	String id_part2 = id.substring(1);

		Long id_room = Long.parseLong(id);
		System.out.println("idstring: " + id);
		System.out.println("idLong: " + id_room);
		// your logic here
		String usernameOfloggeduser = securityService.findLoggedInUsername();
		User currentuser = usrrpsitry.findByUsername(usernameOfloggeduser);
		Optional<RoomHour> clickedroomhour;
		boolean clickedroomhour_value;
		List<RoomHour> roomsOfcurrentuser;

		clickedroomhour = roomrpstry.findById(id_room);
		clickedroomhour_value = clickedroomhour.get().isConfirm();
		roomsOfcurrentuser = currentuser.getRooms();

		if (!clickedroomhour_value) {
			clickedroomhour.get().setConfirm(true);
			roomsOfcurrentuser.add(clickedroomhour.get());
			clickedroomhour.get().setUser(currentuser);
		} else {
			clickedroomhour.get().setConfirm(false);
			roomsOfcurrentuser.remove(clickedroomhour.get());
			clickedroomhour.get().setUser(null);
		}
		roomrpstry.save(clickedroomhour.get());

	}

	/*
	 * @RequestMapping(value="reservation",method=RequestMethod.POST)
	 * 
	 * public @ResponseBody String addId(@RequestBody Id id throws ParseException,
	 * IOException {
	 * 
	 * log.debug("Adding new person"); try {// perform add operation return
	 * "Successfully added person"; } catch (Exception ex) {} }
	 * 
	 */

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");

		return "login";
	}

	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public String welcome(Model model, Principal principal) {
		// String usernameOfloggeduser = securityService.findLoggedInUsername();
		// User currentuser = usrrpsitry.findByUsername(usernameOfloggeduser);
		User currentuser = usrrpsitry.findByUsername(principal.getName());
		model.addAttribute("currentuser", currentuser);
		return "welcome";
	}

}