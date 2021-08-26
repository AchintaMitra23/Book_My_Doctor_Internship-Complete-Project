package com.capg.bookmydoctor.entities;

/*****************************************************************
 *         @author          Indrajit Singh
 *         Description      It is an entity class for AvailabilityDates
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
@Table(name = "available_dates_table")
public class AvailabilityDates {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int availibityId;

	@OneToOne(targetEntity = Doctor.class, cascade = CascadeType.DETACH)
	@JoinColumn(name = "doctorId")
	private Doctor doctorId;

	private LocalDate fromDate;
	private LocalDate endDate;

	// Constructor
	public AvailabilityDates(Doctor doctorId, LocalDate fromDate, LocalDate endDate) {
		super();
		this.doctorId = doctorId;
		this.fromDate = fromDate;
		this.endDate = endDate;
	}

}
