package com.capg.bookmydoctor.entities;

/*****************************************************************
 *         @author          Soumita Deb
 *         Description      It is an entity class for Appointment
 *                          @Entity 
 *         Version          1.0
 *         Created Date    	22-July-2021
 ******************************************************************/

import java.time.LocalDate;

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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "appointment_table")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int appointmentId;

	@OneToOne(targetEntity = Patient.class, cascade = CascadeType.DETACH)
	@JoinColumn(name = "patientId")
	private Patient patientId;

	@ManyToOne(targetEntity = Doctor.class, cascade = CascadeType.DETACH)
	@JoinColumn(name = "doctorId")
	private Doctor doctorId;

	private LocalDate appointmentDate;
	private String appointmentStatus;
	private String remark;

	// Constructor
	public Appointment(Patient patientId, Doctor doctorId, LocalDate appointmentDate, String appointmentStatus, String remark) {
		super();
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.appointmentDate = appointmentDate;
		this.appointmentStatus = "Ongoing";
		this.remark = "N/A";
	}
}
