package Cab.Service.demo.model;

import java.util.Objects;

public class Cab{
	private int cabId;
	private String carType;
	@Override
	public int hashCode() {
		return Objects.hash(cabId, carType, perKmRate);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cab other = (Cab) obj;
		return cabId == other.cabId && Objects.equals(carType, other.carType)
				&& Float.floatToIntBits(perKmRate) == Float.floatToIntBits(other.perKmRate);
	}
	private float perKmRate;
	public int getCabId() {
		return cabId;
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
	public void setCabId(int cabId) {
		this.cabId = cabId;
	}
	public Cab() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CabService [cabId=" + cabId + ", carType=" + carType + ", perKmRate=" + perKmRate + "]";
	}
}