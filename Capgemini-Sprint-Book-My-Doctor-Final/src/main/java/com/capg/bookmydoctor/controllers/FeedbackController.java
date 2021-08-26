package com.capg.bookmydoctor.controllers;

/*****************************************************************
 *         @author          Ananya Sircar
 *         Description      It is an controller class for Feedback
 *                          @RestController 
 *         Version          1.0
 *         Created On       27-July-2021
 ******************************************************************/

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.bookmydoctor.entities.Doctor;
import com.capg.bookmydoctor.entities.Feedback;
import com.capg.bookmydoctor.services.IFeedbackService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController	
@RequestMapping("/api/feedback")
public class FeedbackController {

	@Autowired 
	private IFeedbackService feedService;

	@PostMapping("/AddFeedback") 
	public Feedback saveFeedback(@Valid @RequestBody Feedback feedback) {
		return feedService.addFeedback(feedback);
	}

	@GetMapping("/GetFeedbackById/{id}") 
	public Feedback findFeedbackById(@PathVariable("id") int id) {
		return feedService.getFeedback(id);
	}

	@GetMapping("/GetAllFeedback") 
	public List<Feedback> findAllFeedback() {
		return feedService.getAllFeedback();
	}

	@DeleteMapping("/RemoveFeedback/{id}")
	public void removeFeed(@PathVariable("id") int id) {
		feedService.removeFeedback(id);
	}

	@GetMapping("/GetFeedBackByDoctor/{id}")
	public List<Feedback> getByDoctor(@PathVariable("id") int did) {
		return feedService.getFeedbackByDoctor(did);
	}

	@GetMapping("/GetFeedBackByPatient/{id}")
	public List<Feedback> getByPatient(@PathVariable("id") int pid) {
		return feedService.getFeedbackByPatient(pid);
	}

	@GetMapping("/GetFeedBackByRating/{rating}")
	public List<Doctor> getByRating(@PathVariable("rating") int rating) {
		return feedService.getDoctorByRating(rating);
	}
}
