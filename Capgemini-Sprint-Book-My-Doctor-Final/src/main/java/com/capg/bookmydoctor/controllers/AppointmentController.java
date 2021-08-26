package com.capg.bookmydoctor.controllers;

/*****************************************************************
 *         @author          Soumita Deb
 *         Description      It is an controller class for Appointment
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.bookmydoctor.entities.Appointment;
import com.capg.bookmydoctor.services.IAppointmentService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController	
@RequestMapping("/api/appointment")
public class AppointmentController {

	@Autowired 
	private IAppointmentService appointmentService; 

	@PostMapping("/AddAppointment")
	public Appointment saveAppointment(@Valid @RequestBody Appointment appointment) {
		return appointmentService.addAppointment(appointment);
	}

	@GetMapping("/GetAllAppointment")
	public List<Appointment> findAllAppointments() {
		return appointmentService.getAllAppointments();
	}

	@GetMapping("/GetAppointmentByID/{id}")
	public Appointment findPatientById1(@PathVariable("id") int id) {
		return appointmentService.getAppointment(id);
	}

	@DeleteMapping("/DeleteAppointmentById/{id}") 
	public void removeAppointmentById(@PathVariable("id") int id) {
		appointmentService.deleteAppointment(id);
	}

	@PutMapping("/UpdateAppointment") 
	public Appointment updateAppointment(@Valid @RequestBody Appointment appointment) {
		return appointmentService.updateAppointment(appointment);
	}

	@GetMapping("/GetAppointmentsByDoctor/{id}")
	public List<Appointment> findAppointsByDoctor(@PathVariable("id") int id) {
		return appointmentService.getAppointmentsByDoctor(id);
	}

	@GetMapping("/GetAppointmentsByPatient/{id}")
	public List<Appointment> findAppointsByPatient(@PathVariable("id") int id) {
		return appointmentService.getAppointmentsByPatient(id);
	}

	@GetMapping("/GetAppointmentsByDate/{date}")
	public List<Appointment> findAppointsByDate(@PathVariable("date") String date) {
		return appointmentService.getAppointmentsByDate(date);
	}
	
	@GetMapping("/GetAppointmentsByStatus/{status}")
	public List<Appointment> findAppointsByStatus(@PathVariable("status") String status) {
		return appointmentService.getAppointmentsByStatus(status);
	}
	
	@GetMapping("/GetAppointmentsByRemark/{remark}")
	public List<Appointment> findAppointsByRemark(@PathVariable("remark") String remark) {
		return appointmentService.getAppointmentsByRemarks(remark);
	}
	
	@GetMapping("/viewPatientsHistory/{id}")
	public List<Appointment> viewPatientsHistory(@PathVariable("id") int id) {
		return appointmentService.getPatientsHistory(id);
	}
	@GetMapping("/GetLatestAppointments/{id}")
	public List<Appointment> findLatestAppointments(@PathVariable("id") int id) {
		return appointmentService.getLatestAppointments(id);
	}
}
