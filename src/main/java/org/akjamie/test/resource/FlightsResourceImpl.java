package org.akjamie.test.resource;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.akjamie.test.entity.Airline;
import org.akjamie.test.entity.Flight;
import org.akjamie.test.service.FlightService;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.swagger.annotations.Api;

@Path("flights")
@Service
@Api("flights")
public class FlightsResourceImpl implements FlightsResource {
	@Autowired
	private FlightService flightService;

	@Valid
	@GET
	@Produces({ "application/json" })
	public List<Flight> getFlights(@NotEmpty String origin, @NotEmpty @QueryParam("destination") String destination,
			@QueryParam("airline") Airline airline) {
		List<Flight> list = null;
		list = flightService.findFlights(origin, destination, airline);
		return list;
	}

	@POST
	@Consumes("application/json")
	@Produces({ "application/json" })
	public Flight postFlights(@Valid Flight entity) {

		return flightService.add(entity);
	}

}
