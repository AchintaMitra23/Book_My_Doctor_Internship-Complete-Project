package com.capg.bookmydoctor.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.bookmydoctor.entities.Admin;
import com.capg.bookmydoctor.services.IAdminService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController	
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	private IAdminService adminService;

	@PostMapping("/AddAdmin")
	public Admin saveAdmin(@Valid @RequestBody Admin admin) {
		return adminService.addAdmin(admin);
	}

	@DeleteMapping("/DeleteAdminById/{id}")
	public void removeAdmin(@PathVariable("id") int id) {
		adminService.removeAdmin(id);
	}

	@GetMapping("/GetAdminById/{id}")
	public Admin find_admin(@PathVariable("id") int id) {
		return adminService.viewAdmin(id);
	}

	@GetMapping("/GetAllAdmins")
	public List<Admin> getAdmins() {
		return adminService.getAllAdmins();
	}

	@PutMapping("/UpdateAdmin")
	public Admin update_admin(@Valid @RequestBody Admin admin) {
		return adminService.updateAdmin(admin);
	}

	@GetMapping("/GetAdminByName/{name}")
	public List<Admin> allAdminByName(@PathVariable("name") String name) {
		return adminService.getAdminByName(name);
	}
	
	@GetMapping("/GetAdminIdByUserId/{id}") 
	public int getAdminByUserId(@PathVariable("id") int id) {
		return adminService.getAdminIdByUserId(id);
	}

}
