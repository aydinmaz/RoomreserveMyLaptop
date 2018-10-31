package it.finsoft.RoomReserve.repository;



import java.util.List;

//import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import it.finsoft.RoomReserve.model.RoomHour;
@Repository
public interface RoomRepository extends CrudRepository<RoomHour, Long> {
	
	public List<RoomHour> findAll();//mesl inke in yek function hast 
	
	
}

