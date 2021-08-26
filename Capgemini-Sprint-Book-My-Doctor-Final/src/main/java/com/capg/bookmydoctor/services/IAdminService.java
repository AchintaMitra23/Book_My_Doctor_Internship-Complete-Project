package com.capg.bookmydoctor.services;

import java.util.List;

import com.capg.bookmydoctor.entities.Admin;


public interface IAdminService {
	
	public Admin addAdmin(Admin admin); 
	public Admin updateAdmin(Admin admin); 
	public void removeAdmin(int id); 
	public Admin viewAdmin(int id); 
	public List<Admin> getAdminByName(String name); 
	public List<Admin> getAllAdmins(); 
	public int getAdminIdByUserId(int id); 
	
}