package Cab.Service.demo.dto;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class Customerdto {
	private int customerId;
	private String username;
	
	
	public Customerdto() {
		super();
	}
	public Customerdto(int customerId, String username) {
		super();
		this.customerId = customerId;
		this.username = username;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "Customerdto [customerId=" + customerId + ", username=" + username + "]";
	}
	
	

}
