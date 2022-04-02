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

	@PutMapping("/update/")
	public Customer updateCustomer(@RequestBody Customer customer) {
		return cust.updateCustomer(customer);
	}
	
	@DeleteMapping("/delete/{Id}")
	public Customer deleteCustomer(@PathVariable(name="Id") int Id) {
		return cust.deleteCustomer(Id);
		
	}
	

	@GetMapping("/AllCustomers")
	public List<Customer> viewCustomers(){
		return cust.viewCustomers();
	}

	@GetMapping("/viewCustomer/{Id}")
	public Customer viewCustomer(@PathVariable(name="Id") int Id) {
		return cust.viewCustomer(Id);
	}
	
	


}
