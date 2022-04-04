package Cab.Service.demo.contoller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
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

@RequestMapping("/drv")


public class DriverController {
	@Autowired
	private DriverServiceImpl drive;
	

	//http://localhost:8088/drv/insert-driver
	@PostMapping("/insert-driver")
	public Driver intDriver(@RequestBody Driver driver) {

	
		return drive.insertDriver(driver);
		
	}
	//http://localhost:8088/drv/update-driver
	@PutMapping("/update-driver")
	public Driver updtDriver(Driver driver) {
		return drive.updateDriver(driver);
		
	}
	//http://localhost:8088/drv/delete-driver/{did}
	@DeleteMapping("/delete-driver")
	public Driver delDriver( @PathVariable(name ="did") int driverId) {
		return drive.deleteDriver(driverId);
		
	}
	
	//http://localhost:8088/drv/best-drivers
	@GetMapping("/best-drivers")
	public List<Driver> topDrivers(){
		return drive.ViewBestDrivers();
	}

	//http://localhost:8088/drv/view-drivers/{did}
	@GetMapping("/view-driver")
	public Driver ViewDriver( @PathVariable(name = "did") int driverId) {
		return drive.viewDriver(driverId);
		
	}
}
