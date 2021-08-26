package com.capg.bookmydoctor.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.bookmydoctor.entities.Admin;
import com.capg.bookmydoctor.exceptions.AdminException;
import com.capg.bookmydoctor.repositories.IAdminRepository;

@Service
public class AdminServiceImpl implements IAdminService{

	@Autowired
	private IAdminRepository adminRepo;

	@Override
	public Admin addAdmin(Admin admin) {
		return adminRepo.save(admin);
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		Admin admin1 = adminRepo.findById(admin.getAdminId()).get();
		if(admin1 == null) {
			throw new AdminException("Admin not found with id : " + admin.getAdminId());
		} else {
			admin1.setAdminId(admin.getAdminId());
			admin1.setAdminName(admin.getAdminName());
			admin1.setContactNumber(admin.getContactNumber());
			return adminRepo.save(admin1);
		}
	}

	@Override
	public void removeAdmin(int id) {
		if (adminRepo.findById(id) != null) 
			adminRepo.deleteById(id);
		else 
			throw new AdminException("Admin not found with id : " + id);
	}

	@Override
	public Admin viewAdmin(int id) {
		Optional<Admin> list = adminRepo.findById(id);
		if (list.isEmpty()) {
			throw new AdminException("Admin not found with id : " + id);
		}
		return list.get();
	}

	@Override
	public List<Admin> getAdminByName(String name) {
		List<Admin> list = adminRepo.findByAdminName(name);
		if (list.isEmpty()) {
			throw new AdminException("Admins not found with name : " + name);
		}
		return list;
	}

	@Override
	public List<Admin> getAllAdmins() {
		List<Admin> list = adminRepo.findAll();
		if (list.isEmpty()) throw new AdminException("Sorry there is no user in the admin table");
		else 				return list;
	}

	@Override
	public int getAdminIdByUserId(int id) {
		List<Admin> adminList = adminRepo.findAll();
		int flag = 0;
		int ans = -1;
		for (int i = 0; i < adminList.size(); i++) {
			if (adminList.get(i).getUserId().getUserId() == id) {
				ans = adminList.get(i).getAdminId();
				flag = 1;
				break;
			}
		}
		if (flag == 0) 	throw new AdminException("No Admin found with user id : " + id);
		else 			return ans;
	}
}
