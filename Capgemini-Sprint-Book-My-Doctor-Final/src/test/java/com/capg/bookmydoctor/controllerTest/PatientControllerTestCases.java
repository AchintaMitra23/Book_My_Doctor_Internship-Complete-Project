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

import com.capg.bookmydoctor.controllers.PatientController;
import com.capg.bookmydoctor.entities.Patient;
import com.capg.bookmydoctor.entities.User;
import com.capg.bookmydoctor.repositories.IPatientRepository;
import com.capg.bookmydoctor.services.IPatientService;

@WebMvcTest(PatientController.class)
class PatientControllerTestCases {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private IPatientService patientService;
	
	@MockBean
	private IPatientRepository patientRepo;
	
	private Patient patient1, patient2;
	private User user1, user2;
	
	@BeforeEach
	void setUp() throws Exception {
		user1 = new User(1, "MarkLouis", "mark@gmail.com", "Mark1234567", "Patient", false);
		user2 = new User(2, "JacobSmith", "jacob@gmail.com", "Jacob1234567", "Patient", false);
		patient1=new Patient(1,"MarkLouis",9876567870L,"AB+","female",22,"kolkata", user1);
		patient2=new Patient(2,"jacobSmith",9876567870L,"AB-","male",22,"kolkata", user2);
	}
	
	@Test
	public void findAllPatienttest() throws Exception {
		List<Patient> patientList=new ArrayList<Patient>();
		patientList.add(patient1);
		patientList.add(patient2);
		Mockito.when(patientService.getAllPatient()).thenReturn(patientList);
		String url="/GetAllPatient";
		mvc.perform(get(url)).andExpect(status().isOk()).andReturn();
	}
	
	@Test
	public void findPatientByIdTest() throws Exception {
		List<Patient> patientList=new ArrayList<Patient>();
		patientList.add(patient1);
		patientList.add(patient2);
		Mockito.when(patientService.getPatient(1)).thenReturn(patient1);
		String url="/GetPatientByID/1";
		mvc.perform(get(url).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
	}
	

}

