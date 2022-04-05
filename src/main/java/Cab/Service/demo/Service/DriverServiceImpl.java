package Cab.Service.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Cab.Service.demo.Exception.DriverAlreadyExistsException;
import Cab.Service.demo.Exception.DriverNotFoundException;
import Cab.Service.demo.Exception.InvalidUserNamePasswordException;
import Cab.Service.demo.model.Customer;
import Cab.Service.demo.model.Driver;
import Cab.Service.demo.model.Role;
import Cab.Service.demo.repository.DriverRepositoryImpl;

@Service
public class DriverServiceImpl implements IDriverService {

	@Autowired
	private DriverRepositoryImpl driRepo;

	@Autowired
	Customer AppUser;

	@Override
	public Driver insertDriver(Driver driver) {
		if (AppUser.getRole() == Role.ADMIN) {
			Optional<Driver> dri = driRepo.findById(driver.getDriverId());
			if (dri.isPresent()) {
				throw new DriverAlreadyExistsException("Driver Already Present");
			} else {
				driRepo.save(driver);
				return driver;
			}
		} else {
			throw new InvalidUserNamePasswordException("Login First");
		}

	}

	@Override
	public Driver updateDriver(Driver driver) {
		if (AppUser.getRole() == Role.ADMIN) {

			Optional<Driver> dri = driRepo.findById(driver.getDriverId());
			if (dri.isPresent()) {
				driRepo.save(driver);
				return driver;
			} else {
				throw new DriverNotFoundException("Driver is not present");
			}
		} else {
			throw new InvalidUserNamePasswordException("Login First");
		}
	}

	@Override
	public Driver deleteDriver(int driverId) {
		if (AppUser.getRole() == Role.ADMIN) {
			Optional<Driver> dri = driRepo.findById(driverId);
			if (dri.isPresent()) {
				driRepo.deleteById(driverId);
				return dri.get();
			} else {

				throw new DriverNotFoundException("Driver is not present");
			}
		} else {
			throw new InvalidUserNamePasswordException("Login First");
		}
	}

	@Override
	public List<Driver> ViewBestDrivers() {
		if (AppUser.getRole() == Role.CUSTOMER) {
			return driRepo.findByViewBestDrivers();
		} else {
			throw new InvalidUserNamePasswordException("Login First");
		}
	}

	@Override
	public Driver viewDriver(int driverId) {
		if (AppUser.getRole() == Role.ADMIN) {
			Optional<Driver> dri = driRepo.findById(driverId);
			if (dri.isPresent()) {
				return dri.get();
			} else {

				throw new DriverNotFoundException("Driver is not present");
			}
		} else {
			throw new InvalidUserNamePasswordException("Login First");
		}
	}

}
