package Cab.Service.demo.repository;

import java.util.List;

import Cab.Service.demo.model.TripBooking;

public interface ITripBookingRepository {
	TripBooking insertTripBooking(TripBooking tripBooking);
	TripBooking updateTripBooking(TripBooking tripBooking);
	TripBooking deleteTripBooking(int tripBookingId);
	List<TripBooking> viewAllTripsCustomer(int customerId);
	TripBooking calculateBill(int customerId);
	

}
