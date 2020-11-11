package com.rm.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rm.project.entity.UserEntity;
import com.rm.project.repository.UserRepo;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserRepo userRepo;
	@Autowired
	BCryptPasswordEncoder bCrypt;
	
	@GetMapping("/signup")
	public String userSignup(Model model) {
		UserEntity userEntity = new UserEntity();
		
		model.addAttribute("userData", userEntity);
		
		return "User/signup";
		
	}
	@PostMapping("/save")
	public String userSave(UserEntity userEntity) {
		userEntity.setPassword(bCrypt.encode(userEntity.getPassword()));
		userRepo.save(userEntity);
		return "redirect:/";
	}
	
	@GetMapping("/login")
	public String userLogin(Model model) {
		
		return "User/login";
	}
	

}
