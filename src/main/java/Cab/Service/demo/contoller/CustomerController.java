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



import Cab.Service.demo.Service.CustomerServiceImpl;
import Cab.Service.demo.model.Customer;

@RestController
@RequestMapping("/Customer")
public class CustomerController {
	@Autowired
	private CustomerServiceImpl cust;
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	@PostMapping("/register")
	public ResponseEntity<Customer> register(@RequestBody Customer appUser) {
		LOG.info("Register Customer");
		return new ResponseEntity<Customer>(cust.insertCustomer(appUser), HttpStatus.OK);
	}
	@PutMapping("/update")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
		LOG.info(customer.toString());
		return new ResponseEntity<Customer>(cust.updateCustomer(customer),HttpStatus.OK);
	}
	@DeleteMapping("/delete/{Id}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable(name="Id") int Id) {
		LOG.info(Integer.toString(Id));
		return new ResponseEntity<Customer>(cust.deleteCustomer(Id), HttpStatus.OK);
		
	}
	@GetMapping("/AllCustomers")
	public ResponseEntity<List<Customer>> viewCustomers(){
		LOG.info("All Customers Fetched");
		return new ResponseEntity<List<Customer>>(cust.viewCustomers(), HttpStatus.OK);
	}
	@GetMapping("/viewCustomer/{Id}")
	public ResponseEntity<Customer> viewCustomer(@PathVariable(name="Id") int Id) {
		return new ResponseEntity<Customer>(cust.viewCustomer(Id), HttpStatus.OK);
	}
	
	


}
