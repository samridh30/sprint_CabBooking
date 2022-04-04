package Cab.Service.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Cab.Service.demo.Exception.CabNotFoundException;
import Cab.Service.demo.model.Cab;
import Cab.Service.demo.repository.CabRepositoryImpl;

@Service
public class CabServiceImpl implements ICabService {
	@Autowired
	CabRepositoryImpl car_repo;

	@Override
	public Cab insertCab(Cab cab) {
		Optional<Cab> car = car_repo.findById(cab.getCabId());
		if (car.isEmpty()) {
			car_repo.save(cab);
			return cab;
		} else {
			return null;
		}
	}

	@Override
	public Cab updateCab(Cab cab) {
		Optional<Cab> car = car_repo.findById(cab.getCabId());
		if (car.isPresent()) {
			car_repo.save(cab);
			return cab;
		} else {
			throw new CabNotFoundException("Invalid Customer");
		}
	}

	@Overrid
	public Cab deleteCab(int cabId) {
		Optional<Cab> car=car_repo.findById(cabId);
		if(car.isPresent()) {
			car_repo.deleteById(cabId);
			return car.get();
		}else {
			throw new CabNotFoundException("Invalid Id");
		}
	}

	@Override
	public List<Cab> viewCabsOfType(String carType) {
		List<Cab> car = car_repo.findByCarType(carType);
		return car;
	}

	@Override
	public int countCabsOfType(String carType) {

		return 0;
	}

}
