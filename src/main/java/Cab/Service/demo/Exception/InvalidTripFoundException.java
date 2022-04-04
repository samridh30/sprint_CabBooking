package Cab.Service.demo.Exception;

public class InvalidTripFoundException extends RuntimeException  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	InvalidTripFoundException(){
		
	}
	public InvalidTripFoundException(String Message){
		super(Message);
	}
	

}
