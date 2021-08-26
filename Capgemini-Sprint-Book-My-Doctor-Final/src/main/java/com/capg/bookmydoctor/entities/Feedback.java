package com.capg.bookmydoctor.entities;

/*****************************************************************
 *         @author          Ananya Sircar
 *         Description      It is an entity class for Feedback
 *                          @Entity 
 *         Version          1.0
 *         Created Date    	22-July-2021
 ******************************************************************/

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "feedback_table")
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int feedbackId;

	private int rating;

	@OneToOne(targetEntity = Patient.class, cascade = CascadeType.DETACH)
	@JoinColumn(name = "patientId")
	private Patient patientId;

	@ManyToOne(targetEntity = Doctor.class, cascade = CascadeType.DETACH)
	@JoinColumn(name = "doctorId")
	private Doctor doctorId;

	private String feedbackComment;

	// Constructor
	public Feedback(int rating, Patient patientId, Doctor doctorId, String feedbackComment) {
		super();
		this.rating = rating;
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.feedbackComment = feedbackComment;
	}
}
