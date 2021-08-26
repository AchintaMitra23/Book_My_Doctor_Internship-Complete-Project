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

import com.capg.bookmydoctor.entities.Patient;
import com.capg.bookmydoctor.entities.User;
import com.capg.bookmydoctor.repositories.IPatientRepository;

@DataJpaTest
class PatientRepositoryTestCases {

	@Autowired 
	private IPatientRepository patientRepo;
	
	@Autowired
	private TestEntityManager entity;
	
	private Patient patient1, patient2;
	private User user1, user2;
	
	@BeforeEach
	public void setUp() throws Exception {
		user1 = new User(3, "AchintaMitra", "achinta@gmail.com", "Achinta12345678", "Patient", false);
		user2 = new User(4, "NilanjanaBasu", "nilanjana@gmail.com", "Nilanjana12345678", "Patient", false);
		patient1 = new Patient(1, "AchintaMitra", 9090909090L, "A+", "Male", 49, "India", user1);
		patient2 = new Patient(2, "NilanjanaBasu", 8080808080L, "B+", "Female", 71, "London", user2);
		entity.persist(user1);
		entity.persist(user2);
		entity.persist(patient1);
		entity.persist(patient2);
	}
	
	@Test
	public void getAllPatientsTest() {
		List<Patient> patientList = new ArrayList<Patient>();
		patientList.add(patient1);
		patientList.add(patient2);
		List<Patient> resList = patientRepo.findAll();
		assertEquals(patientList, resList);
	}
	
	@Test
	@DisplayName("Get Patient By ID Passed Cases -> ")
	public void getByPatientIdTest1() {
		Patient patient = patientRepo.findById(1).get(); 
		assertEquals(patient1.getAge(), patient.getAge());
	}
	
	@Test
	@DisplayName("Get Patient By ID Failed Cases -> ")
	public void getByPatientIdTest2() {
		Patient patient = patientRepo.findById(2).get();
		assertEquals(patient1.getAge(), patient.getAge());
	}
	
	@Test
	@DisplayName("Get Patient By Name Passed Cases -> ")
	public void getByPatientNameTest1() {
		List<Patient> patientList = patientRepo.findByPatientName("AchintaMitra");
		assertEquals(patient1.getAddress(), patientList.get(0).getAddress());
	}

	@Test
	@DisplayName("Get Patient By Name Failed Cases -> ")
	public void getByPatientNameTest2() {
		List<Patient> patientList = patientRepo.findByPatientName("NilanjanaBasu");
		assertEquals(patient1.getAddress(), patientList.get(0).getAddress());
	}
	
	@Test
	@DisplayName("Get Patient By Gender Passed Cases -> ")
	public void getByPatientGenderTest1() {
		List<Patient> patientList = patientRepo.findByGenderIgnoreCase("Male");
		assertEquals(patient1.getAddress(), patientList.get(0).getAddress());
	}

	@Test
	@DisplayName("Get Patient By Gender Failed Cases -> ")
	public void getByPatientGenderTest2() {
		List<Patient> patientList = patientRepo.findByGenderIgnoreCase("Female");
		assertEquals(patient1.getAddress(), patientList.get(0).getAddress());
	}
	
	@Test
	@DisplayName("Get Patient By BG Passed Cases -> ")
	public void getByPatientBGTest1() {
		List<Patient> patientList = patientRepo.findByBloodGroupIgnoreCase("A+");
		assertEquals(patient1.getAddress(), patientList.get(0).getAddress());
	}

	@Test
	@DisplayName("Get Patient By BG Failed Cases -> ")
	public void getByPatientBGTest2() {
		List<Patient> patientList = patientRepo.findByBloodGroupIgnoreCase("B+");
		assertEquals(patient1.getAddress(), patientList.get(0).getAddress());
	}
}
