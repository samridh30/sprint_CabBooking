package Cab.Service.demo.Exception;

public class DriverAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DriverAlreadyExistsException() {

	}

	public DriverAlreadyExistsException(String message) {
		super(message);
	}
}
