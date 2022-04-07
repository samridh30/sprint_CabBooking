package Cab.Service.demo.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.List;
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

import Cab.Service.demo.dto.Cabservicedto;
import Cab.Service.demo.dto.TripDto;
import Cab.Service.demo.model.AppUser;
import Cab.Service.demo.model.Cab;
import Cab.Service.demo.model.Customer;
import Cab.Service.demo.model.Driver;
import Cab.Service.demo.model.Role;
import Cab.Service.demo.model.TripBooking;
import Cab.Service.demo.repository.CustomerRepositorImpl;
import Cab.Service.demo.repository.TripBookingRepositoryImpl;
@ExtendWith(SpringExtension.class)
public class TripBookingImplMockitoTest {
	
	LocalDateTime now = LocalDateTime.now();
	
	@InjectMocks
	TripBookingServiceImpl tripservice;
	@InjectMocks
	CustomerServiceImpl cusService;
	
//	@Mock
//	CustomerServiceImpl custService;
	@Mock
	TripBookingRepositoryImpl tripRepo;
	@Mock
	CustomerRepositorImpl cusRepo;
	
	@BeforeEach
	void start() {
		AppUser app = new AppUser();
		app.setEmail("Srikanth@gmail.com");
		app.setPassword("Srikanth@");
		Customer c= new Customer(205,"Srikanth","Srikanth@","Punjab",1234567890L, "Srikanth@gmail.com",Role.CUSTOMER);

		Mockito.when(cusRepo.findByEmail("Srikanth@gmail.com")).thenReturn(Optional.of(c));
		cusService.loginUser(app);
		}
	
	@AfterEach
	void end() {
		cusService.logoutUser();
	}

	
	//@Disabled
	@Test
	void deleteTripTest() {
		Customer c= new Customer("Sajal","Sajal@","Punjab",1234567890, "Sajal@gmail.com",Role.CUSTOMER);
		Cab cab= new Cab(115,"Mini",20,true);
		Driver d= new Driver(131,"Id1",4.7f,cab,true);
		TripBooking trip= new TripBooking(8,c,d,"nyz","kukatpally",now,now,false,56,34);
		Mockito.when(tripRepo.findById(8)).thenReturn(Optional.of(trip));
		Mockito.when(tripRepo.save(trip)).thenReturn(trip);
		TripBooking deletetest= tripservice.deleteTripBooking(8);
		assertEquals(8,deletetest.getTripBookingId());
		assertEquals(34,deletetest.getBill());
		}
	
	@Disabled
	@Test
	void updateTripTest() {
		AppUser app = new AppUser();
		app.setEmail("Sri@gmail.com");
		app.setPassword("Srikanth@");
		cusService.loginUser(app);
		LocalDateTime now = LocalDateTime.now();
		Customer c= new Customer(157, "Sajal","Sajal@","Punjab",1234567890L, "Sajal3@gmail.com",Role.ADMIN);
		Cab cab= new Cab(158,"Mini",20,true);
		Driver d= new Driver(159,"Id1",4.7f,cab,true);
		TripBooking trip= new TripBooking(147,c,d,"hyd","kukatpally",now,now,false,56,79);
		TripBooking updatetest=tripservice.updateTripBooking(trip);
		assertEquals(79,updatetest.getBill());
		assertEquals("hyd", updatetest.getFromLocation());
		}
	
	
	@Disabled
	@Test
	void viewAllTripsCustomerTest() {
		List<TripBooking> list= tripservice.ViewAllTripsCustomer();
		assertEquals(3,list.size());
		
	}
		
	@Disabled
	@Test
	void BookCabTest() {
		TripDto tripdto=new TripDto("Hyd","Andhra");
		Cabservicedto cabbooktest=tripservice.BookCab(tripdto);
		assertEquals(114,cabbooktest.getCustomerId());
		cusService.logoutUser();
		}
	
	@Disabled
	@Test
	void CalculateBill() {
		TripBooking billtest=tripservice.calculateBill(114);
		assertEquals(2000,billtest.getBill());
		}
	@Test
	void endTripTest() {
		
	}
	
//	Customer c= new Customer(112,"Sajal","Sajal@","Punjab",1234567890, "Sajal@gmail.com",Role.ADMIN);
////AppUser app=new AppUser("Sajal@gmail.com","Sajal@");
////cusService.loginUser(app);
//Cab cab= new Cab(115,"Mini",20,true);
//Driver d= new Driver(131,"Id1",4.7f,cab,true);
//TripBooking trip= new TripBooking(8,c,d,"nyz","kukatpally",now,now,false,56,34);
////Cabservicedto cabdto= new Cabservicedto("Sajal","Hyd","kukatpally",now,now,131,4.7f,"Mini",34);
////System.out.println(cusService.loginUser(app).getCustomerId());
//Cabservicedto cabdto1=tripservice.BookCab("Hyd", "kukatpally");
	
	
	

}
