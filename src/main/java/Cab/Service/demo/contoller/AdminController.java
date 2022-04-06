package Cab.Service.demo.contoller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

//admin/Driver/getDriver
///admin/cab/getCabs
@RestController
@RequestMapping("/admin")
public class AdminController {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AdminServiceImpl adm;

//	http://localhost:8088/admin/getCabs
	@GetMapping("/getAllTrips")
	public ResponseEntity<List<TripBooking>> getAllTrips() {
//		LOG.info(carType);
		return new ResponseEntity<List<TripBooking>>(adm.getAllTrips(), HttpStatus.OK);
	}

	@GetMapping("/getByCabs")
	public ResponseEntity<List<TripBooking>> getByCabs() {
//		LOG.info(carType);
		return new ResponseEntity<List<TripBooking>>(adm.getTripsCabwise(), HttpStatus.OK);
	}

	@GetMapping("/getByCustomer")
	public ResponseEntity<List<TripBooking>> getByCustomer() {
//		LOG.info(carType);
		return new ResponseEntity<List<TripBooking>>(adm.getTripsCustomerwise(), HttpStatus.OK);
	}

	@GetMapping("/getByDate")
	public ResponseEntity<List<TripBooking>> getByDate() {
//		LOG.info(carType);
		return new ResponseEntity<List<TripBooking>>(adm.getTripsDatewise(), HttpStatus.OK);
	}

	@PostMapping("/getBySetDate")
	public ResponseEntity<List<TripBooking>> getByCustomDate(@RequestBody TripDateDto trip) {
//		LOG.info(carType);
		return new ResponseEntity<List<TripBooking>>(adm.getAllTripsForDays(trip), HttpStatus.OK);
	}
}
