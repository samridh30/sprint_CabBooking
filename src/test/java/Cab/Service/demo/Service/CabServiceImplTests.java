package Cab.Service.demo.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import Cab.Service.demo.model.Cab;
import Cab.Service.demo.model.Driver;
import Cab.Service.demo.Service.CabServiceImpl;

@SpringBootTest
public class CabServiceImplTests {

	Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CabServiceImpl cabService;

	private static Cab cab;

	@BeforeAll
	public static void setUp() {
		cab = new Cab(123, "mini", 4, true);

	}
	
	@Test
	public void testInsertCab() {
		LOG.info(cab.toString());
		Cab expected = cab;
		Cab actual = cabService.updateCab(cab);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testInsertCabFailure() {
		LOG.info(cab.toString());
		Cab unexpected = cab;
		Cab actual = cabService.insertCab(new Cab(456, "sedane", 5, true) );
		assertEquals(unexpected, actual);
	}

	@Test
	public void testUpdateCab() {
		LOG.info(cab.toString());
		Cab expected = cab;
		Cab actual = cabService.updateCab(cab);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testDeleteCab() {
		LOG.info(cab.toString());
		Cab expected = cab;
		Cab actual = cabService.updateCab(cab);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testviewCabsOfType() {
		LOG.info(cab.toString());
		Cab expected = cab;
		Cab actual = cabService.updateCab(cab);
		assertEquals(expected, actual);
	}
	
}