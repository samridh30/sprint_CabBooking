package Cab.Service.demo.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Cab.Service.demo.model.Role;
import Cab.Service.demo.model.TripBooking;
import Cab.Service.demo.repository.AdminRepositoryImpl;
import Cab.Service.demo.repository.CabRepositoryImpl;
import Cab.Service.demo.repository.TripBookingRepositoryImpl;

@Service
public class AdminServiceImpl implements IAdminService {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AdminRepositoryImpl adminRepo;
	@Autowired
	private TripBookingRepositoryImpl tripRepo;
	@Autowired
	private CabRepositoryImpl car_repo;

	@Autowired
	private CustomerServiceImpl User;

//	@Override
//	public List<Admin> getAllAdmin() {
//		return adminRepo.findAll();
//	}
//
//	@Override
//	public Admin insertAdmin(Admin admin) {
//		LOG.info(admin.toString());
//		Optional<Admin> ad = adminRepo.findById(admin.getAdminId());
//		if (ad.isPresent())
//			return null;
//		else
//			adminRepo.save(admin);
//		return admin;
//	}
//
//	@Override
//	public Admin updateAdmin(Admin admin) {
//		Optional<Admin> ad = adminRepo.findById(admin.getAdminId());
//		if (ad.isPresent())
//			return adminRepo.save(admin);
//		else
//			return null;
//	}
//
//	@Override
//	public Admin deleteAdmin(int adminId) {
//		Optional<Admin> ad = adminRepo.findById(adminId);
//		if (ad.isPresent()) {
//			adminRepo.deleteById(adminId);
//			return ad.get();
//		}
//		return null;
//	}
//
//	@Override
//	public List<Cab> getCabs() {
//		return car_repo.findAll();
//	}
//
//	@Override
//	public List<Cab> getByCarTypes(String carType) {
//		return car_repo.findByCarType(carType);
//	}

	@Override
	public List<TripBooking> getAllTrips() {
		if (User.loggedInUser != null) {
			if (User.loggedInUser.getRole() == Role.ADMIN) {
				List<TripBooking> trip = tripRepo.findAll();
				return trip;
			}
		}
		return null;
	}

	@Override
	public String check() {
		if (User.loggedInUser != null) {
			if (User.loggedInUser.getRole() == Role.ADMIN) {
				return "Works";
			} else {
				return "Not logged IN";
			}
		}
		return "Not logged in";
	}

	@Override
	public List<TripBooking> getTripsCabwise() {
		// TODO Auto-generated method stub
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
