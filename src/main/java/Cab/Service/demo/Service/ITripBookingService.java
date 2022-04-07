package Cab.Service.demo.Service;

import java.util.List;

import Cab.Service.demo.dto.Cabservicedto;
import Cab.Service.demo.dto.TripDto;
import Cab.Service.demo.model.TripBooking;

public interface ITripBookingService {
	TripBooking insertTripBooking(TripBooking tripBooking);
	TripBooking updateTripBooking(TripBooking tripBooking);
	TripBooking deleteTripBooking(int tripBookingId);
	List<TripBooking> ViewAllTripsCustomer(int customerId);
	TripBooking calculateBill(int customerId);
	boolean validateTrip(int customerId);
	TripBooking endTrip(int Id);
	Cabservicedto BookCab(TripDto tripdto);
	

}
