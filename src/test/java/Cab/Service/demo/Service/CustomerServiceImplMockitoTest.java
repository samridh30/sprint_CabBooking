package Cab.Service.demo.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import Cab.Service.demo.dto.Customerdto;
import Cab.Service.demo.model.AppUser;
import Cab.Service.demo.model.Customer;
import Cab.Service.demo.model.Role;
import Cab.Service.demo.repository.CustomerRepositorImpl;
import Cab.Service.demo.repository.DriverRepositoryImpl;
import Cab.Service.demo.repository.TripBookingRepositoryImpl;

@ExtendWith(SpringExtension.class)
public class CustomerServiceImplMockitoTest {

	@InjectMocks
	CustomerServiceImpl cusService;
	@InjectMocks
	TripBookingServiceImpl tripService;
	@Mock
	CustomerServiceImpl CustRepo;
	@Mock
	CustomerRepositorImpl custRepo;
	@Mock
	DriverRepositoryImpl driverRepo;
	@Mock
	TripBookingRepositoryImpl tripRepo;

	LocalDateTime now = LocalDateTime.now();

	/**
	 * @desc UserLogin method Called before Every TestCase
	 */

	@BeforeEach
	void start() {
		AppUser app = new AppUser();
		app.setEmail("Srikanth@gmail.com");
		app.setPassword("Srikanth@");
		Customer c = new Customer(205, "Srikanth", "Srikanth@", "Hyderabad", 1234567890L, "Srikanth@gmail.com",
				Role.CUSTOMER, "Active");
		Mockito.when(custRepo.findByEmail("Srikanth@gmail.com")).thenReturn(Optional.of(c));
		cusService.loginUser(app);

	}

	/**
	 * @desc User Logout Method called after Every Test Case
	 */
	@AfterEach
	void end() {
		cusService.logoutUser();
	}

	/**
	 * @desc Testing Insert Customer Method using Mockito
	 */

	@Disabled
	@Test
	void insertCustomerTest() {
		AppUser app = new AppUser();
		app.setEmail("Sajal@gmail.com");
		app.setPassword("Sajal@");
		cusService.loginUser(app);

		Optional<Customer> c = Optional.of(new Customer(205, "Srikanth", "Srikanth@", "Hyderabad", 1234567890L,
				"Srikanth@gmail.com", Role.CUSTOMER, "Active"));
		Mockito.when(custRepo.findByEmail(c.get().getEmail())).thenReturn(null);
		Mockito.when(custRepo.save(c.get())).thenReturn(c.get());

		Customer insertTest = cusService.insertCustomer(c.get());
		assertEquals(11, insertTest.getCustomerId());
	}

	@Disabled
	@Test
	void insertCustomerNegativeTest() {
		AppUser app = new AppUser();
		app.setEmail("Sajal@gmail.com");
		app.setPassword("Sajal@");
		cusService.loginUser(app);

		Optional<Customer> c = Optional.of(new Customer(205, "Srikanth", "Srikanth@", "Hyderabad", 1234567890L,
				"Srikanth@gmail.com", Role.CUSTOMER, "Active"));
		Mockito.when(custRepo.findByEmail(c.get().getEmail())).thenReturn(null);
		Mockito.when(custRepo.save(c.get())).thenReturn(c.get());

		Customer insertTest = cusService.insertCustomer(c.get());
		assertNotEquals(12, insertTest.getCustomerId());
	}

	/**
	 * @desc Testing Update Customer Method using Mockito
	 */

	@Test
	void updateCustomerTest() {
		AppUser app = new AppUser();
		app.setEmail("Srikanth@gmail.com");
		app.setPassword("Srikanth@");
		Customer c = new Customer(205, "Srikanth", "Srikanth@", "Hyderabad", 1234567890L, "Srikanth@gmail.com",
				Role.CUSTOMER, "Active");
		Mockito.when(custRepo.findByEmail("Srikanth@gmail.com")).thenReturn(Optional.of(c));
		Mockito.when(custRepo.findById(205)).thenReturn(Optional.of(c));
		Mockito.when(custRepo.save(c)).thenReturn(c);
		Customer updatedCustomer = cusService.updateCustomer(c);

		assertEquals(205, updatedCustomer.getCustomerId());

	}

	@Test
	void updateCustomerNegativeTest() {
		AppUser app = new AppUser();
		app.setEmail("Srikanth@gmail.com");
		app.setPassword("Srikanth@");
		Customer c = new Customer(205, "Srikanth", "Srikanth@", "Hyderabad", 1234567890L, "Srikanth@gmail.com",
				Role.CUSTOMER, "Active");
		Mockito.when(custRepo.findByEmail("Srikanth@gmail.com")).thenReturn(Optional.of(c));
		Mockito.when(custRepo.findById(205)).thenReturn(Optional.of(c));
		Mockito.when(custRepo.save(c)).thenReturn(c);
		Customer updatedCustomer = cusService.updateCustomer(c);

		assertNotEquals(206, updatedCustomer.getCustomerId());

	}

