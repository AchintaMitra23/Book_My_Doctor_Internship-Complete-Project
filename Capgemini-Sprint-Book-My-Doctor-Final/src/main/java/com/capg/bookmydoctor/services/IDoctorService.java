package com.capg.bookmydoctor.services;

import java.util.List;

import com.capg.bookmydoctor.entities.AvailabilityDates;
import com.capg.bookmydoctor.entities.Doctor;

public interface IDoctorService {

	public Doctor addDoctor(Doctor bean); 
	public Doctor updateDoctorProfile(Doctor doctor); 
	public AvailabilityDates addAvailability(AvailabilityDates bean); 
	public List<AvailabilityDates> showAvailability(); 
	public AvailabilityDates updateAvailability(AvailabilityDates bean); 
	public void removeAvailability(int id); 
	public Doctor getDoctor(int id); 
	public void removeDoctor(int id); 
	public List<Doctor> getDoctorList(); 
	public List<Doctor> getDoctorBySpeciality(String speciality); 
	public List<Doctor> getDoctorByLocation(String location); 
	public List<Doctor> getDoctorByHospitalName(String hospital); 
	public List<Doctor> getDoctorByName(String name);
	public List<Doctor> getDoctorWithInBudget(double min, double max);
	public int getDoctorIdByUserId(int id); 
}
