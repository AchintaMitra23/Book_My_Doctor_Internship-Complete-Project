package com.capg.bookmydoctor.controllers;

/*****************************************************************
 *         @author          Achinta Mitra
 *         Description      It is an controller class for User
 *                          @RestController 
 *         Version          1.0
 *         Created On       27-July-2021
 ******************************************************************/

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

import com.capg.bookmydoctor.entities.User;
import com.capg.bookmydoctor.services.IUserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController	
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private IUserService userService;

	@GetMapping("/GetAllUser")
	public List<User> getALL() {
		return userService.getAll();
	}

	@GetMapping("/GetUserById/{id}")
	public User fetchById(@PathVariable("id") int id) {
		return userService.fetchById(id);
	}

	@PostMapping("/AddUser")
	public User addUser(@Valid @RequestBody User user) {
		return userService.registerUser(user);
	}

	@PutMapping("/UpdateUser")
	public User updateUser(@Valid @RequestBody User user) {
		return userService.updateUser(user);
	}

	@DeleteMapping("/DeleteUserById/{id}")
	public void removeUser(@PathVariable("id") int id) {
		userService.removeUser(id);
	}

	@GetMapping("/GetUserByRole/{role}")
	public List<User> getByRole(@PathVariable("role") String role) {
		return userService.getByRole(role);	
	}

	@GetMapping("/GetUserIdByEmail/{email}/{password}")
	public User getIdByMail(@PathVariable("email") String email, @PathVariable("password") String password) {
		return userService.fetchUserIdByEmailAndPassword(email, password);
	}

}
