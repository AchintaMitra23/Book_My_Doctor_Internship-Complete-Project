package com.capg.bookmydoctor.controllers;

/*****************************************************************
 *         @author          Indrajit Singh
 *         Description      It is an controller class for Doctor
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

import com.capg.bookmydoctor.entities.AvailabilityDates;
import com.capg.bookmydoctor.entities.Doctor;
import com.capg.bookmydoctor.services.IDoctorService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController	
@RequestMapping("/api/doctor")
public class DoctorController {

	@Autowired
	public IDoctorService doctorService;

	@PostMapping("/AddDoctor")
	public Doctor addDoctor(@Valid @RequestBody Doctor bean) {
		return doctorService.addDoctor(bean);
	}

	@GetMapping("/GetDoctorById/{id}")
	public Doctor getDoctor(@PathVariable("id") int id) {
		return doctorService.getDoctor(id);
	}

	@PutMapping("/UpdateDoctor")
	public Doctor updateDoctorProfile(@Valid @RequestBody Doctor bean) {
		return doctorService.updateDoctorProfile(bean);

	}

	@PostMapping("/AddDates")
	public AvailabilityDates addAvailability(@Valid @RequestBody AvailabilityDates bean) {
		return doctorService.addAvailability(bean);
	}

	@PutMapping("/DoctorAvailabilityDatesById")
	public AvailabilityDates updateAvailability(@Valid @RequestBody AvailabilityDates bean) {
		return doctorService.updateAvailability(bean);

	}

	@GetMapping("/GetAllDoctor")
	public List<Doctor> getDoctorList() {
		return doctorService.getDoctorList();
	}

	@GetMapping("/GetAllDates")
	public List<AvailabilityDates> getDates() {
		return doctorService.showAvailability();
	}

	@GetMapping("/GetAllDoctorsBySpecility/{speciality}")
	public List<Doctor> getDoctorBySpeciality(@PathVariable("speciality") String speciality) {
		return doctorService.getDoctorBySpeciality(speciality);
	}

	@GetMapping("/GetAllDoctorsByLocation/{location}")
	public List<Doctor> getDoctorByLocation(@PathVariable("location") String location) {
		return doctorService.getDoctorByLocation(location);
	}

	@GetMapping("/GetAllDoctorsByHospital/{hospital}")
	public List<Doctor> getDoctorByHospital(@PathVariable("hospital") String hospital) {
		return doctorService.getDoctorByHospitalName(hospital);
	}

	@GetMapping("/GetAllDoctorsByName/{name}")
	public List<Doctor> getDoctorByName(@PathVariable("name") String name) {
		return doctorService.getDoctorByName(name);
	}

	@GetMapping("/GetAllDoctorsByRange/{min}/{max}")
	public List<Doctor> getDoctorByName(@PathVariable("min") double min, @PathVariable("max") double max) {
		return doctorService.getDoctorWithInBudget(min, max);
	}

	@DeleteMapping("/RemoveDoctorById/{id}")
	public void removeDoctor(@PathVariable("id") int id) {
		doctorService.removeDoctor(id);
	}

	@DeleteMapping("/RemoveAvailability/{id}")
	public void removeDates(@PathVariable("id") int id) {
		doctorService.removeAvailability(id);
	}

	@GetMapping("/GetDoctorIdByUserId/{id}") 
	public int getDoctorByUserId(@PathVariable("id") int id) {
		return doctorService.getDoctorIdByUserId(id);
	}
}
