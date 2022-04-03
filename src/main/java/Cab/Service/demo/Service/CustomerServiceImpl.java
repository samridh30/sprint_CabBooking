package Cab.Service.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Cab.Service.demo.Exception.CustomerNotFoundException;
import Cab.Service.demo.model.Customer;
import Cab.Service.demo.repository.CustomerRepositorImpl;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private CustomerRepositorImpl custRepo;

	@Override
	public Customer insertCustomer(Customer customer) {
		Optional<Customer> cus = custRepo.findById(customer.getCustomerId());
		if (cus.isPresent()) {
			return null;
		} else {
			custRepo.save(customer);
			return customer;
		}

	}
	

	@Override
	public Customer updateCustomer(Customer customer) {
		Optional<Customer> cus = custRepo.findById(customer.getCustomerId());
		if (cus.isPresent()) {
			custRepo.save(customer);
			return customer;
		} else {
			 throw new CustomerNotFoundException("Invalid Customer");
		}
	}

	@Override
	public Customer deleteCustomer(int customerId) {
		Optional<Customer> cus = custRepo.findById(customerId);
		if (cus.isPresent()) {
			custRepo.deleteById(customerId);
			return cus.get();
		}else {
			throw new CustomerNotFoundException("Invalid Id-"+customerId);
		}
	}

	@Override
	public List<Customer> viewCustomers() {
		List<Customer> cus = custRepo.findAll();
		if (cus.isEmpty()) {
			throw new CustomerNotFoundException("Empty Table");
		} else {
			return cus;
		}
	}

	@Override
	public Customer viewCustomer(int customerId) {
		Optional<Customer> cus = custRepo.findById(customerId);
		if (cus.isPresent()) {
			return cus.get();
		} else {
			throw new CustomerNotFoundException("Invalid Id");
		}
	}

	@Override
	public Customer validateCustomer(String userName, String password) {
		Customer cus = custRepo.findByUserName(userName);
		if (userName == cus.getUserName() && password == cus.getPassword()) {
			return cus;
		} else {
			return null;
		}
	}

}
