package Cab.Service.demo.repository;

import java.util.List;

import Cab.Service.demo.model.Driver;

public interface IDriverRepository {
	Driver insertDriver(Driver driver);
	Driver updateDriver(Driver driver);
	Driver deleteDriver(int driverId);
	List<Driver> viewBestDrivers();
	Driver viewDriver(int driverId);

}
