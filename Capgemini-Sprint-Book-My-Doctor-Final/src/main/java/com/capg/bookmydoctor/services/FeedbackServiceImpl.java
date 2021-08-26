package com.capg.bookmydoctor.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.bookmydoctor.entities.Doctor;
import com.capg.bookmydoctor.entities.Feedback;
import com.capg.bookmydoctor.exceptions.FeedbackException;
import com.capg.bookmydoctor.repositories.IFeedbackRepository;

@Service
public class FeedbackServiceImpl implements IFeedbackService {

	@Autowired
	private IFeedbackRepository feedbackRepo;

	@Override
	public Feedback addFeedback(Feedback fdb) {
		return feedbackRepo.save(fdb);
	}

	@Override
	public Feedback getFeedback(int id) {
		Optional<Feedback> list =  feedbackRepo.findById(id);
		if (list.isEmpty()) {
			throw new FeedbackException("Feedback Not Found");
		}
		return list.get();
	}

	@Override
	public List<Feedback> getAllFeedback() {
		return feedbackRepo.findAll();
	}

	@Override
	public void removeFeedback(int id) {
		if (feedbackRepo.findById(id) != null)
			feedbackRepo.deleteById(id);
		else 
			throw new FeedbackException("Feedback Not Found");
	}

	@Override
	public List<Feedback> getFeedbackByPatient(int pid) {
		List<Feedback> list = feedbackRepo.findAll();
		List<Feedback> temp = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getPatientId().getPatientId() == pid) {
				temp.add(list.get(i));
			}
		}
		if (temp.isEmpty()) throw new FeedbackException("Feedback not found with patient id : " + pid);
		else 				return temp;
	}

	@Override
	public List<Feedback> getFeedbackByDoctor(int did) {
		List<Feedback> list = feedbackRepo.findAll();
		List<Feedback> temp = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getDoctorId().getDoctorId() == did) {
				temp.add(list.get(i));
			}
		}
		if (temp.isEmpty()) throw new FeedbackException("Feedback not found with doctor id : " + did);
		else 				return temp;
	}

	@Override
	public List<Doctor> getDoctorByRating(int rating) {
		List<Feedback> list = feedbackRepo.findAll();
		List<Feedback> temp = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getRating() == rating) {
				temp.add(list.get(i));
			}
		}

		List<Doctor> doctorList = new ArrayList<>();
		for (Feedback i : temp) doctorList.add(i.getDoctorId());


		if (temp.isEmpty()) throw new FeedbackException("Feedback not found with rating : " + rating);
		else 				return doctorList;
	}
}