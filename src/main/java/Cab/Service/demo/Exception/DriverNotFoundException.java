package Cab.Service.demo.Exception;

public class DriverNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DriverNotFoundException() {

	}

	public DriverNotFoundException(String message) {
		super(message);
	}
}
