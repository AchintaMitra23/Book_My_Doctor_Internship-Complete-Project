package com.capg.bookmydoctor.entities;

/*****************************************************************
 *         @author          Achinta Mitra
 *         Description      It is an entity class for User
 *                          @Entity 
 *         Version          1.0
 *         Created Date    	22-July-2021
 ******************************************************************/

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "user_table")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private String userName;
	private String emailID;
	private String password;
	private String role;
	private boolean isLoggedIn;

	// Constructor
	public User(String userName, String emailID, String password, String role) {
		super();	
		this.userName = userName;
		this.emailID = emailID;
		this.password = password;
		this.role = role;
		this.isLoggedIn = true;
	}

}
