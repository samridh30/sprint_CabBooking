package Cab.Service.demo.contoller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "http://localhost:3000/")
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

	// http://localhost:8088/cab/viewAll
	@GetMapping("/viewAll")
	public ResponseEntity<List<Cab>> ViewAllCabs() {
		return new ResponseEntity<List<Cab>>(car.viewAllCabs(), HttpStatus.OK);

	}

	// http://localhost:8088/cab/viewCabsOfType/{Type}
	@GetMapping("/viewCabsOfType/{Type}")
	public ResponseEntity<List<Cab>> viewCabsOfType(@PathVariable(name = "Type") String Type) {
		return new ResponseEntity<List<Cab>>(car.viewCabsOfType(Type), HttpStatus.OK);

	}

	// http://localhost:8088/cab/viewCabsOfType/{Type}
	@GetMapping("/availableCabs")
	public ResponseEntity<List<Integer>> getAvailableCabs() {
		return new ResponseEntity<List<Integer>>(car.getAvailableCabs(), HttpStatus.OK);

	}

	// http://localhost:8088/cab/countCabsOfType/{Type}
	@GetMapping("/countCabsOfType/{Type}")
	public ResponseEntity<Integer> countCabsOfType(@PathVariable(name = "Type") String Type) {
		return new ResponseEntity<Integer>(car.countCabsOfType(Type), HttpStatus.OK);

	}

	@GetMapping("/getCabById/{id}")
	public ResponseEntity<Cab> getCabByIDs(@PathVariable(name = "id") int cabId) {
		return new ResponseEntity<Cab>(car.getCabById(cabId), HttpStatus.OK);

	}
}
