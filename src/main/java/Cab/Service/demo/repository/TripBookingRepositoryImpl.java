package Cab.Service.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Cab.Service.demo.model.TripBooking;
@Repository
public interface TripBookingRepositoryImpl extends JpaRepository<TripBooking, Integer>{
	@Query(value="select * from trip_booking t where t.customer_id=:customerId", nativeQuery=true)
	List<TripBooking> findByCustomer(@Param("customerId")  int customerId);
	
	@Transactional
	@Query(value= "select c.per_km_rate from trip_booking t  join driver d on d.driver_id=t.driver_id join cab c on d.cab_cab_id=c.cab_id where t.customer_id=:Id", nativeQuery=true)
	float findByPerKmRate(@Param("Id")int Id);
	
	@Transactional
	@Modifying
	@Query(value="delete from trip_booking t where t.customer_id=:Id", nativeQuery=true)
	void deleteTripByCustomerId(@Param("Id")int Id);
	
	@Query(value="select * from trip_booking t where t.customer_id=:Id", nativeQuery=true)
	TripBooking findByCustomerId(@Param("Id") int customerId);
	

}
