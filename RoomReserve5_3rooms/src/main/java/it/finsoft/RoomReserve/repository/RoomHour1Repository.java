package it.finsoft.RoomReserve.repository;

import java.util.List;

//import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.finsoft.RoomReserve.model.RoomHour1;

@Repository
public interface RoomHour1Repository extends CrudRepository<RoomHour1, Long> {

	public List<RoomHour1> findAll();// mesl inke in yek function hast

}
