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

import com.capg.bookmydoctor.entities.Doctor;
import com.capg.bookmydoctor.entities.Feedback;
import com.capg.bookmydoctor.entities.Patient;
import com.capg.bookmydoctor.entities.User;
import com.capg.bookmydoctor.repositories.IFeedbackRepository;
import com.capg.bookmydoctor.services.IFeedbackService;

@SpringBootTest
class FeedbackServiceTestCases {

	@MockBean
	private IFeedbackRepository feedRepo;
	
	@Autowired
	private IFeedbackService feedService;
	
	private Feedback feedback1, feedback2;
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
		
		feedback1 = new Feedback(5, 8, patient1, doctor1, "Good");
		feedback2 = new Feedback(6, 4, patient2, doctor2, "Bad"); 
	}
	
	@Test
	public void getAllFeedback() {
		List<Feedback> feedList = new ArrayList<Feedback>();
		feedList.add(feedback1);
		feedList.add(feedback2);
		Mockito.when(feedRepo.findAll()).thenReturn(feedList);
		assertEquals(feedList, feedService.getAllFeedback());
	}
	
	@Test
	@DisplayName("Get Feedback By ID Passed Case -> ")
	public void getFeedbackByIdTest1() {
		List<Feedback> appointList = new ArrayList<Feedback>();
		appointList.add(feedback1);
		appointList.add(feedback2);
		Mockito.when(feedRepo.findById(5)).thenReturn(Optional.of(feedback1));
		assertEquals(feedback1, feedService.getFeedback(5));
	}

	@Test
	@DisplayName("Get Feedback By ID Failed Case -> ")
	public void getFeedbackByIdTest2() {
		List<Feedback> appointList = new ArrayList<Feedback>();
		appointList.add(feedback1);
		appointList.add(feedback2);
		Mockito.when(feedRepo.findById(6)).thenReturn(Optional.of(feedback2));
		assertEquals(feedback1, feedService.getFeedback(6));
	}
	
	@Test
	@DisplayName("Add Feedbacks Passed Case -> ")
	public void addFeedbacksTest1() {
		Mockito.when(feedRepo.save(feedback1)).thenReturn(feedback1);
		assertEquals(feedback1, feedService.addFeedback(feedback1));
	}

	@Test
	@DisplayName("Add Feedbacks Failed Case -> ")
	public void addAppointmentsTest2() {
		Mockito.when(feedRepo.save(feedback2)).thenReturn(feedback2);
		assertEquals(feedback1, feedService.addFeedback(feedback2));
	}

}
