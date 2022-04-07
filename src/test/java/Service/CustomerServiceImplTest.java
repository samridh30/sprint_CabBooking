package Service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import Cab.Service.demo.Service.CustomerServiceImpl;
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
		app.setEmail("Sri@gmail.com");
		app.setPassword("Srikanth@");
		cusService.loginUser(app);
				}
	
	@AfterEach
	void end() {
		cusService.logoutUser();
	}
	
	@Disabled
	@Test
	void insertCustomerTest() {
		Customer c= new Customer(1000,"xxxx","xxxx@","xxxx",1234567890L, "xxx@gmail.com",Role.CUSTOMER);
		Customer insertTest=cusService.insertCustomer(c);
		assertEquals(1000,insertTest.getCustomerId());
		}
	
	@Disabled
	@Test
	void updateCustomerTest() {
		
		Customer update= new Customer(174,"xxxx","xxxxx@","xxxz",1234567890L, "xxx@gmail.com",Role.CUSTOMER);

		Customer updateTest= cusService.updateCustomer(update);
		assertEquals("xxxz",updateTest.getAddress());
		}
	
	@Disabled
	@Test
	void deleteCustomerTest() {
		Customer deleteTest= cusService.deleteCustomer(174);
		assertEquals(174, deleteTest.getCustomerId());
		assertEquals("xxxx", deleteTest.getUserName());
	}
	
	@Disabled
	@Test
	void viewCustomersTest() {
		
		List<Customer> viewCustomerTest= cusService.viewCustomers();
		assertEquals(5, viewCustomerTest.size());
		
	}
	


}
