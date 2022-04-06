package Cab.Service.demo.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import Cab.Service.demo.Service.CustomerServiceImpl;
import Cab.Service.demo.Service.TripBookingServiceImpl;
import Cab.Service.demo.dto.Cabservicedto;
import Cab.Service.demo.model.AppUser;
import Cab.Service.demo.model.Cab;
import Cab.Service.demo.model.Customer;
import Cab.Service.demo.model.Driver;
import Cab.Service.demo.model.Role;
import Cab.Service.demo.model.TripBooking;
import Cab.Service.demo.repository.TripBookingRepositoryImpl;
@SpringBootTest
public class TripBookingServiceImplTests {
	
	LocalDateTime now = LocalDateTime.now();
	
	@Autowired
	TripBookingServiceImpl tripservice;
	@Autowired
	CustomerServiceImpl cusService;
	
	@Disabled
	@Test
	void deleteTripTest() {
		
		TripBooking deletetest= tripservice.deleteTripBooking(144);
		//assertEquals("Hyd", cabdto1.getFromLocation());
		assertEquals(144,deletetest.getTripBookingId());
		//cusService.loginUser(app);
		
		
		
	}
	
	@Disabled
	@Test
	void updateTripTest() {
		Customer c= new Customer(112,"Sajal","Sajal@","Punjab",1234567890, "Sajal@gmail.com",Role.ADMIN);
//		AppUser app=new AppUser("Sajal@gmail.com","Sajal@");
		//cusService.loginUser(app);
		Cab cab= new Cab(115,"Mini",20,true);
		Driver d= new Driver(131,"Id1",4.7f,cab,true);
		TripBooking trip= new TripBooking(8,c,d,"nyz","kukatpally",now,now,false,56,34);
//		Cabservicedto cabdto= new Cabservicedto("Sajal","Hyd","kukatpally",now,now,131,4.7f,"Mini",34);
//		System.out.println(cusService.loginUser(app).getCustomerId());
		//Cabservicedto cabdto1=tripservice.BookCab("Hyd", "kukatpally");
		
		TripBooking updatetest=tripservice.updateTripBooking(trip);
		assertEquals(8,updatetest.getTripBookingId());
		assertEquals("nyz", updatetest.getFromLocation());
		
		
		
	}
	
	
	@Disabled
	@Test
	void viewAllTripsCustomerTest() {
		List<TripBooking> list= tripservice.ViewAllTripsCustomer(113);
		assertEquals(1,list.size());
		
	}
	
	
	

}
