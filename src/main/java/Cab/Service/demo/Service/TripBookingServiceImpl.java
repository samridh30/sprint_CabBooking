package Cab.Service.demo.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Cab.Service.demo.Exception.DriverNotFoundException;
import Cab.Service.demo.Exception.InvalidTripFoundException;
import Cab.Service.demo.Exception.TripNotFoundException;
import Cab.Service.demo.dto.Cabservicedto;
import Cab.Service.demo.dto.Customerdto;
import Cab.Service.demo.dto.Driverdto;
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
	CustomerRepositorImpl custRepo;
	@Autowired
	DriverRepositoryImpl driverRepo;
	@Autowired
	Cabservicedto cabservicedto;
	@Autowired
	Driverdto driverdto;
	@Autowired
	Customerdto customerdto;
	@Autowired
	TripBooking service;
	@Autowired
	CustomerServiceImpl Customer;
	
	LocalDateTime now = LocalDateTime.now();
	
	/**
	 * @desc Creates a TripBooking
	 * @return TripBooked Object will be returned
	 */
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
	
	/**
	 * @desc Update already tripbooked data
	 * @return Updated tripBooking Object will be returned
	 */
	@Override
	public TripBooking updateTripBooking(TripBooking tripBooking) {
		Optional<TripBooking> trip=tripRepo.findById(tripBooking.getTripBookingId());
		if(trip.isPresent()) {
			return tripRepo.save(tripBooking);
		}else {
			throw new TripNotFoundException("Invalid Data");
		}

	
	}
	
	/**
	 * @desc method will Delete trip booking
	 * @return Deleted TripBooking Object will be returned
	 * @author Srikanth
	 */
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
	
	/**
	 * @desc  Fetch trip data based on customerId
	 * @return all trips of a customer by Id will be returned.
	 */
	@Override
	public List<TripBooking> ViewAllTripsCustomer(int customerId) {
		
		List<TripBooking> trip= tripRepo.findByCustomer(customerId);
		return trip;
	}
	
	/**
	 * @desc Calculate Trip bill based on distance and PerKmRate of cab
	 * @return tripbooking object will be returned with updated bill
	 */	
	@Override
	public TripBooking calculateBill(int customerId) {
		float rate=tripRepo.findByPerKmRate(customerId);
		TripBooking t= tripRepo.findByCustomerId(customerId);
		TripBooking trip= tripRepo.getById(t.getTripBookingId());
		trip.setBill(trip.getDistanceInKm()*rate);
		return trip;
	}
	
	/**
	 * @desc Validate Trip 
	 * @return boolean value(True or False)
	 */
	public boolean validateTrip(int customerId) {
		List<Integer> Id =tripRepo.IsCustomerInTrip(customerId);
		if(Id.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	/**
	 * @desc To End the trip
	 * @return Tripbooking object
	 */
	public TripBooking endTrip(int Id) {
		Optional<TripBooking> end= tripRepo.findById(Id);
		TripBooking end1=end.get();
		end1.setStatus(false);
		end1.getDriver().setStatus(false);
		end1.getDriver().getCab().setStatus(false);
		
		TripBooking end2= updateTripBooking(end1);
		
		return end2;}
	
	/**
	 * @desc To Book a cab from fromlocation to Tolocation
	 * @return Cabservicedto object will be returned
	 */
	public Cabservicedto BookCab(String fromLocation, String toLocation) {
		Optional<Customer> tripCust= custRepo.findById(112);
		System.out.println(tripCust);
		List<Driver> driver1=driverRepo.findByStatus();
		if(driver1.size()==0) {
			throw new DriverNotFoundException("All drivers are Busy rightNow. Try Again after Some time");
		}else {
		System.out.println(driver1.get(0).getDriverId());
		Optional<Driver> s= driverRepo.findById(driver1.get(0).getDriverId());
		driver1.get(0).setStatus(true);
		driver1.get(0).getCab().setStatus(true);	
		
		service.setCustomer(tripCust.get());
		service.setDistanceInKm(50);
		service.setStatus(true);
		service.setBill(300);
		service.setDriver(s.get());
		service.setFromDateTime(now);
		service.setToDateTime(now);
		service.setFromLocation(fromLocation);
		service.setToLocation(toLocation);
		
		TripBooking book=insertTripBooking(service);
		
		
		driverdto.setDriverId(book.getDriver().getDriverId());
		driverdto.setRating(book.getDriver().getRating());
		driverdto.setCab(book.getDriver().getCab());
		
		customerdto.setCustomerId(book.getCustomer().getCustomerId());
		customerdto.setUsername(book.getCustomer().getUserName());
		
		cabservicedto.setCustomerId(customerdto.getCustomerId());
		cabservicedto.setCustomername(customerdto.getUsername());
		cabservicedto.setBill(book.getBill());
		cabservicedto.setFromDateTime(book.getFromDateTime());
		cabservicedto.setToLocation(book.getToLocation());
		cabservicedto.setToDateTime(book.getToDateTime());
		cabservicedto.setFromLocation(book.getFromLocation());
		cabservicedto.setDriverId(driverdto.getDriverId());
		cabservicedto.setRating(driverdto.getRating());
		cabservicedto.setCabtype(driverdto.getCab().getCarType());}
		
		return cabservicedto;
		
		
		
		
		
		
	}

}
