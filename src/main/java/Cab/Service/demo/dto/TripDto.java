package Cab.Service.demo.dto;

public class TripDto {

	private String fromLocation;
	private String toLocation;
	private String cabType;

	public TripDto(String fromLocation, String toLocation, String cabType) {
		super();
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.cabType=cabType;
	}
	

	public String getCabType() {
		return cabType;
	}


	public void setCabType(String cabType) {
		this.cabType = cabType;
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
