package Cab.Service.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.context.annotation.ComponentScan;

@Entity
@Table(name = "Driver_table")
public class Driver {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int driverId;
private String licenseNo;
private float rating;
@OneToOne
private Cab cab;

//@OneToMany
//
//private List<TripBooking> Trip_id;


//public List<TripBooking> getTrip_id() {
//	return Trip_id;
//}
//public void setTrip_id(List<TripBooking> trip_id) {
//	Trip_id = trip_id;
//}
public int getDriverId() {
	return driverId;
}
public void setDriverId(int driverId) {
	this.driverId = driverId;
}
public String getLicenseNo() {
	return licenseNo;
}
public void setLicenseNo(String licenseNo) {
	this.licenseNo = licenseNo;
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
	return "Driver [driverId=" + driverId + ", licenseNo=" + licenseNo + ", rating=" + rating + ", cab=" + cab + "]";
}

}