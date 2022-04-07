package Cab.Service.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Cab.Service.demo.Exception.CustomerNotFoundException;
import Cab.Service.demo.Exception.InvalidAccessException;
import Cab.Service.demo.Exception.InvalidUserNamePasswordException;
import Cab.Service.demo.Exception.UserNotLoggedInException;
import Cab.Service.demo.dto.Customerdto;
import Cab.Service.demo.model.AppUser;
import Cab.Service.demo.model.Customer;
import Cab.Service.demo.model.Role;
import Cab.Service.demo.repository.CustomerRepositorImpl;
import Cab.Service.demo.repository.TripBookingRepositoryImpl;

/**
 * @desc Class for Customer services
 * @author  Srikanth
 * 
 */
@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private CustomerRepositorImpl custRepo;
	@Autowired
	private TripBookingRepositoryImpl trip;

	@Autowired
	Customer loggedInUser;
	
	/**
	 * @desc To Register a New customer to DataBase
	 * @return Customer Object
	 * 
	 */

	@Override
	public Customer insertCustomer(Customer customer) {
			Optional<Customer> cus = custRepo.findByEmail(customer.getEmail());
			if (cus.isPresent()) {
				throw new InvalidUserNamePasswordException("Email Address Already Exists");
			} else {
				custRepo.save(customer);
				return customer;
			}
		


	}

	/**
	 * @desc To Update Customer Data
	 * @return Customer
	 * 
	 */
	@Override
	public Customer updateCustomer(Customer customer) {
		if (loggedInUser.getRole() != null ) {
			if(loggedInUser.getCustomerId()==customer.getCustomerId()) {
			Optional<Customer> cus = custRepo.findById(customer.getCustomerId());
			if (cus.isPresent()) {
				custRepo.save(customer);
				return customer;
			} else {
				throw new CustomerNotFoundException("Invalid Customer");
			}
		}
			else{
				throw new InvalidAccessException("Access Denied");
			}
		}
			else {
			throw new UserNotLoggedInException("User Not Login");}
	}

	/**
	 * @desc To Delete a Customer 
	 * @return Deleted Customer Object
	 * 
	 */
	@Override
	public Customer deleteCustomer(int customerId) {
		if (loggedInUser.getRole() != null) {
			if(loggedInUser.getCustomerId()==customerId) {
			Optional<Customer> cus = custRepo.findById(customerId);
			if (cus.isPresent()) {

				trip.deleteTripByCustomerId(customerId);
				custRepo.deleteCustomerById(customerId);
				return cus.get();
			} else {
				throw new CustomerNotFoundException("Invalid Id-" + customerId);

			}
			
			}else {
				throw new InvalidAccessException("Access Denied");
				}
			
		} else {
			throw new UserNotLoggedInException("User Not Login");
		}

	}

	/**
	 * @desc To View all Customers
	 * @return List<Customer>
	 * 
	 */
	@Override
	public List<Customer> viewCustomers() {
		if (loggedInUser.getRole() == Role.ADMIN) {
			List<Customer> cus = custRepo.findAll();

			if (cus.isEmpty()) {
				throw new CustomerNotFoundException("Empty Table");
			} else {
				return cus;
			}
		} else
			throw new InvalidUserNamePasswordException("User Not Login");
	}

	/**
	 * @desc To View Customer Based On CustomerId
	 * @return Customer
	 * 
	 */
	@Override
	public Customerdto viewCustomer() {

		if (loggedInUser.getRole() != null) {
			Optional<Customer> cus = custRepo.findById(loggedInUser.getCustomerId());
			Customerdto dto = new Customerdto();
			dto.setCustomerId(cus.get().getCustomerId());
			dto.setUsername(cus.get().getUserName());
			if (cus.isPresent()) {
				return dto;
			} else {
				throw new CustomerNotFoundException("Invalid Id");
			}
		} else
			throw new UserNotLoggedInException("User Not Login");
	}

	/**
	 * @desc Login for Registered User
	 * @return Customer
	 * 
	 */
	@Override
	public Customer loginUser(AppUser user) {
		System.out.println(user.getEmail());

		Optional<Customer> cust = custRepo.findByEmail(user.getEmail());
		if (user.getPassword().equals(cust.get().getPassword())) {
			loggedInUser = cust.get();
			return cust.get();
		} else {
			throw new InvalidUserNamePasswordException("Invalid UserName or Password");}
	}


	

	/**
	 * @desc Logout fuction 
	 * @author  String(User Name)
	 * 
	 */
	@Override
	public String logoutUser() {
		if (loggedInUser.getRole() != null) {
			String message = loggedInUser.getUserName();
			loggedInUser = null;
			return message + " is Logged Out";
		} else {
			throw new UserNotLoggedInException("Login First");
		}
		

	}
}
