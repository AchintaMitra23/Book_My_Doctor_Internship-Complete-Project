package com.capg.bookmydoctor.services;

/*****************************************************************
 *         @author          Soumita Deb
 *         Description      It is a service class for Patient
 *                          @Service 
 *         Version          1.0
 *         Created On       26-July-2021
 ******************************************************************/

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.bookmydoctor.entities.Patient;
import com.capg.bookmydoctor.exceptions.PatientException;
import com.capg.bookmydoctor.repositories.IPatientRepository;

@Service
public class PatientServiceImpl implements IPatientService {

	@Autowired
	private IPatientRepository patientRepo;	

	@Override
	public Patient addPatient(Patient patient) {
		return patientRepo.save(patient);
	}

	@Override
	public void removePatientDetails(int id) {
		Optional<Patient> patientList = patientRepo.findById(id);
		if (patientList.isEmpty())   	
			throw new PatientException("Patient is not found");
		else
			patientRepo.deleteById(id);
	}

	@Override
	public List<Patient> getAllPatient() {
		Iterable<Patient> listPatient = patientRepo.findAll(); 
		return (List<Patient>)listPatient;
	}

	@Override
	public Patient getPatient(int id) {
		Optional<Patient> patientList = patientRepo.findById(id);
		if (patientList.isEmpty()) 
			throw new PatientException("Patient Not Found");
		else
			return patientList.get();
	}

	@Override
	public Patient editPatientProfile(Patient patient) {
		Patient patientList = patientRepo.findById(patient.getPatientId()).get();
		patientList.setPatientName(patient.getPatientName());
		patientList.setMobileNo(patient.getMobileNo());
		patientList.setBloodGroup(patient.getBloodGroup());
		patientList.setGender(patient.getGender());
		patientList.setAge(patient.getAge());
		patientList.setAddress(patient.getAddress());
		return patientRepo.save(patientList);
	}

	@Override
	public List<Patient> getPatientByName(String name) {
		List<Patient> list = patientRepo.findByPatientName(name);
		if (list.isEmpty()) {
			throw new PatientException("Patients are not available");
		}
		return list;
	}

	@Override
	public List<Patient> getPatientByGender(String gender) {
		List<Patient> list = patientRepo.findByGenderIgnoreCase(gender);
		if (list.isEmpty()) {
			throw new PatientException("Patients are not available");
		}
		return list;
	}

	@Override
	public List<Patient> getPatientByAgeRange(int min, int max) {
		List<Patient> list = patientRepo.findAll();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getAge()<=min || list.get(i).getAge()>=max) {
				list.remove(list.get(i));
			}
		}
		if (list.isEmpty()) {
			throw new PatientException("Patients Not Found with that range");
		} else {
			return list;
		}
	}

	@Override
	public List<Patient> getPatientByBloodGroup(String bg) {
		List<Patient> list = patientRepo.findByBloodGroupIgnoreCase(bg);
		if (list.isEmpty()) {
			throw new PatientException("Patients are not available");
		}
		return list;
	}

	@Override
	public int getPatientIdByUserId(int id) {
		List<Patient> patientList = patientRepo.findAll();
		int flag = 0;
		int ans = -1;
		for (int i = 0; i < patientList.size(); i++) {
			if (patientList.get(i).getUserId().getUserId() == id) {
				ans = patientList.get(i).getPatientId();
				flag = 1;
				break;
			}
		}
		if (flag == 0) {
			throw new PatientException("No Patient found");
		} else {
			return ans;
		}
	}

}