	/**
	 * @desc Testing Delete Customer Method using Mockito
	 */

	@Test
	void deleteCustomerTest() {
		AppUser app = new AppUser();
		app.setEmail("Srikanth@gmail.com");
		app.setPassword("Srikanth@");
		Customer c = new Customer(205, "Srikanth", "Srikanth@", "Hyderabad", 1234567890L, "Srikanth@gmail.com",
				Role.CUSTOMER, "Active");
		Mockito.when(custRepo.findByEmail("Srikanth@gmail.com")).thenReturn(Optional.of(c));
		cusService.loginUser(app);
		Optional<Customer> c1 = Optional.of(new Customer(205, "Srikanth", "Srikanth@", "Hyderabad", 1234567890L,
				"Srikanth@gmail.com", Role.CUSTOMER, "Active"));
		Mockito.when(custRepo.findById(c1.get().getCustomerId())).thenReturn(c1);
		Mockito.doNothing().when(tripRepo).deleteTripByCustomerId(205);
		Mockito.doNothing().when(custRepo).deleteCustomerById(205);
		Customer deleteTest = cusService.deleteCustomer(205);
		assertEquals(205, deleteTest.getCustomerId());

	}

	@Test
	void deleteCustomerNegativeTest() {
		AppUser app = new AppUser();
		app.setEmail("Srikanth@gmail.com");
		app.setPassword("Srikanth@");
		Customer c = new Customer(205, "Srikanth", "Srikanth@", "Hyderabad", 1234567890L, "Srikanth@gmail.com",
				Role.CUSTOMER, "Active");
		Mockito.when(custRepo.findByEmail("Srikanth@gmail.com")).thenReturn(Optional.of(c));
		cusService.loginUser(app);
		Optional<Customer> c1 = Optional.of(new Customer(205, "Srikanth", "Srikanth@", "Hyderabad", 1234567890L,
				"Srikanth@gmail.com", Role.CUSTOMER, "Active"));
		Mockito.when(custRepo.findById(c1.get().getCustomerId())).thenReturn(c1);
		Mockito.doNothing().when(tripRepo).deleteTripByCustomerId(205);
		Mockito.doNothing().when(custRepo).deleteCustomerById(205);
		Customer deleteTest = cusService.deleteCustomer(205);
		assertNotEquals(207, deleteTest.getCustomerId());

	}

	/**
	 * @desc Testing view Customer Method Using Mockito
	 */
	@Test
	void viewCustomerTest() {
		AppUser app = new AppUser();
		app.setEmail("Srikanth@gmail.com");
		app.setPassword("Srikanth@");
		Customer c = new Customer(205, "Srikanth", "Srikanth@", "Hyderabad", 1234567890L, "Srikanth@gmail.com",
				Role.CUSTOMER, "Active");
		Mockito.when(custRepo.findByEmail("Srikanth@gmail.com")).thenReturn(Optional.of(c));
		cusService.loginUser(app);

		Customer c1 = new Customer(205, "Srikanth", "Srikanth@", "Hyderabad", 1234567890L, "Srikanth@gmail.com",
				Role.CUSTOMER, "Active");
		Mockito.when(custRepo.findById(205)).thenReturn(Optional.of(c1));
		Customerdto viewTest = cusService.viewCustomer();
		assertEquals(205, viewTest.getCustomerId());

	}

	@Test
	void viewCustomerNegativeTest() {
		AppUser app = new AppUser();
		app.setEmail("Srikanth@gmail.com");
		app.setPassword("Srikanth@");
		Customer c = new Customer(205, "Srikanth", "Srikanth@", "Hyderabad", 1234567890L, "Srikanth@gmail.com",
				Role.CUSTOMER, "Active");
		Mockito.when(custRepo.findByEmail("Srikanth@gmail.com")).thenReturn(Optional.of(c));
		cusService.loginUser(app);

		Customer c1 = new Customer(205, "Srikanth", "Srikanth@", "Hyderabad", 1234567890L, "Srikanth@gmail.com",
				Role.CUSTOMER, "Active");
		Mockito.when(custRepo.findById(205)).thenReturn(Optional.of(c1));
		Customerdto viewTest = cusService.viewCustomer();
		assertNotEquals(209, viewTest.getCustomerId());

	}

}
