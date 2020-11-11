package com.rm.project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rm.project.entity.BookEntity;
import com.rm.project.entity.ReviewsEntity;
import com.rm.project.entity.UserEntity;
import com.rm.project.repository.BookRepo;
import com.rm.project.repository.ReviewRepo;
import com.rm.project.repository.UserRepo;


@Controller
@RequestMapping("/review")
public class ReviewController {
	@Autowired 
	ReviewRepo reviewRepo;
	@Autowired
	BookRepo bookRepo;
	@Autowired
	UserRepo userRepo;
	private long idOfBook;
	
	@GetMapping("/addreview/{id}")
	public String addReview(@PathVariable long id , Model model) {
		this.idOfBook = id;
	
		 BookEntity bookDetails = bookRepo.findById(id);
		 String bookName = bookDetails.getBookName();
		 model.addAttribute("bookName", bookName);
		
		 ReviewsEntity reviewsEntity = new ReviewsEntity();
		 model.addAttribute("reviewData", reviewsEntity);
		
		return "Review/AddReview.html";
	}
	@PostMapping("/save")
	public String saveReview(ReviewsEntity reviewsEntity , Authentication authentication) {
		UserEntity userEntity = userRepo.findByUserName(authentication.getName());
		
		reviewsEntity.setReviewOfBookId(idOfBook);
		reviewsEntity.setReviewAddedByUserId(userEntity.getUserId());
		
		
		reviewRepo.save(reviewsEntity);
		
		return "redirect:/";
	}
	

}
