package Cab.Service.demo.dto;

import org.springframework.stereotype.Component;

@Component
public class Ratedto {

	int driverId;
	float rating;
	
	
	public Ratedto() {
		super();
	}


	public Ratedto(int driverId, float rating) {
		super();
		this.driverId = driverId;
		this.rating = rating;
	}


	public int getDriverId() {
		return driverId;
	}


	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}


	public float getRating() {
		return rating;
	}


	public void setRating(float rating) {
		this.rating = rating;
	}


	@Override
	public String toString() {
		return "Rundto [driverId=" + driverId + ", rating=" + rating + "]";
	}
	
	
	
	
	
	
}


