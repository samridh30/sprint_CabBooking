package Cab.Service.demo.TripBooking;

import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import Cab.Service.demo.Service.TripBookingServiceImpl;
import Cab.Service.demo.model.Cab;
import Cab.Service.demo.model.Customer;
import Cab.Service.demo.model.Driver;
import Cab.Service.demo.model.TripBooking;

@SpringBootTest
public class TripBookingTest {
	Logger LOG = LoggerFactory.getLogger(this.getClass());
	private TripBooking triptest;
	private Customer customertest;
	private Driver drivertest;
	private Cab cabtest;
	
	
	
	@Autowired
	private static TripBookingServiceImpl tripservicetest;

	@BeforeAll
	public static void setUp() {
		
		

	}
	

}

