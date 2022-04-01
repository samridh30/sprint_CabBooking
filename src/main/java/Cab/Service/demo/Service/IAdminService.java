package Cab.Service.demo.Service;

import Cab.Service.demo.model.Admin;

public interface IAdminService {

	public Admin insertAdmin(Admin admin);
	public Admin updateAdmin(Admin admin);
	public Admin deleteAdmin(int adminId);
//	public List<TripBooking> getAllTrips(int customerId);
//	public List<TripBooking> getTripsCabwise();
//	public List<TripBooking> getTripsCustomerwise();
//	public List<TripBooking> getTripsDatewise();
//	public List<TripBooking> getAllTripsForDays(int customerId, LocalDateTime fromDate, LocalDateTime toDate);
	
}
