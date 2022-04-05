package Cab.Service.demo.Exception;

public class AlreadyLoggedInException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AlreadyLoggedInException() {

	}

	public AlreadyLoggedInException(String message) {
		super(message);
	}
}
