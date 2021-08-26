package com.capg.bookmydoctor.services;

import java.util.List;

import com.capg.bookmydoctor.entities.Doctor;
import com.capg.bookmydoctor.entities.Feedback;

public interface IFeedbackService {

	public Feedback addFeedback(Feedback fdb); 
	public Feedback getFeedback(int id);
	public void removeFeedback(int id); 
	public List<Feedback> getFeedbackByPatient(int pid);
	public List<Feedback> getFeedbackByDoctor(int did); 
	public List<Feedback> getAllFeedback(); 
	public List<Doctor> getDoctorByRating(int rating);
}
