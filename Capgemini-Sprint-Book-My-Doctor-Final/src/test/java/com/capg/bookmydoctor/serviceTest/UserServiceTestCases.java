package com.capg.bookmydoctor.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.capg.bookmydoctor.entities.User;
import com.capg.bookmydoctor.repositories.IUserRepository;
import com.capg.bookmydoctor.services.IUserService;

@SpringBootTest
class UserServiceTestCases {
	
	@Autowired
	private IUserService userService;
	
	@MockBean
	private IUserRepository userRepo;
	
	private User user1, user2, user3, user4;
	
	@BeforeEach
	public void setUp() throws Exception {
		user1 = new User(1, "GoogleCompany", "google@gmail.com", "Google12345", "Doctor", false);
		user2 = new User(2, "AppleCompany", "apple@gmail.com", "Apple12345", "Patient", true);
		user3 = new User(3, "FacebookCompany", "facebook@gmail.com", "Facebook12345", "Admin", false);
		user4 = new User(4, "Oracle", "oracle@gmail.com", "oracle", "Admin", false);
	}
	
	@Test
	public void getAllUserTest() {
		List<User> userList = new ArrayList<>();
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		userList.add(user4);
		Mockito.when(userRepo.findAll()).thenReturn(userList);
		assertEquals(userList, userService.getAll());
	}
	
	@Test
	@DisplayName("Add User Passed Case -> ")
	public void addUserTest1() {
		Mockito.when(userRepo.save(user1)).thenReturn(user1);
		assertEquals(user1, userService.registerUser(user1));
	}

	@Test
	@DisplayName("Add User Failed Case -> ")
	public void addUserTest2() {
		Mockito.when(userRepo.save(user2)).thenReturn(user2);
		assertEquals(user1, userService.registerUser(user2));
	}
	
	@Test
	@DisplayName("Get User By Id Passed Case -> ")
	public void getUserByIdTest1() {
		List<User> userList = new ArrayList<User>();
		userList.add(user1);
		userList.add(user2);
		Mockito.when(userRepo.findById(1)).thenReturn(Optional.of(user1));
		assertEquals(user1, userService.fetchById(1));
	}
	
	@Test
	@DisplayName("Get User By Id Failed Case -> ")
	public void getUserByIdTest2() {
		List<User> userList = new ArrayList<User>();
		userList.add(user1);
		userList.add(user2);
		Mockito.when(userRepo.findById(2)).thenReturn(Optional.of(user2));
		assertEquals(user1, userService.fetchById(2));
	}
	
	@Test
	@DisplayName("Validation Error Case -> ")
	public void validateUserTest1() {
		Mockito.when(userRepo.save(user4)).thenReturn(user4);
		assertEquals(user4, userService.registerUser(user4));
	}
	
	@Test
	@DisplayName("Validation Passed Case -> ")
	public void validateUserTest2() {
		Mockito.when(userRepo.save(user3)).thenReturn(user3);
		assertEquals(user3, userService.registerUser(user3));
	}
	
	
	
}
