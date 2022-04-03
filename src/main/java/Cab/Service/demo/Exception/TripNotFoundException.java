package Cab.Service.demo.Exception;

public class TripNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	TripNotFoundException(){
		
	}
	public TripNotFoundException(String message){
		super(message);
	
		
	}

}
