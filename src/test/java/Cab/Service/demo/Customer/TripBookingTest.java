package Cab.Service.demo.Customer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import Cab.Service.demo.Service.TripBookingServiceImpl;
import Cab.Service.demo.dto.Cabservicedto;
import Cab.Service.demo.model.Cab;
import Cab.Service.demo.model.Customer;
import Cab.Service.demo.model.Driver;
import Cab.Service.demo.model.Role;
import Cab.Service.demo.model.TripBooking;
import Cab.Service.demo.repository.TripBookingRepositoryImpl;


@ExtendWith(SpringExtension.class)
public class TripBookingTest {
	
	@InjectMocks
	TripBookingServiceImpl tripBookingService;
	@MockBean
	TripBookingRepositoryImpl tripRepo;
	
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
		
	}
//	{
//        "tripBookingId": 148,
//        "customer": {
//            "customerId": 111,
//            "userName": "Srikanth",
//            "password": "Srikanth@",
//            "address": "Hyderabad",
//            "mobileNumber": 1234567890,
//            "email": "Sri@gmail.com",
//            "role": "CUSTOMER"
//        },
//        "driver": {
//            "driverId": 134,
//            "licenseNo": "Id4",
//            "rating": 4.7,
//            "cab": {
//                "cabId": 118,
//                "carType": "Medium",
//                "perKmRate": 30.0,
//                "status": true
//            },
//            "status": true
//        },
//        "fromLocation": "kukatpally",
//        "toLocation": "nyz",
//        "fromDateTime": "2022-04-05T22:02:38.371113",
//        "toDateTime": "2022-04-05T22:02:38.371113",
//        "status": true,
//        "distanceInKm": 50.0,
//        "bill": 1500.0
//    }
//]
//	 "customerId": 111,
//	    "customername": "Srikanth",
//	    "fromLocation": "kukatpally",
//	    "toLocation": "nyz",
//	    "fromDateTime": "2022-04-05T22:02:38.3711132",
//	    "toDateTime": "2022-04-05T22:02:38.3711132",
//	    "driverId": 134,
//	    "rating": 4.7,
//	    "cabtype": "Medium",
//	    "bill": 1500.0
//	}
	
	@Test
	void bookTripTest() {
		Customer c= new Customer(111,"Srikanth","Srikanth@","Hyderabad",1234567890, "Sri@gmail.com",Role.CUSTOMER);
		Cab cab= new Cab(118,"Medium",30,true);
		Driver d= new Driver(134,"Id4",4.7f,cab,true);
		TripBooking trip= new TripBooking(148,c,d,"kukatpally","nyz",true,50,1500);
		
		Cabservicedto cabdto= new Cabservicedto("Srikanth","kukatpally","nyz",134,4.7,"Medium",1500);
		//Mockito.when(tripRepo.save(Tri)).thenReturn(cabdto);
		
		
		
		
	}
	
	

}
