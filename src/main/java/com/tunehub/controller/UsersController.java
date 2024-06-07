package com.tunehub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.tunehub.entities.Users;
import com.tunehub.services.UsersService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UsersController {
	@Autowired
	UsersService userv;

	@PostMapping("/register")
	public String addUser(@ModelAttribute Users user) {
		boolean userStatus = userv.emailExists(user.getEmail());
		if (userStatus == false) {
			userv.addUser(user);
			System.out.println("User is added");
			return "/registersuccess";
		} else {
			System.out.println("User is already Exists!!");
			return "/registerfail";
		}

	}

	@PostMapping("/login")
	public String validateUser(@RequestParam String email, @RequestParam String password) {
		boolean loginStatus = userv.validateUser(email, password);
		if (loginStatus == true) {
		if(userv.findRole(email).equals("Admin")) {
			return "/adminhome";
		}
			else {
				return"/customerhome";
			}
		
		} else {
			return "login";
		}
	}
	@GetMapping("/exploreSongs")
	public String exploreSongs( String email) {
		Users user=userv.getUser(email);
		
		boolean userStatus = user.isPremium();
		if(userStatus==true) {
			return "displaysongs";
		}else {
			return "payment";
			
		}
	}
	

}
