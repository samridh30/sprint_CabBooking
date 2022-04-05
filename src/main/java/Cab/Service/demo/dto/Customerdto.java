package Cab.Service.demo.dto;

import org.springframework.stereotype.Component;

@Component
public class Customerdto {
	private int customerId;
	private String username;
	
	
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
