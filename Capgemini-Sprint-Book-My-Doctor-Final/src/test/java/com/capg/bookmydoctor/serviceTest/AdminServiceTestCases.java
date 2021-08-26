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

import com.capg.bookmydoctor.entities.Admin;
import com.capg.bookmydoctor.entities.User;
import com.capg.bookmydoctor.repositories.IAdminRepository;
import com.capg.bookmydoctor.services.IAdminService;


@SpringBootTest
class AdminServiceTestCases {
	
	@MockBean
	private IAdminRepository adminRepo;
	
	@Autowired
	private IAdminService adminService;
	
	private Admin admin1, admin2;
	private User user1, user2;
	
	@BeforeEach
	void setUp() throws Exception {
		user1 = new User(3, "AchintaMitra", "achinta@gmail.com", "Achinta12345678", "Admin", false);
		user2 = new User(4, "NilanjanaBasu", "nilanjana@gmail.com", "Nilanjana12345678", "Admin", false);
		admin1 = new Admin(1, "AchintaMitra", 9090909090L, user1);
		admin2 = new Admin(2, "NilanjanaBasu", 8080808080L, user2);
	}

	@Test
	@DisplayName("Add Admin Passed Case -> ")
	public void addAdminTest1(){
		Mockito.when(adminRepo.save(admin1)).thenReturn(admin1);
		assertEquals(admin1, adminService.addAdmin(admin1));
	}
	
	@Test
	@DisplayName("Add Admin Failed Case -> ")
	public void addAdminTest2(){
		Mockito.when(adminRepo.save(admin2)).thenReturn(admin2);
		assertEquals(admin1, adminService.addAdmin(admin2));
	}
	
	@Test
	@DisplayName("View Admin By Id Passed Case -> ")
	public void viewAdminByIdTest1() {
		List<Admin> adminList = new ArrayList<Admin>();
		adminList.add(admin1);
		adminList.add(admin2);
		Mockito.when(adminRepo.findById(1)).thenReturn(Optional.of(admin1));
		assertEquals(admin1, adminService.viewAdmin(1));
	}

	@Test
	@DisplayName("View Admin By Id Failed Case -> ")
	public void viewAdminByIdTest2() {
		List<Admin> adminList = new ArrayList<Admin>();
		adminList.add(admin1);
		adminList.add(admin2);
		Mockito.when(adminRepo.findById(2)).thenReturn(Optional.of(admin2));
		assertEquals(admin1, adminService.viewAdmin(2));
	}

	@Test
	@DisplayName("Get Admin By Name Passed Case -> ")
	public void getAdminByNameTest1() {
		List<Admin> adminList = new ArrayList<Admin>();
		adminList.add(admin1);
		Mockito.when(adminRepo.findByAdminName("Google")).thenReturn(adminList);
		assertEquals(admin1, adminList.get(0));
	}

	@Test
	@DisplayName("Get Admin By Name Failed Case -> ")
	public void getAdminByNameTest2() {
		List<Admin> adminList = new ArrayList<Admin>();
		adminList.add(admin2);
		Mockito.when(adminRepo.findByAdminName("Apple")).thenReturn(adminList);
		assertEquals(admin1, adminList.get(0));
	}
}


