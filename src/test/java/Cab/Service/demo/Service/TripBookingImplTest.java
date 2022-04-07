package Cab.Service.demo.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import Cab.Service.demo.Service.CustomerServiceImpl;
import Cab.Service.demo.Service.TripBookingServiceImpl;
import Cab.Service.demo.dto.Cabservicedto;
import Cab.Service.demo.dto.TripDto;
import Cab.Service.demo.model.AppUser;
import Cab.Service.demo.model.Cab;
import Cab.Service.demo.model.Customer;
import Cab.Service.demo.model.Driver;
import Cab.Service.demo.model.Role;
import Cab.Service.demo.model.TripBooking;
import Cab.Service.demo.repository.TripBookingRepositoryImpl;
@SpringBootTest
public class TripBookingImplTest {
	
	LocalDateTime now = LocalDateTime.now();
	
	@Autowired
	TripBookingServiceImpl tripservice;
	@Autowired
	CustomerServiceImpl cusService;
	@Autowired
	TripBooking TripBook;
	
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
	void deleteTripTest() {
		TripBooking deletetest= tripservice.deleteTripBooking(145);
		assertEquals(145,deletetest.getTripBookingId());
		assertEquals(2000,deletetest.getBill());
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
