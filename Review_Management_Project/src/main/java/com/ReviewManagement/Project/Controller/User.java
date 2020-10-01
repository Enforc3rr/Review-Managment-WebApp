package com.ReviewManagement.Project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ReviewManagement.Project.DAO.UserRepo;
import com.ReviewManagement.Project.Entitites.UserEntity;

@Controller
@RequestMapping("/user")
public class User {
	@Autowired
	UserRepo userRepo;
	
	@GetMapping("/userSignup")
	public String userSignup(Model model) {
		UserEntity userEntity = new UserEntity();
		model.addAttribute("userData", userEntity);
		return "userSignup";
	}
	@PostMapping("/saveUser")
	public String userSave(UserEntity userEntity){
		userRepo.save(userEntity);
		return "redirect:/";
	}
	@GetMapping("/login")
	public String userLogin() {
		return "Login/Login";
	}

}
