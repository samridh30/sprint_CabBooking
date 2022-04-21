package Cab.Service.demo.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import Cab.Service.demo.model.AppUser;
import Cab.Service.demo.model.Driver;

@SpringBootTest
public class DriverServiceImplTests {
	Logger LOG = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private DriverServiceImpl driserimp;
	@Autowired
	CustomerServiceImpl login;
	
	private static Driver driver;

	
	@BeforeEach
	void start() {
		AppUser app = new AppUser();
		app.setEmail("Sajal@gmail.com");
		app.setPassword("Sajal@");
		login.loginUser(app);
		driver = new Driver(229, "Rohan", "Id6", 4.9f, null, true);
		
				}
	
	@AfterEach
	void end() {
		login.logoutUser();
		driver = null;
	}


	@Test
	public void testInsertDriver() {
	
		Driver expected = driver;
		Driver actual = driserimp.insertDriver(driver);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testInsertDriverFailure() {
	 
		Driver unexpected = driver;
		Driver actual = driserimp.insertDriver(new Driver(6,"Pb-101206","Sharma", 4.9f,null,true) );
		assertNotEquals(unexpected, actual);
	}

	
	@Test
	public void testUpdateDriver() {
		Driver expected = driver;
		Driver actual = driserimp.updateDriver(driver);
		assertEquals(expected, actual);
	}

	@Disabled
	@Test
	public void testDeleteDriver() {
		LOG.info(driver.toString());
		Driver expected = driver;
		Driver actual = driserimp.deleteDriver(driver.getDriverId());
		assertEquals(expected, actual);
	}

	@Test
	public void testViewAllDrivers() {
		login.loggedInUser.getRole();
		LOG.info("best driver test");

	}

	@Test
	public void testViewDriversById() {
		LOG.info(driver.toString());
		Driver expected = driver;
		Driver actual = driserimp.viewDriver(driver.getDriverId());
		assertEquals(expected, actual);
	}

}