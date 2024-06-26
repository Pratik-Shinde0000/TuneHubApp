package com.tunehub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunehub.entities.Users;
import com.tunehub.repositories.UserRepository;

@Service
public class UsersServiceImplementation implements UsersService {
	@Autowired
	UserRepository repo;

	@Override
	public String addUser(Users user) {
		repo.save(user);
		return "User is created and Saved";
	}

	@Override
	public boolean emailExists(String email) 
	{
		if(repo.findByEmail(email)==null) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public boolean validateUser(String email, String password) {
		Users user =repo.findByEmail(email);
		String db_password=user.getPassword();
		if(db_password.equals(password)) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public String findRole(String email) {
		return repo.findByEmail(email).getRole();
		 
	}

	@Override
	public Users getUser(String email) {
		return repo.findByEmail(email);
	}

}
