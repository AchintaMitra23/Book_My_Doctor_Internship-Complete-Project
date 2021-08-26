package com.capg.bookmydoctor.services;

/*****************************************************************
 *         @author          Indrajit Singh 
 *         Description      It is a service class for Doctor
 *                          @Service 
 *         Version          1.0
 *         Created On       26-July-2021
 ******************************************************************/

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.bookmydoctor.entities.AvailabilityDates;
import com.capg.bookmydoctor.entities.Doctor;
import com.capg.bookmydoctor.exceptions.DoctorException;
import com.capg.bookmydoctor.repositories.IAvailabilityRepository;
import com.capg.bookmydoctor.repositories.IDoctorRepository;

@Service
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	public IDoctorRepository doctorRepo;
	@Autowired
	public IAvailabilityRepository arepo;

	public Doctor addDoctor(Doctor bean) {
		return doctorRepo.save(bean);
	}

	@Override
	public Doctor updateDoctorProfile(Doctor doctor) {
		Doctor doc = doctorRepo.findById(doctor.getDoctorId()).get();
		if (doc == null) {
			throw new DoctorException("Doctor with id : " + doctor.getDoctorId() + " is not found");
		} else {
			doc.setDoctorId(doctor.getDoctorId());
			doc.setDoctorName(doctor.getDoctorName());
			doc.setHospitalName(doctor.getHospitalName());
			doc.setLocation(doctor.getLocation());
			doc.setMobileNo(doctor.getMobileNo());
			doc.setSpeciality(doctor.getSpeciality());
			doc.setChargesPerVisit(doctor.getChargesPerVisit());
			return doctorRepo.save(doc);
		}
	}

	@Override
	public Doctor getDoctor(int id) {
		Optional<Doctor> list = doctorRepo.findById(id);
		if(list.isEmpty()) 		throw new DoctorException("Doctor with id : " + id + " is not found");
		else 					return list.get();
	}

	@Override
	public void removeDoctor(int id) {
		if (doctorRepo.findById(id) != null)
			doctorRepo.deleteById(id);
		else 
			throw new DoctorException("Doctor with id : " + id + " is not found");
	}

	@Override
	public List<Doctor> getDoctorList() {
		List<Doctor> list = doctorRepo.findAll();
		if(list.isEmpty()) 	throw new DoctorException("No Doctor are in the list");
		else 				return list;
	}

	@Override
	public List<Doctor> getDoctorBySpeciality(String speciality) {
		List<Doctor> list = doctorRepo.findBySpecialityIgnoreCase(speciality);
		if (list.isEmpty()) 	throw new DoctorException("Doctors are not available with the speciality : " + speciality);
		else 					return list;
	}

	@Override
	public AvailabilityDates addAvailability(AvailabilityDates bean) {
		return arepo.save(bean);
	}

	@Override
	public List<AvailabilityDates> showAvailability() {
		List<AvailabilityDates> list = arepo.findAll();
		if(list.isEmpty()) {
			throw new DoctorException("Dates are not available");
		}
		return list;
	}

	@Override
	public AvailabilityDates updateAvailability(AvailabilityDates bean) {
		AvailabilityDates ad = arepo.findById(bean.getAvailibityId()).get();
		if (ad == null) {
			throw new DoctorException("Doctor with dates id : " + bean.getAvailibityId() + " is not found");
		} else {
			ad.setDoctorId(bean.getDoctorId());
			ad.setEndDate(bean.getEndDate());
			ad.setFromDate(bean.getFromDate());
			return arepo.save(ad);
		}

	}

	@Override
	public void removeAvailability(int id) {
		if(arepo.findById(id).isEmpty()) {
			throw new DoctorException("Dates not available");
		}
		arepo.deleteById(id);
	}

	@Override
	public List<Doctor> getDoctorByLocation(String location) {
		List<Doctor> list = doctorRepo.findByLocationIgnoreCase(location);
		if (list.isEmpty()) {
			throw new DoctorException("Doctors are not available");
		}
		else return list;
	}

	@Override
	public List<Doctor> getDoctorByHospitalName(String hospital) {
		List<Doctor> list = doctorRepo.findByHospitalNameIgnoreCase(hospital);
		if (list.isEmpty()) {
			throw new DoctorException("Doctors are not available");
		}
		else return list;
	}

	@Override
	public List<Doctor> getDoctorByName(String name) {
		List<Doctor> list = doctorRepo.findByDoctorName(name);
		if (list.isEmpty()) {
			throw new DoctorException("Doctors are not available");
		}
		else return list;
	}

	@Override
	public List<Doctor> getDoctorWithInBudget(double min, double max) {
		List<Doctor> list = doctorRepo.findAll();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getChargesPerVisit()<=min || list.get(i).getChargesPerVisit()>=max) {
				list.remove(list.get(i));
			}
		}
		if (list.isEmpty()) {
			throw new DoctorException("Doctors Not Found with that range");
		} else {
			return list;
		}
	}

	@Override
	public int getDoctorIdByUserId(int id) {
		List<Doctor> doctorList = doctorRepo.findAll();
		int flag = 0;
		int ans = -1;
		for (int i = 0; i < doctorList.size(); i++) {
			if (doctorList.get(i).getUserId().getUserId() == id) {
				ans = doctorList.get(i).getDoctorId();
				flag = 1;
				break;
			}
		}
		if (flag == 0) {
			throw new DoctorException("No Doctor found with user id : " + id);
		} else {
			return ans;
		}
	}

}
