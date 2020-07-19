package com.example.springboot;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface DestinationsRepository extends CrudRepository<Destination, Long> {
	
	
//	ArrayList<Destination> findByid(String id);
	
//	Destination findById(String id);
/*	
	@Modifying
    @Query("insert into DESTINATIONS (id,city,state,country) ")
    public Destination modifyingQueryInsertDestination(@Param("id")String id, @Param("city")String name, @Param("state")String age, @Param("country")String country);
	
	

	
	@Transactional
	@Modifying
	@Query(value = "insert into holidays.DESTINATIONS (ID,CITY,STATE,COUNTRY) "
            + "VALUES (:#{#sp.id},:#{#sp.city},  :#{#sp.state} ,:#{#sp.country} )", nativeQuery = true)
    public void addDest(@Param("sp") Destination sp);
*/
	
	Destination save(Destination dest);
	
	
}
