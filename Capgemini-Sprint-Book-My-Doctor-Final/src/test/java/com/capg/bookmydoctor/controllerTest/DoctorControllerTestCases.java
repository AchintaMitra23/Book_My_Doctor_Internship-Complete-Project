package com.capg.bookmydoctor.controllerTest;


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

import com.capg.bookmydoctor.controllers.DoctorController;
import com.capg.bookmydoctor.entities.Doctor;
import com.capg.bookmydoctor.entities.User;
import com.capg.bookmydoctor.repositories.IDoctorRepository;
import com.capg.bookmydoctor.services.IDoctorService;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DoctorController.class)
class DoctorControllerTestCases {

	@Autowired 
	private MockMvc mvc;
	
	@MockBean
	private IDoctorService serv;
	
	@MockBean
	private IDoctorRepository repo;

	private Doctor doctor1, doctor2;
	private User user1, user2;
	
	@BeforeEach
	void setUp() throws Exception {
		user1 = new User(1, "MarkLouis", "mark@gmail.com", "Mark1234567", "Doctor", false);
		user2 = new User(2, "JacobSmith", "jacob@gmail.com", "Jacob1234567", "Doctor", false);
		doctor1 = new Doctor(1, "MarkLouis", "Neuro","KOL","xyz",9876543210L,1000, user1);
		doctor2 = new Doctor(2, "JacobSmith", "Chest","CHE","xyz1",9876543210L,1500, user2);
	}
	
	@Test
	public void getAllDoctorsTest() throws Exception {
		List<Doctor> docList = new ArrayList<Doctor>();
		docList.add(doctor1);
		docList.add(doctor2);
		
		Mockito.when(serv.getDoctorList()).thenReturn(docList);
		String url = "/GetAllDoctor";
		mvc.perform(get(url)).andExpect(status().isOk()).andReturn(); 
	}
	

	@Test
	void GetDoctorByIdTest() throws Exception {
		List<Doctor> list=new ArrayList<Doctor>();
		list.add(doctor1);
		list.add(doctor2);
		Mockito.when(serv.getDoctor(1)).thenReturn(doctor1);
		String url="/GetDoctorById/1";
		mvc.perform(get(url).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
		
	}

}
