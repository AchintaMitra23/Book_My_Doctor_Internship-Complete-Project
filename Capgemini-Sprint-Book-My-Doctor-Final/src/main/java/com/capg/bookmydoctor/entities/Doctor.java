package com.capg.bookmydoctor.entities;

/*****************************************************************
 *         @author          Indrajit Singh
 *         Description      It is an entity class for Doctor
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
@Table(name = "doctor_table")
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int doctorId;
	private String doctorName;
	private String speciality;
	private String location;
	private String hospitalName;
	private long mobileNo;
	private double chargesPerVisit;

	@OneToOne(targetEntity = User.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private User userId;

	// Constructor
	public Doctor(String doctorName, String speciality, String location, String hospitalName, long mobileNo, double chargesPerVisit, User userId) {
		super();
		this.userId = userId;
		this.doctorName = doctorName;
		this.speciality = speciality;
		this.location = location;
		this.hospitalName = hospitalName;
		this.mobileNo = mobileNo;
		this.chargesPerVisit = chargesPerVisit;
	}
	
}
