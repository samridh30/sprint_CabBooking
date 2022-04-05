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
public interface TripBookingRepositoryImpl extends JpaRepository<TripBooking, Integer> {
	/**
	 * @desc To fetch Trips bookings of a customer By Id
	 * @return List of trips of a CustomerId
	 */

	@Query(value = "select * from trip_booking t where t.customer_id=:customerId", nativeQuery = true)
	List<TripBooking> findByCustomer(@Param("customerId") int customerId);

	/**
	 * @desc To fetch RatePerKm field from cab to calculate Bill for a trip
	 * @return RatePerKm float value
	 */
	@Transactional
	@Query(value = "select c.per_km_rate from trip_booking t  join driver d on d.driver_id=t.driver_id join cab c on d.cab_cab_id=c.cab_id where t.customer_id=:Id and t.status=true", nativeQuery = true)
	float findByPerKmRate(@Param("Id") int Id);

	/**
	 * @desc To Delete A trip of customerById from tripBooking table
	 * 
	 */
	@Transactional
	@Modifying
	@Query(value = "delete from trip_booking t where t.customer_id=:Id", nativeQuery = true)
	void deleteTripByCustomerId(@Param("Id") int Id);

	@Query(value = "select * from trip_booking t where t.customer_id=:Id and t.status=true", nativeQuery = true)
	TripBooking findByCustomerId(@Param("Id") int customerId);

	public default boolean validateTripInsert(int Id) {

		return true;

	}

	@Query(value = "select t.customer_id from trip_booking t where t.customer_id=:customerId and t.status=true", nativeQuery = true)
	List<Integer> IsCustomerInTrip(@Param("customerId") int customerId);

	@Transactional
	@Modifying
	@Query(value = " update trip_booking  set driver_id= null where driver_id=:Id", nativeQuery = true)
	void deletedriver(@Param("Id") int Id);

}
