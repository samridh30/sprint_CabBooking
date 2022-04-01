package Cab.Service.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.ComponentScan;

@Entity
@ComponentScan
@Table(name = "Driver")
public class Driver {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name = "Driver_Id")
private int driverId;
@Column(name = "License_No")
private String licenseNo;
@Column(name = "Rating")
private float rating;
@Column(name = "Cab")
private Cab cab;
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
public Driver() {
	super();
	
}
public Driver(int driverId, String licenseNo, float rating, Cab cab) {
	super();
	this.driverId = driverId;
	this.licenseNo = licenseNo;
	this.rating = rating;
	this.cab = cab;
}
@Override
public String toString() {
	return "Driver [driverId=" + driverId + ", licenseNo=" + licenseNo + ", rating=" + rating + ", cab=" + cab + "]";
}

}
