package Cab.Service.demo.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Cab.Service.demo.Exception.DriverNotFoundException;
import Cab.Service.demo.Exception.InvalidAccessException;
import Cab.Service.demo.Exception.InvalidTripFoundException;
import Cab.Service.demo.Exception.InvalidUserException;
import Cab.Service.demo.Exception.TripNotFoundException;
import Cab.Service.demo.Exception.UserNotLoggedInException;
import Cab.Service.demo.dto.Cabservicedto;
import Cab.Service.demo.dto.Customerdto;
import Cab.Service.demo.dto.Driverdto;
import Cab.Service.demo.dto.TripDto;
import Cab.Service.demo.model.Customer;
import Cab.Service.demo.model.Driver;
import Cab.Service.demo.model.Role;
import Cab.Service.demo.model.TripBooking;
import Cab.Service.demo.repository.CustomerRepositorImpl;
import Cab.Service.demo.repository.DriverRepositoryImpl;
import Cab.Service.demo.repository.TripBookingRepositoryImpl;

/**
 * @desc Class for TripBooking Services
 * @author  Srikanth
 * 
 */

@Service
public class TripBookingServiceImpl implements ITripBookingService {
	@Autowired
	TripBookingRepositoryImpl tripRepo;
	@Autowired
	CustomerRepositorImpl custRepo;
	@Autowired
	DriverRepositoryImpl driverRepo;


	@Autowired
	private CustomerServiceImpl appUser;

	LocalDateTime now = LocalDateTime.now();

	@Override
	public TripBooking insertTripBooking(TripBooking tripBooking) {
		Optional<TripBooking> trip = tripRepo.findById(tripBooking.getTripBookingId());


		if (trip.isPresent()) {
			throw new InvalidTripFoundException("Duplicate Trip Id");
		} else {
			boolean check = validateTrip(tripBooking.getCustomer().getCustomerId());
			if (check == true) {
				

				tripRepo.save(tripBooking);

				int cus_id = tripBooking.getCustomer().getCustomerId();
				TripBooking book = calculateBill(cus_id);
				System.out.println(book);

				return updateTripBooking(book);
			} else {

				throw new InvalidTripFoundException("Multiple Trips Not Allowed At Same Time");
			}

		}
	}

	/**
	 * @desc Update already tripbooked data
	 * @return Updated tripBooking Object will be returned
	 * 
	 */
	@Override
	public TripBooking updateTripBooking(TripBooking tripBooking) {
	
		if(appUser.loggedInUser.getRole()==Role.CUSTOMER && tripBooking.getCustomer().getCustomerId()==appUser.loggedInUser.getCustomerId()) {
		Optional<TripBooking> trip = tripRepo.findById(tripBooking.getTripBookingId());
		if (trip.isPresent()) {
			return tripRepo.save(tripBooking);
		} else {
			throw new TripNotFoundException("Invalid TripData");
		} }else {
			throw new InvalidAccessException("Access Denied");

		}

	}

	/**
	 * @desc method will Delete trip booking
	 * @return Deleted TripBooking Object will be returned
	 * 
	 */
	@Override
	public TripBooking deleteTripBooking(int tripBookingId) {
		if(appUser.loggedInUser.getRole()==Role.CUSTOMER) {
		Optional<TripBooking> trip = tripRepo.findById(tripBookingId);
		if (trip.isPresent()) {
			tripRepo.deleteById(tripBookingId);
			return trip.get();
		} else {
			throw new TripNotFoundException("Invalid Id-" + tripBookingId);
		}}
		else{
			throw new InvalidAccessException("Access Denied");

		}
	}

