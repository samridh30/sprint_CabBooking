package Cab.Service.demo.dto;

import org.springframework.stereotype.Component;

import Cab.Service.demo.model.Cab;
@Component
public class Driverdto {
	int driverId;
	float rating;
	Cab cab;
	
	
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
	public Cab getCab() {
		return cab;
	}
	public void setCab(Cab cab) {
		this.cab = cab;
	}
	@Override
	public String toString() {
		return "Driverdto [driverId=" + driverId + ", rating=" + rating + ", cab=" + cab + "]";
	}
	
	

}
