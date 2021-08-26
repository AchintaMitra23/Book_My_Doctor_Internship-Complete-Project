package com.capg.bookmydoctor.services;

import java.util.List;

import com.capg.bookmydoctor.entities.Appointment;

public interface IAppointmentService {

	public Appointment addAppointment(Appointment appointment); 
	public List<Appointment> getAllAppointments(); 
	public Appointment getAppointment(int id); 
	public void deleteAppointment(int id); 
	public Appointment updateAppointment(Appointment bean); 
	public List<Appointment> getAppointmentsByDoctor(int doctorId);  
	public List<Appointment> getAppointmentsByPatient(int patientId); 
	public List<Appointment> getAppointmentsByDate(String date); 
	public List<Appointment> getAppointmentsByStatus(String status);
	public List<Appointment> getAppointmentsByRemarks(String remark);
	public List<Appointment> getPatientsHistory(int doctorId);
	public List<Appointment> getLatestAppointments(int doctorId);
	
}
