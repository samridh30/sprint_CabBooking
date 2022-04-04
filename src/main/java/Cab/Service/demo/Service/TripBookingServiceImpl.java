package Cab.Service.demo.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Cab.Service.demo.Exception.InvalidTripFoundException;
import Cab.Service.demo.Exception.TripNotFoundException;
import Cab.Service.demo.model.Customer;
import Cab.Service.demo.model.Driver;
import Cab.Service.demo.model.TripBooking;
import Cab.Service.demo.repository.CustomerRepositorImpl;
import Cab.Service.demo.repository.DriverRepositoryImpl;
import Cab.Service.demo.repository.TripBookingRepositoryImpl;

@Service
public class TripBookingServiceImpl implements ITripBookingService {
	@Autowired
	TripBookingRepositoryImpl tripRepo;
	@Autowired
	CustomerRepositorImpl cust;
	@Autowired
	DriverRepositoryImpl driver;
	
	@Autowired
	TripBooking service;
	
	LocalDateTime now = LocalDateTime.now();
	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	

	@Override
	public TripBooking insertTripBooking(TripBooking tripBooking) {
		Optional<TripBooking> trip= tripRepo.findById(tripBooking.getTripBookingId());
		
		if(trip.isPresent()) {
			throw new InvalidTripFoundException("Duplicate Trip Id");
		}else {
			boolean check= validateTrip(tripBooking.getCustomer().getCustomerId());
			if(check==true) {
			
			tripRepo.save(tripBooking);

			int cus_id=tripBooking.getCustomer().getCustomerId();
			TripBooking book=calculateBill(cus_id);
			
			return updateTripBooking(book);}
			else {
				throw new InvalidTripFoundException("Multiple Trips Not Allowed At Same Time");
			}
			
		}
	}

	@Override
	public TripBooking updateTripBooking(TripBooking tripBooking) {
		Optional<TripBooking> trip=tripRepo.findById(tripBooking.getTripBookingId());
		if(trip.isPresent()) {
			return tripRepo.save(tripBooking);
		}else {
			throw new TripNotFoundException("Invalid Data");
		}

	
	}

	@Override
	public TripBooking deleteTripBooking(int tripBookingId) {
		Optional<TripBooking> trip=tripRepo.findById(tripBookingId);
		if(trip.isPresent()) {
			tripRepo.deleteById(tripBookingId);
			return trip.get();		}
		else {
			throw new TripNotFoundException("Invalid Id-"+tripBookingId);
		}
	}

	@Override
	public List<TripBooking> ViewAllTripsCustomer(int customerId) {
		
		List<TripBooking> trip= tripRepo.findByCustomer(customerId);
		return trip;
	}

	@Override
	public TripBooking calculateBill(int customerId) {
		float rate=tripRepo.findByPerKmRate(customerId);
		TripBooking t= tripRepo.findByCustomerId(customerId);
		TripBooking trip= tripRepo.getById(t.getTripBookingId());
		trip.setBill(trip.getDistanceInKm()*rate);
		return trip;
	}
	
	public boolean validateTrip(int customerId) {
		List<Integer> Id =tripRepo.IsCustomerInTrip(customerId);
		if(Id.isEmpty()) {
			LOG.info("U can book cab");
			return true;
		}
		else {
			LOG.info("U can't book trip while travelling");
			return false;
		}
		
	}
	
	public TripBooking endTrip(int Id) {
		Optional<TripBooking> end= tripRepo.findById(Id);
		TripBooking end1=end.get();
		end1.setStatus(false);
		TripBooking end2= updateTripBooking(end1);
		
		return end2;
		
		
		
	}
	
	public TripBooking BookCab(String fromLocation, String toLocation, int CustId) {
		Optional<Customer> tripCust= cust.findById(CustId);
		
		Driver s= driver.getById(66);
		
		service.setCustomer(tripCust.get());
		service.setDistanceInKm(50);
		service.setStatus(true);
		service.setBill(300);
		service.setDriver(s);
		service.setFromDateTime(now);
		service.setToDateTime(now);
		service.setFromLocation(fromLocation);
		service.setToLocation(toLocation);
		
		TripBooking trip=insertTripBooking(service);
		
		return trip;
		
		
		
		
		
		
	}

}
