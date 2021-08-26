package com.capg.bookmydoctor.repositories;

/*****************************************************************
 *         @author          Soumita Deb
 *         Description      It is a repository interface for Appointment 
 *                          @Repository 
 *         Version          1.0
 *         Created On       23-July-2021
 ******************************************************************/

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.bookmydoctor.entities.Appointment;

@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment, Serializable> {

}
