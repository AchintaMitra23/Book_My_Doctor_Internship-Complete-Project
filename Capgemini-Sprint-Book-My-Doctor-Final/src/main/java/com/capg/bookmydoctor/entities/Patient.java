package com.capg.bookmydoctor.entities;

/*****************************************************************
 *         @author          Soumita Deb
 *         Description      It is an entity class for Patient
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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "patient_table")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int patientId;
	private String patientName;
	private long mobileNo;
	private String bloodGroup;
	private String gender;
	private int age;
	private String address;

	@OneToOne(targetEntity = User.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private User userId;

	// Constructor
	public Patient(String patientName, long mobileNo, String bloodGroup, String gender, int age, String address, User userId) {
		super();
		this.userId = userId;
		this.patientName = patientName;
		this.mobileNo = mobileNo;
		this.bloodGroup = bloodGroup;
		this.gender = gender;
		this.age = age;
		this.address = address;
	}
}
