package Cab.Service.demo.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import Cab.Service.demo.Service.CustomerServiceImpl;
import Cab.Service.demo.model.Customer;

@RestController
@RequestMapping("/Customer")
public class CustomerController {
	@Autowired
	private CustomerServiceImpl cust;
	
	@PostMapping("/register")
	public Customer register(@RequestBody Customer appUser) {
		
		
		System.out.println("Started");
		return cust.insertCustomer(appUser);
	}


}
