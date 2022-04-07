package Cab.Service.demo.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import Cab.Service.demo.model.Driver;

@SpringBootTest
public class DriverServiceImplTests {
	Logger LOG = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private DriverServiceImpl driserimp;
	@Autowired
	CustomerServiceImpl login;

	private static Driver driver;

	@BeforeAll
	public static void setUp() {
		driver = new Driver(5, "Pb-101206", 4.9f, null, true);
	}

	@AfterAll
	public static void tearDown() {
		driver = null;
	}

	@Test
	public void testInsertDriver() {
	login.loggedInUser.getRole();
		LOG.info(driver.toString());
		Driver expected = driver;
		Driver actual = driserimp.insertDriver(driver);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testInsertDriverFailure() {
	 login.loggedInUser.getRole();
		LOG.info(driver.toString());
		Driver unexpected = driver;
		Driver actual = driserimp.insertDriver(new Driver(6,"Pb-101206",4.9f,null,true) );
		assertEquals(unexpected, actual);
	}

	@Test
	public void testUpdateDriver() {
		login.loggedInUser.getRole();
		LOG.info(driver.toString());
		Driver expected = driver;
		Driver actual = driserimp.updateDriver(driver);
		assertEquals(expected, actual);
	}

	@Test
	public void testDeleteDriver() {
		login.loggedInUser.getRole();
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
		login.loggedInUser.getRole();
		LOG.info(driver.toString());
		Driver expected = driver;
		Driver actual = driserimp.viewDriver(driver.getDriverId());
		assertEquals(expected, actual);
	}

}