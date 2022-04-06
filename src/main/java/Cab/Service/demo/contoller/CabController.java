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

import Cab.Service.demo.Service.CabServiceImpl;
import Cab.Service.demo.model.Cab;

@RestController
@RequestMapping("/cab")
public class CabController {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CabServiceImpl car;
	
	// http://localhost:8088/cab/insert-cab
		// Inserts a new cab
	@PostMapping("/insert-cab")
	public ResponseEntity<Cab> insertCab(@RequestBody Cab cab) {
		LOG.info(cab.toString());
		return new ResponseEntity<Cab>(car.insertCab(cab), HttpStatus.CREATED);
	}
	// http://localhost:8088/cab/update-cab
		// Updates an existing cab
	@PutMapping("/update-cab")
	public ResponseEntity<Cab> updateCab(@RequestBody Cab cab) {
		LOG.info(cab.toString());
		return new ResponseEntity<Cab>(car.updateCab(cab), HttpStatus.CREATED);
	}
	// http://localhost:8088/cab/delete-cab
		// deletes an existing cab based on cabId
	@DeleteMapping("/delete/{cabId}")
	public ResponseEntity<Cab> deleteCab(@PathVariable(name = "cabId") int cabId) {
		LOG.info(Integer.toString(cabId));
		return new ResponseEntity<Cab>(car.deleteCab(cabId), HttpStatus.OK);
	}

//	@GetMapping("/view")
//	ResponseEntity<Cab> ViewAllCabs(@PathVariable(name = "carType") String carType) {
//		LOG.info(carType);
//		return new ResponseEntity<Cab>(car.viewCabsofType(carType), HttpStatus.OK);
//	}

	@GetMapping("/viewAll")
	public ResponseEntity<List<Cab>> ViewAllCabs() {
//		LOG.info(carType);
		return new ResponseEntity<List<Cab>>(car.viewAllCabs(), HttpStatus.OK);

	}
}
