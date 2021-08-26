package com.capg.bookmydoctor.repositories;

/*****************************************************************
 *         @author          Supratim Das
 *         Description      It is a repository interface for Admin
 *                          @Repository 
 *         Version          1.0
 *         Created On       24-July-2021
 ******************************************************************/

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.bookmydoctor.entities.Admin;

@Repository
public interface IAdminRepository extends JpaRepository<Admin,Serializable> {
	public List<Admin> findByAdminName(String name);
}
