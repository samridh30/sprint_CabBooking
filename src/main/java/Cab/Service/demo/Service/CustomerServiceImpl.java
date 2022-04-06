package Cab.Service.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Cab.Service.demo.Exception.CustomerNotFoundException;
import Cab.Service.demo.Exception.InvalidUserNamePasswordException;
import Cab.Service.demo.Exception.UserNotLoggedInException;
import Cab.Service.demo.dto.Customerdto;
import Cab.Service.demo.model.AppUser;
import Cab.Service.demo.model.Customer;
import Cab.Service.demo.model.Role;
import Cab.Service.demo.repository.CustomerRepositorImpl;
import Cab.Service.demo.repository.TripBookingRepositoryImpl;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private CustomerRepositorImpl custRepo;
	@Autowired
	private TripBookingRepositoryImpl trip;

	@Autowired
	Customer loggedInUser;

	@Override
	public Customer insertCustomer(Customer customer) {
//		System.out.println(loggedInUser.toString());
//		if (loggedInUser.equals(null)) {
		Optional<Customer> cus = custRepo.findByEmail(customer.getEmail());
		if (cus.isPresent()) {
			throw new InvalidUserNamePasswordException("Email Address Already Exists");
		} else {
			custRepo.save(customer);
			return customer;
		}
//		} else
//			throw new AlreadyLoggedInException("Already Logged in as a User");
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		if (loggedInUser.getRole() != null) {
			Optional<Customer> cus = custRepo.findById(customer.getCustomerId());
			if (cus.isPresent()) {
				custRepo.save(customer);
				return customer;
			} else {
				throw new CustomerNotFoundException("Invalid Customer");
			}
		} else
			throw new UserNotLoggedInException("Login First");
	}

	@Override
	public Customer deleteCustomer(int customerId) {
		if (loggedInUser.getRole() != null) {
			Optional<Customer> cus = custRepo.findById(customerId);
			if (cus.isPresent()) {

				trip.deleteTripByCustomerId(customerId);
				custRepo.deleteCustomerById(customerId);
				return cus.get();
			} else {
				throw new CustomerNotFoundException("Invalid Id-" + customerId);

			}
		} else {
			throw new UserNotLoggedInException("Login First");
		}

	}

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
			throw new InvalidUserNamePasswordException("Login First");
	}

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
			throw new UserNotLoggedInException("Login First");
	}

	@Override
	public Customer loginUser(AppUser user) {

		Optional<Customer> cust = custRepo.findByEmail(user.getEmail());
		if (user.getPassword().equals(cust.get().getPassword())) {
			loggedInUser = cust.get();
			return cust.get();
		} else
			throw new InvalidUserNamePasswordException("Invalid UserName or Password");
	}

//		System.out.println(customer.toString());
//		if (password.equals(customer.getPassword())) {
//			loggedInUser = customer;
//			return customer;
//		} else {
//			throw new InvalidUserNamePasswordException("Invalid UserName or Password");
//		}

	@Override
	public String logoutUser() {
		if (loggedInUser.getRole() != null) {
			String message = loggedInUser.getUserName();
			loggedInUser = null;
			return message + " is Logged Out";
		} else {
			throw new UserNotLoggedInException("Login First");
		}
//		if (loggedInUser.getUserName()) {
//			loggedInUser = null;
//			return "User LoggedOut";
//		} else
//			throw new InvalidUserNamePasswordException("Invalid UserName or Password");
	}
}
