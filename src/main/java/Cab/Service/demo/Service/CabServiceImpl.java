package Cab.Service.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Cab.Service.demo.Exception.CabNotFoundException;
import Cab.Service.demo.model.Cab;
import Cab.Service.demo.repository.CabRepositoryImpl;
import Cab.Service.demo.Exception.DriverAlreadyExistsException;
import Cab.Service.demo.Exception.UserNotLoggedInException;
import Cab.Service.demo.model.Customer;
import Cab.Service.demo.model.Role;
import Cab.Service.demo.repository.TripBookingRepositoryImpl;
@Service
public class CabServiceImpl implements ICabService {
	@Autowired
	CabRepositoryImpl car_repo;
	
	@Autowired
	Customer AppUser;
	@Autowired
	private TripBookingRepositoryImpl TRepo;

	@Override
	public Cab insertCab(Cab cab) {
		if(AppUser.getRole()==Role.ADMIN) {
		Optional<Cab> car = car_repo.findById(cab.getCabId());
		if (car.isEmpty()) {
			throw new CabNotFoundException("Cab not found");}
		else {
			car_repo.save(cab);
			return cab;
		}
		}
		else {
			throw new UserNotLoggedInException("Login First");
		
		}
	}
	

	@Override
	public Cab updateCab(Cab cab) {
		if(AppUser.getRole()==Role.ADMIN) {
		Optional<Cab> car = car_repo.findById(cab.getCabId());
		
		if (car.isPresent()) {
			car_repo.save(cab);
			return cab;
		} else {
			throw new CabNotFoundException("Invalid Customer");
		}}
		throw new UserNotLoggedInException("Login First");
	}

	@Override
	public Cab deleteCab(int cabId) {
		if(AppUser.getRole()==Role.ADMIN) {
		Optional<Cab> car = car_repo.findById(cabId);
		if (car.isPresent()) {
			car_repo.deleteById(cabId);
			return car.get();
		} else {
			throw new CabNotFoundException("Invalid Id");
		}}
		else {
			throw new UserNotLoggedInException("Login First");
		}
	}

	@Override
	public List<Cab> viewCabsOfType(String carType) {
		if(AppUser.getRole()==Role.CUSTOMER) {
		List<Cab> car = car_repo.findByCarType(carType);
		return car;
		}
		else {
			throw new UserNotLoggedInException("Login First");
		}
		
	}

	@Override
	public int countCabsOfType(String carType) {
		if(AppUser.getRole()==Role.CUSTOMER) {
			int car = car_repo.countByCarType(carType);
			return car;
		}
		else {
			throw new UserNotLoggedInException("Login First");
		}
		
	}

}
