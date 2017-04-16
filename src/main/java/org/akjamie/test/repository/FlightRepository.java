package org.akjamie.test.repository;


import java.util.List;

import org.akjamie.test.entity.Airline;
import org.akjamie.test.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, String>{
	
	@Query("select flight from Flights flight where flight.destination like %:dest% and flight.origin like %:org% and flight.airline = :airline")
	public List<Flight> findAllFlights( @Param(value = "org") String origin, @Param(value = "dest") String destination, @Param(value="airline")Airline airline);
	
	@Query("select flight from Flights flight where flight.destination like %:dest% and flight.origin like %:org%")
	public List<Flight> findFlights( @Param(value = "org") String origin, @Param(value = "dest") String destination);
	
	
}
