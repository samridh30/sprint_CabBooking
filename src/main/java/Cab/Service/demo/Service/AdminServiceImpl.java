package Cab.Service.demo.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Cab.Service.demo.Exception.InvalidUserNamePasswordException;
import Cab.Service.demo.model.Role;
import Cab.Service.demo.model.TripBooking;
import Cab.Service.demo.repository.TripBookingRepositoryImpl;

@Service
public class AdminServiceImpl implements IAdminService {

//	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

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
				throw new InvalidUserNamePasswordException("Invalid Username or Password");
		}
		return null;
	}

//	@Override
//	public String check() {
//		if (User.loggedInUser != null) {
//			if (User.loggedInUser.getRole() == Role.ADMIN) {
//				return "Works";
//			} else {
//				return "Not logged IN";
//			}
//		}
//		return "Not logged in";
//	}

	@Override
	public List<TripBooking> getTripsCabwise() {
//		if(AppUser.loggedInUser.getRole() == Role.ADMIN) {
//			List<TripBooking> list = tripRepo.
//		}
		return null;
	}

	@Override
	public List<TripBooking> getTripsCustomerwise() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TripBooking> getTripsDatewise() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TripBooking> getAllTripsForDays(int customerId, LocalDateTime fromDate, LocalDateTime toDate) {
		// TODO Auto-generated method stub
		return null;
	}

}
