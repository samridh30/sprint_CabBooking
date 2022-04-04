package Cab.Service.demo.Service;

import java.util.List;

import Cab.Service.demo.model.Cab;

public interface ICabService {
	Cab insertCab(Cab cab);
	Cab updateCab(Cab cab);
	Cab deleteCab(int cabId);
	List<Cab> viewCabsOfType(String carType);
	int countCabsOfType(String carType);

}
