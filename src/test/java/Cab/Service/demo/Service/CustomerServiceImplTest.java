package Cab.Service.demo.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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
		Customer c= new Customer(230,"Testing","Testing@","Hyderabad",1234567890L, "Testing@gmail.com",Role.CUSTOMER);
		Customer insertTest=cusService.insertCustomer(c);
		assertEquals("Testing@gmail.com",insertTest.getEmail());
		assertEquals("Testing@", insertTest.getPassword());
		}
	
	/**
	 * @desc Testing Update Customer Method 
	 */
	@Disabled
	@Test
	void updateCustomerTest() {
		
		Customer expected= new Customer(230,"Testing","Testing@","Hyderabad",1234567890L, "Testing@gmail.com",Role.CUSTOMER);

		Customer actual= cusService.updateCustomer(expected);
		assertEquals(expected,actual);
		}
	
	@Disabled
	@Test
	void updateCustomerNegativeTest() {
		
		Customer unexcepted= new Customer(9,"Testing","Testing@","NYZ",1234567890L, "dnhuuo@gmail.com",Role.CUSTOMER);

		Customer actual= cusService.updateCustomer(new Customer(230,"Testing","Testing@","NYZ",1234567890L, "Testing@gmail.com",Role.CUSTOMER));
		assertNotEquals(unexcepted.getCustomerId(),actual.getCustomerId());
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
	
	@Disabled
	@Test
	void deleteCustomerNegativeTest() {
		Customer deleteTest= cusService.deleteCustomer();
		assertNotEquals(9, deleteTest.getCustomerId());
		assertNotEquals("Hyderabad", deleteTest.getUserName());
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
		assertEquals(6, viewCustomerTest.size());
		
	}
	

	
	@Disabled
	@Test
	void viewCustomersNegativeTest() {
		AppUser app = new AppUser();
		app.setEmail("Sajal@gmail.com");
		app.setPassword("Sajal@");
		cusService.loginUser(app);
		
		List<Customer> viewCustomerTest= cusService.viewCustomers();
		assertNotEquals(5, viewCustomerTest.size());
		
	}
	


}
