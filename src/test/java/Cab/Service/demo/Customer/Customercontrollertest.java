package Cab.Service.demo.Customer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springdoc.ui.SpringDocUIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import Cab.Service.demo.Service.CustomerServiceImpl;
import Cab.Service.demo.model.Customer;
import Cab.Service.demo.model.Role;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class Customercontrollertest {
//	@Autowired
//	private MockMvc mvc;
//	
//	
//	@MockBean
//	private CustomerServiceImpl customerImpl;
//	
//	@Test
//	void testGetCustomer() {
//		Customer c= new Customer();
//		c.setAddress("hyd");
//		c.setCustomerId(5);
//		c.setMobileNumber(665L);
//		c.setPassword("se4t");
//		c.setRole(Role.CUSTOMER);
//		c.setUserName("Srikanth");
//		c.setEmail("dguygug@gmail.com");
//		
//		
//		
//		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("fytfy")).andReturn();
//		int status = mvcResult.getResponse().getStatus();
//		assertEquals(200, status);
//		String content = mvcResult.getResponse().getContentAsString();
//		Customer customer = super.mapFromJson(content, Customer.class);
//		assertEquals("shadow007", customerImpl.viewCustomer(5));
//
//	}
	

}
