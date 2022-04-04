package Cab.Service.demo.contoller;

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

	@PostMapping("/insert")
	public ResponseEntity<Cab> insertCab(@RequestBody Cab cab) {
		LOG.info(cab.toString());
		return new ResponseEntity<Cab>(car.insertCab(cab), HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<Cab> updateCab(@RequestBody Cab cab) {
		LOG.info(cab.toString());
		return new ResponseEntity<Cab>(car.updateCab(cab), HttpStatus.CREATED);
	}

//	@DeleteMapping("/delete/{cabId}")
	public ResponseEntity<Cab> deleteCab(@PathVariable(name = "cabId") String cabId) {
		LOG.info(cabId);
		return new ResponseEntity<Cab>(car.deleteCab(Integer.parseInt(cabId)), HttpStatus.OK);
	}

	@GetMapping("/view")
	ResponseEntity<Cab> viewCabsofType(String carType) {
		LOG.info(carType);
		return new ResponseEntity<Cab>(car.viewCabsofType(carType), HttpStatus.OK);
	}
}
