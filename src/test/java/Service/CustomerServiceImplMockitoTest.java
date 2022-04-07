package Service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import Cab.Service.demo.Service.CustomerServiceImpl;
import Cab.Service.demo.model.AppUser;
import Cab.Service.demo.model.Customer;
import Cab.Service.demo.model.Role;
import Cab.Service.demo.repository.CustomerRepositorImpl;

@ExtendWith(SpringExtension.class)
public class CustomerServiceImplMockitoTest {
	
	@InjectMocks
	CustomerServiceImpl cusService;
	@Mock
	CustomerRepositorImpl custRepo;
	
	@BeforeEach
	void start() {
//		AppUser app = new AppUser();
//		app.setEmail("Sri@gmail.com");
//		app.setPassword("Srikanth@");
//		cusService.loginUser(app);
				}
	
	@AfterEach
	void end() {
		//cusService.logoutUser();
	}
	
	@Disabled
	@Test
	void insertCustomerTest() {
		Optional<Customer> c= Optional.of(new Customer(11,"Srikanth","Srikanth@","Hyderabad",1234567890L, "Srihari9@gmail.com",Role.CUSTOMER));
		
		Mockito.when(custRepo.findByEmail(c.get().getEmail())).thenReturn(null);
		Mockito.when(custRepo.save(c.get())).thenReturn(c.get());
		
		Customer insertTest=cusService.insertCustomer(c.get());
		assertEquals(11,insertTest.getCustomerId());
		}

}
