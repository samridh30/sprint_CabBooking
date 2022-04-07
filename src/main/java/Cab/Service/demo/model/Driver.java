package Cab.Service.demo.model;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;

import javax.persistence.OneToOne;

@Entity
public class Driver {

	@Id

	@GeneratedValue

	private int driverId;
	private String licenseNo;
	private float rating;
	@OneToOne(cascade = { CascadeType.MERGE} )
	private Cab cab;
	private boolean status = true;
	
	Driver(){
		
	}

	public Driver(int i, String string, double d, boolean b) {
	}

	public Driver(int driverId, String licenseNo, float rating, Cab cab, boolean status) {
		super();
		this.driverId = driverId;
		this.licenseNo = licenseNo;
		this.rating = rating;
		this.cab = cab;
		this.status = status;
	}

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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Driver [driverId=" + driverId + ", licenseNo=" + licenseNo + ", rating=" + rating + ", cab=" + cab
				+ ", status=" + status + "]";
	}

}
