package com.capg.bookmydoctor.services;

import java.util.List;

import com.capg.bookmydoctor.entities.Patient;

public interface IPatientService {
	
	public Patient addPatient(Patient patient); 
	public Patient editPatientProfile(Patient patient); 
	public void removePatientDetails(int id); 
	public Patient getPatient(int id); 
	public List<Patient> getAllPatient(); 
	public List<Patient> getPatientByName(String name); 
	public List<Patient> getPatientByGender(String gender); 
	public List<Patient> getPatientByBloodGroup(String bg); 
	public List<Patient> getPatientByAgeRange(int min, int max); 
	public int getPatientIdByUserId(int id); 
	
}
