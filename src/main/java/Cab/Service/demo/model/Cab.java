package Cab.Service.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class Cab {

	public Cab() {

	}

	public Cab(int cabId, String carType, float perKmRate, boolean status) {
		super();
		this.cabId = cabId;
		this.carType = carType;
		this.perKmRate = perKmRate;
		this.status = status;
	}

	@Id
	@GeneratedValue
	private int cabId;
	private String carType;
	private float perKmRate;
	private boolean status;

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getCabId() {
		return cabId;
	}

	public void setCabId(int cabId) {
		this.cabId = cabId;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public float getPerKmRate() {
		return perKmRate;
	}

	public void setPerKmRate(float perKmRate) {
		this.perKmRate = perKmRate;
	}

	@Override
	public String toString() {
		return "Cab [cabId=" + cabId + ", carType=" + carType + ", perKmRate=" + perKmRate + ", status=" + status + "]";
	}

}
