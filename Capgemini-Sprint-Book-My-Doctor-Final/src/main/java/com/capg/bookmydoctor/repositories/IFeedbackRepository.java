package com.capg.bookmydoctor.repositories;

/*****************************************************************
 *         @author          Ananya Sircar
 *         Description      It is a repository interface for Feedback
 *                          @Repository 
 *         Version          1.0
 *         Created On       24-July-2021
 ******************************************************************/

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.bookmydoctor.entities.Feedback;

@Repository
public interface IFeedbackRepository extends JpaRepository<Feedback, Serializable> {

}
