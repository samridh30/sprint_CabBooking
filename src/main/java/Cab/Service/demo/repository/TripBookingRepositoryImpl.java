package Cab.Service.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Cab.Service.demo.model.Customer;
import Cab.Service.demo.model.TripBooking;
@Repository
public interface TripBookingRepositoryImpl extends JpaRepository<TripBooking, Integer>{
	@Query(value="select * from trip_booking_table t where t.customer_id=:customerId", nativeQuery=true)
	List<TripBooking> findByCustomer(@Param("customerId")  int customerId);
	
	@Query(value= "select c.rate_per_km from trip_booking_table t  join driver_table  d on d.driver_id=t.driver_id join cab_table c on d.cab_cab_id=c.cab_id where t.customer_id=:Id", nativeQuery=true)
	float findByPerKmRate(@Param("Id")int Id);
	

}
