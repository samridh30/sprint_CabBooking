package Cab.Service.demo.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import Cab.Service.demo.model.AppUser;
import Cab.Service.demo.model.Customer;
import Cab.Service.demo.model.Role;


@SpringBootTest
public class CustomerServiceImplTest {
	@Autowired
	CustomerServiceImpl cusService;
	
	@BeforeEach
	void start() {
		AppUser app = new AppUser();
		app.setEmail("Testing@gmail.com");
		app.setPassword("Testing@");
		cusService.loginUser(app);
				}
	
	@AfterEach
	void end() {
		cusService.logoutUser();
	}
	
	/**
	 * @desc Testing Insert Customer Method 
	 */

	@Disabled
	@Test
	void insertCustomerTest() {
		Customer c= new Customer(1000,"mahesh","mahesh@","Hyderabad",1234567890L, "Mahesh@gmail.com",Role.CUSTOMER);
		Customer insertTest=cusService.insertCustomer(c);
		assertEquals("Mahesh@gmail.com",insertTest.getEmail());
		assertEquals("mahesh@", insertTest.getPassword());
		}
	/**
	 * @desc Testing Update Customer Method 
	 */
	@Disabled
	@Test
	void updateCustomerTest() {
		
		Customer update= new Customer(230,"Testing","Testing@","NYZ",1234567890L, "Testing@gmail.com",Role.CUSTOMER);

		Customer updateTest= cusService.updateCustomer(update);
		assertEquals("NYZ",updateTest.getAddress());
		}
	/**
	 * @desc Testing Delete Customer Method 
	 */
	@Disabled
	@Test
	void deleteCustomerTest() {
		Customer deleteTest= cusService.deleteCustomer();
		assertEquals(230, deleteTest.getCustomerId());
		assertEquals("Hyderabad", deleteTest.getUserName());
	}
	
	/**
	 * @desc Testing view Customer Method 
	 */
	@Disabled
	@Test
	void viewCustomersTest() {
		AppUser app = new AppUser();
		app.setEmail("Sajal@gmail.com");
		app.setPassword("Sajal@");
		cusService.loginUser(app);
		
		List<Customer> viewCustomerTest= cusService.viewCustomers();
		assertEquals(5, viewCustomerTest.size());
		
	}
	


}