	/**
	 * @desc Fetch trip data based on customerId
	 * @return all trips of a customer by Id will be returned.
	 */
	@Override
	public List<TripBooking> ViewAllTripsCustomer() {
		/////////////////////////
		if(appUser.loggedInUser!=null ) {
			if(appUser.loggedInUser.getRole()==Role.CUSTOMER) {
			int customerId=appUser.loggedInUser.getCustomerId();
			if(appUser.loggedInUser.getCustomerId()==customerId) {


		List<TripBooking> trip = tripRepo.findByCustomer(customerId);
		
		if(trip!=null) {

		return trip;}
		else {
			throw new TripNotFoundException("No Trips Found For Customer Id- "+ customerId);
		
		} 
	}else {
		throw new InvalidAccessException("Invalid Access");
		
	}
			}else {
				throw new InvalidUserException("Not Logged in as Customer");
			}
			
			}
	else {
		throw new UserNotLoggedInException ("Login");
	}
}
	
	

	/**
	 * @desc Calculate Trip bill based on distance and PerKmRate of cab
	 * @return tripbooking object will be returned with updated bill
	 */
	@Override
	public TripBooking calculateBill(int customerId) {
		float rate = tripRepo.findByPerKmRate(customerId);
		TripBooking trip = tripRepo.findByCustomerId(customerId);
		trip.setBill(trip.getDistanceInKm() * rate);
		return trip;
	}

	/**
	 * @desc Validate Trip
	 * @return boolean value(True or False)
	 */
	@Override
	public boolean validateTrip(int customerId) {
		List<Integer> Id = tripRepo.IsCustomerInTrip(customerId);
		if (Id.isEmpty()) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * @desc To End the trip
	 * @return Tripbooking object
	 */
	@Override
	public TripBooking endTrip() {

		
		if(appUser.loggedInUser.getRole()==Role.CUSTOMER) {
		int Id=appUser.loggedInUser.getCustomerId();
		TripBooking end1 = tripRepo.findByCustomerId(Id);
		if(end1!=null) {
		end1.setStatus(false);
		end1.getDriver().setStatus(false);

		end1.getDriver().getCab().setStatus(false);
		
		TripBooking end2= updateTripBooking(end1);
		
		return end2;}
		else {
			throw new TripNotFoundException("No Trip Found");
			
		}
		}
		else {
			throw new InvalidUserException("Not logged in as CUSTOMER");
}
	}

	/**
	 * @desc To Book a cab from fromlocation to Tolocation
	 * @return Cabservicedto object will be returned
	 */
	@Override
	public TripBooking BookCab(TripDto tripdto) {
		if(appUser.loggedInUser.getRole()==Role.CUSTOMER) {
		Optional<Customer> tripCust = custRepo.findById(appUser.loggedInUser.getCustomerId());
		List<Driver> driver1 = driverRepo.findByCarType(tripdto.getCabType());;
		if (driver1.size() == 0) {
			throw new DriverNotFoundException(tripdto.getCabType()+" Cab Not Available Right Now Please Try Again after Some time");
		} else {
			Driver s = driverRepo.getById(driver1.get(0).getDriverId());
			driver1.get(0).setStatus(true);
			driver1.get(0).getCab().setStatus(true);
							
			TripBooking tripbooking= new TripBooking(tripCust.get(),s,tripdto.getFromLocation(),tripdto.getToLocation(),now,now,true,50,300);
			TripBooking book = insertTripBooking(tripbooking);
			Driverdto driverdto = new Driverdto(book.getDriver().getDriverId(),book.getDriver().getRating(),book.getDriver().getCab());
			Customerdto customerdto=new Customerdto(book.getCustomer().getCustomerId(),book.getCustomer().getUserName());

			Cabservicedto cabservicedto=  new Cabservicedto(customerdto.getCustomerId(),customerdto.getUsername(),book.getFromLocation(),book.getToLocation(),book.getFromDateTime(),
					book.getToDateTime(),driverdto.getDriverId(),driverdto.getRating(),driverdto.getCab().getCarType(),book.getBill());
			return book;}

			}
			else {
			throw new InvalidUserException("Not logged in as CUSTOMER");}

	}
}

