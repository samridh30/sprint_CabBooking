package Cab.Service.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import Cab.Service.demo.model.Driver;

@Repository
@EnableJpaRepositories
public interface DriverRepositoryImpl extends JpaRepository<Driver, Integer> {
	
	@Query("select a from Driver a where a.rating>=4.5")
	List<Driver> findByViewBestDrivers();
	
	@Query(value="select * from Driver d where d.status=false ", nativeQuery=true)
	List<Driver> findByStatus();
	

}
