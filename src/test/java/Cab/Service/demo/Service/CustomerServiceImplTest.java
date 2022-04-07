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
		app.setEmail("Mahesh@gmail.com");
		app.setPassword("mahesh@");
		cusService.loginUser(app);
				}
	
	@AfterEach
	void end() {
		cusService.logoutUser();
	}
	

	@Disabled
	@Test
	void insertCustomerTest() {
		Customer c= new Customer(1000,"mahesh","mahesh@","Hyderabad",1234567890L, "Mahesh@gmail.com",Role.CUSTOMER);
		Customer insertTest=cusService.insertCustomer(c);
		assertEquals("Mahesh@gmail.com",insertTest.getEmail());
		assertEquals("mahesh@", insertTest.getPassword());
		}
	
	@Disabled
	@Test
	void updateCustomerTest() {
		
		Customer update= new Customer(214,"srikanth","mahesh@","Hyderabad",1234567890L, "Mahesh@gmail.com",Role.CUSTOMER);

		Customer updateTest= cusService.updateCustomer(update);
		assertEquals("Hyderabad",updateTest.getAddress());
		}
	
	@Disabled
	@Test
	void deleteCustomerTest() {
		Customer deleteTest= cusService.deleteCustomer();
		assertEquals(207, deleteTest.getCustomerId());
		assertEquals("Hyderabad", deleteTest.getUserName());
	}
	
	@Disabled
	@Test
	void viewCustomersTest() {
		
		List<Customer> viewCustomerTest= cusService.viewCustomers();
		assertEquals(5, viewCustomerTest.size());
		
	}
	


}
