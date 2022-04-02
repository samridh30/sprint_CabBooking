package Cab.Service.demo.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Cab.Service.demo.Service.CabServiceImpl;
import Cab.Service.demo.model.Cab;
@RestController
public class CabController {
	@Autowired
	CabServiceImpl car;
	
	@PostMapping("/insert")
	public Cab insertCab(@RequestBody Cab cab) {
		return car.insertCab(cab);
		
		
	}
	@PatchMapping("/update")
	public Cab updateCab(@RequestBody Cab cab) {
		return car.updateCab(cab);
	
	}
	@DeleteMapping("/Cab/Delete")
	public Cab deleteCab(Cab cab) {
		return car.deleteCab(cab);
	
	}

}
