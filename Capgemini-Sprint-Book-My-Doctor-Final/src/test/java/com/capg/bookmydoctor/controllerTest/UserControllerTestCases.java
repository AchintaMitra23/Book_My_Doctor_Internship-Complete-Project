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

import com.capg.bookmydoctor.controllers.UserController;
import com.capg.bookmydoctor.entities.User;
import com.capg.bookmydoctor.repositories.IUserRepository;
import com.capg.bookmydoctor.services.IUserService;

@WebMvcTest(UserController.class)
class UserControllerTestCases {
	
	@Autowired 
	private MockMvc mvc;
	
	@MockBean
	private IUserService userService;	
	
	@MockBean
	private IUserRepository userRepo;
	
	private User user1, user2;

	@BeforeEach
	void setUp() throws Exception {
		user1 = new User(1, "MarkLouis", "mark@gmail.com", "Mark1234567", "Admin", false);
		user2 = new User(2, "JacobSmith", "jacob@gmail.com", "Jacob1234567", "Doctor", false);
	}

	@Test
	public void getAllUsersTest() throws Exception {
		List<User> userList = new ArrayList<User>();
		userList.add(user1);
		userList.add(user2);
		
		Mockito.when(userService.getAll()).thenReturn(userList);
		String url = "/GetAllUser";
		mvc.perform(get(url)).andExpect(status().isOk()).andReturn(); 
	}
	
	@Test
	public void getUserByIdTest() throws Exception {
		List<User> userList = new ArrayList<User>();
		userList.add(user1);
		userList.add(user2);
		Mockito.when(userService.fetchById(1)).thenReturn(user1);
		String url = "/GetUserById/1";
		mvc.perform(get(url).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
	}

}
