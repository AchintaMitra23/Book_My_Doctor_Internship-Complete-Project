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

import com.capg.bookmydoctor.entities.Admin;
import com.capg.bookmydoctor.entities.User;
import com.capg.bookmydoctor.repositories.IAdminRepository;

@DataJpaTest
class AdminRepositoryTestCases {
	
	@Autowired 
	private IAdminRepository adminRepo;
	
	@Autowired
	private TestEntityManager entity;
	
	private Admin admin1, admin2;
	private User user1, user2;

	@BeforeEach
	public void setUp() throws Exception {
		user1 = new User(3, "AchintaMitra", "achinta@gmail.com", "Achinta12345678", "Admin", false);
		user2 = new User(4, "NilanjanaBasu", "nilanjana@gmail.com", "Nilanjana12345678", "Admin", false);
		admin1 = new Admin(1, "AchintaMitra", 9090909090L, user1);
		admin2 = new Admin(2, "NilanjanaBasu", 8080808080L, user2);
		entity.persist(user1);
		entity.persist(user2);
		entity.persist(admin1);
		entity.persist(admin2);
	}
	
	@Test
	public void getAllAdminsTest() {
		List<Admin> adminList = new ArrayList<Admin>();
		adminList.add(admin1);
		adminList.add(admin2);
		List<Admin> resList = adminRepo.findAll();
		assertEquals(adminList, resList);
	}
	
	@Test
	@DisplayName("Get Admin By ID Passed Cases -> ")
	public void getAdminByIdTest1() {
		Admin admin = adminRepo.findById(1).get();
		assertEquals(admin1.getContactNumber(), admin.getContactNumber());
	}

	@Test
	@DisplayName("Get Admin By ID Failed Cases -> ")
	public void getAdminByIdTest2() {
		Admin admin = adminRepo.findById(2).get();
		assertEquals(admin1.getContactNumber(), admin.getContactNumber());
	}
	
	@Test
	@DisplayName("Get Admin By Name Passed Cases -> ")
	public void getAdminByNameTest1() {
		List<Admin> adminList = adminRepo.findByAdminName("AchintaMitra");
		assertEquals(admin1.getContactNumber(), adminList.get(0).getContactNumber());
	}

	@Test
	@DisplayName("Get Admin By Name Failed Cases -> ")
	public void getAdminByNameTest2() {
		List<Admin> adminList = adminRepo.findByAdminName("NilanjanaBasu");
		assertEquals(admin1.getContactNumber(), adminList.get(0).getContactNumber());
	}
}
