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

	private static Driver driver;

	@BeforeAll
	public static void setUp() {
		driver = new Driver (5,"Pb-101206",4.9f,null,true);
	}
	@AfterAll
	public static void tearDown() {
		driver = null;
	}

//	@Test
//	public void testInsertDriver() {
//		LOG.info(driver.toString());
//		Driver expected = driver;
//		Driver actual = driserimp.insertDriver(driver);
//		assertEquals(expected, actual);
//	}
//	
//	@Test
//	public void testInsertDriverFailure() {
//		LOG.info(driver.toString());
//		Driver unexpected = driver;
//		Driver actual = driserimp.insertDriver(new Driver(6,"Pb-101206",4.9f,null,true) );
//		assertEquals(unexpected, actual);
//	}

	@Test
	public void testUpdateDriver() {
	LOG.info(driver.toString());
	Driver expected = driver;
	Driver actual = driserimp.updateDriver(driver);
    assertEquals(expected, actual);
	}

	@Test
	public void testDeleteDriver() {
	LOG.info(driver.toString());
	Driver expected = driver;
	Driver actual = driserimp.updateDriver(driver);
    assertEquals(expected, actual);
	}



}