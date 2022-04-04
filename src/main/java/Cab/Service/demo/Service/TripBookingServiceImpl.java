package Cab.Service.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Cab.Service.demo.Exception.TripNotFoundException;
import Cab.Service.demo.model.TripBooking;
import Cab.Service.demo.repository.TripBookingRepositoryImpl;

@Service
public class TripBookingServiceImpl implements ITripBookingService {
	@Autowired
	TripBookingRepositoryImpl tripRepo;
	

	@Override
	public TripBooking insertTripBooking(TripBooking tripBooking) {
		Optional<TripBooking> trip= tripRepo.findById(tripBooking.getTripBookingId());
		if(trip.isPresent()) {
			return null;
		}else {
			tripRepo.save(tripBooking);

			int cus_id=tripBooking.getCustomer().getCustomerId();
			TripBooking book=calculateBill(cus_id);
			
			return tripRepo.save(book);
			
		}
	}

	@Override
	public TripBooking updateTripBooking(TripBooking tripBooking) {
		Optional<TripBooking> trip=tripRepo.findById(tripBooking.getTripBookingId());
		if(trip.isPresent()) {
			return tripRepo.save(tripBooking);
		}else {
			throw new TripNotFoundException("Invalid Data");
		}

	
	}

	@Override
	public TripBooking deleteTripBooking(int tripBookingId) {
		Optional<TripBooking> trip=tripRepo.findById(tripBookingId);
		if(trip.isPresent()) {
			tripRepo.deleteById(tripBookingId);
			return trip.get();		}
		else {
			throw new TripNotFoundException("Invalid Id-"+tripBookingId);
		}
	}

	@Override
	public List<TripBooking> ViewAllTripsCustomer(int customerId) {
		
		List<TripBooking> trip= tripRepo.findByCustomer(customerId);
		return trip;
		//return null;
	}

	@Override
	public TripBooking calculateBill(int customerId) {
		float rate=tripRepo.findByPerKmRate(customerId);
		TripBooking t= tripRepo.findByCustomerId(customerId);
		TripBooking trip= tripRepo.getById(t.getTripBookingId());
		trip.setBill(trip.getDistanceInKm()*rate);
		return trip;
	}

}
