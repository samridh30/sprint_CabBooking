package Cab.Service.demo.Service;

import java.util.List;

import Cab.Service.demo.dto.TripDateDto;
import Cab.Service.demo.model.TripBooking;

public interface IAdminService {


	List<TripBooking> getAllTrips();

	List<TripBooking> getTripsCabwise();

	List<TripBooking> getTripsCustomerwise();

	List<TripBooking> getTripsDatewise();



	List<TripBooking> getAllTripsForDays(TripDateDto trip);



}