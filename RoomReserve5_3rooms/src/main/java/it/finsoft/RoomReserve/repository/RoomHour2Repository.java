package it.finsoft.RoomReserve.repository;

import java.util.List;

//import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.finsoft.RoomReserve.model.RoomHour2;

@Repository
public interface RoomHour2Repository extends CrudRepository<RoomHour2, Long> {

	public List<RoomHour2> findAll();// mesl inke in yek function hast

}