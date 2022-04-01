package Cab.Service.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Cab.Service.demo.model.TripBooking;
@Repository
public interface TripBookingRepositoryImpl extends JpaRepository<TripBooking, Integer>, ITripBookingRepository {
	List<TripBooking> findByCustomerId(int customerId);
	

}
