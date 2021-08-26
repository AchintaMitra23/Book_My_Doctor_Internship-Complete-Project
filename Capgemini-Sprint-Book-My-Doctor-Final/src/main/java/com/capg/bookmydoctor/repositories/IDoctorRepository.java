package com.capg.bookmydoctor.repositories;

/*****************************************************************
 *         @author          Indrajit Singh
 *         Description      It is a repository interface for Doctor
 *                          @Repository 
 *         Version          1.0
 *         Created On       23-July-2021
 ******************************************************************/

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.bookmydoctor.entities.Doctor;

@Repository
public interface IDoctorRepository extends JpaRepository<Doctor, Serializable> {
	public List<Doctor> findByDoctorName(String name);
	public List<Doctor> findBySpecialityIgnoreCase(String speciality);
	public List<Doctor> findByLocationIgnoreCase(String location);
	public List<Doctor> findByHospitalNameIgnoreCase(String hospital);
}
