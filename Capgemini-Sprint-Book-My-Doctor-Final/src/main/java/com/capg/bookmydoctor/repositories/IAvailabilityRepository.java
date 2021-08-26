package com.capg.bookmydoctor.repositories;

/*****************************************************************
 *         @author          Indrajit Singh
 *         Description      It is a repository interface for AvailabilityDates
 *                          @Repository 
 *         Version          1.0
 *         Created On       24-July-2021
 ******************************************************************/

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.bookmydoctor.entities.AvailabilityDates;

@Repository
public interface IAvailabilityRepository extends JpaRepository<AvailabilityDates, Serializable> {

}
