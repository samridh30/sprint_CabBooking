package Cab.Service.demo.Exception;
public class CabNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public CabNotFoundException() {
		
	}
	
	public CabNotFoundException(String message) {
		super(message);
	}

}