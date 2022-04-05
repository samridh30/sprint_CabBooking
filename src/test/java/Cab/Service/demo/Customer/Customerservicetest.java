package Cab.Service.demo.Customer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Cab.Service.demo.Service.CustomerServiceImpl;
import Cab.Service.demo.contoller.TripBookingController;
import Cab.Service.demo.model.Customer;
import Cab.Service.demo.model.Role;
import Cab.Service.demo.repository.CustomerRepositorImpl;


@SpringBootTest
public class Customerservicetest {
	
	private MockMvc mockMvc;
	@Autowired
	private TripBookingController TripC;
	
//	ObjectMapper om = new ObjectMapper();
//	@Before(value = "")
//	private void setup() {
//		mockMvc=MockMvcBuilders.webAppContextSetup((WebApplicationContext) TripC).build();
//		
//	}
//	
//	public void addCustomer() throws JsonProcessingException {
//		Customer c=new Customer();
//		c.setUserName("Srikanth");
//		c.setEmail("duygu@gmail.com");
//		
//		String jsonRequest=om.writeValueAsString(c);
//		MvcResult result =mockMvc.perform(Get("Customer/viewCustomer/{Id}"));
//	}
	
	
	

}
