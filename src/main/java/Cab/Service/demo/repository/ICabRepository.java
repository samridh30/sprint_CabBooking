package Cab.Service.demo.repository;

import java.util.List;

import Cab.Service.demo.model.Cab;

public interface ICabRepository {
	Cab insertCab(Cab cab);
	Cab updateCab(Cab cab);
	Cab deleteCab(int cabId);
	List<Cab> viewCabsOfType(String carType);
	int countCabsOfType(String carType);

}
