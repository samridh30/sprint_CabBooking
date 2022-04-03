package Cab.Service.demo.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Cab.Service.demo.model.Admin;
import Cab.Service.demo.model.TripBooking;
import Cab.Service.demo.repository.AdminRepositoryImpl;

@Service
public class AdminServiceImpl implements IAdminService {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AdminRepositoryImpl adminRepo;

	@Override
	public List<Admin> getAllAdmin() {
		return adminRepo.findAll();
	}

	@Override
	public Admin insertAdmin(Admin admin) {
		LOG.info(admin.toString());
		Optional<Admin> ad = adminRepo.findById(admin.getAdminId());
		if (ad.isPresent())
			return null;
		else
			adminRepo.save(admin);
		return admin;
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		Optional<Admin> ad = adminRepo.findById(admin.getAdminId());
		if (ad.isPresent())
			return adminRepo.save(admin);
		else
			return null;
	}

	@Override
	public Admin deleteAdmin(int adminId) {
		Optional<Admin> ad = adminRepo.findById(adminId);
		if (ad.isPresent()) {
			adminRepo.deleteById(adminId);
			return ad.get();
		}
		return null;
	}

	@Override
	public List<TripBooking> getAllTrips(int customerId) {
		// TODO Auto-generated method stub
		return null;
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
