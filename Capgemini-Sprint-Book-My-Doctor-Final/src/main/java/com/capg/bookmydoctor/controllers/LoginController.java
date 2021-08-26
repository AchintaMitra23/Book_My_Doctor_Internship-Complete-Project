package com.capg.bookmydoctor.controllers;

/*****************************************************************
 *         @author          Achinta Mitra
 *         Description      It is an controller class for Login
 *                          @RestController 
 *         Version          1.0
 *         Created On       27-July-2021
 ******************************************************************/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.bookmydoctor.entities.User;
import com.capg.bookmydoctor.services.IUserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController	
@RequestMapping("/api/login")
public class LoginController {

	@Autowired
	private IUserService userService;

	@GetMapping("/loginUser/{email}/{password}")
	public User logedinUser(@PathVariable("email") String email, @PathVariable("password") String password) {
		if (userService.loginUser(email, password) == null) {
			return null;
		} else {
			return userService.loginUser(email, password);
		}
	}

	@GetMapping("/logoutUser/{id}")
	public boolean logedoutUser(@PathVariable("id") int id) {
		return userService.logoutUser(id);
	}

	@GetMapping("/isLoggedIn/{id}")
	public boolean isLoggedIn(@PathVariable("id") int id) {
		return userService.isLogedIn(id);
	}

	@PutMapping("/forgotPassword/{email}/{newPass}/{confirmPass}")
	public User updatePassword(@PathVariable("email") String email, @PathVariable("newPass") String newPassword, @PathVariable("confirmPass") String confirm) {
		return userService.updatePassword(email, newPassword, confirm);
	}
}
