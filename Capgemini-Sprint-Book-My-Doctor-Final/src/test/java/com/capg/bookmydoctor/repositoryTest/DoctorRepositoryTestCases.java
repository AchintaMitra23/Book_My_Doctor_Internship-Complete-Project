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

import com.capg.bookmydoctor.entities.Doctor;
import com.capg.bookmydoctor.entities.User;
import com.capg.bookmydoctor.repositories.IDoctorRepository;

@DataJpaTest
class DoctorRepositoryTestCases {

	@Autowired
	private IDoctorRepository doctorRepo;
	
	@Autowired
	private TestEntityManager entity;
	
	private Doctor doctor1, doctor2;
	private User user1, user2;
	
	@BeforeEach
	public void setUp() throws Exception {
		user1 = new User(3, "AchintaMitra", "achinta@gmail.com", "Achinta12345678", "Doctor", false);
		user2 = new User(4, "NilanjanaBasu", "nilanjana@gmail.com", "Nilanjana12345678", "Doctor", false);
		doctor1 = new Doctor(1, "AchintaMitra", "Chest", "Kolkata", "D.Y.Patil", 9876543210L, 1000.00, user1);
		doctor2 = new Doctor(2, "NilanjanaBasu", "Heart", "Chennai", "CMC", 9876543210L, 2000.00, user2);
		entity.persist(user1);
		entity.persist(user2);
		entity.persist(doctor1);
		entity.persist(doctor2);
	}
	
	@Test
	public void findAllDoctorsTest() {
		List<Doctor> doctorList = new ArrayList<Doctor>();
		doctorList.add(doctor1);
		doctorList.add(doctor2);
		List<Doctor> resList = doctorRepo.findAll();
		assertEquals(doctorList, resList);
	}
	
	@Test
	@DisplayName("Find By Doctor Id Passed Cases -> ")
	public void findByDoctorIdTest1() {
		Doctor doctor = doctorRepo.findById(1).get();
		assertEquals(doctor1.getDoctorName(), doctor.getDoctorName());
	}
	
	@Test
	@DisplayName("Find By Doctor Id Failed Cases -> ")
	public void findByDoctorIdTest2() {
		Doctor doctor = doctorRepo.findById(2).get();
		assertEquals(doctor1.getDoctorName(), doctor.getDoctorName());
	}
	
	@Test
	@DisplayName("Find By Doctor Name Passed Cases -> ")
	public void findByDoctorNameTest1() {
		List<Doctor> doctorList = doctorRepo.findByDoctorName("AchintaMitra");
		assertEquals(doctor1.getHospitalName(), doctorList.get(0).getHospitalName());
	}
	
	@Test
	@DisplayName("Find By Doctor Name Failed Cases -> ")
	public void findByDoctorNameTest2() {
		List<Doctor> doctorList = doctorRepo.findByDoctorName("NilanjanaBasu");
		assertEquals(doctor1.getHospitalName(), doctorList.get(0).getHospitalName());
	}
	
	@Test
	@DisplayName("Find By Speciality Passed Cases -> ")
	public void findBySpecialityIgnoreCaseTest1() {
		List<Doctor> doctorList = doctorRepo.findBySpecialityIgnoreCase("Chest");
		assertEquals(doctor1.getLocation(), doctorList.get(0).getLocation());
	}

	@Test
	@DisplayName("Find By Speciality Failed Cases -> ")
	public void findBySpecialityIgnoreCaseTest2() {
		List<Doctor> doctorList = doctorRepo.findBySpecialityIgnoreCase("Heart");
		assertEquals(doctor1.getLocation(), doctorList.get(0).getLocation());
	}
	
	@Test
	@DisplayName("Find By Location Passed Cases -> ")
	public void findByLocationIgnoreCaseTest1() {
		List<Doctor> doctorList = doctorRepo.findByLocationIgnoreCase("Kolkata");
		assertEquals(doctor1.getDoctorName(), doctorList.get(0).getDoctorName());
	}

	@Test
	@DisplayName("Find By Location Failed Cases -> ")
	public void findByLocationIgnoreCaseTest2() {
		List<Doctor> doctorList = doctorRepo.findByLocationIgnoreCase("Chennai");
		assertEquals(doctor1.getDoctorName(), doctorList.get(0).getDoctorName());
	}
	
	@Test
	@DisplayName("Find By Hospital Passed Cases -> ")
	public void findByHospitalIgnoreCaseTest1() {
		List<Doctor> doctorList = doctorRepo.findByHospitalNameIgnoreCase("D.Y.Patil");
		assertEquals(doctor1.getDoctorName(), doctorList.get(0).getDoctorName());
	}

	@Test
	@DisplayName("Find By Hospital Failed Cases -> ")
	public void findByHospitalIgnoreCaseTest2() {
		List<Doctor> doctorList = doctorRepo.findByHospitalNameIgnoreCase("CMC");
		assertEquals(doctor1.getDoctorName(), doctorList.get(0).getDoctorName());
	}

}
