package Cab.Service.demo.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import Cab.Service.demo.model.Cab;

@SpringBootTest
public class CabServiceImplTests {

	Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CabServiceImpl cabService;
	
	@Autowired
	CustomerServiceImpl login;

	private static Cab cab;

	@BeforeAll
	public static void setUp() {
		cab = new Cab(123, "mini", 4, true);

	}
	
	@Test
	public void testInsertCab() {
		login.loggedInUser.getRole();
		LOG.info(cab.toString());
		Cab expected = cab;
		Cab actual = cabService.updateCab(cab);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testInsertCabFailure() {
		login.loggedInUser.getRole();
		LOG.info(cab.toString());
		Cab unexpected = cab;
		Cab actual = cabService.insertCab(new Cab(456, "sedane", 5, true) );
		assertEquals(unexpected, actual);
	}

	@Test
	public void testUpdateCab() {
		login.loggedInUser.getRole();
		LOG.info(cab.toString());
		Cab expected = cab;
		Cab actual = cabService.updateCab(cab);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testDeleteCab() {
		login.loggedInUser.getRole();
		LOG.info(cab.toString());
		Cab expected = cab;
		Cab actual = cabService.updateCab(cab);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testviewCabsOfType() {
		login.loggedInUser.getRole();
		LOG.info(cab.toString());
		Cab expected = cab;
		Cab actual = cabService.updateCab(cab);
		assertEquals(expected, actual);
	}
	
}