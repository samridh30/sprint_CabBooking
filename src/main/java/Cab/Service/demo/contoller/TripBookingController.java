package Cab.Service.demo.contoller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Cab.Service.demo.Service.TripBookingServiceImpl;
import Cab.Service.demo.model.TripBooking;

@RestController
@RequestMapping("/Trip")
public class TripBookingController {
	//insertTripBooking
	TripBookingServiceImpl trip;
	@PostMapping("/insert")
	TripBooking insertTripBooking(@RequestBody TripBooking tripBooking) {
		return trip.insertTripBooking(tripBooking);
		
	}
	//updateTripbooking
	@PatchMapping("/update")
	TripBooking updateTripBooking(@RequestBody TripBooking tripBooking) {
		return trip.updateTripBooking(tripBooking);
	}
	
	//deleteTripBooking
	@DeleteMapping("/delete/{Id}")
	TripBooking deleteTripBooking(@PathVariable(name="Id") int Id) {
		return trip.deleteTripBooking(Id);
	}
	//viewAllTripsCustomer
	@GetMapping("/view/{Id}")
	List<TripBooking> viewAllTripsCustomer(@PathVariable(name="Id") int Id){
		return trip.ViewAllTripsCustomer(Id);
	}
	//calculateBill
	@GetMapping("/bill/{Id}")
	TripBooking calculateBill(@PathVariable(name="Id") int Id) {
		return trip.calculateBill(Id);
	}

}
