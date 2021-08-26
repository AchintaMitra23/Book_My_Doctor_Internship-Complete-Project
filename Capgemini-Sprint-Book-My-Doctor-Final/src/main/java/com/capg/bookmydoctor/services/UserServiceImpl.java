package com.capg.bookmydoctor.services;

/*****************************************************************
 *         @author          Achinta Mitra
 *         Description      It is a service class for User
 *                          @Service 
 *         Version          1.0
 *         Created On       26-July-2021
 ******************************************************************/

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.bookmydoctor.entities.User;
import com.capg.bookmydoctor.exceptions.UserException;
import com.capg.bookmydoctor.repositories.IUserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository userRepo;

	public boolean validateUser(User user) {
		// Password should be of 8 to 30 characters long and contains capital and small letters both
		String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,30}$";

		// UserName should be of 5 to 30 characters long and should starts with letters. 
		String usernameRegex = "^[A-Za-z]\\w{5,30}$";
		List<User> list = userRepo.findAll();
		int flag = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getEmailID().equals(user.getEmailID())) {
				flag = 1;
				break;
			}
		}
		if (flag == 0) {
			Pattern p = Pattern.compile(passwordRegex);
			Pattern p1 = Pattern.compile(usernameRegex);
			if((p.matcher(user.getPassword()).matches()) && (p1.matcher(user.getUserName()).matches())) return true;
			else return false;
		} else {
			return false;
		}
	}

	public boolean validateNameAndPassword(User user) {
		String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,30}$";
		String usernameRegex = "^[A-Za-z]\\w{5,30}$";

		Pattern p = Pattern.compile(passwordRegex);
		Pattern p1 = Pattern.compile(usernameRegex);
		if((p.matcher(user.getPassword()).matches()) && (p1.matcher(user.getUserName()).matches())) return true;
		else return false;
	}

	public User registerUser(User user) {
		if(validateUser(user)) 
			return userRepo.save(user);
		else 
			throw new UserException("Either Username or password is not valid OR User has already Registered");
	}

	public void removeUser(int id) {
		userRepo.deleteById(id);
	}

	public User updateUser(User user) {
		if (userRepo.findById(user.getUserId()).get() != null) {
			if(validateUser(user)) {
				User userDb = userRepo.findById(user.getUserId()).get();
				userDb.setUserId(user.getUserId());
				userDb.setUserName(user.getUserName());
				userDb.setEmailID(user.getEmailID());
				userDb.setPassword(user.getPassword());
				userDb.setRole(user.getRole());
				return userRepo.save(userDb);
			}
			else {
				throw new UserException("username or password not valid");
			}
		} else {
			throw new UserException("User not found with id " + user.getUserId());
		}

	}

	public List<User> getAll() {
		List<User> list = new ArrayList<User>();
		userRepo.findAll().forEach(list::add);
		return list;
	}

	public User fetchById(int id) {
		Optional<User> user = userRepo.findById(id);
		if(user.isEmpty())   	throw new UserException("User Not Found with id : " + id); 
		else 					return user.get();
	}

	public List<User> getByRole(String role) {
		List<User> list = userRepo.findByRole(role);
		if (list.isEmpty()) 	throw new UserException("User Not Found by role : " + role);
		else 					return list;
	}

	@Override
	public User loginUser(String email, String password) {
		List<User> list = userRepo.findAll();
		int flag = 0;
		User temp = null;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getEmailID().equals(email) && list.get(i).getPassword().equals(password)) {
				flag = 1;
				temp = list.get(i);
				list.get(i).setLoggedIn(true);
				userRepo.save(list.get(i));
				break;
			} 
		}
		return flag == 1 ? temp : null;
	}

	@Override
	public boolean logoutUser(int id) {
		User user = fetchById(id);
		if (user.isLoggedIn()) {
			user.setLoggedIn(false);
			userRepo.save(user);
			return true;	
		} else return false;
	}

	@Override
	public boolean isLogedIn(int id) {
		return userRepo.findById(id).get().isLoggedIn() ? true : false;
	}

	@Override
	public User updatePassword(String email, String password, String confirm) {
		List<User> list = userRepo.findAll();
		if (password.equals(confirm)) {
			User user = null;
			int flag = 0;
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getEmailID().equals(email)) {
					flag = 1;
					list.get(i).setPassword(password);
					user = list.get(i);
					userRepo.save(user);
					break;
				} 
			}
			return (flag == 1) ? user : null;
		} else return null;
	}

	@Override
	public User fetchUserIdByEmailAndPassword(String email, String password) {
		List<User> list = userRepo.findAll();
		int flag = 0;
		User id = null;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getEmailID().equals(email) && list.get(i).getPassword().equals(password)) {
				flag = 1;
				id = list.get(i);
				break;
			}
		}
		if (flag == 0) 	throw new UserException("User Id can't be fetched by Email and Password");
		else 			return id;
	}	

}
