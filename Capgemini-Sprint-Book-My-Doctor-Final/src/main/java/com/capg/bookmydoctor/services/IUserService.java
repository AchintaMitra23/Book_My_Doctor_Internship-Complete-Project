package com.capg.bookmydoctor.services;

import java.util.List;

import com.capg.bookmydoctor.entities.User;

public interface IUserService {
	
	public boolean validateUser(User user); 
	public boolean validateNameAndPassword(User user);
	public User registerUser(User user); 
	public User loginUser(String email, String password); 
	public boolean logoutUser(int id); 
	public boolean isLogedIn(int id); 
	public void removeUser(int id); 
	public User updateUser(User user); 
	public List<User> getAll(); 
	public User fetchById(int id); 
	public List<User> getByRole(String role); 
	public User updatePassword(String email, String password, String confirm); 
	public User fetchUserIdByEmailAndPassword(String email, String password); 
}
