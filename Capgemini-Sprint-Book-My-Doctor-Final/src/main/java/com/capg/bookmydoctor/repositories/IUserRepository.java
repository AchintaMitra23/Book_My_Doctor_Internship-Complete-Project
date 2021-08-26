package com.capg.bookmydoctor.repositories;

/*****************************************************************
 *         @author          Achinta Mitra
 *         Description      It is a repository interface for User
 *                          @Repository 
 *         Version          1.0
 *         Created On       23-July-2021
 ******************************************************************/

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.bookmydoctor.entities.User;

@Repository
public interface IUserRepository extends JpaRepository<User,Integer> {
	public List<User> findByRole(String role);
}
