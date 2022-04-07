package Cab.Service.demo.Service;

import java.util.List;

import Cab.Service.demo.dto.Customerdto;
import Cab.Service.demo.model.AppUser;
import Cab.Service.demo.model.Customer;

public interface ICustomerService {
	public Customer insertCustomer(Customer customer);

	public Customer updateCustomer(Customer customer);

	public Customer deleteCustomer();

	public List<Customer> viewCustomers();

	String logoutUser();

	Customer loginUser(AppUser user);

	Customerdto viewCustomer();

}
