package Cab.Service.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Cab.Service.demo.model.Cab;

@Repository
public interface CabRepositoryImpl extends JpaRepository<Cab, Integer> {
	List<Cab> findByCarType(String carType);
	int countByCarType(String carType);

}
