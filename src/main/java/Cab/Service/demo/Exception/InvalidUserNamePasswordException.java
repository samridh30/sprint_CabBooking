package Cab.Service.demo.Exception;

public class InvalidUserNamePasswordException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidUserNamePasswordException() {

	}

	public InvalidUserNamePasswordException(String message) {
		super(message);
	}
}
