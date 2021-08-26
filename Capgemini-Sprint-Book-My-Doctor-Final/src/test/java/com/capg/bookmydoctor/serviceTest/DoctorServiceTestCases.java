package com.capg.bookmydoctor.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
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

import com.capg.bookmydoctor.entities.AvailabilityDates;
import com.capg.bookmydoctor.entities.Doctor;
import com.capg.bookmydoctor.entities.User;
import com.capg.bookmydoctor.repositories.IAvailabilityRepository;
import com.capg.bookmydoctor.repositories.IDoctorRepository;
import com.capg.bookmydoctor.services.IDoctorService;

@SpringBootTest
class DoctorServiceTestCases {

	@MockBean
	private IDoctorRepository doctorRepo;
	
	@MockBean
	private IAvailabilityRepository availRepo;
	
	@Autowired
	private IDoctorService doctorService;
	
	private Doctor doctor1, doctor2;
	private User user1, user2;
	
	@BeforeEach
	public void setUp() throws Exception {
		user1 = new User(3, "AchintaMitra", "achinta@gmail.com", "Achinta12345678", "Doctor", false);
		user2 = new User(4, "NilanjanaBasu", "nilanjana@gmail.com", "Nilanjana12345678", "Doctor", false);
		doctor1 = new Doctor(1, "AchintaMitra", "Chest", "Maharastra", "D.Y.Patil", 9876543210L, 1000.00, user1);
		doctor2 = new Doctor(2, "NilanjanaBasu", "Heart", "Punjab", "AMRI", 1234567890L, 2000.00, user2);
	}
	
	@Test
	public void getAllDoctorTest() {
		List<Doctor> doctorList = new ArrayList<Doctor>();
		doctorList.add(doctor1);
		doctorList.add(doctor2);
		Mockito.when(doctorRepo.findAll()).thenReturn(doctorList);
		assertEquals(doctorList, doctorService.getDoctorList());
	}
	
	@Test
	@DisplayName("Get Doctor By Speciality Passed Case -> ")
	public void getDoctorBySpecialityTest1() {
		List<Doctor> doctorList = new ArrayList<Doctor>();
		doctorList.add(doctor1);
		Mockito.when(doctorRepo.findBySpecialityIgnoreCase("Chest")).thenReturn(doctorList);
		assertEquals(doctor1, doctorList.get(0));
	}
	
	@Test
	@DisplayName("Get Doctor By Speciality Failed Case -> ")
	public void getDoctorBySpecialityTest2() {
		List<Doctor> doctorList = new ArrayList<Doctor>();
		doctorList.add(doctor2);
		Mockito.when(doctorRepo.findBySpecialityIgnoreCase("Heart")).thenReturn(doctorList);
		assertEquals(doctor1, doctorList.get(0));
	}
	
	@Test
	@DisplayName("Get Doctor By ID Passed Case -> ")
	public void getDoctorByIdTest1() {
		List<Doctor> doctorList = new ArrayList<Doctor>();
		doctorList.add(doctor1);
		doctorList.add(doctor2);
		Mockito.when(doctorRepo.findById(1)).thenReturn(Optional.of(doctor1));
		assertEquals(doctor1, doctorService.getDoctor(1));
	}

	@Test
	@DisplayName("Get Doctor By ID Failed Case -> ")
	public void getDoctorByIdTest2() {
		List<Doctor> doctorList = new ArrayList<Doctor>();
		doctorList.add(doctor1);
		doctorList.add(doctor2);
		Mockito.when(doctorRepo.findById(2)).thenReturn(Optional.of(doctor2));
		assertEquals(doctor1, doctorService.getDoctor(2));
	}
	
	@Test
	@DisplayName("Add Availability Dates Passed Case -> ")
	public void addAvailabilityDatesTest1() {
		AvailabilityDates ad = new AvailabilityDates(1, doctor1, LocalDate.now(), LocalDate.now());
		Mockito.when(availRepo.save(ad)).thenReturn(ad);
		assertEquals(1, ad.getDoctorId().getDoctorId());
	}
	
	@Test
	@DisplayName("Add Availability Dates Failed Case -> ")
	public void addAvailabilityDatesTest2() {
		AvailabilityDates ad = new AvailabilityDates(1, doctor1, LocalDate.now(), LocalDate.now());
		Mockito.when(availRepo.save(ad)).thenReturn(ad);
		assertEquals(2, ad.getDoctorId().getDoctorId());
	}
	
	
	
	

}
