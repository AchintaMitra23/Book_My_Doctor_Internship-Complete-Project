package com.capg.bookmydoctor.repositoryTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.capg.bookmydoctor.entities.User;
import com.capg.bookmydoctor.repositories.IUserRepository;

@DataJpaTest
class UserRepositoryTestCases {
	
	@Autowired 
	private IUserRepository userRepo;
	
	@Autowired
	private TestEntityManager entity;
	
	private User user1, user2;
	
	@BeforeEach
	public void setUp() throws Exception {
		 user1 = new User(1, "GoogleCompany", "google@gmail.com", "Google12345", "Doctor", false);
		 user2 = new User(2, "FacebookCompany", "facebook@gmail.com", "Facebook12345", "Patient", false);
		 entity.persist(user1);
		 entity.persist(user2);
	}
	
	@Test
	public void getAllUsersTest() {
		List<User> userList = new ArrayList<User>();
		userList.add(user1);
		userList.add(user2);
		List<User> resList = userRepo.findAll();
		assertEquals(userList, resList);
	}

	@Test
	@DisplayName("Get User By ID Passed Cases -> ")
	public void getByUserIdTest1() {
		User user = userRepo.findById(1).get(); 
		assertEquals(user1.getEmailID(), user.getEmailID());
	}
	
	@Test
	@DisplayName("Get User By ID Failed Cases -> ")
	public void getByUserIdTest2() {
		User user = userRepo.findById(2).get();
		assertEquals(user1.getEmailID(), user.getEmailID());
	}

	@Test
	@DisplayName("Get User By Role Passed Cases -> ")
	public void findByRoleTest1() {
		List<User> user = userRepo.findByRole("Doctor");
		assertEquals(user1.getPassword(), user.get(0).getPassword());
	}

	@Test
	@DisplayName("Get User By Role Failed Cases -> ")
	public void findByRoleTest2() {
		List<User> user = userRepo.findByRole("Patient");
		assertEquals(user1.getPassword(), user.get(0).getPassword());
	}

}
