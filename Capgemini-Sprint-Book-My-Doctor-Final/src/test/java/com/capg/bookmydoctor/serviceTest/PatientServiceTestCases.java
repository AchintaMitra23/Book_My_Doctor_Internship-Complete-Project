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

import com.capg.bookmydoctor.entities.Patient;
import com.capg.bookmydoctor.entities.User;
import com.capg.bookmydoctor.repositories.IPatientRepository;
import com.capg.bookmydoctor.services.IPatientService;

@SpringBootTest
class PatientServiceTestCases {

	@Autowired
	private IPatientService patientService;
	
	@MockBean
	private IPatientRepository patientRepo; 
	
	private Patient patient1, patient2;
	private User user1, user2;
	
	@BeforeEach
	public void setUp() throws Exception {
		user1 = new User(3, "AchintaMitra", "achinta@gmail.com", "Achinta12345678", "Patient", false);
		user2 = new User(4, "NilanjanaBasu", "nilanjana@gmail.com", "Nilanjana12345678", "Patient", false);
		patient1 = new Patient(1, "AchintaMitra", 9090909090L, "A+", "female", 22, "Kolkata", user1);
		patient2 = new Patient(2, "NilanjanaBasu", 8080808080L, "B+", "male", 23, "Chennai", user2);
	}
	
	@Test
	public void getAllPatientTest() {
		List<Patient> patientList = new ArrayList<Patient>();
		patientList.add(patient1);
		patientList.add(patient2);
		Mockito.when(patientRepo.findAll()).thenReturn(patientList);
		assertEquals(patientList, patientService.getAllPatient());
	}
	
	@Test
	@DisplayName("Add Patient Passed Case -> ")
	public void addPatientTest1() {
		Mockito.when(patientRepo.save(patient1)).thenReturn(patient1);
		assertEquals(patient1, patientService.addPatient(patient1));
	}
	
	@Test
	@DisplayName("Add Patient Failed Case -> ")
	public void addPatientTest2() {
		Mockito.when(patientRepo.save(patient1)).thenReturn(patient1);
		assertEquals(patient2, patientService.addPatient(patient1));
	}
	
	@Test
	@DisplayName("Get Patient By ID Passed Case -> ")
	public void getPatientByIdTest1() {
		List<Patient> patientList = new ArrayList<Patient>();
		patientList.add(patient1);
		patientList.add(patient2);
		Mockito.when(patientRepo.findById(1)).thenReturn(Optional.of(patient1));
		assertEquals(patient1, patientService.getPatient(1));
	}

	@Test
	@DisplayName("Get Patient By ID Failed Case -> ")
	public void getPatientByIdTest2() {
		List<Patient> patientList = new ArrayList<Patient>();
		patientList.add(patient1);
		patientList.add(patient2);
		Mockito.when(patientRepo.findById(2)).thenReturn(Optional.of(patient2));
		assertEquals(patient1, patientService.getPatient(2));
	}

}
