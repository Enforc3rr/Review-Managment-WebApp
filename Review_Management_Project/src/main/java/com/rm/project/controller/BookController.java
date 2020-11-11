package com.rm.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rm.project.entity.BookAddition;
import com.rm.project.entity.BookEntity;
import com.rm.project.entity.UserEntity;
import com.rm.project.repository.BookAddRepo;
import com.rm.project.repository.BookRepo;
import com.rm.project.repository.UserRepo;

@Controller
@RequestMapping("/book")
public class BookController {
	@Autowired
	BookRepo bookRepo;
	@Autowired
	UserRepo userRepo;
	@Autowired
	BookAddRepo bookAddRepo;
	
	@GetMapping("/addbook")
	public String addBook(Model model) {
		BookEntity bookEntity = new BookEntity();
		model.addAttribute("bookData", bookEntity);
		return "Book/addbook";
	}
	@PostMapping("/savebook")
	public String saveBook(BookEntity bookEntity , Authentication authentication) {
		bookEntity.setAddedBy(authentication.getName());
		bookRepo.save(bookEntity);
		BookAddition bookAddition = new BookAddition();
		
		
		bookAddition.setBookId(bookEntity.getBookid());
		
		UserEntity userEntity = userRepo.findByUserName(authentication.getName());
		bookAddition.setUserId(userEntity.getUserId());
		
		bookAddRepo.save(bookAddition);
		
		
		return "redirect:/";
	}
}
