package Cab.Service.demo.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Cab.Service.demo.Service.AdminServiceImpl;
import Cab.Service.demo.dto.TripDateDto;
import Cab.Service.demo.model.TripBooking;


@RestController
@RequestMapping("/admin")
public class AdminController {



	@Autowired
	private AdminServiceImpl adm;

//	http://localhost:8088/admin/getAllTrips
	@GetMapping("/getAllTrips")
	public ResponseEntity<List<TripBooking>> getAllTrips() {

		return new ResponseEntity<List<TripBooking>>(adm.getAllTrips(), HttpStatus.OK);
	}

	@GetMapping("/getByCabs")
	public ResponseEntity<List<TripBooking>> getByCabs() {

		return new ResponseEntity<List<TripBooking>>(adm.getTripsCabwise(), HttpStatus.OK);
	}

	@GetMapping("/getByCustomer")
	public ResponseEntity<List<TripBooking>> getByCustomer() {
		return new ResponseEntity<List<TripBooking>>(adm.getTripsCustomerwise(), HttpStatus.OK);
	}

	@GetMapping("/getByDate")
	public ResponseEntity<List<TripBooking>> getByDate() {
		return new ResponseEntity<List<TripBooking>>(adm.getTripsDatewise(), HttpStatus.OK);
	}

	@PostMapping("/getBySetDate")
	public ResponseEntity<List<TripBooking>> getByCustomDate(@RequestBody TripDateDto trip) {

		return new ResponseEntity<List<TripBooking>>(adm.getAllTripsForDays(trip), HttpStatus.OK);
	}
}
