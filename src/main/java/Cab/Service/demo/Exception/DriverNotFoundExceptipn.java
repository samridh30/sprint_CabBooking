package Cab.Service.demo.Exception;

public class DriverNotFoundExceptipn extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DriverNotFoundExceptipn() {

	}

	public DriverNotFoundExceptipn(String message) {
		super(message);
	}
}
