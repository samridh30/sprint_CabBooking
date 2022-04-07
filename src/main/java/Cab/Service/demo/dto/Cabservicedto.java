package Cab.Service.demo.dto;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;
@Component
public class Cabservicedto {
	private int customerId;
	private String customername;
	private String fromLocation;
	private String toLocation;
	private LocalDateTime fromDateTime;
	private LocalDateTime toDateTime;
	private int driverId;
	private float rating;
	private String cabtype;
	float bill;

	Cabservicedto(){
		
	}
	
	/**
	 * @desc Cabservicedto
	 */
	
	public Cabservicedto(int customerId, String customername, String fromLocation, String toLocation,
			LocalDateTime fromDateTime, LocalDateTime toDateTime, int driverId, float rating, String cabtype,
			float bill) {
		super();
		this.customerId = customerId;
		this.customername = customername;
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.fromDateTime = fromDateTime;
		this.toDateTime = toDateTime;
		this.driverId = driverId;
		this.rating = rating;
		this.cabtype = cabtype;
		this.bill = bill;
	}

	/**
	 * @desc Getters and Setters
	 */

	public float getBill() {
		return bill;
	}
	public void setBill(float bill) {
		this.bill = bill;
	}
	public String getFromLocation() {
		return fromLocation;
	}
	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}
	public String getToLocation() {
		return toLocation;
	}
	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}
	public LocalDateTime getFromDateTime() {
		return fromDateTime;
	}
	public void setFromDateTime(LocalDateTime fromDateTime) {
		this.fromDateTime = fromDateTime;
	}
	public LocalDateTime getToDateTime() {
		return toDateTime;
	}
	public void setToDateTime(LocalDateTime toDateTime) {
		this.toDateTime = toDateTime;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
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
	public String getCabtype() {
		return cabtype;
	}
	public void setCabtype(String cabtype) {
		this.cabtype = cabtype;
	}
	@Override
	public String toString() {
		return "Cabservicedto [bill=" + bill + ", fromLocation=" + fromLocation + ", toLocation=" + toLocation
				+ ", fromDateTime=" + fromDateTime + ", toDateTime=" + toDateTime + ", customerId=" + customerId
				+ ", customername=" + customername + ", driverId=" + driverId + ", rating=" + rating + ", cabtype="
				+ cabtype + "]";
	}
	
	
		

}
