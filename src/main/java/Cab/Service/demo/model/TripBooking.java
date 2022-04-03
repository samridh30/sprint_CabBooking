package Cab.Service.demo.model;


import java.time.LocalDateTime;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

//enum TripStatus {
//	  IN_PROGRESS,
//	  FINISHED
//	}

@Entity
@Table(name="TripBooking_table")
@Data
public class TripBooking {
	@Id
	@GeneratedValue
	private int tripBookingId;
	@ManyToOne(cascade= {CascadeType.MERGE ,CascadeType.PERSIST})
	@JoinColumn(name="customer_Id")
	private Customer customer;
	@ManyToOne(cascade= {CascadeType.MERGE ,CascadeType.PERSIST})
	@JoinColumn(name="driver_Id")
	private Driver driver;
	private String fromLocation;
	private String toLocation;
	private LocalDateTime fromDateTime;
	private LocalDateTime toDateTime;
	private boolean status;
	private float distanceInKm;
	private float bill;

	
		
	
}
