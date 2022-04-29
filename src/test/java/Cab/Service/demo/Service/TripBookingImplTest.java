package Cab.Service.demo.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import Cab.Service.demo.dto.Cabservicedto;
import Cab.Service.demo.dto.TripDto;
import Cab.Service.demo.model.AppUser;
import Cab.Service.demo.model.Cab;
import Cab.Service.demo.model.Customer;
import Cab.Service.demo.model.Driver;
import Cab.Service.demo.model.Role;
import Cab.Service.demo.model.TripBooking;

@SpringBootTest
public class TripBookingImplTest {
	
	Date in = new Date();
	Instant now = Instant.ofEpochMilli(in.getTime());
	
	@Autowired
	TripBookingServiceImpl tripservice;
	
	@Autowired
	CustomerServiceImpl cusService;
	
	
	
	
	@BeforeEach
	void start() {
		AppUser app = new AppUser();
		app.setEmail("Srikanth@gmail.com");
		app.setPassword("Srikanth@");
		cusService.loginUser(app);
		}
	
	@AfterEach
	void end() {
		cusService.logoutUser();
	}

	/**
	 * @desc Testing DeleteTrip Method 
	 */
	@Disabled
	@Test
	void deleteTripTest() {
		TripBooking deletetest= tripservice.deleteTripBooking(232);
		assertEquals(232,deletetest.getTripBookingId());
		assertEquals(500,deletetest.getBill());
		}
	
	/**
	 * @desc Testing Update Trip Method 
	 */
	@Disabled
	@Test
	void updateTripTest() {

		Customer c= new Customer(220, "Srikanth","Srikanth@","Punjab",1234567890L, "Srikanth@gmail.com",Role.CUSTOMER);
		Cab cab= new Cab(1,"Mini",20,true);
		Driver d= new Driver(224,"Rohan","Id1",4.7f,cab,true);
		TripBooking trip= new TripBooking(231,c,d,"hyd","kukatpally",now,now,false,56,79);
		TripBooking updatetest=tripservice.updateTripBooking(trip);
		assertEquals(79,updatetest.getBill());
		assertEquals("hyd", updatetest.getFromLocation());
		}
	
	/**
	 * @desc Testing ViewAllTripsCustomer Method
	 */
	@Disabled
	@Test
	void viewAllTripsCustomerTest() {
		List<TripBooking> list= tripservice.ViewAllTripsCustomer();
		assertEquals(3,list.size());
		
	}
		
	/**
	 * @desc Testing BookCab Method 
	 */
	@Disabled
	@Test
	void BookCabTest() {
		TripDto tripdto=new TripDto("Hyd","Andhra","Mini");
		TripBooking cabbooktest=tripservice.BookCab(tripdto);
		assertEquals(220,cabbooktest.getCustomer().getCustomerId());
		
		}
	
	/**
	 * @desc Testing CalculateBill Method 
	 */
	@Disabled
	@Test
	void CalculateBill() {
		TripBooking billtest=tripservice.calculateBill(114);
		assertEquals(2000,billtest.getBill());
		}
	
	/**
	 * @desc Testing EndTripTest Method 
	 */
	@Disabled
	@Test
	void endTripTest() {
		TripBooking endTrip= tripservice.endTrip();
		assertEquals(232, endTrip.getTripBookingId());
		
	}
	

	
	
	

}
