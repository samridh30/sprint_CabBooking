package Cab.Service.demo.dto;

public class TripDateDto {

	private int customerId;
	private String fromLocation;
	private String toLocation;

	public TripDateDto(int customerId, String fromLocation, String toLocation) {
		super();
		this.customerId = customerId;
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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

	@Override
	public String toString() {
		return "TripDateDto [customerId=" + customerId + ", fromLocation=" + fromLocation + ", toLocation=" + toLocation
				+ "]";
	}

}
