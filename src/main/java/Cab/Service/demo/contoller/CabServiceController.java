package Cab.Service.demo.contoller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Cab.Service.demo.Service.CabServiceImpl;
import Cab.Service.demo.model.Cab;

@RestController
public class CabServiceController {
	@Autowired
	private CabServiceImpl cs;

	@PostMapping("/register")
	public Cab register(@RequestBody Cab appUser) {

		System.out.println("Started");
		return cs.insertCab(appUser);
	}

}