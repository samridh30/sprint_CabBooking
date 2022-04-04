package Cab.Service.demo.contoller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Cab.Service.demo.Service.AdminServiceImpl;
import Cab.Service.demo.model.TripBooking;

//admin/Driver/getDriver
///admin/cab/getCabs
@RestController
@RequestMapping("/admin")
public class AdminController {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AdminServiceImpl adm;

//	http://localhost:8088/admin/getCabs
	@GetMapping("/getCabs")
	public ResponseEntity<List<TripBooking>> getByCarType() {
//		LOG.info(carType);
		return new ResponseEntity<List<TripBooking>>(adm.getAllTrips(), HttpStatus.OK);
	}

	@GetMapping("/check")
	public ResponseEntity<String> cehckTest() {
//		LOG.info(carType);
		return new ResponseEntity<String>(adm.check(), HttpStatus.OK);
	}

////	http://localhost:8088/admin/getAll
////	Fetches all Admins as a list
//	@GetMapping("/getAll")
//	public ResponseEntity<List<Admin>> getAdmin() {
//		LOG.info("ok");
//		return new ResponseEntity<List<Admin>>(adm.getAllAdmin(), HttpStatus.OK);
//	}
//
////	http://localhost:8088/admin/getCabs
//	@GetMapping("/getCabs")
//	public ResponseEntity<List<Cab>> getAllCab() {
////		LOG.info();
//		return new ResponseEntity<List<Cab>>(adm.getCabs(), HttpStatus.OK);
//	}
//
////	http://localhost:8088/admin/getCabs/mini
//	@GetMapping("/getCabs/{carType}")
//	public ResponseEntity<List<Cab>> getByCarType(@PathVariable(name = "carType") String carType) {
//		LOG.info(carType);
//		return new ResponseEntity<List<Cab>>(adm.getByCarTypes(carType), HttpStatus.OK);
//	}
//
////	http://localhost:8088/admin/register
//	@PostMapping("/register")
//	public ResponseEntity<Admin> insertAdmin(@RequestBody Admin admin) {
//		LOG.info(admin.toString());
//		return new ResponseEntity<Admin>(adm.insertAdmin(admin), HttpStatus.CREATED);
//	}
//
////	http://localhost:8088/admin/update
//	@PutMapping("/update")
//	public ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin) {
//		LOG.info(admin.toString());
//		return new ResponseEntity<Admin>(adm.updateAdmin(admin), HttpStatus.OK);
//	}
//
////	//	http://localhost:8088/admin/delete/{1}
//	@DeleteMapping("/delete/{eid}")
//	public ResponseEntity<Admin> deleteAdmin(@PathVariable(name = "eid") String adminId) {
//		LOG.info(adminId);
//		return new ResponseEntity<Admin>(adm.deleteAdmin(Integer.parseInt(adminId)), HttpStatus.OK);
//	}

}
