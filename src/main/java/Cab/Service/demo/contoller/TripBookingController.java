package Cab.Service.demo.contoller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Cab.Service.demo.Service.TripBookingServiceImpl;
import Cab.Service.demo.dto.Cabservicedto;
import Cab.Service.demo.model.TripBooking;

@RestController
@RequestMapping("/Trip")
public class TripBookingController {
	
	@Autowired
	TripBookingServiceImpl trip;
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * @desc To update data of bookedtrip
	 * {@link= http://localhost:8088/Trip/update}
	 */
	@PutMapping("/update")
	ResponseEntity<TripBooking> updateTripBooking(@RequestBody TripBooking tripBooking) {
		LOG.info(tripBooking.toString());
		return new ResponseEntity<TripBooking>(trip.updateTripBooking(tripBooking), HttpStatus.OK);
	}
	
	/**
	 * @desc Method Delete Tripbooking by tripbooking Id
	 * {@link=http://localhost:8088/Trip/delete/{Id}}
	 */

	@DeleteMapping("/delete/{Id}")
	ResponseEntity<TripBooking> deleteTripBookingByTripId(@PathVariable(name="Id") int Id) {
		LOG.info(Integer.toString(Id)+"Deleted");
		return new ResponseEntity<TripBooking>(trip.deleteTripBooking(Id), HttpStatus.OK);
	}
	
	/**
	 * @desc shows all trips of particular customer
	 * {@link=http://localhost:8088/Trip/view/{Id}
	 */
	
	@GetMapping("/view/{Id}")
	ResponseEntity<List<TripBooking>> viewAllTripsCustomerByCustomerId(@PathVariable(name="Id") int Id){
		LOG.info(Integer.toString(Id)+"Feteched");
		return new ResponseEntity<List<TripBooking>>(trip.ViewAllTripsCustomer(Id), HttpStatus.OK);
	}
	
	
	/**
	 * @desc Ends the trip
	 * {@link=http://localhost:8088/Trip/endTrip/68}
	 */
	@PutMapping("/endTrip/{Id}")
	ResponseEntity<TripBooking> endTrip(@PathVariable(name="Id") int Id) {
		LOG.info(Integer.toString(Id)+" "+"Updated");
		return new ResponseEntity<TripBooking>(trip.endTrip(Id), HttpStatus.OK);
	}
	
	
	/**
	 * @desc Book a cab
	 * {@link=//http://localhost:8088/Trip/view/kukatpally/nyz}l
	 */
	@GetMapping("/view/{fromlocation}/{tolocation}")
	ResponseEntity<Cabservicedto> BookCab(@PathVariable(name="fromlocation") String fromlocation, @PathVariable(name="tolocation") String tolocation){
		LOG.info(fromlocation+"Feteched");
		return new ResponseEntity<Cabservicedto>(trip.BookCab(fromlocation, tolocation), HttpStatus.OK);
	}

	
	


}
