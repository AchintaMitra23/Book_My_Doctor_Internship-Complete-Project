package com.capg.bookmydoctor.repositories;

/*****************************************************************
 *         @author          Soumita Deb
 *         Description      It is a repository interface for Patient
 *                          @Repository 
 *         Version          1.0
 *         Created On       23-July-2021
 ******************************************************************/

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.bookmydoctor.entities.Patient;

@Repository
public interface IPatientRepository extends JpaRepository<Patient, Serializable> {
	public List<Patient> findByPatientName(String name);
	public List<Patient> findByGenderIgnoreCase(String gender);
	public List<Patient> findByBloodGroupIgnoreCase(String gender);
}
