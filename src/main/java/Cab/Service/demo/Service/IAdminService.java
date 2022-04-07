package Cab.Service.demo.Service;

import java.util.List;

import Cab.Service.demo.dto.TripDateDto;
import Cab.Service.demo.model.TripBooking;

public interface IAdminService {


	public List<TripBooking> getAllTrips();

	public List<TripBooking> getTripsCabwise();

	public List<TripBooking> getTripsCustomerwise();

	public List<TripBooking> getTripsDatewise();



	List<TripBooking> getAllTripsForDays(TripDateDto trip);



}