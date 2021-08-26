package com.capg.bookmydoctor.controllerTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.capg.bookmydoctor.controllers.AdminController;
import com.capg.bookmydoctor.entities.Admin;
import com.capg.bookmydoctor.entities.User;
import com.capg.bookmydoctor.repositories.IAdminRepository;
import com.capg.bookmydoctor.services.IAdminService;

@WebMvcTest(AdminController.class)
class AdminControllerTestCases {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private IAdminService adminService;
	
	@MockBean
	private IAdminRepository adminRepo;
	
	private Admin admin1, admin2;
	private User user1, user2;
	
	@BeforeEach
	void setUp() throws Exception {
		user1 = new User(1, "MarkLouis", "mark@gmail.com", "Mark1234567", "Admin", false);
		user2 = new User(2, "JacobSmith", "jacob@gmail.com", "Jacob1234567", "Admin", false);
		admin1 = new Admin(1, "MarkLouis", 9876567870L, user1);
		admin2 = new Admin(2, "JacobSmith", 9876567870L, user2);
	} 
	
	@Test
	public void findAdminByIdTest() throws Exception {
		List<Admin> adminList = new ArrayList<Admin>();
		adminList.add(admin1);
		adminList.add(admin2);
		Mockito.when(adminService.viewAdmin(1)).thenReturn(admin1);
		String url="/GetAdminById/1";
		mvc.perform(get(url).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
	}

}
