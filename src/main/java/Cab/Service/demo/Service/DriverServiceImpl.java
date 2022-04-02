package Cab.Service.demo.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Cab.Service.demo.model.Driver;
import Cab.Service.demo.repository.DriverRepositoryImpl;

@Service
public class DriverServiceImpl implements IDriverService {
	
	@Autowired
	private DriverRepositoryImpl driRepo;

	@Override
	public Driver insertDriver(Driver driver) {
		Optional<Driver> dri = driRepo.findById(driver.getDriverId());
		if(dri.isPresent()) {
			System.out.println("Duplicate Id");
			return null;
		}
		else {
			driRepo.save(driver);
			return driver;
		}
		
	}

	@Override
	public Driver updateDriver(Driver driver) {
		Optional<Driver> dri = driRepo.findById(driver.getDriverId());
		if(dri.isPresent()) {
			driRepo.save(driver);
			return driver;
		}
		else {
			return null;
		}
	}

	@Override
	public Driver deleteDriver(int driverId) {
		Optional<Driver> dri = driRepo.findById(driverId);
		if(dri.isPresent()) {
			driRepo.deleteById(driverId);
			return dri.get();
		}
	
		return null;
	}

	@Override
	public List<Driver> ViewBestDrivers() {
		return driRepo.findByViewBestDrivers();
	}

	@Override
	public Driver viewDriver(int driverId) {
		Optional<Driver> dri = driRepo.findById(driverId);
		if(dri.isPresent()) {
			return dri.get();
		}
		else {
	
		return null;
		}
	}

	
}
