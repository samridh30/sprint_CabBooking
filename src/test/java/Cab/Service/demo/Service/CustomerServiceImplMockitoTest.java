package Cab.Service.demo.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
	
	@BeforeEach
	void start() {
		AppUser app = new AppUser();
		app.setEmail("Srikanth@gmail.com");
		app.setPassword("Srikanth@");
		Customer c= new Customer(205,"Srikanth","Srikanth@","Hyderabad",1234567890L, "Srikanth@gmail.com",Role.CUSTOMER);
		Mockito.when(custRepo.findByEmail("Srikanth@gmail.com")).thenReturn(Optional.of(c));
		cusService.loginUser(app);
		
				}
	
	@AfterEach
	void end() {
		cusService.logoutUser();
	}
	
	@Disabled
	@Test
	void insertCustomerTest() {
		AppUser app = new AppUser();
		app.setEmail("Sajal@gmail.com");
		app.setPassword("Sajal@");
		cusService.loginUser(app);
		
		Optional<Customer> c= Optional.of(new Customer(205,"Srikanth","Srikanth@","Hyderabad",1234567890L, "Srikanth@gmail.com",Role.CUSTOMER));
		Mockito.when(custRepo.findByEmail(c.get().getEmail())).thenReturn(null);
		Mockito.when(custRepo.save(c.get())).thenReturn(c.get());
		
		Customer insertTest=cusService.insertCustomer(c.get());
		assertEquals(11,insertTest.getCustomerId());
		}
	
	@Test
	void updateCustomerTest() {
		AppUser app = new AppUser();
		app.setEmail("Srikanth@gmail.com");
		app.setPassword("Srikanth@");
		Customer c= new Customer(205,"Srikanth","Srikanth@","Hyderabad",1234567890L, "Srikanth@gmail.com",Role.CUSTOMER);
		Mockito.when(custRepo.findByEmail("Srikanth@gmail.com")).thenReturn(Optional.of(c));
		cusService.loginUser(app);
		
		
		Mockito.when(custRepo.findById(205)).thenReturn(Optional.of(c));
		Mockito.when(custRepo.save(c)).thenReturn(c);
		
	}
	@Test
	void deleteCustomerTest() {
		AppUser app = new AppUser();
		app.setEmail("Srikanth@gmail.com");
		app.setPassword("Srikanth@");
		Customer c= new Customer(205,"Srikanth","Srikanth@","Hyderabad",1234567890L, "Srikanth@gmail.com",Role.CUSTOMER);
		Mockito.when(custRepo.findByEmail("Srikanth@gmail.com")).thenReturn(Optional.of(c));
		cusService.loginUser(app);
		Optional<Customer> c1= Optional.of(new Customer(205,"Srikanth","Srikanth@","Hyderabad",1234567890L, "Srikanth@gmail.com",Role.CUSTOMER));
		Mockito.when(custRepo.findById(c1.get().getCustomerId())).thenReturn(c1);
		Mockito.doNothing().when(tripRepo).deleteTripByCustomerId(205);
		Mockito.doNothing().when(custRepo).deleteCustomerById(205);
		Customer deleteTest=cusService.deleteCustomer();
		assertEquals(205, deleteTest.getCustomerId());
		
	}
	
	@Test
	void viewCustomerTest() {
		AppUser app = new AppUser();
		app.setEmail("Srikanth@gmail.com");
		app.setPassword("Srikanth@");
		Customer c= new Customer(205,"Srikanth","Srikanth@","Hyderabad",1234567890L, "Srikanth@gmail.com",Role.CUSTOMER);
		Mockito.when(custRepo.findByEmail("Srikanth@gmail.com")).thenReturn(Optional.of(c));
		cusService.loginUser(app);
		
		Customer c1= new Customer(205,"Srikanth","Srikanth@","Hyderabad",1234567890L, "Srikanth@gmail.com",Role.CUSTOMER);
		Mockito.when(custRepo.findById(205)).thenReturn(Optional.of(c1));
		Customerdto viewTest= cusService.viewCustomer();
		assertEquals(205, viewTest.getCustomerId());
		
	}
	
	
	
//	@Test
//	void bookCab() {
//		Optional<Customer> c= Optional.of(new Customer(205,"Srikanth","Srikanth@","Hyderabad",1234567890L, "Srihari9@gmail.com",Role.CUSTOMER));
//		Cab cab= new Cab(3,"Mini",20,false);
//		System.out.println("ukgukyg");
//		Driver d= new Driver(131,"Id1",4.7f,cab,false);
//		Optional<TripBooking> trip= Optional.of(new TripBooking(209,c.get(),d,"nyz","kukatpally",now,now,false,5,34));
//		List<Driver> d1= new ArrayList();
//		d1.add(d);
//		TripDto tripdto=new TripDto("hyd","andhra");
//		Mockito.when(custRepo.findById(205)).thenReturn(c);
//		Mockito.when(driverRepo.findByStatus()).thenReturn(d1);
//		Mockito.when(driverRepo.getById(131)).thenReturn(d);
//		Mockito.when(tripRepo.findById(209)).thenReturn(trip);
//		Mockito.when(tripRepo.IsCustomerInTrip(205)).thenReturn(new ArrayList<Integer>());
//		Mockito.when(tripRepo.save(trip.get())).thenReturn(trip.get());
//		Mockito.when(tripRepo.findByPerKmRate(11)).thenReturn(10f);
//		Mockito.when(tripRepo.findByCustomerId(11)).thenReturn(trip.get());
//		
//		Cabservicedto cab1 = tripService.BookCab(tripdto);
//		
//		
//		assertEquals("Mini",cab1.getCabtype());
//	}
//
}
