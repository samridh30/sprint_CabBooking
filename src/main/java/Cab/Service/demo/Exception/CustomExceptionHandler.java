package Cab.Service.demo.Exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<Object> handleCustomerNotFoundException(CustomerNotFoundException e) {
		String exceptionMessage = e.getMessage();
		LOG.info(exceptionMessage);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", exceptionMessage);
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CabNotFoundException.class)
	public ResponseEntity<Object> handleCabNotFoundException(CabNotFoundException e) {
		String exceptionMessage = e.getMessage();
		LOG.info(exceptionMessage);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", exceptionMessage);
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(TripNotFoundException.class)
	public ResponseEntity<Object> handleCustomerNotFoundException(TripNotFoundException e) {
		String exceptionMessage = e.getMessage();
		LOG.info(exceptionMessage);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", exceptionMessage);
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvalidTripFoundException.class)
	public ResponseEntity<Object> handleInvalidTripFoundException(InvalidTripFoundException e) {

		String exceptionMessage = e.getMessage();
		LOG.info(exceptionMessage);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", exceptionMessage);
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(DriverAlreadyExistsException.class)
	public ResponseEntity<Object> handleDriverAlreadyExistsException(DriverAlreadyExistsException e) {
		String exceptionMessage = e.getMessage();
		LOG.info(exceptionMessage);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", exceptionMessage);
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DriverNotFoundException.class)
	public ResponseEntity<Object> drivernotfound(DriverNotFoundException e) {
		String exceptionMessage = e.getMessage();
		LOG.info(exceptionMessage);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", exceptionMessage);
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidAccessException.class)
	public ResponseEntity<Object> drivernotfound(InvalidAccessException e) {
		String exceptionMessage = e.getMessage();
		LOG.info(exceptionMessage);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", exceptionMessage);
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}






}
