package Cab.Service.demo.Exception;

public class UserNotLoggedInException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserNotLoggedInException() {
	}

	public UserNotLoggedInException(String message) {
		super(message);
	}
}
