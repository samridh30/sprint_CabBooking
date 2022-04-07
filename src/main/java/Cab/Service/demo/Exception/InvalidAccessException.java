package Cab.Service.demo.Exception;

public class InvalidAccessException  extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	InvalidAccessException(){
		
	}
	
	public InvalidAccessException(String message){
		super(message);
	}
	
	

}
