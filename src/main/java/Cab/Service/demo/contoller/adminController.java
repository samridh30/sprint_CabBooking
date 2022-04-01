package Cab.Service.demo.contoller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Cab.Service.demo.Service.AdminServiceImpl;
import Cab.Service.demo.model.Admin;

@RestController
@RequestMapping("/admin")
public class adminController {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AdminServiceImpl adm;

	@PostMapping("/register")
	public ResponseEntity<Admin> insertAdmin(@RequestBody Admin admin) {
		LOG.info(admin.toString());
		return new ResponseEntity<Admin>(adm.insertAdmin(admin), HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin) {
		LOG.info(admin.toString());
		return new ResponseEntity<Admin>(adm.updateAdmin(admin), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{eid}")
	public ResponseEntity<Admin> deleteAdmin(@PathVariable(name = "eid") int adminId) {
//		LOG.info(adminId);
		return new ResponseEntity<Admin>(adm.deleteAdmin(adminId), HttpStatus.OK);
	}

}
