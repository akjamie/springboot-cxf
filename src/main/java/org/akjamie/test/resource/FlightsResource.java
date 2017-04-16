
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
import org.springframework.web.bind.annotation.RequestBody;

@Path("flights")
public interface FlightsResource {

	/**
	 * 
	 * @param destination
	 * 
	 * @param airline
	 * 
	 */
	@GET
	@Produces({ "application/json" })
	public List<Flight> getFlights(@QueryParam("origin") String Origin, @QueryParam("destination") String destination,
			@QueryParam("airline") Airline airline);

	@POST
	@Consumes("application/json")
	@Produces({ "application/json" })
	public Flight postFlights(@RequestBody @Valid Flight entity);

}
