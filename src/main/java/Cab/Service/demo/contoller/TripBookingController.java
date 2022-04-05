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
	 * @desc created tripbooking
	 */
	//http://localhost:8088/Trip/insert
	@PostMapping("/insert")
	ResponseEntity<TripBooking> insertTripBooking(@RequestBody TripBooking tripBooking) {
		LOG.info(tripBooking.toString());
		return new ResponseEntity<TripBooking>(trip.insertTripBooking(tripBooking), HttpStatus.OK);
		
	}
	
	/**
	 * @desc To update data of bookedtrip
	 */
	//http://localhost:8088/Trip/update
	@PutMapping("/update")
	ResponseEntity<TripBooking> updateTripBooking(@RequestBody TripBooking tripBooking) {
		LOG.info(tripBooking.toString());
		return new ResponseEntity<TripBooking>(trip.updateTripBooking(tripBooking), HttpStatus.OK);
	}
	
	/**
	 * @desc Method Delete Tripbooking by tripbooking Id
	 */
	//http://localhost:8088/Trip/delete/{Id}
	@DeleteMapping("/delete/{Id}")
	ResponseEntity<TripBooking> deleteTripBooking(@PathVariable(name="Id") int Id) {
		LOG.info(Integer.toString(Id)+"Deleted");
		return new ResponseEntity<TripBooking>(trip.deleteTripBooking(Id), HttpStatus.OK);
	}
	
	/**
	 * @desc shows all trips of particular customer
	 */
	//http://localhost:8088/Trip/view/9
	@GetMapping("/view/{Id}")
	ResponseEntity<List<TripBooking>> viewAllTripsCustomer(@PathVariable(name="Id") int Id){
		LOG.info(Integer.toString(Id)+"Feteched");
		return new ResponseEntity<List<TripBooking>>(trip.ViewAllTripsCustomer(Id), HttpStatus.OK);
	}
	
	/**
	 * @desc calculates a tripbooking bill
	 */
	//http://localhost:8088/Trip/bill/{Id}
	@GetMapping("/bill/{Id}")
	ResponseEntity<TripBooking> calculateBill(@PathVariable(name="Id") int Id) {
		LOG.info(Integer.toString(Id)+"Bill");
		return new ResponseEntity<TripBooking>(trip.calculateBill(Id), HttpStatus.OK);
	}
	
	/**
	 * @desc Ends the trip
	 */
	//http://localhost:8088/Trip/endTrip/68
	@PutMapping("/endTrip/{Id}")
	ResponseEntity<TripBooking> endTrip(@PathVariable(name="Id") int Id) {
		LOG.info(Integer.toString(Id)+" "+"Updated");
		return new ResponseEntity<TripBooking>(trip.endTrip(Id), HttpStatus.OK);
	}
	
	
	/**
	 * @desc Book a cab
	 */
	
	//http://localhost:8088/Trip/view/kukatpally/nyz
	@GetMapping("/view/{fromlocation}/{tolocation}")
	ResponseEntity<Cabservicedto> BookCab(@PathVariable(name="fromlocation") String fromlocation, @PathVariable(name="tolocation") String tolocation){
		LOG.info(fromlocation+"Feteched");
		return new ResponseEntity<Cabservicedto>(trip.BookCab(fromlocation, tolocation, 114), HttpStatus.OK);
	}

	
	


}
