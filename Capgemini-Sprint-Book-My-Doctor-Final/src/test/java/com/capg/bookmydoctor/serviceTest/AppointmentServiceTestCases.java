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

import com.capg.bookmydoctor.entities.Appointment;
import com.capg.bookmydoctor.entities.Doctor;
import com.capg.bookmydoctor.entities.Patient;
import com.capg.bookmydoctor.entities.User;
import com.capg.bookmydoctor.repositories.IAppointmentRepository;
import com.capg.bookmydoctor.services.IAppointmentService;

@SpringBootTest
class AppointmentServiceTestCases {
	
	@MockBean
	private IAppointmentRepository appointRepo;
	
	@Autowired
	private IAppointmentService appointService;
	
	private Appointment appointment1, appointment2;
	private Patient patient1, patient2;
	private Doctor doctor1, doctor2;
	private User user1, user2, user3, user4;
	
	@BeforeEach
	public void setUp() throws Exception {
		
		user1 = new User(5, "AchintaMitra", "achinta@gmail.com", "Achinta12345678", "Patient", false);
		user2 = new User(6, "NilanjanaBasu", "nilanjana@gmail.com", "Nilanjana12345678", "Patient", false);
		user3 = new User(7, "AchintaMitra123", "achinta@gmail.com", "Achinta12345678", "Doctor", false);
		user4 = new User(8, "NilanjanaBasu123", "nilanjana@gmail.com", "Nilanjana12345678", "Doctor", false);
		
		patient1 = new Patient(1, "Achinta", 9090909090L, "A+", "male", 22, "Kolkata", user1);
		patient2 = new Patient(2, "Naina", 8080808080L, "B+", "female", 21, "Delhi", user2);
		
		doctor1 = new Doctor(3, "Megha", "Chest", "Bangalore", "AMRI", 8080808080L, 1000, user3);
		doctor2 = new Doctor(4, "Aniket", "Kidney", "Pune", "CMC", 9090909090L, 2000, user4);
		
		appointment1 = new Appointment(5, patient1, doctor1, LocalDate.parse("2021-12-15"), "Done And Checked", "Good");
		appointment2 = new Appointment(6, patient2, doctor2, LocalDate.parse("2021-12-15"), "Done And Not Checked", "Bad"); 
	}
	
	@Test
	public void getAllAppointments() {
		List<Appointment> appointList = new ArrayList<Appointment>();
		appointList.add(appointment1);
		appointList.add(appointment2);
		Mockito.when(appointRepo.findAll()).thenReturn(appointList);
		assertEquals(appointList, appointService.getAllAppointments());
	}
	
	@Test
	@DisplayName("Get Appointments By ID Passed Case -> ")
	public void getAppointmentsByIdTest1() {
		List<Appointment> appointList = new ArrayList<Appointment>();
		appointList.add(appointment1);
		appointList.add(appointment2);
		Mockito.when(appointRepo.findById(5)).thenReturn(Optional.of(appointment1));
		assertEquals(appointment1, appointService.getAppointment(5));
	}

	@Test
	@DisplayName("Get Appointments By ID Failed Case -> ")
	public void getAppointmentsByIdTest2() {
		List<Appointment> appointList = new ArrayList<Appointment>();
		appointList.add(appointment1);
		appointList.add(appointment2);
		Mockito.when(appointRepo.findById(6)).thenReturn(Optional.of(appointment2));
		assertEquals(appointment1, appointService.getAppointment(6));
	}
	
	@Test
	@DisplayName("Add Appointments Passed Case -> ")
	public void addAppointmentsTest1() {
		Mockito.when(appointRepo.save(appointment1)).thenReturn(appointment1);
		assertEquals(appointment1, appointService.addAppointment(appointment1));
	}

	@Test
	@DisplayName("Add Appointments Failed Case -> ")
	public void addAppointmentsTest2() {
		Mockito.when(appointRepo.save(appointment2)).thenReturn(appointment2);
		assertEquals(appointment1, appointService.addAppointment(appointment2));
	}

}
