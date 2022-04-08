package Cab.Service.demo.Service;

import java.util.List;

import Cab.Service.demo.dto.Customerdto;
import Cab.Service.demo.model.AppUser;
import Cab.Service.demo.model.Customer;

public interface ICustomerService {
	Customer insertCustomer(Customer customer);

	Customer updateCustomer(Customer customer);

	Customer deleteCustomer();

	List<Customer> viewCustomers();

	String logoutUser();

	Customer loginUser(AppUser user);

	Customerdto viewCustomer();

}
