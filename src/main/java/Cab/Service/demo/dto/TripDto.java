package Cab.Service.demo.dto;

public class TripDto {

	private String fromLocation;
	private String toLocation;

	public TripDto(String fromLocation, String toLocation) {
		super();
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
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
		return "TripDto [fromLocation=" + fromLocation + ", toLocation=" + toLocation + "]";
	}

}
