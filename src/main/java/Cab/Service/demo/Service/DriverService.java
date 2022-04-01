package Cab.Service.demo.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Cab.Service.demo.model.Driver;
import Cab.Service.demo.repository.IDriverRepository;

@Service
public class DriverService implements IDriverService {
	
	@Autowired
	private IDriverRepository driRepo;

	@Override
	public Driver insertDriver(Driver driver) {
		Optional<Driver> dri = driRepo.findById(driver.getDriverId());
		if(dri.isPresent()) {
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
		
		return null;
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
