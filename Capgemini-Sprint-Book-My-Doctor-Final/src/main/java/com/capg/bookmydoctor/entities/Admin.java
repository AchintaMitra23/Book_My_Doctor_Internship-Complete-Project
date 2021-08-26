package com.capg.bookmydoctor.entities;

/*****************************************************************
 *         @author          Supratim Das
 *         Description      It is an entity class for Admin
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
@Table(name = "admin_table")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int adminId;

	private String adminName;
	private long contactNumber;

	@OneToOne(targetEntity = User.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private User userId;

	// Constructor
	public Admin(String adminName, long contactNumber, User userId) {
		super();
		this.userId = userId;
		this.adminName = adminName;
		this.contactNumber = contactNumber;
		
	}
}
