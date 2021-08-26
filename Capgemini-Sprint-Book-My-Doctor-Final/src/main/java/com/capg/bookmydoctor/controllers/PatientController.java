package com.capg.bookmydoctor.controllers;

/*****************************************************************
 *         @author          Soumita Deb
 *         Description      It is an controller class for Patient
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

import com.capg.bookmydoctor.entities.Patient;
import com.capg.bookmydoctor.services.IPatientService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController	
@RequestMapping("/api/patient")
public class PatientController {

	@Autowired
	private IPatientService patientService;

	@PostMapping("/AddPatient")
	public Patient savePatient(@Valid @RequestBody Patient patient) {
		return patientService.addPatient(patient);
	}

	@DeleteMapping("/RemovePatientDetails/{id}")
	public void removePatient(@PathVariable("id") int patient) {
		patientService.removePatientDetails(patient);
	}

	@GetMapping("/GetAllPatient")
	public List<Patient> findAllPatient() {
		return patientService.getAllPatient();
	}

	@GetMapping("/GetPatientByID/{id}")
	public Patient findPatientById(@PathVariable("id") int patientId) {
		return patientService.getPatient(patientId);
	}

	@PutMapping("/EditPatientProfile") 
	public Patient updatePatient(@Valid @RequestBody Patient patient) {
		return patientService.editPatientProfile(patient);
	}

	@GetMapping("/GetPatientByName/{name}")
	public List<Patient> allPatientByName(@PathVariable("name") String name) {
		return patientService.getPatientByName(name);
	}

	@GetMapping("/GetPatientByBloodGroup/{bg}")
	public List<Patient> allPatientByBloodGroup(@PathVariable("bg") String bg) {
		return patientService.getPatientByBloodGroup(bg);
	}

	@GetMapping("/GetPatientByGender/{gender}")
	public List<Patient> allPatientByGender(@PathVariable("gender") String gender) {
		return patientService.getPatientByGender(gender);
	}

	@GetMapping("/GetPatientByAgeRange/{min}/{max}")
	public List<Patient> allPatientByBG(@PathVariable("min") int min, @PathVariable("max") int max) {
		return patientService.getPatientByAgeRange(min, max);
	}

	@GetMapping("/GetPatientIdByUserId/{id}") 
	public int getPatientByUserId(@PathVariable("id") int id) {
		return patientService.getPatientIdByUserId(id);
	}
}
