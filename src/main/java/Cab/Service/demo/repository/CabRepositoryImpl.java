package Cab.Service.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Cab.Service.demo.model.Cab;

@Repository
public interface CabRepositoryImpl extends JpaRepository<Cab, Integer> {
	List<Cab> findByCarType(String carType);

	int countByCarType(String carType);

	@Query(value = "select cab_id from cab where cab_id Not In (SELECT DISTINCT t1.cab_id FROM cab t1 JOIN driver t2 ON t1.cab_id = t2.cab_cab_id)", nativeQuery = true)
	List<Integer> availableCabs();

}
