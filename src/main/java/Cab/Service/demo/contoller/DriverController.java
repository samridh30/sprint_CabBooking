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

import Cab.Service.demo.Service.DriverServiceImpl;
import Cab.Service.demo.model.Driver;

@RestController

@RequestMapping("/driver")

public class DriverController {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private DriverServiceImpl drive;

	// http://localhost:8088/drv/insert-driver
	// Inserts a new driver
	@PostMapping("/insert")
	public ResponseEntity<Driver> intDriver(@RequestBody Driver driver) {

		LOG.info("Insert Driver");
		return new ResponseEntity<Driver>(drive.insertDriver(driver), HttpStatus.CREATED);

	}

	// http://localhost:8088/drv/update-driver
	// Updates an existing driver
	@PutMapping("/update")
	public ResponseEntity<Driver> updtDriver(@RequestBody Driver driver) {
		LOG.info(driver.toString());

		return new ResponseEntity<Driver>(drive.updateDriver(driver), HttpStatus.OK);

	}

	// http://localhost:8088/drv/delete-driver/{did}
	// Deletes an existing driver
	@DeleteMapping("/delete/{did}")
	public ResponseEntity<Driver> delDriver(@PathVariable(name = "did") int driverId) {
		LOG.info(Integer.toString(driverId));
		return new ResponseEntity<Driver>(drive.deleteDriver(driverId), HttpStatus.OK);

	}

	// http://localhost:8088/drv/best-drivers
	// Fetches all the best drivers as a List
	@GetMapping("/bestDrivers")
	public ResponseEntity<List<Driver>> topDrivers() {
		LOG.info("Best Drivers Fetched");
		return new ResponseEntity<List<Driver>>(drive.ViewBestDrivers(), HttpStatus.OK);
	}

	// http://localhost:8088/drv/view-drivers/{did}
	// Fetches a driver based on driver Id
	@GetMapping("/viewDrivers/{did}")
	public ResponseEntity<Driver> ViewDriver(@PathVariable(name = "did") int driverId) {
		LOG.info(Integer.toString(driverId));
		return new ResponseEntity<Driver>(drive.viewDriver(driverId), HttpStatus.OK);

	}

	@GetMapping("/viewAllDrivers")
	public ResponseEntity<List<Driver>> ViewDriver() {
		LOG.info("All Drivers Fetched");
		return new ResponseEntity<List<Driver>>(drive.ViewAllDrivers(), HttpStatus.OK);

	}
}
