package org.akjamie.test.service;

import java.util.List;

import org.akjamie.test.entity.Airline;
import org.akjamie.test.entity.Flight;
import org.akjamie.test.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FlightService {

	@Autowired
	@Qualifier("flightRepository")
	private FlightRepository repository;

	public List<Flight> findFlights(String origin, String destination, Airline airline) {
		List<Flight> rsList = null;
		if(airline != null){
			rsList = repository.findAllFlights(origin, destination, airline);
		}else{
			rsList = repository.findFlights(origin, destination);
		}
		return rsList;
	}

	@Transactional
	public Flight add(Flight flight) {

		return repository.save(flight);
	}

}
