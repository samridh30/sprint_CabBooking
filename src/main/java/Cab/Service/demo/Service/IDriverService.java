package Cab.Service.demo.Service;

import java.util.List;


import Cab.Service.demo.model.Driver;

public interface IDriverService {

	public Driver insertDriver(Driver driver);

	public Driver updateDriver(Driver driver);

	public Driver deleteDriver(int driverId);

	public List<Driver> ViewBestDrivers();

	public Driver viewDriver(int driverId);

}
