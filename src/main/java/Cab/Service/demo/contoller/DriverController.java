package Cab.Service.demo.contoller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Cab.Service.demo.Service.DriverServiceImpl;
import Cab.Service.demo.model.Driver;

@RestController
@RequestMapping("/Driver")
public class DriverController {
	@Autowired
	DriverServiceImpl drive;
	
	@PostMapping("/insert")
	public Driver insertDriver(@RequestBody Driver driver) {
		return drive.insertDriver(driver);
		
	}
	
	@GetMapping("/best_drivers")
	public List<Driver> topDrivers(){
		return drive.ViewBestDrivers();
	}

}
