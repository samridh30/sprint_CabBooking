package Cab.Service.demo.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import Cab.Service.demo.model.TripBooking;
import Cab.Service.demo.repository.TripBookingRepositoryImpl;

public class AdminServiceImplTests {

	Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AdminServiceImpl admService;

	@Autowired
	private TripBookingRepositoryImpl tripRepo;

	@Test
	public void testGetAllTrips() {
//		LOG.info(null);
		List<TripBooking> expected = tripRepo.findAll();
		List<TripBooking> actual = admService.getAllTrips();
		assertEquals(expected, actual);
	}

}
