package com.ReviewManagement.Project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ReviewManagement.Project.DAO.UserRepo;
import com.ReviewManagement.Project.Entitites.UserEntity;

@Controller
@RequestMapping("/admin")
public class Admin {
	@Autowired
	UserRepo UserRepo ;
	@GetMapping("/adminlogin")
	public String adminLogin() {
		return "Admin/AdminLogin";
	}
	
	@GetMapping("/viewUsers")
	public String viewUsers(Model model) {
		List<UserEntity> userEntity = UserRepo.findAll();
		model.addAttribute("userValue" , userEntity);
		return "Admin/viewUsers";
	}
	
}
