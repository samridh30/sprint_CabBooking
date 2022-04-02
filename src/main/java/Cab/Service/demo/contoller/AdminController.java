package Cab.Service.demo.contoller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
public class AdminController {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AdminServiceImpl adm;

	@GetMapping("getAll")
	public ResponseEntity<List<Admin>> getAdmin() {
		LOG.info("ok");
		return new ResponseEntity<List<Admin>>(adm.getAllAdmin(), HttpStatus.OK);
	}

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
	public ResponseEntity<Admin> deleteAdmin(@PathVariable(name = "eid") String adminId) {
		LOG.info(adminId);
		return new ResponseEntity<Admin>(adm.deleteAdmin(Integer.parseInt(adminId)), HttpStatus.OK);
	}
}
