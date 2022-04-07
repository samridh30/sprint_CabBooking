package Cab.Service.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Cab.Service.demo.Exception.InvalidUserException;
import Cab.Service.demo.Exception.InvalidUserNamePasswordException;
import Cab.Service.demo.dto.TripDateDto;
import Cab.Service.demo.model.Role;
import Cab.Service.demo.model.TripBooking;
import Cab.Service.demo.repository.TripBookingRepositoryImpl;

@Service
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private TripBookingRepositoryImpl tripRepo;

	@Autowired
	private CustomerServiceImpl AppUser;

	@Override
	public List<TripBooking> getAllTrips() {
		if (AppUser.loggedInUser != null) {
			if (AppUser.loggedInUser.getRole() == Role.ADMIN) {
				List<TripBooking> trip = tripRepo.findAll();
				return trip;
			} else
				throw new InvalidUserException("Not LoggedIn as Admin");
		} else
			throw new InvalidUserNamePasswordException("Login First");

	}


	@Override
	public List<TripBooking> getTripsCabwise() {
		if (AppUser.loggedInUser.toString() != null) {
			if (AppUser.loggedInUser.getRole() == Role.ADMIN) {
				List<TripBooking> list = tripRepo.findByCabs();
				return list;
			} else
				throw new InvalidUserException("Not Logged In As Admin");
		} else
			throw new InvalidUserNamePasswordException("Login First");

	}

	@Override
	public List<TripBooking> getTripsCustomerwise() {
		if (AppUser.loggedInUser.toString() != null) {
			if (AppUser.loggedInUser.getRole() == Role.ADMIN) {
				List<TripBooking> list = tripRepo.findByCustomer();
				return list;
			} else
				throw new InvalidUserException("Not Logged In As Admin");
		} else
			throw new InvalidUserNamePasswordException("Login First");
	}

	@Override
	public List<TripBooking> getTripsDatewise() {
		if (AppUser.loggedInUser.toString() != null) {
			if (AppUser.loggedInUser.getRole() == Role.ADMIN) {
				List<TripBooking> list = tripRepo.findByDate();
				return list;
			} else
				throw new InvalidUserException("Not Logged In As Admin");
		} else
			throw new InvalidUserNamePasswordException("Login First");
	}

	@Override
	public List<TripBooking> getAllTripsForDays(TripDateDto trip) {
		if (AppUser.loggedInUser.toString() != null) {
			if (AppUser.loggedInUser.getRole() == Role.ADMIN) {
				List<TripBooking> list = tripRepo.findByTripForDay(trip.getCustomerId(), trip.getFromLocation(),
						trip.getToLocation());
				return list;
			} else
				throw new InvalidUserException("Not Logged In As Admin");
		} else
			throw new InvalidUserNamePasswordException("Login First");
	}

}