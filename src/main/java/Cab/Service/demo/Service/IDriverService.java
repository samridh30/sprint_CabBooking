package Cab.Service.demo.Service;

import java.util.List;

import Cab.Service.demo.model.Driver;

public interface IDriverService {

	Driver insertDriver(Driver driver);

	Driver updateDriver(Driver driver);

	Driver deleteDriver(int driverId);

	List<Driver> ViewBestDrivers();

	Driver viewDriver(int driverId);

	List<Driver> ViewAllDrivers();

}
